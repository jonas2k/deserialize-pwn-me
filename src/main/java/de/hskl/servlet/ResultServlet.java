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

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

	private static final long serialVersionUID = 4569228537485654918L;

	public ResultServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String input = request.getParameter("input");

		if (input == null || input.length() == 0 || !Base64.isBase64(input.getBytes())) {
			request.setAttribute("message", "Error: Input empty or not base64 encoded!");
		} else {

			byte[] data = Base64.decodeBase64(input);
			String exception = "";
			Object object = null;

			try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {

				object = ois.readObject();
				ois.close();

			} catch (Exception e) {
				exception = e.getMessage();
				e.printStackTrace();
			}

			request.setAttribute("message", "Success: Input got deserialized!\n Object is: " + object);
			request.setAttribute("exception", exception);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
