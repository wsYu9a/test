package com.google.common.util.concurrent;

import b5.u;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a */
    public final boolean f10523a;

    /* renamed from: b */
    public final ReentrantLock f10524b;

    /* renamed from: c */
    @CheckForNull
    @GuardedBy("lock")
    public a f10525c;

    public static abstract class a {

        /* renamed from: a */
        @Weak
        public final o f10526a;

        /* renamed from: b */
        public final Condition f10527b;

        /* renamed from: c */
        @GuardedBy("monitor.lock")
        public int f10528c = 0;

        /* renamed from: d */
        @CheckForNull
        @GuardedBy("monitor.lock")
        public a f10529d;

        public a(o oVar) {
            this.f10526a = (o) u.F(oVar, "monitor");
            this.f10527b = oVar.f10524b.newCondition();
        }

        public abstract boolean a();
    }

    public o() {
        this(false);
    }

    public static long E(long j10, long j11) {
        if (j11 <= 0) {
            return 0L;
        }
        return j11 - (System.nanoTime() - j10);
    }

    public static long H(long j10, TimeUnit timeUnit) {
        return Longs.f(timeUnit.toNanos(j10), 0L, 6917529027641081853L);
    }

    public static long y(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1L;
        }
        return nanoTime;
    }

    public boolean A() {
        return this.f10524b.isLocked();
    }

    public boolean B() {
        return this.f10524b.isHeldByCurrentThread();
    }

    @GuardedBy("lock")
    public final boolean C(a aVar) {
        try {
            return aVar.a();
        } catch (Throwable th2) {
            F();
            throw th2;
        }
    }

    public void D() {
        ReentrantLock reentrantLock = this.f10524b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                G();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @GuardedBy("lock")
    public final void F() {
        for (a aVar = this.f10525c; aVar != null; aVar = aVar.f10529d) {
            aVar.f10527b.signalAll();
        }
    }

    @GuardedBy("lock")
    public final void G() {
        for (a aVar = this.f10525c; aVar != null; aVar = aVar.f10529d) {
            if (C(aVar)) {
                aVar.f10527b.signal();
                return;
            }
        }
    }

    public boolean I() {
        return this.f10524b.tryLock();
    }

    public boolean J(a aVar) {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f10524b;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            boolean a10 = aVar.a();
            if (!a10) {
            }
            return a10;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void K(a aVar) throws InterruptedException {
        if (aVar.f10526a != this || !this.f10524b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (aVar.a()) {
            return;
        }
        b(aVar, true);
    }

    public boolean L(a aVar, long j10, TimeUnit timeUnit) throws InterruptedException {
        long H = H(j10, timeUnit);
        if (aVar.f10526a != this || !this.f10524b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (aVar.a()) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return c(aVar, H, true);
    }

    public void M(a aVar) {
        if (aVar.f10526a != this || !this.f10524b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (aVar.a()) {
            return;
        }
        d(aVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean N(com.google.common.util.concurrent.o.a r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            long r8 = H(r8, r10)
            com.google.common.util.concurrent.o r10 = r7.f10526a
            if (r10 != r6) goto L53
            java.util.concurrent.locks.ReentrantLock r10 = r6.f10524b
            boolean r10 = r10.isHeldByCurrentThread()
            if (r10 == 0) goto L53
            boolean r10 = r7.a()
            r0 = 1
            if (r10 == 0) goto L18
            return r0
        L18:
            long r1 = y(r8)
            boolean r10 = java.lang.Thread.interrupted()
            r3 = r8
            r5 = 1
        L22:
            boolean r7 = r6.c(r7, r3, r5)     // Catch: java.lang.Throwable -> L30 java.lang.InterruptedException -> L33
            if (r10 == 0) goto L2f
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
        L2f:
            return r7
        L30:
            r7 = move-exception
            r0 = r10
            goto L49
        L33:
            boolean r10 = r7.a()     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto L41
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            r7.interrupt()
            return r0
        L41:
            long r3 = E(r1, r8)     // Catch: java.lang.Throwable -> L48
            r5 = 0
            r10 = 1
            goto L22
        L48:
            r7 = move-exception
        L49:
            if (r0 == 0) goto L52
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
        L52:
            throw r7
        L53:
            java.lang.IllegalMonitorStateException r7 = new java.lang.IllegalMonitorStateException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.o.N(com.google.common.util.concurrent.o$a, long, java.util.concurrent.TimeUnit):boolean");
    }

    @GuardedBy("lock")
    public final void b(a aVar, boolean z10) throws InterruptedException {
        if (z10) {
            G();
        }
        e(aVar);
        do {
            try {
                aVar.f10527b.await();
            } finally {
                f(aVar);
            }
        } while (!aVar.a());
    }

    @GuardedBy("lock")
    public final boolean c(a aVar, long j10, boolean z10) throws InterruptedException {
        boolean z11 = true;
        while (j10 > 0) {
            if (z11) {
                if (z10) {
                    try {
                        G();
                    } catch (Throwable th2) {
                        if (!z11) {
                            f(aVar);
                        }
                        throw th2;
                    }
                }
                e(aVar);
                z11 = false;
            }
            j10 = aVar.f10527b.awaitNanos(j10);
            if (aVar.a()) {
                if (!z11) {
                    f(aVar);
                }
                return true;
            }
        }
        if (!z11) {
            f(aVar);
        }
        return false;
    }

    @GuardedBy("lock")
    public final void d(a aVar, boolean z10) {
        if (z10) {
            G();
        }
        e(aVar);
        do {
            try {
                aVar.f10527b.awaitUninterruptibly();
            } finally {
                f(aVar);
            }
        } while (!aVar.a());
    }

    @GuardedBy("lock")
    public final void e(a aVar) {
        int i10 = aVar.f10528c;
        aVar.f10528c = i10 + 1;
        if (i10 == 0) {
            aVar.f10529d = this.f10525c;
            this.f10525c = aVar;
        }
    }

    @GuardedBy("lock")
    public final void f(a aVar) {
        int i10 = aVar.f10528c - 1;
        aVar.f10528c = i10;
        if (i10 == 0) {
            a aVar2 = this.f10525c;
            a aVar3 = null;
            while (aVar2 != aVar) {
                aVar3 = aVar2;
                aVar2 = aVar2.f10529d;
            }
            if (aVar3 == null) {
                this.f10525c = aVar2.f10529d;
            } else {
                aVar3.f10529d = aVar2.f10529d;
            }
            aVar2.f10529d = null;
        }
    }

    public void g() {
        this.f10524b.lock();
    }

    public boolean h(long j10, TimeUnit timeUnit) {
        boolean tryLock;
        long H = H(j10, timeUnit);
        ReentrantLock reentrantLock = this.f10524b;
        boolean z10 = true;
        if (!this.f10523a && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = Thread.interrupted();
        try {
            long nanoTime = System.nanoTime();
            long j11 = H;
            while (true) {
                try {
                    try {
                        tryLock = reentrantLock.tryLock(j11, TimeUnit.NANOSECONDS);
                        break;
                    } catch (InterruptedException unused) {
                        j11 = E(nanoTime, H);
                        interrupted = true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (Throwable th3) {
            th = th3;
            z10 = interrupted;
        }
    }

    public boolean i(a aVar) {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f10524b;
        reentrantLock.lock();
        try {
            boolean a10 = aVar.a();
            if (!a10) {
            }
            return a10;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean j(a aVar, long j10, TimeUnit timeUnit) {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        if (!h(j10, timeUnit)) {
            return false;
        }
        try {
            boolean a10 = aVar.a();
            if (!a10) {
            }
            return a10;
        } finally {
            this.f10524b.unlock();
        }
    }

    public boolean k(a aVar) throws InterruptedException {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f10524b;
        reentrantLock.lockInterruptibly();
        try {
            boolean a10 = aVar.a();
            if (!a10) {
            }
            return a10;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean l(a aVar, long j10, TimeUnit timeUnit) throws InterruptedException {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f10524b;
        if (!reentrantLock.tryLock(j10, timeUnit)) {
            return false;
        }
        try {
            boolean a10 = aVar.a();
            if (!a10) {
            }
            return a10;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void m() throws InterruptedException {
        this.f10524b.lockInterruptibly();
    }

    public boolean n(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f10524b.tryLock(j10, timeUnit);
    }

    public void o(a aVar) throws InterruptedException {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f10524b;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (aVar.a()) {
                return;
            }
            b(aVar, isHeldByCurrentThread);
        } catch (Throwable th2) {
            D();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (c(r11, r0, r3) != false) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean p(com.google.common.util.concurrent.o.a r11, long r12, java.util.concurrent.TimeUnit r14) throws java.lang.InterruptedException {
        /*
            r10 = this;
            long r0 = H(r12, r14)
            com.google.common.util.concurrent.o r2 = r11.f10526a
            if (r2 != r10) goto L62
            java.util.concurrent.locks.ReentrantLock r2 = r10.f10524b
            boolean r3 = r2.isHeldByCurrentThread()
            boolean r4 = r10.f10523a
            r5 = 0
            r6 = 0
            if (r4 != 0) goto L29
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L23
            boolean r4 = r2.tryLock()
            if (r4 == 0) goto L29
            r8 = r6
            goto L34
        L23:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        L29:
            long r8 = y(r0)
            boolean r12 = r2.tryLock(r12, r14)
            if (r12 != 0) goto L34
            return r5
        L34:
            boolean r12 = r11.a()     // Catch: java.lang.Throwable -> L4a
            if (r12 != 0) goto L4c
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 != 0) goto L3f
            goto L43
        L3f:
            long r0 = E(r8, r0)     // Catch: java.lang.Throwable -> L4a
        L43:
            boolean r11 = r10.c(r11, r0, r3)     // Catch: java.lang.Throwable -> L4a
            if (r11 == 0) goto L4d
            goto L4c
        L4a:
            r11 = move-exception
            goto L53
        L4c:
            r5 = 1
        L4d:
            if (r5 != 0) goto L52
            r2.unlock()
        L52:
            return r5
        L53:
            if (r3 != 0) goto L5e
            r10.G()     // Catch: java.lang.Throwable -> L59
            goto L5e
        L59:
            r11 = move-exception
            r2.unlock()
            throw r11
        L5e:
            r2.unlock()
            throw r11
        L62:
            java.lang.IllegalMonitorStateException r11 = new java.lang.IllegalMonitorStateException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.o.p(com.google.common.util.concurrent.o$a, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void q(a aVar) {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f10524b;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (aVar.a()) {
                return;
            }
            d(aVar, isHeldByCurrentThread);
        } catch (Throwable th2) {
            D();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[Catch: all -> 0x0023, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0023, blocks: (B:5:0x0012, B:7:0x001a, B:22:0x004f, B:33:0x005c, B:34:0x005f, B:35:0x0025, B:38:0x002a, B:13:0x0032, B:17:0x003d, B:18:0x0049, B:27:0x0045), top: B:4:0x0012, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean r(com.google.common.util.concurrent.o.a r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            long r13 = H(r13, r15)
            com.google.common.util.concurrent.o r15 = r12.f10526a
            if (r15 != r11) goto L7f
            java.util.concurrent.locks.ReentrantLock r15 = r11.f10524b
            boolean r0 = r15.isHeldByCurrentThread()
            boolean r1 = java.lang.Thread.interrupted()
            boolean r2 = r11.f10523a     // Catch: java.lang.Throwable -> L23
            r3 = 0
            r4 = 0
            r6 = 1
            if (r2 != 0) goto L25
            boolean r2 = r15.tryLock()     // Catch: java.lang.Throwable -> L23
            if (r2 != 0) goto L21
            goto L25
        L21:
            r7 = r4
            goto L32
        L23:
            r12 = move-exception
            goto L75
        L25:
            long r7 = y(r13)     // Catch: java.lang.Throwable -> L23
            r9 = r13
        L2a:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L23 java.lang.InterruptedException -> L6d
            boolean r2 = r15.tryLock(r9, r2)     // Catch: java.lang.Throwable -> L23 java.lang.InterruptedException -> L6d
            if (r2 == 0) goto L63
        L32:
            boolean r2 = r12.a()     // Catch: java.lang.Throwable -> L43 java.lang.InterruptedException -> L60
            if (r2 == 0) goto L39
            goto L4d
        L39:
            int r2 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r2 != 0) goto L45
            long r7 = y(r13)     // Catch: java.lang.Throwable -> L43 java.lang.InterruptedException -> L60
            r9 = r13
            goto L49
        L43:
            r12 = move-exception
            goto L5c
        L45:
            long r9 = E(r7, r13)     // Catch: java.lang.Throwable -> L43 java.lang.InterruptedException -> L60
        L49:
            boolean r6 = r11.c(r12, r9, r0)     // Catch: java.lang.Throwable -> L43 java.lang.InterruptedException -> L60
        L4d:
            if (r6 != 0) goto L52
            r15.unlock()     // Catch: java.lang.Throwable -> L23
        L52:
            if (r1 == 0) goto L5b
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L5b:
            return r6
        L5c:
            r15.unlock()     // Catch: java.lang.Throwable -> L23
            throw r12     // Catch: java.lang.Throwable -> L23
        L60:
            r0 = 0
            r1 = 1
            goto L32
        L63:
            if (r1 == 0) goto L6c
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L6c:
            return r3
        L6d:
            long r9 = E(r7, r13)     // Catch: java.lang.Throwable -> L73
            r1 = 1
            goto L2a
        L73:
            r12 = move-exception
            r1 = 1
        L75:
            if (r1 == 0) goto L7e
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L7e:
            throw r12
        L7f:
            java.lang.IllegalMonitorStateException r12 = new java.lang.IllegalMonitorStateException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.o.r(com.google.common.util.concurrent.o$a, long, java.util.concurrent.TimeUnit):boolean");
    }

    public int s() {
        return this.f10524b.getHoldCount();
    }

    public int t() {
        return this.f10524b.getQueueLength();
    }

    public int u(a aVar) {
        if (aVar.f10526a != this) {
            throw new IllegalMonitorStateException();
        }
        this.f10524b.lock();
        try {
            return aVar.f10528c;
        } finally {
            this.f10524b.unlock();
        }
    }

    public boolean v(Thread thread) {
        return this.f10524b.hasQueuedThread(thread);
    }

    public boolean w() {
        return this.f10524b.hasQueuedThreads();
    }

    public boolean x(a aVar) {
        return u(aVar) > 0;
    }

    public boolean z() {
        return this.f10523a;
    }

    public o(boolean z10) {
        this.f10525c = null;
        this.f10523a = z10;
        this.f10524b = new ReentrantLock(z10);
    }
}
