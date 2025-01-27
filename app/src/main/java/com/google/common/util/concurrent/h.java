package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.l0;

@a5.b(emulated = true)
@p5.m
/* loaded from: classes2.dex */
public abstract class h<V, C> extends AggregateFuture<V, C> {

    /* renamed from: j */
    @CheckForNull
    public List<b<V>> f10486j;

    public static final class a<V> extends h<V, List<V>> {
        public a(ImmutableCollection<? extends c0<? extends V>> immutableCollection, boolean z10) {
            super(immutableCollection, z10);
            C();
        }

        @Override // com.google.common.util.concurrent.h
        /* renamed from: J */
        public List<V> I(List<b<V>> list) {
            ArrayList u10 = Lists.u(list.size());
            Iterator<b<V>> it = list.iterator();
            while (it.hasNext()) {
                b<V> next = it.next();
                u10.add(next != null ? next.f10487a : null);
            }
            return Collections.unmodifiableList(u10);
        }
    }

    public static final class b<V> {

        /* renamed from: a */
        public V f10487a;

        public b(V v10) {
            this.f10487a = v10;
        }
    }

    public h(ImmutableCollection<? extends c0<? extends V>> immutableCollection, boolean z10) {
        super(immutableCollection, z10, true);
        List<b<V>> emptyList = immutableCollection.isEmpty() ? Collections.emptyList() : Lists.u(immutableCollection.size());
        for (int i10 = 0; i10 < immutableCollection.size(); i10++) {
            emptyList.add(null);
        }
        this.f10486j = emptyList;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void A() {
        List<b<V>> list = this.f10486j;
        if (list != null) {
            set(I(list));
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void H(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.H(releaseResourcesReason);
        this.f10486j = null;
    }

    public abstract C I(List<b<V>> list);

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void x(int i10, @l0 V v10) {
        List<b<V>> list = this.f10486j;
        if (list != null) {
            list.set(i10, new b<>(v10));
        }
    }
}
