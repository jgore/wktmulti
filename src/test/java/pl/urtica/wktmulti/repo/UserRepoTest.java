package pl.urtica.wktmulti.repo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.urtica.wktmulti.entity.User;

import java.util.Random;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Before
    public void setUp() {
       // userRepo.deleteAll();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateUsers() {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            User user = User.builder()
                    .userId(String.valueOf(i))
                    .firstName("fname" + random.nextInt(1000))
                    .lastName("lname" + random.nextInt(1000))
                    .build();

            userRepo.save(user);
        }

    }
}