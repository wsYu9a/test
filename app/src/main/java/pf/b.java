package pf;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import sf.j;

/* loaded from: classes3.dex */
public interface b {
    boolean a();

    void b(boolean z10);

    void c(j jVar);

    void d(MotionEvent motionEvent);

    void e(e eVar, View view, View view2);

    ValueAnimator.AnimatorUpdateListener f(int i10);

    @NonNull
    View g();

    @NonNull
    View getView();

    void h(int i10, int i11, int i12);

    boolean i();
}
