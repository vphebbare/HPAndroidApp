package com.example.hindpolymers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerDataModel> {






        public NavigationDrawerAdapter(Context mContext, int layoutResourceId, NavigationDrawerDataModel[] data) {

            super(mContext, 0, data);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View listItem = convertView;

            if (listItem == null) {
                listItem = LayoutInflater.from(getContext()).inflate(
                        R.layout.nav_drawer_list_items, parent, false);
            } else
                listItem = convertView;

            final NavigationDrawerDataModel currentRow = getItem(position);
            ImageView imageViewIcon = listItem.findViewById(R.id.imageViewIcon);
            imageViewIcon.setImageResource(currentRow.getDrawerListItemIcon());
            TextView textViewName = listItem.findViewById(R.id.textViewName);
            textViewName.setText(currentRow.getDrawerListItemName());


            return listItem;
        }
    }

