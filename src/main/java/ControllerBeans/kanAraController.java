/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBeans;

import DAOData.kanAra;
import Entity.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
public class kanAraController implements Serializable 
{
    private static final long serialVersionUID = 1L;
    private String kan_grubu;
    private String il_bilgisi;
    private List<Users> users;
    private final kanAra kanjpa = new kanAra();
    private List<Users> seçilen_kullanıcı;

    public kanAraController() 
    {
       
        
    }
    
    
    
    
   
   
    public List<Users> getir()
    {
        users = kanjpa.kan_getir(kan_grubu, il_bilgisi);
        return users;
    }
    

    public String getKan_grubu() {
        return kan_grubu;
    }

    public void setKan_grubu(String kan_grubu) {
        this.kan_grubu = kan_grubu;
    }

    public String getIl_bilgisi() {
        return il_bilgisi;
    }

    public void setIl_bilgisi(String il_bilgisi) {
        this.il_bilgisi = il_bilgisi;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Users> getSeçilen_kullanıcı() {
        return seçilen_kullanıcı;
    }

    public void setSeçilen_kullanıcı(List<Users> seçilen_kullanıcı) {
        this.seçilen_kullanıcı = seçilen_kullanıcı;
    }

   

   

    

   
    
    
    
    
}
