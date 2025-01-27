package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.c;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public final class c {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahG = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.c.1
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.ahG.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.core.e.kwai.c$1 */
    final class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.ahG.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public c(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.mContext.bindService(intent, this.ahE, 1)) {
                try {
                    try {
                        str = new c.a(this.ahG.take()).getOaid();
                        new StringBuilder("getOAID oaid:").append(str);
                        context = this.mContext;
                    } catch (Throwable th) {
                        this.mContext.unbindService(this.ahE);
                        throw th;
                    }
                } catch (Exception unused) {
                    context = this.mContext;
                }
                context.unbindService(this.ahE);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
