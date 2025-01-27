package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class g {
    private static final AtomicBoolean aKj = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.crash.g$1 */
    public class AnonymousClass1 extends b.c {
        public AnonymousClass1() {
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: c */
        public void d(com.kwad.library.solder.lib.b.c cVar) {
            super.d(cVar);
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
        }

        private void uO() {
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onPostLoad");
            a aVar = a.this;
            if (aVar != null) {
                aVar.Jd();
            }
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
            uO();
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public final /* bridge */ /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
            a(pluginError);
        }

        private void a(PluginError pluginError) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName() + "\n" + pluginError);
            a aVar = a.this;
            if (aVar != null) {
                aVar.Je();
            }
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: a */
        public void f(com.kwad.library.solder.lib.b.c cVar) {
            super.f(cVar);
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
        }
    }

    public interface a {
        void Jd();

        void Je();
    }

    public static void a(@NonNull c cVar, a aVar) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = aKj;
        if (atomicBoolean.get()) {
            aVar.Jd();
            return;
        }
        if (cVar.sdkVersion.compareTo(cVar.aJL) < 0) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "sdkVersion:" + cVar.sdkVersion + "*supportAppVersion:" + cVar.aJL);
            aVar.Je();
            return;
        }
        if (!TextUtils.isEmpty(cVar.aJM) && cVar.sdkVersion.compareTo(cVar.aJM) >= 0) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "sdkVersion:" + cVar.sdkVersion + "*maxVersionExclude:" + cVar.aJM);
            aVar.Je();
            return;
        }
        Context context = cVar.context;
        atomicBoolean.set(true);
        if (AbiUtil.isArm64(context)) {
            str = cVar.aJP;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202406211433/ks_so-exceptionArm64v8aRelease-3.3.67-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aJR;
            str3 = "exception-v8a";
        } else {
            str = cVar.aJQ;
            if (TextUtils.isEmpty(str)) {
                str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202406211433/ks_so-exceptionArmeabiv7aRelease-3.3.67-e8fbb3a5f8-666.apk";
            }
            str2 = cVar.aJS;
            str3 = "exception-v7a";
        }
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "url:" + str + " pluginName:" + str3 + " md5:" + str2);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.ano = com.kwad.sdk.core.network.idc.a.Fz().eg(str);
        bVar.Lc = true;
        bVar.ann = str3;
        bVar.version = cVar.aJK;
        bVar.anq = str2;
        bVar.anr = false;
        a(context, bVar, aVar);
    }

    private static void a(Context context, com.kwad.library.solder.lib.c.b bVar, @Nullable a aVar) {
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.crash.g.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            private void uO() {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onPostLoad");
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.Jd();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                uO();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName() + "\n" + pluginError);
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.Je();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }
        });
    }
}
