package com.biz.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.biz.board.BoardReplyVO;
import com.biz.board.BoardVO;


/**
 *  board_map : mapper namespace="com.biz.mapper.BoardMapper
 * @author kosmo09
 *
 */
@Repository(value="boardMapper")
public interface BoardMapper{
	
	public ArrayList<BoardVO> brlist();
	public ArrayList<BoardVO> selectAll() ;
	public BoardVO view(int bseq) ;
	public int insert(BoardVO boardVO);
	public int update(BoardVO boardVO);
	public int delete(int bseq) ;
//	-------------reply------------------------
	public ArrayList<BoardReplyVO> rselect(int bseq);
	public int rinsert(BoardReplyVO boardReplyVO) ;
	public int rupdate(BoardReplyVO boardReplyVO);
	public int rdelete(int bseq);
	
}
