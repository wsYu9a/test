package com.baidu.mobads.sdk.internal;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    private static volatile c f7011a;

    public interface a {

        /* renamed from: a */
        public static final String f7012a = "remote_adserv";

        /* renamed from: b */
        public static final String f7013b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f7011a == null) {
            synchronized (c.class) {
                try {
                    if (f7011a == null) {
                        f7011a = new c();
                    }
                } finally {
                }
            }
        }
        return f7011a;
    }

    public ar a(String str) {
        return new ar(str);
    }
}
