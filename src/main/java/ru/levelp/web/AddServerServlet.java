package ru.levelp.web;

import ru.levelp.weld.AppServer;
import ru.levelp.weld.ApplicationServerDiscovered;
import ru.levelp.weld.ApplicationServerManager;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/add-server", loadOnStartup = 1)
public class AddServerServlet extends HttpServlet {

    @Inject
    private Event<ApplicationServerDiscovered> discovered;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add-server.html")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String hostPort = req.getParameter("hostPort");

        discovered.fire(new ApplicationServerDiscovered(new AppServer(title, hostPort)));

        resp.sendRedirect(req.getContextPath());
    }
}
