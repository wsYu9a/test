package pf;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import sf.g;
import sf.h;
import sf.j;

/* loaded from: classes3.dex */
public interface f {
    f A(boolean z10);

    f B(h hVar);

    f C(boolean z10);

    f D(@NonNull c cVar, int i10, int i11);

    f E(g gVar);

    f F(boolean z10);

    f G(boolean z10);

    f H(boolean z10);

    f I(boolean z10);

    f J(float f10);

    f K(int i10, boolean z10, Boolean bool);

    boolean L();

    f M(boolean z10);

    f N(boolean z10);

    f O(@NonNull d dVar);

    f P(boolean z10);

    boolean Q(int i10);

    f R(boolean z10);

    f S();

    f T(@IdRes int i10);

    f U(@NonNull c cVar);

    f V();

    f W(boolean z10);

    f X(int i10);

    f Y(@FloatRange(from = 1.0d, to = 10.0d) float f10);

    boolean Z(int i10, int i11, float f10, boolean z10);

    f a(boolean z10);

    boolean a0();

    f b(boolean z10);

    f b0(int i10);

    f c(j jVar);

    f c0(int i10);

    boolean d();

    f d0(@NonNull View view, int i10, int i11);

    f e(boolean z10);

    f e0();

    f f(@NonNull View view);

    f f0(sf.e eVar);

    f g(@FloatRange(from = 0.0d, to = 1.0d) float f10);

    f g0(@FloatRange(from = 1.0d, to = 10.0d) float f10);

    @NonNull
    ViewGroup getLayout();

    @Nullable
    c getRefreshFooter();

    @Nullable
    d getRefreshHeader();

    @NonNull
    RefreshState getState();

    boolean h(int i10);

    f h0(sf.f fVar);

    f i(boolean z10);

    boolean i0();

    boolean isLoading();

    f j(float f10);

    f j0(boolean z10);

    f k(@IdRes int i10);

    f k0();

    f l(boolean z10);

    f l0(int i10, boolean z10, boolean z11);

    f m(int i10);

    f m0(@NonNull Interpolator interpolator);

    f n();

    f n0(boolean z10);

    f o(boolean z10);

    f o0(@FloatRange(from = 0.0d, to = 1.0d) float f10);

    f p();

    f p0(int i10);

    boolean q(int i10, int i11, float f10, boolean z10);

    f q0(@IdRes int i10);

    f r(float f10);

    f r0(@NonNull d dVar, int i10, int i11);

    f s(float f10);

    f setPrimaryColors(@ColorInt int... iArr);

    f t(@FloatRange(from = 0.0d, to = 1.0d) float f10);

    f u(boolean z10);

    f v(@IdRes int i10);

    f w(int i10);

    f x(@ColorRes int... iArr);

    f y(int i10);

    boolean z();
}
