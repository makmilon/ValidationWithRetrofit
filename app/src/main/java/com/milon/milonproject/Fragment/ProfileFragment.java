package com.milon.milonproject.Fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.milon.milonproject.Adapter.adapter;
import com.milon.milonproject.Model.MainDataClass;
import com.milon.milonproject.Model.ObjectDataClass;
import com.milon.milonproject.R;
import com.milon.milonproject.Retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    adapter newAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Movie");



        recyclerView=view.findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Call<MainDataClass> call=
                RetrofitInstance.getInstance().apiInterface.getData("59d66de22e2db508042945cb854e9144");
        call.enqueue(new Callback<MainDataClass>() {
            @Override
            public void onResponse(Call<MainDataClass> call, Response<MainDataClass> response) {

                if (response.isSuccessful()){
                    List<ObjectDataClass> objectList= response.body().getData();
                    for (int i=0; i<objectList.size(); i++){

                        newAdapter= new adapter((ArrayList<ObjectDataClass>) objectList);
                        recyclerView.setAdapter(newAdapter);
                        newAdapter.notifyDataSetChanged();


                    }
                }
            }

            @Override
            public void onFailure(Call<MainDataClass> call, Throwable t) {

            }
        });

        return view;
    }
}