package y0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.repack.bun.lib.sysParamters;
import java.util.HashMap;
import java.util.Map;
import y0.c;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public Map<String, String> f32941a = new HashMap();

    public class a implements c.a {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final Map<String, String> a() {
        PackageInfo packageInfo;
        String str;
        String str2;
        String str3;
        if (this.f32941a.isEmpty()) {
            ?? r02 = this.f32941a;
            sysParamters a10 = sysParamters.a();
            if (TextUtils.isEmpty(a10.f16628a)) {
                Context a11 = jh.b.a();
                if (a11 == null) {
                    str = "0.1.100";
                } else {
                    try {
                        packageInfo = a11.getPackageManager().getPackageInfo(a11.getPackageName(), 0);
                    } catch (Exception unused) {
                        packageInfo = null;
                    }
                    str = packageInfo == null ? null : packageInfo.versionName;
                }
                a10.f16628a = str;
                str2 = str;
            } else {
                str2 = a10.f16628a;
            }
            r02.put(n3.a.f28757w, str2);
            this.f32941a.put(n3.a.f28754t, sysParamters.a().e());
            ?? r03 = this.f32941a;
            sysParamters a12 = sysParamters.a();
            if (TextUtils.isEmpty(a12.f16629b)) {
                String str4 = Build.MODEL;
                a12.f16629b = str4;
                String replace = str4.replace(" ", "-");
                a12.f16629b = replace;
                str3 = replace;
            } else {
                str3 = a12.f16629b;
            }
            r03.put("md", str3);
            this.f32941a.put("mf", sysParamters.a().c());
            this.f32941a.put("pn", sysParamters.d());
        }
        this.f32941a.put("tm", String.valueOf(System.currentTimeMillis()));
        return this.f32941a;
    }
}
