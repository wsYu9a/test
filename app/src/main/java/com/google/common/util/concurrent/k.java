package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import p5.c0;
import p5.u;

@a5.b
@CanIgnoreReturnValue
@p5.m
/* loaded from: classes2.dex */
public abstract class k<V> extends u<V> implements c0<V> {

    public static abstract class a<V> extends k<V> {

        /* renamed from: b */
        public final c0<V> f10493b;

        public a(c0<V> c0Var) {
            this.f10493b = (c0) b5.u.E(c0Var);
        }

        @Override // com.google.common.util.concurrent.k, p5.u
        /* renamed from: f */
        public final c0<V> delegate() {
            return this.f10493b;
        }
    }

    @Override // p5.c0
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    @Override // p5.u
    /* renamed from: f */
    public abstract c0<? extends V> delegate();
}
