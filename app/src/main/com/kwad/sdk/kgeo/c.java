package com.kwad.sdk.kgeo;

import android.content.Context;
import android.os.Build;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.q;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class c {
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.kgeo.c$1 */
    public class AnonymousClass1 extends b.c {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        private void uO() {
            com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onPostLoad");
            try {
                System.loadLibrary("ipneigh-android");
                a.this.onSuccess(com.kwai.library.ipneigh.c.dQ(context).aZh);
            } catch (Throwable unused) {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "loadLibrary fail");
                a.this.Je();
            }
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
            com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
            a.this.Je();
        }
    }

    public interface a {
        void Je();

        void onSuccess(String str);
    }

    public static void a(Context context, a aVar) {
        if (az.Og()) {
            aVar.Je();
            return;
        }
        if (!q.MW()) {
            aVar.Je();
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            aVar.Je();
            return;
        }
        AtomicBoolean atomicBoolean = sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        boolean isArm64 = AbiUtil.isArm64(context);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.version = "1.0.3";
        bVar.ann = isArm64 ? "kmc-v8a" : "kmc-v7a";
        bVar.ano = com.kwad.sdk.core.network.idc.a.Fz().eg(isArm64 ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32");
        bVar.anq = isArm64 ? "db9a8da62a0354ec5710ec03e2743f07" : "2440a8221230913d4287c6b1e02b49f1";
        bVar.Lc = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.kgeo.c.1
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            private void uO() {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onPostLoad");
                try {
                    System.loadLibrary("ipneigh-android");
                    a.this.onSuccess(com.kwai.library.ipneigh.c.dQ(context).aZh);
                } catch (Throwable unused) {
                    com.kwad.sdk.core.d.c.d("KGeoSoHelper", "loadLibrary fail");
                    a.this.Je();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                uO();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                a.this.Je();
            }
        });
    }
}
