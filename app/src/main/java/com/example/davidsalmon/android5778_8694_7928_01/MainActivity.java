package com.example.davidsalmon.android5778_8694_7928_01;

import android.app.Activity;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    FactoryMethod a = new FactoryMethod();
    public DB_manager b;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create one mofa
        b = a.getManager();

        //checking the add client function and the function All users.
        CheckClientFunctions();

        Log.i(TAG, "******************************************************************************************");

        //checking the add cars functions
        CheckCarsFunctions();

        Log.i(TAG, "******************************************************************************************");

        //checking cars model functions
        CheckCarsModelFunctions();

        Log.i(TAG, "******************************************************************************************");

        //checking branch functions
        CheckBranchFunctions();


    }
    void CheckClientFunctions() {
        Client client1 = new Client("Salmon", "David", 208796323, "054-98394993", "davidyoqwe@gmail.com", 323123123);
        Client client2 = new Client("Levi", "Yoel", 202079658, "054-7456347", "davidyoqwe@gmail.com", 323123123);
        Client client3 = new Client("Salmon", "David", 208796323, "054-8394993", "davidyoqwe@gmail.com", 323123123);
        Client client4 = new Client("Salmon", "David", 208796321, "054-8394993", "davidyoqwe@gmail.com", 221123123);
        b.addUser(client1);
        b.addUser(client2);
        b.addUser(client3);
        List<Client> clients = b.AllUsers();
        for (int i = 0; i < clients.size(); i++) {
            Log.i(TAG, clients.get(i).toString());
        }
        //checking if user exist in the system.

        if (b.UserExistsOnDataBase(client4))
            Log.i(TAG, "Client exist in the system");
        else
            Log.i(TAG, "Client does not exist in the system");
        if (b.UserExistsOnDataBase(client3))
            Log.i(TAG, "Client exist in the system");
        else
            Log.i(TAG, "Client does not exist in the system");
    }
    void CheckCarsFunctions()
    {
        Car car1 = new Car(13, "Volvo", 150, "20-300-23");
        Car car2 = new Car(13, "Kaia", 300, "35-246-15");
        Car car3 = new Car(13, "Nissan", 0, "61-152-90");
        Car car4 = new Car(13, "Volvo", 422, "94-953-78");
        b.addCar(car1);
        b.addCar(car2);
        b.addCar(car3);
        b.addCar(car4);
        List<Car> cars = b.AllCars();
        for (int i = 0; i < cars.size(); i++) {
            Log.i(TAG, cars.get(i).toString());
        }
    }
    void CheckCarsModelFunctions()
    {
        CarsModel carsModel1 = new CarsModel(123,"Nissan","Largo",3400,Gearbox.Automaton,6);
        CarsModel carsModel2 = new CarsModel(984,"Volvo","Yes",3400,Gearbox.Manual,8);
        CarsModel carsModel3 = new CarsModel(295,"Yaguar","Flam",3400,Gearbox.Manual,5);
        CarsModel carsModel4 = new CarsModel(584,"Nissan","Largo",3400,Gearbox.Automaton,2);
        b.addModel(carsModel1);
        b.addModel(carsModel2);
        b.addModel(carsModel3);
        b.addModel(carsModel4);
        List<CarsModel> carsModels = b.AllCarsModel();
        for (int i = 0; i < carsModels.size(); i++) {
            Log.i(TAG, carsModels.get(i).toString());
        }
    }
    void CheckBranchFunctions()
    {
        Branch branch1 = new Branch("Jerusalem","Ben Yehuda",11,5,857);
        Branch branch2 = new Branch("Beit Shemes","Nahal Dulev",16,2,853);
        Branch branch3 = new Branch("Haifa","Benji",11,5,857);
        Branch branch4 = new Branch("Tel Aviv","Alenbi",20,4,234);
        b.addBranch(branch1);
        b.addBranch(branch2);
        b.addBranch(branch3);
        b.addBranch(branch4);
        List<Branch> branches = b.AllBranch();
        for (int i = 0; i < branches.size(); i++) {
            Log.i(TAG, branches.get(i).toString());
        }
    }
}