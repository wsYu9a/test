package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public class ActionBarH5 extends FrameLayout implements c {
    private TextView Db;
    private a Dc;
    private View Dd;

    /* renamed from: fb */
    private TextView f11893fb;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5$1 */
    public class AnonymousClass1 implements a.b {
        final /* synthetic */ boolean vU;

        public AnonymousClass1(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            if (ActionBarH5.this.Dc != null) {
                ActionBarH5.this.Dc.O(z10);
            }
        }
    }

    public interface a {
        void O(boolean z10);
    }

    public ActionBarH5(Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.Db = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.f11893fb = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.Dd = findViewById(R.id.ksad_download_bar_cover);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.Dc = aVar;
        AdInfo eb2 = e.eb(adTemplate);
        this.Db.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        this.f11893fb.setText(com.kwad.sdk.core.response.b.a.aE(eb2));
        setClickable(true);
        this.Dd.setClickable(true);
        new f(this.Dd, this);
        new f(this, this);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    private void b(View view, boolean z10) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.mAdTemplate).ao(view == this.Dd ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            final /* synthetic */ boolean vU;

            public AnonymousClass1(boolean z102) {
                z10 = z102;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.Dc != null) {
                    ActionBarH5.this.Dc.O(z10);
                }
            }
        }));
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        A(context);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
