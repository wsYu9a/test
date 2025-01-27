package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class t {
    @Nullable
    public static Animator a(AdTemplate adTemplate, View view, DetailVideoView detailVideoView) {
        ValueAnimator a2;
        if (detailVideoView == null || (a2 = detailVideoView.a(adTemplate, (int) (detailVideoView.getHeight() - detailVideoView.getContext().getResources().getDimension(R.dimen.ksad_play_again_end_height)), (ValueAnimator.AnimatorUpdateListener) null)) == null) {
            return null;
        }
        Animator r = r(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(a2.getDuration());
        animatorSet.setInterpolator(a2.getInterpolator());
        animatorSet.playTogether(a2, r);
        return animatorSet;
    }

    @Nullable
    public static Animator a(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView, View view) {
        int width;
        if (view == null || view.getLayoutParams() == null || (width = view.getWidth()) == 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", -width).setDuration(300L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        if (com.kwad.sdk.core.response.a.a.aO(com.kwad.sdk.core.response.a.d.cb(adTemplate)) || detailVideoView == null) {
            return duration;
        }
        ValueAnimator aM = detailVideoView.aM(width);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, aM);
        return animatorSet;
    }

    @Nullable
    private static Animator r(View view) {
        if (view == null || view.getHeight() == 0) {
            return null;
        }
        return ObjectAnimator.ofFloat(view, "translationY", view.getContext().getResources().getDimension(R.dimen.ksad_play_again_end_animate_margin));
    }
}
