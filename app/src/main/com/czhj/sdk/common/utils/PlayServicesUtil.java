package com.czhj.sdk.common.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class PlayServicesUtil {

    public static final class AdvertisingConnection implements ServiceConnection {

        /* renamed from: a */
        public boolean f8650a;

        /* renamed from: b */
        public final LinkedBlockingQueue<IBinder> f8651b;

        public AdvertisingConnection() {
            this.f8650a = false;
            this.f8651b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f8650a) {
                throw new IllegalStateException();
            }
            this.f8650a = true;
            return this.f8651b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f8651b.put(iBinder);
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public /* synthetic */ AdvertisingConnection(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String str, boolean z10) {
            this.advertisingId = str;
            this.limitAdTracking = z10;
        }
    }

    public static final class AdvertisingInterface implements IInterface {

        /* renamed from: a */
        public final IBinder f8652a;

        public AdvertisingInterface(IBinder iBinder) {
            this.f8652a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f8652a;
        }

        public String j() throws RemoteException {
            return null;
        }

        public boolean k() throws RemoteException {
            return false;
        }
    }

    public static AdvertisingInfo getAdvertisingIdInfo(Context context) throws Exception {
        Looper.myLooper();
        Looper.getMainLooper();
        return null;
    }
}
