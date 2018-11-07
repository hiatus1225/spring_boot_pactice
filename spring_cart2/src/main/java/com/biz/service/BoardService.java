package com.biz.service;

import java.util.ArrayList;

import com.biz.vo.BoardReplyVO;
import com.biz.vo.BoardVO;

public interface BoardService {
	public int svcInsert(BoardVO vo) throws Exception; //re-throwing
	public ArrayList<BoardVO> svcList();
	public ArrayList<BoardVO> svcBRList(); //resultMap
	
	public BoardVO svcSelect(int bseq);
	public int svcUpdate(BoardVO bvo);
	public int svcDelete(BoardVO bvo);
		
	public int svcReplyInsert(BoardReplyVO rvo);
	public ArrayList<BoardReplyVO> svcReplyList(int bseq);
	public int svcReplyDelete(int rseq);
	
	
}
