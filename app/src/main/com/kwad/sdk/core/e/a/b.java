package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.kwad.sdk.core.e.a.c;
import com.kwad.sdk.core.e.b.b;
import com.shu.priory.config.AdKeys;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> aBf = new LinkedBlockingQueue<>(1);
    private ServiceConnection aBd = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.b.1
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Objects.toString(iBinder);
                b.this.aBf.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.core.e.a.b$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Objects.toString(iBinder);
                b.this.aBf.put(iBinder);
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

    private c.C0494c Gc() {
        Context context;
        ServiceConnection serviceConnection;
        c cVar = new c();
        cVar.mContext = this.mContext;
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (c.isAdvertisingIdAvailable(this.mContext) && this.mContext.bindService(intent, this.aBd, 1)) {
                try {
                    try {
                        cVar.aBh = new c.C0494c();
                        b.a aVar = new b.a(this.aBf.take());
                        aVar.a(cVar.aBi);
                        aVar.b(cVar.aBj);
                        cVar.aBk.await(3000L, TimeUnit.MICROSECONDS);
                        context = this.mContext;
                        serviceConnection = this.aBd;
                    } catch (Throwable th2) {
                        this.mContext.unbindService(this.aBd);
                        throw th2;
                    }
                } catch (Exception unused) {
                    context = this.mContext;
                    serviceConnection = this.aBd;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Throwable th3) {
            th3.toString();
        }
        return cVar.aBh;
    }

    public final String getOAID() {
        String str;
        try {
            str = Settings.Global.getString(this.mContext.getContentResolver(), AdKeys.OAID);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = Settings.Secure.getString(this.mContext.getContentResolver(), AdKeys.OAID);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        if (str != null && !str.isEmpty()) {
            return str;
        }
        c.C0494c Gc = Gc();
        return Gc != null ? Gc.akr : "";
    }
}
