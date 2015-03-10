package jp.mzw.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtils {
	
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
