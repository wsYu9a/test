package com.shu.priory.utils.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.a.a;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a */
    protected Context f17277a;

    /* renamed from: b */
    private final LinkedBlockingQueue<IBinder> f17278b = new LinkedBlockingQueue<>(1);

    /* renamed from: c */
    private ServiceConnection f17279c = new ServiceConnection() { // from class: com.shu.priory.utils.a.a.b.1
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f17278b.put(iBinder);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.shu.priory.utils.a.a.b$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f17278b.put(iBinder);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public b(Context context) {
        this.f17277a = context;
    }

    public abstract String a();

    public abstract int b();

    public boolean c() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public abstract Intent d();

    public String[] e() {
        return null;
    }

    public void a(a.InterfaceC0558a interfaceC0558a) {
        Context context;
        try {
            if (!c()) {
                com.shu.priory.utils.h.a(SDKConstants.TAG, "not support");
                return;
            }
            Intent d10 = d();
            if (d10 != null && this.f17277a.bindService(d10, this.f17279c, 1)) {
                try {
                    com.shu.priory.utils.h.a(SDKConstants.TAG, "bind success");
                    IBinder take = this.f17278b.take();
                    String a10 = a();
                    if (!TextUtils.isEmpty(a10)) {
                        String a11 = new d(take, a10).a(b(), e());
                        if (interfaceC0558a != null) {
                            interfaceC0558a.a(a11);
                        }
                    }
                    context = this.f17277a;
                } catch (Exception unused) {
                    context = this.f17277a;
                } catch (Throwable th2) {
                    this.f17277a.unbindService(this.f17279c);
                    throw th2;
                }
                context.unbindService(this.f17279c);
            }
        } catch (Throwable unused2) {
            com.shu.priory.utils.h.a(SDKConstants.TAG, "get oaid error");
        }
    }
}
