package com.emma.viewpagerfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RessourceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RessourceFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    View view;
    Spinner spinnerRes;
    EditText mountRes;
    Button validerRes;
    TextView dateRes;
    TextView dateAfficherRes;
    String madate;

    String dateChoisir;

    public static RessourceFragment newInstance(String param1) {
        RessourceFragment fragment = new RessourceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("je test");
        System.out.println(madate);
        // Inflate the layout for this fragment
        if(view == null){
            view =  inflater.inflate(R.layout.fragment_ressource, container, false);
        }
        initView();
        dateAfficherRes.setText(madate);

        return view;
    }

    private void initView() {
        spinnerRes = view.findViewById(R.id.spinnerRes);
        mountRes = view.findViewById(R.id.mountRes);
        validerRes = view.findViewById(R.id.validerRes);
        dateRes = view.findViewById(R.id.dateRes);
        dateAfficherRes = view.findViewById(R.id.dateAfficherRes);

        // spinner
        String[] strings = {"Salaires","Invertissement"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), R.layout.spinner_list, strings);

        spinnerRes.setAdapter(adapter);
        spinnerRes.setSelection(0);
        spinnerRes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(RessourceFragment.this.getContext(), str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // choose a date
        dateRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RessourceFragment.this.getContext(),DatePickerActivity.class);
                intent.putExtra("fragment", "ressource");
                startActivityForResult(intent,0x11);
            }
        });

        //afficher la date choisi
        //dateAfficherRes.setText(dateChoisir);


    }
}