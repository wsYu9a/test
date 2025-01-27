package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.c.b;
import com.kwad.components.core.page.recycle.e;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.proxy.h;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bd;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends h {
    private FeedVideoView Qd;
    private LinearLayout Qe;
    private SplitScrollWebView Sg;
    private Presenter Sh;
    private com.kwad.components.core.page.splitLandingPage.view.a Si;
    private com.kwad.components.core.page.c.a Sj;
    private boolean Sk;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.a$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.Qe.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.a$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a.this.qM();
            a.this.Qd.qR();
            a.a(a.this, false);
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.a$3 */
    public class AnonymousClass3 implements a.InterfaceC0441a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0441a
        public final boolean qO() {
            return a.this.qL();
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.a$4 */
    public class AnonymousClass4 extends bd {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.Sg.setTranslationY(a.this.Sg.getTranslationY() + a.this.Qd.getHeight());
        }
    }

    /* renamed from: com.kwad.components.core.page.splitLandingPage.a$5 */
    public class AnonymousClass5 implements SplitScrollWebView.a {

        /* renamed from: com.kwad.components.core.page.splitLandingPage.a$5$1 */
        public class AnonymousClass1 extends AnimatorListenerAdapter {
            public AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.Qd.qN();
                if (d.CT() != 2 || a.this.Qd.isComplete()) {
                    return;
                }
                a.this.Si.qR();
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
        public final void f(float f10) {
            a.this.Sg.setTranslationY(a.this.Sg.getTranslationY() - f10);
        }

        @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
        public final boolean qP() {
            if (!a.this.Si.qQ() && d.CT() == 2) {
                return false;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            Animator a10 = n.a(a.this.Sg, (Interpolator) null, a.this.Sg.getTranslationY(), 0.0f);
            if (d.CT() == 2) {
                if (a.this.Qd.isComplete()) {
                    animatorSet.playTogether(a10);
                } else {
                    animatorSet.playSequentially(a10, a.this.Si.aI(true));
                }
            } else if (d.CT() == 1) {
                animatorSet.playTogether(a10);
            }
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                public AnonymousClass1() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.Qd.qN();
                    if (d.CT() != 2 || a.this.Qd.isComplete()) {
                        return;
                    }
                    a.this.Si.qR();
                }
            });
            animatorSet.start();
            return true;
        }
    }

    public static a ax(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void initView() {
        e eVar = new e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.Sh.k(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.MA));
        this.Si = aVar;
        aVar.a(new a.InterfaceC0441a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0441a
            public final boolean qO() {
                return a.this.qL();
            }
        });
        this.Qd.post(new bd() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.Sg.setTranslationY(a.this.Sg.getTranslationY() + a.this.Qd.getHeight());
            }
        });
        this.Sg.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5

            /* renamed from: com.kwad.components.core.page.splitLandingPage.a$5$1 */
            public class AnonymousClass1 extends AnimatorListenerAdapter {
                public AnonymousClass1() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.Qd.qN();
                    if (d.CT() != 2 || a.this.Qd.isComplete()) {
                        return;
                    }
                    a.this.Si.qR();
                }
            }

            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void f(float f10) {
                a.this.Sg.setTranslationY(a.this.Sg.getTranslationY() - f10);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean qP() {
                if (!a.this.Si.qQ() && d.CT() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator a10 = n.a(a.this.Sg, (Interpolator) null, a.this.Sg.getTranslationY(), 0.0f);
                if (d.CT() == 2) {
                    if (a.this.Qd.isComplete()) {
                        animatorSet.playTogether(a10);
                    } else {
                        animatorSet.playSequentially(a10, a.this.Si.aI(true));
                    }
                } else if (d.CT() == 1) {
                    animatorSet.playTogether(a10);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    public AnonymousClass1() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.Qd.qN();
                        if (d.CT() != 2 || a.this.Qd.isComplete()) {
                            return;
                        }
                        a.this.Si.qR();
                    }
                });
                animatorSet.start();
                return true;
            }
        });
    }

    private void j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.Sh = presenter;
        presenter.I(viewGroup);
        b bVar = new b();
        bVar.I(this.Sg);
        com.kwad.components.core.page.c.a aVar = new com.kwad.components.core.page.c.a();
        this.Sj = aVar;
        aVar.I(this.Qd);
        this.Sh.a(bVar);
        this.Sh.a(this.Sj);
    }

    public boolean qL() {
        SplitScrollWebView splitScrollWebView = this.Sg;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.Sk) {
            return false;
        }
        this.Sg.setDisableAnimation(false);
        this.Sk = true;
        SplitScrollWebView splitScrollWebView2 = this.Sg;
        Animator a10 = n.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.Qd.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (d.CT() == 2 && this.Si.isVisible()) {
            this.Si.qN();
            animatorSet.playSequentially(this.Si.aI(false), a10);
        } else {
            animatorSet.play(a10);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            public AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.qM();
                a.this.Qd.qR();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    public void qM() {
        this.Sj.mM();
        this.Sj.I(this.Qd);
        this.Sj.k(new e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    private void x(View view) {
        this.Qe = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.Qe.setVisibility(8);
            }
        });
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        boolean by = com.kwad.sdk.core.response.b.a.by(eb2);
        String bu = com.kwad.sdk.core.response.b.a.bu(eb2);
        if (!by) {
            this.Qe.setVisibility(8);
            return;
        }
        this.Qe.setVisibility(0);
        textView.setText(bu);
        textView.setSelected(true);
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.l.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.Sg;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.Sg.goBack();
            return true;
        }
        if (qL()) {
            return true;
        }
        FeedVideoView feedVideoView = this.Qd;
        if (feedVideoView != null) {
            return feedVideoView.uy();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.Qd = (FeedVideoView) findViewById(R.id.ksad_split_land_ad_feed_video);
        this.Sg = (SplitScrollWebView) findViewById(R.id.ksad_video_webView);
        x(view);
        j(this.mR);
        initView();
    }

    @Override // com.kwad.components.core.proxy.h
    public final int pR() {
        return R.layout.ksad_split_land_page;
    }

    public final void qN() {
        this.Qd.qN();
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.Sk = false;
        return false;
    }
}
