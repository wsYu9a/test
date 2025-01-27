package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import b5.u;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import e5.f1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public final class n<L> {

    /* renamed from: b */
    public static final Logger f10516b = Logger.getLogger(n.class.getName());

    /* renamed from: a */
    public final List<b<L>> f10517a = Collections.synchronizedList(new ArrayList());

    public interface a<L> {
        void call(L l10);
    }

    public static final class b<L> implements Runnable {

        /* renamed from: b */
        public final L f10518b;

        /* renamed from: c */
        public final Executor f10519c;

        /* renamed from: d */
        @GuardedBy("this")
        public final Queue<a<L>> f10520d = f1.d();

        /* renamed from: e */
        @GuardedBy("this")
        public final Queue<Object> f10521e = f1.d();

        /* renamed from: f */
        @GuardedBy("this")
        public boolean f10522f;

        public b(L l10, Executor executor) {
            this.f10518b = (L) u.E(l10);
            this.f10519c = (Executor) u.E(executor);
        }

        public synchronized void a(a<L> aVar, Object obj) {
            this.f10520d.add(aVar);
            this.f10521e.add(obj);
        }

        public void b() {
            boolean z10;
            synchronized (this) {
                try {
                    if (this.f10522f) {
                        z10 = false;
                    } else {
                        z10 = true;
                        this.f10522f = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                try {
                    this.f10519c.execute(this);
                } catch (RuntimeException e10) {
                    synchronized (this) {
                        this.f10522f = false;
                        Logger logger = n.f10516b;
                        Level level = Level.SEVERE;
                        String valueOf = String.valueOf(this.f10518b);
                        String valueOf2 = String.valueOf(this.f10519c);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 42 + valueOf2.length());
                        sb2.append("Exception while running callbacks for ");
                        sb2.append(valueOf);
                        sb2.append(" on ");
                        sb2.append(valueOf2);
                        logger.log(level, sb2.toString(), (Throwable) e10);
                        throw e10;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.call(r10.f10518b);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        
            r4 = com.google.common.util.concurrent.n.f10516b;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r10.f10518b);
            r3 = java.lang.String.valueOf(r3);
            r8 = new java.lang.StringBuilder((r6.length() + 37) + r3.length());
            r8.append("Exception while executing callback: ");
            r8.append(r6);
            r8.append(" ");
            r8.append(r3);
            r4.log(r5, r8.toString(), (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r10 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L2a
                boolean r2 = r10.f10522f     // Catch: java.lang.Throwable -> L1f
                b5.u.g0(r2)     // Catch: java.lang.Throwable -> L1f
                java.util.Queue<com.google.common.util.concurrent.n$a<L>> r2 = r10.f10520d     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L1f
                com.google.common.util.concurrent.n$a r2 = (com.google.common.util.concurrent.n.a) r2     // Catch: java.lang.Throwable -> L1f
                java.util.Queue<java.lang.Object> r3 = r10.f10521e     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1f
                if (r2 != 0) goto L23
                r10.f10522f = r0     // Catch: java.lang.Throwable -> L1f
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = 0
                goto L65
            L1f:
                r2 = move-exception
                r1 = r2
                r2 = 1
                goto L65
            L23:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1f
                L r4 = r10.f10518b     // Catch: java.lang.Throwable -> L2a java.lang.RuntimeException -> L2c
                r2.call(r4)     // Catch: java.lang.Throwable -> L2a java.lang.RuntimeException -> L2c
                goto L0
            L2a:
                r2 = move-exception
                goto L6e
            L2c:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.n.a()     // Catch: java.lang.Throwable -> L2a
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L2a
                L r6 = r10.f10518b     // Catch: java.lang.Throwable -> L2a
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L2a
                int r7 = r6.length()     // Catch: java.lang.Throwable -> L2a
                int r7 = r7 + 37
                int r8 = r3.length()     // Catch: java.lang.Throwable -> L2a
                int r7 = r7 + r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
                r8.<init>(r7)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r7 = "Exception while executing callback: "
                r8.append(r7)     // Catch: java.lang.Throwable -> L2a
                r8.append(r6)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r6 = " "
                r8.append(r6)     // Catch: java.lang.Throwable -> L2a
                r8.append(r3)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r3 = r8.toString()     // Catch: java.lang.Throwable -> L2a
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L2a
                goto L0
            L65:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L6c
                throw r1     // Catch: java.lang.Throwable -> L67
            L67:
                r1 = move-exception
                r9 = r2
                r2 = r1
                r1 = r9
                goto L6e
            L6c:
                r1 = move-exception
                goto L65
            L6e:
                if (r1 == 0) goto L78
                monitor-enter(r10)
                r10.f10522f = r0     // Catch: java.lang.Throwable -> L75
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
                goto L78
            L75:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
                throw r0
            L78:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.n.b.run():void");
        }
    }

    public void b(L l10, Executor executor) {
        u.F(l10, "listener");
        u.F(executor, "executor");
        this.f10517a.add(new b<>(l10, executor));
    }

    public void c() {
        for (int i10 = 0; i10 < this.f10517a.size(); i10++) {
            this.f10517a.get(i10).b();
        }
    }

    public void d(a<L> aVar) {
        f(aVar, aVar);
    }

    public void e(a<L> aVar, String str) {
        f(aVar, str);
    }

    public final void f(a<L> aVar, Object obj) {
        u.F(aVar, NotificationCompat.CATEGORY_EVENT);
        u.F(obj, TTDownloadField.TT_LABEL);
        synchronized (this.f10517a) {
            try {
                Iterator<b<L>> it = this.f10517a.iterator();
                while (it.hasNext()) {
                    it.next().a(aVar, obj);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
