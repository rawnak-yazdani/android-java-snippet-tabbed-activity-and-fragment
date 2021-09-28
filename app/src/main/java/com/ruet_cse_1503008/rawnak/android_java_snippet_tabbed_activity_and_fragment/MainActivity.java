package com.ruet_cse_1503008.rawnak.android_java_snippet_tabbed_activity_and_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    //    ViewPager2 pager2;
    private ViewPager2 viewPager;
//    FragmentAdapter adapter;

    FirstFragment withoutCreditGpaFragment;
    //    EditGradesFragment withoutCreditAllPassing;
    SecondFragment usingCreditGpaFragment;
    ThirdFragment editGradesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
//        pager2 = findViewById(R.id.view_pager2);
        viewPager = findViewById(R.id.view_pager2);
        viewPager.setPageTransformer(new ZoomOutPageTransformer());
        viewPager.setUserInputEnabled(false);

//        FragmentManager fm = getSupportFragmentManager();
//        adapter = new FragmentAdapter(fm, getLifecycle());
//        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("First"));
        tabLayout.addTab(tabLayout.newTab().setText("Second"));
        tabLayout.addTab(tabLayout.newTab().setText("Third"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
//                tabLayout.selectTab(tabLayout.getTabAt(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }

//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//            }
        });

        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager2 viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        withoutCreditGpaFragment = new FirstFragment();
        usingCreditGpaFragment = new SecondFragment();
        editGradesFragment = new ThirdFragment();
//        withoutCreditAllPassing =new EditGradesFragment();
//        contactsFragment=new ContactsFragment();
        adapter.addFragment(withoutCreditGpaFragment);
        adapter.addFragment(usingCreditGpaFragment);
        adapter.addFragment(editGradesFragment);
//        adapter.addFragment(contactsFragment);
        viewPager.setAdapter(adapter);
    }
}