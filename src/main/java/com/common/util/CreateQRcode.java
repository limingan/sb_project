package com.common.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.qrcode.encoder.QRCode;


public class CreateQRcode {
	
//	public static void createcode() throws IOException{
//		QRCode x=new QRCode();
//		x.setQrcodeErrorCorrect('M');//纠错等级
//	    x.setQrcodeEncodeMode('B');//N 代表数据; A 代表a-A; B 代表其他字符
//	    x.setQrcodeVersion(7);//版本
//	    
//	    String qrData = "http://www.baidu.com";
//	    
//	    int width = 67 + 12*(7-1);
//	    int height = 67 + 12*(7-1);
//	    //int width = 300;
//	    //int height = 300;
//	    int pixoff = 2;//偏移量
//	    
//	    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//	    
//	    Graphics2D gs = bufferedImage.createGraphics();
//	    gs.setBackground(Color.WHITE);
//	    gs.setColor(Color.BLACK);
//	    gs.clearRect(0, 0, width, height);
//	    
//	    byte[] d =qrData.getBytes("utf-8");
//	    if (d.length>0 && d.length <120){
//	        boolean[][] s = x.calQrcode(d);
//	
//	        for (int i=0;i<s.length;i++){
//	        for (int j=0;j<s.length;j++){
//	            if (s[j][i]) {
//	            gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);
//	            }
//	        }
//	        }
//	    }
//	    
//	    gs.dispose();
//	    bufferedImage.flush();
//	
//	    ImageIO.write(bufferedImage, "jpg", new File("D:/qrcode.jpg"));
//	}
}
