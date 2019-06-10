package com.r4v3zn.fofa.core.DO;

/**
 * Title: UserLogin
 * Descrption: UserLogin DO
 * Date:2019-06-07 16:13
 * Email:woo0nise@gmail.com
 * Company:www.j2ee.app
 * @author R4v3zn
 * @version 1.0.0
 */
public class UserLogin {

    /**
     * this is FOFA Pro email
     */
    private  String email;

    /**
     * this is FOFA Pro key
     */
    private  String key;

    /**
     * Constructor
     * @param email user email
     * @param key user key
     */
    public UserLogin(String email, String key) {
        this.email = email;
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public String getKey() {
        return key;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
