package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: classes3.dex */
public final class f extends com.kwad.components.core.page.c.a.a {
    private boolean Rj;
    private com.kwad.components.core.b.a mTitleBarHelper;

    /* renamed from: com.kwad.components.core.page.c.a.f$1 */
    public class AnonymousClass1 implements a.InterfaceC0416a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.b.a.InterfaceC0416a
        public final void v(View view) {
            f.this.y(view);
        }

        @Override // com.kwad.components.core.b.a.InterfaceC0416a
        public final void w(View view) {
            f.this.z(view);
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a.f$2 */
    public class AnonymousClass2 implements a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.page.c.a.f.a
        public final void aC(int i10) {
            f.this.mTitleBarHelper.ha().setVisibility(i10 == 1 ? 0 : 8);
        }
    }

    public interface a {
        void aC(int i10);
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.QL.mPageTitle)) {
            return this.QL.mPageTitle;
        }
        List<AdInfo> list = this.QL.mAdTemplate.adInfoList;
        return (list == null || list.size() <= 0 || this.QL.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.b.a.cj(com.kwad.sdk.core.response.b.e.eb(this.QL.mAdTemplate));
    }

    private void qs() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.QL.f8if);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.ai(true);
        this.mTitleBarHelper.a(new a.InterfaceC0416a() { // from class: com.kwad.components.core.page.c.a.f.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0416a
            public final void v(View view) {
                f.this.y(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0416a
            public final void w(View view) {
                f.this.z(view);
            }
        });
        ViewGroup ha2 = this.mTitleBarHelper.ha();
        AdTemplate adTemplate = this.QL.mAdTemplate;
        int i10 = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.b.a.ch(adTemplate) && !com.kwad.sdk.core.response.b.b.dz(com.kwad.sdk.core.response.b.e.eb(this.QL.mAdTemplate))) {
            i10 = 8;
        }
        ha2.setVisibility(i10);
        this.QL.a(new a() { // from class: com.kwad.components.core.page.c.a.f.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.page.c.a.f.a
            public final void aC(int i102) {
                f.this.mTitleBarHelper.ha().setVisibility(i102 == 1 ? 0 : 8);
            }
        });
    }

    public void y(View view) {
        b bVar = this.QL;
        if (bVar != null) {
            bVar.a(this.Rj, view);
        }
    }

    public void z(View view) {
        com.kwad.components.core.page.a.a aVar = this.QL.QM;
        if (aVar != null) {
            aVar.pT();
        }
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        b bVar = this.QL;
        this.Rj = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.eb(bVar.mAdTemplate)));
        qs();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
