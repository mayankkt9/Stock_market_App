import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonData {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      String a1=jsonText.substring(5,jsonText.length()-2);
      //System.out.println(a1);
      JSONObject json = new JSONObject(a1);
      return json;
    } finally {
      is.close();
    }
  }
  
  public double returnCurrentPrice(String url) throws IOException, JSONException
  {
	  //System.out.println("this"+url);
	  
	  JSONObject json = readJsonFromUrl(url);
	  System.out.println(url);
	  MakeUrl obj=new MakeUrl();
	  System.out.println(json.get("l").toString());
	  double price=obj.getTrimPrice(json.get("l").toString());
	  System.out.println(price);
	   return price;
	    
  }
  

  public static void main(String[] args) throws IOException, JSONException {
	  
	  
	  
    JSONObject json = readJsonFromUrl("https://www.google.com/finance/info?q=NSE%3aGRASIM");
    //System.out.println(json.toString());
    System.out.println(json.get("l"));
  }
}