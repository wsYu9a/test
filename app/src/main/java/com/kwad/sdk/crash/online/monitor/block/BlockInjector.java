package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.kwad.sdk.ranger.RangerInjector;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;

/* loaded from: classes2.dex */
public class BlockInjector {
    private static volatile boolean arU;
    private static volatile boolean arV;

    /* renamed from: com.kwad.sdk.crash.online.monitor.block.BlockInjector$1 */
    static class AnonymousClass1 implements RangerInjector.b {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.ranger.RangerInjector.b
        public final void a(String str, long j2, long j3, String str2, String str3) {
            e.a(str, j2, j3, str2, str3, false);
        }

        @Override // com.kwad.sdk.ranger.RangerInjector.b
        public final void onError(String str) {
            BlockInjector.onError(str);
        }
    }

    /* renamed from: com.kwad.sdk.crash.online.monitor.block.BlockInjector$2 */
    static class AnonymousClass2 implements RangerInjector.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.ranger.RangerInjector.a
        public final void dI(String str) {
            e.d(str, false);
        }
    }

    private static String a(com.kwad.sdk.crash.online.monitor.kwai.b bVar) {
        String str = new String(com.kwad.sdk.core.kwai.c.vJ().decode((bVar == null || TextUtils.isEmpty(bVar.aso)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.aso));
        com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    private static String b(com.kwad.sdk.crash.online.monitor.kwai.b bVar) {
        String str = new String(com.kwad.sdk.core.kwai.c.vJ().decode((bVar == null || TextUtils.isEmpty(bVar.asn)) ? "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==" : bVar.asn));
        com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "ListenerName:" + str);
        return str;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (arU) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.kwai.b c2 = c(aVar);
            RangerInjector.a(b(c2), a(c2), new RangerInjector.b() { // from class: com.kwad.sdk.crash.online.monitor.block.BlockInjector.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void a(String str, long j2, long j3, String str2, String str3) {
                    e.a(str, j2, j3, str2, str3, false);
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void onError(String str) {
                    BlockInjector.onError(str);
                }
            });
            arU = true;
        } catch (Exception e2) {
            onError(Log.getStackTraceString(e2));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.kwai.b c(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        f fVar = (f) ServiceProvider.get(f.class);
        String appId = fVar != null ? fVar.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return aVar.dP(appId);
    }

    public static void onError(String str) {
        e.dO(str);
        com.kwad.sdk.core.d.b.w("perfMonitor.Injector", str);
    }

    @Keep
    public static void tryProxyOtherOutput(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (arV) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.kwai.b c2 = c(aVar);
            if (c2 == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("perfMonitor.Injector", "featureConfig:" + c2.toJson().toString());
            RangerInjector.tryProxyOtherOutput(c2.asp, c2.asq, c2.asr, c2.ass, new RangerInjector.a() { // from class: com.kwad.sdk.crash.online.monitor.block.BlockInjector.2
                AnonymousClass2() {
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.a
                public final void dI(String str) {
                    e.d(str, false);
                }
            });
            arV = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Injector", Log.getStackTraceString(th));
        }
    }
}
