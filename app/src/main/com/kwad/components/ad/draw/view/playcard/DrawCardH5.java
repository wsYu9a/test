package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.l;

/* loaded from: classes2.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    private ValueAnimator eJ;
    private a eL;
    private ImageView eM;
    private TextView eN;
    private TextView eO;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.draw.view.playcard.DrawCardH5$1 */
    public class AnonymousClass1 implements a.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            if (DrawCardH5.this.eL != null) {
                DrawCardH5.this.eL.aV();
            }
        }
    }

    public interface a {
        void aU();

        void aV();
    }

    public DrawCardH5(Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.eM = (ImageView) findViewById(R.id.ksad_card_close);
        this.eN = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.eO = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void bf() {
        ValueAnimator valueAnimator = this.eJ;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.eJ.cancel();
        }
    }

    private void bp() {
        d(this.mHeight, 0);
    }

    private void d(int i10, int i11) {
        bf();
        ValueAnimator b10 = n.b(this, i10, i11);
        this.eJ = b10;
        b10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.eJ.setDuration(300L);
        this.eJ.start();
    }

    public final void bn() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.eM) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(getContext()).au(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (DrawCardH5.this.eL != null) {
                        DrawCardH5.this.eL.aV();
                    }
                }
            }));
            return;
        }
        bp();
        a aVar = this.eL;
        if (aVar != null) {
            aVar.aU();
        }
    }

    public final void release() {
        bf();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = e.eb(adTemplate);
        this.eL = aVar;
        this.eN.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        this.eO.setText(com.kwad.sdk.core.response.b.a.aE(eb2));
        this.eM.setOnClickListener(this);
        this.eO.setOnClickListener(this);
        this.mLogoView.aK(adTemplate);
        setOnClickListener(this);
        this.eN.measure(View.MeasureSpec.makeMeasureSpec((l.getScreenWidth(this.mContext) - (com.kwad.sdk.c.a.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.c.a.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.c.a.a.a(this.mContext, 100.0f) + this.eN.getMeasuredHeight();
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        A(context);
    }
}
