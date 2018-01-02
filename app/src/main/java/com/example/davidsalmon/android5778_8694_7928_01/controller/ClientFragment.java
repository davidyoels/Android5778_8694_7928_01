package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;

import java.util.List;

/**
 * Created by david salmon on 11/28/2017.
 */

public class ClientFragment extends Fragment {
    public static final String TAB = "ClientFragment";
    List<Client> myClientsList;
    ViewGroup viewGroup;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.client_fragment, container, false);
        //View  v = initCarByListView(100);
        new AsyncTask<Void, Void, List<Client>>() {

            @Override
            protected List<Client> doInBackground(Void... voids) {
                initClientList(40);
                return myClientsList;
            }

        }.execute();
        while(myClientsList==null){}
        v = initClientByListView(40);
          return v;
    }
    public  void initClientList (int size){
        myClientsList = FactoryMethod.getManager().AllUsers();
    }
    public View initClientByListView(int size){

        ListView listView = new ListView(this.getActivity());
        ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(this.getActivity(), R.layout.show_cient_constraint, myClientsList)
        {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null)    {
                    convertView = View.inflate(ClientFragment.this.getActivity(), R.layout.show_cient_constraint,null);
                }

                TextView productId_firstName_TextView = (TextView) convertView.findViewById(R.id._FirstName);
                TextView productId_lastName_TextView = (TextView) convertView.findViewById(R.id._LastName);
                TextView productId_id_TextView = (TextView) convertView.findViewById(R.id._ID);
                TextView productId_phoneNumber_TextView = (TextView) convertView.findViewById(R.id._PhoneNumber);
                TextView productId_credirCard_TextView = (TextView) convertView.findViewById(R.id._CreditCard);
                TextView productId_email_TextView = (TextView) convertView.findViewById(R.id._Email);

                productId_firstName_TextView.setText(myClientsList.get(position).getPrivateName());
                productId_lastName_TextView.setText((myClientsList.get(position).getFamilyName()));
                productId_id_TextView.setText(((Long) myClientsList.get(position).getId()).toString());
                productId_phoneNumber_TextView.setText((myClientsList.get(position).getPhoneNumber()).toString());
                productId_credirCard_TextView.setText(((Long) myClientsList.get(position).getCreditCard()).toString());
                productId_email_TextView.setText((myClientsList.get(position).getEmail()));
                return convertView;
            }
        };


        listView.setAdapter(adapter);
        viewGroup.addView(listView);

        return viewGroup;
    }



}