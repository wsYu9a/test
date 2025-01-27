package com.kwad.components.offline.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.b.a.l;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bb;

/* loaded from: classes3.dex */
public final class d implements ITkOfflineCompoInitConfig {

    /* renamed from: com.kwad.components.offline.c.d$1 */
    public class AnonymousClass1 implements ISoLoader {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
        public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
            com.kwad.components.offline.c.b.a.a(context, soLoadListener);
        }
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getSpKeyTkSoLoadTimes() {
        return "tk_so_load_times";
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getSpNameSoLoadTimes() {
        return "ksadsdk_so_load_times";
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getTkJsFileDir(Context context, String str) {
        return bb.getTkJsFileDir(context, str);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getTkJsRootDir(Context context) {
        return bb.getTkJsRootDir(context);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getTkVersion() {
        return "6.1.2";
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean isLocalDebugEnable() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.c.d.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                com.kwad.components.offline.c.b.a.a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean useTkLite() {
        return com.kwad.components.offline.c.b.a.useTkLite();
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean useTkSoAll() {
        return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.auF);
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new l(ITkOfflineCompo.PACKAGE_NAME);
    }
}
