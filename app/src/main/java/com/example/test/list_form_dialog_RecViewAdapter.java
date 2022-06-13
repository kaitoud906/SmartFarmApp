package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class list_form_dialog_RecViewAdapter extends RecyclerView.Adapter<list_form_dialog_RecViewAdapter.ViewHolder>{
    private ArrayList<AutoWateringHour> list_item;
    private FragmentActivity fragmentActivity;


    public list_form_dialog_RecViewAdapter(FragmentActivity AdapterActivity, ArrayList<AutoWateringHour> list_checks) {
        this.fragmentActivity = AdapterActivity;
        this.list_item = list_checks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder((view));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AutoWateringHour check = list_item.get(position);
        if(check == null) return;
        holder.setAll(check,position);
    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{
        AutoWateringHour list_checks;
        ImageView remove_list_item, save_item;
        EditText edttxt_hour,edttxt_min;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            remove_list_item = itemView.findViewById(R.id.remove_list_item);
            edttxt_hour = itemView.findViewById(R.id.edttext_hour);
            edttxt_min = itemView.findViewById(R.id.edttext_min);
            save_item = itemView.findViewById(R.id.item_save);
        }

        public void setAll(AutoWateringHour list, int position) {
            this.list_checks = list;
            edttxt_hour.setText(list.getHour());
            edttxt_min.setText(list.getMinute());
//            edttxt_hour.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable editable) {
//                    list_checks.setHour(String.valueOf(editable));
//                    notifyDataSetChanged();
////                    listener.addListCheck(list_checks);
//                }
//            });
//            edttxt_min.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable editable) {
//                    list_checks.setMinute(String.valueOf(editable));
//                    notifyDataSetChanged();
////                    listener.addListCheck(list_checks);
//                }
//            });
//            edttxt_hour.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                @Override
//                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                    if(i == EditorInfo.IME_ACTION_SEARCH || i == EditorInfo.IME_ACTION_NEXT){
//                        if(keyEvent == null || !keyEvent.isShiftPressed()){
//                            list_checks.setHour(String.valueOf(edttxt_hour.getText()));
////                            listener.addListCheck(list_checks);
//                            notifyDataSetChanged();
//                            return true;
//                        }
//                    }
//                    else if( i == EditorInfo.IME_ACTION_DONE || keyEvent != null && keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
//                        if(keyEvent == null || !keyEvent.isShiftPressed()){
//                            InputMethodManager imm = (InputMethodManager) fragmentActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
//                            imm.hideSoftInputFromWindow(edttxt_hour.getWindowToken(), 0);
//                            list_checks.setHour(String.valueOf(edttxt_hour.getText()));
//                            notifyDataSetChanged();
////                            listener.addListCheck(list_checks);
////                            listener.addListCheckItem();
//                            return true;
//                        }
//                    }
//                    return false;
//                }
//
//            });
//            edttxt_min.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                 @Override
//                 public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                     if (i == EditorInfo.IME_ACTION_SEARCH || i == EditorInfo.IME_ACTION_NEXT) {
//                         if (keyEvent == null || !keyEvent.isShiftPressed()) {
//                             list_checks.setMinute(String.valueOf(edttxt_min.getText()));
////                            listener.addListCheck(list_checks);
//                             notifyDataSetChanged();
//                             return true;
//                         }
//                     } else if (i == EditorInfo.IME_ACTION_DONE || keyEvent != null && keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//                         if (keyEvent == null || !keyEvent.isShiftPressed()) {
//                             InputMethodManager imm = (InputMethodManager) fragmentActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
//                             imm.hideSoftInputFromWindow(edttxt_hour.getWindowToken(), 0);
//                             list_checks.setMinute(String.valueOf(edttxt_min.getText()));
//                             notifyDataSetChanged();
////                            listener.addListCheck(list_checks);
////                            listener.addListCheckItem();
//                             return true;
//                         }
//                     }
//                     return false;
//                 }
//             });
            remove_list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list_item.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, list_item.size());
                }
            });
            save_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list_checks.setMinute(edttxt_min.getText().toString());
                    list_checks.setHour(edttxt_hour.getText().toString());
                    notifyDataSetChanged();
                    InputMethodManager imm = (InputMethodManager) fragmentActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            });

        }
    }

}
