package com.example.task;

public class hotelBean {
    int userid;
    String username;
    String userpass;
    int roomno;
    String clientname;
    int no_of_person;
    String checkin;
    String checkout;
    int ava_room_id;
    int floor;
    int price;
    String type;
    String guestname;
    String guestid;
    String email;
    int contactno;
    String address;
    String guestpass;
    Boolean booked;
    String membername;
    String memberid;
    String memberemail;
    int membercontactno;
    String memberaddress;
    String loginName;
    String loginPassword;

    public String getRoomString() {
        return "{" +
                "\"ava_room_id\":" + ava_room_id + ","+
                "\"floor\":" + floor +","+
                "\"price\":"+ price+","+
                "\"type\":\""+type+"\""+
                "}";
    }
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
    public int getNo_of_person() {return no_of_person;}
    public void setNo_of_person(int no_of_person) {
        this.no_of_person = no_of_person;
    }
    public String getCheckin() { return checkin; }
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public String getCheckout() {
        return checkout;
    }
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
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
    public String getGuestname() {
        return guestname;
    }
    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }
    public String getGuestid() {return guestid;}
    public void setGuestid(String guestid) {this.guestid = guestid;}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getContactno() {
        return contactno;
    }
    public void setContactno(int contactno) {
        this.contactno = contactno;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGuestpass() {return guestpass;}
    public void setGuestpass(String guestpass) {
        this.guestpass = guestpass;
    }
    public Boolean getBooked(){return booked;}
    public Boolean setBooked(Boolean booked){this.booked = booked;return booked;}
    public String getMembername() {
        return membername;
    }
    public void setMembername(String membername) {
        this.membername = membername;
    }
    public String getMemberid() {return memberid;}
    public void setMemberid(String memberid) {this.memberid = memberid;}
    public String getMemberemail() {
        return memberemail;
    }
    public void setMemberemail(String memberemail) {this.memberemail = memberemail;}
    public int getMembercontactno() {return membercontactno;}
    public void setMembercontactno(int membercontactno) {
        this.membercontactno = membercontactno;
    }
    public String getMemberaddress() {
        return memberaddress;
    }
    public void setMemberaddress(String memberaddress) {
        this.memberaddress = memberaddress;
    }
    public String getLoginName(){return loginName;}
    public String getLoginPassword(){return loginPassword;}

}
