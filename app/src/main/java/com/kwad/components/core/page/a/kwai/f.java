package com.kwad.components.core.page.a.kwai;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import java.util.List;

/* loaded from: classes2.dex */
public final class f extends com.kwad.components.core.page.a.kwai.a {
    private boolean Md;
    private com.kwad.components.core.a.a mTitleBarHelper;

    /* renamed from: com.kwad.components.core.page.a.kwai.f$1 */
    final class AnonymousClass1 implements a.InterfaceC0162a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.a.a.InterfaceC0162a
        public final void t(View view) {
            f.this.w(view);
        }

        @Override // com.kwad.components.core.a.a.InterfaceC0162a
        public final void u(View view) {
            f.this.x(view);
        }
    }

    /* renamed from: com.kwad.components.core.page.a.kwai.f$2 */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.page.a.kwai.f.a
        public final void az(int i2) {
            f.this.mTitleBarHelper.gK().setVisibility(i2 == 1 ? 0 : 8);
        }
    }

    public interface a {
        void az(int i2);
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.LG.mPageTitle)) {
            return this.LG.mPageTitle;
        }
        List<AdInfo> list = this.LG.mAdTemplate.adInfoList;
        return (list == null || list.size() <= 0 || this.LG.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bK(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate));
    }

    private boolean ou() {
        return TextUtils.isEmpty(this.LG.mPageTitle);
    }

    private void ov() {
        com.kwad.components.core.a.a aVar = new com.kwad.components.core.a.a(this.LG.gv);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.a.b(getTitle()));
        this.mTitleBarHelper.am(ou());
        this.mTitleBarHelper.a(new a.InterfaceC0162a() { // from class: com.kwad.components.core.page.a.kwai.f.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0162a
            public final void t(View view) {
                f.this.w(view);
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0162a
            public final void u(View view) {
                f.this.x(view);
            }
        });
        ViewGroup gK = this.mTitleBarHelper.gK();
        AdTemplate adTemplate = this.LG.mAdTemplate;
        int i2 = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.a.b.cJ(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            i2 = 8;
        }
        gK.setVisibility(i2);
        this.LG.a(new a() { // from class: com.kwad.components.core.page.a.kwai.f.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.page.a.kwai.f.a
            public final void az(int i22) {
                f.this.mTitleBarHelper.gK().setVisibility(i22 == 1 ? 0 : 8);
            }
        });
    }

    public void w(View view) {
        KsAdWebView ksAdWebView = this.LG.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            com.kwad.components.core.page.kwai.a aVar = this.LG.LH;
            if (aVar != null) {
                aVar.dK();
                return;
            }
            return;
        }
        this.LG.mAdWebView.goBack();
        if (this.Md) {
            com.kwad.sdk.core.report.a.aw(this.LG.mAdTemplate);
        }
    }

    public void x(View view) {
        KsAdWebView ksAdWebView = this.LG.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            com.kwad.components.core.page.kwai.a aVar = this.LG.LH;
            if (aVar != null) {
                aVar.dL();
                return;
            }
            return;
        }
        this.LG.mAdWebView.goBack();
        if (this.Md) {
            com.kwad.sdk.core.report.a.aw(this.LG.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        b bVar = this.LG;
        this.Md = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(bVar.mAdTemplate)));
        ov();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
