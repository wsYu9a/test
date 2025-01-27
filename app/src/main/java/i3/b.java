package i3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.sigmob.sdk.base.common.y;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes.dex */
public class b {
    public static String A = null;
    public static volatile b B = null;
    public static volatile com.alipay.sdk.m.p0.b C = null;

    /* renamed from: a */
    public static final String f26847a = "VMS_IDLG_SDK_Client";

    /* renamed from: b */
    public static final String f26848b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c */
    public static final String f26849c = "persist.sys.identifierid.supported";

    /* renamed from: d */
    public static final String f26850d = "appid";

    /* renamed from: e */
    public static final String f26851e = "type";

    /* renamed from: f */
    public static final String f26852f = "OAID";

    /* renamed from: g */
    public static final String f26853g = "VAID";

    /* renamed from: h */
    public static final String f26854h = "AAID";

    /* renamed from: i */
    public static final int f26855i = 0;

    /* renamed from: j */
    public static final int f26856j = 1;

    /* renamed from: k */
    public static final int f26857k = 2;

    /* renamed from: l */
    public static final int f26858l = 4;

    /* renamed from: m */
    public static final int f26859m = 11;

    /* renamed from: n */
    public static final int f26860n = 2000;

    /* renamed from: o */
    public static Context f26861o = null;

    /* renamed from: p */
    public static boolean f26862p = false;

    /* renamed from: q */
    public static c f26863q;

    /* renamed from: r */
    public static c f26864r;

    /* renamed from: s */
    public static c f26865s;

    /* renamed from: t */
    public static Object f26866t = new Object();

    /* renamed from: u */
    public static HandlerThread f26867u;

    /* renamed from: v */
    public static Handler f26868v;

    /* renamed from: w */
    public static String f26869w;

    /* renamed from: x */
    public static String f26870x;

    /* renamed from: y */
    public static String f26871y;

    /* renamed from: z */
    public static String f26872z;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e(b.f26847a, "message type valid");
                return;
            }
            String unused = b.f26869w = b.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
            synchronized (b.f26866t) {
                b.f26866t.notify();
            }
        }
    }

    public static b a(Context context) {
        if (B == null) {
            synchronized (b.class) {
                f26861o = context.getApplicationContext();
                B = new b();
            }
        }
        if (C == null) {
            synchronized (b.class) {
                f26861o = context.getApplicationContext();
                o();
                C = new com.alipay.sdk.m.p0.b(f26861o);
                n();
            }
        }
        return B;
    }

    public static String d(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e10) {
                e10.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void f(Context context, int i10, String str) {
        if (i10 == 0) {
            f26863q = new c(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f26863q);
            return;
        }
        if (i10 == 1) {
            f26864r = new c(B, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f26864r);
            return;
        }
        if (i10 != 2) {
            return;
        }
        f26865s = new c(B, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, f26865s);
    }

    public static void n() {
        f26862p = "1".equals(d(f26849c, "0"));
    }

    public static void o() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        f26867u = handlerThread;
        handlerThread.start();
        f26868v = new a(f26867u.getLooper());
    }

    public String b() {
        if (!k()) {
            return null;
        }
        String str = f26870x;
        if (str != null) {
            return str;
        }
        e(0, null);
        if (f26863q == null) {
            f(f26861o, 0, null);
        }
        return f26870x;
    }

    public String c(String str) {
        if (!k()) {
            return null;
        }
        String str2 = f26872z;
        if (str2 != null) {
            return str2;
        }
        e(2, str);
        if (f26865s == null && f26872z != null) {
            f(f26861o, 2, str);
        }
        return f26872z;
    }

    public void e(int i10, String str) {
        synchronized (f26866t) {
            i(i10, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f26866t.wait(y.f.f18076n);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= y.f.f18076n) {
                Log.d(f26847a, "query timeout");
            } else if (i10 == 0) {
                f26870x = f26869w;
                f26869w = null;
            } else if (i10 != 1) {
                if (i10 == 2) {
                    String str2 = f26869w;
                    if (str2 != null) {
                        f26872z = str2;
                        f26869w = null;
                    } else {
                        Log.e(f26847a, "get aaid failed");
                    }
                } else if (i10 != 4) {
                }
                A = f26869w;
                f26869w = null;
            } else {
                String str3 = f26869w;
                if (str3 != null) {
                    f26871y = str3;
                    f26869w = null;
                } else {
                    Log.e(f26847a, "get vaid failed");
                }
            }
        }
    }

    public String g() {
        if (!k()) {
            return null;
        }
        e(4, null);
        return A;
    }

    public String h(String str) {
        if (!k()) {
            return null;
        }
        String str2 = f26871y;
        if (str2 != null) {
            return str2;
        }
        e(1, str);
        if (f26864r == null && f26871y != null) {
            f(f26861o, 1, str);
        }
        return f26871y;
    }

    public final void i(int i10, String str) {
        Message obtainMessage = f26868v.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i10);
        if (i10 == 1 || i10 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f26868v.sendMessage(obtainMessage);
    }

    public boolean k() {
        return f26862p;
    }
}
