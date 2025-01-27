package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class UMConfigureImpl {

    /* renamed from: a */
    private static String f26095a = "delayed_transmission_flag_new";

    /* renamed from: e */
    private static final int f26099e = 1000;

    /* renamed from: f */
    private static ScheduledExecutorService f26100f;

    /* renamed from: g */
    private static Context f26101g;

    /* renamed from: b */
    private static CopyOnWriteArrayList<onMessageSendListener> f26096b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    private static int f26097c = 0;

    /* renamed from: d */
    private static boolean f26098d = false;

    /* renamed from: h */
    private static int f26102h = 0;

    /* renamed from: i */
    private static Runnable f26103i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f26097c == 0 || UMConfigureImpl.f26102h >= 10) {
                    if (!UMConfigureImpl.f26098d) {
                        boolean unused = UMConfigureImpl.f26098d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f26101g);
                    }
                    if (UMConfigureImpl.f26100f != null) {
                        UMConfigureImpl.f26100f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f26100f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    /* renamed from: com.umeng.commonsdk.UMConfigureImpl$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f26097c == 0 || UMConfigureImpl.f26102h >= 10) {
                    if (!UMConfigureImpl.f26098d) {
                        boolean unused = UMConfigureImpl.f26098d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f26101g);
                    }
                    if (UMConfigureImpl.f26100f != null) {
                        UMConfigureImpl.f26100f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f26100f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    }

    static /* synthetic */ int f() {
        int i2 = f26102h;
        f26102h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f26101g = context;
        try {
            if (f26097c < 1) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else if (d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f26100f == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                    f26100f = newScheduledThreadPool;
                    newScheduledThreadPool.scheduleAtFixedRate(f26103i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f26097c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = f26096b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = f26096b) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f26096b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f26097c--;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f26096b;
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
                CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = f26096b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<onMessageSendListener> it = f26096b.iterator();
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
            SharedPreferences sharedPreferences = context.getSharedPreferences(f26095a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(f26095a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f26095a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f26095a, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
