package com.kwad.components.ad.c;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.c.b;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: classes2.dex */
public final class h extends com.kwad.components.core.l.c<b> {
    private KsAdVideoPlayConfig bI;
    private List<AdTemplate> bJ;
    private KsBannerAd.BannerAdInteractionListener bK;

    /* renamed from: cc */
    private e f11408cc;
    private Context context;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.c.h$1 */
    public class AnonymousClass1 implements b.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.c.b.a
        public final void Y() {
            h.this.mPresenter.a(new com.kwad.components.ad.c.c.c(), true);
        }
    }

    public h(Context context, AdResultData adResultData, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context);
        this.context = context;
        this.mAdResultData = adResultData;
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        this.mAdTemplate = o10;
        this.mAdScene = o10.mAdScene;
        this.bJ = this.mAdResultData.getAdTemplateList();
        this.bI = ksAdVideoPlayConfig;
        py();
    }

    @Override // com.kwad.components.core.l.c
    /* renamed from: ai */
    public b ak() {
        e eVar = new e(this.mR, com.kwad.sdk.core.response.b.a.cH(this.mAdInfo));
        this.f11408cc = eVar;
        eVar.uE();
        b bVar = new b();
        bVar.a(this.mAdResultData);
        bVar.a(this.bK);
        bVar.mAdScene = this.mAdScene;
        bVar.bG = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        bVar.bL = b(this.mAdTemplate);
        bVar.bJ = this.bJ;
        bVar.mContext = this.context;
        bVar.bI = this.bI;
        bVar.a(new b.a() { // from class: com.kwad.components.ad.c.h.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.c.b.a
            public final void Y() {
                h.this.mPresenter.a(new com.kwad.components.ad.c.c.c(), true);
            }
        });
        return bVar;
    }

    private static StyleTemplate b(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dD(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k10 != null) {
            styleTemplate.templateId = k10.templateId;
            styleTemplate.templateMd5 = k10.templateMd5;
            styleTemplate.templateUrl = k10.templateUrl;
            styleTemplate.templateVersionCode = (int) k10.templateVersionCode;
        }
        return styleTemplate;
    }

    @Override // com.kwad.components.core.l.c
    public final boolean ah() {
        return true;
    }

    @Override // com.kwad.components.core.l.c
    public final void aj() {
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return R.layout.ksad_banner_base;
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        return a(getContext(), this.mAdTemplate);
    }

    public final void setBannerAdListener(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.bK = bannerAdInteractionListener;
    }

    private static Presenter a(Context context, AdTemplate adTemplate) {
        com.kwad.sdk.core.response.b.e.eb(adTemplate);
        Presenter presenter = new Presenter();
        if (b.a(adTemplate)) {
            presenter.a(new com.kwad.components.ad.c.d.a(context));
        } else {
            presenter.a(new com.kwad.components.ad.c.c.c());
        }
        return presenter;
    }
}
