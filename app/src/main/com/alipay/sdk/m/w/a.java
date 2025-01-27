package com.alipay.sdk.m.w;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p3.d;
import p3.k;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final String f6612a = "CDT";

    /* renamed from: b */
    public static final int f6613b = 1;

    /* renamed from: c */
    public static final int f6614c = 2;

    /* renamed from: d */
    public static final int f6615d = 3;

    /* renamed from: e */
    public static final int f6616e = 4;

    /* renamed from: f */
    public static final int f6617f = 5;

    /* renamed from: g */
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> f6618g;

    /* renamed from: h */
    public static ExecutorService f6619h = Executors.newFixedThreadPool(16);

    /* renamed from: com.alipay.sdk.m.w.a$a */
    public interface InterfaceC0216a<T, R> {
        R a(T t10);
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static Pair<Boolean, ?> b(int i10, TimeUnit timeUnit, long j10) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = f6618g;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Pair<Long, ?> pair = concurrentHashMap.get(Integer.valueOf(i10));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Long l10 = (Long) pair.first;
        return (l10 == null || SystemClock.elapsedRealtime() - l10.longValue() > TimeUnit.MILLISECONDS.convert(j10, timeUnit)) ? new Pair<>(Boolean.FALSE, null) : new Pair<>(Boolean.TRUE, pair.second);
    }

    public static <T> T c(int i10, long j10, TimeUnit timeUnit, InterfaceC0216a<Object, Boolean> interfaceC0216a, Callable<T> callable, boolean z10, long j11, TimeUnit timeUnit2, n3.a aVar, boolean z11) {
        T call;
        try {
            Pair<Boolean, ?> b10 = b(i10, timeUnit, j10);
            if (((Boolean) b10.first).booleanValue() && interfaceC0216a.a(b10.second).booleanValue()) {
                d.i("getC", i10 + " got " + b10.second);
                return (T) b10.second;
            }
            if (z11 && k.d0()) {
                x2.a.i(aVar, x2.b.f31789l, "ch_get_main", "" + i10);
                d.i("getC", i10 + " skip");
                call = null;
            } else {
                call = z10 ? f6619h.submit(callable).get(j11, timeUnit2) : callable.call();
                e(i10, call);
            }
            d.i("getC", i10 + " new " + call);
            return call;
        } catch (Throwable th2) {
            d.d(f6612a, "ch_get_e|" + i10, th2);
            x2.a.e(aVar, x2.b.f31789l, "ch_get_e|" + i10, th2);
            d.i("getC", i10 + " err");
            return null;
        }
    }

    public static synchronized void d() {
        synchronized (a.class) {
            f6618g = null;
        }
    }

    public static synchronized void e(int i10, Object obj) {
        synchronized (a.class) {
            try {
                if (f6618g == null) {
                    f6618g = new ConcurrentHashMap<>();
                }
                f6618g.put(Integer.valueOf(i10), new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), obj));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
