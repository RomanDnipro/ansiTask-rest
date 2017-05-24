package ua.init.team.myapplication;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.init.team.myapplication.retrofit_models.FootballData;

public class MainActivity extends AppCompatActivity implements Callback<FootballData>, MyAsyncTask.OnResponce {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_onload);
        findViewById(R.id.btn_add_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            User user = new User(3, "Trest1", "23");
            User user1 = new User(4, "Trest2", "23");
            User user2 = new User(5, "Trest3", "23");
            Gson gson = new Gson();


            Log.e("@@@@", "onClick: "+gson.toJson(user));
            Log.e("@@@@", "onClick: "+gson.toJson(user1));
            Log.e("@@@@", "onClick: "+gson.toJson(user2));
            parseRequest("{\"_links\":{\"self\":{\"href\":\"http://api.football-data.org/v1/soccerseasons/424/fixtures\"},\"soccerseason\":{\"href\":\"http://api.football-data.org/v1/soccerseasons/424\"}},\"count\":51}");

                MyAsyncTask myAsyncTask = new MyAsyncTask(MainActivity.this);
                myAsyncTask.execute();


                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, "post handler", Toast.LENGTH_SHORT).show();

                    }
                });

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, "postDelayed handler", Toast.LENGTH_SHORT).show();


                    }
                },5000);


                Thread thread=  new Thread(new Runnable() {
                    @Override
                    public void run() {

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Snackbar.make(textView, "run on UI thread",Snackbar.LENGTH_LONG).show();

                            }
                        });

                    }
                });
                thread.start();


            }
        });

    }


    private void makeRequest(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                //TODO make request


            }
        }).start();



    }


    private void parseRequest(String json){

        Gson gson = new Gson();
        FootballData footballData = gson.fromJson(json, FootballData.class);


        Log.e("###", "parseRequest:retrofit parse "+footballData.getLinksObject().getLinks1().getString() );

    }


    @Override
    public void onResponse(Call<FootballData> call, Response<FootballData> response) {

        FootballData footballData = response.body();

        footballData.getAnInt();

    }

    @Override
    public void onFailure(Call<FootballData> call, Throwable t) {

        Log.e("###", "onFailure: "+t.getLocalizedMessage());

    }

    @Override
    public void responce(String responce) {

        textView.setText(responce);
    }
}
