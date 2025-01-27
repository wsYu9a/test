package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.crash.online.monitor.block.d;
import com.kwad.sdk.crash.online.monitor.kwai.c;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    private static volatile boolean hasInit = false;

    /* renamed from: com.kwad.sdk.crash.online.monitor.a$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ String arG;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            if (a.hasInit) {
                return;
            }
            b.d("perfMonitor.MonitorManager", "configStr:" + str);
            c dE = a.dE(str);
            b.d("perfMonitor.MonitorManager", dE.toJson().toString());
            d.d(dE.ast);
            a.access$002(true);
        }
    }

    static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void cL(String str) {
        g.execute(new aw() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            final /* synthetic */ String arG;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                b.d("perfMonitor.MonitorManager", "configStr:" + str);
                c dE = a.dE(str);
                b.d("perfMonitor.MonitorManager", dE.toJson().toString());
                d.d(dE.ast);
                a.access$002(true);
            }
        });
    }

    public static c dE(String str) {
        if (TextUtils.isEmpty(str)) {
            return zR();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e2) {
            b.w("perfMonitor.MonitorManager", e2);
            return zR();
        }
    }

    private static c zR() {
        c cVar = new c();
        com.kwad.sdk.crash.online.monitor.kwai.a aVar = new com.kwad.sdk.crash.online.monitor.kwai.a();
        cVar.ast = aVar;
        aVar.ask = 5;
        return cVar;
    }
}
