package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import wg.a;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.umeng.commonsdk.statistics.common.a$a */
    public static final class C0674a {

        /* renamed from: a */
        private final String f24622a;

        /* renamed from: b */
        private final boolean f24623b;

        public C0674a(String str, boolean z10) {
            this.f24622a = str;
            this.f24623b = z10;
        }

        public String b() {
            return this.f24622a;
        }

        public boolean a() {
            return this.f24623b;
        }
    }

    public static String a(Context context) {
        try {
            C0674a c10 = c(context);
            if (c10 != null && !c10.a()) {
                return c10.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0674a c10 = c(context);
            if (c10 == null) {
                return null;
            }
            return c10.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0674a c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper() || com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
            return null;
        }
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, bVar, 1)) {
            throw new IOException("Google Play connection failed");
        }
        try {
            try {
                c cVar = new c(bVar.a());
                boolean a10 = cVar.a(true);
                C0674a c0674a = new C0674a(a10 ? "" : cVar.a(), a10);
                context.unbindService(bVar);
                return c0674a;
            } catch (Exception e10) {
                throw e10;
            }
        } catch (Throwable th2) {
            context.unbindService(bVar);
            throw th2;
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: a */
        boolean f24624a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f24625b;

        private b() {
            this.f24624a = false;
            this.f24625b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f24624a) {
                throw new IllegalStateException();
            }
            this.f24624a = true;
            return this.f24625b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f24625b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static final class c implements IInterface {

        /* renamed from: a */
        private IBinder f24626a;

        public c(IBinder iBinder) {
            this.f24626a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(a.b.f31713b);
                this.f24626a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f24626a;
        }

        public boolean a(boolean z10) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(a.b.f31713b);
                obtain.writeInt(z10 ? 1 : 0);
                this.f24626a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
