package com.example.hindpolymers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GalleryGridViewAdapter extends RecyclerView.Adapter<imageViewHolder> {


    private Context context;
    private List<GalleryDataModel> imageList;


    GalleryGridViewAdapter(Context mContext, List imageList) {
        this.context = mContext;
        this.imageList = imageList;
    }

    @Override
    public imageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_recyclerview_items, parent, false);
          return new imageViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final imageViewHolder viewHolder, final int i) {
        viewHolder.image.setImageResource(imageList.get(i).getImaResId());
        //viewHolder.image.setImageResource(imageArray[i]);


        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageSliderFragment fragment = new ImageSliderFragment();
                Bundle args = new Bundle();

                args.putString("selectedImageId", String.valueOf(imageList.get(viewHolder.getAdapterPosition()).getImaResId()));
                //args.putString("Image", String.valueOf(imageArray[i]));
                fragment.setArguments(args);

                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();

            }
        });


    }





    @Override
    public int getItemCount() {
        return imageList.size();
    }
}

class imageViewHolder extends RecyclerView.ViewHolder {

    ImageView image;

    CardView cardView;

    imageViewHolder(View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.gallery_ImageView);

        cardView = itemView.findViewById(R.id.gallery_cardview);
    }

}