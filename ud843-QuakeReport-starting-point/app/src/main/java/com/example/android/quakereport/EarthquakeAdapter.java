package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by elija on 8/18/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = "of";

    private int getMagColor(double magnitude){
        int magnitudecolorresourceID = R.color.magnitude1;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudecolorresourceID = R.color.magnitude1;
                break;
            case 2:
                magnitudecolorresourceID = R.color.magnitude2;
                break;
            case 3:
                magnitudecolorresourceID = R.color.magnitude3;
                break;
            case 4:
                magnitudecolorresourceID = R.color.magnitude4;
                break;
            case 5:
                magnitudecolorresourceID = R.color.magnitude5;
                break;
            case 6:
                magnitudecolorresourceID = R.color.magnitude6;
                break;
            case 7:
                magnitudecolorresourceID = R.color.magnitude7;
                break;
            case 8:
                magnitudecolorresourceID = R.color.magnitude8;
                break;
            case 9:
                magnitudecolorresourceID = R.color.magnitude9;
                break;
            case 10:
                magnitudecolorresourceID = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudecolorresourceID);

    }
    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeformat = new DecimalFormat("0.0");
        return magnitudeformat.format(magnitude);
    }
    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject){
        SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
        return timeformat.format(dateObject);
    }

    public EarthquakeAdapter(@NonNull Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       View listitemview = convertView;
        if(listitemview == null){
            listitemview = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent,false);
        }

        Earthquake currentearthquake = getItem(position);

        double mag = currentearthquake.getMagnitude();
        String formattedmag = formatMagnitude(mag);

        TextView magnitude = (TextView) listitemview.findViewById(R.id.mag);
        magnitude.setText(formattedmag);

        GradientDrawable magnitudecircle = (GradientDrawable) magnitude.getBackground();

        double magcolor = getMagColor(currentearthquake.getMagnitude());

        magnitudecircle.setColor((int) magcolor);

                String originalLoaction = currentearthquake.getLocation();
        String primarylocation;
        String locationoffset;

        if(originalLoaction.contains(LOCATION_SEPARATOR)){
            String [] parts = originalLoaction.split(LOCATION_SEPARATOR);
            locationoffset = parts[0] + LOCATION_SEPARATOR;
            primarylocation = parts[1];
        }else{
            locationoffset = getContext().getString(R.string.near_the);
            primarylocation = originalLoaction;
        }

        TextView location1 = (TextView)listitemview.findViewById(R.id.location1);
        location1.setText(locationoffset);

        TextView location2 = (TextView)listitemview.findViewById(R.id.location2);
        location2.setText(primarylocation);

        Date dateObject = new Date(currentearthquake.getTimeinMilliseconds());

        TextView date = (TextView) listitemview.findViewById(R.id.date);
        String formatteddate = formatDate(dateObject);
        date.setText(formatteddate);

        TextView time = (TextView) listitemview.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedTime);

        return listitemview;
    }
}
