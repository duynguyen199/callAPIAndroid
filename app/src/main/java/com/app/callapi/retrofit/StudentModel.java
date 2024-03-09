package com.app.callapi.retrofit;

import com.google.gson.annotations.SerializedName;

public class StudentModel {

    private String id;
    private String name;
    private String age;
    private String phone;
    private String avatar;

    @SerializedName("create_time")
    private String time_create;

    public StudentModel() {
    }

    public StudentModel(String id, String name, String phone, String avatar, String create_time) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.avatar = avatar;
        this.time_create = create_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreate_time() {
        return time_create;
    }

    public void setCreate_time(String create_time) {
        this.time_create = create_time;
    }
}
