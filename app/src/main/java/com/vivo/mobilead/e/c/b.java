package com.vivo.mobilead.e.c;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static Object f28808a = new Object();

    /* renamed from: b */
    private static Context f28809b = null;

    /* renamed from: c */
    private static boolean f28810c = false;

    /* renamed from: d */
    private static d f28811d;

    /* renamed from: e */
    private static d f28812e;

    /* renamed from: f */
    private static d f28813f;

    /* renamed from: g */
    private static HandlerThread f28814g;

    /* renamed from: h */
    private static Handler f28815h;

    /* renamed from: i */
    private static String f28816i;

    /* renamed from: j */
    private static String f28817j;
    private static String k;
    private static String l;
    private static volatile b m;
    private static volatile com.vivo.mobilead.e.c.a n;
    private static int o;
    private static int p;
    private static int q;
    private static int r;
    private static int s;
    private static int t;
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y;
    private static int z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.o + b.p + b.u + b.x + b.q + b.r + b.w + b.x + b.s + b.t + b.y + b.z > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("oaid", b.this.a(b.o, b.p, b.u, b.v));
                contentValues.put("vaid", b.this.a(b.q, b.r, b.w, b.x));
                contentValues.put("aaid", b.this.a(b.s, b.t, b.y, b.z));
                b.n.a(7, "vivo", new ContentValues[]{contentValues});
                int unused = b.o = b.p = b.q = b.r = b.s = b.t = 0;
                int unused2 = b.u = b.v = b.w = b.x = b.y = b.z = 0;
            }
        }
    }

    /* renamed from: com.vivo.mobilead.e.c.b$b */
    static class HandlerC0591b extends Handler {
        HandlerC0591b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                c.b("VMS_SDK_Client", "message type valid");
                return;
            }
            int i2 = message.getData().getInt("type");
            try {
                String a2 = b.n.a(i2, message.getData().getString("appid"));
                if (i2 == 0) {
                    String unused = b.f28816i = a2;
                    b.d(8, b.f28816i);
                } else if (i2 == 1) {
                    if (a2 != null) {
                        String unused2 = b.f28817j = a2;
                    } else {
                        c.b("VMS_SDK_Client", "get vaid failed");
                    }
                    b.d(9, b.f28817j);
                } else if (i2 == 2) {
                    if (a2 != null) {
                        String unused3 = b.k = a2;
                    } else {
                        c.b("VMS_SDK_Client", "get aaid failed");
                    }
                    b.d(10, b.k);
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        String unused4 = b.l = a2;
                    } else if (i2 == 5) {
                        if (a2 != null) {
                            b.f(a2);
                        } else {
                            c.b("VMS_SDK_Client", "get guid failed");
                        }
                    }
                } else if (a2 != null) {
                    b.d(a2);
                } else {
                    c.b("VMS_SDK_Client", "get udid failed");
                }
            } catch (Exception e2) {
                c.b("VMS_SDK_Client", "readException:" + e2.toString());
            }
            synchronized (b.f28808a) {
                b.f28808a.notify();
            }
        }
    }

    private b() {
        v();
        n = new com.vivo.mobilead.e.c.a(f28809b);
        c(f28809b);
    }

    static /* synthetic */ String d(String str) {
        return str;
    }

    static /* synthetic */ String f(String str) {
        return str;
    }

    private static void u() {
        f28810c = "1".equals(a("persist.sys.identifierid.supported", "0")) || "1".equals(a("persist.sys.identifierid", "0"));
    }

    private static void v() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        f28814g = handlerThread;
        handlerThread.start();
        f28815h = new HandlerC0591b(f28814g.getLooper());
    }

    static boolean w() {
        if (!f28810c) {
            u();
        }
        return f28810c;
    }

    private void x() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new a(), 600L, 600L, TimeUnit.SECONDS);
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void d(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                p++;
                return;
            } else {
                o++;
            }
        }
        if (i2 == 1) {
            if (str == null) {
                r++;
                return;
            } else {
                q++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                t++;
                return;
            } else {
                s++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str != null) {
                    u++;
                    break;
                } else {
                    v++;
                    break;
                }
            case 9:
                if (str != null) {
                    w++;
                    break;
                } else {
                    x++;
                    break;
                }
            case 10:
                if (str != null) {
                    y++;
                    break;
                } else {
                    z++;
                    break;
                }
        }
    }

    public String a(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(";");
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    static b b(Context context) {
        if (f28809b == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f28809b = context;
        }
        if (m == null) {
            synchronized (b.class) {
                if (m == null) {
                    m = new b();
                    m.x();
                }
            }
        }
        return m;
    }

    static b a(Context context) {
        if (w()) {
            return b(context);
        }
        return null;
    }

    String a() {
        String str = f28816i;
        if (str != null) {
            d(0, str);
            return f28816i;
        }
        c(0, null);
        if (f28811d == null) {
            a(f28809b, 0, null);
        }
        d(0, f28816i);
        return f28816i;
    }

    String c() {
        String str = f28817j;
        if (str != null) {
            d(1, str);
            return f28817j;
        }
        c(1, "vivo");
        if (f28812e == null) {
            a(f28809b, 1, "vivo");
        }
        d(1, f28817j);
        return f28817j;
    }

    String b() {
        c(4, null);
        return l;
    }

    private void c(int i2, String str) {
        synchronized (f28808a) {
            a(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f28808a.wait(2000L);
            } catch (InterruptedException unused) {
                c.b("VMS_SDK_Client", "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                c.a("VMS_SDK_Client", "query timeout");
            }
        }
    }

    void a(int i2, String str) {
        Message obtainMessage = f28815h.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f28815h.sendMessage(obtainMessage);
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e2) {
                c.b("VMS_SDK_Client", "getProperty: invoke is error" + e2.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static synchronized void a(Context context, int i2, String str) {
        synchronized (b.class) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (f28813f == null) {
                            f28813f = new d(m, 2, str);
                            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, f28813f);
                        }
                    }
                } else if (f28812e == null) {
                    f28812e = new d(m, 1, str);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f28812e);
                }
            } else if (f28811d == null) {
                f28811d = new d(m, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f28811d);
            }
        }
    }
}
