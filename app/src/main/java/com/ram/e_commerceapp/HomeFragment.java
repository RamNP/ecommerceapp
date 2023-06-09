package com.ram.e_commerceapp;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ram.e_commerceapp.features.home.ProductAdapter;
import com.ram.e_commerceapp.features.home.ProductsAdapter;
import com.ram.e_commerceapp.features.home.ProductPojo;
import com.ram.e_commerceapp.features.home.ProductsPojo;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    // create the arraylist

    ArrayList<ProductPojo> arrAppContacts;
    ArrayList<ProductsPojo> Arraylist;
    RecyclerView recyclerView;

    RecyclerView recyclerView1;

    private  View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return view = inflater.inflate(R.layout.fragment_home, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerAppContener); // initialize the variable find by id
         recyclerView1 = view.findViewById(R.id.recyclerAppContener1);

//         used the divider


        arrAppContacts = new ArrayList<>();
        arrAppContacts.add(new ProductPojo(R.mipmap.product20, "HeadPhone", "Rs.500"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product21, "Name", "Rs.69999"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product22, "Name ", "Rs.500"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product23, "Name", "Rs.1500 "));
        arrAppContacts.add(new ProductPojo(R.mipmap.product24, "Name", " Rs.4500"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product25, "Name ", "Rs.5199"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product26, "Name", "Rs. 1600"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product27, "Name", "Rs.899"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product28, "Name", "Rs.550"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product29, "Name", "Rs.405 "));
        arrAppContacts.add(new ProductPojo(R.mipmap.product30, "Name", "Rs.799"));
        arrAppContacts.add(new ProductPojo(R.mipmap.product31, "Name", "Rs.555 "));
        arrAppContacts.add(new ProductPojo(R.mipmap.product32, "Name", "Rs.892 "));
        arrAppContacts.add(new ProductPojo(R.mipmap.product33, "Name", "Rs.666 "));
        arrAppContacts.add(new ProductPojo(R.mipmap.product34, "Name", "Rs.166 "));
        arrAppContacts.add(new ProductPojo(R.mipmap.product35, "Name", "Rs.666 "));
        arrAppContacts.add(new ProductPojo(R.mipmap.product36, "Name", "Rs.1199 "));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ProductAdapter adapter = new ProductAdapter(this, arrAppContacts);
        recyclerView.setAdapter(adapter);



        Arraylist = new ArrayList<>();
        Arraylist.add(new ProductsPojo(R.mipmap.product1, "Name", "$400"));
        Arraylist.add(new ProductsPojo(R.mipmap.product2, "Name", "$408"));
        Arraylist.add(new ProductsPojo(R.mipmap.product3, "Name ", "$4"));
        Arraylist.add(new ProductsPojo(R.mipmap.product4, "Name", "$866"));
        Arraylist.add(new ProductsPojo(R.mipmap.product5, "Name", "$494"));
        Arraylist.add(new ProductsPojo(R.mipmap.product6, "Name ", "$900"));
        Arraylist.add(new ProductsPojo(R.mipmap.product7, "Name", "$546"));
        Arraylist.add(new ProductsPojo(R.mipmap.product9, "Name", "$890"));
        Arraylist.add(new ProductsPojo(R.mipmap.product10, "Name", "$899"));
        Arraylist.add(new ProductsPojo(R.mipmap.product11, "Name", "$80"));
        Arraylist.add(new ProductsPojo(R.mipmap.product13, "Name", "$900"));
        Arraylist.add(new ProductsPojo(R.mipmap.product14, "Name", "$638"));
        Arraylist.add(new ProductsPojo(R.mipmap.product14, "Name", "$787"));
        Arraylist.add(new ProductsPojo(R.mipmap.product15, "Name", "$878"));
        Arraylist.add(new ProductsPojo(R.mipmap.product16, "Name", "$987"));
        Arraylist.add(new ProductsPojo(R.mipmap.product17, "Name", "$78"));
        Arraylist.add(new ProductsPojo(R.mipmap.product18, "Name", "$33"));
        Arraylist.add(new ProductsPojo(R.mipmap.product19, "Name", "$65"));

     //LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(gridLayoutManager);
        ProductsAdapter adapter1 = new ProductsAdapter(this, Arraylist);
        recyclerView1.setAdapter(adapter1);
    }
}