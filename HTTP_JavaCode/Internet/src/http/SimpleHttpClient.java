/*
    This exercise uses Google Server as HTTP Server
    Send an HTTP GET request to Google.com to get the search result.
 */
package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class SimpleHttpClient {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        SimpleHttpClient http = new SimpleHttpClient();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://www.google.com/search?q=IoT";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + con.getResponseCode());
        System.out.println("Response Message : " + con.getResponseMessage());
        System.out.println("Content Type : " + con.getContentType());
        System.out.println("Content Length : " + con.getContentLength());

        if (con.getResponseMessage().equalsIgnoreCase("OK")) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        }

    }

}
