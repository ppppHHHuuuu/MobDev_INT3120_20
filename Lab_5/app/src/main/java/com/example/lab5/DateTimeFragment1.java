package com.example.lab5;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class DateTimeFragment1 extends Fragment {
    DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();

    TextView lblDateAndTime;
    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) -> {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateLabel();
    };

    TimePickerDialog.OnTimeSetListener t = (view, hourOfDay, minute) -> {
        myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        myCalendar.set(Calendar.MINUTE	, minute);
        updateLabel();
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date_time1, container, false);
        lblDateAndTime = (TextView) view.findViewById(R.id.lblDateAndTime);
        Button btnDate = (Button) view.findViewById(R.id.btnSetDate);
        btnDate.setOnClickListener(v -> {
            new DatePickerDialog(view.getContext(), d,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            Log.d("BtnDate", "clicked");

        });
        Button btnTime = (Button) view.findViewById(R.id.btnSetTime);
        btnTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new TimePickerDialog(view.getContext(), t,
                        myCalendar.get(Calendar.HOUR_OF_DAY),
                        myCalendar.get(Calendar.MINUTE), true).show();
                Log.d("BtnTime", "clicked");
            }
        });
        updateLabel();
        return view;
    }

    public void updateLabel() {
        String dateTimeString = fmtDateAndTime.format(myCalendar.getTime());
        lblDateAndTime.setText(dateTimeString);
    }
}