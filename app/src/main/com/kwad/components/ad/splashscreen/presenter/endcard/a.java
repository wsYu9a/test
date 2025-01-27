package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.splashscreen.presenter.e {
    private AnimatorSet FZ;
    private TextView Ga;
    private ViewGroup Gb;
    private ViewGroup Gc;

    private void initView() {
        this.Ga = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.Gb = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.Gc = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }

    private void lR() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Gc, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Ga, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.Gb, "scaleX", 0.8f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.Gb, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.FZ = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        this.FZ.setDuration(300L);
        this.FZ.start();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        lR();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.FZ;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
