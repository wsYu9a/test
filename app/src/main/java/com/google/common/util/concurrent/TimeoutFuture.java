package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.j;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;
import p5.c0;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public final class TimeoutFuture<V> extends j.a<V> {

    /* renamed from: b */
    @CheckForNull
    public c0<V> f10401b;

    /* renamed from: c */
    @CheckForNull
    public ScheduledFuture<?> f10402c;

    public static final class TimeoutFutureException extends TimeoutException {
        public /* synthetic */ TimeoutFutureException(String str, a aVar) {
            this(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        private TimeoutFutureException(String str) {
            super(str);
        }
    }

    public static final class b<V> implements Runnable {

        /* renamed from: b */
        @CheckForNull
        public TimeoutFuture<V> f10403b;

        public b(TimeoutFuture<V> timeoutFuture) {
            this.f10403b = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0<? extends V> c0Var;
            TimeoutFuture<V> timeoutFuture = this.f10403b;
            if (timeoutFuture == null || (c0Var = timeoutFuture.f10401b) == null) {
                return;
            }
            this.f10403b = null;
            if (c0Var.isDone()) {
                timeoutFuture.setFuture(c0Var);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = timeoutFuture.f10402c;
                timeoutFuture.f10402c = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            StringBuilder sb2 = new StringBuilder("Timed out".length() + 66);
                            sb2.append("Timed out");
                            sb2.append(" (timeout delayed by ");
                            sb2.append(abs);
                            sb2.append(" ms after scheduled time)");
                            str = sb2.toString();
                        }
                    } catch (Throwable th2) {
                        timeoutFuture.setException(new TimeoutFutureException(str));
                        throw th2;
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(c0Var);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
                sb3.append(valueOf);
                sb3.append(": ");
                sb3.append(valueOf2);
                timeoutFuture.setException(new TimeoutFutureException(sb3.toString()));
            } finally {
                c0Var.cancel(true);
            }
        }
    }

    public TimeoutFuture(c0<V> c0Var) {
        this.f10401b = (c0) u.E(c0Var);
    }

    public static <V> c0<V> y(c0<V> c0Var, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(c0Var);
        b bVar = new b(timeoutFuture);
        timeoutFuture.f10402c = scheduledExecutorService.schedule(bVar, j10, timeUnit);
        c0Var.addListener(bVar, p.c());
        return timeoutFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.f10401b);
        ScheduledFuture<?> scheduledFuture = this.f10402c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f10401b = null;
        this.f10402c = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        c0<V> c0Var = this.f10401b;
        ScheduledFuture<?> scheduledFuture = this.f10402c;
        if (c0Var == null) {
            return null;
        }
        String valueOf = String.valueOf(c0Var);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
        sb2.append("inputFuture=[");
        sb2.append(valueOf);
        sb2.append("]");
        String sb3 = sb2.toString();
        if (scheduledFuture == null) {
            return sb3;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb3;
        }
        String valueOf2 = String.valueOf(sb3);
        StringBuilder sb4 = new StringBuilder(valueOf2.length() + 43);
        sb4.append(valueOf2);
        sb4.append(", remaining delay=[");
        sb4.append(delay);
        sb4.append(" ms]");
        return sb4.toString();
    }
}
