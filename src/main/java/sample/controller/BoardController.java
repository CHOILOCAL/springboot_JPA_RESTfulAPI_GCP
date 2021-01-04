package sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sample.dto.BoardDto;
import sample.service.BoardService;

import java.util.List;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 조회
    @RequestMapping("/board/openBoardList.do")
    public ModelAndView openBoardList() throws Exception {

        log.debug("openBoardList");

        ModelAndView mv = new ModelAndView("/board/boardList");

        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);

        return mv;
    }
    
    // 게시판 저장 화면
    @RequestMapping("/board/openBoardWrite.do")
    public String openBoardWrite() throws Exception {
        return "/board/boardWrite";
    }
    
    // 게시판 저장 기능
    @RequestMapping("/board/insertBoard.do")
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);
        return "redirect:/board/openBoardList.do";
    }
    
    // 게시글 상세 조회 기능
    @RequestMapping("/board/openBoardDetail.do")
    public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {

        ModelAndView mv = new ModelAndView("/board/boardDetail"); // template

        BoardDto board = boardService.selectBoardDetail(boardIdx);
        mv.addObject("board", board);

        return mv;
    }
    
    // 게시글 수정
    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board/openBoardList.do";
    }


    // 게시글 삭제
    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board/openBoardList.do";
    }



}
