package Proiect;

import java.util.HashMap;

public class IdSiParola {

    HashMap<String, String> logininfo = new HashMap<String, String>();

    IdSiParola() {
        logininfo.put("Ion","123");

    }

    public void setLogininfo(HashMap<String, String> logininfo) {
        this.logininfo = logininfo;
    }

    public HashMap getLoginInfo() {
        return logininfo;
    }

}