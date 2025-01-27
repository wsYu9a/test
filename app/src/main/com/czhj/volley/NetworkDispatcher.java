package com.czhj.volley;

import android.net.TrafficStats;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public class NetworkDispatcher implements Runnable, Comparable {

    /* renamed from: a */
    public final Network f8724a;

    /* renamed from: b */
    public final ResponseDelivery f8725b;

    /* renamed from: c */
    public final Request f8726c;

    /* renamed from: d */
    public volatile boolean f8727d = false;

    public NetworkDispatcher(Network network, Request request, ResponseDelivery responseDelivery) {
        this.f8726c = request;
        this.f8724a = network;
        this.f8725b = responseDelivery;
    }

    public final void a(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return (obj == null && hashCode() == obj.hashCode()) ? 0 : 1;
    }

    public void processRequest(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.finish("network-discard-cancelled");
                request.notifyListenerResponseNotUsable();
                return;
            }
            a(request);
            NetworkResponse performRequest = this.f8724a.performRequest(request);
            request.addMarker("network-http-complete");
            if (performRequest.notModified && request.hasHadResponseDelivered()) {
                request.finish("not-modified");
                request.notifyListenerResponseNotUsable();
                return;
            }
            Response<?> parseNetworkResponse = request.parseNetworkResponse(performRequest);
            request.addMarker("network-parse-complete");
            request.markDelivered();
            this.f8725b.postResponse(request, parseNetworkResponse);
            request.notifyListenerResponseReceived(parseNetworkResponse);
        } catch (VolleyError e10) {
            e10.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            a(request, e10);
            request.notifyListenerResponseNotUsable();
        } catch (Throwable th2) {
            VolleyLog.e(th2, "Unhandled exception %s", th2.toString());
            VolleyError volleyError = new VolleyError(th2);
            volleyError.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f8725b.postError(request, volleyError);
            request.notifyListenerResponseNotUsable();
        }
    }

    public void quit() {
        this.f8727d = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        processRequest(this.f8726c);
    }

    public final void a(Request<?> request, VolleyError volleyError) {
        this.f8725b.postError(request, request.parseNetworkError(volleyError));
    }
}
