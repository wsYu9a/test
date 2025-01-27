package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a */
    private Context f9434a;

    /* renamed from: b */
    private int f9435b;

    /* renamed from: c */
    private h f9436c;

    public w(Context context) {
        this.f9435b = 0;
        this.f9434a = context;
        h a2 = h.a(context, "re_po_rt");
        this.f9436c = a2;
        if (a2 != null) {
            this.f9435b = a2.b(de.p, 0);
        }
    }

    public JSONArray a(int i2) {
        try {
            new A(this.f9434a, i2);
            JSONArray jsonObject = A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject != null) {
                for (int i3 = 0; i3 < jsonObject.length(); i3++) {
                    jSONArray.put(jsonObject.get(i3));
                }
                A.setJsonObject(null);
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray b(int i2) {
        try {
            return c(i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray c(int i2) {
        return d(i2);
    }

    public JSONArray d(int i2) {
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.f9434a.getPackageManager();
            for (int i3 = 1000; i3 <= 19999; i3++) {
                String[] strArr = null;
                try {
                    strArr = packageManager.getPackagesForUid(i3);
                } catch (Exception unused) {
                }
                if (strArr != null) {
                    for (String str : strArr) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (i2 != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                v vVar = new v(packageInfo, this.f9434a);
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
