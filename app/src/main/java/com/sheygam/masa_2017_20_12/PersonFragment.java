package com.sheygam.masa_2017_20_12;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    private Person person;
    public PersonFragment() {
        // Required empty public constructor
    }

    public static PersonFragment newInstance(Person person){
        PersonFragment fragment = new PersonFragment();
        fragment.person = person;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView nameTxt = view.findViewById(R.id.name_txt);
        TextView emailTxt = view.findViewById(R.id.email_txt);
        TextView phoneTxt = view.findViewById(R.id.phone_txt);
        nameTxt.setText(person.getName());
        emailTxt.setText(person.getEmail());
        phoneTxt.setText(person.getPhone());
    }
}
