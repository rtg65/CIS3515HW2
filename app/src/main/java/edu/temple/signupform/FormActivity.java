package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView userName = findViewById(R.id.editTextTextPersonName);
                TextView email = findViewById(R.id.editTextTextEmailAddress);
                TextView password = findViewById(R.id.editTextTextPassword);
                TextView confirmPassword = findViewById(R.id.editTextTextPassword2);
                //booleans to confirm form if filled correctly. (all filled assumes they are unless it encounters one that is not
                boolean allFilled = true;
                boolean password_length = false;
                boolean passwordMatch = false;
                boolean validEmail = false;

                //check to see if forms are filled and valid
                if(userName.getText().length() == 0){
                    allFilled = false;
                }
                if(email.getText().length() == 0){
                    allFilled = false;
                }else if(android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()){
                    validEmail = true;
                }
                if(password.getText().length() == 0){
                    allFilled = false;
                } else if(password.getText().length() > 8){
                    password_length = true;
                }
                if(confirmPassword.getText().length() == 0){
                    allFilled = false;
                } else if(password.getText().toString().contentEquals(confirmPassword.getText())){
                    passwordMatch = true;
                }


                //Check to see if any errors noticed, if not, display welcome toast
                if(!allFilled){
                    Toast.makeText(getApplicationContext(),R.string.unfilled, Toast.LENGTH_LONG).show();
                } else if(!validEmail){
                    Toast.makeText(getApplicationContext(),R.string.validemail, Toast.LENGTH_LONG).show();
                }else if(!password_length){
                    Toast.makeText(getApplicationContext(),R.string.shortpassword, Toast.LENGTH_LONG).show();
                } else if(!passwordMatch){
                    Toast.makeText(getApplicationContext(),R.string.nomatch, Toast.LENGTH_LONG).show();
                } else {
                    String text = "Welcome " + userName.getText() + " to the SignUpForm App!";
                    Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG).show();
                }

            }
        });
            }
        });
    }
}