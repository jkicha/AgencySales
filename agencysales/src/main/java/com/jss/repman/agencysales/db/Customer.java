package com.jss.repman.agencysales.db;

import android.text.format.Time;

/**
 * Created by krishna on 18-04-2014.
 */
public class Customer  {

    private int _id;
    private int customerId;
    private String dealerName;
    private String address1;
    private String address2;
    private String city;
    private String district;
    private String block;
    private String state;
    private String country;
    private int pincode;
    private int landLine;
    private int cell1;
    private int cell2;
    private String email;
    private String cstNo;
    private String tinNo;
    private String ownerName;
    private String contactName;
    private String flNo;
    private Time flExpiryDate;
    private String slNo;
    private Time slExpiryDate;
    private String plNo;
    private Time plExpiryDate;
    private String transport;
    private String mfmsRetrailId;
    private String mfmsWsId;

//    public Customer(Context context, int customerId, String mobileno, String name) {
//
//
//        this.customerId = customerId;
//        this.mobileno = mobileno;
//        this.name = name;
//    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getLandLine() {
        return landLine;
    }

    public void setLandLine(int landLine) {
        this.landLine = landLine;
    }

    public int getCell1() {
        return cell1;
    }

    public void setCell1(int cell1) {
        this.cell1 = cell1;
    }

    public int getCell2() {
        return cell2;
    }

    public void setCell2(int cell2) {
        this.cell2 = cell2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCstNo() {
        return cstNo;
    }

    public void setCstNo(String cstNo) {
        this.cstNo = cstNo;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getFlNo() {
        return flNo;
    }

    public void setFlNo(String flNo) {
        this.flNo = flNo;
    }

    public Time getFlExpiryDate() {
        return flExpiryDate;
    }

    public void setFlExpiryDate(Time flExpiryDate) {
        this.flExpiryDate = flExpiryDate;
    }

    public String getSlNo() {
        return slNo;
    }

    public void setSlNo(String slNo) {
        this.slNo = slNo;
    }

    public Time getSlExpiryDate() {
        return slExpiryDate;
    }

    public void setSlExpiryDate(Time slExpiryDate) {
        this.slExpiryDate = slExpiryDate;
    }

    public String getPlNo() {
        return plNo;
    }

    public void setPlNo(String plNo) {
        this.plNo = plNo;
    }

    public Time getPlExpiryDate() {
        return plExpiryDate;
    }

    public void setPlExpiryDate(Time plExpiryDate) {
        this.plExpiryDate = plExpiryDate;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getMfmsRetrailId() {
        return mfmsRetrailId;
    }

    public void setMfmsRetrailId(String mfmsRetrailId) {
        this.mfmsRetrailId = mfmsRetrailId;
    }

    public String getMfmsWsId() {
        return mfmsWsId;
    }

    public void setMfmsWsId(String mfmsWsId) {
        this.mfmsWsId = mfmsWsId;
    }

    @Override
    public String toString() {
        return dealerName;
    }
}
