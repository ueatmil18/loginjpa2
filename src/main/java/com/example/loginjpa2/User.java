/**
*@author: Prof. javier Juan Alvarez (silverfenix@mns)
*@Note: toma en cuenta que la tabla se llama user y 
tiene cuatro campo: id,username, email,password
 */
package com.example.loginjpa2; // coloca el TU paquete

// estos import son necesarios
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
  
    @Column(name="username")
    String username;

    @Column(name="email")
    String email;
    
    @Column(name="password")
    String password;

    // constructor sin parametros
    public User(){}
    
    // constructor con parametros
    public User(String name, String pass, String mail){
        this.username= name;
        this.email = mail;
        this.password= pass;
    }

    // getter y setter, necesarios
    public Integer getUserId(){
        return id;
    }

    public void setUserId(Integer myId){
        this.id = myId;
    }
    
    public String getUserName(){
        return username;
    }

    public void setUserName(String myName){
        this.username = myName;
    }
    
    public String getUserMail(){
        return email;
    }

    public void setUserMail(String myEmail){
        this.email = myEmail;
    }

    public String getUserPass(){
        return password;
    }

    public void setUserPass(String myPass){
        this.password = myPass;
    }
} // fin clase User
