package com.smallwei.firstprogect.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smallwei.firstprogect.R;

public class News extends Fragment {

    public News() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView= (TextView) view.findViewById(R.id.text_flag);
        Bundle arguments = getArguments();
        String name = arguments.getString("text");
        textView.setText(name);
    }
}
