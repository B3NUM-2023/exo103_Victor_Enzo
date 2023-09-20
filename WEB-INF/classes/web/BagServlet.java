package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

// TODO: this class should extends something to be a usable servlet.
// TODO: add an annotation here to map your servlet on an URL.
@WebServlet("/bag")
public class BagServlet {
	
	Bag myBag = new Bag();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();

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
			RequestDispatcher rd = req.getRequestDispatcher("bag.jsp");
			rd.forward(req, res);
		}

	}


	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");

		if ( ref == null || qty == null ) throw new ServletException("error : 400");
		else{
			out.println("La reference est :"+ref +" et la quantité est de :"+qty);
		}
	}
	
	
	

}
