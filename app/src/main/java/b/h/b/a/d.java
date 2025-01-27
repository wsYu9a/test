package b.h.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import h.a.a.a;
import h.a.a.b;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public volatile h.a.a.b f5048a = null;

    /* renamed from: b */
    public String f5049b = null;

    /* renamed from: c */
    public String f5050c = null;

    /* renamed from: d */
    public final Object f5051d = new Object();

    /* renamed from: e */
    public ServiceConnection f5052e = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.h.b.a.b.a("2014");
            d.this.f5048a = b.a.b(iBinder);
            synchronized (d.this.f5051d) {
                b.h.b.a.b.a("2015");
                d.this.f5051d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.h.b.a.b.a("2016");
            d.this.f5048a = null;
        }
    }

    public static class b {

        /* renamed from: a */
        public static final d f5054a = new d();
    }

    public String a(Context context, String str) {
        String str2;
        String str3;
        String c2;
        synchronized (this) {
            if (this.f5048a == null) {
                b.h.b.a.b.a("2009");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
                intent.setAction("action.com.oplus.stdid.ID_SERVICE");
                b.h.b.a.b.a("2012");
                try {
                    if (context.bindService(intent, this.f5052e, 1)) {
                        b.h.b.a.b.a("2013");
                        if (this.f5048a == null) {
                            synchronized (this.f5051d) {
                                try {
                                    if (this.f5048a == null) {
                                        this.f5051d.wait(10000L);
                                    }
                                } catch (InterruptedException unused) {
                                    Log.e("StdIDHelper", "1006");
                                }
                            }
                        }
                    } else {
                        Log.e("StdIDHelper", "1007");
                    }
                } catch (Exception e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("1008 ");
                    sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                    Log.e("StdIDHelper", sb.toString());
                }
                if (this.f5048a == null) {
                    str2 = "StdIDHelper";
                    str3 = "1004";
                } else {
                    try {
                        b.h.b.a.b.a("2010");
                        c2 = c(context, str);
                    } catch (RemoteException unused2) {
                        str2 = "StdIDHelper";
                        str3 = "1005";
                    }
                }
                Log.e(str2, str3);
                c2 = "";
            } else {
                try {
                    b.h.b.a.b.a("2011");
                    c2 = c(context, str);
                } catch (RemoteException unused3) {
                    str2 = "StdIDHelper";
                    str3 = "1005";
                }
            }
        }
        return c2;
    }

    public void b(Context context) {
        synchronized (this) {
            try {
                if (this.f5048a != null) {
                    b.h.b.a.b.a("2019");
                    context.unbindService(this.f5052e);
                    this.f5048a = null;
                }
            } catch (Exception unused) {
                Log.e("StdIDHelper", "1010");
            }
        }
    }

    public final String c(Context context, String str) {
        if (TextUtils.isEmpty(this.f5049b)) {
            this.f5049b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f5050c)) {
            this.f5050c = a.b.b(context, this.f5049b, "SHA1");
        }
        b.h.b.a.b.a("2017");
        if (this.f5048a != null) {
            String a2 = this.f5048a.a(this.f5049b, this.f5050c, str);
            b.h.b.a.b.a("2018");
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        Log.e("StdIDHelper", context.getPackageName() + " 1009");
        return "";
    }
}
