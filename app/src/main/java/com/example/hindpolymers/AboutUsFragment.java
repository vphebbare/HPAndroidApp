package com.example.hindpolymers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        WebView webView = view.findViewById(R.id.wv_about_us);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(getResources().getColor(R.color.colorGrey));
        String text;
        text = "<html><body><p align=\"justify\">";
        text+= getString(R.string.aboutus_html_text);
        text+= "</p></body></html>";
        webView.loadData(text, "text/html", "utf-8");



        return view;
    }


}
