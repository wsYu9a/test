package com.czhj.sdk.common.track;

import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Request;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;

/* loaded from: classes2.dex */
public class TrackingRequest extends Request<NetworkResponse> {
    private static final int ZERO_RETRIES = 0;
    private static int reTryFailCount;
    private final RequestListener mListener;

    public interface RequestListener extends Response.ErrorListener {
        void onSuccess(NetworkResponse networkResponse);
    }

    public TrackingRequest(String str, int i10, int i11, RequestListener requestListener) {
        super(0, str, requestListener);
        this.mListener = requestListener;
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 > 3) {
            i10 = 3;
        }
        setShouldRetryServerErrors(true);
        setRetryPolicy(new DefaultRetryPolicy(i11, i11, i10, 0.0f));
        setShouldCache(false);
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        SigmobLog.e("send tracking: " + getUrl() + " fail");
        super.deliverError(volleyError);
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(NetworkResponse networkResponse) {
        RequestListener requestListener;
        synchronized (this.mLock) {
            requestListener = this.mListener;
        }
        SigmobLog.i("send tracking: " + getUrl() + " success");
        if (requestListener != null) {
            requestListener.onSuccess(networkResponse);
        }
    }

    @Override // com.czhj.volley.Request
    public int getMaxLength() {
        return 100;
    }

    @Override // com.czhj.volley.Request
    public Response<NetworkResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse, null);
    }

    public TrackingRequest(String str, int i10, RequestListener requestListener) {
        this(str, i10, Config.sharedInstance().getNetworkTimeout(), requestListener);
    }
}
