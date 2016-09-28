/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexandre
 */
public class TestePersistirProfessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        Professor p = new Professor();        
        p.setTitulacao("Mestre");
        p.setTopicosInteresse("Java,PHP");
        p.setEspecialidade(em.find(Especialidade.class, 1));
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
