package org.repackage.com.vivo.identifier;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes5.dex */
public class IdentifierIdClient {
    private static String A = null;
    private static volatile IdentifierIdClient B = null;
    private static volatile DataBaseOperation C = null;

    /* renamed from: a */
    private static final String f35605a = "VMS_IDLG_SDK_Client";

    /* renamed from: b */
    private static final String f35606b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c */
    private static final String f35607c = "persist.sys.identifierid.supported";

    /* renamed from: d */
    private static final String f35608d = "appid";

    /* renamed from: e */
    private static final String f35609e = "type";

    /* renamed from: f */
    private static final String f35610f = "OAID";

    /* renamed from: g */
    private static final String f35611g = "VAID";

    /* renamed from: h */
    private static final String f35612h = "AAID";

    /* renamed from: i */
    private static final int f35613i = 0;

    /* renamed from: j */
    private static final int f35614j = 1;
    private static final int k = 2;
    private static final int l = 4;
    private static final int m = 11;
    private static final int n = 2000;
    private static Context o = null;
    private static boolean p = false;
    private static IdentifierIdObserver q;
    private static IdentifierIdObserver r;
    private static IdentifierIdObserver s;
    private static Object t = new Object();
    private static HandlerThread u;
    private static Handler v;
    private static String w;
    private static String x;
    private static String y;
    private static String z;

    /* renamed from: org.repackage.com.vivo.identifier.IdentifierIdClient$1 */
    static class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e(IdentifierIdClient.f35605a, "message type valid");
                return;
            }
            String unused = IdentifierIdClient.w = IdentifierIdClient.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
            synchronized (IdentifierIdClient.t) {
                IdentifierIdClient.t.notify();
            }
        }
    }

    private IdentifierIdClient() {
    }

    public static IdentifierIdClient a(Context context) {
        if (B == null) {
            synchronized (IdentifierIdClient.class) {
                o = context.getApplicationContext();
                B = new IdentifierIdClient();
            }
        }
        if (C == null) {
            synchronized (IdentifierIdClient.class) {
                o = context.getApplicationContext();
                g();
                C = new DataBaseOperation(o);
                d();
            }
        }
        return B;
    }

    public static void d() {
        p = "1".equals(a(f35607c, "0"));
    }

    private static void g() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new Handler(u.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    Log.e(IdentifierIdClient.f35605a, "message type valid");
                    return;
                }
                String unused = IdentifierIdClient.w = IdentifierIdClient.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (IdentifierIdClient.t) {
                    IdentifierIdClient.t.notify();
                }
            }
        };
    }

    public String b() {
        if (!a()) {
            return null;
        }
        String str = x;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        if (q == null) {
            a(o, 0, null);
        }
        return x;
    }

    public String c() {
        if (!a()) {
            return null;
        }
        a(4, (String) null);
        return A;
    }

    public String b(String str) {
        if (!a()) {
            return null;
        }
        String str2 = z;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        if (s == null && z != null) {
            a(o, 2, str);
        }
        return z;
    }

    private void b(int i2, String str) {
        Message obtainMessage = v.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        v.sendMessage(obtainMessage);
    }

    public boolean a() {
        return p;
    }

    public String a(String str) {
        if (!a()) {
            return null;
        }
        String str2 = y;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        if (r == null && y != null) {
            a(o, 1, str);
        }
        return y;
    }

    public void a(int i2, String str) {
        synchronized (t) {
            b(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                Log.d(f35605a, "query timeout");
            } else if (i2 == 0) {
                x = w;
                w = null;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    String str2 = w;
                    if (str2 != null) {
                        z = str2;
                        w = null;
                    } else {
                        Log.e(f35605a, "get aaid failed");
                    }
                } else if (i2 != 4) {
                }
                A = w;
                w = null;
            } else {
                String str3 = w;
                if (str3 != null) {
                    y = str3;
                    w = null;
                } else {
                    Log.e(f35605a, "get vaid failed");
                }
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, EnvironmentCompat.MEDIA_UNKNOWN);
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            q = new IdentifierIdObserver(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
            return;
        }
        if (i2 == 1) {
            r = new IdentifierIdObserver(B, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
            return;
        }
        if (i2 != 2) {
            return;
        }
        s = new IdentifierIdObserver(B, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
    }
}
