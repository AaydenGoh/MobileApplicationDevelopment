package com.example.gee.assignment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    FoodDatabase foodDatabase;
    ExpandListAdapter ExpAdapter;
    ExpandableListView expandList;
    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_food, container, false);
        expandList = (ExpandableListView) view.findViewById(R.id.food_lists);
        ArrayList<ExpandListGroup> ExpListItems = SetStandardGroups(foodDatabase.getAllData());
        ExpAdapter = new ExpandListAdapter(getContext(), ExpListItems);


        return view;
    }

    public ArrayList<ExpandListGroup> SetStandardGroups(Cursor crsr) {
        ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
        ArrayList<ExpandListChild> list2;
        Cursor c = crsr;
        if (c.moveToFirst()) {
            do {
                String category = c.getString(c.getColumnIndex("CATEGORY"));
                String name = c.getString(c.getColumnIndex("NAME"));
                String calories = c.getString(c.getColumnIndex("CALORIES"));
                ExpandListGroup gru1 = new ExpandListGroup();
                gru1.setName(category);
                ExpandListChild ch1_1 = new ExpandListChild();
                ch1_1.setName(name);
                ch1_1.setTag(calories);
                list2 = new ArrayList<ExpandListChild>();
                list2.add(ch1_1);
                gru1.setItems(list2);
                list.add(gru1);
            } while (c.moveToNext());
        }
        c.close();

        return list;
    }

}
