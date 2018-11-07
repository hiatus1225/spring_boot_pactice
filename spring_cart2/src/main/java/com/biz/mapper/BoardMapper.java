package com.biz.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.biz.vo.BoardReplyVO;
import com.biz.vo.BoardVO;

@Repository(value="dao")
public interface BoardMapper {
	public ArrayList<BoardVO> brlist();
	public ArrayList<BoardVO> selectAll();
	public BoardVO view(int bseq);
	public int insert(BoardVO bvo);
	public int update(BoardVO bvo);
	public int delete(BoardVO bvo);
	
	public ArrayList<BoardReplyVO> rselect(int bseq);
	public int rinsert(BoardReplyVO rvo);
	public int rdelete(int rseq);
}
