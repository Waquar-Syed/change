package in.nj.demo.common;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import in.nj.demo.common.interfaces.ServiceRequest;
import in.nj.demo.common.interfaces.listeners.ServiceResponseListener;
import in.nj.demo.services.CustomStringRequest;
import in.nj.demo.services.DemoRequest;

/**
 * Created by hp on 22-11-2017.
 */

public class StringServiceRequest extends ServiceRequest {

    public StringServiceRequest(DemoRequest demoRequest, ServiceResponseListener serviceResponseListener) {
        super(demoRequest, serviceResponseListener);
    }

    @Override
    public Request getRequest() {
        StringRequest stringRequest = new CustomStringRequest(demoRequest,serviceResponseListener);
        return stringRequest;
    }
}
