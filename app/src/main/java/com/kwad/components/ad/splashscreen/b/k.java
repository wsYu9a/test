package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k extends i implements com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.a {
    private View CC;
    private KsRotateView CD;
    private TextView CE;
    private TextView CF;
    private com.kwad.sdk.core.f.c CG;
    private com.kwad.components.ad.splashscreen.d CH;
    private Runnable CI = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.k.3
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.CG.xD();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.b.k$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.CD.kT();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.k$2 */
    final class AnonymousClass2 implements h.a {
        final /* synthetic */ String CK;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // com.kwad.components.ad.splashscreen.h.a
        public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
            iVar.cz(str);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.k$3 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.CG.xD();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void ab(String str) {
        TextView textView = this.CF;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.kwad.sdk.core.f.a
    public final void ae(String str) {
        Runnable runnable;
        long j2;
        boolean rG = this.Cg.BH.rG();
        boolean mF = com.kwad.components.core.d.a.b.mF();
        if (!rG || mF) {
            runnable = this.CI;
            j2 = 1800;
        } else {
            this.CD.lv();
            com.kwad.components.ad.splashscreen.h hVar = this.Cg;
            if (hVar != null) {
                hVar.a(1, getContext(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.k.2
                    final /* synthetic */ String CK;

                    AnonymousClass2(String str2) {
                        str = str2;
                    }

                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                        iVar.cz(str);
                    }
                });
            }
            kW();
            runnable = this.CI;
            j2 = 2000;
        }
        bi.a(runnable, null, j2);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        this.CC = viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_rotate_root);
        this.CE = (TextView) findViewById(R.id.ksad_rotate_text);
        this.CF = (TextView) findViewById(R.id.ksad_rotate_action);
        this.CD = (KsRotateView) findViewById(R.id.ksad_rotate_view);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kP() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        getContext();
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        com.kwad.components.ad.splashscreen.d a2 = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, cb, hVar.mApkDownloadHelper, 1);
        this.CH = a2;
        TextView textView = this.CE;
        if (textView != null) {
            textView.setText(a2.getTitle());
        }
        TextView textView2 = this.CF;
        if (textView2 != null) {
            textView2.setText(this.CH.kq());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kQ() {
        View view = this.CC;
        if (view == null || this.Cg == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, (JSONObject) null);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kR() {
        AdMatrixInfo.RotateInfo by = com.kwad.sdk.core.response.a.b.by(this.Cg.mAdTemplate);
        com.kwad.sdk.core.f.c cVar = this.CG;
        if (cVar != null) {
            cVar.a(by);
            return;
        }
        com.kwad.sdk.core.f.c cVar2 = new com.kwad.sdk.core.f.c(by);
        this.CG = cVar2;
        cVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kS() {
        this.CG.aX(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kT() {
        this.CD.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.k.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                k.this.CD.kT();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.b.i
    protected final void kU() {
        if (com.kwad.components.ad.splashscreen.e.c.c(this.Cg)) {
            com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_rotate_action), -1, 60, -1, -1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kt() {
        com.kwad.sdk.core.f.c cVar = this.CG;
        if (cVar != null) {
            cVar.aY(getContext());
        }
    }

    @Override // com.kwad.sdk.core.f.a
    public final void la() {
        com.kwad.sdk.core.report.a.ax(this.Cg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("SplashRotatePresenter", "onUnbind");
        com.kwad.sdk.core.f.c cVar = this.CG;
        if (cVar != null) {
            cVar.aY(getContext());
        }
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar != null) {
            hVar.b(this);
        }
    }
}
