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

import org.apache.commons.codec.binary.Base64;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -789670430012592030L;

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String input = request.getParameter("input");

		if (input == null || !Base64.isBase64(input.getBytes())) {
			request.setAttribute("error", "Error: Input empty or not base64 encoded!");
		} else {

			byte[] data = Base64.decodeBase64(input);

			try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
				
				Object object = ois.readObject();
				request.setAttribute("success", "Success!");
				request.setAttribute("object", "Object info: " + object.toString());
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
