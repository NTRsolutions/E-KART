package com.oms_infotech.www.e_kart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Himanshu on 10/24/2016.
 */
public class CustomAdapter extends BaseAdapter{
    ArrayList<String> nameid=new ArrayList<>();
    ArrayList<String> typeid=new ArrayList<>();
    ArrayList<String> priceid=new ArrayList<>();
    ArrayList<String> discountid=new ArrayList<>();
    ArrayList<Integer> imgsid=new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<String> name, ArrayList<String> type, ArrayList<String> price, ArrayList<String> discount,ArrayList<Integer> imgs)
    {
        nameid=name;
        typeid=type;
        priceid=price;
        discountid=discount;
        imgsid=imgs;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public class Holder
    {
        TextView tvname;
        TextView tvtype;
        TextView tvprice;
        TextView tvdiscount;
        ImageView ivimgs;
    }
    @Override
    public int getCount() {
        return nameid.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder=new Holder();
        view=inflater.inflate(R.layout.model,null);

        holder.tvname=(TextView)view.findViewById(R.id.textView8);
        holder.tvtype=(TextView)view.findViewById(R.id.textView9);
        holder.tvprice=(TextView)view.findViewById(R.id.textView11);
        holder.tvdiscount=(TextView)view.findViewById(R.id.textView10);
        holder.ivimgs=(ImageView)view.findViewById(R.id.imageView2);

        holder.tvname.setText(nameid.get(i));
        holder.tvtype.setText(typeid.get(i));
        holder.tvprice.setText(priceid.get(i));
        holder.tvdiscount.setText(discountid.get(i));
        holder.ivimgs.setImageResource(imgsid.get(i));

        return view;
    }
}
