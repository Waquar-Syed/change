package in.nj.demo.common;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import in.nj.demo.common.interfaces.ServiceRequest;
import in.nj.demo.common.interfaces.listeners.ServiceResponseListener;
import in.nj.demo.services.CustomJSONRequest;
import in.nj.demo.services.DemoRequest;

/**
 * Created by hp on 22-11-2017.
 */

public class JSONServiceRequest extends ServiceRequest {

    public JSONServiceRequest(DemoRequest demoRequest, ServiceResponseListener serviceResponseListener) {
        super(demoRequest, serviceResponseListener);
    }

    @Override
    public Request getRequest() {
        JsonObjectRequest jsonObjectRequest = new CustomJSONRequest(demoRequest,serviceResponseListener);
        jsonObjectRequest.setTag(demoRequest.getUrl());
        return jsonObjectRequest;
    }
}
