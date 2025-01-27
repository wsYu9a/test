package com.kwad.sdk.m.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@KsJson
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();
    public Object aRL;
    public String aRM;
    public String aRN;
    public boolean aRO;

    @NonNull
    public String aRP;
    public b aRQ;
    public a aRR;

    @KsJson
    /* renamed from: com.kwad.sdk.m.a.a$a */
    public static class C0511a extends com.kwad.sdk.core.response.a.a {
        public String aRS;
        public String aRT;
        public String aRU;
        public List<String> aRV;
        public List<C0511a> aRW = new ArrayList();
        public Object aRX;
        public List<Object> aRY;
        public String className;
        public String fieldName;

        private Object Ms() {
            Object obj = null;
            try {
            } catch (Exception e10) {
                c.d(a.TAG, Log.getStackTraceString(e10));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(a.TAG, "SpecialParam className is null");
                return null;
            }
            obj = w.gJ(this.className);
            c.d(a.TAG, "Class.forName(className):" + this.className + " value:" + obj);
            List<C0511a> list = this.aRW;
            if (list != null && !list.isEmpty()) {
                for (C0511a c0511a : this.aRW) {
                    c0511a.aRX = obj;
                    c.d(a.TAG, "param.ob:" + c0511a.aRX);
                    try {
                        w.a(c0511a.aRX, c0511a.fieldName, c0511a.getValue());
                    } catch (Exception e11) {
                        c.d(a.TAG, Log.getStackTraceString(e11));
                    }
                }
            }
            c.d(a.TAG, "return value in special:" + obj);
            return obj;
        }

        private Object Mt() {
            if (TextUtils.isEmpty(this.aRU)) {
                return an(this.aRS, this.aRT);
            }
            this.aRY = new ArrayList();
            Iterator<String> it = this.aRV.iterator();
            while (it.hasNext()) {
                Object an = an(this.aRU, it.next());
                if (an != null) {
                    this.aRY.add(an);
                }
            }
            return this.aRY;
        }

        private static Object an(String str, String str2) {
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
            } catch (Exception e10) {
                c.w(a.TAG, Log.getStackTraceString(e10));
            }
            return obj;
        }

        public final Object getValue() {
            return (TextUtils.isEmpty(this.aRS) && TextUtils.isEmpty(this.aRU)) ? Ms() : Mt();
        }
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public boolean aRZ;
        public List<C0511a> aSa;
        public Object[] aSb;
        public String name;

        public final boolean Mr() {
            if (!TextUtils.isEmpty(this.name)) {
                return false;
            }
            List<C0511a> list = this.aSa;
            return (list == null || list.isEmpty()) && this.aSb == null;
        }

        public final Object[] Mu() {
            List<C0511a> list = this.aSa;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.aSa.size()];
            for (int i10 = 0; i10 < this.aSa.size(); i10++) {
                objArr[i10] = this.aSa.get(i10).getValue();
            }
            return objArr;
        }
    }

    public final boolean Mr() {
        if (this.aRL != null || !TextUtils.isEmpty(this.aRM) || !TextUtils.isEmpty(this.aRN) || !TextUtils.isEmpty(this.aRP)) {
            return false;
        }
        b bVar = this.aRQ;
        if (bVar != null && !bVar.Mr()) {
            return false;
        }
        a aVar = this.aRR;
        return aVar == null || aVar.Mr();
    }
}
