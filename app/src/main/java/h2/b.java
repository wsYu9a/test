package h2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class b implements f2.b {

    /* renamed from: a */
    public static final String f26378a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* renamed from: b */
    public static final int f26379b = 1;

    /* renamed from: c */
    public static final int f26380c = 2;

    public static final class c implements IInterface {

        /* renamed from: b */
        public IBinder f26383b;

        public c(IBinder iBinder) {
            this.f26383b = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f26383b;
        }

        public boolean e() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(b.f26378a);
                this.f26383b.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public String j() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(b.f26378a);
                this.f26383b.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Override // f2.b
    public String a(Context context) {
        ServiceConnectionC0704b serviceConnectionC0704b = new ServiceConnectionC0704b();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC0704b, 1)) {
            try {
                return new c(serviceConnectionC0704b.a()).j();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC0704b);
            }
        }
        return null;
    }

    /* renamed from: h2.b$b */
    public static final class ServiceConnectionC0704b implements ServiceConnection {

        /* renamed from: b */
        public boolean f26381b;

        /* renamed from: c */
        public final LinkedBlockingQueue<IBinder> f26382c;

        public ServiceConnectionC0704b() {
            this.f26381b = false;
            this.f26382c = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f26381b) {
                throw new IllegalStateException();
            }
            this.f26381b = true;
            return this.f26382c.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f26382c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public /* synthetic */ ServiceConnectionC0704b(a aVar) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
