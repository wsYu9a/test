package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes.dex */
public final class AsyncLayoutInflater {

    /* renamed from: a */
    private static final String f1073a = "AsyncLayoutInflater";

    /* renamed from: b */
    LayoutInflater f1074b;

    /* renamed from: e */
    private Handler.Callback f1077e = new Handler.Callback() { // from class: androidx.asynclayoutinflater.view.AsyncLayoutInflater.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f1083d == null) {
                inflateRequest.f1083d = AsyncLayoutInflater.this.f1074b.inflate(inflateRequest.f1082c, inflateRequest.f1081b, false);
            }
            inflateRequest.f1084e.onInflateFinished(inflateRequest.f1083d, inflateRequest.f1082c, inflateRequest.f1081b);
            AsyncLayoutInflater.this.f1076d.releaseRequest(inflateRequest);
            return true;
        }
    };

    /* renamed from: c */
    Handler f1075c = new Handler(this.f1077e);

    /* renamed from: d */
    InflateThread f1076d = InflateThread.getInstance();

    /* renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$1 */
    class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.f1083d == null) {
                inflateRequest.f1083d = AsyncLayoutInflater.this.f1074b.inflate(inflateRequest.f1082c, inflateRequest.f1081b, false);
            }
            inflateRequest.f1084e.onInflateFinished(inflateRequest.f1083d, inflateRequest.f1082c, inflateRequest.f1081b);
            AsyncLayoutInflater.this.f1076d.releaseRequest(inflateRequest);
            return true;
        }
    }

    private static class BasicInflater extends LayoutInflater {

        /* renamed from: a */
        private static final String[] f1079a = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            for (String str2 : f1079a) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class InflateRequest {

        /* renamed from: a */
        AsyncLayoutInflater f1080a;

        /* renamed from: b */
        ViewGroup f1081b;

        /* renamed from: c */
        int f1082c;

        /* renamed from: d */
        View f1083d;

        /* renamed from: e */
        OnInflateFinishedListener f1084e;

        InflateRequest() {
        }
    }

    private static class InflateThread extends Thread {

        /* renamed from: a */
        private static final InflateThread f1085a;

        /* renamed from: b */
        private ArrayBlockingQueue<InflateRequest> f1086b = new ArrayBlockingQueue<>(10);

        /* renamed from: c */
        private Pools.SynchronizedPool<InflateRequest> f1087c = new Pools.SynchronizedPool<>(10);

        static {
            InflateThread inflateThread = new InflateThread();
            f1085a = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return f1085a;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.f1086b.put(inflateRequest);
            } catch (InterruptedException e2) {
                throw new RuntimeException("Failed to enqueue async inflate request", e2);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.f1087c.acquire();
            return acquire == null ? new InflateRequest() : acquire;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.f1084e = null;
            inflateRequest.f1080a = null;
            inflateRequest.f1081b = null;
            inflateRequest.f1082c = 0;
            inflateRequest.f1083d = null;
            this.f1087c.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                InflateRequest take = this.f1086b.take();
                try {
                    take.f1083d = take.f1080a.f1074b.inflate(take.f1082c, take.f1081b, false);
                } catch (RuntimeException e2) {
                    Log.w(AsyncLayoutInflater.f1073a, "Failed to inflate resource in the background! Retrying on the UI thread", e2);
                }
                Message.obtain(take.f1080a.f1075c, 0, take).sendToTarget();
            } catch (InterruptedException e3) {
                Log.w(AsyncLayoutInflater.f1073a, e3);
            }
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view, @LayoutRes int i2, @Nullable ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.f1074b = new BasicInflater(context);
    }

    @UiThread
    public void inflate(@LayoutRes int i2, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        InflateRequest obtainRequest = this.f1076d.obtainRequest();
        obtainRequest.f1080a = this;
        obtainRequest.f1082c = i2;
        obtainRequest.f1081b = viewGroup;
        obtainRequest.f1084e = onInflateFinishedListener;
        this.f1076d.enqueue(obtainRequest);
    }
}
