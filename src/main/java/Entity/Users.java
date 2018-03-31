/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mete
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId")
    , @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName")
    , @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
    , @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname")
    , @NamedQuery(name = "Users.findByMailAdress", query = "SELECT u FROM Users u WHERE u.mailAdress = :mailAdress")
    , @NamedQuery(name = "Users.findByBlood", query = "SELECT u FROM Users u WHERE u.blood = :blood")
    , @NamedQuery(name = "Users.findByTelNumber", query = "SELECT u FROM Users u WHERE u.telNumber = :telNumber")
    , @NamedQuery(name = "Users.findByAdress", query = "SELECT u FROM Users u WHERE u.adress = :adress")
    , @NamedQuery(name = "Users.findByActiveDeactive", query = "SELECT u FROM Users u WHERE u.activeDeactive = :activeDeactive")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="user_id",updatable=true,nullable=true)
    
    @Basic(optional = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "user_name",updatable = true)
    private String userName;
    @Basic(optional = false)
    @Column(name = "user_password",updatable = true)
    private String userPassword;
    @Basic(optional = false)
    @Column(name = "name",updatable = true)
    private String name;
    @Basic(optional = false)
    @Column(name = "surname",updatable = true)
    private String surname;
    @Basic(optional = false)
    @Column(name = "mail_adress",updatable = true)
    private String mailAdress;
    @Basic(optional = false)
    @Column(name = "blood",updatable = true)
    private String blood;
    @Basic(optional = false)
    @Column(name = "tel_number",updatable = true)
    private String telNumber;
    @Basic(optional = false)
    @Column(name = "adress",updatable = true)
    private String adress;
    @Basic(optional = false)
    @Column(name = "active_deactive",updatable = true)
    private int activeDeactive;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userName, String userPassword, String name, String surname, String mailAdress, String blood, String telNumber, String adress, int activeDeactive) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.name = name;
        this.surname = surname;
        this.mailAdress = mailAdress;
        this.blood = blood;
        this.telNumber = telNumber;
        this.adress = adress;
        this.activeDeactive = activeDeactive;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getActiveDeactive() {
        return activeDeactive;
    }

    public void setActiveDeactive(int activeDeactive) {
        this.activeDeactive = activeDeactive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Users[ userId=" + userId + " ]";
    }
    
}
