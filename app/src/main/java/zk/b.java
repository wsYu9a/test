package zk;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.sigmob.sdk.base.common.y;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import jh.c;
import p013while.Cdo;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a */
    public static Context f33872a;

    /* renamed from: b */
    public static boolean f33873b;

    /* renamed from: c */
    public static b f33874c;

    /* renamed from: d */
    public static Cdo f33875d;

    /* renamed from: e */
    public static zk.a f33876e;

    /* renamed from: f */
    public static zk.a f33877f;

    /* renamed from: g */
    public static zk.a f33878g;

    /* renamed from: h */
    public static Object f33879h = new Object();

    /* renamed from: i */
    public static HandlerThread f33880i;

    /* renamed from: j */
    public static a f33881j;

    /* renamed from: k */
    public static String f33882k;

    /* renamed from: l */
    public static String f33883l;

    /* renamed from: m */
    public static String f33884m;

    /* renamed from: n */
    public static String f33885n;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 11) {
                c.g(i3.b.f26847a, "message type valid");
                return;
            }
            try {
                b.f33882k = b.f33875d.a(message.getData().getInt("type"), message.getData().getString("appid"));
            } catch (Exception e10) {
                b.f33882k = "";
                c.b(i3.b.f26847a, "exception", e10);
            }
            Context context = b.f33872a;
            Object obj = b.f33879h;
            synchronized (obj) {
                obj.notify();
            }
        }
    }

    public static b a(Context context) {
        String str;
        if (f33874c == null) {
            f33874c = new b();
            f33872a = context;
            HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
            f33880i = handlerThread;
            handlerThread.start();
            f33881j = new a(f33880i.getLooper());
            f33875d = new Cdo(f33872a);
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, i3.b.f26849c, "unknown");
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "0";
                f33873b = "1".equals(str);
                return f33874c;
            } catch (Throwable unused) {
                str = "0";
                f33873b = "1".equals(str);
                return f33874c;
            }
            f33873b = "1".equals(str);
        }
        return f33874c;
    }

    public static void c(Context context, int i10, String str) {
        ContentResolver contentResolver;
        Uri parse;
        zk.a aVar;
        if (i10 == 0) {
            f33876e = new zk.a(f33874c, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f33876e);
            return;
        }
        if (i10 == 1) {
            f33877f = new zk.a(f33874c, 1, str);
            contentResolver = context.getContentResolver();
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
            aVar = f33877f;
        } else {
            if (i10 != 2) {
                return;
            }
            f33878g = new zk.a(f33874c, 2, str);
            contentResolver = context.getContentResolver();
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
            aVar = f33878g;
        }
        contentResolver.registerContentObserver(parse, false, aVar);
    }

    public final void b(int i10, String str) {
        String str2;
        Object obj = f33879h;
        synchronized (obj) {
            Message obtainMessage = f33881j.obtainMessage();
            obtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i10);
            if (i10 == 1 || i10 == 2) {
                bundle.putString("appid", str);
            }
            obtainMessage.setData(bundle);
            f33881j.sendMessage(obtainMessage);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                obj.wait(y.f.f18076n);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < y.f.f18076n) {
                if (i10 != 0) {
                    if (i10 == 1) {
                        String str3 = f33882k;
                        if (str3 != null) {
                            f33884m = str3;
                        } else {
                            str2 = "get vaid failed";
                            c.g(i3.b.f26847a, str2);
                        }
                    } else if (i10 == 2) {
                        String str4 = f33882k;
                        if (str4 != null) {
                            f33885n = str4;
                        } else {
                            str2 = "get aaid failed";
                            c.g(i3.b.f26847a, str2);
                        }
                    }
                }
                f33883l = f33882k;
                f33882k = null;
            } else {
                c.g(i3.b.f26847a, "query timeout");
            }
        }
    }
}
