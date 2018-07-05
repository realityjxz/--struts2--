package domain;

import java.util.Date;

public class Tea {
    private String Tno,Tname, Tpass,Tsex;
    private Date Tbirth;
    private String Tphone;

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTpass() {
        return Tpass;
    }

    public void setTpass(String tpass) {
        Tpass = tpass;
    }

    public String getTsex() {
        return Tsex;
    }

    public void setTsex(String tsex) {
        Tsex = tsex;
    }

    public java.sql.Date getTbirth() {
        return (java.sql.Date) Tbirth;
    }

    public void setTbirth(Date tbirth) {
        Tbirth = tbirth;
    }

    public String getTphone() {
        return Tphone;
    }

    public void setTphone(String tphone) {
        Tphone = tphone;
    }
}
