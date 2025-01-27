package com.kwad.components.offline.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.offline.init.kwai.i;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.av;

/* loaded from: classes2.dex */
public final class c implements ITkOfflineCompoInitConfig {

    /* renamed from: com.kwad.components.offline.tk.c$1 */
    final class AnonymousClass1 implements ISoLoader {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
        public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
            com.kwad.components.offline.tk.a.a.a(context, soLoadListener);
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
        return av.getTkJsFileDir(context, str);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getTkJsRootDir(Context context) {
        return av.getTkJsRootDir(context);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getTkVersion() {
        return "5.0.1";
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean isCanUseTk() {
        return d.isCanUseTk();
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean isLocalDebugEnable() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.tk.c.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                com.kwad.components.offline.tk.a.a.a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean useTkLite() {
        return com.kwad.components.offline.tk.a.a.useTkLite();
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new i(ITkOfflineCompo.PACKAGE_NAME);
    }
}
