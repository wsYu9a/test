package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class a implements c {
    protected View AV;
    protected ImageView AW;
    private com.kwad.components.ad.widget.tailframe.appbar.a AX;
    private TailFrameBarH5View AY;
    private b AZ;
    private TextProgressBar Ba;
    private View Bb;
    private int Bc;
    private TextView dR;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private j qt;

    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.a$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            a.this.AX.x(a.this.mAdInfo);
            a.this.Ba.f(com.kwad.sdk.core.response.a.a.aw(a.this.mAdInfo), 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            a.this.AX.x(a.this.mAdInfo);
            a.this.Ba.f(com.kwad.sdk.core.response.a.a.aH(a.this.mAdTemplate), 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            a.this.AX.x(a.this.mAdInfo);
            a.this.Ba.f(com.kwad.sdk.core.response.a.a.aw(a.this.mAdInfo), 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            a.this.AX.x(a.this.mAdInfo);
            a.this.Ba.f(com.kwad.sdk.core.response.a.a.T(a.this.mAdInfo), 0);
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            a.this.AX.x(a.this.mAdInfo);
            a.this.Ba.f(com.kwad.sdk.core.response.a.a.bz(i2), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            a.this.AX.x(a.this.mAdInfo);
            a.this.Ba.f(com.kwad.sdk.core.response.a.a.by(i2), i2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.a$2 */
    final class AnonymousClass2 implements a.b {
        final /* synthetic */ boolean tN;

        AnonymousClass2(boolean z) {
            r2 = z;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            if (a.this.AZ != null) {
                a.this.AZ.R(r2);
            }
        }
    }

    public a(int i2) {
        this.Bc = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.a.d.p(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = 1
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.j r0 = r5.qt
            android.view.View r3 = r5.AV
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.Bb
            if (r6 != r4) goto L1d
            r1 = 1
        L1d:
            r0.a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.a.a.ax(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.Ba
            if (r6 != r0) goto L34
        L2d:
            r1 = 1
            goto L34
        L2f:
            android.widget.TextView r0 = r5.dR
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.d.b.a$a r0 = new com.kwad.components.core.d.b.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.d.b.a$a r0 = r0.I(r3)
            com.kwad.components.core.d.b.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.d.b.a$a r0 = r0.b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = 1
            goto L4f
        L4e:
            r4 = 0
        L4f:
            com.kwad.components.core.d.b.a$a r0 = r0.ao(r4)
            com.kwad.components.core.d.b.a$a r0 = r0.an(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.Ba
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            com.kwad.components.core.d.b.a$a r6 = r0.ao(r2)
            com.kwad.components.core.d.b.a$a r6 = r6.ap(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.d.b.a$a r6 = r6.a(r0)
            com.kwad.components.core.d.b.a.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.b(android.view.View, boolean):void");
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.aw(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.aH(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.aw(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.T(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.bz(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                a.this.AX.x(a.this.mAdInfo);
                a.this.Ba.f(com.kwad.sdk.core.response.a.a.by(i2), i2);
            }
        });
    }

    private void ke() {
        this.AV.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void kg() {
        if (!com.kwad.sdk.core.response.a.a.ax(this.mAdInfo) && !d.p(this.mAdTemplate)) {
            this.AY.bindView(this.mAdTemplate);
            TextView h5OpenBtn = this.AY.getH5OpenBtn();
            this.dR = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.AY.setVisibility(0);
            new f(this.dR, this);
            return;
        }
        this.AX.bindView(this.mAdTemplate);
        this.AX.setVisibility(0);
        this.Ba = this.AX.getTextProgressBar();
        if (!d.p(this.mAdTemplate)) {
            this.Ba.setClickable(true);
            new f(this.Ba, this);
            bindDownloadListener();
        } else {
            View btnInstallContainer = this.AX.getBtnInstallContainer();
            this.Bb = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new f(this.Bb, this);
        }
    }

    public void D(Context context) {
        View a2 = k.a(context, this.Bc, null, false);
        this.AV = a2;
        this.AW = (ImageView) a2.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.AV.findViewById(R.id.ksad_video_tf_logo);
        this.AX = (com.kwad.components.ad.widget.tailframe.appbar.a) this.AV.findViewById(R.id.ksad_video_app_tail_frame);
        this.AY = (TailFrameBarH5View) this.AV.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.mReportExtData = jSONObject;
        this.AZ = bVar;
        this.mLogoView.S(this.mAdTemplate);
        kg();
        this.AV.setClickable(true);
        new f(this.AV, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void d(boolean z, boolean z2) {
        this.AY.e(z, z2);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.AX;
        if (aVar != null) {
            aVar.ki();
            this.AX.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.AY;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.ki();
            this.AY.setVisibility(8);
        }
        ke();
    }

    public final void jJ() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.AX;
        if (aVar != null) {
            aVar.ki();
        }
        TailFrameBarH5View tailFrameBarH5View = this.AY;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.ki();
        }
    }

    public final View kf() {
        return this.AV;
    }

    public final void setCallerContext(j jVar) {
        this.qt = jVar;
    }
}
