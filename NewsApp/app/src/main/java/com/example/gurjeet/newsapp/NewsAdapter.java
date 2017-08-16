package com.example.gurjeet.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Gurjeet on 07-Feb-17.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Activity context, ArrayList<News> w) {
        super(context, 0, w);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_news, parent, false);
        }
        News currentNews = getItem(position);

        TextView numView=(TextView)listItemView.findViewById(R.id.number);
        String number=String.valueOf(currentNews.getMnum());
        numView.setText(number);
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String date=(currentNews.getMtime());
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(date);
        // Display the date of the current news in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(date);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        TextView secnView = (TextView) listItemView.findViewById(R.id.secn);
        secnView.setText(currentNews.getMsec());
        TextView titView = (TextView) listItemView.findViewById(R.id.title);
        titView.setText(currentNews.getMtitle());

        return listItemView;
    }
    private String formatDate(String dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        Date d=new Date();
        try {
            d=dateFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(d);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(String dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        Date d=new Date();
        try {
            d=timeFormat.parse(dateObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeFormat.format(d);
    }
}
