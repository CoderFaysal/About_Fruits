package com.coderfaysal.aboutfruits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    public static String IMAGE = "";
    public static String TITLE = "";
    public static String DESC = "";

    ImageView show_img;
    TextView show_name, show_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        show_img = findViewById(R.id.show_img);
        show_name = findViewById(R.id.show_name);
        show_desc = findViewById(R.id.show_desc);

        Picasso.get().load(IMAGE).into(show_img);

        show_name.setText(TITLE);
        show_desc.setText(DESC);



    }
}