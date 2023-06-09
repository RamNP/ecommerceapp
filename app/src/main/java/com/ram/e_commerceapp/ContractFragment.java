package com.ram.e_commerceapp;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;




public class ContractFragment extends Fragment {

    private  View view;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etSubject;
    private EditText etDesc;

    ImageView btnCall;

    ImageButton btn_email;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view=inflater.inflate(R.layout.fragment_contract, container, false);
          return view;
    }
    @Override
    public void onViewCreated (@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etEmail = view.findViewById(R.id.etEmail);
        etSubject = view.findViewById(R.id.etSubject);
        etDesc = view.findViewById(R.id.etDesc);

        etPhone = view.findViewById(R.id.etPhone);
        btnCall = view.findViewById(R.id.btn_call);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = etPhone.getText().toString().trim();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+call));
                startActivity(callIntent);
            }
        });
        btn_email = view.findViewById(R.id.btn_email);
        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = etEmail.getText().toString().trim();
                String Subject = etSubject.getText().toString().trim();
                String Message  = etDesc.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {to});
                intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
                intent.putExtra(Intent.EXTRA_TEXT,Message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose and email client "));
            }
        });
    }
}