package main.java.com.ssg.todo.controller;


import lombok.extern.log4j.Log4j2;
import main.java.com.ssg.todo.dto.TodoDTO;
import main.java.com.ssg.todo.service.TodoService;
import main.java.com.ssg.todo.service.TodoServiceMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {


    private TodoServiceMapper todoServiceMapper = TodoServiceMapper.INSTANCE;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Long tno = Long.parseLong(req.getParameter("tno"));
        try {

            TodoDTO todoDTO = todoServiceMapper.get(tno);
            req.setAttribute("dto", todoDTO);
            req.getRequestDispatcher("/todo/read.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
