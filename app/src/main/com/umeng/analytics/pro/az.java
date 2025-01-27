package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class az {

    /* renamed from: a */
    public static Handler f23490a = null;

    /* renamed from: b */
    public static final int f23491b = 101;

    /* renamed from: c */
    private static HandlerThread f23492c = null;

    /* renamed from: d */
    private static HashMap<Integer, a> f23493d = null;

    /* renamed from: e */
    private static final int f23494e = 256;

    /* renamed from: com.umeng.analytics.pro.az$1 */
    public static class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 256) {
                return;
            }
            az.b(message);
        }
    }

    public interface a {
        void a(Object obj, int i10);
    }

    private az() {
    }

    public static void b(Message message) {
        int i10 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i10 / 100);
        HashMap<Integer, a> hashMap = f23493d;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? f23493d.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i10);
        }
    }

    public static void a(Context context, int i10, int i11, a aVar, Object obj, long j10) {
        if (context == null || aVar == null) {
            return;
        }
        if (f23493d == null) {
            f23493d = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i11 / 100);
        if (!f23493d.containsKey(valueOf)) {
            f23493d.put(valueOf, aVar);
        }
        if (f23492c == null || f23490a == null) {
            a();
        }
        try {
            Handler handler = f23490a;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i10;
                obtainMessage.arg1 = i11;
                obtainMessage.obj = obj;
                f23490a.sendMessageDelayed(obtainMessage, j10);
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
        synchronized (az.class) {
            try {
                if (f23492c == null) {
                    HandlerThread handlerThread = new HandlerThread("ck_dispatch");
                    f23492c = handlerThread;
                    handlerThread.start();
                    if (f23490a == null) {
                        f23490a = new Handler(f23492c.getLooper()) { // from class: com.umeng.analytics.pro.az.1
                            public AnonymousClass1(Looper looper) {
                                super(looper);
                            }

                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                az.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
