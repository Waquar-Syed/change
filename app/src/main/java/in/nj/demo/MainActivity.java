package in.nj.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import in.nj.demo.Controller.ServiceController;
import in.nj.demo.common.JSONServiceRequest;
import in.nj.demo.common.StringServiceRequest;
import in.nj.demo.common.interfaces.ServiceRequest;
import in.nj.demo.common.interfaces.listeners.ServiceResponseListener;
import in.nj.demo.services.DemoRequest;


//https://www.w3schools.com/action_page.php?fname=haha&lname=hoho
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.textView);

        DemoRequest demoRequest = DemoRequest.builder().requestMethod(DemoRequest.TYPE.POST)
                .url("https://www.w3schools.com/action_page.php?fname=haha&lname=hoho")
                .headers(null)
                .build();

        ServiceResponseListener<String> listener = new ServiceResponseListener<String>() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                Log.v("RESPONSE",response);
                textView.setText(response);
            }
        };

        ServiceRequest serviceRequest = new StringServiceRequest(demoRequest,listener);
        ServiceController.getServiceController().newServiceRequest(serviceRequest);
    }
}
