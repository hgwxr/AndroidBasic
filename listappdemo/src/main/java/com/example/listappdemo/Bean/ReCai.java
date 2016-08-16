package com.example.listappdemo.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class ReCai {

    private String title;
    private String classname;
    private int classid;
    private int total;
    private String header_img;
    private String header_word;
    private List<Data>  data=new ArrayList<>();
    private int is_filter;
    private  int search_num;
    private  int column_rank;
    private String city_hot;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getHeader_img() {
        return header_img;
    }

    public void setHeader_img(String header_img) {
        this.header_img = header_img;
    }

    public String getHeader_word() {
        return header_word;
    }

    public void setHeader_word(String header_word) {
        this.header_word = header_word;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getIs_filter() {
        return is_filter;
    }

    public void setIs_filter(int is_filter) {
        this.is_filter = is_filter;
    }

    public int getSearch_num() {
        return search_num;
    }

    public void setSearch_num(int search_num) {
        this.search_num = search_num;
    }

    public int getColumn_rank() {
        return column_rank;
    }

    public void setColumn_rank(int column_rank) {
        this.column_rank = column_rank;
    }

    public String getCity_hot() {
        return city_hot;
    }

    public void setCity_hot(String city_hot) {
        this.city_hot = city_hot;
    }
}
