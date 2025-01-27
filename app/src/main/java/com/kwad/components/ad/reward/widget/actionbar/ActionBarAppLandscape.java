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
public class ActionBarAppLandscape extends LinearLayout implements c {
    private AppScoreView CU;
    private TextProgressBar CV;
    private View CW;
    private a CX;
    private KsAppDownloadListener dL;
    private ImageView eT;
    private TextView eU;
    private TextView eW;

    /* renamed from: gb */
    private TextView f11891gb;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
            ActionBarAppLandscape.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.cg(ActionBarAppLandscape.this.mAdTemplate), 0);
            ActionBarAppLandscape.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
            ActionBarAppLandscape.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppLandscape.this.mAdInfo), 0);
            ActionBarAppLandscape.this.CW.setVisibility(0);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
            ActionBarAppLandscape.this.CW.setVisibility(8);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
            ActionBarAppLandscape.this.CW.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape$2 */
    public class AnonymousClass2 implements a.b {
        final /* synthetic */ boolean vU;

        public AnonymousClass2(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            if (ActionBarAppLandscape.this.CX != null) {
                ActionBarAppLandscape.this.CX.O(z10);
            }
        }
    }

    public interface a {
        void O(boolean z10);
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dL == null) {
            this.dL = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.cg(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.CW.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
                    ActionBarAppLandscape.this.CW.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    ActionBarAppLandscape.this.CV.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
                    ActionBarAppLandscape.this.CW.setVisibility(8);
                }
            };
        }
        return this.dL;
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
        this.eT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.eU = (TextView) findViewById(R.id.ksad_app_title);
        this.f11891gb = (TextView) findViewById(R.id.ksad_app_desc);
        this.CU = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.eW = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.CV = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.CV.setTextColor(-1);
        this.CW = findViewById(R.id.ksad_download_bar_cover);
    }

    private void kC() {
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z10 = aA >= 3.0f;
        if (z10) {
            this.CU.setScore(aA);
            this.CU.setVisibility(0);
        }
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        boolean isEmpty = true ^ TextUtils.isEmpty(az);
        if (isEmpty) {
            this.eW.setText(az);
            this.eW.setVisibility(0);
        }
        if (isEmpty || z10) {
            this.f11891gb.setVisibility(8);
            return;
        }
        this.f11891gb.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.CU.setVisibility(8);
        this.eW.setVisibility(8);
        this.f11891gb.setVisibility(0);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = e.eb(adTemplate);
        this.mAdInfo = eb2;
        this.CX = aVar;
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

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    private void b(View view, boolean z10) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.CV).ao(view == this.CW ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            final /* synthetic */ boolean vU;

            public AnonymousClass2(boolean z102) {
                z10 = z102;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.CX != null) {
                    ActionBarAppLandscape.this.CX.O(z10);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
