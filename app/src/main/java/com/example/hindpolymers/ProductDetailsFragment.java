package com.example.hindpolymers;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import static java.lang.Integer.getInteger;



public class ProductDetailsFragment extends Fragment {

    Toolbar toolbar;
    ImageView product;
    TextView description;


    public ProductDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_details, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        product = view.findViewById(R.id.ivImage);
        description = view.findViewById(R.id.tvDescription);
        String title = getArguments().getString("Title");
        int image = 0;
        //String desc = getArguments().getString("Description");
        /*if (getArguments().getString("image") != null){
            image = Integer.parseInt((getArguments().getString("image")));
        }*/


        /*Bundle mBundle = getActivity().getIntent().getExtras();*/
        if (!getArguments().isEmpty()) {
            if (toolbar != null)
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    toolbar.setTitle(title);
                }
            }

            product.setImageResource(getArguments().getInt("image"));
            ((TextView)description).setText(getArguments().getString("Description"));

        }
        return view;
    }


}
