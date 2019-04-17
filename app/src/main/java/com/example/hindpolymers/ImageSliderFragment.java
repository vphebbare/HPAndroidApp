package com.example.hindpolymers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;


public class ImageSliderFragment extends Fragment {

    Context context;
    public ImageSliderFragment() {
        // Required empty public constructor
    }

    int[] images = {R.drawable.gallery_hp_battery_cut_shrink_sleeve_2,R.drawable.gallery_hp_battery_grade_shrink_sleeve,R.drawable.gallery_hp_battery_grade_shrink_sleeve_1
            ,R.drawable.gallery_hp_busbar_grade_shrink_sleeve,R.drawable.gallery_hp_busbar_grade_shrink_sleeve_1,R.drawable.gallery_hp_busbar_grade_shrink_sleeve_2,R.drawable.gallery_hp_capacitor_grade_shrink_sleeve,
            R.drawable.gallery_hp_capacitor_grade_shrink_sleeve_1,R.drawable.gallery_hp_capacitor_grade_shrink_sleeve_2,
            R.drawable.gallery_hp_cob_web_remover_handle_shrink_sleeve,R.drawable.gallery_hp_combo_pack_shrink_sleeve,R.drawable.gallery_hp_full_body_shrink_sleeve,
                R.drawable.gallery_hp_gas_valve_shrink_sleeves,R.drawable.gallery_hp_gas_valve_shrink_sleeves_1,R.drawable.gallery_hp_gas_valve_shrink_sleeves_2,
            R.drawable.gallery_hp_micro_fiber_mop_handle_shrink_sleeve,R.drawable.gallery_hp_mop_handle_shrink_sleeve,R.drawable.gallery_hp_multipack_shrink_sleeve,
            R.drawable.gallery_hp_plunger_shrink_sleeve,R.drawable.gallery_hp_profile_cut_shrink_pouch,R.drawable.gallery_hp_profilecut_shrink_pouce_application,
            R.drawable.gallery_hp_promotional_pack_shrink_sleeve,R.drawable.gallery_hp_straight_cut_shrink_pouches,R.drawable.gallery_hp_tamper_evident_head_band,
            R.drawable.gallery_hp_tranperant_shrink_rolls,R.drawable.gallery_hp_transculent_shrink_rolls,R.drawable.gallery_hp_transperant_shrink_roll_application,R.drawable.gallery_hp_full_body_shrink_sleeve_1,
            R.drawable.gallery_hp_twist_mop_handle_shrink_sleeves,R.drawable.gallery_hp_wiper_rod_shrink_sleeve};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String selectedImageResId = getArguments().getString("selectedImageId");
        int selectedImageIndex = 0;

        for (int i = 0; i < images.length; i++) {
            if (images[i] == Integer.parseInt(selectedImageResId)) {
                selectedImageIndex = i;
                break;
            }
        }
        Log.v("abcde", selectedImageResId);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_slider, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.imageSlider_viewpager);
        ImageSliderAdapter adapterView = new ImageSliderAdapter(getContext(), images);
        viewPager.setAdapter(adapterView);
        viewPager.setCurrentItem(selectedImageIndex);
        return  view;
    }



}
