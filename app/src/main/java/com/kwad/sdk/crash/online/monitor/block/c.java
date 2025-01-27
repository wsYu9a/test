package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.m.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* loaded from: classes3.dex */
public final class c {
    private static volatile boolean aLe;

    /* renamed from: com.kwad.sdk.crash.online.monitor.block.c$1 */
    public class AnonymousClass1 implements d.a {
        @Override // com.kwad.sdk.m.d.a
        public final void a(String str, long j10, long j11, String str2, String str3) {
            f.a(str, j10, j11, str2, str3, false);
        }

        @Override // com.kwad.sdk.m.d.a
        public final void onError(String str) {
            c.onError(str);
        }
    }

    private static String a(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.EY().decode((bVar == null || TextUtils.isEmpty(bVar.aLx)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.aLx));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aLe) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.a.b c10 = c(aVar);
            com.kwad.sdk.m.d.a(b(c10), a(c10), new d.a() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.m.d.a
                public final void a(String str, long j10, long j11, String str2, String str3) {
                    f.a(str, j10, j11, str2, str3, false);
                }

                @Override // com.kwad.sdk.m.d.a
                public final void onError(String str) {
                    c.onError(str);
                }
            });
            aLe = true;
        } catch (Exception e10) {
            onError(Log.getStackTraceString(e10));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.b c(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        h hVar = (h) ServiceProvider.get(h.class);
        String appId = hVar != null ? hVar.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return aVar.fQ(appId);
    }

    public static void onError(String str) {
        f.fP(str);
        com.kwad.sdk.core.d.c.w("perfMonitor.Injector", str);
    }

    private static String b(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str;
        if (bVar != null && !TextUtils.isEmpty(bVar.aLw)) {
            str = bVar.aLw;
        } else {
            str = "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==";
        }
        String str2 = new String(com.kwad.sdk.core.a.c.EY().decode(str));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "ListenerName:" + str2);
        return str2;
    }
}
