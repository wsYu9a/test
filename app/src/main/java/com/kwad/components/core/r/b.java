package com.kwad.components.core.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {
    private static volatile b PQ;

    /* renamed from: com.kwad.components.core.r.b$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ AdTemplate eI;

        AnonymousClass1(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.core.b.a lW = com.kwad.components.core.b.a.lW();
            if (lW != null) {
                lW.m(com.kwad.sdk.core.response.a.d.cl(adTemplate));
            }
        }
    }

    private b() {
    }

    @NonNull
    public static b pK() {
        if (PQ == null) {
            synchronized (b.class) {
                if (PQ == null) {
                    PQ = new b();
                }
            }
        }
        return PQ;
    }

    public final void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.report.i iVar) {
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.b.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        com.kwad.sdk.core.report.a.b(adTemplate, (JSONObject) null, iVar);
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.r.b.1
            final /* synthetic */ AdTemplate eI;

            AnonymousClass1(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.b.a lW = com.kwad.components.core.b.a.lW();
                if (lW != null) {
                    lW.m(com.kwad.sdk.core.response.a.d.cl(adTemplate));
                }
            }
        });
        com.kwad.components.core.b.f.mk().F(adTemplate2);
    }
}
