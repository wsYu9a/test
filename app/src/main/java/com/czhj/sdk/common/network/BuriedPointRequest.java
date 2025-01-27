package com.czhj.sdk.common.network;

import android.util.Base64;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import java.util.Map;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes2.dex */
public class BuriedPointRequest extends SigmobRequest<NetworkResponse> {

    /* renamed from: b */
    public final RequestListener f8523b;

    /* renamed from: c */
    public byte[] f8524c;

    /* renamed from: d */
    public boolean f8525d;

    public interface RequestListener {
        void onErrorResponse(VolleyError volleyError);

        void onSuccess();
    }

    public BuriedPointRequest(String str, String str2, RequestListener requestListener) {
        super(str, 1, null);
        this.f8524c = null;
        this.f8523b = requestListener;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
        try {
            try {
                if (Config.sharedInstance().isEnc()) {
                    this.f8524c = AESUtil.Encrypt(str2.getBytes(), "KGpfzbYsn4T9Jyuq");
                    this.f8525d = true;
                }
                if (this.f8525d) {
                    return;
                }
                this.f8524c = str2.getBytes();
            } catch (Exception e10) {
                e10.printStackTrace();
                if (this.f8525d) {
                    return;
                }
                this.f8524c = str2.getBytes();
            }
        } catch (Throwable th2) {
            if (!this.f8525d) {
                this.f8524c = str2.getBytes();
            }
            throw th2;
        }
    }

    public static void BuriedPointSend(String str, RequestListener requestListener) {
        if ((str == null || str.length() == 0) && requestListener != null) {
            requestListener.onErrorResponse(new VolleyError("body is empty"));
        }
        if (Networking.getBuriedPointRequestQueue() == null) {
            if (requestListener != null) {
                requestListener.onErrorResponse(new VolleyError("BuriedPointRequestQueue is empty"));
                return;
            }
            return;
        }
        try {
            Networking.getBuriedPointRequestQueue().add(new BuriedPointRequest(Config.sharedInstance().getLogUrl(), str, requestListener));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            if (requestListener != null) {
                requestListener.onErrorResponse(new VolleyError("network is disconnect "));
            }
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        RequestListener requestListener;
        synchronized (this.mLock) {
            requestListener = this.f8523b;
        }
        SigmobLog.i("send dclog: " + getUrl() + " onErrorResponse");
        if (requestListener != null) {
            requestListener.onErrorResponse(volleyError);
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(NetworkResponse networkResponse) {
        RequestListener requestListener;
        synchronized (this.mLock) {
            requestListener = this.f8523b;
        }
        SigmobLog.d("send dclog: " + getUrl() + " success");
        if (requestListener != null) {
            requestListener.onSuccess();
        }
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public byte[] getBody() {
        return this.f8524c;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        if (this.f8525d) {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        }
        headers.put("gz", DebugKt.DEBUG_PROPERTY_VALUE_ON);
        return headers;
    }

    @Override // com.czhj.volley.Request
    public int getMaxLength() {
        return 100;
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Response<NetworkResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse, null);
    }
}
