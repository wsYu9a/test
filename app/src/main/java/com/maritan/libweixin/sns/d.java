package com.maritan.libweixin.sns;

import b.d.c.b.k;

/* loaded from: classes2.dex */
public abstract class d<Data> {
    public abstract Data a();

    public abstract int b();

    public abstract String c();

    public k d() {
        return (e() || a() == null) ? new b.d.c.b.c(b(), c()) : new b.d.c.b.b(a());
    }

    public abstract boolean e();
}
