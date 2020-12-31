package sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import sample.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoardList() throws Exception;

}
