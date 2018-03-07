package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.datasource.MySQL_DBManager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;

import java.util.List;

/**
 * class for the loading screen while all the lists are download.
 */
public class MainActivity extends Activity {

    FactoryMethod a = new FactoryMethod();

    public DB_manager b;

    /*
     * instance to check the connection status.
     */
    ConnectionDetector connectionDetector;
    /*
     * definition for the instance views we will get.
     */
    private Button button;
    private Button addCarButton;
    private Button addBranchButton;
    private Button addCarModelButton;
    private Button addClientButton;
    private Button showCarsButton;
    private Button showClientButton;
    private Button showCarsModelButton;
    private Button showBranchsButton;
    private Button openTabs;

    /**
     * @param savedInstanceState contains the most recent data, specially contains
     * data of the activity's previous initialization part.
     */
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = FactoryMethod.getManager();
        /*
         * thread to get all our lists from our database.
         */
        new AsyncTask<Void, Void, Void>() {
            /**
             * @param aVoid no params.
             */
            @Override
            protected void onPostExecute(Void aVoid) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }

            /**
             * download all the lists in background.
             * @param voids no params.
             * @return null
             */
            @Override
            protected Void doInBackground(Void... voids) {
                MySQL_DBManager.branchList = FactoryMethod.getManager().AllBranch();
                MySQL_DBManager.carsModelList = FactoryMethod.getManager().AllCarsModel();
                MySQL_DBManager.carsList = FactoryMethod.getManager().AllCars();
                MySQL_DBManager.clientList = FactoryMethod.getManager().AllUsers();
                return null;
            }
        }.execute();

        /*
         * Instance of the connection to be check.
         * Checked the connection and make Toast of "connected" in case everything ok, "Not Connected" otherwise.
         */
        connectionDetector = new ConnectionDetector(this);
        if (connectionDetector.isConnected()) {
            Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(MainActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();

    }

    /**
     * class that check the internet connection.
     */
    public class ConnectionDetector {
        Context context;

        /**
         * @param context to change the current context.
         */
        public ConnectionDetector(Context context) {
            this.context = context;
        }

        /**
         * this function check the status of the internet connection.
         * @return true if the connection is open false otherwise.
         */
        public boolean isConnected() {
            ConnectivityManager connectivity = (ConnectivityManager)
                    context.getSystemService(Service.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null) {
                    if (info.getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
            return false;
        }
    }
}