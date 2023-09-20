package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/bag")
public class BagServlet extends HttpServlet{

	Bag myBag = new Bag();

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		Bag userBag = (Bag) session.getAttribute("userBag");


		out.write("<html><body>");
		out.write("<form method=\"post\">");
		out.write("<h1>Reference</h1>");
		out.write("Reference <input name=\"ref\" placeholder=\"Entrez la reference\">");
		out.write("<h2>Quantite</h2>");
		out.write("Quantite <input name=\"qty\" placeholder=\"Entrez la quantite\">\n");
		out.write("<input type=\"submit\"value=\"Confirmer\">");
		out.write("</html></body>");

		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");

		if(ref == null || qty == null) throw new ServletException("Erreur 400 : quantite ou reference non rempli");
		else {
			RequestDispatcher rd = req.getRequestDispatcher("bag");
			rd.forward(req, res);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();

		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");

		if ( ref == null || qty == null ) throw new ServletException("error : 400");
		else{
			Bag userBag = (Bag) session.getAttribute("userBag");
			if(userBag == null){
				userBag = new Bag();
			}
			userBag.setItem(ref,Integer.parseInt(qty));
			out.print(userBag);
		}
	}
}