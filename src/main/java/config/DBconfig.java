package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBconfig {
	
	//dbの接続情報を取得
	public Map<String, String> getDBinfo() throws FileNotFoundException{
		
		//プロパティファイル場所を指定
		FileLocatio fileLocatio = new FileLocatio();
		String db_properties_file = fileLocatio.getFileLocatio();
		Properties db_info = new Properties();
		FileInputStream db_file_stream = new FileInputStream(db_properties_file);
		
		try {
			//プロパティファイル読み込む
			db_info.load(db_file_stream);
		} catch (IOException e) {
			System.out.println("`db設定ファイルが認識できません");
			e.printStackTrace();
		}
		
		//DBconfig.propertiesのキーから値を取得
		String db_url = db_info.getProperty("url");
		String db_user = db_info.getProperty("user");
		String db_pass = db_info.getProperty("password");
		
		//dbの接続情報をMapに格納
		Map<String, String> getDBinfoForMap = new HashMap();
		getDBinfoForMap.put("url", db_url);
		getDBinfoForMap.put("user", db_user);
		getDBinfoForMap.put("password", db_pass);
		
		//接続情報を返す
		return getDBinfoForMap;
	}

}
