package com.czhj.volley;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class RequestQueue {

    /* renamed from: h */
    public static final int f8731h = 4;

    /* renamed from: a */
    public final AtomicInteger f8732a;

    /* renamed from: b */
    public final Set<Request<?>> f8733b;

    /* renamed from: c */
    public CustomLinkedBlockingQueue f8734c;

    /* renamed from: d */
    public final Network f8735d;

    /* renamed from: e */
    public final ResponseDelivery f8736e;

    /* renamed from: f */
    public final List<RequestFinishedListener> f8737f;

    /* renamed from: g */
    public ThreadPoolExecutor f8738g;

    /* renamed from: com.czhj.volley.RequestQueue$1 */
    public class AnonymousClass1 implements RequestFilter {

        /* renamed from: a */
        public final /* synthetic */ Object f8739a;

        public AnonymousClass1(Object obj) {
            obj = obj;
        }

        @Override // com.czhj.volley.RequestQueue.RequestFilter
        public boolean apply(Request<?> request) {
            return request.getTag() == obj;
        }
    }

    public static class CustomLinkedBlockingQueue extends LinkedBlockingQueue<Runnable> {

        /* renamed from: a */
        public ThreadPoolExecutor f8741a;

        public void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
            this.f8741a = threadPoolExecutor;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Runnable runnable) {
            ThreadPoolExecutor threadPoolExecutor = this.f8741a;
            if (threadPoolExecutor == null || threadPoolExecutor.getPoolSize() >= this.f8741a.getMaximumPoolSize()) {
                return super.offer((CustomLinkedBlockingQueue) runnable);
            }
            return false;
        }
    }

    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> request);
    }

    public RequestQueue(Network network) {
        this(network, 4, Integer.MAX_VALUE);
    }

    public <T> void a(Request<T> request) {
        synchronized (this.f8733b) {
            this.f8733b.remove(request);
        }
        synchronized (this.f8737f) {
            try {
                Iterator<RequestFinishedListener> it = this.f8737f.iterator();
                while (it.hasNext()) {
                    it.next().onRequestFinished(request);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public <T> Request<T> add(Request<T> request) {
        if (request == null || TextUtils.isEmpty(request.getUrl())) {
            return null;
        }
        try {
            this.f8738g.submit(new NetworkDispatcher(this.f8735d, request, this.f8736e));
        } catch (Exception e10) {
            VolleyLog.e(e10, "add request error", new Object[0]);
        }
        return request;
    }

    public <T> void addRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.f8737f) {
            this.f8737f.add(requestFinishedListener);
        }
    }

    public void cancelAll(RequestFilter requestFilter) {
        synchronized (this.f8733b) {
            try {
                for (Request<?> request : this.f8733b) {
                    if (requestFilter.apply(request)) {
                        request.cancel();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int getSequenceNumber() {
        return this.f8732a.incrementAndGet();
    }

    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.f8737f) {
            this.f8737f.remove(requestFinishedListener);
        }
    }

    public void start() {
        stop();
    }

    public void stop() {
    }

    public RequestQueue(Network network, int i10, int i11) {
        this(network, i10, i11, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public void cancelAll(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        cancelAll((RequestFilter) new RequestFilter() { // from class: com.czhj.volley.RequestQueue.1

            /* renamed from: a */
            public final /* synthetic */ Object f8739a;

            public AnonymousClass1(Object obj2) {
                obj = obj2;
            }

            @Override // com.czhj.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }

    public RequestQueue(Network network, int i10, int i11, ResponseDelivery responseDelivery) {
        this.f8732a = new AtomicInteger();
        this.f8733b = new HashSet();
        this.f8734c = new CustomLinkedBlockingQueue();
        this.f8737f = new ArrayList();
        this.f8738g = null;
        this.f8735d = network;
        this.f8736e = responseDelivery;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i11, 60L, TimeUnit.SECONDS, this.f8734c, new VolleyThreadFactory());
        this.f8738g = threadPoolExecutor;
        this.f8734c.setExecutor(threadPoolExecutor);
    }
}
