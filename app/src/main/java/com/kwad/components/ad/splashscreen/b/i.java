package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public abstract class i extends e {
    private static long ka = 400;
    private com.kwad.components.ad.splashscreen.e.a Cv;
    private Vibrator eg;

    /* renamed from: com.kwad.components.ad.splashscreen.b.i$1 */
    final class AnonymousClass1 extends com.kwad.components.ad.splashscreen.e.a {
        AnonymousClass1(Context context, AdTemplate adTemplate) {
            super(context, adTemplate);
        }

        @Override // com.kwad.components.ad.splashscreen.e.a
        @SuppressLint({"SetTextI18n"})
        public final void ac(String str) {
            i.this.ab(str);
        }
    }

    private void kV() {
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Cv;
            if (aVar == null) {
                this.Cv = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.i.1
                    AnonymousClass1(Context context, AdTemplate adTemplate) {
                        super(context, adTemplate);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void ac(String str) {
                        i.this.ab(str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.d.b.c cVar = this.Cg.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Cv);
            }
        }
    }

    protected abstract void ab(String str);

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        if (this.Cg == null) {
            return;
        }
        kU();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        kR();
        kP();
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            kV();
        }
        kQ();
        kS();
        kT();
    }

    protected abstract void initView();

    protected abstract void kP();

    protected abstract void kQ();

    protected abstract void kR();

    protected abstract void kS();

    protected abstract void kT();

    protected abstract void kU();

    protected final void kW() {
        Context context = getContext();
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService("vibrator");
        }
        bi.a(getContext(), this.eg);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        bi.b(getContext(), this.eg);
    }
}
