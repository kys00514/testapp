package com.example.dostandard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
        Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         intent=new Intent(this,writeActivity.class);
        setContentView(R.layout.activity_main);
        TableLayout sv = (TableLayout) findViewById(R.id.categoryLinearLayout1);

        for (int i = 0; i < 2; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < 2; j++) {
                ImageButton ib = new ImageButton(this);
                ib.setBackgroundColor(getColor(R.color.white));

                Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                        R.drawable.img1);;
                if(i==0 && j==0) {
                     bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.img1);
                }
                if(i==0 && j==1) {
                    bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.img2);
                }
                if(i==1 && j==0) {
                     bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.img3);
                }
                if(i==1 && j==1) {
               bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.img4);
                }
                int width = 400;
                int height = 400;
                Bitmap resizedbitmap = Bitmap.createScaledBitmap(bmp, width,
                        height, true);
                ib.setImageBitmap(resizedbitmap);
                ib.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tr.addView(ib);
                ((ViewGroup.MarginLayoutParams) ib.getLayoutParams()).topMargin = -15;
                ((ViewGroup.MarginLayoutParams) ib.getLayoutParams()).rightMargin = 15;
                ((ViewGroup.MarginLayoutParams) ib.getLayoutParams()).leftMargin = 15;
            }
            sv.addView(tr);
        }
        ViewPager2 viewPager2;
        ViewPager2 viewPager3;
        TabLayout tablayout;

        viewPager2 = findViewById(R.id.viewPager2);
        viewPager3 = findViewById(R.id.viewPager3);
        Drawable d = getResources().getDrawable(R.drawable.swipe1);
        Drawable d1 = getResources().getDrawable(R.drawable.swipe2r);
        Drawable d2 = getResources().getDrawable(R.drawable.swipe3r);

        Drawable e = getResources().getDrawable(R.drawable.dotswipe1);
        Drawable e1 = getResources().getDrawable(R.drawable.dotswipe1);
        Drawable e2 = getResources().getDrawable(R.drawable.dotswipe1);

        ArrayList<DataPage> list = new ArrayList<>();
        list.add(new DataPage(android.R.color.black, d));
        list.add(new DataPage(android.R.color.holo_red_light, d1));
        list.add(new DataPage(android.R.color.holo_green_dark, d2));

        viewPager2.setAdapter(new ViewPagerAdapter(list));


        ArrayList<DataPage> list1 = new ArrayList<>();
        list1.add(new DataPage(android.R.color.black, e1));
        list1.add(new DataPage(android.R.color.holo_red_light, e1));
        list1.add(new DataPage(android.R.color.holo_green_dark, e2));

        viewPager3.setAdapter(new ViewPagerAdapter(list1));
        TabLayout tabLayout=findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout,
                viewPager3,
                (tab, position) -> tab.setIcon(getDrawable(R.drawable.selected_dot)

                )
        );
        tabLayoutMediator.attach();
        ProgressBar progressBar=findViewById(R.id.progress2);
        progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));

    }


    public void write(View view){

        final PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);
        getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {


            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_menu1){
                    startActivity(intent);
                }else if (menuItem.getItemId() == R.id.action_menu2){
                    Toast.makeText(MainActivity.this, "메뉴 2 클릭", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
        popupMenu.show();
    }

}

