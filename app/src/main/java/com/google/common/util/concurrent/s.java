package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import p5.c0;
import p5.l0;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public final class s<V> extends AbstractFuture.i<V> {
    public static <V> s<V> n() {
        return new s<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean set(@l0 V v10) {
        return super.set(v10);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean setException(Throwable th2) {
        return super.setException(th2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean setFuture(c0<? extends V> c0Var) {
        return super.setFuture(c0Var);
    }
}
