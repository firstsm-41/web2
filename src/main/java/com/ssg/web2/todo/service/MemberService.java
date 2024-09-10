package com.ssg.web2.todo.service;

import com.ssg.web2.todo.dao.TodoDAO;
import com.ssg.web2.todo.domain.TodoVO;
import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.util.ModelUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();   // 직접 dao 주입
        modelMapper = ModelUtil.INSTANCE.get();
    }

    public void register(TodoDTO dto) throws Exception {
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        log.info(vo);
        dao.insert(vo);      // int 반환하므로 예외처리는 후에 진행
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAllList();
        log.info(".................");
        log.info(voList);

        return voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
    }

    public TodoDTO get(Long tno) throws Exception {
        log.info("tno = " + tno);
        TodoVO todoVO = dao.selectOne(tno);
        return modelMapper.map(todoVO, TodoDTO.class);
    }

    public void remove(Long tno) throws Exception {
        log.info(tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO  : " + todoDTO);
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(vo);
    }
}