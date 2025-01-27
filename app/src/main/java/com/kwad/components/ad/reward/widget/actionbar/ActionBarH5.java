package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public class ActionBarH5 extends FrameLayout implements c {
    private TextView AR;
    private a AS;
    private View AT;
    private TextView dR;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5$1 */
    final class AnonymousClass1 implements a.b {
        final /* synthetic */ boolean tN;

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            if (ActionBarH5.this.AS != null) {
                ActionBarH5.this.AS.R(z);
            }
        }
    }

    public interface a {
        void R(boolean z);
    }

    public ActionBarH5(Context context) {
        super(context);
        D(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        k.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.AR = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dR = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.AT = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b(View view, boolean z) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(view.getContext()).I(this.mAdTemplate).ap(view == this.AT ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            final /* synthetic */ boolean tN;

            AnonymousClass1(boolean z2) {
                z = z2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.AS != null) {
                    ActionBarH5.this.AS.R(z);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.AS = aVar;
        AdInfo cb = d.cb(adTemplate);
        this.AR.setText(com.kwad.sdk.core.response.a.a.an(cb));
        this.dR.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        setClickable(true);
        this.AT.setClickable(true);
        new f(this.AT, this);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }
}
