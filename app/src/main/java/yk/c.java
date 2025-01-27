package yk;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import bh.b;
import com.baidu.mobads.sdk.internal.bm;
import com.sntech.net.DomainProvider;
import com.sntech.net.NetClient;
import com.sntech.net.NetRequest;
import com.umeng.analytics.pro.bt;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class c implements Thread.UncaughtExceptionHandler {

    /* renamed from: b */
    public static final String f33566b = "c";

    /* renamed from: c */
    public static Handler f33567c;

    /* renamed from: d */
    public static HandlerThread f33568d;

    /* renamed from: a */
    public Thread.UncaughtExceptionHandler f33569a;

    static {
        HandlerThread handlerThread = new HandlerThread("checkNewHandler");
        f33568d = handlerThread;
        handlerThread.start();
        f33567c = new Handler(f33568d.getLooper());
    }

    public c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f33569a = uncaughtExceptionHandler;
    }

    public static void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        b.a.f1608a.f(f33566b, "try remove in handler: " + uncaughtExceptionHandler);
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal")) {
            return;
        }
        ArrayList arrayList = (ArrayList) mj.g.c(uncaughtExceptionHandler, Thread.UncaughtExceptionHandler.class);
        if (arrayList.size() == 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Field field = (Field) it.next();
            Object b10 = mj.g.b(uncaughtExceptionHandler, field);
            bh.j jVar = b.a.f1608a;
            String str = f33566b;
            jVar.f(str, "child handler: " + b10);
            if (b10 != null && b10 != uncaughtExceptionHandler && !b10.getClass().getName().startsWith("com.android.internal")) {
                if (b10 instanceof c) {
                    StringBuilder a10 = nh.b.a("remove: default handler = ");
                    c cVar = (c) b10;
                    a10.append(cVar.f33569a);
                    jVar.f(str, a10.toString());
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = cVar.f33569a;
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    try {
                        if (Modifier.isFinal(field.getModifiers())) {
                            Field declaredField = Field.class.getDeclaredField("accessFlags");
                            declaredField.setAccessible(true);
                            declaredField.setInt(field, field.getModifiers() & (-17));
                        }
                        field.set(uncaughtExceptionHandler, uncaughtExceptionHandler2);
                    } catch (Throwable th2) {
                        Log.e("goto", "setFieldValue:", th2);
                    }
                }
                a((Thread.UncaughtExceptionHandler) b10);
            }
        }
    }

    public final void b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Thread thread, @NonNull Throwable th2) {
        if (uncaughtExceptionHandler == null) {
            return;
        }
        if (uncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal")) {
            b.a.f1608a.f(f33566b, "handle exception by android internal handler");
            uncaughtExceptionHandler.uncaughtException(thread, th2);
            return;
        }
        ArrayList arrayList = (ArrayList) mj.g.c(uncaughtExceptionHandler, Thread.UncaughtExceptionHandler.class);
        if (arrayList.size() == 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object b10 = mj.g.b(uncaughtExceptionHandler, (Field) it.next());
            if (b10 != null && b10 != uncaughtExceptionHandler) {
                b((Thread.UncaughtExceptionHandler) b10, thread, th2);
            }
        }
    }

    public final void c(Thread thread, Throwable th2, boolean z10) {
        bh.j jVar;
        String str;
        String str2;
        if (mj.j.a().getBoolean("crash_handler_enabled", false) || (mj.f.c() && z10)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("crash_id", UUID.randomUUID().toString());
                jSONObject.put("thread", thread.toString());
                jSONObject.put("exception", mj.i.a(th2));
                jSONObject.put(o3.a.f29032k, System.currentTimeMillis());
                jSONObject.put("self_crash", z10 ? 1 : 0);
                jSONObject.put("loaded_plugin_versions", mj.f.a());
                jSONObject.put(bt.f23593aj, Build.VERSION.SDK_INT);
                jSONObject.put(bm.f6905j, Build.BRAND);
                jSONObject.put(bm.f6904i, Build.MODEL);
            } catch (Throwable unused) {
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            String str3 = DomainProvider.baseUrl() + "hc";
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(NotificationCompat.CATEGORY_EVENT, "APP_CRASHED");
                jSONObject2.put("event_extra", jSONObject);
                Object obj = new Object();
                NetClient.postEncryptAsync(new NetRequest.Builder().url(str3).requestJSON(jSONObject2).checkReqId(false).build(), new mj.h(atomicBoolean, obj));
                synchronized (obj) {
                    obj.wait();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            if (atomicBoolean.get()) {
                jVar = b.a.f1608a;
                str = f33566b;
                str2 = "report exception success";
            } else {
                jVar = b.a.f1608a;
                str = f33566b;
                str2 = "report exception fail";
            }
            jVar.f(str, str2);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
        try {
            boolean b10 = mj.f.b(th2, mj.j.b(new HashSet(Arrays.asList("com.sntech", "com.sn.catpie", "SNADS", "snads"))));
            b.a.f1608a.f(f33566b, "try handle uncaughtException selfCrash = " + b10);
            c(thread, th2, b10);
            if (b10 && mj.f.c()) {
                Thread.sleep(3000L);
                b(this, thread, th2);
            }
        } catch (Throwable th3) {
            b.a.f1608a.a("CrashHandler", th3, "handleException Error");
        }
        if (this.f33569a != null) {
            b.a.f1608a.f(f33566b, "pass exception");
            this.f33569a.uncaughtException(thread, th2);
        }
    }
}
