package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class l extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.a {
    private View Fc;
    private KsRotateView Fd;
    private TextView Fe;
    private TextView Ff;
    private com.kwad.components.ad.splashscreen.d Fg;
    private com.kwad.sdk.core.f.c fw;
    private long mStartTime;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.l$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            l.this.Fd.lF();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.l$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.ad.splashscreen.h hVar = l.this.EJ;
            if (hVar != null) {
                hVar.Ek = SystemClock.elapsedRealtime() - l.this.mStartTime;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.l$3 */
    public class AnonymousClass3 implements h.a {
        final /* synthetic */ String Fi;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // com.kwad.components.ad.splashscreen.h.a
        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
            bVar.dr(str);
        }
    }

    @Nullable
    private Context lI() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            context = null;
        }
        return (context != null || (view = this.Fc) == null) ? context : view.getContext();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void X(int i10) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        View rootView = getRootView();
        if (rootView == null) {
            return;
        }
        rootView.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.ad.splashscreen.h hVar = l.this.EJ;
                if (hVar != null) {
                    hVar.Ek = SystemClock.elapsedRealtime() - l.this.mStartTime;
                }
            }
        });
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.sdk.core.f.a
    public final void bx() {
        com.kwad.sdk.core.adlog.c.bV(this.EJ.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        if (viewStub != null) {
            this.Fc = viewStub.inflate();
        } else {
            this.Fc = findViewById(R.id.ksad_rotate_root);
        }
        this.Fe = (TextView) findViewById(R.id.ksad_rotate_text);
        this.Ff = (TextView) findViewById(R.id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.ksad_rotate_view);
        this.Fd = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void j(int i10, String str) {
        TextView textView = this.Ff;
        if (textView != null) {
            if (i10 == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kS() {
        com.kwad.sdk.core.f.c cVar = this.fw;
        if (cVar != null) {
            cVar.bA(lI());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lA() {
        AdTemplate adTemplate = this.EJ.mAdTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.Fg = com.kwad.components.ad.splashscreen.d.a(adTemplate, eb2, this.EJ.mApkDownloadHelper, 1);
        TextView textView = this.Fe;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dB(eb2));
        }
        TextView textView2 = this.Ff;
        if (textView2 != null) {
            textView2.setText("或点击" + this.Fg.kM());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lB() {
        View view = this.Fc;
        if (view == null || this.EJ == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.EJ.mAdTemplate, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.d.a.uf().aX(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lC() {
        AdMatrixInfo.RotateInfo dc2 = com.kwad.sdk.core.response.b.b.dc(this.EJ.mAdTemplate);
        com.kwad.sdk.core.f.c cVar = this.fw;
        if (cVar != null) {
            cVar.b(dc2);
            return;
        }
        com.kwad.sdk.core.f.c cVar2 = new com.kwad.sdk.core.f.c(dc2);
        this.fw = cVar2;
        cVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lD() {
        com.kwad.sdk.core.f.c cVar = this.fw;
        if (cVar != null) {
            cVar.bz(lI());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lE() {
        com.kwad.sdk.core.f.c cVar = this.fw;
        if (cVar != null) {
            cVar.bA(lI());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lF() {
        KsRotateView ksRotateView = this.Fd;
        if (ksRotateView == null) {
            return;
        }
        ksRotateView.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.l.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                l.this.Fd.lF();
            }
        });
    }

    @Override // com.kwad.sdk.core.f.a
    public final void o(String str) {
        boolean uH = this.EJ.DV.uH();
        boolean of2 = com.kwad.components.core.e.c.b.of();
        if (!uH || of2) {
            return;
        }
        this.Fd.mK();
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar != null) {
            hVar.a(1, lI(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.3
                final /* synthetic */ String Fi;

                public AnonymousClass3(String str2) {
                    str = str2;
                }

                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.dr(str);
                }
            });
        }
        lH();
        lE();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.EJ.c(1, lI(), 162, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotatePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar != null) {
            hVar.b(this);
        }
    }
}
