package com.biz.vo;

import java.util.ArrayList;

public class CartVO {

	private int cseq;
	private String gcode;
	private String regid;
	private String regdate;
	private int amount;
	
	private ArrayList<GoodsVO> goodsList;

	
	

	public ArrayList<GoodsVO> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(ArrayList<GoodsVO> goodsList) {
		this.goodsList = goodsList;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
