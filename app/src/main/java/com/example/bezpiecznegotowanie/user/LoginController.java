package com.example.bezpiecznegotowanie.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chef.R;
import com.example.chef.utilites_search.FindAction;
import com.google.firebase.auth.FirebaseAuth;

public class LoginController extends AppCompatActivity {

    //klasa jest tworzona przy nowym projekcie zmienione tylko nazwy zmiennych

    private FirebaseAuth firebaseAuth;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_input);
        password = findViewById(R.id.password_input);
        email.setText("");
        password.setText("");
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void startAppWithoutSigning(View v){
        Intent intent = new Intent(this, FindAction.class);
        startActivity(intent);
    }

    public void register(View v){

        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if(email.isEmpty() || password.isEmpty()) {
            displayToast(getString(R.string.missing_email_password_message));
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, authTaskResult -> {
                    if(authTaskResult.isSuccessful()) {
                        displayToast("Rejestracja przebiegła poprawnie");
                    }
                    else{
                        displayToast("Rejestracja niepoprawna: " + authTaskResult.getException().getMessage());
                    }

                });

    }

    public void signIn(View v){

        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if(email.isEmpty() || password.isEmpty()) {
            displayToast(getString(R.string.missing_email_password_message));
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).
                addOnCompleteListener(this, authTaskResult -> {
                    if(authTaskResult.isSuccessful()){
                        Intent intent = new Intent(LoginController.this, FindAction.class);
                        startActivity(intent);
                    }
                    else{
                        displayToast(authTaskResult.getException().getMessage());
                    }

                });


    }

    public void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
