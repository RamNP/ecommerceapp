package com.ram.e_commerceapp;
import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ram.e_commerceapp.R;

import org.w3c.dom.Text;


public class ProfileFragment extends Fragment {

    private ImageView btn_camera;
    TextView btnInfo;
    private Uri ImageUrl;
    private  View viewProfile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewProfile = inflater.inflate(R.layout.fragment_profile, container, false);
        return  viewProfile;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnInfo = viewProfile.findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PersonalActivity.class));
                getParentFragment().onDestroy();
//                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.container1, personalInfo).commit();
            }
        });
        btn_camera = viewProfile.findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {

                        Intent intent = new Intent();
                        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {

                        e.printStackTrace();
                    }
                }


        });
    }
//    public void takePictureFromGallery() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, 1);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
//            ImageUrl = data.getData();
//            btn_camera.setImageURI(ImageUrl);
//        } else {
//            assert data != null;
//            Bitmap bitmap = (Bitmap) (data.getExtras().get("data"));
//            btn_camera.setImageBitmap(bitmap);
//        }
//    }

}