package com.czhj.volley;

import android.os.Process;
import com.czhj.volley.Cache;
import com.czhj.volley.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class CacheDispatcher extends Thread {

    /* renamed from: g */
    public static final boolean f8701g = VolleyLog.DEBUG;

    /* renamed from: a */
    public final BlockingQueue<Request<?>> f8702a;

    /* renamed from: b */
    public final BlockingQueue<Request<?>> f8703b;

    /* renamed from: c */
    public final Cache f8704c;

    /* renamed from: d */
    public final ResponseDelivery f8705d;

    /* renamed from: f */
    public volatile boolean f8707f = false;

    /* renamed from: e */
    public final WaitingRequestManager f8706e = new WaitingRequestManager(this);

    /* renamed from: com.czhj.volley.CacheDispatcher$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Request f8708a;

        public AnonymousClass1(Request request) {
            request = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CacheDispatcher.this.f8703b.put(request);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static class WaitingRequestManager implements Request.NetworkRequestCompleteListener {

        /* renamed from: a */
        public final Map<String, List<Request<?>>> f8710a = new HashMap();

        /* renamed from: b */
        public final CacheDispatcher f8711b;

        public WaitingRequestManager(CacheDispatcher cacheDispatcher) {
            this.f8711b = cacheDispatcher;
        }

        @Override // com.czhj.volley.Request.NetworkRequestCompleteListener
        public synchronized void onNoUsableResponseReceived(Request<?> request) {
            try {
                String cacheKey = request.getCacheKey();
                List<Request<?>> remove = this.f8710a.remove(cacheKey);
                if (remove != null && !remove.isEmpty()) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                    }
                    Request<?> remove2 = remove.remove(0);
                    this.f8710a.put(cacheKey, remove);
                    remove2.setNetworkRequestCompleteListener(this);
                    try {
                        this.f8711b.f8703b.put(remove2);
                    } catch (InterruptedException e10) {
                        VolleyLog.e("Couldn't add request to queue. %s", e10.toString());
                        Thread.currentThread().interrupt();
                        this.f8711b.quit();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // com.czhj.volley.Request.NetworkRequestCompleteListener
        public void onResponseReceived(Request<?> request, Response<?> response) {
            List<Request<?>> remove;
            Cache.Entry entry = response.cacheEntry;
            if (entry == null || entry.isExpired()) {
                onNoUsableResponseReceived(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.f8710a.remove(cacheKey);
            }
            if (remove != null) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                Iterator<Request<?>> it = remove.iterator();
                while (it.hasNext()) {
                    this.f8711b.f8705d.postResponse(it.next(), response);
                }
            }
        }

        public final synchronized boolean a(Request<?> request) {
            try {
                String cacheKey = request.getCacheKey();
                if (!this.f8710a.containsKey(cacheKey)) {
                    this.f8710a.put(cacheKey, null);
                    request.setNetworkRequestCompleteListener(this);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.d("new request, sending to network %s", cacheKey);
                    }
                    return false;
                }
                List<Request<?>> list = this.f8710a.get(cacheKey);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.addMarker("waiting-for-response");
                list.add(request);
                this.f8710a.put(cacheKey, list);
                if (VolleyLog.DEBUG) {
                    VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.f8702a = blockingQueue;
        this.f8703b = blockingQueue2;
        this.f8704c = cache;
        this.f8705d = responseDelivery;
    }

    public void processRequest(Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        if (request.isCanceled()) {
            request.finish("cache-discard-canceled");
            return;
        }
        Cache.Entry entry = this.f8704c.get(request.getCacheKey());
        if (entry == null) {
            request.addMarker("cache-miss");
            if (this.f8706e.a(request)) {
                return;
            }
            this.f8703b.put(request);
            return;
        }
        if (entry.isExpired()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(entry);
            if (this.f8706e.a(request)) {
                return;
            }
            this.f8703b.put(request);
            return;
        }
        request.addMarker("cache-hit");
        Response<?> parseNetworkResponse = request.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
        request.addMarker("cache-hit-parsed");
        if (entry.refreshNeeded()) {
            request.addMarker("cache-hit-refresh-needed");
            request.setCacheEntry(entry);
            parseNetworkResponse.intermediate = true;
            if (!this.f8706e.a(request)) {
                this.f8705d.postResponse(request, parseNetworkResponse, new Runnable() { // from class: com.czhj.volley.CacheDispatcher.1

                    /* renamed from: a */
                    public final /* synthetic */ Request f8708a;

                    public AnonymousClass1(Request request2) {
                        request = request2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CacheDispatcher.this.f8703b.put(request);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });
                return;
            }
        }
        this.f8705d.postResponse(request2, parseNetworkResponse);
    }

    public void quit() {
        this.f8707f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f8701g) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f8704c.initialize();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f8707f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void a() throws InterruptedException {
        processRequest(this.f8702a.take());
    }
}
