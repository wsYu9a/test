package com.vivo.mobilead.lottie.c.b;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class n implements b {

    /* renamed from: a */
    private final String f29284a;

    /* renamed from: b */
    private final List<b> f29285b;

    /* renamed from: c */
    private final boolean f29286c;

    public n(String str, List<b> list, boolean z) {
        this.f29284a = str;
        this.f29285b = list;
        this.f29286c = z;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        return new com.vivo.mobilead.lottie.a.a.d(cVar, aVar, this);
    }

    public String a() {
        return this.f29284a;
    }

    public List<b> b() {
        return this.f29285b;
    }

    public boolean c() {
        return this.f29286c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f29284a + "' Shapes: " + Arrays.toString(this.f29285b.toArray()) + '}';
    }
}
