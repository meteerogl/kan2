/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBeans;

import DAOData.parola;
import Entity.Users;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@ManagedBean
@SessionScoped
public class parola_controller implements Serializable 
{
    
    
    private String userName;
    private String mailAdress;
    private String onay_kodu ="111";
    
    
    
    
    public void mail_getir()
    {
        parola p = new parola();
        Users u = p.mail_adresi(userName, mailAdress);
        if(u!=null)
        {
            userName = u.getUserName();
            mailAdress=u.getMailAdress();
        }
        else
        {
            userName="am";
            mailAdress="bla";
        }
        
    }
    
    public void mail_at()
    {
        final String username ="gelecekbekcisi@gmail.com";
        final String password ="muco05055833758";
        Properties properties = new Properties();
        properties.put("mail.smtp.aouth", "true");
        properties.put("mail.smtp.starttls.enable", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        Session session = Session.getInstance(properties,
                           new javax.mail.Authenticator() {
                    
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(username, password);
                    }
             }); 
             try {
 
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("gelecekbekcisi@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailAdress));
                    message.setSubject("KOD5 Hakkındaki Görüşler");
                    message.setText("Merhaba "+userName+"/n" +"parola yenileme kodunuz" +onay_kodu); 
                    Transport.send(message);
 
             } catch (MessagingException ex) {
                    throw new RuntimeException(ex);
             }
        
        
        
        
    }
  
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public String getOnay_kodu() {
        return onay_kodu;
    }

    public void setOnay_kodu(String onay_kodu) {
        this.onay_kodu = onay_kodu;
    }
    

    
    
    
    
    
    
    
}
