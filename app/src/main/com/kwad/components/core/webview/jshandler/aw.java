package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.WebCardRegisterFeedMonitorListenerHandler;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class aw implements com.kwad.sdk.core.webview.c.a {
    private final b aaF;

    /* renamed from: com.kwad.components.core.webview.jshandler.aw$1 */
    public class AnonymousClass1 implements com.kwad.components.core.webview.tachikoma.e.d {
        final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;
        final /* synthetic */ a aaG;

        public AnonymousClass1(a aVar, com.kwad.sdk.core.webview.c.c cVar) {
            aVar = aVar;
            cVar = cVar;
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.d
        public final void p(int i10, String str) {
            a aVar = aVar;
            aVar.aaK = str;
            aVar.aaJ = i10;
            cVar.a(aVar);
        }
    }

    @KsJson
    public class a extends com.kwad.sdk.core.response.a.a {

        @WebCardRegisterFeedMonitorListenerHandler.FeedMotionType
        public int aaI;
        public int aaJ;
        public String aaK;

        public a() {
        }
    }

    public interface b {
        void c(com.kwad.components.core.webview.tachikoma.e.d dVar);

        void d(com.kwad.components.core.webview.tachikoma.e.d dVar);

        void e(com.kwad.components.core.webview.tachikoma.e.d dVar);
    }

    public aw(b bVar) {
        this.aaF = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        AnonymousClass1 anonymousClass1 = new com.kwad.components.core.webview.tachikoma.e.d() { // from class: com.kwad.components.core.webview.jshandler.aw.1
            final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;
            final /* synthetic */ a aaG;

            public AnonymousClass1(a aVar2, com.kwad.sdk.core.webview.c.c cVar2) {
                aVar = aVar2;
                cVar = cVar2;
            }

            @Override // com.kwad.components.core.webview.tachikoma.e.d
            public final void p(int i10, String str2) {
                a aVar2 = aVar;
                aVar2.aaK = str2;
                aVar2.aaJ = i10;
                cVar.a(aVar2);
            }
        };
        int i10 = aVar2.aaI;
        if (i10 == 1) {
            this.aaF.d(anonymousClass1);
        } else if (i10 == 2) {
            this.aaF.c(anonymousClass1);
        } else {
            if (i10 != 3) {
                return;
            }
            this.aaF.e(anonymousClass1);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerFeedMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
