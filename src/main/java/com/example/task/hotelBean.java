package com.example.task;

public class hotelBean {
    int userid;
    String username;
    String userpass;
    int roomno;
    String clientname;
    int age;
    int phoneno;
    int no_of_person;
    String checkin;
    String checkout;
    int ava_room_id;
    Boolean booked;
    int floor;
    int price;
    String type;
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpass() {
        return userpass;
    }
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    public int getRoomno() {
        return roomno;
    }
    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }
    public String getClientname() {
        return clientname;
    }
    public void setClientname(String clientname) {
        this.clientname = clientname;
    }
    public int getAge() {return age;}
    public void setAge(int age) {
        this.age = age;
    }
    public int getPhoneno() {return phoneno;}
    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }
    public int getNo_of_person() {return no_of_person;}
    public void setNo_of_person(int no_of_person) {
        this.no_of_person = no_of_person;
    }
    public String getCheckin() {
        return checkin;
    }
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public String getCheckout() {
        return checkout;
    }
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    public boolean getBooked(){return booked;}
    public void setBooked(Boolean booked){this.booked=booked;}
    public int getAva_room_id(){return ava_room_id;}
    public void setAva_room_id(int ava_room_id){this.ava_room_id=ava_room_id;}
    public int getFloor() {return floor;}
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public int getPrice() {return price;}
    public void setPrice(int price) {
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
