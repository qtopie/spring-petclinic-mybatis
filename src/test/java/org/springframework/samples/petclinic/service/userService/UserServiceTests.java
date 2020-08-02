package org.springframework.samples.petclinic.service.userService;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore("User-Role need refactoring")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc, mysql")
public class UserServiceTests extends AbstractUserServiceTests {}
