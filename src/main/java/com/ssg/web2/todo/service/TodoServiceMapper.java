package main.java.com.ssg.todo.service;


import lombok.extern.log4j.Log4j2;
import main.java.com.ssg.todo.dao.TodoDAO;
import main.java.com.ssg.todo.domain.TodoVO;
import main.java.com.ssg.todo.dto.TodoDTO;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoServiceMapper {
    INSTANCE;

    private TodoDAO dao;

    private ModelMapper modelMapper;

    TodoServiceMapper() {
        dao = new TodoDAO(); //직접 dao 주입
        modelMapper = ModelUtil.INSTANCE.get();
    }

    public void register(TodoDTO dto) throws Exception {
        TodoVO vo = modelMapper.map(dto, TodoVO.class);

        log.info(vo);
        dao.insert(vo);    //int를 반환하므로 예외처리도 진행예정
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAllList();
        log.info("..........................");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream().map(vo->modelMapper.map(vo,TodoDTO.class)).collect(Collectors.toList());
        return dtoList;

    }
}