/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexandre
 */
public class TestePersistirInstituicao {
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirInstituicao() {
    }
    
     @Before
    public void setUp() {
       emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
       em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void Teste(){
        boolean exception = false;//variável que vai armazenar o resultado do teste
        try {
            Instituicao in = new Instituicao();
            in.setNome("IFSul-Passo Fundo");
            in.setAnoFundacao(Calendar.getInstance());
            em.getTransaction().begin();
            em.persist(in);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
         //compara o resultado esperado com o que ocorreu
        Assert.assertEquals(false, exception);
    }
    
}
