package com.example.gopal.nfaretrofit;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.gopal.nfaretrofit.pojo.Event;
import com.example.gopal.nfaretrofit.pojo.Fields;
import com.example.gopal.nfaretrofit.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private DataAdapter dataAdapter;
    private ProgressBar mProgressbar;
    private TextView textView;
    private String Url = "https://content.guardianapis.com/search?&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline";
    private int id = 1;
    private RecyclerView recyclerView;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Attaching  viewpager with FragmentPagerAdapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


       /* mProgressbar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.no_network);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movies = new ArrayList<>();
        dataAdapter = new DataAdapter(this, movies);
        recyclerView.setAdapter(dataAdapter);*/

        // click listener for list item
        /*    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Movie currentNews = mCustomAdapter.getItem(position);
                Uri webPage = Uri.parse(currentNews.getWebUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });*/

        //loadEvent();
    }

    public void loadEvent() {
       /* try {
            Thread.sleep(5000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        ApiInterface apiInterface = Api.getClient();

                        apiInterface.getEvent().enqueue(new Callback<Event>() {
                       @Override
                       public void onResponse(Call<Event> call, Response<Event> response) {
                           if(response.isSuccessful()){
                               mProgressbar.setVisibility(View.GONE);
                               textView.setVisibility(View.VISIBLE);
                               ArrayList<Movie> movieArrayList = new ArrayList<>();
                               List<Result> resultList = response.body().getResponse().getResults();
                               for(int i=0; i<resultList.size();i++){
                                   Result result = resultList.get(i);
                                   String sectionName = result.getSectionName();
                                   String webPublicationDate = result.getWebPublicationDate();
                                   String webTitle = result.getWebTitle();
                                   String webUrl = result.getWebUrl();
                                   Fields field = result.getFields();
                                   String byline = field.getByline();
                                   String thumbnail = field.getThumbnail();
                                   movieArrayList.add(new Movie(sectionName,webPublicationDate,webTitle,webUrl,byline,thumbnail));
                               }

                               movies.addAll(movieArrayList);
                               dataAdapter.notifyDataSetChanged();
//                               dataAdapter.setAdapter(movies);

                               //textView.setText("Show  Data: " + response.body().getResponse().getResults().size());
                           }
                           else{
                               int responsCode = response.code();
                               mProgressbar.setVisibility(View.GONE);
                               textView.setVisibility(View.VISIBLE);
                               textView.setText("Response Code" + responsCode);
                           }
                       }

                       @Override
                       public void onFailure(Call<Event> call, Throwable t) {
                           mProgressbar.setVisibility(View.GONE);
                           textView.setVisibility(View.VISIBLE);
                           textView.setText("Exception" + call.toString());
                       }
                   });
    }

    private void commentedWrongCode(){
          /* Call<Movie> call1 = apiInterface.getSingleEvent();
        call1.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie event1 = response.body();

                    mProgressbar.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Show  Data");
                    textView.append("\n WebTitle: " + event1.getWebTitle());
                    textView.append("\n sectionName: " + event1.getSectionName());
                    textView.append("\n webPublicationDate: " + event1.getWebPublicationDate());
                    textView.append("\n WebUrl: " + event1.getWebUrl());

                } else {
                    int responsCode = response.code();
                    mProgressbar.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Response Code" + responsCode);
                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                mProgressbar.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("Exception");


            }
        });*/

/*        Call<List<Event>> call = apiInterface.getListOfEvent();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if(response.isSuccessful()){

                    List<Event> events = response.body();
                    mProgressbar.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Show  Data" + events.size());

                } else{
                    int responsCode = response.code();
                    mProgressbar.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Response Code" + responsCode);
                }

            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                mProgressbar.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("Exception" + call.toString());

            }
        });*/

       /*            apiInterface.getResponseOne().enqueue(new Callback<com.example.gopal.nfaretrofit.pojo.Response>() {
                       @Override
                       public void onResponse(Call<com.example.gopal.nfaretrofit.pojo.Response> call, Response<com.example.gopal.nfaretrofit.pojo.Response> response) {
                           if(response.isSuccessful()){

                               com.example.gopal.nfaretrofit.pojo.Response events = response.body();
                               mProgressbar.setVisibility(View.GONE);
                               textView.setVisibility(View.VISIBLE);
                               int size = events.getResults().size();
                               textView.setText("Show  Data" + size);

                           } else{
                               int responsCode = response.code();
                               mProgressbar.setVisibility(View.GONE);
                               textView.setVisibility(View.VISIBLE);
                               textView.setText("Response Code" + responsCode);
                           }
                       }

                       @Override
                       public void onFailure(Call<com.example.gopal.nfaretrofit.pojo.Response> call, Throwable t) {
                           mProgressbar.setVisibility(View.GONE);
                           textView.setVisibility(View.VISIBLE);
                           textView.setText("Exception" + call.toString());
                       }
                   });*/

    }

}

