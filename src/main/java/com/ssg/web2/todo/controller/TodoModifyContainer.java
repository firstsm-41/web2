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
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoModifyContainer", value = "/todo/modify")
@Log4j2
public class TodoModifyContainer extends HttpServlet {


    private TodoServiceMapper todoServiceMapper = TodoServiceMapper.INSTANCE;
    private final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));

        try {
            TodoDTO dto = todoServiceMapper.get(tno);

            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/todo/modify.jsp").forward(req, resp);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String finishedstr = req.getParameter("tno");

        TodoDTO dto = TodoDTO.builder().
                tno(Long.parseLong(req.getParameter(tno)))

    }
}
