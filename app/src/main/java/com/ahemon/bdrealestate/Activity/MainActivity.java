package com.ahemon.bdrealestate.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahemon.bdrealestate.Adapter.ItemsAdapter;
import com.ahemon.bdrealestate.Domain.PropertyDomain;
import com.ahemon.bdrealestate.R;
import com.ahemon.bdrealestate.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterRecommend,adapterNearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initLocation();
        initList();
    }

    private void initList() {
        ArrayList<PropertyDomain> items=new ArrayList<>();
        items.add(new PropertyDomain("Apartment","Royal Apartment","Banasree, DHAKA","house_1",1500,2,3,350,true,4.5,"This 2 bed /1 bath"));
        items.add(new PropertyDomain("House","Royal House","Banasree, DHAKA","house_2",1500,2,3,350,false,4.9,"This 2 bed /1 bath"));
        items.add(new PropertyDomain("Villa","Royal Villa","Banasree, Cumilla","house_3",1500,2,3,350,true,4.7,"This 2 bed /1 bath"));
        items.add(new PropertyDomain("House","Beauty Apartment","Banasree, DHAKA","house_4",1500,2,3,350,true,4.3,"This 2 bed /1 bath"));
        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recommendedView.setAdapter(new ItemsAdapter(items));


        ArrayList<PropertyDomain> itemsNear=new ArrayList<>();
        itemsNear.add(new PropertyDomain("Apartment","Royal Apartment","Banasree, DHAKA","house_4",1500,2,3,350,true,4.5,"This 2 bed /1 bath"));
        itemsNear.add(new PropertyDomain("House","Royal House","Banasree, DHAKA","house_3",1500,2,3,350,false,4.9,"This 2 bed /1 bath"));
        itemsNear.add(new PropertyDomain("Villa","Royal Villa","Banasree, Cumilla","house_2",1500,2,3,350,true,4.7,"This 2 bed /1 bath"));
        itemsNear.add(new PropertyDomain("House","Beauty Apartment","Banasree, DHAKA","house_1",1500,2,3,350,true,4.3,"This 2 bed /1 bath"));
        binding.nearView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.nearView.setAdapter(new ItemsAdapter(itemsNear));

    }

    private void initLocation(){
        String[] items=new String[]{"Dhaka, BD","Cumilla, BD"};
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.locationSpin.setAdapter(adapter);
    }
}