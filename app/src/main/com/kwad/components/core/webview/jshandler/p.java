package com.kwad.components.core.webview.jshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class p implements com.kwad.sdk.core.webview.c.a {
    private BroadcastReceiver YS;
    private com.kwad.sdk.core.webview.c.c oN;

    /* renamed from: com.kwad.components.core.webview.jshandler.p$1 */
    public class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(h3.e.f26408m);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            a aVar = new a();
            aVar.message = stringExtra;
            p.this.oN.a(aVar);
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String message;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "onMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        try {
            if (this.YS != null) {
                com.kwad.sdk.utils.aa.cn(ServiceProvider.getContext()).unregisterReceiver(this.YS);
                this.YS = null;
            }
        } catch (Throwable th2) {
            com.kwad.sdk.crash.b.n(th2);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.oN = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ksad_webView_local_broadcast");
        try {
            if (this.YS != null) {
                com.kwad.sdk.utils.aa.cn(ServiceProvider.getContext()).unregisterReceiver(this.YS);
                this.YS = null;
            }
            this.YS = new BroadcastReceiver() { // from class: com.kwad.components.core.webview.jshandler.p.1
                public AnonymousClass1() {
                }

                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    String stringExtra = intent.getStringExtra(h3.e.f26408m);
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    a aVar = new a();
                    aVar.message = stringExtra;
                    p.this.oN.a(aVar);
                }
            };
            com.kwad.sdk.utils.aa.cn(ServiceProvider.getContext()).a(this.YS, intentFilter);
        } catch (Throwable th2) {
            com.kwad.sdk.crash.b.n(th2);
        }
        cVar.a(null);
    }
}
