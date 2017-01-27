package de.hskl.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -789670430012592030L;

	public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String input = request.getParameter("input");
				
		if (input == null) {
			request.setAttribute("error", "Error!");
		} else {
			
			byte[] data = Base64.decode(input);
			
			try {
				ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
				
				try {
					Object object = ois.readObject();
					request.setAttribute("success", "Success!");
					request.setAttribute("object", "Object info: "+object.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
