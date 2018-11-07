package com.biz.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.BoardMapper;
import com.biz.service.BoardService;
import com.biz.vo.BoardReplyVO;
import com.biz.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper dao;
	
//	@Autowired
//	private BoardReplyMapper rdao;
	
	@Override
	public int svcInsert(BoardVO vo) throws Exception {
		int res = 0;
		try { 
//			dao.insert(vo);
//			dao.insert(vo);
//			res = 10/0;
//			dao.insert(vo);
			res = dao.insert(vo);
		} catch(Exception e) {	
			System.out.println("service 잡았어..SMS.log.");
			throw new Exception();
		}
		return res;
	}
    
	@Override
	public ArrayList<BoardVO> svcList() {
		System.out.println("servce .....");
		return dao.selectAll();
//		ArrayList<BoardVO> list = dao.select();
//		return list;
	}
	
	@Override
	public ArrayList<BoardVO> svcBRList() {
		return dao.brlist();
	}


	@Override
	public BoardVO svcSelect(int bseq) {
		System.out.println("servce .....");
		return dao.view(bseq);
//		BoardVO vo = dao.select(bseq);
//		return vo;
		
	}

	@Override
	public int svcUpdate(BoardVO bvo) {
		return dao.update(bvo);
	}

	@Override
	public int svcDelete(BoardVO bvo) {
		return dao.delete(bvo);
	}

	@Override
	public int svcReplyInsert(BoardReplyVO rvo) {
		return dao.rinsert(rvo);
	}

	@Override
	public ArrayList<BoardReplyVO> svcReplyList(int bseq) {
		return dao.rselect(bseq);
	}

	@Override
	public int svcReplyDelete(int rseq) {
		return dao.rdelete(rseq);
	}

	
}
