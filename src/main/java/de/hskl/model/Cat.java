package de.hskl.model;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cat implements Serializable {

	private static final long serialVersionUID = 6547399357279103833L;
	public String name;
	public int age;
	public Color color;
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeUTF("Meow");
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		System.out.println("The cat says: "+ois.readUTF());
	}
}