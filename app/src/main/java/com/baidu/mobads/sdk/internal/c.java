package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static volatile c f5682a;

    public interface a {

        /* renamed from: a */
        public static final String f5683a = "remote_adserv";

        /* renamed from: b */
        public static final String f5684b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f5682a == null) {
            synchronized (c.class) {
                if (f5682a == null) {
                    f5682a = new c();
                }
            }
        }
        return f5682a;
    }

    public ao a(String str) {
        return new ao(str);
    }
}
