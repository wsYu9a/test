package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class l implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.e.d.c MA;
    private KsAppDownloadListener Yr;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.c.c oN;

    /* renamed from: com.kwad.components.core.webview.jshandler.l$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            l.this.p(0, 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            l.this.p(8, 100);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            l.this.p(0, 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            l.this.p(12, 100);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            l.this.p(4, i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            if (i10 == 0) {
                l.this.p(1, 0);
            } else {
                l.this.p(2, i10);
            }
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String YP;
        public String packageName;
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int YQ;
        public int progress;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    public l(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    private synchronized void o(String str, String str2) {
        this.MA = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.Yr == null) {
            KsAppDownloadListener tp = tp();
            this.Yr = tp;
            this.MA.b(tp);
        }
    }

    private static boolean p(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener tp() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.l.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                l.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                l.this.p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                l.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                l.this.p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                l.this.p(4, i10);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                if (i10 == 0) {
                    l.this.p(1, 0);
                } else {
                    l.this.p(2, i10);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.oN = null;
    }

    public void p(int i10, int i11) {
        if (this.oN != null) {
            b bVar = new b();
            bVar.status = i10;
            bVar.progress = i11;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                bVar.totalBytes = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                long j10 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate).soFarBytes;
                bVar.soFarBytes = j10;
                long j11 = bVar.totalBytes;
                if (j11 > 0) {
                    bVar.YQ = (int) ((j10 * 100.0f) / j11);
                } else {
                    bVar.YQ = 0;
                }
            }
            this.oN.a(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.oN = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (p(aVar.YP, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.MA == null) {
                o(aVar.YP, aVar.packageName);
            }
            a.C0427a as = new a.C0427a(this.mContext).ap(true).aq(false).au(this.mAdTemplate).as(false);
            if (this.MA.s(as)) {
                return;
            }
            this.MA.d(this.Yr);
            this.MA.r(as);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }
}
