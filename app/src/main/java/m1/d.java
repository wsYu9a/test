package m1;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Route(path = "/arouter/service/interceptor")
/* loaded from: classes.dex */
public class d implements InterceptorService {

    /* renamed from: a */
    public static boolean f28253a;

    /* renamed from: b */
    public static final Object f28254b = new Object();

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Postcard f28255b;

        /* renamed from: c */
        public final /* synthetic */ InterceptorCallback f28256c;

        public a(Postcard postcard, InterceptorCallback interceptorCallback) {
            this.f28255b = postcard;
            this.f28256c = interceptorCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.a aVar = new o1.a(f.f28272f.size());
            try {
                d.a(0, aVar, this.f28255b);
                aVar.await(this.f28255b.getTimeout(), TimeUnit.SECONDS);
                if (aVar.getCount() > 0) {
                    this.f28256c.onInterrupt(new HandlerException("The interceptor processing timed out."));
                } else if (this.f28255b.getTag() != null) {
                    this.f28256c.onInterrupt((Throwable) this.f28255b.getTag());
                } else {
                    this.f28256c.onContinue(this.f28255b);
                }
            } catch (Exception e10) {
                this.f28256c.onInterrupt(e10);
            }
        }
    }

    public static class b implements InterceptorCallback {

        /* renamed from: a */
        public final /* synthetic */ o1.a f28258a;

        /* renamed from: b */
        public final /* synthetic */ int f28259b;

        /* renamed from: c */
        public final /* synthetic */ Postcard f28260c;

        public b(o1.a aVar, int i10, Postcard postcard) {
            this.f28258a = aVar;
            this.f28259b = i10;
            this.f28260c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            this.f28258a.countDown();
            d.a(this.f28259b + 1, this.f28258a, postcard);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th2) {
            Postcard postcard = this.f28260c;
            if (th2 == null) {
                th2 = new HandlerException("No message.");
            }
            postcard.setTag(th2);
            this.f28258a.a();
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Context f28261b;

        public c(Context context) {
            this.f28261b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p1.d.b(f.f28271e)) {
                Iterator<Map.Entry<Integer, Class<? extends IInterceptor>>> it = f.f28271e.entrySet().iterator();
                while (it.hasNext()) {
                    Class<? extends IInterceptor> value = it.next().getValue();
                    try {
                        IInterceptor newInstance = value.getConstructor(null).newInstance(null);
                        newInstance.init(this.f28261b);
                        f.f28272f.add(newInstance);
                    } catch (Exception e10) {
                        throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + value.getName() + "], reason = [" + e10.getMessage() + "]");
                    }
                }
                boolean unused = d.f28253a = true;
                n1.a.f28723e.info("ARouter::", "ARouter interceptors init over.");
                synchronized (d.f28254b) {
                    d.f28254b.notifyAll();
                }
            }
        }
    }

    public static void a(int i10, o1.a aVar, Postcard postcard) {
        if (i10 < f.f28272f.size()) {
            f.f28272f.get(i10).process(postcard, new b(aVar, i10, postcard));
        }
    }

    public static void e() {
        synchronized (f28254b) {
            while (!f28253a) {
                try {
                    f28254b.wait(10000L);
                } catch (InterruptedException e10) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e10.getMessage() + "]");
                }
            }
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.InterceptorService
    public void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback) {
        if (!p1.d.b(f.f28271e)) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        e();
        if (f28253a) {
            e.f28264b.execute(new a(postcard, interceptorCallback));
        } else {
            interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        e.f28264b.execute(new c(context));
    }
}
