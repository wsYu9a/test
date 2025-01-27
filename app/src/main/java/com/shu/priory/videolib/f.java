package com.shu.priory.videolib;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    public static JZPlayer f17400a;

    /* renamed from: b */
    public static JZPlayer f17401b;

    public static JZPlayer a() {
        return f17400a;
    }

    public static JZPlayer b() {
        return f17401b;
    }

    public static JZPlayer c() {
        return b() != null ? b() : a();
    }

    public static void d() {
        JZPlayer jZPlayer = f17401b;
        if (jZPlayer != null) {
            jZPlayer.t();
            f17401b = null;
        }
        JZPlayer jZPlayer2 = f17400a;
        if (jZPlayer2 != null) {
            jZPlayer2.t();
            f17400a = null;
        }
    }

    public static void a(JZPlayer jZPlayer) {
        f17400a = jZPlayer;
    }

    public static void b(JZPlayer jZPlayer) {
        f17401b = jZPlayer;
    }
}
