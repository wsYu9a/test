package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.vivo.ic.dm.Downloads;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class n extends a implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private static long sm = 300;
    private ImageView fp;
    private ViewGroup sn;
    private TextView so;
    private boolean sp;
    private float sq;
    private WeakReference<View> sr;
    private q ss;
    private boolean st = false;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.n.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            n.this.hide();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.n$1 */
    final class AnonymousClass1 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            n.this.hide();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.n$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.this.hz().start();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.n$3 */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ColorDrawable sv;

        AnonymousClass3(ColorDrawable colorDrawable) {
            colorDrawable = colorDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            colorDrawable.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public n(q qVar) {
        this.ss = qVar;
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        int i2;
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.sn.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                i2 = this.sn.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize = this.sn.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.sr;
                    View view = weakReference != null ? weakReference.get() : null;
                    int i3 = marginLayoutParams2.height;
                    if (i3 <= 0 && view != null) {
                        i3 = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i3 + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                    this.sn.setLayoutParams(marginLayoutParams);
                }
                i2 = layoutParams.height + dimensionPixelSize;
            }
            marginLayoutParams.bottomMargin = i2;
            this.sn.setLayoutParams(marginLayoutParams);
        }
    }

    private synchronized void hy() {
        if (this.st) {
            return;
        }
        com.kwad.sdk.core.report.a.d(this.qt.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().bl(Downloads.Impl.STATUS_RUNNING).S(this.qt.oN.getPlayDuration()));
        this.st = true;
    }

    public Animator hz() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.sn, "translationX", getContext().getResources().getDimension(R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.fp.getBackground();
        if (background instanceof ColorDrawable) {
            valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(R.color.ksad_reward_main_color));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.n.3
                final /* synthetic */ ColorDrawable sv;

                AnonymousClass3(ColorDrawable colorDrawable) {
                    colorDrawable = colorDrawable;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    colorDrawable.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator = null;
        }
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.so, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(sm);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.sn;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ksad_playabel_pre_tips_icon);
        this.fp = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg));
        this.so = (TextView) this.sn.findViewById(R.id.ksad_playabel_pre_tips_text);
        this.sn.setOnClickListener(this);
    }

    public final void M(boolean z) {
        ViewGroup viewGroup = this.sn;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        hy();
        WeakReference<View> weakReference = this.sr;
        if (weakReference != null && weakReference.get() != null) {
            a(this.sr.get().getLayoutParams());
        }
        this.sn.setVisibility(0);
        if (z) {
            this.sn.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    n.this.hz().start();
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.sr = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        com.kwad.sdk.core.d.b.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.sn == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playable_pre_tips_stub);
            this.sn = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_playable_pre_tips_root));
            initView();
        }
        if (this.qt.fN()) {
            a(new ViewGroup.LayoutParams(-1, this.sn.getResources().getDimensionPixelSize(R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.qt.oQ.a(this);
        }
        this.qt.b(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.sn;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.sn;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.b.ff().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.report.a.a(this.qt.mAdTemplate, new com.kwad.sdk.core.report.i().bl(Downloads.Impl.STATUS_RUNNING).S(this.qt.oN.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sq = com.kwad.components.ad.reward.kwai.b.gC();
        this.sp = !com.kwad.components.ad.reward.kwai.b.gE() && com.kwad.components.ad.reward.kwai.b.gD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.c(this.mPlayEndPageListener);
        this.qt.oQ.b(this);
    }
}
