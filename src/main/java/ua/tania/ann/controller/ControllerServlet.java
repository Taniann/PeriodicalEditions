package ua.tania.ann.controller;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.ResultPage;
import ua.tania.ann.service.EditionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

import static ua.tania.ann.controller.command.ResultPage.RoutingType.FORWARD;
import static ua.tania.ann.controller.command.ResultPage.RoutingType.REDIRECT;

/**
 * Created by Таня on 17.08.2018.
 */
public class ControllerServlet extends HttpServlet {
    RequestHelper requestHelper = RequestHelper.getInstance();

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "text/html;charset=utf-8";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Override
    public void init() throws ServletException {
        super.init();
        Locale.setDefault(Locale.US);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResultPage page = null;
        try {
            HttpSession session = request.getSession(true);
            Command command = requestHelper.getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
          //  request.setAttribute(ERROR_MESSAGE,
          //          MessageManager.getInstance().getMessage(MessageManager.SERVLET_EXCEPTION));
          //  page = ConfigurationManager.getInstance().getConfig(ConfigurationManager.ERROR);
        } catch (IOException e) {
         //   request.setAttribute(ERROR_MESSAGE,
         //           MessageManager.getInstance().getMessage(MessageManager.IO_EXCEPTION));
         //   page = ConfigurationManager.getInstance().getConfig(ConfigurationManager.ERROR);
        } catch (Exception e) {
         //   request.setAttribute(ERROR_MESSAGE, MessageManager.getInstance().getMessage(MessageManager.EXCEPTION));
         //   page = ConfigurationManager.getInstance().getConfig(ConfigurationManager.ERROR);
        }
        response.setCharacterEncoding(CHARACTER_ENCODING);
        response.setContentType(CONTENT_TYPE);

        if (REDIRECT.equals(page.getRoutingType())) {
            response.sendRedirect(request.getContextPath() + page.getPage());
        } else if (FORWARD.equals(page.getRoutingType())) {
            getServletContext().getRequestDispatcher(page.getPage()).forward(request, response);
        }
    }
}
