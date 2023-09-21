package com.example.lab_5_hw;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class DateTime extends Fragment {
    DateFormat fmtDateAndTime  = DateFormat.getDateTimeInstance();
    TextView lblDateAndTime;

    Calendar calendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);

        }
    };

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            calendar.set(Calendar.HOUR_OF_DAY, i);
            calendar.set(Calendar.MINUTE, i1);

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.date, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find views by their IDs
        lblDateAndTime = view.findViewById(R.id.lblDateAndTime);
        Button buttonDate = view.findViewById(R.id.btnSetDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(requireContext(), d,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        Button buttonTime = view.findViewById(R.id.btnSetTime);
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(
                        requireContext(),
                        t,
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE), true
                ).show();
            }
        });
    }
}
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        lblDateAndTime = (TextView) findViewById(R.id.lblDateAndTime);
//        Button buttonDate = findViewById(R.id.btnSetDate);
//        buttonDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new DatePickerDialog(MainActivity.this, d,
//                        calendar.get(Calendar.YEAR),
//                        calendar.get(Calendar.MONTH),
//                        calendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
//
//        Button buttonTime = findViewById(R.id.btnSetTime);
//        buttonTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new TimePickerDialog(
//                        MainActivity.this,
//                        t,
//                        calendar.get(Calendar.HOUR_OF_DAY),
//                        calendar.get(Calendar.MINUTE), true
//                ).show();
//            }
//        });
//
//
//
//    }
//}
