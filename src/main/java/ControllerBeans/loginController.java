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
    private String blood;
    private String name;
    private String surname;
    private String mail_adress;
    private String tel_number;
    private String adress;
    private int active_deactive;
    
    
    
    
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
            blood = u.getBlood();
            name = u.getName();
            surname = u.getSurname();
            mail_adress=u.getMailAdress();
            tel_number = u.getTelNumber();
            adress = u.getAdress();
            active_deactive= u.getActiveDeactive();
            
           return "kullanıcı_paneli?faces-redirect=true";
        }
        else
        {
            return "index";
        }
    }
    
   public void bilgileri_güncelle()
   {
       login b = new login();
       b.güncelle(name, surname, mail_adress, blood, tel_number, adress, user_id);
   }
        
    public void hesap_sil()
    {
        
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
    public String sifremi_unuttum_buton()
    {
        return "parola_yenile?faces-redirect=true";
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

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail_adress() {
        return mail_adress;
    }

    public void setMail_adress(String mail_adress) {
        this.mail_adress = mail_adress;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(int active_deactive) {
        this.active_deactive = active_deactive;
    }
    
    
        
    

    

    

    

    

   
    
    
    
}
