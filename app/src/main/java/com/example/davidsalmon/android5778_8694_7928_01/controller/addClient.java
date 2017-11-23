package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;

public class addClient extends AppCompatActivity implements View.OnClickListener{

    private EditText NameEditText13;
    private EditText FamilyNameEditText14;
    private EditText IdEditText15;
    private EditText EmailEditText16;
    private EditText PhoneEditText17;
    private EditText CreditCardEditText18;
    private Button AddClientButton;




    private void findViews() {
        NameEditText13 = (EditText)findViewById( R.id.Name_editText13 );
        FamilyNameEditText14 = (EditText)findViewById( R.id.FamilyName_editText14 );
        IdEditText15 = (EditText)findViewById( R.id.Id_editText15 );
        EmailEditText16 = (EditText)findViewById( R.id.Email_editText16 );
        PhoneEditText17 = (EditText)findViewById( R.id.Phone_editText17 );
        CreditCardEditText18 = (EditText)findViewById( R.id.CreditCard_editText18 );
        AddClientButton = (Button)findViewById( R.id.AddClient_button );

        AddClientButton.setOnClickListener( this );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        findViews();
    }



    @Override
    public void onClick(View v) {
        if ( v == AddClientButton ) {
            Context context = getApplicationContext();
            CharSequence text = "one of the filed missed!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);

            final ContentValues contentValues = new ContentValues();
            try{
                long ID = Long.valueOf(this.IdEditText15.getText().toString());
                long CreditCard = Long.valueOf(this.CreditCardEditText18.getText().toString());
                String Email = this.EmailEditText16.getText().toString();
                String PhoneNumber = this.PhoneEditText17.getText().toString();
                String Name = this.NameEditText13.getText().toString();
                String FamilyName = this.FamilyNameEditText14.getText().toString();



                if(ID == 0 || Email.isEmpty() || Name.isEmpty() || CreditCard == 0 )
                    toast.show();
                else {
                    contentValues.put(Car_GoConst.ClientConst.ID, ID);
                    contentValues.put(Car_GoConst.ClientConst.CREDIT_CARD, CreditCard);
                    contentValues.put(Car_GoConst.ClientConst.EMAIL, Email);
                    contentValues.put(Car_GoConst.ClientConst.PHONE_NUMBER, PhoneNumber);
                    contentValues.put(Car_GoConst.ClientConst.PRIVATE_NAME, Name);
                    contentValues.put(Car_GoConst.ClientConst.FAMILY_NAME, FamilyName);


                    FactoryMethod.getManager().addUser(contentValues);
                    finish();
                }
            } catch (Exception e) {

                toast.show();

            }
        }
    }

}
