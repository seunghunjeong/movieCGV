package com.example.domain;
import java.net.*;
import java.io.*;

	public class NaverAPI {

	 public static String search(String apiURL) {
		 
	 
	        String clientId = "9yU38FYd3UvYhDFlNgrP";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "RS3g7eDXG9";//애플리케이션 클라이언트 시크릿값";
	        try {
	            
	            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	            return response.toString();
	        } catch (Exception e) {
	            System.out.println(e);
	            return e.toString();
	        }
}
}