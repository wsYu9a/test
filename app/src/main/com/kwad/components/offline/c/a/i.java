package com.kwad.components.offline.c.a;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.IOfflineTKView;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.r;
import com.kwad.sdk.components.s;
import com.kwad.sdk.utils.au;
import java.util.Map;

/* loaded from: classes3.dex */
public final class i implements s {
    private final IOfflineCompoTachikomaContext agB;

    /* renamed from: com.kwad.components.offline.c.a.i$1 */
    public class AnonymousClass1 implements n {
        final /* synthetic */ IOfflineTKView agC;

        public AnonymousClass1(IOfflineTKView iOfflineTKView) {
            tKView = iOfflineTKView;
        }

        @Override // com.kwad.sdk.components.n
        public final void bindActivity(Activity activity) {
            tKView.bindActivity(activity);
        }

        @Override // com.kwad.sdk.components.n
        public final View getView() {
            return tKView.getView();
        }

        @Override // com.kwad.sdk.components.n
        public final boolean onBackPressed() {
            return tKView.onBackPressed();
        }

        @Override // com.kwad.sdk.components.n
        public final void render() {
            tKView.render();
        }
    }

    public i(@NonNull IOfflineCompoTachikomaContext iOfflineCompoTachikomaContext) {
        au.checkNotNull(iOfflineCompoTachikomaContext);
        this.agB = iOfflineCompoTachikomaContext;
    }

    @Override // com.kwad.sdk.components.s
    public final void a(String str, String str2, r rVar) {
        this.agB.execute(str, str2, new h(rVar));
    }

    @Override // com.kwad.sdk.components.s
    public final void b(com.kwad.sdk.core.webview.c.g gVar) {
        if (gVar == null) {
            return;
        }
        this.agB.registerTKBridge(new f(gVar));
    }

    @Override // com.kwad.sdk.components.s
    public final n bd(String str) {
        return new n() { // from class: com.kwad.components.offline.c.a.i.1
            final /* synthetic */ IOfflineTKView agC;

            public AnonymousClass1(IOfflineTKView iOfflineTKView) {
                tKView = iOfflineTKView;
            }

            @Override // com.kwad.sdk.components.n
            public final void bindActivity(Activity activity) {
                tKView.bindActivity(activity);
            }

            @Override // com.kwad.sdk.components.n
            public final View getView() {
                return tKView.getView();
            }

            @Override // com.kwad.sdk.components.n
            public final boolean onBackPressed() {
                return tKView.onBackPressed();
            }

            @Override // com.kwad.sdk.components.n
            public final void render() {
                tKView.render();
            }
        };
    }

    @Override // com.kwad.sdk.components.s
    public final void c(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.agB.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.s
    public final Object execute(String str) {
        return this.agB.execute(str);
    }

    @Override // com.kwad.sdk.components.s
    public final int getUniqId() {
        return this.agB.getUniqId();
    }

    @Override // com.kwad.sdk.components.s
    public final View getView() {
        return this.agB.getView();
    }

    @Override // com.kwad.sdk.components.s
    public final void onDestroy() {
        this.agB.onDestroy();
    }

    @Override // com.kwad.sdk.components.s
    public final void setCustomEnv(Map<String, Object> map) {
        this.agB.setCustomEnv(map);
    }

    @Override // com.kwad.sdk.components.s
    public final void a(q qVar) {
        if (qVar != null) {
            this.agB.registerHostActionHandler(new c(qVar));
        }
    }

    @Override // com.kwad.sdk.components.s
    public final void a(k kVar) {
        if (kVar != null) {
            this.agB.registerApkLoadCreator(new e(kVar));
        }
    }
}
