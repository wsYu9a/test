package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a extends LinearLayout {
    protected AppScoreView CU;
    protected TextProgressBar Dk;
    protected View Jh;
    protected TextView Kr;
    protected TextView eW;
    protected ValueAnimator ky;

    /* renamed from: mi */
    protected ImageView f11910mi;

    /* renamed from: mj */
    protected TextView f11911mj;
    protected View zD;
    protected Button zE;
    protected Button zF;
    protected KsAppTagsView zL;
    protected com.kwad.components.ad.k.a zO;
    private Runnable zP;

    /* renamed from: com.kwad.components.ad.widget.tailframe.appbar.a$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.zO.io();
        }
    }

    /* renamed from: com.kwad.components.ad.widget.tailframe.appbar.a$2 */
    public class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.Dk.setScaleY(floatValue);
            a.this.Dk.setScaleX(floatValue);
        }
    }

    public a(Context context) {
        this(context, null);
    }

    private void initView() {
        this.Jh = m.inflate(getContext(), getLayoutId(), this);
        this.f11910mi = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f11911mj = (TextView) findViewById(R.id.ksad_app_name);
        this.CU = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.eW = (TextView) findViewById(R.id.ksad_app_download_count);
        this.Kr = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.Dk = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.Dk.setTextColor(-1);
        this.zL = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.zE = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.zF = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.zD = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.zO = new com.kwad.components.ad.k.a(this.Jh);
    }

    private void ng() {
        ValueAnimator valueAnimator = this.ky;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.ky = ofFloat;
            ofFloat.setDuration(1200L);
            this.ky.setRepeatCount(-1);
            this.ky.setRepeatMode(1);
            this.ky.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                public AnonymousClass2() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.Dk.setScaleY(floatValue);
                    a.this.Dk.setScaleX(floatValue);
                }
            });
            this.ky.start();
        }
    }

    public final void D(@NonNull AdInfo adInfo) {
        int i10 = adInfo.status;
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            kH();
        } else {
            ng();
        }
    }

    public void f(@NonNull AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        if (e.J(adTemplate)) {
            KSImageLoader.loadAppIcon(this.f11910mi, com.kwad.sdk.core.response.b.a.cP(eb2), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.f11910mi, com.kwad.sdk.core.response.b.a.cm(eb2), adTemplate, 12);
        }
        this.f11911mj.setText(com.kwad.sdk.core.response.b.a.cj(eb2));
        if (!e.J(adTemplate)) {
            float aA = com.kwad.sdk.core.response.b.a.aA(eb2);
            if (aA >= 3.0f) {
                this.CU.setScore(aA);
                this.CU.setVisibility(0);
            } else {
                this.CU.setVisibility(8);
            }
            String az = com.kwad.sdk.core.response.b.a.az(eb2);
            if (TextUtils.isEmpty(az)) {
                this.eW.setVisibility(8);
            } else {
                this.eW.setText(az);
                this.eW.setVisibility(0);
            }
        }
        this.Kr.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        if (e.J(adTemplate)) {
            this.Dk.setVisibility(8);
            this.zD.setVisibility(0);
            this.zF.setText("查看详情");
            Button button = this.zE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d.DG());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb2.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.zP == null) {
                    this.zP = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.zO.io();
                        }
                    };
                }
                this.zD.postDelayed(this.zP, 1600L);
            }
        } else {
            this.Dk.setVisibility(0);
            this.zD.setVisibility(8);
            Runnable runnable = this.zP;
            if (runnable != null) {
                this.zD.removeCallbacks(runnable);
                this.zP = null;
            }
            D(e.eb(adTemplate));
        }
        if (e.J(adTemplate)) {
            List<String> dS = com.kwad.sdk.core.response.b.d.dS(adTemplate);
            if (dS.size() > 0) {
                this.zL.setVisibility(0);
            } else {
                this.zL.setVisibility(8);
            }
            this.zL.setAppTags(dS);
        }
    }

    public View getBtnInstallContainer() {
        return this.zD;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.Dk;
    }

    public final void kH() {
        ValueAnimator valueAnimator = this.ky;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ky.cancel();
            this.ky.end();
        }
        Runnable runnable = this.zP;
        if (runnable != null) {
            this.zD.removeCallbacks(runnable);
            this.zP = null;
        }
        this.zO.mR();
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(m.wrapContextIfNeed(context), attributeSet, i10);
        initView();
    }
}
