package com.biz.board;

import java.util.ArrayList;

public interface BoardService {

	public int serviceInsert(BoardVO boardVO) throws Exception; // re-throws

	public BoardVO serviceSelect(int bseq);
	public ArrayList<BoardVO> selectAll();
	public ArrayList<BoardVO> brList();
	
	public int serviceUpdate(BoardVO boardVO);
	public int serviceDelete(int bseq);
	
	public ArrayList<BoardReplyVO> replyList(int bseq);
	public int replyInsert(BoardReplyVO boardReplyVO);
	public int replyDelete(int rseq);
	public int replyUpdate(BoardReplyVO boardReplyVO);
	
	
}
