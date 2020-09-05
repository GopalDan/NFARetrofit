package com.example.gopal.nfaretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{

    Context context;
    ArrayList<Movie> movies;

    public DataAdapter(Context context, ArrayList<Movie> movies){
        this.context = context;
        this.movies = movies;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Movie currentEvent = movies.get(position);
        holder.webTitle.setText(currentEvent.getWebTitle());
        holder.sectionName.setText(currentEvent.getSectionName());
        holder.publishedDateView.setText(dateFormatter(currentEvent.getWebPublicationDate()));
        Picasso.with(context)
                .load(currentEvent.getThumbnail())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setAdapter(ArrayList<Movie> movieArrayList){
        movies = movieArrayList;
        notifyDataSetChanged();
    }

    private String dateFormatter(String dateInString) {
        String mPublishedDate = "";
        //Specifying the pattern of input date and time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        //   String dateString = "22-03-2017 11:18:32";
        try {
            //Step 1- Parsing  the dateString to convert it into a Date.
            //Here as a special case take care of ParseException: Unparseable date: "2018-11-19T06:37:56Z"
            Date date = sdf.parse(dateInString.replaceAll("Z$", "+0000 "));

            //Step 2- Formatting the date to get desired output
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd-MMM-yyyy");
            mPublishedDate =  fmtOut.format(date);

            Log.v("CustomArrayAdapter", "Value of Date is :" + date);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mPublishedDate;
    }

    class DataViewHolder extends RecyclerView.ViewHolder{
        TextView sectionName, webTitle, publishedDateView;
        ImageView imageView;

        public DataViewHolder(View itemView) {
            super(itemView);
             sectionName = itemView.findViewById(R.id.section_name);
             webTitle = itemView.findViewById(R.id.web_title);
             imageView = itemView.findViewById(R.id.thumbnail);
             publishedDateView = itemView.findViewById(R.id.published_date);
        }
    }

}