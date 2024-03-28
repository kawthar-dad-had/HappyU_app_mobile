package com.example.happyuapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MoodFragment extends Fragment {

    public MoodFragment() {
        // Required empty public constructor
    }

    public static MoodFragment newInstance() {
        return new MoodFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mood, container, false);

        // Vous pouvez ajouter des écouteurs d'événements sur les RadioGroups pour réagir aux sélections de l'utilisateur
        RadioGroup radioGroup2 = view.findViewById(R.id.answersGroup2);

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Vous pouvez gérer la réponse de l'utilisateur ici
                RadioButton selectedRadioButton = view.findViewById(checkedId);
                String response = selectedRadioButton.getText().toString();
                // Affichez la réponse avec un Toast, par exemple
                Toast.makeText(getActivity(), "Vous avez sélectionné : " + response, Toast.LENGTH_SHORT).show();
            }
        });

        // Répétez pour les autres groupes de réponses
        RadioGroup radioGroup3 = view.findViewById(R.id.answersGroup3);
        RadioGroup radioGroup4 = view.findViewById(R.id.answersGroup4);
        RadioGroup radioGroup5 = view.findViewById(R.id.answersGroup5);
        RadioGroup radioGroup6 = view.findViewById(R.id.answersGroup6);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Here you can perform any additional setup for your fragment
    }
}
