package ua.tania.ann.service;

import org.junit.Before;
import org.junit.Test;
import ua.tania.ann.model.dao.DAOFactory;
import ua.tania.ann.model.dao.UserDAO;
import ua.tania.ann.model.entity.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Таня on 10.09.2018.
 */
public class UserServiceTest {
    private static final String LOGIN = "login";


    private DAOFactory factory;
    private UserDAO userDAO;

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        factory = mock(DAOFactory.class);
        userDAO = mock(UserDAO.class);
        userService = UserService.getInstance();
        userService.setFactory(factory);

        when(factory.createUserDAO()).thenReturn(userDAO);

    }

    @Test
    public void whenLoginIsExistThenTrue() {
        User expectedUser = new User();
        expectedUser.setId(5);
        expectedUser.setLogin(LOGIN);
        when(userDAO.findByLogin(LOGIN)).thenReturn(expectedUser);

        User actualUser = userService.findByLogin(LOGIN);

        assertEquals(expectedUser, actualUser);

    }

}