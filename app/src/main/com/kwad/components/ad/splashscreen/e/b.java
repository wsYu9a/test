package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.f;

/* loaded from: classes2.dex */
public final class b implements com.kwad.sdk.widget.c {
    private a EZ;
    private ViewStub Hj;
    private ViewGroup Hk;
    private View Hl;
    private TextView Hm;
    private boolean Hn;

    @Nullable
    private e Ho;
    private f Hp;

    /* renamed from: if */
    @NonNull
    private ViewGroup f7if;

    @Nullable
    private AdInfo mAdInfo;

    @Nullable
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.ad.splashscreen.e.b$1 */
    public class AnonymousClass1 extends a {
        public AnonymousClass1(Context context, AdTemplate adTemplate) {
            super(adTemplate);
        }

        @Override // com.kwad.components.ad.splashscreen.e.a
        public final void k(int i10, String str) {
            b.this.X(str);
        }
    }

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, boolean z10, com.kwad.components.core.e.d.c cVar) {
        this.f7if = viewGroup;
        this.Hj = viewStub;
        this.mApkDownloadHelper = cVar;
        this.Hn = z10;
    }

    public void X(String str) {
        TextView textView = this.Hm;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.Hl = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.Hm = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.Hp = new f(this.Hl.getContext(), this.Hl, this);
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void j(boolean z10, boolean z11) {
        e eVar = this.Ho;
        if (eVar != null) {
            eVar.i(z10, z11);
        }
    }

    public final void al(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.EZ;
        if (aVar2 == null) {
            this.EZ = new a(this.f7if.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.e.b.1
                public AnonymousClass1(Context context, AdTemplate adTemplate2) {
                    super(adTemplate2);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void k(int i10, String str) {
                    b.this.X(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        }
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.EZ) == null) {
            return;
        }
        cVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (this.Hn) {
            j(false, view.equals(this.Hl));
        }
    }

    public final void lN() {
        com.kwad.sdk.core.d.c.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.Hj);
        if (this.Hk == null) {
            ViewStub viewStub = this.Hj;
            if (viewStub == null || viewStub.getParent() == null) {
                this.Hk = (ViewGroup) this.f7if.findViewById(R.id.ksad_splash_actionbar_native_root);
            } else {
                this.Hk = (ViewGroup) this.Hj.inflate();
            }
            g(this.Hk);
        }
        ViewGroup viewGroup = this.Hk;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.EZ) == null) {
            return;
        }
        cVar.c(aVar);
    }

    public final void a(@Nullable e eVar) {
        this.Ho = eVar;
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        X(dVar.kM());
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        j(true, view.equals(this.Hl));
    }
}
