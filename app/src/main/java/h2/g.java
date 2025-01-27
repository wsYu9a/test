package h2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import y2.a;

/* loaded from: classes.dex */
public class g implements f2.b {
    @Override // f2.b
    public String a(Context context) {
        b bVar = new b();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, bVar, 1)) {
            try {
                return a.AbstractBinderC0847a.g(bVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }

    public static final class b implements ServiceConnection {

        /* renamed from: b */
        public boolean f26390b;

        /* renamed from: c */
        public final LinkedBlockingQueue<IBinder> f26391c;

        public b() {
            this.f26390b = false;
            this.f26391c = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f26390b) {
                throw new IllegalStateException();
            }
            this.f26390b = true;
            return this.f26391c.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f26391c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
