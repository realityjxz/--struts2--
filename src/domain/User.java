package domain;

import java.util.Date;

public class User {
    private long id;
    private String username, pass,sex;
    private Date birth;
    private String phone;

    public User() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public java.sql.Date getBirth() {
        return (java.sql.Date) birth;
    }

    public void setBirth(java.sql.Date birth) {
        this.birth = birth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   /* @Override
    public String toString() {
        ResourceBundle bundle = ResourceBundle.getBundle("demo.msg");
        String info = bundle.getString("user.info");
        String res = MessageFormat.format(info, id, username);
        return res;
    }*/
}
