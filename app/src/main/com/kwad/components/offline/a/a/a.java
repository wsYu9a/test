package com.kwad.components.offline.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ae;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class a {
    private static final AtomicBoolean afJ = new AtomicBoolean(false);
    private static final String afK = ae.format("lib%s.so", "c++_shared");
    private static final String afL = ae.format("lib%s.so", "kwaiplayer");
    private static final String afM = ae.format("lib%s.so", "kste");
    private static final String afN = ae.format("lib%s.so", "hodor");
    private static final String afO = ae.format("lib%s.so", "aegon");

    /* renamed from: com.kwad.components.offline.a.a.a$1 */
    public class AnonymousClass1 extends b.c {
        public AnonymousClass1() {
        }

        private void uO() {
            SoLoadListener.this.onLoaded();
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
            uO();
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
            a(pluginError);
        }

        private void a(PluginError pluginError) {
            SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
        }
    }

    public static void a(Context context, @NonNull SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = afJ;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            hashMap.put(afK, "dcd68cd059cb06a9596ba6839c2e8858");
            hashMap.put(afL, "cf71bcc476b2b25e2e62b541275ad78c");
            hashMap.put(afM, "ebb56fa9c5701350497e281c2446660f");
            hashMap.put(afN, "a61edf93bc5abc7799c5444ccbaf140b");
            hashMap.put(afO, "c256c0d7f79ad4d47db61cb8e8ab142a");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArm64v8aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v8a";
            str3 = "41a4213dcbf3ed262fc69daf7d4a29e5";
        } else {
            hashMap.put(afK, "e3fdbf82716c2cb9b666a3880ab94003");
            hashMap.put(afL, "2ba24f9d0a6e786af477ed1e2dad148b");
            hashMap.put(afM, "71a9baa45905a6f0e527e5a2e06e8808");
            hashMap.put(afN, "d997935a035d00a67dc46e26427b8bf9");
            hashMap.put(afO, "bdac6eea0d25da98061c21234f3b20c5");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArmeabiv7aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v7a";
            str3 = "ceddd5a3aae9148992bee153a29a25fb";
        }
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        com.kwad.library.b.a j10 = com.kwad.library.solder.a.a.j(context, IAdLiveOfflineCompo.PACKAGE_NAME);
        c.d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + j10);
        if (j10 instanceof com.kwad.library.b.a) {
            bVar.anw = j10.yc();
        }
        bVar.ano = com.kwad.sdk.core.network.idc.a.Fz().eg(str);
        bVar.Lc = true;
        bVar.ann = str2;
        bVar.version = "3.3.44.3";
        bVar.ant = hashMap;
        bVar.anq = str3;
        bVar.anr = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.a.a.a.1
            public AnonymousClass1() {
            }

            private void uO() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                uO();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
            }
        });
    }
}
