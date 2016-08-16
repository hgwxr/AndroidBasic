package com.example.xianghaapp.model.bean;

/**
 * Created by Administrator on 2016/8/13.
 */
public class Customer {
    private String code;
    private String nickName;
    private String img;
    private String sex;
    private  String isGourmet;
    private String duty;
    private  String liveness;
    private String folState;
    private String color;



    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsGourmet() {
        return isGourmet;
    }

    public void setIsGourmet(String isGourmet) {
        this.isGourmet = isGourmet;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getLiveness() {
        return liveness;
    }

    public void setLiveness(String liveness) {
        this.liveness = liveness;
    }

    public String getFolState() {
        return folState;
    }

    public void setFolState(String folState) {
        this.folState = folState;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
