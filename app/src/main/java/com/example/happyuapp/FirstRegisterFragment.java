package com.example.happyuapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstRegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstRegisterFragment extends Fragment {

    EditText emailEdit, passwordEdit, passwordConfirmationEdit;
    Button suivantBtn, registerButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstRegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstRegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstRegisterFragment newInstance(String param1, String param2) {
        FirstRegisterFragment fragment = new FirstRegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first_register, container, false);
        emailEdit = view.findViewById(R.id.adresse_mail_edit_text);
        passwordEdit = view.findViewById(R.id.mot_de_passe_edit_text);
        passwordConfirmationEdit = view.findViewById(R.id.confirmation_de_mot_de_passe_edit_text);
        suivantBtn = view.findViewById(R.id.suivant_btn);
        registerButton = view.findViewById(R.id.register_button);

        suivantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with the SecondRegisterFragment
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.firstFragment, new SecondRegisterFragment())
                        .addToBackStack(null) // Optional: Adds the transaction to the back stack
                        .commit();
            }
        });


        return view;

    }
}