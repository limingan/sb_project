package com.poic.dayday;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	/**
	 * 序列化
	 * @param object
	 * @return
	 */
	public byte[] serialize(Object object) {
		byte[] result = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
			result = bos.toByteArray();
			oos.flush();
			oos.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Object deSerialize(byte[] buf) {
		Object object = null;
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		try {
			ObjectInputStream ois = new ObjectInputStream(bis);
			object = ois.readObject();
			ois.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return object;
	}
}
