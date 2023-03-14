package com.example.dostandard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);
        TableLayout sv = (TableLayout) findViewById(R.id.categoryLinearLayout1);

        for (int i = 0; i < 2; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < 2; j++) {
                ImageButton ib = new ImageButton(this);
                // ib.setImageDrawable(getResources().getDrawable(R.drawable.cat1));
                Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                        R.drawable.img1);
                int width = 400;
                int height = 400;
                Bitmap resizedbitmap = Bitmap.createScaledBitmap(bmp, width,
                        height, true);
                ib.setImageBitmap(resizedbitmap);
                ib.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tr.addView(ib);
            }
            sv.addView(tr);
        }



    }
}