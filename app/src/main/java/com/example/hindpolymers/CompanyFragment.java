package com.example.hindpolymers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class CompanyFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);



    }


    public CompanyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Log.v("Inside","Inside oncreateView");

        View view = inflater.inflate(R.layout.fragment_company, container, false);
        WebView webView = view.findViewById(R.id.textContent);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(getResources().getColor(R.color.colorGrey));
        /*String text;
        text = "<html><body><p align=\"justify\">";
        text+= getString(R.string.company_text);
        text+= "</p></body></html>";
        webView.loadData(text, "text/html", "utf-8");
        Log.v("html",text);*/
        webView.loadUrl("file:///android_asset/company.html");
        return view;

    }

    /*@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }*/
}
