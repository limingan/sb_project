package com.common.util;

import java.io.File;
import java.io.IOException;

public class TestCode {

	public static void main(String[] args){
			zxing();
	}
	
	public static void qrcode() {
//		try {
//			CreateQRcode.createcode();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
    public static void zxing(){
        File logoFile = new File("D://qrcode/aa.jpg");
        File QrCodeFile = new File("D://qrcode/code1.jpg");
        String url = "https://www.baidu.com/";
        String note = "";
        ZXingCodeUtil.drawLogoQRCode(logoFile, QrCodeFile, url, note);
    }
}
