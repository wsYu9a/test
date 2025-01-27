package pf;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes3.dex */
public interface e {
    e a(float f10);

    e b(@NonNull a aVar, boolean z10);

    e c(@NonNull a aVar, int i10);

    e d();

    ValueAnimator e(int i10);

    e f(Animator animator, boolean z10);

    e g(int i10);

    e h(boolean z10);

    e i(int i10, boolean z10);

    e j(Animator animator, boolean z10);

    @NonNull
    b k();

    @NonNull
    f l();

    e m(@NonNull a aVar, boolean z10);

    e n(@NonNull a aVar);

    e o(@NonNull RefreshState refreshState);
}
