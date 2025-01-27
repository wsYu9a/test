package com.kwad.components.core.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    private static volatile b VJ;

    /* renamed from: com.kwad.components.core.s.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass1(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.core.c.a nj2 = com.kwad.components.core.c.a.nj();
            if (nj2 != null) {
                nj2.r(com.kwad.sdk.core.response.b.e.el(adTemplate));
            }
        }
    }

    private b() {
    }

    @NonNull
    public static b sc() {
        if (VJ == null) {
            synchronized (b.class) {
                try {
                    if (VJ == null) {
                        VJ = new b();
                    }
                } finally {
                }
            }
        }
        return VJ;
    }

    public final boolean a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        boolean z10 = false;
        if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean b10 = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null && sceneImpl.adStyle == 10000) {
                z10 = true;
            }
            int i10 = adTemplate.adStyle;
            if (i10 == 3 || i10 == 2 || i10 == 13 || z10) {
                com.kwad.sdk.core.response.b.e.eb(adTemplate);
                if (b10 && com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class) != null) {
                    com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.b.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.core.s.b.1
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass1(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.c.a nj2 = com.kwad.components.core.c.a.nj();
                if (nj2 != null) {
                    nj2.r(com.kwad.sdk.core.response.b.e.el(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.nu().ao(adTemplate2);
        return b10;
    }
}
