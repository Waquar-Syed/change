package in.nj.demo.Controller;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import in.nj.demo.DemoApplication;
import in.nj.demo.common.interfaces.ServiceRequest;

/**
 * Created by hp on 22-11-2017.
 */

public class ServiceController {

    private static final String TAG = ServiceController.class.getName();
    private static ServiceController serviceController;

    public static ServiceController getServiceController(){
        if(serviceController == null)
            serviceController = new ServiceController();

        return serviceController;
    }

    public void newServiceRequest(ServiceRequest serviceRequest){

        StringRequest stringRequest = (StringRequest) serviceRequest.getRequest();
        stringRequest.setTag(serviceRequest.demoRequest.getUrl());
        addRequestToQueue(stringRequest);

    }


    private void addRequestToQueue(Request request){
        DemoApplication.getInstance().addToRequestQueue(request);
    }
}
