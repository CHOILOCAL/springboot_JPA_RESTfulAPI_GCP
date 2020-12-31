package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import sample.dto.BoardDto;
import sample.service.BoardService;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    public ModelAndView openBoardList() throws Exception {

        ModelAndView mv = new ModelAndView("/board/boardList");

        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);

        return mv;
    }
}