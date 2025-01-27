package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private TransViewPager jF;

    /* renamed from: kb */
    private ImageView f11569kb;

    /* renamed from: kc */
    private ImageView f11570kc;

    /* renamed from: kd */
    private ImageView f11571kd;

    /* renamed from: ke */
    private int f11572ke;

    /* renamed from: kf */
    private int f11573kf;

    /* renamed from: kg */
    private final ViewPager.OnPageChangeListener f11574kg;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView$1 */
    public class AnonymousClass1 extends ViewPager.SimpleOnPageChangeListener {
        public AnonymousClass1() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i10) {
            InterstitialAggregateManualTipsView.this.f11572ke = i10;
            if (InterstitialAggregateManualTipsView.this.f11572ke == InterstitialAggregateManualTipsView.this.f11573kf - 1) {
                InterstitialAggregateManualTipsView.this.f11569kb.setAlpha(0.5f);
                InterstitialAggregateManualTipsView.this.f11570kc.setAlpha(0.5f);
            } else {
                InterstitialAggregateManualTipsView.this.f11569kb.setAlpha(1.0f);
                InterstitialAggregateManualTipsView.this.f11570kc.setAlpha(1.0f);
            }
        }
    }

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    private void cV() {
        int i10 = this.f11572ke;
        if (i10 < this.f11573kf - 1) {
            this.jF.setCurrentItem(i10 + 1, true);
        }
    }

    private void initView() {
        m.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.f11569kb = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.f11570kc = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.f11571kd = imageView;
        com.kwad.sdk.c.a.a.a(this, this.f11569kb, this.f11570kc, imageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.ad.interstitial.h.c y10;
        if (view.equals(this.f11569kb)) {
            cV();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 162);
        } else if (view.equals(this.f11570kc)) {
            cV();
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 36);
        } else {
            if (!view.equals(this.f11571kd) || (y10 = this.jF.y(this.f11572ke)) == null) {
                return;
            }
            y10.ew();
        }
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11574kg = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            public AnonymousClass1() {
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i102) {
                InterstitialAggregateManualTipsView.this.f11572ke = i102;
                if (InterstitialAggregateManualTipsView.this.f11572ke == InterstitialAggregateManualTipsView.this.f11573kf - 1) {
                    InterstitialAggregateManualTipsView.this.f11569kb.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.f11570kc.setAlpha(0.5f);
                } else {
                    InterstitialAggregateManualTipsView.this.f11569kb.setAlpha(1.0f);
                    InterstitialAggregateManualTipsView.this.f11570kc.setAlpha(1.0f);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public final void a(@NonNull AdTemplate adTemplate, @NonNull TransViewPager transViewPager) {
        this.mAdTemplate = adTemplate;
        this.jF = transViewPager;
        this.f11572ke = transViewPager.getCurrentItem();
        a aVar = (a) transViewPager.getAdapter();
        if (aVar == null) {
            return;
        }
        this.f11573kf = aVar.getCount();
        new d(this.jF.getContext()).a(this.jF);
        this.jF.addOnPageChangeListener(this.f11574kg);
        AdInfo eb2 = e.eb(adTemplate);
        String dG = com.kwad.sdk.core.response.b.b.dG(eb2);
        String dH = com.kwad.sdk.core.response.b.b.dH(eb2);
        String dI = com.kwad.sdk.core.response.b.b.dI(eb2);
        if (!TextUtils.isEmpty(dG) && !TextUtils.isEmpty(dH) && !TextUtils.isEmpty(dI)) {
            KSImageLoader.loadImage(this.f11569kb, dG);
            KSImageLoader.loadImage(this.f11570kc, dH);
            KSImageLoader.loadImage(this.f11571kd, dI);
            com.kwad.sdk.core.adlog.c.b(adTemplate, 162, (JSONObject) null);
            return;
        }
        setVisibility(8);
    }
}
