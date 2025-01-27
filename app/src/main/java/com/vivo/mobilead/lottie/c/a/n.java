package com.vivo.mobilead.lottie.c.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
abstract class n<V, O> implements m<V, O> {

    /* renamed from: a */
    final List<com.vivo.mobilead.lottie.g.a<V>> f29189a;

    n(V v) {
        this(Collections.singletonList(new com.vivo.mobilead.lottie.g.a(v)));
    }

    n(List<com.vivo.mobilead.lottie.g.a<V>> list) {
        this.f29189a = list;
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public boolean b() {
        return this.f29189a.isEmpty() || (this.f29189a.size() == 1 && this.f29189a.get(0).e());
    }

    @Override // com.vivo.mobilead.lottie.c.a.m
    public List<com.vivo.mobilead.lottie.g.a<V>> c() {
        return this.f29189a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f29189a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f29189a.toArray()));
        }
        return sb.toString();
    }
}
