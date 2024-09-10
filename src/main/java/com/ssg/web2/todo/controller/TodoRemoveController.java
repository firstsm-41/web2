package main.java.com.ssg.todo.controller;


import lombok.extern.log4j.Log4j2;
import main.java.com.ssg.todo.service.TodoService;
import main.java.com.ssg.todo.service.TodoServiceMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoRemoveController", value = "/todo/remove")
@Log4j2
public class TodoRemoveController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));
        log.info(tno);

        todoService.remove(tno);




        try {
            todoService.remove(tno);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        resp.sendRedirect("/todo/list");
    }
}
