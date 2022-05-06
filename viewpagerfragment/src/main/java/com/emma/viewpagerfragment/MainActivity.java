package com.emma.viewpagerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager2 viewPager;
    private LinearLayout tab_ressource, tab_depense;
    //保存当前页面
    private ImageView tab_ressource_img, tab_depense_img,currentImage;
    String data;
    String fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // recevoir le date  de Ressource Fragment
        Intent intent = getIntent();
        data = intent.getStringExtra("date");
        fragment = intent.getStringExtra("fragment");
        System.out.println("activity date choisi "+data);
        System.out.println("activity fragment :"+fragment);
        //traiter UI
        initTabView();
        //initialiser ViewPger2
        initPager(data,fragment);

    }

    private void initTabView() {
        tab_depense = findViewById(R.id.tab_depense);
        tab_ressource= findViewById(R.id.tab_ressource);

        //Listener tous les pages
        tab_depense.setOnClickListener(this);
        tab_ressource.setOnClickListener(this);


        tab_depense_img = findViewById(R.id.tab_depense_img);
        tab_ressource_img = findViewById(R.id.tab_ressource_img);

        tab_ressource_img.setSelected(true);
        currentImage = tab_ressource_img;
    }

    @SuppressLint("ResourceType")
    private void initPager(String data, String fragment) {
        viewPager = findViewById(R.id.viewPager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        RessourceFragment ressourceFragment = RessourceFragment.newInstance("resource");
        DepenseFragment depenseFragment = DepenseFragment.newInstance("depense");

        System.out.println(fragment + " fragement in initPager");

        fragments.add(ressourceFragment);
        fragments.add(depenseFragment);

        //adapter
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),
                fragments);
        viewPager.setAdapter(pagerAdapter);

        if(data != null && fragment.equals("ressource")){
            ressourceFragment.madate = data;
            viewPager.setCurrentItem(0);
        }else if(data != null && fragment.equals("depense")){
            //todo:rester dans la meme page
            // trouver pas R.id.depense_fragment, R.layout.fragment_depense

            // ViewPager2 does not support direct child views
            // never add frogment directely on viewPger2
            /*
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.viewPager,new DepenseFragment())
                    .addToBackStack(null).commit();
            */
            viewPager.setCurrentItem(1);
            tab_depense_img.setSelected(true);
            tab_ressource_img.setSelected(false);
            currentImage = tab_depense_img;
            //donner la date
            depenseFragment.madateDes = data;

        }

        //Listener de change pages
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        currentImage.setSelected(false);
        switch (position){
            //case R.id.tab_wechat: 是为了 public void onClick(View view)增加的
            //   case 0: 是为了 public void onPageSelected(int position) {
            case R.id.tab_ressource:
                viewPager.setCurrentItem(0);
            case 0:
                tab_ressource_img.setSelected(true);
                currentImage = tab_ressource_img;
                break;
            case R.id.tab_depense:
                viewPager.setCurrentItem(1);
            case 1:
                tab_depense_img.setSelected(true);
                currentImage = tab_depense_img;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();
        if(fragment.equals("depense")){
            DepenseFragment depenseF = new DepenseFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.viewPager,depenseF).commit();

        }
    }

     */
}