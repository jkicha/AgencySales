package com.jss.repman.agencysales;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by krishna on 08-05-2014.
 */
public class LayoutTwo extends Fragment{


        public static Fragment newInstance(Context context) {
            LayoutTwo f = new LayoutTwo();
            return f;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_two   , null);
            return root;
        }

}
