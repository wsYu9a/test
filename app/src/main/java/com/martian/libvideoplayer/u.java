package com.martian.libvideoplayer;

/* loaded from: classes3.dex */
public class u {

    /* renamed from: a */
    public static JCVideoPlayer f10733a;

    /* renamed from: b */
    public static JCVideoPlayer f10734b;

    public static void a() {
        JCVideoPlayer jCVideoPlayer = f10734b;
        if (jCVideoPlayer != null) {
            jCVideoPlayer.r();
            f10734b = null;
        }
        JCVideoPlayer jCVideoPlayer2 = f10733a;
        if (jCVideoPlayer2 != null) {
            jCVideoPlayer2.r();
            f10733a = null;
        }
    }

    public static JCVideoPlayer b() {
        return d() != null ? d() : c();
    }

    public static JCVideoPlayer c() {
        return f10733a;
    }

    public static JCVideoPlayer d() {
        return f10734b;
    }

    public static void e(JCVideoPlayer jcVideoPlayer) {
        f10733a = jcVideoPlayer;
    }

    public static void f(JCVideoPlayer jcVideoPlayer) {
        f10734b = jcVideoPlayer;
    }
}
