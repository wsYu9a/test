package rg;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static int f30424a = 9004;

    public static int a() {
        return f30424a;
    }

    public static void b(int i10) {
        f30424a = i10;
    }

    public static void c(hg.d dVar, AdMonitorType adMonitorType) {
        String str = adMonitorType == AdMonitorType.CLICK ? "tanx_click_invoke_success" : adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_invoke_success" : "tanx_interact_invoke_success";
        if (dVar == null) {
            sg.a.a(str, "AdMonitorExtraParams is null");
        } else {
            c.a(str, sg.c.f(dVar), true);
        }
    }

    public static void d(hg.d dVar, AdMonitorType adMonitorType, String str) {
        String str2 = adMonitorType == AdMonitorType.CLICK ? "tanx_click_invoke_error" : adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_invoke_error" : "tanx_interact_invoke_error";
        if (dVar == null) {
            sg.a.a(str2, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = sg.c.f(dVar);
        f10.put(MediationConstant.KEY_ERROR_MSG, str);
        c.a(str2, f10, true);
    }

    public static void e(hg.d dVar, AdMonitorType adMonitorType, String str, String str2) {
        String str3 = adMonitorType == AdMonitorType.CLICK ? "tanx_click_request" : adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_request" : adMonitorType == AdMonitorType.INTERACT_DEDUPLICATION ? "tanx_interact_deduplication_request" : "tanx_interact_request";
        if (dVar == null) {
            sg.a.a(str3, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = sg.c.f(dVar);
        f10.put(z2.c.f33638f, str);
        f10.put("url_hash", str2);
        c.a(str3, f10, true);
    }

    public static void f(ig.b bVar, int i10, String str, boolean z10, String str2) {
        if (bVar == null || bVar.l() == null) {
            sg.a.a("exposeRequestFail", "wrapper is null");
            return;
        }
        String str3 = bVar.l() == AdMonitorType.CLICK ? "tanx_click_request_fail" : bVar.l() == AdMonitorType.EXPOSE ? "tanx_expose_request_fail" : "tanx_interact_request_fail";
        if (bVar.j() == null) {
            sg.a.a(str3, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = sg.c.f(bVar.j());
        f10.put(z2.c.f33638f, bVar.o());
        f10.put("url_hash", bVar.n());
        f10.put("isRetry", String.valueOf(z10));
        f10.put("retryType", str2);
        f10.put("url", bVar.k());
        f10.put(MediationConstant.KEY_ERROR_CODE, String.valueOf(i10));
        f10.put(MediationConstant.KEY_ERROR_MSG, str);
        c.a(str3, f10, false);
    }

    public static void g(ig.b bVar, boolean z10, String str) {
        if (bVar == null || bVar.l() == null) {
            sg.a.a("exposeRequestSuccess", "wrapper is null");
            return;
        }
        String str2 = bVar.l() == AdMonitorType.CLICK ? "tanx_click_request_success" : bVar.l() == AdMonitorType.EXPOSE ? "tanx_expose_request_success" : "tanx_interact_request_success";
        if (bVar.j() == null) {
            sg.a.a(str2, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = sg.c.f(bVar.j());
        f10.put(z2.c.f33638f, bVar.o());
        f10.put("url_hash", bVar.n());
        f10.put("isRetry", String.valueOf(z10));
        f10.put("retryType", str);
        c.a(str2, f10, false);
    }

    public static void h(hg.d dVar, AdMonitorType adMonitorType) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("tanx_request_duplicated_");
        sb2.append(adMonitorType != null ? adMonitorType.name() : "");
        String sb3 = sb2.toString();
        if (dVar == null) {
            sg.a.a(sb3, "AdMonitorExtraParams is null");
        } else {
            c.a(sb3, sg.c.f(dVar), true);
        }
    }

    public static void i(hg.d dVar, AdMonitorType adMonitorType, String str) {
        String str2 = adMonitorType == AdMonitorType.CLICK ? "tanx_click_invalid_url" : adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_invalid_url" : adMonitorType == AdMonitorType.INTERACT_DEDUPLICATION ? "tanx_interact_deduplication_invalid_url" : "tanx_interact_invalid_url";
        if (dVar == null) {
            sg.a.a(str2, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = sg.c.f(dVar);
        f10.put(MediationConstant.KEY_ERROR_MSG, str);
        c.a(str2, f10, true);
    }
}
