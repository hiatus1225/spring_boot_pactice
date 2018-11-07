//package com.kosmo.url;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.google.gson.Gson;
//import com.biz.board.OracleConnector;
//import com.biz.board.BoardReplyDAO;
//import com.biz.board.BoardReplyVO;
//import com.biz.board.BoardService;
//
//@Controller
//public class RestControllerTest {
//	
//	@Autowired
//	private BoardService boardService;
//	@Autowired
//	private BoardReplyDAO boardReplyDAO;
//	
////	gson pase
//	@RequestMapping(value = "/gson_test", method = RequestMethod.POST)
//	public void gson_test(HttpServletRequest request, HttpServletResponse response) {
//		
//		String bseqStr = request.getParameter("bseq");
//		int bseq = 0;
//		if(bseqStr != null || !bseqStr.equals("")) {
//			bseq = Integer.parseInt(bseqStr);
//		}
//		ArrayList<BoardReplyVO> rlist = boardService.replyList(bseq);
//		//json		
//		Gson gson = new Gson(); // Or use new GsonBuilder().create();
//		String gsonStr = gson.toJson(rlist); // serializes target to Json 
//		
//		
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.println(gsonStr);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@RequestMapping(value = "/response_body", method = RequestMethod.POST)
//	@ResponseBody
//	public ArrayList<BoardReplyVO> response_body(HttpServletRequest request, HttpServletResponse response) {
////	public ResponseEntity<ArrayList<BoardReplyVO>> response_body(HttpServletRequest request, HttpServletResponse response) {
//		
//		String bseqStr = request.getParameter("bseq");
//		int bseq = 0;
//		if(bseqStr != null || !bseqStr.equals("")) {
//			bseq = Integer.parseInt(bseqStr);
//		}
//		ArrayList<BoardReplyVO> rlist = boardService.replyList(bseq);
//		return rlist;
////		return new ResponseEntity<ArrayList<BoardReplyVO>>(rlist,HttpStatus.OK);
//		
//	}
//}
