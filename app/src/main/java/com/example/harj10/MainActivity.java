package com.example.harj10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    EditText editText;
    Button button1;
    Button button2;
    Button button3;
    ImageView imageView;
    ArrayList<String> stringlista;
    String tag;
    RequestQueue requestQueue;
    String kuvaurl = "https://loremflickr.com/320/240/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        imageView = findViewById(R.id.imageView);
        stringlista = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);








        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //lisätään stringi listaan ja näytetään textviewissä , eroteltuna
                tag = editText.getText().toString();

                stringlista.add(new String(tag));

                StringBuilder Sbuilder = new StringBuilder();

                for (String s : stringlista){
                    Sbuilder.append(s + "," +"\n");
                }
                textView.setText(Sbuilder.toString());


            }
        });
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                stringlista.clear();
                textView.setText("");
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ImageRequest request = new ImageRequest(kuvaurl + stringlista,

                        new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap response) {
                            imageView.setImageBitmap(response);
                            }
                        }, 720, 440, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.ALPHA_8, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this,"jtn men iväärin", Toast.LENGTH_LONG).show();
                        error.printStackTrace();

                    }

                });

                Objekti.getInstance(MainActivity.this).addToRequestQue(request);




            }
        });


    }

}
