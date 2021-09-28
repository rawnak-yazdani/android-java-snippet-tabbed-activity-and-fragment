package com.ruet_cse_1503008.rawnak.android_java_snippet_tabbed_activity_and_fragment.bottom_navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruet_cse_1503008.rawnak.android_java_snippet_tabbed_activity_and_fragment.R;

public class UsingCreditMinCgpaFragment extends Fragment {

    public UsingCreditMinCgpaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_using_credit_min_cgpa, container, false);

        return root;
    }
}