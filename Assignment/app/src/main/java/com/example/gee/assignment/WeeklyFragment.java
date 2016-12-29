package com.example.gee.assignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WeeklyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WeeklyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeeklyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WeeklyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeeklyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeeklyFragment newInstance(String param1, String param2) {
        WeeklyFragment fragment = new WeeklyFragment();
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
        View view=inflater.inflate(R.layout.fragment_weekly, container, false);

        final ArrayList<Day> days=new ArrayList<>();
        ArrayList<Activity> activities=new ArrayList<>();

        Activity a1=new Activity("Jogging","10:00","-12:00");
        Activity a2=new Activity("Swimming","11:00","-12:00");
        Activity a3=new Activity("Workout","10:00","-12:00");
        Activity a4=new Activity("Jogging","11:00","-12:00");

        Day d1=new Day("Monday", a1);
        Day d2=new Day("Tuesday", a2);
        Day d3=new Day("Wednesday", a3);
        Day d4=new Day("Thursday", a4);

        days.add(d1);
        days.add(d2);
        days.add(d3);
        days.add(d4);

        BindDictionary<Day> dictionary=new BindDictionary<>();
        dictionary.addStringField(R.id.day_name, new StringExtractor<Day>() {
            @Override
            public String getStringValue(Day day, int i) {
                return day.getDay();
            }
        });

        dictionary.addStringField(R.id.excercise, new StringExtractor<Day>() {
            @Override
            public String getStringValue(Day day, int i) {
                return day.getActivity().getName();
            }
        });
        dictionary.addStringField(R.id.start_time, new StringExtractor<Day>() {
            @Override
            public String getStringValue(Day day, int i) {
                return day.getActivity().getStartTime();
            }
        });
        dictionary.addStringField(R.id.end_time, new StringExtractor<Day>() {
            @Override
            public String getStringValue(Day day, int i) {
                return day.getActivity().getEndTime();
            }
        });

        FunDapter adapter=new FunDapter(WeeklyFragment.this.getActivity(),days,R.layout.day_layout,dictionary);

        ListView dayList=(ListView)view.findViewById(R.id.day_lists);
        dayList.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
