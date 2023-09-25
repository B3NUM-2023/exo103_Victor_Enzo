<%@ page import="web.Bag" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.lang.reflect.Array" %>
<%
    Bag userBag = (Bag) request.getAttribute("userBag");
    PrintWriter print = response.getWriter();
    response.setContentType("text/html");
%>
<html>
    <head>

    </head>
    <body>
        <%
            if(userBag != null){
            print.write("<h1>SAC :</h1>");
            userBag.print(print);
        }else {
                print.write("Panier vide");
            }
        %>
        <form method="post" action="/exo103/bag">
            <h2>Reference</h2>
            Reference <input name="ref" placeholder="Entrez la reference">
            <h2>Quantite</h2>
            Quantite <input name="qty" placeholder="Entrez la quantite">
            <input type= "submit" value= Confirmer>
        </form>
    </body>
</html>