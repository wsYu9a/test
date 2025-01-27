package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.b.a;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public final class a {
    private final LinkedBlockingQueue<IBinder> aBc = new LinkedBlockingQueue<>(1);
    private ServiceConnection aBd = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.a.1
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.aBc.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context mContext;

    /* renamed from: com.kwad.sdk.core.e.a.a$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.aBc.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.mContext.bindService(intent, this.aBd, 1)) {
                try {
                    try {
                        str = new a.C0495a(this.aBc.take()).getID();
                        context = this.mContext;
                    } catch (Throwable th2) {
                        this.mContext.unbindService(this.aBd);
                        throw th2;
                    }
                } catch (Exception unused) {
                    context = this.mContext;
                }
                context.unbindService(this.aBd);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
