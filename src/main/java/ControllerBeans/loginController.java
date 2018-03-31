/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBeans;

import DAOData.login;
import Entity.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean
@SessionScoped
public class loginController implements Serializable
{
    private String kullanici;
    private String sifre;
    private int user_id;
    private String eski_sifre;
    
    
    
    
    private String yeni_sifre;
    private String yeni_sifre_control;
    
    private List<Users> bilgiler;
    
    

    

   //GİRİŞ İŞLEMİNİ DOĞRULAMA
    public String validateLogin()
    {
        
        login User = new login();
        Users u = User.valUser(kullanici, sifre);
        if(u!=null)
        {
            user_id = u.getUserId();
            eski_sifre=u.getUserPassword();
            
           return "kullanıcı_paneli?faces-redirect=true";
        }
        else
        {
            return "index";
        }
    }
    
    public  List<Users> bilgileri_getir()
    {
        login log = new login();
        bilgiler = log.bilgileri_getir(kullanici, sifre);
        
        return bilgiler;
        
    }
    
    public void sifre_degis()
    {
        login l = new login();
        if(sifre.equals(eski_sifre))
        {
            
            if(yeni_sifre.equals(yeni_sifre_control))
            {
                l.sifre_degis(user_id, yeni_sifre);
            }
           
        }
        
    }
    
    
    public String üyeol_buton()
    {
        return "uyelik_formu?faces-redirect=true";
    }
    
    
    public List<Users> getBilgiler() {
        return bilgiler;
    }

    public void setBilgiler(List<Users> bilgiler) {
        this.bilgiler = bilgiler;
    }

    public loginController() {
        this.bilgiler = new ArrayList<>();
    }
   
     public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getYeni_sifre() {
        return yeni_sifre;
    }

    public void setYeni_sifre(String yeni_sifre) {
        this.yeni_sifre = yeni_sifre;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEski_sifre() {
        return eski_sifre;
    }

    public void setEski_sifre(String eski_sifre) {
        this.eski_sifre = eski_sifre;
    }

    public String getYeni_sifre_control() {
        return yeni_sifre_control;
    }

    public void setYeni_sifre_control(String yeni_sifre_control) {
        this.yeni_sifre_control = yeni_sifre_control;
    }
    
    
        
    

    

    

    

    

   
    
    
    
}
