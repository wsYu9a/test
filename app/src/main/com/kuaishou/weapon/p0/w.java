package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class w {

    /* renamed from: a */
    private Context f11267a;

    /* renamed from: b */
    private int f11268b;

    /* renamed from: c */
    private h f11269c;

    public w(Context context) {
        this.f11268b = 0;
        this.f11267a = context;
        h a10 = h.a(context, "re_po_rt");
        this.f11269c = a10;
        if (a10 != null) {
            this.f11268b = a10.b(df.f11064r, 0);
        }
    }

    public JSONArray a(int i10) {
        try {
            new A(this.f11267a, i10);
            JSONArray jsonObject = A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject != null) {
                for (int i11 = 0; i11 < jsonObject.length(); i11++) {
                    jSONArray.put(jsonObject.get(i11));
                }
                A.setJsonObject(null);
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray b(int i10) {
        try {
            return c(i10);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray c(int i10) {
        return d(i10);
    }

    public JSONArray d(int i10) {
        String[] strArr;
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.f11267a.getPackageManager();
            for (int i11 = 1000; i11 <= 19999; i11++) {
                try {
                    strArr = packageManager.getPackagesForUid(i11);
                } catch (Exception unused) {
                    strArr = null;
                }
                if (strArr != null) {
                    for (String str : strArr) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (i10 != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                v vVar = new v(packageInfo, this.f11267a);
                                vVar.h();
                                jSONArray.put(vVar.k());
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
        return jSONArray;
    }
}
