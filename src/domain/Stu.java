package domain;

import java.util.Date;

public class Stu {
    private String Sno,Sname, Spass,Ssex;
    private Date Sbirth;
    private String Sphone;
    String Sclass;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSpass() {
        return Spass;
    }

    public void setSpass(String spass) {
        Spass = spass;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public java.sql.Date getSbirth() {
        return (java.sql.Date) Sbirth;
    }

    public void setSbirth(Date sbirth) {
        Sbirth = sbirth;
    }

    public String getSphone() {
        return Sphone;
    }

    public void setSphone(String sphone) {
        Sphone = sphone;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String sclass) {
        Sclass = sclass;
    }
}
