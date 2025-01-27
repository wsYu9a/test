package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o {
    public static s a(JSONObject jSONObject) {
        p b2 = b(jSONObject);
        if (b2 == null) {
            return null;
        }
        int a2 = b2.a();
        String l = b2.l();
        String j2 = b2.j();
        boolean z = b2.d() == 1;
        boolean z2 = b2.h() == 1;
        int e2 = b2.e();
        String c2 = b2.c();
        String f2 = b2.f();
        String b3 = b2.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f2;
            packageInfo.versionName = l;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f2) && !TextUtils.isEmpty(b3) && b3.startsWith(".")) {
                applicationInfo.name = f2 + b3;
                applicationInfo.className = f2 + b3;
            }
            applicationInfo.theme = b2.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m = b2.m();
            if (m != null && m.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < m.size(); i2++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m.get(i2).c();
                    activityInfo.theme = m.get(i2).b();
                    activityInfo.labelRes = m.get(i2).a();
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
        s sVar = new s(packageInfo, a2, f2, l, j2, c2);
        sVar.v = z;
        sVar.x = e2;
        int a3 = b2.k() == null ? 0 : b2.k().a();
        int b4 = b2.k() == null ? -1 : b2.k().b();
        sVar.t = a3;
        sVar.u = b4;
        sVar.s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z2) {
            z2 = b2.g() == 1;
        }
        sVar.y = z2;
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
            pVar.c(jSONObject.optString(bh.q));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                aVar.a(jSONObject2.optInt(t.k));
                aVar.b(jSONObject2.optInt("t"));
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
            bVar.b(jSONObject3.optInt("network"));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
