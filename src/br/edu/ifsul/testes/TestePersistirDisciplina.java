/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexandre
 */
public class TestePersistirDisciplina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        Disciplina d = new Disciplina();        
        d.setNome("DAW");
        d.setDescricao("Desenvolvimento de Aplicações Web");
        d.setCargaHoraria(45.00);
        d.setConhecimentoMinimo("progr. java");
        d.setCurso(em.find(Curso.class, 2));
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
