
package ControllerBeans;

import DAOData.uyelik;
import Entity.Users;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;





@ManagedBean
@SessionScoped
public class uyelikController implements Serializable
{
    private int    user_id;
    private String user_name; 
    private String user_password; 
    private String name; 
    private String surname; 
    private String mail_adress; 
    private String blood; 
    private String tel_number;
    private String adress;
    private String password_control;
    private int active_deactive;
    
    

   
    public void uye_kayıt()
    {
        if(user_password.equals(password_control))
        {
           uyelik yeni = new uyelik();
            yeni.yeni_uye(user_name, user_password, name, surname, mail_adress, blood, tel_number, adress, active_deactive,user_id); 
        }
 
    }
    
    public String geri()
    {
         return "login?faces-redirect=true";
    }
  
    
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
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

    public String getPassword_control() {
        return password_control;
    }

    public void setPassword_control(String password_control) {
        this.password_control = password_control;
    }

    public int getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(int active_deactive) {
        this.active_deactive = active_deactive;
    }

    
    
    
    
}
