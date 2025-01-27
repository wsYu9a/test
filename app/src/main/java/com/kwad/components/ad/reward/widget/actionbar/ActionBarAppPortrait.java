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
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public class ActionBarAppPortrait extends LinearLayout implements c {
    private AppScoreView AK;
    private TextProgressBar AL;
    private View AM;
    private a AP;
    private KsAppDownloadListener cE;
    private ImageView dJ;
    private TextView dK;
    private TextView dM;
    private TextView eE;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.aw(ActionBarAppPortrait.this.mAdInfo), 0);
            ActionBarAppPortrait.this.AM.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.aH(ActionBarAppPortrait.this.mAdTemplate), 0);
            ActionBarAppPortrait.this.AM.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.aw(ActionBarAppPortrait.this.mAdInfo), 0);
            ActionBarAppPortrait.this.AM.setVisibility(0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.T(ActionBarAppPortrait.this.mAdInfo), 0);
            ActionBarAppPortrait.this.AM.setVisibility(0);
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.bz(i2), i2);
            ActionBarAppPortrait.this.AM.setVisibility(8);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.by(i2), i2);
            ActionBarAppPortrait.this.AM.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait$2 */
    final class AnonymousClass2 implements a.b {
        final /* synthetic */ boolean tN;

        AnonymousClass2(boolean z) {
            z = z;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            if (ActionBarAppPortrait.this.AP != null) {
                ActionBarAppPortrait.this.AP.R(z);
            }
        }
    }

    public interface a {
        void R(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView();
    }

    private void b(View view, boolean z) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(view.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.AL).ap(view == this.AM ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            final /* synthetic */ boolean tN;

            AnonymousClass2(boolean z2) {
                z = z2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.AP != null) {
                    ActionBarAppPortrait.this.AP.R(z);
                }
            }
        }));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cE == null) {
            this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.aw(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.aH(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.aw(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.T(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.AM.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.bz(i2), i2);
                    ActionBarAppPortrait.this.AM.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    ActionBarAppPortrait.this.AL.f(com.kwad.sdk.core.response.a.a.by(i2), i2);
                    ActionBarAppPortrait.this.AM.setVisibility(8);
                }
            };
        }
        return this.cE;
    }

    private void initView() {
        k.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dK = (TextView) findViewById(R.id.ksad_app_title);
        this.eE = (TextView) findViewById(R.id.ksad_app_desc);
        this.AK = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dM = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.AL = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.kwai.a.a(getContext(), 16.0f));
        this.AL.setTextColor(-1);
        this.AM = findViewById(R.id.ksad_download_bar_cover);
    }

    private void kd() {
        String ar = com.kwad.sdk.core.response.a.a.ar(this.mAdInfo);
        boolean z = !TextUtils.isEmpty(ar);
        float as = com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
        boolean z2 = as >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.dK.getLayoutParams()).bottomMargin = com.kwad.sdk.c.kwai.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.AK.getLayoutParams()).bottomMargin = com.kwad.sdk.c.kwai.a.a(getContext(), 1.0f);
            this.dM.setText(ar);
            this.dM.setVisibility(0);
            this.AK.setVisibility(0);
            this.AK.setScore(as);
            this.eE.setVisibility(8);
            return;
        }
        if (z) {
            this.dM.setText(ar);
            this.dM.setVisibility(0);
            this.AK.setVisibility(8);
            this.eE.setVisibility(8);
            return;
        }
        if (z2) {
            this.dM.setVisibility(8);
            this.AK.setScore(as);
            this.AK.setVisibility(0);
            this.eE.setVisibility(8);
            return;
        }
        this.eE.setText(com.kwad.sdk.core.response.a.a.an(this.mAdInfo));
        this.dM.setVisibility(8);
        this.AK.setVisibility(8);
        this.eE.setVisibility(0);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.d.b.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = d.cb(adTemplate);
        this.mAdInfo = cb;
        this.AP = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.dJ, com.kwad.sdk.core.response.a.a.bM(cb), adTemplate, 12);
        this.dK.setText(com.kwad.sdk.core.response.a.a.bK(this.mAdInfo));
        kd();
        this.AL.f(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo), 0);
        com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.AM, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }
}
