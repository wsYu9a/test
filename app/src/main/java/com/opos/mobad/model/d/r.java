package com.opos.mobad.model.d;

import android.text.TextUtils;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class r {

    /* renamed from: a */
    private Map<String, Integer> f21638a;

    /* renamed from: b */
    private Integer[] f21639b;

    /* renamed from: c */
    private String f21640c;

    /* renamed from: d */
    private Map<String, Integer> f21641d;

    /* renamed from: e */
    private Integer[] f21642e;

    /* renamed from: f */
    private String f21643f;

    /* renamed from: g */
    private Map<String, Integer> f21644g;

    /* renamed from: h */
    private Integer[] f21645h;

    /* renamed from: i */
    private HashMap<String, Integer> f21646i;

    /* renamed from: j */
    private Integer[] f21647j;
    private HashMap<String, Integer> k;
    private Integer[] l;
    private JSONObject m;

    public r(y yVar, x xVar) {
        c(yVar.V);
        d(yVar.S);
        a(yVar.ba);
        a(xVar);
        com.opos.mobad.b.a.r rVar = yVar.aH;
        if (rVar != null) {
            b(rVar.f19857d);
            e(yVar.aH.f19860g);
            b(yVar.aH.f19861h);
        }
        this.m = new JSONObject();
    }

    private static final StringBuilder a(Integer[] numArr) {
        StringBuilder sb = new StringBuilder();
        if (numArr != null && numArr.length > 0) {
            for (Integer num : numArr) {
                if (num == null) {
                    sb.append(0);
                } else {
                    sb.append(num);
                }
            }
        }
        return sb;
    }

    private void a(x xVar) {
        if (xVar == null || TextUtils.isEmpty(xVar.f19904d)) {
            return;
        }
        this.f21640c = xVar.f19904d;
    }

    private void a(String str, String str2) {
        try {
            this.m.put(str, str2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("", "append fail", e2);
        }
    }

    private void a(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f21646i = new HashMap<>();
        this.f21647j = new Integer[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.f19904d)) {
                this.f21646i.put(xVar.f19904d, Integer.valueOf(i2));
            }
        }
    }

    private void b(x xVar) {
        if (xVar == null || TextUtils.isEmpty(xVar.f19904d)) {
            return;
        }
        this.f21643f = xVar.f19904d;
    }

    private void b(String str, int i2) {
        try {
            this.m.put(str, i2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("", "append fail", e2);
        }
    }

    private void b(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k = new HashMap<>();
        this.l = new Integer[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.f19904d)) {
                this.k.put(xVar.f19904d, Integer.valueOf(i2));
            }
        }
    }

    private void c(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f21638a = new HashMap();
        this.f21639b = new Integer[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.f19904d)) {
                this.f21638a.put(xVar.f19904d, Integer.valueOf(i2));
            }
        }
    }

    private void d(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f21641d = new HashMap();
        this.f21642e = new Integer[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.f19904d)) {
                this.f21641d.put(xVar.f19904d, Integer.valueOf(i2));
            }
        }
    }

    private void e(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f21644g = new HashMap();
        this.f21645h = new Integer[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.f19904d)) {
                this.f21644g.put(xVar.f19904d, Integer.valueOf(i2));
            }
        }
    }

    public String a() {
        StringBuilder a2 = a(this.f21639b);
        if (a2.length() > 0) {
            a("icL", a2.toString());
        }
        StringBuilder a3 = a(this.f21642e);
        if (a3.length() > 0) {
            a("iL", a3.toString());
        }
        StringBuilder a4 = a(this.f21645h);
        if (a4.length() > 0) {
            a("fiL", a4.toString());
        }
        StringBuilder a5 = a(this.f21647j);
        if (a5.length() > 0) {
            a("itrL", a5.toString());
        }
        StringBuilder a6 = a(this.l);
        if (a6.length() > 0) {
            a("fitrL", a6.toString());
        }
        return this.m.toString();
    }

    public void a(String str, int i2) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        String str2;
        try {
            if (str.equals(this.f21640c)) {
                str2 = com.kuaishou.weapon.p0.t.f9404d;
            } else {
                if (!str.equals(this.f21643f)) {
                    Map<String, Integer> map = this.f21641d;
                    if (map != null && (num4 = map.get(str)) != null) {
                        int intValue = num4.intValue();
                        Integer[] numArr = this.f21642e;
                        if (intValue < numArr.length) {
                            numArr[num4.intValue()] = Integer.valueOf(i2);
                        }
                    }
                    Map<String, Integer> map2 = this.f21638a;
                    if (map2 != null && (num3 = map2.get(str)) != null) {
                        int intValue2 = num3.intValue();
                        Integer[] numArr2 = this.f21639b;
                        if (intValue2 < numArr2.length) {
                            numArr2[num3.intValue()] = Integer.valueOf(i2);
                        }
                    }
                    HashMap<String, Integer> hashMap = this.f21646i;
                    if (hashMap != null && (num2 = hashMap.get(str)) != null) {
                        int intValue3 = num2.intValue();
                        Integer[] numArr3 = this.f21647j;
                        if (intValue3 < numArr3.length) {
                            numArr3[num2.intValue()] = Integer.valueOf(i2);
                        }
                    }
                    HashMap<String, Integer> hashMap2 = this.k;
                    if (hashMap2 != null && (num = hashMap2.get(str)) != null) {
                        int intValue4 = num.intValue();
                        Integer[] numArr4 = this.l;
                        if (intValue4 < numArr4.length) {
                            numArr4[num.intValue()] = Integer.valueOf(i2);
                        }
                    }
                    Map<String, Integer> map3 = this.f21644g;
                    if (map3 != null) {
                        Integer num5 = map3.get(str);
                        if (num5 != null) {
                            int intValue5 = num5.intValue();
                            Integer[] numArr5 = this.f21645h;
                            if (intValue5 < numArr5.length) {
                                numArr5[num5.intValue()] = Integer.valueOf(i2);
                            }
                        }
                        com.opos.cmn.an.f.a.b("", "unknow url:" + str);
                    }
                }
                str2 = "fi";
            }
            b(str2, i2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("", "mark url fail", e2);
        }
    }
}
