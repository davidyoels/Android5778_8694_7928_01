package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;

public class AddClient extends Activity implements View.OnClickListener{

    //definition for the instance views we will get.
    private EditText NameEditText13;
    private EditText FamilyNameEditText14;
    private EditText IdEditText15;
    private EditText EmailEditText16;
    private EditText PhoneEditText17;
    private EditText CreditCardEditText18;
    private Button AddClientButton;



    /**
     * the findViews function gets the instance of the views.
     * and make the add button to listen the click event.
     */
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
    /**
     * the function create the activity and find the views.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        findViews();

    }


    /**
     * check if the click is the add button click.
     * the function take all the information that has been insert and send it by thread in the background to
     * the php page to add the new Client.
     * @param v represent the view of the event that have been occurred.
     *
     */
    @Override
    public void onClick(View v) {
        if ( v == AddClientButton ) {
            Context context = getApplicationContext();

            Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);

            final ContentValues contentValues = new ContentValues();
            try{
                long ID = Long.valueOf(this.IdEditText15.getText().toString());
                long CreditCard = Long.valueOf(this.CreditCardEditText18.getText().toString());
                String Email = this.EmailEditText16.getText().toString();
                String PhoneNumber = this.PhoneEditText17.getText().toString();
                String Name = this.NameEditText13.getText().toString();
                String FamilyName = this.FamilyNameEditText14.getText().toString();

                if (FactoryMethod.getManager().UserExistsOnDataBase(ID))
                {
                  throw new Exception("User ID already exist");
                }




                if(ID == 0 || Email.isEmpty() || Name.isEmpty() || CreditCard == 0 || PhoneNumber.isEmpty() || FamilyName.isEmpty() )
                    throw new Exception("one of the filed missed!");
                else {
                    contentValues.put(Car_GoConst.ClientConst.ID, ID);
                    contentValues.put(Car_GoConst.ClientConst.CREDIT_CARD, CreditCard);
                    contentValues.put(Car_GoConst.ClientConst.EMAIL, Email);
                    contentValues.put(Car_GoConst.ClientConst.PHONE_NUMBER, PhoneNumber);
                    contentValues.put(Car_GoConst.ClientConst.PRIVATE_NAME, Name);
                    contentValues.put(Car_GoConst.ClientConst.FAMILY_NAME, FamilyName);


                    new AsyncTask<Void, Void, Long>() {
                        @Override
                        protected void onPostExecute(Long idResult)
                        {
                            super.onPostExecute(idResult);
                            if (idResult > 0)
                                Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                        }
                        @Override
                        protected Long doInBackground(Void... params)
                        {
                            return FactoryMethod.getManager().addUser(contentValues);
                        }}.execute();


                    finish();
                }
            } catch (Exception e) {

                //Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG);
                toast.setText(e.getMessage());
                toast.show();

            }
        }

    }

}
