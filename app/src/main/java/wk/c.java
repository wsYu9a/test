package wk;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes5.dex */
public class c {
    public static void a(View view, Runnable runnable) {
        view.postDelayed(runnable, ValueAnimator.getFrameDelay());
    }

    public static void b(View view, float f10) {
        view.setAlpha(f10);
    }
}
