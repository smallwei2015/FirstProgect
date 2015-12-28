package com.smallwei.firstprogect.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smallwei.firstprogect.R;
import com.smallwei.firstprogect.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class Thing_fragment extends Fragment {

    private ViewPager viewPager;
    MyAdapter adapter;
    TabLayout tabLayout;

    public Thing_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thing_fragment, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        List<String> names=new ArrayList<>();
        names.add("专享");
        names.add("视频");
        names.add("文章");
        names.add("图片");
        names.add("精华");
        names.add("最新");
        names.add("最爱");
        names.add("评分");

        adapter=new MyAdapter(getChildFragmentManager(),names);
        viewPager.setAdapter(adapter);

        tabLayout= (TabLayout) view.findViewById(R.id.tabView);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


}
