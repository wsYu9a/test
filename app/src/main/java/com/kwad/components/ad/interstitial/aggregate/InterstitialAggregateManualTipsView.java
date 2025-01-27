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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private TransViewPager hZ;
    private ImageView iA;
    private ImageView iB;
    private int iC;
    private int iD;
    private final ViewPager.OnPageChangeListener iE;
    private ImageView iz;
    private AdTemplate mAdTemplate;
    private final Context mContext;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView$1 */
    final class AnonymousClass1 extends ViewPager.SimpleOnPageChangeListener {
        AnonymousClass1() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            ImageView imageView;
            float f2;
            InterstitialAggregateManualTipsView.this.iC = i2;
            if (InterstitialAggregateManualTipsView.this.iC == InterstitialAggregateManualTipsView.this.iD - 1) {
                imageView = InterstitialAggregateManualTipsView.this.iz;
                f2 = 0.5f;
            } else {
                imageView = InterstitialAggregateManualTipsView.this.iz;
                f2 = 1.0f;
            }
            imageView.setAlpha(f2);
            InterstitialAggregateManualTipsView.this.iA.setAlpha(f2);
        }
    }

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.iE = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            AnonymousClass1() {
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i22) {
                ImageView imageView;
                float f2;
                InterstitialAggregateManualTipsView.this.iC = i22;
                if (InterstitialAggregateManualTipsView.this.iC == InterstitialAggregateManualTipsView.this.iD - 1) {
                    imageView = InterstitialAggregateManualTipsView.this.iz;
                    f2 = 0.5f;
                } else {
                    imageView = InterstitialAggregateManualTipsView.this.iz;
                    f2 = 1.0f;
                }
                imageView.setAlpha(f2);
                InterstitialAggregateManualTipsView.this.iA.setAlpha(f2);
            }
        };
        this.mContext = context;
        initView();
    }

    private void cC() {
        int i2 = this.iC;
        if (i2 < this.iD - 1) {
            this.hZ.setCurrentItem(i2 + 1, true);
        }
    }

    private void initView() {
        k.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.iz = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.iA = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.iB = imageView;
        com.kwad.sdk.c.kwai.a.a(this, this.iz, this.iA, imageView);
    }

    public final void a(@NonNull AdTemplate adTemplate, @NonNull TransViewPager transViewPager) {
        this.mAdTemplate = adTemplate;
        this.hZ = transViewPager;
        this.iC = transViewPager.getCurrentItem();
        a aVar = (a) transViewPager.getAdapter();
        if (aVar == null) {
            return;
        }
        this.iD = aVar.getCount();
        new d(this.hZ.getContext()).a(this.hZ);
        this.hZ.addOnPageChangeListener(this.iE);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String cT = com.kwad.sdk.core.response.a.b.cT(cb);
        String cU = com.kwad.sdk.core.response.a.b.cU(cb);
        String cV = com.kwad.sdk.core.response.a.b.cV(cb);
        if (TextUtils.isEmpty(cT) || TextUtils.isEmpty(cU) || TextUtils.isEmpty(cV)) {
            setVisibility(8);
            return;
        }
        KSImageLoader.loadImage(this.iz, cT);
        KSImageLoader.loadImage(this.iA, cU);
        KSImageLoader.loadImage(this.iB, cV);
        com.kwad.sdk.core.report.a.b(adTemplate, 162, (JSONObject) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.ad.interstitial.e.c B;
        AdTemplate adTemplate;
        int i2;
        if (view.equals(this.iz)) {
            cC();
            adTemplate = this.mAdTemplate;
            i2 = 162;
        } else {
            if (!view.equals(this.iA)) {
                if (!view.equals(this.iB) || (B = this.hZ.B(this.iC)) == null) {
                    return;
                }
                B.ey();
                return;
            }
            cC();
            adTemplate = this.mAdTemplate;
            i2 = 36;
        }
        com.kwad.sdk.core.report.a.q(adTemplate, i2);
    }
}
