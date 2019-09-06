package com.acquaintsoft.docscannerandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GeneratedDocActivity extends AppCompatActivity {

    private ImageView ivImg;
    private TextView tvPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_doc);

        findViewById();

        Intent intent = getIntent();

        if (intent != null){
            byte[] img = intent.getByteArrayExtra("img");
            Bitmap bmp = BitmapFactory.decodeByteArray(img, 0, img.length);
            ivImg.setImageBitmap(bmp);

            tvPath.setText(intent.getStringExtra("path"));
        }


    }

    private void findViewById() {

        ivImg = findViewById(R.id.ivImg);
        tvPath = findViewById(R.id.tvPath);

    }
}
