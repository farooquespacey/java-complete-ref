package com.farooque.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;

public class InputStrMain {

	public static void main(String[] args) throws IOException {
		URL srcUrl = new java.net.URL("http://ec2-3-83-167-140.compute-1.amazonaws.com:8080/pentaho/plugin/data-access/api/datasource/analysis/catalog/NGDW");
		
		URLConnection uc = srcUrl.openConnection();
		
		String userpass = "admin" + ":" + "password";
	    String basicAuth = "Basic " + new java.lang.String(java.util.Base64.getEncoder().encode(userpass.getBytes()));
	    uc.setRequestProperty ("Authorization", basicAuth);

	    InputStream istream = uc.getInputStream();
	    
	    System.out.println((char)istream.read());
	    
//	    Path path = Path.class ("C:\\Host\\git\\package_mondrian\\connector\\dsa");
//	    OutputStream ostream = java.nio.file.Files.newOutputStream(Path."C:\\Host\\git\\package_mondrian\\connector\\new");
//	    	    byte buf[] = new byte[12];
//	    	    int numBytes;
//
//	    	    try {
//	    	        try {
//	    	            while ((numBytes = istream.read(buf, 0, 8192)) > 0) {
//	    	                ostream.write(buf, 0, numBytes);
//	    	            }
//	    	        } finally {
//	    	            ostream.close();
//	    	        }
//	    	    } finally {
//	    	        istream.close();
//	    	    }

	    
//		Path das = java.nio.file.Paths.get("C:\\Users\\OrionMDH\\Downloads\\Priority_Jira_Defects.xlsx");
		
	}

}
