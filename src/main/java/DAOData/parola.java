/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOData;

import Entity.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class parola {
    
    
    private  final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("kanbagis");
    protected  EntityManager em = emf.createEntityManager();
    private Users user;
  
    
    public Users mail_adresi(String userName, String mailAdress)
    {
        
        String sql = "SELECT u FROM Users u WHERE u.userName = :userName AND u.mailAdress = :mailAdress";
        Query query = em.createQuery(sql);
        query.setParameter("userName", userName);
        query.setParameter("mailAdress", mailAdress);
        user = (Users) query.getSingleResult();
        em.close();
        return user;
        
        
    }
    
}
