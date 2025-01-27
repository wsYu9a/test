package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: com.kwad.components.ad.reward.j.b$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a<AdTrackLog> {
        final /* synthetic */ Context hB;
        final /* synthetic */ int yD;

        public AnonymousClass1(Context context, int i10) {
            context = context;
            i10 = i10;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: a */
        public void accept(AdTrackLog adTrackLog) {
            adTrackLog.rewardDetailStatusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            adTrackLog.rewardDetailCallPositionY = i10;
        }
    }

    public static void a(boolean z10, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        boolean a10 = com.kwad.components.core.s.b.sc().a(adTemplate, jSONObject, bVar);
        if (z10 && a10) {
            c.e(e.dV(adTemplate) == 2, adTemplate);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.b(adTemplate, str, str2, null);
        com.kwad.sdk.core.adlog.c.a(adTemplate, bVar, jSONObject);
    }

    public static void a(Context context, AdTemplate adTemplate, String str, int i10, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.b cN = new com.kwad.sdk.core.adlog.c.b().cN(18);
        cN.b(adTemplate, str, null, new com.kwad.sdk.f.a<AdTrackLog>() { // from class: com.kwad.components.ad.reward.j.b.1
            final /* synthetic */ Context hB;
            final /* synthetic */ int yD;

            public AnonymousClass1(Context context2, int i102) {
                context = context2;
                i10 = i102;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: a */
            public void accept(AdTrackLog adTrackLog) {
                adTrackLog.rewardDetailStatusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
                adTrackLog.rewardDetailCallPositionY = i10;
            }
        });
        com.kwad.sdk.core.adlog.c.d(adTemplate, jSONObject, cN);
    }
}
