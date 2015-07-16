package com.bankonet.Presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankonet.EJB.ClientService;
import com.bankonet.model.Client;


@WebServlet ("/Clients")
public class ClientWeb extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB public ClientService monService;
	
	/**
	 * Surcharge de la méhode DoGet.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("je suis dans le deGet");
		PrintWriter w = resp.getWriter();
		w.println("hello");
		List<Client> liste = monService.getNomClients();
		
		for (Client client : liste){
			w.println(client.getNom());
		}
	}

	/**
	 * Surcharge de la méthode doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("je suis dans le doPost");
		String nom = req.getParameter("nom");
		monService.createClient(nom);
		
	}
	
	/**
	 * Surcharge de la méthode doPut
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
			try	(BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream())))
			{
				String data = br.readLine();
				System.out.println(data);
			}
				
			System.out.println("je suis le doPut");
			//monService.updateClient(nom,modif);
		
	}
}
