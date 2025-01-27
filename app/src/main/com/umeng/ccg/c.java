package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static Handler f24257a = null;

    /* renamed from: b */
    public static final int f24258b = 101;

    /* renamed from: c */
    public static final int f24259c = 102;

    /* renamed from: d */
    public static final int f24260d = 103;

    /* renamed from: e */
    public static final int f24261e = 104;

    /* renamed from: f */
    public static final int f24262f = 105;

    /* renamed from: g */
    public static final int f24263g = 106;

    /* renamed from: h */
    public static final int f24264h = 107;

    /* renamed from: i */
    public static final int f24265i = 0;

    /* renamed from: j */
    public static final int f24266j = 1;

    /* renamed from: k */
    public static final int f24267k = 2;

    /* renamed from: l */
    public static final int f24268l = 201;

    /* renamed from: m */
    public static final int f24269m = 202;

    /* renamed from: n */
    public static final int f24270n = 203;

    /* renamed from: o */
    public static final int f24271o = 301;

    /* renamed from: p */
    public static final int f24272p = 302;

    /* renamed from: q */
    public static final int f24273q = 303;

    /* renamed from: r */
    public static final int f24274r = 304;

    /* renamed from: s */
    public static final int f24275s = 305;

    /* renamed from: t */
    private static HandlerThread f24276t = null;

    /* renamed from: u */
    private static HashMap<Integer, a> f24277u = null;

    /* renamed from: v */
    private static final int f24278v = 256;

    /* renamed from: com.umeng.ccg.c$1 */
    public static class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 256) {
                return;
            }
            c.b(message);
        }
    }

    public interface a {
        void a(Object obj, int i10);
    }

    private c() {
    }

    public static void b(Message message) {
        int i10 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i10 / 100);
        HashMap<Integer, a> hashMap = f24277u;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? f24277u.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i10);
        }
    }

    public static void a(Context context, int i10, int i11, a aVar, Object obj, long j10) {
        if (context == null || aVar == null) {
            return;
        }
        if (f24277u == null) {
            f24277u = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i11 / 100);
        if (!f24277u.containsKey(valueOf)) {
            f24277u.put(valueOf, aVar);
        }
        if (f24276t == null || f24257a == null) {
            a();
        }
        try {
            Handler handler = f24257a;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i10;
                obtainMessage.arg1 = i11;
                obtainMessage.obj = obj;
                f24257a.sendMessageDelayed(obtainMessage, j10);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i10, a aVar, Object obj) {
        a(context, 256, i10, aVar, obj, 0L);
    }

    public static void a(Context context, int i10, a aVar, Object obj, long j10) {
        a(context, 256, i10, aVar, obj, j10);
    }

    private static synchronized void a() {
        synchronized (c.class) {
            try {
                if (f24276t == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    f24276t = handlerThread;
                    handlerThread.start();
                    if (f24257a == null) {
                        f24257a = new Handler(f24276t.getLooper()) { // from class: com.umeng.ccg.c.1
                            public AnonymousClass1(Looper looper) {
                                super(looper);
                            }

                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                c.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
