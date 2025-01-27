package com.kwad.components.ad.g.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class f extends com.kwad.components.ad.g.a.a implements View.OnClickListener, View.OnTouchListener {
    private ImageView eT;
    private TextView eU;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private ViewGroup ot;
    private TextView ou;
    private MotionEvent ov;
    private KsAppDownloadListener ow = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.g.b.f.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.cg(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.ac(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
        }
    };

    /* renamed from: com.kwad.components.ad.g.b.f$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            try {
                f.this.eR();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                com.kwad.components.core.d.a.reportSdkCaughtException(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.b.f$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.cg(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.ou.setText(com.kwad.sdk.core.response.b.a.ac(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
        }
    }

    /* renamed from: com.kwad.components.ad.g.b.f$3 */
    public class AnonymousClass3 implements a.b {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.adlog.c.a(f.this.mAdTemplate, 2, f.this.f11530oe.nZ.getTouchCoords());
        }
    }

    /* renamed from: com.kwad.components.ad.g.b.f$4 */
    public class AnonymousClass4 implements a.b {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.adlog.c.a(f.this.f11530oe.mAdTemplate, 153, f.this.f11530oe.nZ.getTouchCoords());
        }
    }

    private void H(int i10) {
        com.kwad.components.ad.g.c.a aVar;
        a.C0427a b10 = new a.C0427a(this.ot.getContext()).au(this.mAdTemplate).ao(i10).b(this.mApkDownloadHelper);
        com.kwad.components.ad.g.a.b bVar = this.f11530oe;
        com.kwad.components.core.e.d.a.a(b10.v((bVar == null || (aVar = bVar.f11531of) == null) ? 0L : aVar.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.g.b.f.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.mAdTemplate, 2, f.this.f11530oe.nZ.getTouchCoords());
            }
        }));
    }

    public void eR() {
        KSImageLoader.loadAppIcon(this.eT, com.kwad.sdk.core.response.b.a.cm(this.mAdInfo), this.mAdTemplate, 12);
        this.eU.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.ou.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.ow);
        }
        this.ot.setOnClickListener(this);
        this.ot.setOnTouchListener(this);
        this.ot.setVisibility(0);
    }

    private void eS() {
        com.kwad.components.core.e.d.a.a(new a.C0427a(this.ot.getContext()).au(this.f11530oe.mAdTemplate).b(this.f11530oe.mApkDownloadHelper).v(this.f11530oe.f11531of.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.g.b.f.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.f11530oe.mAdTemplate, 153, f.this.f11530oe.nZ.getTouchCoords());
            }
        }));
    }

    private void m(View view) {
        if (view == this.ot) {
            eS();
            notifyAdClick();
        }
    }

    private void notifyAdClick() {
        this.f11530oe.nN.l(this.ot);
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdTemplate adTemplate = this.f11530oe.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.mApkDownloadHelper = this.f11530oe.mApkDownloadHelper;
        AnonymousClass1 anonymousClass1 = new l() { // from class: com.kwad.components.ad.g.b.f.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                try {
                    f.this.eR();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    com.kwad.components.core.d.a.reportSdkCaughtException(th2);
                }
            }
        };
        this.mVideoPlayStateListener = anonymousClass1;
        this.f11530oe.f11531of.b((com.kwad.components.core.video.k) anonymousClass1);
        this.ot.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f11530oe.nL) {
            if (view == this.ot) {
                H(2);
                notifyAdClick();
            } else if (view == this.ou) {
                H(1);
                notifyAdClick();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ot = (ViewGroup) findViewById(R.id.ksad_video_complete_app_container);
        this.eT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.eU = (TextView) findViewById(R.id.ksad_app_name);
        this.ou = (TextView) findViewById(R.id.ksad_app_download);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action == 0) {
            this.ov = MotionEvent.obtain(motionEvent);
        } else if (action == 1 || action == 3) {
            if (this.f11530oe.nK && (motionEvent2 = this.ov) != null && com.kwad.sdk.utils.b.a(motionEvent2, motionEvent, this.mAdTemplate)) {
                m(view);
                z10 = true;
            }
            this.ov = null;
        }
        return z10;
    }

    @Override // com.kwad.components.ad.g.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.ow);
        }
    }
}
