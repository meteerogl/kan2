/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOData;
    

import Entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class uyelik 
{       
    private  final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("kanbagis");
    protected  EntityManager em = emf.createEntityManager();
    private  EntityTransaction transactionObj = em.getTransaction();
    
    
    
    public  Users yeni_uye(
            String user_name,
            String user_password,
            String name,
            String surname,
            String mail_adress,
            String blood,
            String tel_number,
            String adress,
            int active_deactive,
            int    user_id)
    {
        Users u = new Users();
        
        EntityManager emm = emf.createEntityManager();
           emm.getTransaction().begin();
           transactionObj.begin();
            u.setUserName(user_name);
            u.setUserPassword(user_password);
            u.setName(name);
            u.setSurname(surname);
            u.setMailAdress(mail_adress);
            u.setBlood(blood);
            u.setTelNumber(tel_number);
            u.setAdress(adress);
            u.setActiveDeactive(1);
            emm.merge(u);
            emm.getTransaction().commit();
            
        
        return u;
    }
    
}
