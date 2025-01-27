package com.opos.cmn.func.dl.base.e;

import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static final String f17317a = d.class.getSimpleName();

    /* renamed from: b */
    public File f17318b;

    /* renamed from: c */
    public File f17319c;

    /* renamed from: d */
    public com.opos.cmn.func.dl.base.a.b f17320d;

    /* renamed from: e */
    public List<c> f17321e;

    /* renamed from: f */
    public a f17322f;

    public b(com.opos.cmn.func.dl.base.a.b bVar) {
        this.f17320d = bVar;
        this.f17318b = bVar.f17259i;
        this.f17319c = bVar.f17260j;
        this.f17322f = new d(this.f17318b, this.f17319c);
    }

    public static int a(long j2, boolean z) {
        if (j2 <= 1048576 || !z) {
            return 1;
        }
        long j3 = (j2 % 1048576 == 0 ? 0 : 1) + (j2 / 1048576);
        if (j3 > 5) {
            j3 = 5;
        }
        return (int) j3;
    }

    public static boolean a(long j2, Boolean bool) {
        boolean z = j2 > 0 && bool.booleanValue();
        com.opos.cmn.an.f.a.b(f17317a, "supportMultBlock:".concat(String.valueOf(z)));
        return z;
    }
}
