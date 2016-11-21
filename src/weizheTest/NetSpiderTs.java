package weizheTest;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetSpiderTs {

	/**
	 * @author weizhe
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String regex = "\\w+@\\w+(\\.\\w+)+";
		
		List<String> list = getmail(regex);
		for(String mail:list){
			System.out.println(mail);
		}

	}

	public static List<String> getmail(String regex) throws Exception {
	    String str = "http://tieba.baidu.com/p/2453190594";
	    
	    URL url = new URL(str);
	    
	    URLConnection conn = url.openConnection();
	    
	    //获取读取流
	    InputStream in = conn.getInputStream();
	    //读取操作
	    BufferedReader buff = new BufferedReader(new InputStreamReader(in));
	    
	    String line = null;
	    
	    //获取功能
	    Pattern p = Pattern.compile(regex);
	    
	    List<String> list = new ArrayList<>();
	    
	    while((line=buff.readLine()) != null){
	    	Matcher m = p.matcher(line);
	    	while(m.find()){
	    		list.add(m.group());
	    	}
	    }
	    buff.close();
		return list;
	}

	

}
