package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.Komentotehdas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoistaOstoskoristaServlet extends WebKauppaServlet {
    
    Komentotehdas komennot;
    
    public PoistaOstoskoristaServlet() {
        komennot = new Komentotehdas();
    }
             
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );

        komennot.ostoksenPoistoKorista(haeSessionOstoskori(request), tuoteId).suorita();

        naytaSivu("/Tuotelista", request, response);
    }
}