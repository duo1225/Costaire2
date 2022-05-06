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
 * Use the {@link DepenseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DepenseFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    View view;
    Spinner spinnerDes;
    EditText mountDes;
    Button validerDes;
    TextView dateDes;
    TextView dateAfficherDes;
    String madateDes;

    String dateChoisirDes;

    String[] strings = {"General", "Restaurant", "Supermarche", "Assurance", "Véhicule", "Téléphone", "Loisir", "Sports"};


    // TODO: Rename and change types and number of parameters
    public static DepenseFragment newInstance(String param1) {
        DepenseFragment fragment = new DepenseFragment();
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
        // Inflate the layout for this fragment
        if(view == null){
            view =  inflater.inflate(R.layout.fragment_depense, container, false);
        }
        initView();
        dateAfficherDes.setText(madateDes);
        return view;
    }

    private void initView() {
        spinnerDes = view.findViewById(R.id.spinnerDes);
        mountDes = view.findViewById(R.id.mountDes);
        validerDes = view.findViewById(R.id.validerDes);
        dateDes = view.findViewById(R.id.dateDes);
        dateAfficherDes = view.findViewById(R.id.dateAfficherDes);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), R.layout.spinner_list, strings);

        spinnerDes.setAdapter(adapter);
        spinnerDes.setSelection(0);
        spinnerDes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(DepenseFragment.this.getContext(), str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // choose a date
        dateDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepenseFragment.this.getContext(),DatePickerActivity.class);
                intent.putExtra("fragment", "depense");
                startActivityForResult(intent,0x11);
            }
        });

    }
}