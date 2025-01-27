package com.czhj.sdk.common.network;

import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Request;
import com.czhj.volley.toolbox.BaseHttpStack;
import com.czhj.volley.toolbox.HttpResponse;
import com.czhj.volley.toolbox.HurlStack;
import com.czhj.volley.toolbox.OkHttp3Stack;
import com.czhj.volley.toolbox.Volley;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
class RequestQueueHttpStack extends BaseHttpStack {

    /* renamed from: a */
    public BaseHttpStack f8550a;

    public RequestQueueHttpStack() {
        if (Volley.isEnableOkhttp3()) {
            try {
                this.f8550a = new OkHttp3Stack();
            } catch (Throwable unused) {
            }
        }
        if (this.f8550a == null) {
            this.f8550a = new HurlStack();
        }
    }

    @Override // com.czhj.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        if (map == null || map.isEmpty()) {
            map = new TreeMap<>();
        }
        map.put(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
        return this.f8550a.executeRequest(request, map);
    }

    public RequestQueueHttpStack(SSLSocketFactory sSLSocketFactory) {
        if (Volley.isEnableOkhttp3()) {
            try {
                this.f8550a = new OkHttp3Stack(sSLSocketFactory);
            } catch (Throwable unused) {
            }
        }
        if (this.f8550a == null) {
            this.f8550a = new HurlStack(null, sSLSocketFactory);
        }
    }
}
