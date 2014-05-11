package com.jss.repman.agencysales.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by krishna on 20-04-2014.
 */
public class CustomerDbHelper {

    private Repository repo;
    private SQLiteDatabase db;
    /**
     * Pass the context and get the repository instance to get the packed database
     */
    public CustomerDbHelper(Context context) {
        repo = Repository.getInstance(context);

    }



    public List<Customer> searchCustomer(CharSequence charSequence) {
        List<Customer> customers = new LinkedList<Customer>();

        // build the query
        String query = "SELECT * FROM CUSTOMERS WHERE dealername LIKE '%" + charSequence + "%'";

        // get the writable database
        db = repo.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // go over each and build the list
        Customer customer = null;
        if (cursor.moveToFirst()) {
            do {
                customer = new Customer();
                customer.setCustomerId(cursor.getInt(1));
                customer.setDealerName(cursor.getString(2));
                customer.setCity(cursor.getString(5));
                customer.setCell1(cursor.getInt(12));

                customers.add(customer);
            } while (cursor.moveToNext());
        }

        return customers;

    }


    public List<Customer> getAll() {
        List<Customer> customers = new LinkedList<Customer>();

        // build the query
        String query = "SELECT * FROM CUSTOMERS";

        // get the writable database
        db = repo.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // go over each and build the list
        Customer customer = null;
        if (cursor.moveToFirst()) {
            do {
                customer = new Customer();
                customer.setCustomerId(cursor.getInt(1));
                customer.setDealerName(cursor.getString(2));
                customer.setCity(cursor.getString(5));
                customer.setCell1(cursor.getInt(12));

                customers.add(customer);
            } while (cursor.moveToNext());
        }

        return customers;

    }

    public Customer getCustomer(int dealerInfoId) {
        // build the query
        String query = "SELECT * FROM CUSTOMERS WHERE achead = " + dealerInfoId;

        // get the writable database
        db = repo.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // go over each and build the list
        Customer customer = new Customer();
        populateCustomer(cursor, customer);

        return customer;
    }

    private void populateCustomer(Cursor cursor, Customer customer) {
        if (cursor.moveToFirst()) {
            do {
                customer.setCustomerId(cursor.getInt(1));
                customer.setDealerName(cursor.getString(2));
                customer.setAddress1(cursor.getString(3));
                customer.setAddress2(cursor.getString(4));
                customer.setCity(cursor.getString(5));
                customer.setDistrict(cursor.getString(6));
                customer.setBlock(cursor.getString(7));
                customer.setState(cursor.getString(8));
                customer.setCountry(cursor.getString(9));
                customer.setPincode(cursor.getInt(10));
                customer.setLandLine(cursor.getInt(11));
                customer.setCell1(cursor.getInt(12));
                customer.setCell2(cursor.getInt(13));
                customer.setEmail(cursor.getString(14));
                customer.setCstNo(cursor.getString(15));
                customer.setTinNo(cursor.getString(16));
                customer.setOwnerName(cursor.getString(17));
                customer.setContactName(cursor.getString(18));
                customer.setFlNo(cursor.getString(19));
//                customer.setFlExpiryDate( new SimpleDateFormat("dd-MM-yyyy").parse(cursor.getString(20)));
                customer.setSlNo(cursor.getString(21));
//                private Time slExpiryDate;
                customer.setPlNo(cursor.getString(23));
//                private Time plExpiryDate;
                customer.setTransport(cursor.getString(25));
                customer.setMfmsRetrailId(cursor.getString(26));
                customer.setMfmsWsId(cursor.getString(27));

            } while (cursor.moveToNext());
        }
    }
}

