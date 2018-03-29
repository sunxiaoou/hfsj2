package com.xo.beerV1;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BeerSelect extends HttpServlet {
    @Inject BeerExpert be;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice<br>");
        String c = request.getParameter("color");

        /*
        for (String brand : be.getBrands(c)) {
            out.print("<br>try: " + brand);
        }
        */

        request.setAttribute("styles", be.getBrands(c));
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}