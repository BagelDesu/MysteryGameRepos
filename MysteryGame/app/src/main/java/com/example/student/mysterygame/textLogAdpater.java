package com.example.student.mysterygame;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by student on 09/05/2018.
 */

public class textLogAdpater extends ArrayAdapter<LogItems> {

    /**
     * This is the adapter used for the log. Think of this as the part of the code
     * that changes the text view into w/e you need it to be.
     */

    //sets the context of the adapter.
    private Context context;

    //Constructor for the adapter.
    public textLogAdpater(Context context, List items) {
        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
    }


    //Temp holder for the text.
    private class ViewHolder{
        TextView titleText;
    }

    //Setting up the view itself.
    public View getView(int position, View convertView, ViewGroup parent){

        //Variables needed for the View.
        ViewHolder holder = null;
        LogItems item = (LogItems)getItem(position);
        final String name = item.getLogName();
        TextView logDate = null;
        TextView logEntry = null;
        View viewToUse = null;
        ImageView mmImage = null;

        //Used to fit the log in w/e layout is used.
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //sets what view to use.
        viewToUse = mInflater.inflate(R.layout.textlogitem, null);
        holder = new ViewHolder();
        holder.titleText = (TextView)viewToUse.findViewById(R.id.logNameText);
        viewToUse.setTag(holder);

        //sets the views contents to w/e is in the "LogItem" Data set.
        logDate = (TextView)viewToUse.findViewById(R.id.logDateText);
        logEntry = (TextView)viewToUse.findViewById(R.id.logEntryText);
        holder.titleText.setText(item.getLogName());
        logDate.setText(item.getLogDate());
        logEntry.setText(item.getLogEntry());

    return viewToUse;
    }

}
