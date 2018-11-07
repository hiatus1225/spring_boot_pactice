package com.biz.board;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
		// 전체 소문자 : ctrl+shift+y
		// 전체 소문자 : ctrl+shift+x
		private int bseq;
		private String title;
		private String contents;
		private String userid;
		private String regdate;
		private int ufileSize;
		private String ufilePath;
		private String ufileName;
		private String ufile_sys_name;
		
		private ArrayList<BoardReplyVO> boardReplyVOList;
		
		private MultipartFile ufile;
		
		
		public MultipartFile getUfile() {
			return ufile;
		}
		public void setUfile(MultipartFile ufile) {
			this.ufile = ufile;
		}
		
		public ArrayList<BoardReplyVO> getBoardReplyVOList() {
			return boardReplyVOList;
		}
		public void setBoardReplyVOList(ArrayList<BoardReplyVO> boardReplyVOList) {
			this.boardReplyVOList = boardReplyVOList;
		}
		
		
		
		public String getUFILE_SYS_NAME() {
			return ufile_sys_name;
		}
		public void setUFILE_SYS_NAME(String uFILE_SYS_NAME) {
			ufile_sys_name = uFILE_SYS_NAME;
		}
		
		public int getBseq() {
			return bseq;
		}
		public void setBseq(int bseq) {
			this.bseq = bseq;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}
		public int getUfileSize() {
			return ufileSize;
		}
		public void setUfileSize(int ufileSize) {
			this.ufileSize = ufileSize;
		}
		public String getUfilePath() {
			return ufilePath;
		}
		public void setUfilePath(String ufilePath) {
			this.ufilePath = ufilePath;
		}
		public String getUfileName() {
			return ufileName;
		}
		public void setUfileName(String ufileName) {
			this.ufileName = ufileName;
		}
	
}
