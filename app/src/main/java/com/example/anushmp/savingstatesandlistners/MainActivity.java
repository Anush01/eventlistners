package com.example.anushmp.savingstatesandlistners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mtvAssign;
    //private TextWatcher mywatcher;
    private Button editTextButton;
    private EditText eddy;

//    public String favouriteCheese;
//    public int numberofbottlesDrunk;



    public int test;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextButton = findViewById(R.id.textviewbutton);

        editTextButton.setOnClickListener(this);

        mtvAssign = findViewById(R.id.tvtextinstance);
        mtvAssign.setText("Welcome to Masai School");
        mtvAssign.setOnClickListener(this);

        eddy = findViewById(R.id.textedit);
         TextWatcher mywatcher = new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("log123",s+" " +start + " " + count +" "+ after);


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("log123",s+" " +start + " " + count +" "+ before);

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().length()>6){
                    Toast.makeText(MainActivity.this,s.toString(),Toast.LENGTH_LONG).show();
                }

            }
        };
        eddy.addTextChangedListener(mywatcher);

        test = 1;




    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("k","Screen Rotated");


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String data = savedInstanceState.getString("k");
        mtvAssign.setText(data);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch(id){
            case R.id.textviewbutton :
                mtvAssign.setText("Button Clicked");
                    break;
            case R.id.tvtextinstance:
                Toast.makeText(this, "You tapped on the textView" + " " + mtvAssign.getText() , Toast.LENGTH_SHORT).show();
                break;
        }


    }
}