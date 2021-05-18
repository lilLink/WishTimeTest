package ua.wishtime.yukon.model;

import net.serenitybdd.screenplay.Actor;

public class RegisteredUser extends Actor {

    private final String email;

    private final String password;



    public RegisteredUser(String name, String email, String password){
        super(name);

        this.email = email;
        this.password = password;
    }

    public String email(){
        return email;
    }

    public String password(){
        return password;
    }

}
