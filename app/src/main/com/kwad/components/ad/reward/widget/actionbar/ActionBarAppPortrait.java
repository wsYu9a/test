package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public class ActionBarAppPortrait extends LinearLayout implements c {
    private AppScoreView CU;
    private TextProgressBar CV;
    private View CW;
    private a CZ;
    private KsAppDownloadListener dL;
    private ImageView eT;
    private TextView eU;
    private TextView eW;

    /* renamed from: gb */
    private TextView f11892gb;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
            ActionBarAppPortrait.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.cg(ActionBarAppPortrait.this.mAdTemplate), 0);
            ActionBarAppPortrait.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
            ActionBarAppPortrait.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppPortrait.this.mAdInfo), 0);
            ActionBarAppPortrait.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
            ActionBarAppPortrait.this.CW.setVisibility(8);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
            ActionBarAppPortrait.this.CW.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait$2 */
    public class AnonymousClass2 implements a.b {
        final /* synthetic */ boolean vU;

        public AnonymousClass2(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            if (ActionBarAppPortrait.this.CZ != null) {
                ActionBarAppPortrait.this.CZ.O(z10);
            }
        }
    }

    public interface a {
        void O(boolean z10);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dL == null) {
            this.dL = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.cg(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
                    ActionBarAppPortrait.this.CW.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    ActionBarAppPortrait.this.CV.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
                    ActionBarAppPortrait.this.CW.setVisibility(8);
                }
            };
        }
        return this.dL;
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.eT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.eU = (TextView) findViewById(R.id.ksad_app_title);
        this.f11892gb = (TextView) findViewById(R.id.ksad_app_desc);
        this.CU = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.eW = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.CV = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.CV.setTextColor(-1);
        this.CW = findViewById(R.id.ksad_download_bar_cover);
    }

    private void kC() {
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        boolean z10 = !TextUtils.isEmpty(az);
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z11 = aA >= 3.0f;
        if (z10 && z11) {
            ((LinearLayout.LayoutParams) this.eU.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.CU.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            this.eW.setText(az);
            this.eW.setVisibility(0);
            this.CU.setVisibility(0);
            this.CU.setScore(aA);
            this.f11892gb.setVisibility(8);
            return;
        }
        if (z10) {
            this.eW.setText(az);
            this.eW.setVisibility(0);
            this.CU.setVisibility(8);
            this.f11892gb.setVisibility(8);
            return;
        }
        if (z11) {
            this.eW.setVisibility(8);
            this.CU.setScore(aA);
            this.CU.setVisibility(0);
            this.f11892gb.setVisibility(8);
            return;
        }
        this.f11892gb.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.eW.setVisibility(8);
        this.CU.setVisibility(8);
        this.f11892gb.setVisibility(0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = e.eb(adTemplate);
        this.mAdInfo = eb2;
        this.CZ = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.eT, com.kwad.sdk.core.response.b.a.cm(eb2), adTemplate, 12);
        this.eU.setText(com.kwad.sdk.core.response.b.a.cj(this.mAdInfo));
        kC();
        this.CV.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), 0);
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.CW, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    private void b(View view, boolean z10) {
        int i10 = view == this.CW ? 1 : 2;
        com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).am(1).an(i10).ap(view == this.CV).ao(i10).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            final /* synthetic */ boolean vU;

            public AnonymousClass2(boolean z102) {
                z10 = z102;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.CZ != null) {
                    ActionBarAppPortrait.this.CZ.O(z10);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
