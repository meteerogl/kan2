/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerBeans;

import DAOData.parola;
import Entity.Users;
import java.io.Serializable;

import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.primefaces.context.RequestContext;


@ManagedBean
@SessionScoped
public class parola_controller 
{
    
    
    
    private String userName;
    private String mailAdress;

  
    
    public void mail_at()
    {
        parola p = new parola();
        Users u = new Users();
        
        u = p.mail_adresi(userName);
        try {
       String email = u.getMailAdress() ;
       String sifre = u.getUserPassword();
       String ad = userName;
          
			String from = "gelecekbekcisi@gmail.com";
			String pass = "blabla";
			String[] to = { email};
			String host = "smtp.gmail.com";
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "localhost");
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}
            for (InternetAddress toAddres : toAddress) {
                message.addRecipient(Message.RecipientType.TO, toAddres);
            }
			message.setSubject("Şifre hatırlatma");
			message.setText("Kullanıcı adınız: "+ad +" şifreniz: "+sifre +". İyi günler dileriz.");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
                        
		} catch (MessagingException e) {
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

    
    
    
    
}
