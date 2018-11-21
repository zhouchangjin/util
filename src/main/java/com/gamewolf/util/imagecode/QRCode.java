package com.gamewolf.util.imagecode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {

	public static void main(String[] args) throws WriterException, IOException {
		String qrCodeText = "https://lixianghao.net/wxapp?RECYCLE=";
		String filePath = "c:/lixianghao.png";
		int size = 1024;
		String fileType = "png";
		File qrFile = new File(filePath);
		//BufferedImage bi=createQRImageWithLogoToBuffer("c:/logo.png", qrCodeText, size, fileType);
		int width=(int)8.27*600;
		int height=(int)11.69*600;
		System.out.println(width+" "+height);
		BufferedImage buffereImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D) buffereImage.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		for(int i=0;i<4;i++) {
			for(int j=0;j<6;j++) {
				Date t=new Date();
				String qrCodeTextI=qrCodeText+" "+t.getTime()+i+"_"+j;
				BufferedImage bi=createQRImageWithLogoToBuffer("c:/logo.png", qrCodeTextI, size, fileType);
				buffereImage.createGraphics().drawImage(bi, i*bi.getWidth(), j*bi.getHeight(), bi.getWidth(), bi.getHeight(), null);
			}
		}
		ImageIO.write(buffereImage, fileType, qrFile);
	
	}
	
	public static void createQRImageWithLogo(File qrFile,String logoPath,String qrCodeText,int size,String fileType) throws WriterException, IOException{
		FileInputStream fis=new FileInputStream(new File(logoPath));
		BufferedImage prevImage = ImageIO.read(fis);
		
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);
		
		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		graphics.drawImage(prevImage, matrixWidth*5/12, matrixWidth*5/12, matrixWidth/6, matrixWidth/6, null);
		ImageIO.write(image, fileType, qrFile);
	}

	public static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}
	
	public static BufferedImage createQRImageWithLogoToBuffer(String logoPath,String qrCodeText,int size,String fileType) throws WriterException, IOException {
		FileInputStream fis=new FileInputStream(new File(logoPath));
		BufferedImage prevImage = ImageIO.read(fis);
		
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);
		
		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		graphics.drawImage(prevImage, matrixWidth*5/12, matrixWidth*5/12, matrixWidth/6, matrixWidth/6, null);
		return image;
	}

}
