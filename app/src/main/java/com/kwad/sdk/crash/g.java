package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.AbiUtil;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class g {
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.crash.g$1 */
    static class AnonymousClass1 extends b.c {
        AnonymousClass1() {
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public void a(com.kwai.sodler.lib.b.c cVar) {
            super.a((AnonymousClass1) cVar);
            com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        /* renamed from: c */
        public void b(com.kwai.sodler.lib.b.c cVar) {
            super.b(cVar);
            com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
        }

        private void rN() {
            com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onPostLoad thread=" + Thread.currentThread().getName());
            a aVar = a.this;
            if (aVar != null) {
                aVar.zt();
            }
        }

        private void zH() {
            com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
            rN();
        }

        @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
        public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
            zH();
        }
    }

    public interface a {
        void zt();
    }

    private static void a(Context context, com.kwai.sodler.lib.c.b bVar, @Nullable a aVar) {
        com.kwai.sodler.kwai.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.g.1
            AnonymousClass1() {
            }

            @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.c cVar) {
                super.a((AnonymousClass1) cVar);
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }

            @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
            /* renamed from: c */
            public void b(com.kwai.sodler.lib.b.c cVar) {
                super.b(cVar);
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            private void rN() {
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onPostLoad thread=" + Thread.currentThread().getName());
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.zt();
                }
            }

            private void zH() {
                com.kwad.sdk.core.d.b.d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
            }

            @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar2) {
                rN();
            }

            @Override // com.kwai.sodler.lib.ext.b.C0248b, com.kwai.sodler.lib.ext.b
            public final /* synthetic */ void a(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
                zH();
            }
        });
    }

    public static void a(@NonNull c cVar, @Nullable a aVar) {
        String str;
        String str2;
        AtomicBoolean atomicBoolean = ISLOADED;
        if (atomicBoolean.get()) {
            aVar.zt();
            return;
        }
        Context context = cVar.context;
        atomicBoolean.set(true);
        if (AbiUtil.isArm64(context)) {
            str = cVar.aqS;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArm64v8aRelease-3.3.23.apk";
            }
            str2 = "exception-v8a";
        } else {
            str = cVar.aqT;
            if (TextUtils.isEmpty(str)) {
                str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-exceptionArmeabiv7aRelease-3.3.23.apk";
            }
            str2 = "exception-v7a";
        }
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.aKU = com.kwad.sdk.core.network.idc.a.wm().ch(str);
        bVar.Ig = true;
        bVar.aKT = str2;
        bVar.version = "3.1";
        bVar.aKX = false;
        a(context, bVar, aVar);
    }
}
