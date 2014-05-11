package com.jss.repman.agencysales;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jss.repman.agencysales.db.Customer;
import com.jss.repman.agencysales.db.CustomerDbHelper;

import static java.lang.Integer.parseInt;

/**
 * Created by krishna on 08-05-2014.
 */
public class LayoutOne extends Fragment {

    public static Fragment newInstance(Context context) {
        LayoutOne f = new LayoutOne();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String dealerId = getActivity().getIntent().getExtras().getString("dealerId");
//        String dealerIdFromText = (String) ( (TextView) getActivity().findViewById(R.id.dealerDetailId)).getText();

        CustomerDbHelper customerDbHelper = new CustomerDbHelper(getActivity().getApplicationContext());
        Customer dealerInfo = customerDbHelper.getCustomer(parseInt(dealerId));

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_one, null);
        ( (TextView) root.findViewById(R.id.dealerInfoName)).setText(dealerInfo.getDealerName());
        ( (TextView) root.findViewById(R.id.dealerInfoAddress)).setText(dealerInfo.getAddress1());
        ( (TextView) root.findViewById(R.id.dealerInfoAddress1)).setText(dealerInfo.getAddress2());
        ( (TextView) root.findViewById(R.id.dealerInfoCity)).setText(dealerInfo.getCity());


        return root;
    }
}
