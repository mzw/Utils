package jp.mzw.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileUtils {

	/**
	 * 
	 * @param dir
	 * @param filename
	 * @param content
	 * @throws IOException
	 */
	public static void write(String dir, String filename, String content) throws IOException {
		File file = new File(dir, filename);
		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.close();
	}
	
	/**
	 * Retrieves target document via local host
	 * @param filename is a file path of target document
	 * @return Target document
	 */
	public static String cat(String filename) {
		String src = "";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String tmp_str = "";
			while((tmp_str = br.readLine()) != null) {
				src += tmp_str + "\n";
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}	
		return src;
	}

	/**
	 * Retrieves target document via local host
	 * @param dir 
	 * @param filename is a file path of target document
	 * @return Target document
	 */
	public static String cat(String dir, String filename) {
		String src = "";
		try {
			File file = new File(dir, filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String tmp_str = "";
			while((tmp_str = br.readLine()) != null) {
				src += tmp_str + "\n";
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}	
		return src;
	}
	
	/**
	 * Retrieves lines which matches given regular expression
	 * @param content is a text which may contains the lines 
	 * @param regex is the regular expression
	 * @return Matched lines
	 */
	public static ArrayList<String> grep(String content, String regex) {
		ArrayList<String> ret = new ArrayList<String>();
		
		String tmp_line = "";
		for(int i = 0; i < content.length(); i++) {
			int n = content.indexOf('\n');
			if(n != -1) {
				tmp_line = content.substring(0, n);
				content = content.substring(n+1, content.length()-1);
				if(tmp_line.matches(regex)) {
					ret.add(tmp_line);
				}
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @param dir
	 * @param objName
	 * @param obj
	 * @throws IOException
	 */
	public static void serialize(String dir, String objName, Object obj) throws IOException {
		File file = new File(dir, objName);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(obj);
		oos.close();
	}

	/**
	 * 
	 * @param dir
	 * @param objName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Object deserialize(String dir, String objName) throws ClassNotFoundException, IOException {
		File file = new File(dir, objName);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
			
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}
