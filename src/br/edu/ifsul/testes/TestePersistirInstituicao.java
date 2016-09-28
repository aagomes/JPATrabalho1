/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexandre
 */
public class TestePersistirInstituicao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        Instituicao in = new Instituicao();
        //in.setId(1);
        in.setNome("IFSul-Passo Fundo");
        in.setAnoFundacao(Calendar.getInstance());        
        em.getTransaction().begin();
        em.persist(in);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
