package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class UMConfigureImpl {

    /* renamed from: e */
    private static final int f24326e = 1000;

    /* renamed from: f */
    private static ScheduledExecutorService f24327f;

    /* renamed from: g */
    private static Context f24328g;

    /* renamed from: a */
    private static String f24322a = bd.b().b(bd.f23535o);

    /* renamed from: b */
    private static CopyOnWriteArrayList<onMessageSendListener> f24323b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    private static int f24324c = 0;

    /* renamed from: d */
    private static boolean f24325d = false;

    /* renamed from: h */
    private static int f24329h = 0;

    /* renamed from: i */
    private static Runnable f24330i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f24324c == 0 || UMConfigureImpl.f24329h >= 10) {
                    if (!UMConfigureImpl.f24325d) {
                        boolean unused = UMConfigureImpl.f24325d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f24328g);
                    }
                    if (UMConfigureImpl.f24327f != null) {
                        UMConfigureImpl.f24327f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f24327f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    /* renamed from: com.umeng.commonsdk.UMConfigureImpl$1 */
    public static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f24324c == 0 || UMConfigureImpl.f24329h >= 10) {
                    if (!UMConfigureImpl.f24325d) {
                        boolean unused = UMConfigureImpl.f24325d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f24328g);
                    }
                    if (UMConfigureImpl.f24327f != null) {
                        UMConfigureImpl.f24327f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f24327f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    }

    public static /* synthetic */ int f() {
        int i10 = f24329h;
        f24329h = i10 + 1;
        return i10;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f24328g = context;
        try {
            if (f24324c < 1) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else if (d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f24327f == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                    f24327f = newScheduledThreadPool;
                    newScheduledThreadPool.scheduleAtFixedRate(f24330i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f24324c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = f24323b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = f24323b) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f24323b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f24324c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f24323b;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f24323b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f24323b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f24322a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(f24322a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f24322a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f24322a, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
