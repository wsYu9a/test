package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bo;
import com.martian.libmars.widget.FoldedTextView;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e implements View.OnClickListener {
    private final boolean ape;
    private final boolean apf;
    private View apg;
    private ImageView aph;
    private TextView api;
    private Button apj;
    private int apk;
    private int apl;
    private boolean apm;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;

    @NonNull
    private final Context mContext;

    @NonNull
    private View mRootView = Bo();

    /* renamed from: com.kwad.sdk.a.a.e$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            e.this.dismiss();
        }
    }

    /* renamed from: com.kwad.sdk.a.a.e$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup apo;

        public AnonymousClass2(ViewGroup viewGroup) {
            viewGroup = viewGroup;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            viewGroup.removeView(e.this.mRootView);
        }
    }

    /* renamed from: com.kwad.sdk.a.a.e$3 */
    public class AnonymousClass3 implements ap.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.ap.a
        public final void d(Throwable th2) {
            com.kwad.sdk.commercial.a.a.i(e.this.mAdTemplate, 100003, Log.getStackTraceString(th2));
        }

        @Override // com.kwad.sdk.utils.ap.a
        public final void pa() {
            com.kwad.sdk.core.adlog.c.h(e.this.mAdTemplate, 1);
            com.kwad.sdk.commercial.a.a.bf(e.this.mAdTemplate);
        }
    }

    public e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z10, boolean z11, boolean z12) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.ape = z10;
        this.apf = z11;
        this.apm = z12;
        mH();
    }

    @SuppressLint({"InflateParams"})
    private View Bo() {
        if (this.ape && this.apf) {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.apg = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.aph = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.api = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.apj = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    private Animator D(View view) {
        ObjectAnimator ofFloat = (this.ape && this.apf) ? ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, this.apl) : ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.apk);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    private void c(FrameLayout frameLayout) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.apk = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.apk);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void d(FrameLayout frameLayout) {
        int screenWidth = bo.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.apl = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.apl);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void mH() {
        this.apj.setText(this.ape ? "安装" : "打开");
        this.apg.setOnClickListener(this);
        this.apj.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.aph, com.kwad.sdk.core.response.b.a.cm(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)), this.mAdTemplate, 8);
        String av = com.kwad.sdk.core.response.b.a.av(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
        if (av.length() >= 8) {
            av = av.substring(0, 7) + FoldedTextView.f12585y;
        }
        this.api.setText(this.mContext.getString(this.ape ? R.string.ksad_install_tips : R.string.ksad_launch_tips, av));
    }

    private void show() {
        ObjectAnimator ofFloat = (this.ape && this.apf) ? ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_X, this.apl, 0.0f) : ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_Y, -this.apk, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator D = D(this.mRootView);
        D.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            final /* synthetic */ ViewGroup apo;

            public AnonymousClass2(ViewGroup viewGroup2) {
                viewGroup = viewGroup2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        D.start();
        c.Bg().Bl();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.ksad_install_tips_install) {
            if (!this.ape) {
                if (ap.aq(this.mContext, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
                    com.kwad.sdk.core.adlog.c.bP(this.mAdTemplate);
                }
                com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 47);
                return;
            }
            if (this.apm) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.cN(29);
                bVar.cU(23);
                com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar);
            } else {
                com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 45);
            }
            ap.a(com.kwad.sdk.core.response.b.a.H(this.mAdInfo), new ap.a() { // from class: com.kwad.sdk.a.a.e.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.utils.ap.a
                public final void d(Throwable th2) {
                    com.kwad.sdk.commercial.a.a.i(e.this.mAdTemplate, 100003, Log.getStackTraceString(th2));
                }

                @Override // com.kwad.sdk.utils.ap.a
                public final void pa() {
                    com.kwad.sdk.core.adlog.c.h(e.this.mAdTemplate, 1);
                    com.kwad.sdk.commercial.a.a.bf(e.this.mAdTemplate);
                }
            });
            return;
        }
        if (view.getId() == R.id.ksad_install_tips_close) {
            if (!this.ape) {
                com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 48);
                return;
            }
            if (!this.apm) {
                com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
            bVar2.cN(69);
            bVar2.cU(23);
            bVar2.cY(1);
            com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar2);
        }
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.ape && this.apf) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new bd() { // from class: com.kwad.sdk.a.a.e.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                e.this.dismiss();
            }
        }, 10000L);
    }
}
