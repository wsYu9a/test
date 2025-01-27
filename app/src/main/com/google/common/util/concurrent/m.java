package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import p5.c0;
import p5.l0;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public class m<V> implements c0<V> {

    /* renamed from: c */
    public static final c0<?> f10512c = new m(null);

    /* renamed from: d */
    public static final Logger f10513d = Logger.getLogger(m.class.getName());

    /* renamed from: b */
    @l0
    public final V f10514b;

    public static final class a<V> extends AbstractFuture.i<V> {

        /* renamed from: b */
        public static final a<Object> f10515b;

        static {
            f10515b = AbstractFuture.GENERATE_CANCELLATION_CAUSES ? null : new a<>();
        }

        public a() {
            cancel(false);
        }
    }

    public static final class b<V> extends AbstractFuture.i<V> {
        public b(Throwable th2) {
            setException(th2);
        }
    }

    public m(@l0 V v10) {
        this.f10514b = v10;
    }

    @Override // p5.c0
    public void addListener(Runnable runnable, Executor executor) {
        u.F(runnable, "Runnable was null.");
        u.F(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = f10513d;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.log(level, sb2.toString(), (Throwable) e10);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return false;
    }

    @Override // java.util.concurrent.Future
    @l0
    public V get() {
        return this.f10514b;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.f10514b);
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 27 + valueOf.length());
        sb2.append(obj);
        sb2.append("[status=SUCCESS, result=[");
        sb2.append(valueOf);
        sb2.append("]]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    @l0
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException {
        u.E(timeUnit);
        return get();
    }
}
