/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOData;


import Entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class login 
{
    private  final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("kanbagis");
    protected  EntityManager em = emf.createEntityManager();
    private List bilgiler = new ArrayList<>();
    private Users user;
    public login() 
    {
 
    }
    
    public Users valUser(String userName,String userPassword)
    {
  
        String sql = "SELECT u FROM Users u WHERE u.userName = :userName AND u.userPassword = :userPassword";
        Query query = em.createQuery(sql);
        query.setParameter("userName", userName);
        query.setParameter("userPassword", userPassword);
        user = (Users) query.getSingleResult();
        em.close();
        return user;
    }
    
    public List bilgileri_getir(String userName,String userPassword)
    {
        String sql = "SELECT u FROM Users u WHERE u.userName = :userName AND u.userPassword = :userPassword";
        Query query = em.createQuery(sql);
        query.setParameter("userName", userName);
        query.setParameter("userPassword", userPassword);
        bilgiler = query.getResultList();
        em.close();
        return  bilgiler;
        
    }
    
    
    public  Users sifre_degis(int id,String yeni_sifre)
    {
        Users u = em.find(Users.class, id);
        if(u!=null)
        {
            em.getTransaction().begin();
            u.setUserPassword(yeni_sifre);
            em.getTransaction().commit();
            
            
        }
        return u;
    }
    
    
   public Users güncelle(
   
                        String name,
                        String surname,
                        String mail_adress,
                        String blood,
                        String tel_number,
                        String adress,
                        int    user_id)
   {
       Users u = em.find(Users.class, user_id);
       if(u!= null)
       {
           
           em.getTransaction().begin();
           u.setName(name);
           u.setSurname(surname);
           u.setMailAdress(mail_adress);
           u.setBlood(blood);
           u.setTelNumber(tel_number);
           u.setAdress(adress);
           em.getTransaction().commit();
           
       
       }
       return u;
   }
    public Users hesap_sil(int user_id)
    {
        int a =2;
        Users u = em.find(Users.class,user_id);
        em.getTransaction().begin();
        u.setActiveDeactive(a);
        em.getTransaction().commit();
        return u;
    }
    
}
