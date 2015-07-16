package com.bankonet.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bankonet.model.Client;

@Stateless
public class ClientService {
	
	@PersistenceContext(unitName="jpa-tp") private EntityManager em;
		
	public ClientService(){
			
	}
	
	public List<Client> getNomClients(){
		
			String req1 = "Select c from Client as c";
			Query quer1 = this.em.createQuery(req1);
			
			List<Client> result1 = (List<Client>)quer1.getResultList();	
			
			return result1;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createClient(String nom){
		
			Client newClient = new Client(nom);
			em.persist(newClient);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateClient(String nom, String modif){
		
			System.out.println("je suis dans mon EJB");
			
			List<Client> liste =getNomClients();
				for (Client client : liste){
					if(nom==client.getNom())
					{
						System.out.println("je modifie le nom");
						client.setNom(modif);
						em.persist(client);
					}
				}
					
					
			
	}
}
