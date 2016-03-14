package scraperClaw;

import java.io.IOException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Parser {
	
	public static void title(String addr){
		Document doc = null;
		try {
			doc = Jsoup.connect(addr).get();
		} catch (IOException e) {
			System.err.println("Addres is empty!");
			e.printStackTrace();
			return;
		}
		String title = doc.title();
		System.out.println(title);
	}
		
	public static void summon(String addr){
		Document doc = null;
		try {
			doc = Jsoup.connect(addr).get();
		} catch (IOException e) {
			System.err.println("Addres is empty!");
			e.printStackTrace();
			return;
		}
		String title = doc.title();
		System.out.println(title);
		downloadCSV(addr);
	} 
	
	public static void downloadCSV(String addr){
		URL fileAddr = null;
		title(new String(addr+""));
		System.out.println(addr);
		try {
			fileAddr = new URL(addr + "&render=download");
		} catch (MalformedURLException e) {
			System.err.println("No link for downloading!");
			e.printStackTrace();
			return;
		}
		dwnld(fileAddr, addr);	
		System.out.println("Downloaded!");
	}
	
	public static void dwnld(URL fileAddr, String addr){
		try{
	         String fileName = "companylist.csv";
	         String website = addr + "&render=download";
	         
	         System.out.println("Downloading File From: " + website);
	         
	         URL url = new URL(website);
	         InputStream inputStream = url.openStream();
	         OutputStream outputStream = new FileOutputStream(fileName);
	         
	         byte[] buffer = new byte[2048];
	           
	         int length = 0;
	       
	         while ((length = inputStream.read(buffer)) != -1) {
	        //    System.out.println("Buffer Read of length: " + length);
	            outputStream.write(buffer, 0, length);
	         }
	         
	         inputStream.close();
	         outputStream.close();
	         
	      }catch(Exception e){
	         System.out.println("Exception: " + e.getMessage());
	      }
	}
}