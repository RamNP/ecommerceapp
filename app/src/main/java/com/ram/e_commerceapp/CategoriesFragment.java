package com.ram.e_commerceapp;

import android.app.Fragment;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ram.e_commerceapp.features.post.CategoriesAdapter;
import com.ram.e_commerceapp.features.post.CategoriesContract;
import com.ram.e_commerceapp.features.post.CategoriesPresenter;
import com.ram.e_commerceapp.features.post.helper.CategoriesPojo;
import com.ram.e_commerceapp.features.post.helper.ImagePojo;

import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment implements CategoriesContract.View {

    RecyclerView rvCategories;
    View view;
    CategoriesAdapter categoriesAdapter;
    EditText tvSearch;
    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate(R.layout.fragment_categories, container, false);
        return view;
    }

    public  void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        rvCategories = view.findViewById(R.id.rvCategories);
        CategoriesPresenter categoriesPresenter = new CategoriesPresenter(this,getActivity());
        categoriesPresenter.onCreate();
        tvSearch = view.findViewById(R.id.tvSearch);
        // Set up click listener for the search button and perform a Google search
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSearch("Categories");

            }
        });

    }

    /*
     * This method sets up a RecyclerView to display a list of categories, along with corresponding images.
     * The RecyclerView is populated with data obtained from a CategoriesPojo object.
     * An ArrayList of ImagePojo objects is also created and passed to the CategoriesAdapter.
     * Finally, the adapter is set to the RecyclerView along with a LinearLayoutManager.
     */

    @Override
    public void setPost(@NonNull CategoriesPojo body) {
        RecyclerView rvCategories = view.findViewById(R.id.rvCategories);
        ArrayList<ImagePojo> arrayList = new ArrayList<>();
        arrayList.add(new ImagePojo(R.mipmap.rc_car));
        arrayList.add(new ImagePojo(R.mipmap.rc_drone));
        arrayList.add(new ImagePojo(R.mipmap.rc_boat));
        arrayList.add(new ImagePojo(R.mipmap.rc_airplane));
        CategoriesAdapter adapter = new CategoriesAdapter(getActivity(), body.getResult().getResultList().getCategoryList(), arrayList);
        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getActivity()));
        rvCategories.setAdapter(adapter);
        rvCategories.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void showSuccessfulMessage(boolean show) {

    }

    @Override
    public void setPosts(CategoriesPojo body) {

    }

    @Override
    public void showErrorMessage(String error) {

    }
    private void googleSearch(String searchText) {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, searchText);
            startActivity(intent);
        } catch (Exception ex) {
            ex.printStackTrace();
            googleSearch(searchText); // recall the methods
        }
    }

}