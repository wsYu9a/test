package com.kwad.sdk.core.adlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.x;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: com.kwad.sdk.core.adlog.b$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a aVar = new a(com.kwad.sdk.core.adlog.c.a.this);
            b.a(aVar.getUrl(), aVar.getBody(), com.kwad.sdk.core.adlog.c.a.this, null);
        }
    }

    /* renamed from: com.kwad.sdk.core.adlog.b$2 */
    public class AnonymousClass2 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.core.adlog.a.a CJ = com.kwad.sdk.core.adlog.a.b.CG().CJ();
            if (CJ != null) {
                JSONObject jSONObject = CJ.asR;
                x.putValue(jSONObject, DBDefinition.RETRY_COUNT, CJ.retryCount);
                x.putValue(jSONObject, "cacheType", 1);
                b.a(CJ.url, jSONObject, CJ.asS, CJ);
            }
        }
    }

    public static void CD() {
        GlobalThreadPools.Hp().execute(new bd() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a CJ = com.kwad.sdk.core.adlog.a.b.CG().CJ();
                if (CJ != null) {
                    JSONObject jSONObject = CJ.asR;
                    x.putValue(jSONObject, DBDefinition.RETRY_COUNT, CJ.retryCount);
                    x.putValue(jSONObject, "cacheType", 1);
                    b.a(CJ.url, jSONObject, CJ.asS, CJ);
                }
            }
        });
    }

    public static void a(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.Hp().execute(new bd() { // from class: com.kwad.sdk.core.adlog.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a aVar2 = new a(com.kwad.sdk.core.adlog.c.a.this);
                b.a(aVar2.getUrl(), aVar2.getBody(), com.kwad.sdk.core.adlog.c.a.this, null);
            }
        });
    }

    public static void a(String str, JSONObject jSONObject, @NonNull com.kwad.sdk.core.adlog.c.a aVar, @Nullable com.kwad.sdk.core.adlog.a.a aVar2) {
        AdTemplate adTemplate = aVar.adTemplate;
        int i10 = aVar.asm;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate, i10, aVar2);
            if (!al.isNetworkConnected(ServiceProvider.getContext())) {
                com.kwad.sdk.core.d.c.w("AdLogRequestManager", "no network while report log");
                com.kwad.sdk.core.adlog.b.c.a(adTemplate, i10, str, 100004, "no network", aVar2);
                com.kwad.sdk.core.adlog.a.b.CG().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                return;
            }
            if (bt.ho(str)) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i10, str, 100001, "", aVar2);
                return;
            }
            com.kwad.sdk.core.network.c doPost = g.zc().doPost(str, (Map<String, String>) null, jSONObject);
            AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
            adLogRequestResult.parseResult(doPost.azu);
            int i11 = doPost.code;
            if (i11 != 200) {
                int cc2 = d.cc(i11);
                String str2 = doPost.azu;
                com.kwad.sdk.core.adlog.b.c.d(adTemplate, i10, str, cc2, str2, aVar2);
                com.kwad.sdk.core.adlog.a.b.CG().a(aVar2, str, jSONObject, aVar, cc2, str2);
                return;
            }
            if (adLogRequestResult.isResultOk()) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i10, aVar2);
                b(aVar);
                com.kwad.sdk.core.adlog.a.b.CG().CH();
                return;
            }
            if (adLogRequestResult.isCheatingFlow()) {
                adTemplate.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                com.kwad.sdk.core.adlog.b.c.c(adTemplate, i10, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                return;
            }
            int i12 = adLogRequestResult.result;
            String str3 = adLogRequestResult.errorMsg;
            com.kwad.sdk.core.d.c.w("AdLogRequestManager", "request fail code:" + i12 + ", errorMsg:" + str3 + ", url=" + str);
            com.kwad.sdk.core.adlog.b.c.c(adTemplate, i10, str, i12, str3, aVar2);
            com.kwad.sdk.core.adlog.a.b.CG().a(aVar2, str, jSONObject, aVar, i12, str3);
        } catch (Throwable th2) {
            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i10, "", 100000, bt.t(th2), aVar2);
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void b(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.d(aVar);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
