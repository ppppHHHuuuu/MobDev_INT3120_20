package com.example.lab_5_hw;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

//public class MainActivity  extends AppCompatActivity{
//    DateFormat  fmtDateAndTime  = DateFormat.getDateTimeInstance();
//    TextView lblDateAndTime;
//
//    Calendar calendar = Calendar.getInstance();
//
//    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//            calendar.set(Calendar.YEAR, i);
//            calendar.set(Calendar.MONTH, i1);
//            calendar.set(Calendar.DAY_OF_MONTH, i2);
//
//        }
//    };
//    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
//        @Override
//        public void onTimeSet(TimePicker timePicker, int i, int i1) {
//            calendar.set(Calendar.HOUR_OF_DAY, i);
//            calendar.set(Calendar.MINUTE, i1);
//
//        }
//    };
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


public class TabLayout extends AppCompatActivity {
    TabLayout tabLayout1;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        tabLayout1 = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        myViewPagerAdapter.set

    }
}