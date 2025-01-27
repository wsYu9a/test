package com.vivo.mobilead.lottie.a.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    private final List<a<com.vivo.mobilead.lottie.c.b.l, Path>> f29084a;

    /* renamed from: b */
    private final List<a<Integer, Integer>> f29085b;

    /* renamed from: c */
    private final List<com.vivo.mobilead.lottie.c.b.g> f29086c;

    public g(List<com.vivo.mobilead.lottie.c.b.g> list) {
        this.f29086c = list;
        this.f29084a = new ArrayList(list.size());
        this.f29085b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f29084a.add(list.get(i2).b().a());
            this.f29085b.add(list.get(i2).c().a());
        }
    }

    public List<com.vivo.mobilead.lottie.c.b.g> a() {
        return this.f29086c;
    }

    public List<a<com.vivo.mobilead.lottie.c.b.l, Path>> b() {
        return this.f29084a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f29085b;
    }
}
