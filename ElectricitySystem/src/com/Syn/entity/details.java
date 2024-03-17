
package com.Syn.entity;




public class details {
    private String  userid,month,date;
    private int unit;

    public details(String userid, String month, String date, int unit) {
        this.userid = userid;
        this.month = month;
        this.date = date;
        this.unit = unit;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getUserid() {
        return userid;
    }

    public String getMonth() {
        return month;
    }

    public String getDate() {
        return date;
    }

    public int getUnit() {
        return unit;
    }

  

   
   
    
}
