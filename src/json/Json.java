package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONObject;

public class Json {
	
	 public static JSONObject readTxtFile(String filePath){
		 JSONObject jsonObject = new JSONObject();  
	        try {
	                String encoding="GBK";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);//���ǵ������ʽ
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt = null;
	                    while((lineTxt = bufferedReader.readLine()) != null){
	                       String key = lineTxt.split("	")[0];
	                       String value = lineTxt.split("	")[1];
	                       jsonObject.put(key, value);
	                    }
	                    read.close();
	        }else{
	            System.out.println("�Ҳ���ָ�����ļ�");
	        }
	        } catch (Exception e) {
	            System.out.println("��ȡ�ļ����ݳ���");
	            e.printStackTrace();
	        }
	        return jsonObject;
	     
	    }
	
	public static void main(String[] args) {
		 String filePath = "E:\\11.txt";
//	      "res/";
		 JSONObject jsonObj = readTxtFile(filePath);
		 System.out.println(jsonObj.toString());
	}
}
