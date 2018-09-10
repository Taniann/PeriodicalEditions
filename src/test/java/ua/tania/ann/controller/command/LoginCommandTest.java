package ua.tania.ann.controller.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.service.UserService;
import ua.tania.ann.utils.JspPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 10.09.2018.
 */

public class LoginCommandTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private User user;
    private LoginCommand loginCommand;

    @Before
    public void setUp() {
        loginCommand = new LoginCommand();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void whenUserIsNullThenRedirectToLoginPage() throws Exception {
        ResultPage expectedResult = new ResultPage(REDIRECT, JspPath.LOGIN_PAGE);
        user = null;

        ResultPage actualResult = loginCommand.execute(request, response);

        assertEquals(expectedResult, actualResult);
    }
}