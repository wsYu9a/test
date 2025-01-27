package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class a implements c {
    protected View Df;
    protected ImageView Dg;
    private com.kwad.components.ad.widget.tailframe.appbar.a Dh;
    private TailFrameBarH5View Di;
    private b Dj;
    private TextProgressBar Dk;
    private View Dl;
    private int Dm;

    /* renamed from: fb */
    private TextView f11896fb;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private g rO;

    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.a$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            a.this.Dh.D(a.this.mAdInfo);
            a.this.Dk.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            a.this.Dh.D(a.this.mAdInfo);
            a.this.Dk.e(com.kwad.sdk.core.response.b.a.cg(a.this.mAdTemplate), 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            a.this.Dh.D(a.this.mAdInfo);
            a.this.Dk.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            a.this.Dh.D(a.this.mAdInfo);
            a.this.Dk.e(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo), 0);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            a.this.Dh.D(a.this.mAdInfo);
            a.this.Dk.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            a.this.Dh.D(a.this.mAdInfo);
            a.this.Dk.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.widget.tailframe.a$2 */
    public class AnonymousClass2 implements a.b {
        final /* synthetic */ boolean vU;

        public AnonymousClass2(boolean z10) {
            r2 = z10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            if (a.this.Dj != null) {
                a.this.Dj.O(r2);
            }
        }
    }

    public a(int i10) {
        this.Dm = i10;
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Dh.D(a.this.mAdInfo);
                a.this.Dk.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Dh.D(a.this.mAdInfo);
                a.this.Dk.e(com.kwad.sdk.core.response.b.a.cg(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.Dh.D(a.this.mAdInfo);
                a.this.Dk.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Dh.D(a.this.mAdInfo);
                a.this.Dk.e(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                a.this.Dh.D(a.this.mAdInfo);
                a.this.Dk.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                a.this.Dh.D(a.this.mAdInfo);
                a.this.Dk.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
            }
        });
    }

    private void kD() {
        this.Df.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void kF() {
        if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo) && !e.J(this.mAdTemplate)) {
            this.Di.f(this.mAdTemplate);
            TextView h5OpenBtn = this.Di.getH5OpenBtn();
            this.f11896fb = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.Di.setVisibility(0);
            new f(this.f11896fb, this);
            return;
        }
        this.Dh.f(this.mAdTemplate);
        this.Dh.setVisibility(0);
        this.Dk = this.Dh.getTextProgressBar();
        if (!e.J(this.mAdTemplate)) {
            this.Dk.setClickable(true);
            new f(this.Dk, this);
            bindDownloadListener();
        } else {
            View btnInstallContainer = this.Dh.getBtnInstallContainer();
            this.Dl = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new f(this.Dl, this);
        }
    }

    public void A(Context context) {
        View a10 = m.a(context, this.Dm, null, false);
        this.Df = a10;
        this.Dg = (ImageView) a10.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.Df.findViewById(R.id.ksad_video_tf_logo);
        this.Dh = (com.kwad.components.ad.widget.tailframe.appbar.a) this.Df.findViewById(R.id.ksad_video_app_tail_frame);
        this.Di = (TailFrameBarH5View) this.Df.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Dh;
        if (aVar != null) {
            aVar.kH();
            this.Dh.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.Di;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kH();
            this.Di.setVisibility(8);
        }
        kD();
    }

    public final void g(boolean z10, boolean z11) {
        this.Di.h(z10, z11);
    }

    public final View kE() {
        return this.Df;
    }

    public final void kl() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Dh;
        if (aVar != null) {
            aVar.kH();
        }
        TailFrameBarH5View tailFrameBarH5View = this.Di;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kH();
        }
    }

    public final void setCallerContext(g gVar) {
        this.rO = gVar;
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eb(adTemplate);
        this.mReportExtData = jSONObject;
        this.Dj = bVar;
        this.mLogoView.aK(this.mAdTemplate);
        kF();
        this.Df.setClickable(true);
        new f(this.Df, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dQ(this.mAdTemplate)) {
            b(view, false);
        }
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
            boolean r0 = com.kwad.sdk.core.response.b.e.J(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = 1
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.g r0 = r5.rO
            android.view.View r3 = r5.Df
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.Dl
            if (r6 != r4) goto L1d
            r1 = 1
        L1d:
            r0.a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.aF(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.Dk
            if (r6 != r0) goto L34
        L2d:
            r1 = 1
            goto L34
        L2f:
            android.widget.TextView r0 = r5.f11896fb
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.e.d.a$a r0 = new com.kwad.components.core.e.d.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r0 = r0.au(r3)
            com.kwad.components.core.e.d.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r0 = r0.b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = 1
            goto L4f
        L4e:
            r4 = 0
        L4f:
            com.kwad.components.core.e.d.a$a r0 = r0.an(r4)
            com.kwad.components.core.e.d.a$a r0 = r0.am(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.Dk
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            com.kwad.components.core.e.d.a$a r6 = r0.ap(r2)
            com.kwad.components.core.e.d.a$a r6 = r6.ao(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.e.d.a$a r6 = r6.a(r0)
            com.kwad.components.core.e.d.a.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.b(android.view.View, boolean):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
