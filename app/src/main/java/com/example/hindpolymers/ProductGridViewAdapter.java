package com.example.hindpolymers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class ProductGridViewAdapter  extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private List<ProductDataModel> productList;

    ProductGridViewAdapter(Context mContext, List<ProductDataModel> productList) {
        this.context = mContext;
        this.productList = productList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview__row_item, parent, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.image.setImageResource(productList.get(position).getProdcutImage());
        holder.title.setText(productList.get(position).getProductName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductDetailsFragment fragment = new ProductDetailsFragment();
                Bundle args = new Bundle();
                args.putString("Title", productList.get(holder.getAdapterPosition()).getProductName());
                args.putString("Description", productList.get(holder.getAdapterPosition()).getProductDescription());
                args.putString("Image", String.valueOf(productList.get(holder.getAdapterPosition()).getProdcutImage()));
                fragment.setArguments(args);

                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragment_placeholder, fragment).commit();
                /*Intent mIntent = new Intent(context, ProductDetailsFragment.class);
                mIntent.putExtra("Title", productList.get(holder.getAdapterPosition()).getProductName());
                mIntent.putExtra("Description", productList.get(holder.getAdapterPosition()).getProductDescription());
                mIntent.putExtra("Image", productList.get(holder.getAdapterPosition()).getProdcutImage());
                context.startActivity(mIntent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView title;
    CardView cardView;

    ViewHolder(View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.ivImage);
        title = itemView.findViewById(R.id.tvTitle);
        cardView = itemView.findViewById(R.id.cardview);
    }

}
