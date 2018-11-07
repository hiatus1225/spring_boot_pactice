package com.biz.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.biz.vo.CartVO;

@Repository
public interface CartMapper {

	public ArrayList<CartVO> selectAll(String regid);
	public CartVO select(@Param("cseq")int cseq, @Param("regid")String regid);
	
}
