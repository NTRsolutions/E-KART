package com.oms_infotech.www.e_kart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Himanshu on 10/20/2016.
 */
public class Accessories extends Fragment {
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> type=new ArrayList<>();
    ArrayList<String> price=new ArrayList<>();
    ArrayList<String> discount=new ArrayList<>();
    ArrayList<Integer> imgs=new ArrayList<>();
    ListView lv;
    public View view;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {



        name.add("Coolpad Note 3");
        name.add("Coolpad Mega");
        name.add("Coolpad Max");
        name.add("Letv 1s");
        name.add("Letv 2");
        name.add("Samsung Galaxy S6 edge");
        name.add("Samsung Galaxy J7");
        name.add("Samsung Galaxy J2");
        name.add("Xiaomi Mi Max");
        name.add("Redmi 1s");
        name.add("Redmi 2");
        name.add("Redmi 2 prime");
        name.add("Redmi 3s");
        name.add("Redmi note 3");

        type.add("by Coolpad");
        type.add("by Coolpad");
        type.add("by Coolpad");
        type.add("by LeTV");
        type.add("by LeTV");
        type.add("by Samsung");
        type.add("by Samsung");
        type.add("by Samsung");
        type.add("by Xiaomi");
        type.add("by Xiaomi");
        type.add("by Xiaomi");
        type.add("by Xiaomi");
        type.add("by Xiaomi");
        type.add("by Xiaomi");

        price.add("Rs. 9,000");
        price.add("Rs. 12,000");
        price.add("Rs.24,000");
        price.add("Rs. 10,000");
        price.add("Rs. 12,000");
        price.add("Rs. 24,000");
        price.add("Rs. 13,500");
        price.add("Rs. 7,800");
        price.add("Rs. 13,500");
        price.add("Rs.5,500");
        price.add("Rs.6,000");
        price.add("Rs.6,500");
        price.add("Rs.7,000");
        price.add("Rs.10,000");

        imgs.add(R.drawable.coolpadnote3);
        imgs.add(R.drawable.coolpadmega);
        imgs.add(R.drawable.coolpadmax);
        imgs.add(R.drawable.le2pro);
        imgs.add(R.drawable.le2pro);
        imgs.add(R.drawable.samsunggalaxyj72016);
        imgs.add(R.drawable.samsunggalaxyj72016);
        imgs.add(R.drawable.samsunggalaxyj72016);
        imgs.add(R.drawable.xiaomimimax);
        imgs.add(R.drawable.xiaomimimax);
        imgs.add(R.drawable.xiaomiredmi2);
        imgs.add(R.drawable.xiaomiredmi2);
        imgs.add(R.drawable.xiaomiredmi3s);
        imgs.add(R.drawable.xiaomiredminote3);

        discount.add("10% off");
        discount.add("12% off");
        discount.add("9% off");
        discount.add("14% off");
        discount.add("20% off");
        discount.add("31% off");
        discount.add("25% off");
        discount.add("10% off");
        discount.add("15% off");
        discount.add("13% off");
        discount.add("21% off");
        discount.add("12% off");
        discount.add("35% off");
        discount.add("15% off");

        view = inflater.inflate(R.layout.accessories, container, false);
        lv=(ListView)view.findViewById(R.id.listView4);
        lv.setAdapter(new CustomAdapter(this.getContext(),name,type,price,discount,imgs));
        return view;
    }
}
