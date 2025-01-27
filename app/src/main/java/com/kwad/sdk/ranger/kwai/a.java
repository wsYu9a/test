package com.kwad.sdk.ranger.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@KsJson
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();
    public Object ayn;
    public String ayo;
    public String ayp;
    public boolean ayq;

    @NonNull
    public String ayr;
    public b ays;
    public a ayt;

    @KsJson
    /* renamed from: com.kwad.sdk.ranger.kwai.a$a */
    public static class C0230a extends com.kwad.sdk.core.response.kwai.a {
        public List<Object> ayA;
        public String ayu;
        public String ayv;
        public String ayw;
        public List<String> ayx;
        public List<C0230a> ayy = new ArrayList();
        public Object ayz;
        public String className;
        public String fieldName;

        private Object Cs() {
            Object obj = null;
            try {
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.d(a.TAG, Log.getStackTraceString(e2));
            }
            if (TextUtils.isEmpty(this.className)) {
                com.kwad.sdk.core.d.b.w(a.TAG, "SpecialParam className is null");
                return null;
            }
            obj = s.eA(this.className);
            com.kwad.sdk.core.d.b.d(a.TAG, "Class.forName(className):" + this.className + " value:" + obj);
            List<C0230a> list = this.ayy;
            if (list != null && !list.isEmpty()) {
                for (C0230a c0230a : this.ayy) {
                    c0230a.ayz = obj;
                    com.kwad.sdk.core.d.b.d(a.TAG, "param.ob:" + c0230a.ayz);
                    try {
                        s.a(c0230a.ayz, c0230a.fieldName, c0230a.getValue());
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.b.d(a.TAG, Log.getStackTraceString(e3));
                    }
                }
            }
            com.kwad.sdk.core.d.b.d(a.TAG, "return value in special:" + obj);
            return obj;
        }

        private Object Ct() {
            if (TextUtils.isEmpty(this.ayw)) {
                return Y(this.ayu, this.ayv);
            }
            this.ayA = new ArrayList();
            Iterator<String> it = this.ayx.iterator();
            while (it.hasNext()) {
                Object Y = Y(this.ayw, it.next());
                if (Y != null) {
                    this.ayA.add(Y);
                }
            }
            return this.ayA;
        }

        private static Object Y(String str, String str2) {
            Object obj = null;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    obj = Integer.valueOf(Integer.parseInt(str2));
                } else if (cls == Long.class) {
                    obj = Long.valueOf(Long.parseLong(str2));
                } else if (cls == Float.class) {
                    obj = Float.valueOf(Float.parseFloat(str2));
                } else if (cls == Boolean.class) {
                    obj = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (cls == Double.class) {
                    obj = Double.valueOf(Double.parseDouble(str2));
                } else {
                    if (cls != String.class) {
                        str2 = null;
                    }
                    obj = str2;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.w(a.TAG, Log.getStackTraceString(e2));
            }
            return obj;
        }

        public final Object getValue() {
            return (TextUtils.isEmpty(this.ayu) && TextUtils.isEmpty(this.ayw)) ? Cs() : Ct();
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public boolean ayB;
        public List<C0230a> ayC;
        public Object[] ayD;
        public String name;

        public final boolean Cr() {
            return TextUtils.isEmpty(this.name) && this.ayC == null && this.ayD == null;
        }

        public final Object[] Cu() {
            List<C0230a> list = this.ayC;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.ayC.size()];
            for (int i2 = 0; i2 < this.ayC.size(); i2++) {
                objArr[i2] = this.ayC.get(i2).getValue();
            }
            return objArr;
        }
    }

    public final boolean Cr() {
        if (this.ayn != null || !TextUtils.isEmpty(this.ayo) || !TextUtils.isEmpty(this.ayp) || !TextUtils.isEmpty(this.ayr)) {
            return false;
        }
        b bVar = this.ays;
        if (bVar != null && !bVar.Cr()) {
            return false;
        }
        a aVar = this.ayt;
        return aVar == null || aVar.Cr();
    }
}
