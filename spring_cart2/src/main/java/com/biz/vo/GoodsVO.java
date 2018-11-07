package com.biz.vo;

import java.util.ArrayList;

public class GoodsVO {

	private String gcode;
	private String cateCode;
	private String gname;
	private int gprice;
	private String regid;
	private String regdate;
	private CategoriVO categori;
	
	
	private ArrayList<GoodsImgVO> goodsImgVOs;
	public ArrayList<GoodsImgVO> getGoodsImgVOs() {
		return goodsImgVOs;
	}
	public void setGoodsImgVOs(ArrayList<GoodsImgVO> goodsImgVOs) {
		this.goodsImgVOs = goodsImgVOs;
	}
	
	
	
	public CategoriVO getCategori() {
		return categori;
	}
	public void setCategori(CategoriVO categori) {
		this.categori = categori;
	}

	
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
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
