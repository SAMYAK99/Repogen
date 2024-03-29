package com.projects.anticovid_19.Precautions;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.projects.anticovid_19.R;

import java.util.ArrayList;
import java.util.List;


public class Precaution extends Fragment {

    View view;
    private RecyclerView precRecycler;
    private List<PrecautionsModel> precList = new ArrayList<>();
    private String[] titles;
    private String[] contents;
    private String[] whyContents;

    public Precaution() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_precaution, container, false);
        init();

        return view;
    }

    private void init() {
        initElements();
    }

    private void initElements() {
        precRecycler = view.findViewById(R.id.precRecycler);
        titles = PrecautionContent.getTitles();
        contents = PrecautionContent.getContents();
        whyContents = PrecautionContent.getWhyContents();

        for (int i = 0; i < titles.length; i++) {
            precList.add(new PrecautionsModel(titles[i], contents[i], whyContents[i]));
        }
        precRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        precRecycler.setAdapter(new PrecautionAdapter(getActivity(), precList));
    }

}

