package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private static volatile boolean hasInit = false;

    /* renamed from: com.kwad.sdk.crash.online.monitor.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String aKQ;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (a.hasInit) {
                return;
            }
            c.d("perfMonitor.MonitorManager", "configStr:" + str);
            com.kwad.sdk.crash.online.monitor.a.c fI = a.fI(str);
            c.d("perfMonitor.MonitorManager", fI.toJson().toString());
            e.d(fI.aLC);
            a.access$002(true);
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.c JC() {
        com.kwad.sdk.crash.online.monitor.a.c cVar = new com.kwad.sdk.crash.online.monitor.a.c();
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aLC = aVar;
        aVar.aLt = 5;
        return cVar;
    }

    public static /* synthetic */ boolean access$002(boolean z10) {
        hasInit = true;
        return true;
    }

    public static void cO(String str) {
        h.execute(new bd() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            final /* synthetic */ String aKQ;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                c.d("perfMonitor.MonitorManager", "configStr:" + str);
                com.kwad.sdk.crash.online.monitor.a.c fI = a.fI(str);
                c.d("perfMonitor.MonitorManager", fI.toJson().toString());
                e.d(fI.aLC);
                a.access$002(true);
            }
        });
    }

    public static com.kwad.sdk.crash.online.monitor.a.c fI(String str) {
        if (TextUtils.isEmpty(str)) {
            return JC();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.online.monitor.a.c cVar = new com.kwad.sdk.crash.online.monitor.a.c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e10) {
            c.w("perfMonitor.MonitorManager", e10);
            return JC();
        }
    }
}
