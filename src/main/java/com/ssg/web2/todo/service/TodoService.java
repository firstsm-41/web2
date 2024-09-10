package main.java.com.ssg.todo.service;


import lombok.extern.log4j.Log4j2;
import main.java.com.ssg.todo.dao.TodoDAO;
import main.java.com.ssg.todo.domain.TodoVO;
import main.java.com.ssg.todo.dto.TodoDTO;

import java.util.List;

@Log4j2
public enum TodoService {
    INSTANCE;
    TodoDAO dao = new TodoDAO();

    //글 하나를 등록하는 기능
    public void register(TodoDTO dto) throws Exception {
        dao.insert(dto);
    }

    //
    public List<TodoVO> getList() throws Exception {
        List<TodoVO> todoDTOS = dao.selectAllList();

        return todoDTOS;
    }

    public void remove(Long tno) {
        
    }


//
//    public TodoDTO get(Long tno) throws Exception {
//
//        log.info("tno= " + tno);
//        TodoVO todoVO = dao.selectOne(tno);
//        TodoDTO dto = modelmapper.map(todoVO, TodoDTO.class);
//
//        return dto;
//    }
//
//
//
//    public void delete(Long tno) throws Exception {
//        log.info(tno);
//
//        TodoVO vo = modelMapper.map(todoDTO,TodoVO.class);
//
//        dao.deleteOne(tno);
//    }
//
//    public void modify(TodoDTO dto) throws Exception {
//
//        log.info("todoDTO : " + todoDTO);
//        TodoVO vo = modelMapper.map(todoDTO,TodoVO.class);
//        dao.updateOne(dto);
//    }
}
