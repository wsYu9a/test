package hh;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class b implements ServiceConnection {

    /* renamed from: d */
    public static final ThreadPoolExecutor f26731d = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: b */
    public boolean f26732b = false;

    /* renamed from: c */
    public final LinkedBlockingQueue<IBinder> f26733c = new LinkedBlockingQueue<>(1);

    public class a implements Runnable {

        /* renamed from: b */
        public final IBinder f26734b;

        public a(IBinder iBinder) {
            this.f26734b = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
                b.this.f26733c.offer(this.f26734b);
            } catch (Throwable th2) {
                StringBuilder a10 = nh.b.a("onServiceConnected  ");
                a10.append(th2.getClass().getSimpleName());
                Log.w("PPSSerivceConnection", a10.toString());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("PPSSerivceConnection", "onServiceConnected");
        f26731d.execute(new a(iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        StringBuilder a10 = nh.b.a("onServiceDisconnected ");
        a10.append(System.currentTimeMillis());
        Log.d("PPSSerivceConnection", a10.toString());
    }
}
