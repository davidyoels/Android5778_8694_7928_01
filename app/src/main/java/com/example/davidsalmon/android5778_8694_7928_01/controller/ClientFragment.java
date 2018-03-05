package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.datasource.MySQL_DBManager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;

import java.util.List;

/**
 * Created by david salmon on 11/28/2017.
 */

public class ClientFragment extends Fragment {
    public static final String TAB = "ClientFragment";
    List<Client> myClientsList;
    ViewGroup viewGroup;
    FloatingActionButton addClient;
    List listViewClient;
    View v;

    /**
     * @param inflater to convert xml to view.
     * @param container of the screen.
     * @param savedInstanceState
     * @return the view to be display.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.client_fragment, container, false);
        v = initClientByListView(40);
        return v;
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addClient = (FloatingActionButton) getActivity().findViewById(R.id.addfloatingActionButton);
        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddClient.class));
            }
        });
    }

    /**
     * gets the branch list form our database.
     * @param size of the list.
     */
    public  void initClientList (int size){
        myClientsList = MySQL_DBManager.clientList;
    }
    /**
     * this function makes the view fill with the client list.
     * @param size of the list.
     * @return the view to be display.
     */
    public View initClientByListView(int size){
        initClientList(size);
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
                //ImageView productId_Branch_ImageView = (ImageView) convertView.findViewById(R.id.)

                productId_firstName_TextView.setText(myClientsList.get(position).getPrivateName());
                productId_lastName_TextView.setText((myClientsList.get(position).getFamilyName()));
                productId_id_TextView.setText(((Long) myClientsList.get(position).getId()).toString());
                productId_phoneNumber_TextView.setText((myClientsList.get(position).getPhoneNumber()).toString());
                productId_credirCard_TextView.setText(((Long) myClientsList.get(position).getCreditCard()).toString());
                productId_email_TextView.setText((myClientsList.get(position).getEmail()));
                //productId_Branch_ImageView.setImageURI(R.drawable.car1);

                return convertView;
            }
        };


        listView.setAdapter(adapter);
        viewGroup.addView(listView);

        return viewGroup;
    }



}