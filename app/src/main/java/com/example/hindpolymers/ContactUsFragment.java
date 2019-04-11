package com.example.hindpolymers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ContactUsFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        TextView addressTextView = view.findViewById(R.id.tv_address);
        addressTextView.setText(getString(R.string.address_text));

        ImageView mapimageView = view.findViewById(R.id.iv_mapview);
        mapimageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String geoUri = "http://maps.google.co.in/maps?q=loc:" + 17.45725508400875 + "," + 78.4296494567397 + " (" + "Hind Polymers" + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                startActivity(intent);
            }

        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}
