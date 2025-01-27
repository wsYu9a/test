package com.czhj.volley;

import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ExecutorsDelivery implements ResponseDelivery {

    /* renamed from: a */
    public final ExecutorService f8721a;

    public ExecutorsDelivery(ExecutorService executorService) {
        this.f8721a = executorService;
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f8721a.execute(new ResponseDeliveryRunnable(request, Response.error(volleyError), null));
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f8721a.execute(new ResponseDeliveryRunnable(request, response, runnable));
    }
}
