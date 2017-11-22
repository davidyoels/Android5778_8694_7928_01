package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.content.ContentValues;
import android.icu.util.Calendar;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class show_client extends AppCompatActivity {
    List<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Client a = new Client("salkmon","david",123,"123123","asdasdasd",123213);
        FactoryMethod.getManager().addUser(Client.ClientToContentValues(a));
        a = new Client("asd","yoel",123,"123123","asdasdasd",123213);
        FactoryMethod.getManager().addUser(Client.ClientToContentValues(a));
        int size = 1000;
        initByListView(size);

    }
    private void initList(int size) {
        List<Client> ClientList = FactoryMethod.getManager().AllUsers();
        myList = new ArrayList<String>();
        for (int i = 0; i < ClientList.size(); i++)
            myList.add(ClientList.get(i).toString());
    }
    void initByListView(int size) {
        initList(size);
     ListView listView = new ListView(this);
    final ArrayAdapter adapter = new ArrayAdapter
            (
                    this,
                    R.layout.row_button,
                    myList
            );

        listView.setAdapter(adapter);
        this.setContentView(listView);



    }
}
