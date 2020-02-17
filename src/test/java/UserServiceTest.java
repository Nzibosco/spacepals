import com.project2.spacepals.repositories.UserRepository;
import com.project2.spacepals.services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.mockito.Mockito.mock;

public class UserServiceTest {
private UserService sut;
private UserRepository mockRepo = mock(UserRepository.class);

@Rule
    public ExpectedException expectedException = ExpectedException.none();

@Rule
public Timeout globalTimeout = Timeout.seconds(5);

@Before
public void setUp(){
    sut = new UserService(mockRepo);
}

@After
public void tearDown(){
    sut = null;
}


public void testIsUserValid(){

}

public void testIsValidPassword(){

}

public void testIsValidPasswordForSpecialCharacters(){

}

}
