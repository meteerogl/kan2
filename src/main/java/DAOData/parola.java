/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOData;

import Entity.Users;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class parola{
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("kanbagis");
    private  EntityManager em = emf.createEntityManager();
    private Users user;
  
    
    public Users mail_adresi(String userName)
    {
        
        String sql = "SELECT u FROM Users u WHERE u.userName = :userName";
        Query query = em.createQuery(sql);
        query.setParameter("userName", userName);
        user = (Users) query.getSingleResult();
        em.close();
        return user;
        
        
    }
    
}
