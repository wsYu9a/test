package com.opos.mobad.service.b;

import android.text.TextUtils;
import com.opos.mobad.service.j.n;
import f.b.a.d;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final ArrayList<String> f23543a = new ArrayList<>();

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f23544b;

    /* renamed from: c */
    private AtomicBoolean f23545c = new AtomicBoolean(false);

    public a() {
        ArrayList<String> arrayList = f23543a;
        arrayList.add("com.opos");
        arrayList.add("com.heytap");
    }

    private void a(Throwable th) {
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (!TextUtils.isEmpty(className)) {
                    Iterator<String> it = f23543a.iterator();
                    while (it.hasNext()) {
                        if (className.startsWith(it.next())) {
                            n.a().a(th);
                            return;
                        }
                    }
                }
            }
            th = th.getCause();
        }
    }

    public void a() {
        try {
            if (this.f23545c.compareAndSet(false, true)) {
                this.f23544b = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("mob_crash", "init fail", th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@d Thread thread, @d Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f23544b;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        try {
            a(th);
        } catch (Throwable th2) {
            com.opos.cmn.an.f.a.b("mob_crash", "handle crash fail", th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f23544b;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        }
    }
}
