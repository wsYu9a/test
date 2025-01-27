package com.czhj.sdk.common.network;

import android.os.Handler;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.volley.ExecutorsDelivery;
import com.czhj.volley.Network;
import com.czhj.volley.Request;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.ResponseDelivery;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class SigmobRequestQueue extends RequestQueue {

    /* renamed from: j */
    public static final int f8552j = 10;

    /* renamed from: i */
    public final Map<Request<?>, DelayedRequestHelper> f8553i;

    /* renamed from: com.czhj.sdk.common.network.SigmobRequestQueue$1 */
    public class AnonymousClass1 implements RequestQueue.RequestFilter {
        public AnonymousClass1() {
        }

        @Override // com.czhj.volley.RequestQueue.RequestFilter
        public boolean apply(Request<?> request) {
            return true;
        }
    }

    /* renamed from: com.czhj.sdk.common.network.SigmobRequestQueue$2 */
    public class AnonymousClass2 implements RequestQueue.RequestFilter {

        /* renamed from: a */
        public final /* synthetic */ Object f8555a;

        public AnonymousClass2(Object obj) {
            obj = obj;
        }

        @Override // com.czhj.volley.RequestQueue.RequestFilter
        public boolean apply(Request<?> request) {
            return request.getTag() == obj;
        }
    }

    /* renamed from: com.czhj.sdk.common.network.SigmobRequestQueue$3 */
    public class AnonymousClass3 implements RequestQueue.RequestFilter {

        /* renamed from: a */
        public final /* synthetic */ Request f8557a;

        public AnonymousClass3(Request request) {
            request = request;
        }

        @Override // com.czhj.volley.RequestQueue.RequestFilter
        public boolean apply(Request<?> request) {
            return request == request;
        }
    }

    public class DelayedRequestHelper {

        /* renamed from: a */
        public final int f8559a;

        /* renamed from: b */
        public final Handler f8560b;

        /* renamed from: c */
        public final Runnable f8561c;

        /* renamed from: com.czhj.sdk.common.network.SigmobRequestQueue$DelayedRequestHelper$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ SigmobRequestQueue f8563a;

            /* renamed from: b */
            public final /* synthetic */ Request f8564b;

            public AnonymousClass1(SigmobRequestQueue sigmobRequestQueue, Request request) {
                r2 = sigmobRequestQueue;
                request = request;
            }

            @Override // java.lang.Runnable
            public void run() {
                SigmobRequestQueue.this.f8553i.remove(request);
                SigmobRequestQueue.this.add(request);
            }
        }

        public DelayedRequestHelper(SigmobRequestQueue sigmobRequestQueue, Request<?> request, int i10) {
            this(request, i10, new Handler());
        }

        public void a() {
            this.f8560b.removeCallbacks(this.f8561c);
        }

        public void b() {
            this.f8560b.postDelayed(this.f8561c, this.f8559a);
        }

        public DelayedRequestHelper(Request<?> request, int i10, Handler handler) {
            this.f8559a = i10;
            this.f8560b = handler;
            this.f8561c = new Runnable() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.DelayedRequestHelper.1

                /* renamed from: a */
                public final /* synthetic */ SigmobRequestQueue f8563a;

                /* renamed from: b */
                public final /* synthetic */ Request f8564b;

                public AnonymousClass1(SigmobRequestQueue sigmobRequestQueue, Request request2) {
                    r2 = sigmobRequestQueue;
                    request = request2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SigmobRequestQueue.this.f8553i.remove(request);
                    SigmobRequestQueue.this.add(request);
                }
            };
        }
    }

    public SigmobRequestQueue(Network network) {
        super(network);
        this.f8553i = new HashMap(10);
    }

    public void addDelayedRequest(Request<?> request, int i10) {
        a(request, new DelayedRequestHelper(this, request, i10));
    }

    public final void b(Request<?> request) {
        cancelAll((RequestQueue.RequestFilter) new RequestQueue.RequestFilter() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.3

            /* renamed from: a */
            public final /* synthetic */ Request f8557a;

            public AnonymousClass3(Request request2) {
                request = request2;
            }

            @Override // com.czhj.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request2) {
                return request == request2;
            }
        });
    }

    public void cancelAll() {
        cancelAll((RequestQueue.RequestFilter) new RequestQueue.RequestFilter() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.1
            public AnonymousClass1() {
            }

            @Override // com.czhj.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return true;
            }
        });
    }

    public SigmobRequestQueue(Network network, int i10, int i11) {
        this(network, i10, i11, new ExecutorsDelivery(ThreadPoolFactory.getFixIOExecutor()));
    }

    public final void a(Request<?> request, DelayedRequestHelper delayedRequestHelper) {
        if (this.f8553i.containsKey(request)) {
            b(request);
        }
        delayedRequestHelper.b();
        this.f8553i.put(request, delayedRequestHelper);
    }

    @Override // com.czhj.volley.RequestQueue
    public void cancelAll(RequestQueue.RequestFilter requestFilter) {
        super.cancelAll(requestFilter);
        Iterator<Map.Entry<Request<?>, DelayedRequestHelper>> it = this.f8553i.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Request<?>, DelayedRequestHelper> next = it.next();
            if (requestFilter.apply(next.getKey())) {
                next.getKey().cancel();
                next.getValue().a();
                it.remove();
            }
        }
    }

    public SigmobRequestQueue(Network network, int i10, int i11, ResponseDelivery responseDelivery) {
        super(network, i10, i11, responseDelivery);
        this.f8553i = new HashMap(10);
    }

    @Deprecated
    public Map<Request<?>, DelayedRequestHelper> a() {
        return this.f8553i;
    }

    @Override // com.czhj.volley.RequestQueue
    public void cancelAll(Object obj) {
        super.cancelAll(obj);
        cancelAll((RequestQueue.RequestFilter) new RequestQueue.RequestFilter() { // from class: com.czhj.sdk.common.network.SigmobRequestQueue.2

            /* renamed from: a */
            public final /* synthetic */ Object f8555a;

            public AnonymousClass2(Object obj2) {
                obj = obj2;
            }

            @Override // com.czhj.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }
}
