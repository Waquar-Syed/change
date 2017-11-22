package in.nj.demo;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by hp on 22-11-2017.
 */

public class DemoApplication extends Application {

    private static DemoApplication demoApplication;
    private RequestQueue requestQueue;

    public DemoApplication(){}

    @Override
    public void onCreate() {
        super.onCreate();
        demoApplication = this;
    }

    public static synchronized DemoApplication getInstance(){
        return demoApplication;
    }

    private RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(getApplicationContext());

        return requestQueue;
    }

    public void addToRequestQueue(Request request){
        getRequestQueue().add(request);
    }

    public void removeFromRequestQueue(String tag){
        getRequestQueue().cancelAll(tag);
    }
}
