package com.jd.ad.sdk.jad_lu;

import android.content.Context;
import com.jd.ad.sdk.lottie.LottieAnimationView;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class jad_er implements Callable<jad_sf<jad_jt>> {
    public final /* synthetic */ int jad_an;
    public final /* synthetic */ LottieAnimationView jad_bo;

    public jad_er(LottieAnimationView lottieAnimationView, int i10) {
        this.jad_bo = lottieAnimationView;
        this.jad_an = i10;
    }

    @Override // java.util.concurrent.Callable
    public jad_sf<jad_jt> call() {
        LottieAnimationView lottieAnimationView = this.jad_bo;
        if (!lottieAnimationView.jad_na) {
            return jad_hu.jad_an(lottieAnimationView.getContext(), this.jad_an, (String) null);
        }
        Context context = lottieAnimationView.getContext();
        int i10 = this.jad_an;
        return jad_hu.jad_an(context, i10, jad_hu.jad_an(context, i10));
    }
}
