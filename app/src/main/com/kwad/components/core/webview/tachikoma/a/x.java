package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c Zn;
    private OfflineOnAudioConflictListener zt = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.a.x.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.aV(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.aV(3);
        }
    };

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.x$1 */
    public class AnonymousClass1 implements OfflineOnAudioConflictListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.aV(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.aV(3);
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean adf;
        public int adg;
    }

    public void aV(int i10) {
        a aVar = new a();
        aVar.adf = com.kwad.components.core.s.a.av(ServiceProvider.getContext()).sa();
        aVar.adg = i10;
        com.kwad.sdk.core.webview.c.c cVar = this.Zn;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.s.a.av(ServiceProvider.getContext()).b(this.zt);
        this.Zn = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Zn = cVar;
        com.kwad.components.core.s.a.av(ServiceProvider.getContext()).a(this.zt);
        aV(1);
    }
}
