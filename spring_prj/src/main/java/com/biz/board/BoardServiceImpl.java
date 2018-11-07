package com.biz.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	
	@Override
	public int serviceInsert(BoardVO boardVO) throws Exception {

		int res = 0;
		try {
			res=boardMapper.insert(boardVO);
		} catch (Exception e) {
			System.out.println("내가 먼저 잡아 동작취함.");
			throw new Exception();
		}
		return res;
	}
	
	
	@Override
	public ArrayList<BoardVO> selectAll() {
		System.out.println("serviceList run....");
		return boardMapper.selectAll();
	}


	@Override
	public BoardVO serviceSelect(int bseq) {
		System.out.println("serviceView run....");
		return boardMapper.view(bseq);
	}


	@Override
	public ArrayList<BoardReplyVO> replyList(int bseq) {
		return boardMapper.rselect(bseq);
	}


	@Override
	public int replyInsert(BoardReplyVO boardReplyVO) {
		return boardMapper.rinsert(boardReplyVO);
	}


	@Override
	public int serviceUpdate(BoardVO boardVO) {
		return boardMapper.update(boardVO);
	}


	@Override
	public int serviceDelete(int bseq) {
		return boardMapper.delete(bseq);
	}


	@Override
	public int replyDelete(int rseq) {
		return boardMapper.rdelete(rseq);
	}


	@Override
	public int replyUpdate(BoardReplyVO boardReplyVO) {
		return boardMapper.rupdate(boardReplyVO);
	}


	@Override
	public ArrayList<BoardVO> brList() {
		return boardMapper.brlist();
	}

}
