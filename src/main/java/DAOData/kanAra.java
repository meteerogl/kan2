/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOData;

import Entity.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;




public class kanAra  implements Serializable
{
    private static final long serialVersionUID = 1L;
    EntityManager em;
    EntityManagerFactory emf;
    private List<Users> user = new ArrayList<>();

    public kanAra() 
    {
        emf=Persistence.createEntityManagerFactory("kanbagis");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    
    public List<Users> kan_getir(String blood,String adress)
    {
        try
        {
            String sql = "SELECT u FROM Users u WHERE u.blood =:blood AND u.adress =:adress";
            Query query = em.createQuery(sql);
            query.setParameter("blood", blood);
            query.setParameter("adress", adress);
            user = query.getResultList();
            return user;
        }
        catch(Exception e)
                {
                    return user;
                }
    }

    
    
    
    
    
    
    
}
