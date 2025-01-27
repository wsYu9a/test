package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.b;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ahG = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.b.1
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.ahG.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.core.e.kwai.b$1 */
    final class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.ahG.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.mContext.bindService(intent, this.ahE, 1)) {
                try {
                    b.a aVar = new b.a(this.ahG.take());
                    str = aVar.wK();
                    boolean wL = aVar.wL();
                    StringBuilder sb = new StringBuilder("getOAID oaid:");
                    sb.append(str);
                    sb.append("--boos:");
                    sb.append(wL);
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.ahE);
                    throw th;
                }
                context.unbindService(this.ahE);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
