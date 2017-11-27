package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;

import java.util.List;

public class ShowClient extends AppCompatActivity implements View.OnClickListener{
    List<Client> myClientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLay);
        constraintLayout.setOnClickListener(this);
        initClientByListView(100);

    }



    private void initClientList(int size) {
       myClientList = FactoryMethod.getManager().AllUsers();
    }



    public void initClientByListView(int size){

        initClientList(size);
        ListView listView = new ListView(this);
        ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(this, R.layout.activity_show_client, myClientList)
        {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null)    {
                    convertView = View.inflate(ShowClient.this, R.layout.activity_show_client,null);
                }
                TextView productId_firstName_TextView = (TextView) convertView.findViewById(R.id._FirstName);
                TextView productId_lastName_TextView = (TextView) convertView.findViewById(R.id._LastName);
                TextView productId_id_TextView = (TextView) convertView.findViewById(R.id._ID);
                TextView productId_phoneNumber_TextView = (TextView) convertView.findViewById(R.id._PhoneNumber);
                TextView productId_credirCard_TextView = (TextView) convertView.findViewById(R.id._CreditCard);
                TextView productId_email_TextView = (TextView) convertView.findViewById(R.id._Email);

                productId_firstName_TextView.setText(myClientList.get(position).getPrivateName());
                productId_lastName_TextView.setText((myClientList.get(position).getFamilyName()));
                productId_id_TextView.setText(((Long) myClientList.get(position).getId()).toString());
                productId_phoneNumber_TextView.setText((myClientList.get(position).getPhoneNumber()).toString());
                productId_credirCard_TextView.setText(((Long) myClientList.get(position).getCreditCard()).toString());
                productId_email_TextView.setText((myClientList.get(position).getEmail()));
                return convertView;
            }
        };


        listView.setAdapter(adapter);
        this.setContentView(listView);



    }


    @Override
    public void onClick(View view) {
        //Intent intent = new Intent(this,AddBracnh.class);
        //startActivity(intent);
    }
}
