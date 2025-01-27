package new0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import wg.a;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: new0.a$a */
    public static final class C0747a {

        /* renamed from: a */
        public final String f28853a;

        public C0747a(String str) {
            this.f28853a = str;
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: b */
        public boolean f28854b = false;

        /* renamed from: c */
        public final LinkedBlockingQueue<IBinder> f28855c = new LinkedBlockingQueue<>(1);

        public final IBinder a() {
            if (this.f28854b) {
                throw new IllegalStateException();
            }
            this.f28854b = true;
            return this.f28855c.take();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f28855c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static C0747a a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                IBinder a10 = bVar.a();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.b.f31713b);
                    a10.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    obtain = Parcel.obtain();
                    obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(a.b.f31713b);
                        obtain.writeInt(1);
                        a10.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        obtain2.readInt();
                        obtain2.recycle();
                        obtain.recycle();
                        return new C0747a(readString);
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e10) {
                throw e10;
            }
        } finally {
            context.unbindService(bVar);
        }
    }
}
