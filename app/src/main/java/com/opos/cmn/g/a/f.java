package com.opos.cmn.g.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
public class f {

    public static final class a {

        /* renamed from: a */
        private final String f17394a;

        /* renamed from: b */
        private final boolean f17395b;

        a(String str, boolean z) {
            this.f17394a = str;
            this.f17395b = z;
        }

        public String a() {
            return this.f17394a;
        }

        public boolean b() {
            return this.f17395b;
        }
    }

    private static final class b implements ServiceConnection {

        /* renamed from: a */
        boolean f17396a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f17397b;

        private b() {
            this.f17396a = false;
            this.f17397b = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        public IBinder a() {
            if (this.f17396a) {
                throw new IllegalStateException();
            }
            this.f17396a = true;
            return this.f17397b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f17397b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static final class c implements IInterface {

        /* renamed from: a */
        private IBinder f17398a;

        public c(IBinder iBinder) {
            this.f17398a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f17398a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f17398a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f17398a;
        }
    }

    public static a a(Context context) {
        a aVar;
        synchronized (f.class) {
            aVar = null;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                com.opos.cmn.an.f.a.c("GoogleAdIdUtils", "Cannot call in the main thread, You must call in the other thread");
            } else {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                b bVar = new b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        c cVar = new c(bVar.a());
                        aVar = new a(cVar.a(), cVar.a(true));
                        context.unbindService(bVar);
                    } catch (Throwable th) {
                        context.unbindService(bVar);
                        throw th;
                    }
                }
            }
        }
        return aVar;
    }
}
