package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.e;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public final class e {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> aBf = new LinkedBlockingQueue<>(1);
    private ServiceConnection aBd = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.e.1
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                e.this.aBf.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.core.e.a.e$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                e.this.aBf.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.mContext.bindService(intent, this.aBd, 1)) {
                try {
                    str = new e.a(this.aBf.take()).getOaid();
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
