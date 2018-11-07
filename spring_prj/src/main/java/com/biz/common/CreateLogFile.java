package com.biz.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.rmi.server.Util;


public class CreateLogFile {
	
	private static final String FIRST_DIR = "c://log//";
	private static Date sysDate = null;
	private static String dateString = null;
	private static SimpleDateFormat ymd = null;
	private static SimpleDateFormat hms = null;
	private static String sysdate = null;
	private static String systime = null;
	private static String computerName = null;
    
        
	public CreateLogFile() {
		
	}
	
	public static void log(String log) throws IOException {
		
	        
		String stTime = getSysDate("time");
		String path = createDir();
		StringBuffer contents = createLog(log,stTime);
		createFile(path,contents);


	}
	
	private static StringBuffer createLog(String log, String stTime) {
		try {
			computerName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer bufLogMsg = new StringBuffer(); 
		bufLogMsg.append("time[");
		bufLogMsg.append(stTime);
		bufLogMsg.append("]::");             
		bufLogMsg.append("Name=["+computerName+"]::location=["+log+"]\r\n");
		return bufLogMsg;
	}
	
	private static String getSysDate(String type) {
		sysDate = new Date();
		dateString = sysDate.toString();
		ymd = new SimpleDateFormat("yyyy-MM-dd");
		hms = new SimpleDateFormat("HH:mm:ss");
		sysdate = ymd.format(sysDate);
		systime = hms.format(sysDate);
		if(type=="time"||type.equals("time")) {
			return systime;			
		}else if(type=="date"||type.equals("date")) {
			return sysdate;
		}else {
			return null;
		}
				
	}

	private static String createDir() {
		
		
		
		String path = FIRST_DIR+sysdate;
        File file = new File(path);
        String contents=null;
        
        //!표를 붙여주어 파일이 존재하지 않는 경우의 조건을 걸어줌
        if(!file.exists()){
            //디렉토리 생성 메서드
            file.mkdirs();
            System.out.println("created directory successfully!");         
            return path;
        }else {        	
        	return path;
        }
	}
	
	private static void createFile(String path, StringBuffer contents) {
		FileWriter writer = null;
        String fileName = path.substring(path.lastIndexOf("/")+1)+".log";
        StringBuffer message = contents;
        File files = new File(path,fileName);
        if(files.getPath().equals(fileName)) {
        	try {
        		// 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
        		
        		writer = new FileWriter(files, true);
        		writer.write(message.toString());
        		writer.flush();
        		System.out.println("preexistenceFile");
        	} catch(IOException e) {
        		e.printStackTrace();
        	} finally {
        		try {
        			if(writer != null) writer.close();
        		} catch(IOException e) {
        			e.printStackTrace();
        		}
        	}			
		}else {
			try {
        		// 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
        		
        		writer = new FileWriter(files, true);
        		writer.write(message.toString());
        		writer.flush();
        		System.out.println("newFile");
        	} catch(IOException e) {
        		e.printStackTrace();
        	} finally {
        		try {
        			if(writer != null) writer.close();
        		} catch(IOException e) {
        			e.printStackTrace();
        		}
        	}	
		}
	}
}
