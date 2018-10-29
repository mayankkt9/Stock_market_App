import java.io.IOException;

import org.json.JSONException;


public class MakeUrl {

	
	public double make(int index) throws IOException, JSONException
	{
		AllStock obj=new AllStock();
		String symbol=obj.stocksymbol.get(index);
		String url="https://www.google.com/finance/info?q=NSE%3a"+symbol;
		
		JsonData obj1=new JsonData();
		double price=obj1.returnCurrentPrice(url);
		
		
		
		return price;
		
	}
	
	public double getTrimPrice(String str)
	{
		int len=str.length();
		double price;
		StringBuilder sb=new StringBuilder(str);
		StringBuilder sb1;
		if(len>=7)
		{
			sb1=sb.deleteCharAt(len-7);
			price=Double.parseDouble(sb1.toString());
		}
		else
		{
			price=Double.parseDouble(str);
		}
		
		return price;
	}
	
}
