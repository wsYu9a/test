package uk.co.senab.actionbarpulltorefresh.library.j;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes5.dex */
class c {
    c() {
    }

    static void a(View view, Runnable runnable) {
        view.postDelayed(runnable, ValueAnimator.getFrameDelay());
    }

    static void b(View view, float f2) {
        view.setAlpha(f2);
    }
}
