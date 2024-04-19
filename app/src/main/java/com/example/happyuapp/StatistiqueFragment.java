package com.example.happyuapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class StatistiqueFragment extends Fragment {

    private Button click;
    private PieChart chart;
    private int i1 = 15;
    private int i2 = 25;
    private int i3 = 35;
    private int i4 = 45;


    public StatistiqueFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistique, container, false);

        click = view.findViewById(R.id.btn_click);
        chart = view.findViewById(R.id.pie_chart);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToPieChart();
            }
        });

        return view;
    }

    private void addToPieChart() {
        // add to pie chart
        chart.addPieSlice(new PieModel("Integer 1", i1, Color.parseColor("#FCFE19")));
        chart.addPieSlice(new PieModel("Integer 2", i2, Color.parseColor("#47EAD0")));
        chart.addPieSlice(new PieModel("Integer 3", i3, Color.parseColor("#FE277E")));
        chart.addPieSlice(new PieModel("Integer 4", i4, Color.parseColor("#CE8F8A")));

        chart.startAnimation();
        click.setClickable(false);
    }
}
