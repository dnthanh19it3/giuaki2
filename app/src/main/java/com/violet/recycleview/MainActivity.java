package com.violet.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText txtInput;
    LinearLayout linearLayout;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnAdd);
        textView = findViewById(R.id.txtResult);
        txtInput = findViewById(R.id.txtName);
        linearLayout = findViewById(R.id.layoutResult);

//        myText.setText("Display this text!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                msg = String.valueOf(txtInput.getText());
                textView.setText(msg);
                linearLayout.addView(addTextview(v, msg));
            }
        });
    }
    @SuppressLint("ResourceType")
    public CardView addTextview(View view, String content){
        Log.d("LOGOK", content);
        TextView textView = new TextView(this);
        CheckBox checkBox = new CheckBox(this);

        CardView cardView = new CardView(this);
        LinearLayout linearLayout = new LinearLayout(this);

        textView.setText(content);
        checkBox.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });

        linearLayout.addView(checkBox);
        linearLayout.addView(textView);
        cardView.addView(linearLayout);
        return cardView;
    }
}