package de.hskl.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hskl.model.Cat;

@WebServlet("/deserialize")
public class DeserializeServlet extends HttpServlet {

	private static final long serialVersionUID = -3528551310732973719L;

	public DeserializeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(ObjectInputStream ois = new ObjectInputStream(request.getInputStream())) {
			
			Cat cat = (Cat) ois.readObject();
			PrintWriter printWriter = response.getWriter();
			
			printWriter.print("Name: "+cat.name+
					"\nAge: "+cat.age+
					"\nColor: "+cat.color.toString());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
