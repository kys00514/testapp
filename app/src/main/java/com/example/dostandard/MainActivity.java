package com.example.dostandard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
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
        ListPopupWindow mList;
        public String[] Colors={
          "인증 글쓰기","피드 글쓰기"
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
         intent=new Intent(this,writeActivity.class);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height1 = displayMetrics.heightPixels;
        int width1 = displayMetrics.widthPixels;
        int cdp=pxToDp(height1);
        int cdp1=pxToDp(width1);
        Configuration configuration = this.getResources().getConfiguration();
        int screenWidthDp = configuration.screenHeightDp; //The current width of the available screen space, in dp units, corresponding to screen width resource qualifier.
        int smallestScreenWidthDp = configuration.smallestScreenWidthDp;
        String dd1=screenWidthDp+ " "+smallestScreenWidthDp;
        Log.v("asdf",dd1);

        String a=Integer.toString(cdp);
        String b=Integer.toString(cdp1);
        String c=a+" "+b;

        Log.v("metrics112",c);
        TableLayout sv = (TableLayout) findViewById(R.id.categoryLinearLayout1);

        for (int i = 0; i < 2; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < 2; j++) {
                ImageButton ib = new ImageButton(this);
                ib.setBackgroundColor(getColor(R.color.white));

                Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                        R.drawable.list1);;
                if(i==0 && j==0) {
                     bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.list1);
                }
                if(i==0 && j==1) {
                    bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.list3);
                }
                if(i==1 && j==0) {
                     bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.list2);
                }
                if(i==1 && j==1) {
               bmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.list4);
                }
                float dp=180;
                int aa=dpToPx(dp,this);
                int width = 500;
                int height = 500;
                Bitmap resizedbitmap = Bitmap.createScaledBitmap(bmp, aa,
                        aa, true);
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
        ImageView img= findViewById(R.id.menu);
        mList=new ListPopupWindow(this);
        mList.setWidth(400);


        intent= new Intent(this,writeActivity.class);
        mList.setAnchorView(img);






        //mList.setAdapter(adapter);
        mList.setAdapter(new ArrayAdapter<String>(this,R.layout.menus,Colors));
        mList.setModal(true);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:

                       startActivity(intent);
                        break;
                    case 1:
                        Log.v("hi1","hi1");
                        break;

                }
            }
        });


    }


    public void write(View view){
       if(mList.isShowing()){
       mList.dismiss();
       }
       else{
           mList.show();
       }
    }
    public int dpToPx(float dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
    public int pxToDp(int px) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

}

