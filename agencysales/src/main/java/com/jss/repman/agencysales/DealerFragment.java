package com.jss.repman.agencysales;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.TextView;

import com.jss.repman.agencysales.db.Customer;
import com.jss.repman.agencysales.db.CustomerDbHelper;
import com.jss.repman.agencysales.dummy.DummyContent;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class DealerFragment extends Fragment implements AbsListView.OnItemClickListener {

    private OnFragmentInteractionListener mListener;

    private Context context;
    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    private EditText dealerName;
    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;

    // TODO: Rename and change types of parameters
    public static DealerFragment newInstance(int position) {
        DealerFragment fragment = new DealerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DealerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this will display the options menu set in the fragment
        setHasOptionsMenu(true);
        CustomerDbHelper customerDbHelper = new CustomerDbHelper(getActivity().getApplicationContext());
        List<Customer> dealers = customerDbHelper.getAll();
        mAdapter = new DealerRowAdapter(getActivity(), dealers);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dealer, container, false);

        dealerName = (EditText) view.findViewById(R.id.dealerName);
        dealerName.setFocusable(true);
        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);
        dealerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CustomerDbHelper customerDbHelper = new CustomerDbHelper(getActivity().getApplicationContext());
                List<Customer> dealers = customerDbHelper.searchCustomer(charSequence);
                mAdapter = new DealerRowAdapter(getActivity(), dealers);
                ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.activity_main_actions, menu);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent dealerDetail = new Intent(getActivity().getBaseContext(), DealerDetail.class);
                String dealerId = ((TextView) (view.findViewById(R.id.dealerId))).getText().toString();
                dealerDetail.putExtra("dealerId", dealerId);
                startActivity(dealerDetail);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyText instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

    private class DealerRowAdapter extends BaseAdapter {

        List<Customer> dealerList;
        Activity context;

        public DealerRowAdapter(Activity context,  List<Customer> dealerList) {
            this.context = context;
            this.dealerList = dealerList;
        }


        private class ViewHolder {
            TextView dealerId;
            TextView dealerName;
            TextView city;
            TextView mobileNo;
        }

        @Override
        public int getCount() {
            return dealerList.size();
        }

        @Override
        public Object getItem(int i) {
            return dealerList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder holder;


            if (view == null)
            {
                LayoutInflater   inflater = context.getLayoutInflater();
                view = inflater.inflate(R.layout.dealer_row, null);
                holder = new ViewHolder();

                holder.dealerId = (TextView) view.findViewById(R.id.dealerId);
                holder.dealerName = (TextView) view.findViewById(R.id.dealerName);
                holder.city = (TextView) view.findViewById(R.id.city);
                holder.mobileNo = (TextView) view.findViewById(R.id.contactNo);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            Customer dealer = (Customer) getItem(i);
            if ( dealer != null) {
                Log.i("agency", "get Customer Id not null " + dealer.getDealerName());
            } else {
                Log.i("agency", "custoemr id is null");
            }
            holder.dealerId.setText(new Integer(dealer.getCustomerId()).toString());
            holder.dealerName.setText(dealer.getDealerName());
            holder.city.setText(dealer.getCity());
            holder.mobileNo.setText(new Integer(dealer.getCell1()).toString());

            return view;
        }
    }
}
