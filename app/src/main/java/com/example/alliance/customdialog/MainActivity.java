package com.example.alliance.customdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.buttonLoginDialog);
    }

    public void buttonOnclicklistener(View view){
        if(view.getId()==R.id.buttonLoginDialog){
            AlertDialog.Builder mLoginBuilder = new AlertDialog.Builder(MainActivity.this);
            View mLoginView = getLayoutInflater().inflate(R.layout.dialog_login,null);
            final EditText email = (EditText)mLoginView.findViewById(R.id.editTextEmail);
            final EditText pass = (EditText)mLoginView.findViewById(R.id.editTextPass);
            Button submitButton = (Button)mLoginView.findViewById(R.id.buttonSubmit);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!email.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this,getString(R.string.msg1)+ email.getText()
                                .toString(),Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(MainActivity.this, R.string.error_login_message,Toast.LENGTH_LONG).show();
                    }
                }
            });

            mLoginBuilder.setView(mLoginView);
            final AlertDialog loginDialog = mLoginBuilder.create();
            loginDialog.show();
            //loginDialog.dismiss();


        }



    }
}
