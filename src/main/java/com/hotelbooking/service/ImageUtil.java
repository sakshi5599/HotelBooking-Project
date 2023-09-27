package com.hotelbooking.service;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtil {
	public static byte[]compressImage(byte[]data)
	{
		Deflater deflater=new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();
	
		
		ByteArrayOutputStream outputstream=new ByteArrayOutputStream(data.length);
				byte[]tmp=new byte[4*1024];
				
			
		while (!deflater.finished()) {
			int size=deflater.deflate(tmp);
		  outputstream.write(tmp,0,size);
		}	try {
		
			outputstream.close();
		}catch(Exception ignored) {
			
		}
		return outputstream.toByteArray();
	}
//============================================================================//
	public static byte[]decompressImage(byte[]data)
	{
		Inflater inflater=new Inflater();
		//inflater.setLevel(Deflater.BEST_COMPRESSION);
		inflater.setInput(data);
		//deflater.finish();
	
		
		ByteArrayOutputStream outputstream=new ByteArrayOutputStream(data.length);
				byte[]tmp=new byte[4*1024];
				try {	
				
		while (!inflater.finished()) {
			int count=inflater.inflate(tmp);
		  outputstream.write(tmp,0,count);
		}
	
			outputstream.close();
		}catch(Exception ignored) {
			
		}
		return outputstream.toByteArray();
	}

}
