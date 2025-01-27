package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class an implements com.kwad.sdk.core.webview.c.a {
    private List<c> mHolders = new ArrayList();

    public static class a extends com.kwad.sdk.core.download.a.a {
        private c aar;

        public a(c cVar) {
            this.aar = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            an.a(this.aar, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            an.a(this.aar, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            an.a(this.aar, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            an.a(this.aar, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            an.a(this.aar, 3, (i10 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            an.a(this.aar, 2, (i10 * 1.0f) / 100.0f);
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
    }

    public static class c {
        private com.kwad.components.core.e.d.c aas;
        private a aat;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.c.c oN;

        public c(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
            this.aas = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.e.d.c cVar = this.aas;
            if (cVar == null || (aVar = this.aat) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long getCreativeId() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.b.e.el(adTemplate);
        }

        public final void a(a aVar) {
            this.aas.b(aVar);
            this.aat = aVar;
        }
    }

    public an(List<AdTemplate> list, List<com.kwad.components.core.e.d.c> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mHolders.add(new c(list2.get(i10), list.get(i10)));
        }
    }

    private c L(long j10) {
        if (j10 == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.getCreativeId() == j10) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c L = L(bVar.creativeId);
                if (L != null) {
                    L.oN = cVar;
                    L.a(new a(L));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        Iterator<c> it = this.mHolders.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    public static void a(c cVar, int i10, float f10) {
        if (cVar == null || cVar.oN == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.oN + f10);
        com.kwad.sdk.core.webview.c.c cVar2 = cVar.oN;
        bb.a aVar = new bb.a();
        aVar.aaU = f10;
        aVar.status = i10;
        aVar.creativeId = cVar.getCreativeId();
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.eb(cVar.mAdTemplate).totalBytes;
        long j10 = com.kwad.sdk.core.response.b.e.eb(cVar.mAdTemplate).soFarBytes;
        aVar.soFarBytes = j10;
        long j11 = aVar.totalBytes;
        if (j11 > 0) {
            aVar.aaV = (j10 * 1.0f) / j11;
        } else {
            aVar.aaV = 0.0f;
        }
        cVar2.a(aVar);
    }
}
