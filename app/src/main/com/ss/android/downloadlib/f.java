package com.ss.android.downloadlib;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static volatile f f21603a;

    /* renamed from: b */
    private com.ss.android.download.api.config.f f21604b = null;

    private f() {
    }

    public static f a() {
        if (f21603a == null) {
            synchronized (f.class) {
                try {
                    if (f21603a == null) {
                        f21603a = new f();
                    }
                } finally {
                }
            }
        }
        return f21603a;
    }

    public com.ss.android.download.api.config.f b() {
        return this.f21604b;
    }
}
