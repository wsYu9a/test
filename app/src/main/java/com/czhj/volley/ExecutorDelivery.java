package com.czhj.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class ExecutorDelivery implements ResponseDelivery {

    /* renamed from: a */
    public final Executor f8718a;

    /* renamed from: com.czhj.volley.ExecutorDelivery$1 */
    public class AnonymousClass1 implements Executor {

        /* renamed from: a */
        public final /* synthetic */ Handler f8719a;

        public AnonymousClass1(Handler handler) {
            handler = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            handler.post(runnable);
        }
    }

    public ExecutorDelivery(Handler handler) {
        this.f8718a = new Executor() { // from class: com.czhj.volley.ExecutorDelivery.1

            /* renamed from: a */
            public final /* synthetic */ Handler f8719a;

            public AnonymousClass1(Handler handler2) {
                handler = handler2;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f8718a.execute(new ResponseDeliveryRunnable(request, Response.error(volleyError), null));
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    public ExecutorDelivery(Executor executor) {
        this.f8718a = executor;
    }

    @Override // com.czhj.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f8718a.execute(new ResponseDeliveryRunnable(request, response, runnable));
    }
}
