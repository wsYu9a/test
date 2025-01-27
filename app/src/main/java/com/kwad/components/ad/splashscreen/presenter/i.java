package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public abstract class i extends e implements com.kwad.sdk.core.h.c {
    private static long ms = 400;
    private com.kwad.components.ad.splashscreen.e.a EZ;
    private Vibrator fx;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.i$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.splashscreen.e.a {
        public AnonymousClass1(Context context, AdTemplate adTemplate) {
            super(adTemplate);
        }

        @Override // com.kwad.components.ad.splashscreen.e.a
        @SuppressLint({"SetTextI18n"})
        public final void k(int i10, String str) {
            i.this.j(i10, str);
        }
    }

    private void lG() {
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.EZ;
            if (aVar == null) {
                this.EZ = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.EJ.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    public AnonymousClass1(Context context, AdTemplate adTemplate) {
                        super(adTemplate);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void k(int i10, String str) {
                        i.this.j(i10, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.EJ.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.EZ);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar == null) {
            return;
        }
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(hVar.mAdTemplate);
        lC();
        lA();
        if (com.kwad.sdk.core.response.b.a.aF(eb2)) {
            lG();
        }
        lB();
        lF();
        this.EJ.DV.a(this);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        if (this.EJ.DY) {
            return;
        }
        lD();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        lE();
    }

    public abstract void initView();

    public abstract void j(int i10, String str);

    public abstract void lA();

    public abstract void lB();

    public abstract void lC();

    public abstract void lD();

    public abstract void lE();

    public abstract void lF();

    public final void lH() {
        Context context = getContext();
        if (context != null) {
            this.fx = (Vibrator) context.getSystemService("vibrator");
        }
        bt.a(getContext(), this.fx);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.EJ.DV.b(this);
        lE();
        bt.b(getContext(), this.fx);
    }
}
