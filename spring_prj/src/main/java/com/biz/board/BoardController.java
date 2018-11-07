package com.biz.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.biz.board.BoardVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	
	
	@RequestMapping(value = "/filedown/{fname:.+}", method=RequestMethod.GET)
	public void filedown(@PathVariable String fname, HttpServletResponse response) {
		String mimeType = "application/octet-stream";
		System.out.println("MIME type: " + mimeType);

		//modifies HTTP header response
		File downloadFile = new File("c:/uploads/"+fname);
		FileInputStream inStream = null;
		OutputStream outStream = null;
		try {
			inStream = new FileInputStream(downloadFile);
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			//send http response using output stream
			outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				outStream.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}
	
	
	
	@RequestMapping(value = "/list")
	public ModelAndView list() {
		System.out.println("list controller run.....");
		ModelAndView modelAndView = new ModelAndView();
		ArrayList<BoardVO> list = service.selectAll();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("board/board_list");
		
		return modelAndView;
		
	}
	
	
	@RequestMapping(value = "/brlist")
	public ModelAndView brlist() {
		System.out.println("brList Controller");
		ModelAndView modelAndView = new ModelAndView();
		ArrayList<BoardVO> list = service.brList();
		modelAndView.addObject("brlist", list);
		modelAndView.setViewName("board/brlist");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/boardWrite")
//	public String write(@RequestBody BoardVO boardVO) {
	public String write(@ModelAttribute BoardVO boardVO) {
		String filePath = "c:/uploads";
		MultipartFile file = boardVO.getUfile();
		String userid="kim";
		boardVO.setUserid(userid);
		boardVO.setUfileSize((int)file.getSize());
		boardVO.setUfilePath(filePath);
		boardVO.setUfileName(file.getOriginalFilename());
		boardVO.setUFILE_SYS_NAME(file.getOriginalFilename());
		File f = new File(filePath+"/"+file.getOriginalFilename());
		try {
			file.transferTo(f);
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
//			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println("컨트롤러 VO값"+boardVO.getTitle());
		try {
			int res = service.serviceInsert(boardVO);
		} catch (Exception e) {
			System.out.println("컨트롤에서 잡았음");
			e.printStackTrace();
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/view/{bseq}")
	public ModelAndView view(@PathVariable int bseq /*@RequestParam("bseq") int bseq*/) {
//	public ModelAndView view(@RequestParam(value="bseq", required=true, deaultValue="1") int bseq) {
//	public ModelAndView view(HttpServletRequest request) {
//		int bseq = Integer.parseInt(request.getParameter("bseq"));
		System.out.println("view controller run.....");
		BoardVO boardVO = service.serviceSelect(bseq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("select", boardVO);
		modelAndView.setViewName("board/board_view");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/boardInsert")
	public ModelAndView boardInsert() {
//		int bseq = Integer.parseInt(request.getParameter("bseq"));
		
		
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("bseq", bseq);
		modelAndView.setViewName("board/board_form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/boardUpdate")
	public ModelAndView boardUpdate(HttpServletRequest request) {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String updateTitle = request.getParameter("title");  
		String updateContents = request.getParameter("contents");  
		BoardVO boardVO = new BoardVO();
		boardVO.setBseq(bseq);
		boardVO.setTitle(updateTitle);
		boardVO.setContents(updateContents);
		int res=0;
		res=service.serviceUpdate(boardVO);
		
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("bseq", bseq);
		if(res<=0) {
			modelAndView.setViewName("redirect:/list");			
		}else {
			modelAndView.setViewName("redirect:/view/"+bseq);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/boardDelete")
	public ModelAndView boardDelete(HttpServletRequest request) {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		int res = 0;
		res=service.serviceDelete(bseq);
				
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("bseq", bseq);
		modelAndView.setViewName("redirect:/list");
		return modelAndView;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/replyselect")
	@ResponseBody 
	public ArrayList<BoardReplyVO> replyselect(HttpServletRequest request) {
		String bseqStr = request.getParameter("bseq");
		System.out.println("/replyselect"+bseqStr);
		int bseq = 0;
		if(bseqStr != null) {
			bseq = Integer.parseInt(bseqStr);
		}
		ArrayList<BoardReplyVO> rlist = service.replyList(bseq);
		return rlist;
//		return modelAndView;
	}
	
	@RequestMapping(value = "/replyinsert")
	public String replyinsert(HttpServletRequest request) {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String reply = request.getParameter("replyText");
		int res=0;
		System.out.println(bseq+"//"+reply);
		if(bseq<=0) {
			
		}else {
			BoardReplyVO boardReplyVO = new BoardReplyVO();
			boardReplyVO.setBseq(bseq);
			boardReplyVO.setReply(reply);
			boardReplyVO.setUserId("KoreanHacker");
			res = service.replyInsert(boardReplyVO);
		}
		
		if(res<=0) {
			return "redirect:/ERROR";
		}else{
			return "redirect:/replyselect?bseq="+bseq;
		}
	}
	
	@RequestMapping(value = "/replydelete")
	public String replydelete(HttpServletRequest request) {
		int rseq = Integer.parseInt(request.getParameter("rseq"));
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		int res=0;
		System.out.println(rseq);
		if(rseq<=0) {
			
		}else {
			res = service.replyDelete(rseq);
		}
		
		if(res<=0) {
			return "redirect:/ERROR";
		}else{
			return "redirect:/replyselect?bseq="+bseq;
		}
	}
	
	@RequestMapping(value = "/replyupdate")
	public String replyupdate(HttpServletRequest request) {
		int rseq = Integer.parseInt(request.getParameter("rseq"));
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String reply = request.getParameter("replyText");
		int res=0;
		System.out.println(rseq);
		if(rseq<=0) {
			
		}else {
			BoardReplyVO boardReplyVO = new BoardReplyVO();
			boardReplyVO.setBseq(bseq);
			boardReplyVO.setRseq(rseq);
			boardReplyVO.setReply(reply);
			res = service.replyUpdate(boardReplyVO);
		}
		
		if(res<=0) {
			return "redirect:/ERROR";
		}else{
			return "redirect:/replyselect?bseq="+bseq;
		}
	}
	
	
}
