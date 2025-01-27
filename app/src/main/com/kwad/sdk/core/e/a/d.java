package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.d;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public final class d {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> aBf = new LinkedBlockingQueue<>(1);
    private ServiceConnection aBd = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.d.1
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.aBf.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.core.e.a.d$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.aBf.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public d(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.mContext.bindService(intent, this.aBd, 1)) {
                try {
                    d.a aVar = new d.a(this.aBf.take());
                    str = aVar.Ge();
                    aVar.Gf();
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                } catch (Throwable th2) {
                    this.mContext.unbindService(this.aBd);
                    throw th2;
                }
                context.unbindService(this.aBd);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
