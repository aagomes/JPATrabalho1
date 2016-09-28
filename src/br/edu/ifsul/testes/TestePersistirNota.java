/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexandre
 */
public class TestePersistirNota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        Nota n = new Nota();        
        n.setNota01(7.0);
        n.setNota02(8.0);
        n.setMedia((n.getNota01()+n.getNota02())/2);
        n.setAluno(em.find(Aluno.class, 1));
        n.setDisciplina(em.find(Disciplina.class, 2));
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
