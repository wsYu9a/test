package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.f;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public final class j {
    public Context mContext;
    private final LinkedBlockingQueue<IBinder> ahG = new LinkedBlockingQueue<>(1);
    private ServiceConnection ahE = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.j.1
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                j.this.ahG.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.core.e.kwai.j$1 */
    final class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                j.this.ahG.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.mContext.getPackageName());
            boolean bindService = this.mContext.bindService(intent, this.ahE, 1);
            new StringBuilder("getOAID isBind=").append(bindService);
            if (bindService) {
                try {
                    str = new f.a(this.ahG.take()).getOAID();
                    new StringBuilder("getOAID oaid:").append(str);
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
