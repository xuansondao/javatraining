package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value = "/html", name = "html-servlet")
@ServletSecurity(@HttpConstraint(
		transportGuarantee =TransportGuarantee.CONFIDENTIAL,
		rolesAllowed = {"read"}
))
public class HtmlPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.println("<html><head><title>Welcome to our website!</title></head>");
		writer.println("<body><h1> Student</h1>");
		writer.println("<table border = \"" + 1 + "\">\n<tr>\n <td>#</td>\n<td>Name</td>\n</tr>");
		writer.println("\n<tr>\n <td>1</td>\n<td>Dao Xuan Son</td>\n</tr>");
		writer.println("\n<tr>\n <td>2</td>\n<td>Le Cong Vu</td>\n</tr>");
		writer.println("\n<tr>\n <td>3</td>\n<td>Nguyen Thi Hoa Hau</td>\n</tr>\n</table>");
		writer.println("</body>");
		writer.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
