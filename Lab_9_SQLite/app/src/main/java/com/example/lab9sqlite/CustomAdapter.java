package com.example.lab9sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList user_id, user_name, user_age, user_gender;

    CustomAdapter(Context context, ArrayList<Integer> user_id, ArrayList<String> user_name, ArrayList<Integer> user_age, ArrayList<String> user_gender) {
        this.context = context;
        this.user_id = user_id;
        this.user_age = user_age;
        this.user_gender = user_gender;
        this.user_name = user_name;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.data_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textUserId.setText(String.valueOf(user_id.get(position)));
        holder.textUserGender.setText(String.valueOf(user_gender.get(position)));
        holder.textUserAge.setText(String.valueOf(user_age.get(position)));
        holder.textUsername.setText(String.valueOf(user_name.get(position)));
    }

    @Override
    public int getItemCount() {
        if (user_id.size() == 0) {
            return 10;
        }
        return user_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textUserId, textUsername, textUserAge, textUserGender;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textUserId = itemView.findViewById(R.id.textUserId);
            textUsername = itemView.findViewById(R.id.textUserName);
            textUserAge = itemView.findViewById(R.id.textUserAge);
            textUserGender = itemView.findViewById(R.id.textUserGender);
        }
    }
}
