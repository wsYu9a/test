package com.czhj.volley;

/* loaded from: classes2.dex */
class ResponseDeliveryRunnable implements Runnable {

    /* renamed from: a */
    public final Request f8742a;

    /* renamed from: b */
    public final Response f8743b;

    /* renamed from: c */
    public final Runnable f8744c;

    public ResponseDeliveryRunnable(Request request, Response response, Runnable runnable) {
        this.f8742a = request;
        this.f8743b = response;
        this.f8744c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f8742a.isCanceled()) {
            this.f8742a.finish("canceled-at-delivery");
            return;
        }
        if (this.f8743b.isSuccess()) {
            this.f8742a.deliverResponse(this.f8743b.result);
        } else {
            this.f8742a.deliverError(this.f8743b.error);
        }
        if (this.f8743b.intermediate) {
            this.f8742a.addMarker("intermediate-response");
        } else {
            this.f8742a.finish("done");
        }
        Runnable runnable = this.f8744c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
