package com.example.harj10;


import android.content.Context;


import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Objekti {
    private static Objekti mInstance;
    private static Context context;
    private RequestQueue requestQueue;

    public Objekti(@NonNull Context context) {

        this.context = context;
        requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Objekti getInstance(Context context){

        if(mInstance == null){

            mInstance = new Objekti(context);
        }
        return mInstance;
    }

    public <T> void addToRequestQue(Request<T> request){

        requestQueue.add(request);

    }
}
