package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.aggregate.a;
import com.kwad.components.ad.interstitial.aggregate.c;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.interstitial.h.a {

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11580dh;
    private final com.kwad.sdk.core.h.c eu;
    private boolean jA;
    private TransViewPager jF;
    private a jG;
    private ViewPagerIndicator jH;
    private SlideTipsView jI;
    private SlideTipsView jJ;
    private ValueAnimator jK;
    private boolean jL;
    private InterstitialAggregateManualTipsView jM;
    private boolean jN;
    private boolean jO;
    private final ViewPager.OnPageChangeListener jP;
    protected KsInterstitialAd.AdInteractionListener jr;
    private final List<AdResultData> jy;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdResultData mAdResultData;

    @NonNull
    protected AdTemplate mAdTemplate;
    private final View mRootView;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$1 */
    public class AnonymousClass1 implements a.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.aggregate.a.b
        public final void a(com.kwad.components.ad.interstitial.h.c cVar, int i10) {
            b.this.jF.a(i10, cVar);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$10 */
    public class AnonymousClass10 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass10() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            b.this.jF.scrollTo(intValue, 0);
            b.this.jF.onPageScrolled(0, intValue / b.this.getWidth(), 0);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$11 */
    public class AnonymousClass11 extends AnimatorListenerAdapter {
        public AnonymousClass11() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            b.this.jF.setCurrentItem(1);
            b.this.jJ.setVisibility(0);
            b.this.jJ.startAnimation(b.a(b.this, -0.5f, -0.1f));
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.h.d {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bl() {
            super.bl();
            if (b.this.jL) {
                if (b.this.jH != null) {
                    b.this.jH.cZ();
                }
                if (b.this.jK != null) {
                    b.this.jK.resume();
                }
                b.this.jL = false;
            }
        }

        @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
        public final void bm() {
            super.bm();
            if (b.this.jL) {
                return;
            }
            if (b.this.jH != null) {
                b.this.jH.cY();
            }
            if (b.this.jK != null) {
                b.this.jK.pause();
            }
            b.this.jL = true;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$3 */
    public class AnonymousClass3 extends ViewPager.SimpleOnPageChangeListener {
        private int jR = 0;

        public AnonymousClass3() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i10, float f10, int i11) {
            if (f10 != 0.0f) {
                if (b.this.jI.getVisibility() == 0) {
                    b.this.jI.clearAnimation();
                    b.this.jI.setVisibility(8);
                }
                if (b.this.jJ.getVisibility() == 0) {
                    b.this.jJ.clearAnimation();
                    b.this.jJ.setVisibility(8);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i10) {
            com.kwad.components.ad.interstitial.h.c y10 = b.this.jF.y(i10);
            if (y10 != null) {
                y10.eu();
            }
            if (this.jR != i10) {
                com.kwad.sdk.core.adlog.c.a(com.kwad.sdk.core.response.b.c.o((AdResultData) b.this.jy.get(this.jR)), -1L, (JSONObject) null);
                com.kwad.components.ad.interstitial.h.c y11 = b.this.jF.y(this.jR);
                if (y11 != null) {
                    y11.ev();
                }
            }
            this.jR = i10;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$4 */
    public class AnonymousClass4 implements a.InterfaceC0377a {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0377a
        public final void cL() {
            if (b.this.jO) {
                return;
            }
            if (b.this.jK != null) {
                b.this.jK.cancel();
            }
            b.this.jH.setPlayProgressListener(null);
            b.this.jH.setVisibility(8);
            b.this.jF.setScrollable(false);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$5 */
    public class AnonymousClass5 extends bd {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.cM();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$6 */
    public class AnonymousClass6 implements c.b {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.interstitial.aggregate.c.b
        public final void onInterstitialAdLoad(@Nullable List<AdResultData> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            b.this.jy.addAll(list);
            b.this.jG.d(b.this.jy);
            b.this.jG.notifyDataSetChanged();
            b.this.jF.setOffscreenPageLimit(b.this.jy.size() - 1);
            b.this.jF.addOnPageChangeListener(b.this.jP);
            b.this.cP();
            b.this.jH.setViewPager(b.this.jF);
            b.this.jH.setVisibility(0);
            b.this.f11580dh.a(b.this.eu);
            com.kwad.components.ad.interstitial.c.a.I(b.this.mContext);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$7 */
    public class AnonymousClass7 implements ViewPagerIndicator.a {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
        public final void cS() {
            b.a(b.this, true);
            if (b.this.jA) {
                b.this.cR();
            } else {
                b.this.cQ();
            }
            b.this.jF.setScrollable(true);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$8 */
    public class AnonymousClass8 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass8() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.jF.scrollTo(com.kwad.sdk.c.a.a.a(b.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
            b.this.jF.onPageScrolled(0, com.kwad.sdk.c.a.a.a(b.this.mContext, r4) / b.this.getWidth(), 0);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.b$9 */
    public class AnonymousClass9 extends AnimatorListenerAdapter {
        public AnonymousClass9() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (b.this.jN) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setFillAfter(true);
                b.this.jM.startAnimation(alphaAnimation);
                b.this.jM.setVisibility(0);
            }
            b.this.jI.setVisibility(0);
            b.this.jI.startAnimation(b.a(b.this, 0.5f, 0.1f));
        }
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ AnimationSet a(b bVar, float f10, float f11) {
        return b(f10, f11);
    }

    public void cM() {
        if (this.mAdTemplate.mAdScene != null) {
            c.cT().a(16, com.kwad.components.ad.interstitial.b.b.df(), this.mAdTemplate.mAdScene, new c.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
                public AnonymousClass6() {
                }

                @Override // com.kwad.components.ad.interstitial.aggregate.c.b
                public final void onInterstitialAdLoad(@Nullable List<AdResultData> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b.this.jy.addAll(list);
                    b.this.jG.d(b.this.jy);
                    b.this.jG.notifyDataSetChanged();
                    b.this.jF.setOffscreenPageLimit(b.this.jy.size() - 1);
                    b.this.jF.addOnPageChangeListener(b.this.jP);
                    b.this.cP();
                    b.this.jH.setViewPager(b.this.jF);
                    b.this.jH.setVisibility(0);
                    b.this.f11580dh.a(b.this.eu);
                    com.kwad.components.ad.interstitial.c.a.I(b.this.mContext);
                }
            });
        }
    }

    public void cP() {
        this.jH.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void cS() {
                b.a(b.this, true);
                if (b.this.jA) {
                    b.this.cR();
                } else {
                    b.this.cQ();
                }
                b.this.jF.setScrollable(true);
            }
        });
    }

    public void cQ() {
        if (this.jN) {
            this.jM.a(this.mAdTemplate, this.jF);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 120, 0);
        this.jK = ofInt;
        ofInt.setDuration(1200L);
        this.jK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.8
            public AnonymousClass8() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.jF.scrollTo(com.kwad.sdk.c.a.a.a(b.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                b.this.jF.onPageScrolled(0, com.kwad.sdk.c.a.a.a(b.this.mContext, r4) / b.this.getWidth(), 0);
            }
        });
        this.jK.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.9
            public AnonymousClass9() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (b.this.jN) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setFillAfter(true);
                    b.this.jM.startAnimation(alphaAnimation);
                    b.this.jM.setVisibility(0);
                }
                b.this.jI.setVisibility(0);
                b.this.jI.startAnimation(b.a(b.this, 0.5f, 0.1f));
            }
        });
        this.jK.start();
    }

    public void cR() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        this.jK = ofInt;
        ofInt.setDuration(800L);
        this.jK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.10
            public AnonymousClass10() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.jF.scrollTo(intValue, 0);
                b.this.jF.onPageScrolled(0, intValue / b.this.getWidth(), 0);
            }
        });
        this.jK.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.11
            public AnonymousClass11() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                b.this.jF.setCurrentItem(1);
                b.this.jJ.setVisibility(0);
                b.this.jJ.startAnimation(b.a(b.this, -0.5f, -0.1f));
            }
        });
        this.jK.start();
    }

    private void initView() {
        this.jF = (TransViewPager) this.mRootView.findViewById(R.id.ksad_multi_ad_container);
        this.jH = (ViewPagerIndicator) this.mRootView.findViewById(R.id.ksad_multi_ad_indicator);
        this.jI = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_left_slide);
        this.jJ = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_right_slide);
        this.jM = (InterstitialAggregateManualTipsView) this.mRootView.findViewById(R.id.ksad_manual_tips_view);
        this.f11580dh = new com.kwad.components.core.widget.a.b(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void cN() {
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void cO() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11580dh.b(this.eu);
        this.f11580dh.uF();
        this.jy.clear();
        this.jF.clearOnPageChangeListeners();
        c.cT().release();
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.jr = adInteractionListener;
    }

    private b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.jy = new ArrayList();
        this.eu = new com.kwad.sdk.core.h.d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
            public final void bl() {
                super.bl();
                if (b.this.jL) {
                    if (b.this.jH != null) {
                        b.this.jH.cZ();
                    }
                    if (b.this.jK != null) {
                        b.this.jK.resume();
                    }
                    b.this.jL = false;
                }
            }

            @Override // com.kwad.sdk.core.h.d, com.kwad.sdk.core.h.c
            public final void bm() {
                super.bm();
                if (b.this.jL) {
                    return;
                }
                if (b.this.jH != null) {
                    b.this.jH.cY();
                }
                if (b.this.jK != null) {
                    b.this.jK.pause();
                }
                b.this.jL = true;
            }
        };
        this.jP = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3
            private int jR = 0;

            public AnonymousClass3() {
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i10, float f10, int i11) {
                if (f10 != 0.0f) {
                    if (b.this.jI.getVisibility() == 0) {
                        b.this.jI.clearAnimation();
                        b.this.jI.setVisibility(8);
                    }
                    if (b.this.jJ.getVisibility() == 0) {
                        b.this.jJ.clearAnimation();
                        b.this.jJ.setVisibility(8);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i10) {
                com.kwad.components.ad.interstitial.h.c y10 = b.this.jF.y(i10);
                if (y10 != null) {
                    y10.eu();
                }
                if (this.jR != i10) {
                    com.kwad.sdk.core.adlog.c.a(com.kwad.sdk.core.response.b.c.o((AdResultData) b.this.jy.get(this.jR)), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.h.c y11 = b.this.jF.y(this.jR);
                    if (y11 != null) {
                        y11.ev();
                    }
                }
                this.jR = i10;
            }
        };
        this.mContext = context;
        this.mRootView = m.inflate(context, R.layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z10) {
        bVar.jO = true;
        return true;
    }

    private static AnimationSet b(float f10, float f11) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f10, 1, f11, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800L);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        float f10;
        this.mAdResultData = adResultData;
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        this.mAdTemplate = o10;
        AdInfo eb2 = e.eb(o10);
        this.mAdInfo = eb2;
        this.jA = com.kwad.sdk.core.response.b.a.cz(eb2) == 1;
        this.jy.clear();
        this.jy.add(this.mAdResultData);
        this.jr = adInteractionListener;
        a aVar = new a(this.mAdResultData, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.jG = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.h.c cVar, int i10) {
                b.this.jF.a(i10, cVar);
            }
        });
        this.jG.a(new a.InterfaceC0377a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0377a
            public final void cL() {
                if (b.this.jO) {
                    return;
                }
                if (b.this.jK != null) {
                    b.this.jK.cancel();
                }
                b.this.jH.setPlayProgressListener(null);
                b.this.jH.setVisibility(8);
                b.this.jF.setScrollable(false);
            }
        });
        this.jF.setAdapter(this.jG);
        this.jG.d(this.jy);
        this.jG.notifyDataSetChanged();
        this.f11580dh.uE();
        ViewPagerIndicator viewPagerIndicator = this.jH;
        if (viewPagerIndicator == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewPagerIndicator.getLayoutParams();
        if (marginLayoutParams != null) {
            boolean NS = an.NS();
            this.jN = NS;
            Context context = this.mContext;
            if (NS) {
                f10 = this.jA ? 12 : 4;
            } else {
                f10 = 6.0f;
            }
            marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(context, f10);
            this.jH.setLayoutParams(marginLayoutParams);
        }
        this.jH.setFirstAdShowTime(com.kwad.sdk.core.response.b.a.cA(this.mAdInfo));
        post(new bd() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.this.cM();
            }
        });
    }
}
