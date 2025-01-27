package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.p;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class o {
    public static s a(JSONObject jSONObject) {
        p b10 = b(jSONObject);
        if (b10 == null) {
            return null;
        }
        int a10 = b10.a();
        String l10 = b10.l();
        String j10 = b10.j();
        boolean z10 = b10.d() == 1;
        boolean z11 = b10.h() == 1;
        int e10 = b10.e();
        String c10 = b10.c();
        String f10 = b10.f();
        String b11 = b10.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f10;
            packageInfo.versionName = l10;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f10) && !TextUtils.isEmpty(b11) && b11.startsWith(p1.b.f29697h)) {
                applicationInfo.name = f10 + b11;
                applicationInfo.className = f10 + b11;
            }
            applicationInfo.theme = b10.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m10 = b10.m();
            if (m10 != null && m10.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < m10.size(); i10++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m10.get(i10).c();
                    activityInfo.theme = m10.get(i10).b();
                    activityInfo.labelRes = m10.get(i10).a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable unused) {
        }
        s sVar = new s(packageInfo, a10, f10, l10, j10, c10);
        sVar.f11197v = z10;
        sVar.f11199x = e10;
        int a11 = b10.k() == null ? 0 : b10.k().a();
        int b12 = b10.k() == null ? -1 : b10.k().b();
        sVar.f11195t = a11;
        sVar.f11196u = b12;
        sVar.f11194s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z11) {
            z11 = b10.g() == 1;
        }
        sVar.f11200y = z11;
        return sVar;
    }

    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString("wm"));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString(bi.f10821q));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                aVar.a(jSONObject2.optInt(t.f11211k));
                aVar.b(jSONObject2.optInt(com.umeng.analytics.pro.bt.aO));
                aVar.a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar);
            }
            pVar.a(arrayList);
            p.b bVar = new p.b();
            JSONObject jSONObject3 = jSONObject.getJSONObject("we");
            bVar.a(jSONObject3.optInt("duration"));
            bVar.b(jSONObject3.optInt(PointCategory.NETWORK));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
