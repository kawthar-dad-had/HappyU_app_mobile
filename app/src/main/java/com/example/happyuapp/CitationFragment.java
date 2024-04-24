package com.example.happyuapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CitationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CitationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public CitationFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CitationFragment
     */
    // TODO: Rename and change types and number of parameters
    public static CitationFragment newInstance(String param1, String param2) {
        CitationFragment fragment = new CitationFragment();
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

        // Configurez l'AlarmManager pour déclencher le service toutes les deux heures

        new NotificationScheduler().scheduleNotification(requireContext());

        //Affiche la notification de test lors de la création du fragment
        showTestNotification();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_citation, container, false);


        return view;
    }

    private void showTestNotification() {

        Intent intent = new Intent(requireContext(), NotificationScheduler.class);
        intent.setAction("com.example.notification.TEST_NOTIFICATION");
        requireContext().sendBroadcast(intent);
    }
}