package com.auk.responsiveclassregistrationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.auk.responsiveclassregistrationsystem.models.RegisterUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistrationActivity extends AppCompatActivity {

    Button regBtn;
    EditText username, email, rollno, city, phoneno, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regBtn = findViewById(R.id.register_btn);

        username = findViewById(R.id.register_username);
        email = findViewById(R.id.register_email);
        rollno = findViewById(R.id.register_rollno);
        city = findViewById(R.id.register_city);
        phoneno = findViewById(R.id.register_phoneno);
        description = findViewById(R.id.register_description);


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser registerUser = new RegisterUser(username.getText().toString() , rollno.getText().toString(), email.getText().toString(), phoneno.getText().toString(), city.getText().toString(), description.getText().toString() );
                FirebaseFirestore.getInstance().collection("registeredUserData").document().set(registerUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(RegistrationActivity.this, "Registered User Successfully", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegistrationActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}