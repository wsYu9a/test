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
import com.sigmob.sdk.base.common.y;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class o extends b implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {

    /* renamed from: ub */
    private static long f11799ub = 300;
    private ImageView gG;

    /* renamed from: uc */
    private ViewGroup f11800uc;

    /* renamed from: ud */
    private TextView f11801ud;

    /* renamed from: ue */
    private boolean f11802ue;

    /* renamed from: uf */
    private float f11803uf;

    /* renamed from: ug */
    private WeakReference<View> f11804ug;

    /* renamed from: uh */
    private r f11805uh;

    /* renamed from: ui */
    private boolean f11806ui = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.o.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            o.this.hide();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.o$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            o.this.hide();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.o$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.this.hT().start();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.o$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: uk */
        final /* synthetic */ ColorDrawable f11810uk;

        public AnonymousClass3(ColorDrawable colorDrawable) {
            colorDrawable = colorDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            colorDrawable.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public o(r rVar) {
        this.f11805uh = rVar;
    }

    private synchronized void hS() {
        if (this.f11806ui) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.rO.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(192).aq(this.rO.f11689qf.getPlayDuration()));
        this.f11806ui = true;
    }

    public Animator hT() {
        ValueAnimator valueAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11800uc, "translationX", getContext().getResources().getDimension(R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.gG.getBackground();
        if (background instanceof ColorDrawable) {
            valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(R.color.ksad_reward_main_color));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.o.3

                /* renamed from: uk */
                final /* synthetic */ ColorDrawable f11810uk;

                public AnonymousClass3(ColorDrawable colorDrawable) {
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
        animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.f11801ud, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(f11799ub);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.f11800uc;
        if (viewGroup == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.ksad_playabel_pre_tips_icon);
        this.gG = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg));
        this.f11801ud = (TextView) this.f11800uc.findViewById(R.id.ksad_playabel_pre_tips_text);
        this.f11800uc.setOnClickListener(this);
    }

    public final void I(boolean z10) {
        ViewGroup viewGroup = this.f11800uc;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        hS();
        WeakReference<View> weakReference = this.f11804ug;
        if (weakReference != null && weakReference.get() != null) {
            a(this.f11804ug.get().getLayoutParams());
        }
        this.f11800uc.setVisibility(0);
        if (z10) {
            this.f11800uc.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.o.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    o.this.hT().start();
                }
            }, y.f.f18076n);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.f11800uc == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playable_pre_tips_stub);
            if (viewStub != null) {
                this.f11800uc = (ViewGroup) viewStub.inflate();
            } else {
                this.f11800uc = (ViewGroup) findViewById(R.id.ksad_playable_pre_tips_root);
            }
            initView();
        }
        if (this.rO.fZ()) {
            a(new ViewGroup.LayoutParams(-1, this.f11800uc.getResources().getDimensionPixelSize(R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.rO.f11692qi.a(this);
        }
        this.rO.b(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.f11800uc;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.f11800uc;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.a.fr().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.adlog.c.e(this.rO.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(192).aq(this.rO.f11689qf.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11803uf = com.kwad.components.ad.reward.a.b.gQ();
        this.f11802ue = !com.kwad.components.ad.reward.a.b.gS() && com.kwad.components.ad.reward.a.b.gR();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.c(this.mPlayEndPageListener);
        this.rO.f11692qi.b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.f11804ug = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        com.kwad.sdk.core.d.c.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.f11800uc.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                marginLayoutParams.bottomMargin = this.f11800uc.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize = this.f11800uc.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.f11804ug;
                    View view = weakReference != null ? weakReference.get() : null;
                    int i10 = marginLayoutParams2.height;
                    if (i10 <= 0 && view != null) {
                        i10 = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i10 + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                } else {
                    marginLayoutParams.bottomMargin = layoutParams.height + dimensionPixelSize;
                }
            }
            this.f11800uc.setLayoutParams(marginLayoutParams);
        }
    }
}
