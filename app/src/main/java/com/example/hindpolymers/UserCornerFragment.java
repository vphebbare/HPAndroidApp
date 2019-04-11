package com.example.hindpolymers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserCornerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserCornerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserCornerFragment extends Fragment {


    public UserCornerFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user_corner, container, false);
        TextView textView = view.findViewById(R.id.tv_usercorner);
        textView.setText(getString(R.string.user_corner_text));
        return view;
    }


}
