package ja;

import com.martian.libvideoplayer.JCVideoPlayer;

/* loaded from: classes3.dex */
public class o {

    /* renamed from: a */
    public static JCVideoPlayer f27295a;

    /* renamed from: b */
    public static JCVideoPlayer f27296b;

    public static void a() {
        JCVideoPlayer jCVideoPlayer = f27296b;
        if (jCVideoPlayer != null) {
            jCVideoPlayer.s();
            f27296b = null;
        }
        JCVideoPlayer jCVideoPlayer2 = f27295a;
        if (jCVideoPlayer2 != null) {
            jCVideoPlayer2.s();
            f27295a = null;
        }
    }

    public static JCVideoPlayer b() {
        return d() != null ? d() : c();
    }

    public static JCVideoPlayer c() {
        return f27295a;
    }

    public static JCVideoPlayer d() {
        return f27296b;
    }

    public static void e(JCVideoPlayer jCVideoPlayer) {
        f27295a = jCVideoPlayer;
    }

    public static void f(JCVideoPlayer jCVideoPlayer) {
        f27296b = jCVideoPlayer;
    }
}
