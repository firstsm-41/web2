package main.java.com.ssg.todo.controller;


import lombok.extern.log4j.Log4j2;
import main.java.com.ssg.todo.dto.TodoDTO;
import main.java.com.ssg.todo.service.TodoServiceMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
@Log4j2

public class TodoListController extends HttpServlet {

    private TodoServiceMapper todoServiceMapper = TodoServiceMapper.INSTANCE;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<TodoDTO> dtoList = todoServiceMapper.listAll();
            req.setAttribute("dtolist", dtoList);
            req.getRequestDispatcher("/todo/todolist.jsp").forward(req,resp);



        } catch (Exception e) {
            throw new ServletException(e);
        }

    }


}
