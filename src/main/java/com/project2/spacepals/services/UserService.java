package com.project2.spacepals.services;

import com.project2.spacepals.entities.Role;
import com.project2.spacepals.entities.Users;
import com.project2.spacepals.exceptions.AuthenticationException;
import com.project2.spacepals.exceptions.BadRequestException;
import com.project2.spacepals.exceptions.ResourcePersistenceException;
import com.project2.spacepals.repositories.CrudRepositories;
import com.project2.spacepals.repositories.UserRepository;
import com.project2.spacepals.web.dtos.Credentials;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService  {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo){
        super();
        this.userRepo=repo;
    }

    @Transactional(readOnly = true)
    public List<Users> getAllUser(){
        return userRepo.findAll();
    }
    @Transactional(readOnly = true)
    public Users authenticate(Credentials creds){
        if(creds == null || creds.getEmail() == null || creds.getPassword() == null ||
        creds.getEmail().equals("") || creds.getPassword().equals(""))
        {throw new BadRequestException("Invalid credentials object provided!");
        }
        Users retrievedUser = userRepo.findUserByCredentials(creds);
        if(retrievedUser == null){
            throw new AuthenticationException();
        }
        return retrievedUser;
    }

    @Transactional
    public Users register(Users newUser){
        //validation?
        if(!isUserValid(newUser))throw new BadRequestException();

        if(userRepo.findUserByEmail(newUser.getEmail()) != null){
            throw new ResourcePersistenceException("The email entered is already in use!");
        }


        newUser.setRole(Role.BASIC_USER);
        return userRepo.save(newUser);
    }


    public boolean isValidPassword(String password){
        int maxlength = 50;
        int minlength = 7;

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

        Matcher matcher = pattern.matcher(password);

        if (matcher.matches() || password.length()<= minlength||password.length()>= maxlength) {

            return true;
        }
        return false;

    }

    public boolean isUserValid(Users user){
        if (user == null) return false;
        if (checkFLNameLength(user.getFirstName()) ) return false;
        if (checkFLNameLength(user.getLastName())) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("") || isValidPassword(user.getPassword())) return false;
        if(user.getEmail()== null || user.getEmail().trim().equals("")|| checkEmail(user.getEmail()))return false;
        return true;
    }

    public boolean checkEmail(String email){
        int maxLength =151;
        Pattern pattern = Pattern.compile("\\S+@\\S+\\.\\S+");
        Matcher matcher = pattern.matcher(email);

        if (email.length() >= maxLength || !matcher.matches()) {
            return true;
        } return false;
    }

    public boolean checkFLNameLength(String name){
        int maxLength =100;
        int minLength = 2;
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

        Matcher matcher = pattern.matcher(name);
        if(name ==  null || name.trim().equals("")){ return true;}
        if (!matcher.matches() || name.length()< minLength||name.length()> maxLength){return true;}

        return false;
    }
}
