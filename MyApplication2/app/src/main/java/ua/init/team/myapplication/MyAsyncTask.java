package ua.init.team.myapplication;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by dev on 16.05.17.
 */

public class MyAsyncTask extends AsyncTask<String,String,String> {

    private OnResponce onResponce;

    public MyAsyncTask (OnResponce onResponce){
        this.onResponce = onResponce;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String serverReqsponce = "all okey";
        return serverReqsponce;
    }

    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);
        onResponce.responce(o);
        Log.e("####", "doInBackground: worked!!!! "+ o);

    }




    interface OnResponce{

        void responce(String responce);

    }
}
