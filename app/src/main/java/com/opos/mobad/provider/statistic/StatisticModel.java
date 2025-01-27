package com.opos.mobad.provider.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.acs.st.STManager;
import com.opos.mobad.provider.record.SdKRecord;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class StatisticModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.statistic.StatisticModel.1
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public StatisticModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            StatisticModelIdentify statisticModelIdentify = (StatisticModelIdentify) iBridgeTargetIdentify;
            return StatisticModel.a(context.getApplicationContext(), statisticModelIdentify.f23157a, statisticModelIdentify.f23158b);
        }
    };

    /* renamed from: a */
    private static volatile StatisticModel f23155a;

    /* renamed from: b */
    private Context f23156b;

    /* renamed from: com.opos.mobad.provider.statistic.StatisticModel$1 */
    static final class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.opos.process.bridge.provider.d.a
        public StatisticModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            StatisticModelIdentify statisticModelIdentify = (StatisticModelIdentify) iBridgeTargetIdentify;
            return StatisticModel.a(context.getApplicationContext(), statisticModelIdentify.f23157a, statisticModelIdentify.f23158b);
        }
    }

    private StatisticModel(Context context, boolean z, String str) {
        this.f23156b = context;
        str = TextUtils.isEmpty(str) ? STManager.REGION_OF_CN : str;
        Context context2 = this.f23156b;
        com.opos.cmn.f.a.a(context2, com.opos.cmn.an.b.a.a(context2), str);
        if (z) {
            com.opos.cmn.f.a.b();
        }
    }

    public static StatisticModel a(Context context, boolean z, String str) {
        StatisticModel statisticModel = f23155a;
        if (statisticModel == null) {
            synchronized (StatisticModel.class) {
                statisticModel = f23155a;
                if (statisticModel == null) {
                    statisticModel = new StatisticModel(context, z, str);
                    f23155a = statisticModel;
                }
            }
        }
        return statisticModel;
    }

    private String a() {
        List<PackageInfo> installedPackages;
        if (com.opos.cmn.an.f.a.b(this.f23156b) || (installedPackages = this.f23156b.getPackageManager().getInstalledPackages(128)) == null || installedPackages.size() <= 0) {
            return "";
        }
        com.opos.cmn.an.f.a.b("report", "size:" + installedPackages.size());
        StringBuilder sb = new StringBuilder();
        Iterator<PackageInfo> it = installedPackages.iterator();
        while (it.hasNext()) {
            sb.append(it.next().packageName);
            sb.append(":");
        }
        return sb.length() <= 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    private void a(String str, Map<String, String> map) {
        com.opos.cmn.an.f.a.a("report", "report transport params =" + str);
        com.opos.cmn.an.f.a.a("report", "report params =", map);
        com.opos.cmn.f.a.a(this.f23156b, str, map);
    }

    @BridgeMethod(a = 2)
    public final void a(String str) {
        if (!TextUtils.isEmpty(str) && SdKRecord.a(this.f23156b).e() + 86400000 <= System.currentTimeMillis()) {
            try {
                Map<String, String> b2 = b(str);
                b2.put(MiConfigSingleton.t0, a());
                a("", b2);
                SdKRecord.a(this.f23156b).f();
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.b("", "transport fail", e2);
            }
        }
    }

    @BridgeMethod(a = 1)
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            a(str, b(str2));
        } catch (JSONException e2) {
            com.opos.cmn.an.f.a.b("", "transport fail", e2);
        }
    }

    public Map<String, String> b(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        }
        return hashMap;
    }
}
