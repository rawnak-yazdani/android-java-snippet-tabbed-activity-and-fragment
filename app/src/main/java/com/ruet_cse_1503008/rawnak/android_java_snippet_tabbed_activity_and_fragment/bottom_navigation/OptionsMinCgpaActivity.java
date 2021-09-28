package com.ruet_cse_1503008.rawnak.android_java_snippet_tabbed_activity_and_fragment.bottom_navigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ruet_cse_1503008.rawnak.android_java_snippet_tabbed_activity_and_fragment.R;
import com.ruet_cse_1503008.rawnak.android_java_snippet_tabbed_activity_and_fragment.ViewPagerAdapter;
import com.ruet_cse_1503008.rawnak.android_java_snippet_tabbed_activity_and_fragment.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

//import androidx.viewpager.widget.ViewPager;
//import com.rawnak.snippet_bottom_navigation_viewpager2.Fragment.ContactsFragment;

public class OptionsMinCgpaActivity extends AppCompatActivity {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Settings handle
//
//    int themeFlag = 0;
////    TextView textView;
////    Button button;
//
//    LinearLayout layoutParent1;
//    LinearLayout layoutOfBar;
//    LinearLayout layoutDisplay;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    BottomNavigationView bottomNavigationView;

    //This is our viewPager
//    private ViewPager viewPager;
    private ViewPager2 viewPager;

//    private TextView textViewCgpa;
//    private TextView textViewCreditCompleted;

//    DatabaseHelper myDb;

    //Fragments

    WithoutCreditMinCgpaFragment withoutCreditMinCgpaFragment;
    UsingCreditMinCgpaFragment usingCreditMinCgpaFragment;
    //    ContactsFragment contactsFragment;
    MenuItem prevMenuItem;

    List<String> allStringSemesterTableName = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_min_cgpa);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        textViewCgpa = findViewById(R.id.textViewCgpa);
//        textViewCreditCompleted = findViewById(R.id.textViewCreditCompleted);

        //Initializing viewPager
        viewPager = (ViewPager2) findViewById(R.id.viewpager);
        viewPager.setPageTransformer(new ZoomOutPageTransformer());
        viewPager.setUserInputEnabled(false);

//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.using_credit:
                        viewPager.setCurrentItem(0);
//                            return true;
                        break;
                    case R.id.without_credit:
                        viewPager.setCurrentItem(1);
//                            return true;
                        break;
                }
                return false;
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.using_credit).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.without_credit).setChecked(true);
                        break;
                }
            }
        });
//
        setupViewPager(viewPager);


        final View activityRootView = findViewById(R.id.activityRoot);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(getApplicationContext(), 200)) { // if more than 200 dp, it's probably a keyboard...
                    // ... do something here
                    bottomNavigationView.setVisibility(View.GONE);
//                    bottomNavigationView.setVisibility(View.INVISIBLE);

                }
                else{
                    bottomNavigationView.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    private void setupViewPager(ViewPager2 viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        usingCreditMinCgpaFragment =new UsingCreditMinCgpaFragment();
        withoutCreditMinCgpaFragment =new WithoutCreditMinCgpaFragment();
//        contactsFragment=new ContactsFragment();
        adapter.addFragment(usingCreditMinCgpaFragment);
        adapter.addFragment(withoutCreditMinCgpaFragment);
//        adapter.addFragment(contactsFragment);
        viewPager.setAdapter(adapter);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}