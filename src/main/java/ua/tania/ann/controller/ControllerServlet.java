package ua.tania.ann.controller;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.utils.ConfigurationManager;
import ua.tania.ann.utils.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Таня on 17.08.2018.
 */
public class ControllerServlet extends HttpServlet {
    RequestHelper requestHelper = RequestHelper.getInstance();

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "text/html;charset=utf-8";
    private static final String ERROR_MESSAGE = "errorMessage";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        try {
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
       // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
       // dispatcher.forward(request, response);
        response.sendRedirect(page);
    }
}
