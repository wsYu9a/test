package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class u implements Runnable {

    /* renamed from: a */
    public static final int f11228a = 1;

    /* renamed from: b */
    public static final int f11229b = 2;

    /* renamed from: c */
    public static final int f11230c = 4;

    /* renamed from: d */
    public static final int f11231d = 0;

    /* renamed from: e */
    public static final int f11232e = 8;

    /* renamed from: f */
    public static final int f11233f = 1;

    /* renamed from: g */
    public static final int f11234g = 3;

    /* renamed from: h */
    public static final int f11235h = 4;

    /* renamed from: o */
    private static long f11236o;

    /* renamed from: j */
    private Context f11238j;

    /* renamed from: k */
    private q f11239k;

    /* renamed from: l */
    private t f11240l;

    /* renamed from: m */
    private File f11241m;

    /* renamed from: n */
    private dp f11242n;

    /* renamed from: p */
    private int f11243p;

    /* renamed from: r */
    private boolean f11245r;

    /* renamed from: q */
    private int f11244q = 0;

    /* renamed from: i */
    List<Integer> f11237i = new ArrayList();

    /* renamed from: s */
    private Map<Integer, a> f11246s = new HashMap();

    public class a {

        /* renamed from: a */
        int f11247a;

        public a(int i10) {
            this.f11247a = i10;
        }
    }

    public u(Context context, int i10, boolean z10) {
        this.f11243p = 0;
        this.f11245r = false;
        this.f11238j = context;
        this.f11239k = q.a(context);
        this.f11240l = t.a(context);
        this.f11242n = dp.a(context);
        this.f11241m = new File(context.getFilesDir(), ".tmp");
        this.f11243p = i10;
        this.f11245r = z10;
    }

    public JSONObject a() {
        try {
            String str = cu.f10966a + cu.f10972g;
            String a10 = cv.a(this.f11238j);
            if (!TextUtils.isEmpty(a10)) {
                str = str + "?" + a10;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c10 = cv.c(this.f11238j);
            if (c10 != null) {
                jSONObject.put(h3.e.f26408m, new bn(this.f11238j).c(c10.toString()));
            }
            l a11 = l.a(this.f11238j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(a11.a(mVar));
            int optInt = jSONObject2.optInt(p3.i.f29758c, 0);
            if (optInt != 1) {
                if (optInt != -7) {
                    return null;
                }
                dp.a(this.f11238j).a(dp.f11081a, 1, false);
                return null;
            }
            String a12 = new bn(this.f11238j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(a12)) {
                if (this.f11244q == 0) {
                    this.f11244q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(a12);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            dp dpVar = this.f11242n;
            if (dpVar == null) {
                return null;
            }
            dpVar.a(dp.f11082b, System.currentTimeMillis(), true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z10;
        try {
            synchronized (u.class) {
                try {
                    int i10 = this.f11243p;
                    if (i10 == 1 || i10 == 2 || i10 == 4 || this.f11245r || System.currentTimeMillis() - f11236o >= 300000) {
                        this.f11240l.d();
                        f11236o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.f11242n.a(dp.f11082b)) - (this.f11242n.a(dp.f11083c, 6) * 3600000) > 0) {
                            List<s> a10 = this.f11240l.a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject a11 = a();
                            if (a11 == null) {
                                throw new Exception("pluginJsonObject is null ");
                            }
                            boolean z11 = false;
                            try {
                                boolean b10 = dm.b(this.f11238j);
                                Iterator<String> keys = a11.keys();
                                HashSet hashSet = new HashSet();
                                boolean z12 = false;
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (b10 && next.endsWith("64")) {
                                        if (next.length() > 3) {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                            z12 = true;
                                        } else {
                                            z12 = true;
                                        }
                                    } else if (b10 || !next.endsWith("32")) {
                                        if (b10 && next.endsWith("v8")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                                z12 = true;
                                            }
                                        } else if (!b10 && next.endsWith("v7")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                            }
                                        }
                                        z12 = true;
                                    } else if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                        z12 = true;
                                    } else {
                                        z12 = true;
                                    }
                                }
                                if (z12) {
                                    Iterator it2 = hashSet.iterator();
                                    while (it2.hasNext()) {
                                        a11.remove((String) it2.next());
                                    }
                                }
                                z11 = z12;
                            } catch (Throwable unused) {
                            }
                            Iterator<String> keys2 = a11.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                s a12 = o.a(a11.optJSONObject(next2));
                                if (a12 != null) {
                                    if (z11 && !a12.f11200y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                        a12.f11200y = true;
                                    }
                                    if (a12.f11197v) {
                                        arrayList4.add(next2);
                                    }
                                    if (!a12.f11200y) {
                                        arrayList3.add(a12);
                                    }
                                    int indexOf = a10.indexOf(a12);
                                    if (indexOf < 0 || !a12.f11200y) {
                                        it = keys2;
                                        jSONObject = a11;
                                        z10 = z11;
                                        if (a12.f11200y) {
                                            arrayList2.add(a12);
                                        }
                                    } else {
                                        s sVar = a10.get(indexOf);
                                        if (dn.b(a12.f11179d, sVar.f11179d)) {
                                            int i11 = a12.f11199x;
                                            if (i11 != sVar.f11199x) {
                                                this.f11240l.c(a12.f11176a, i11);
                                            }
                                            if (!this.f11240l.d(a12.f11176a)) {
                                                arrayList2.add(a12);
                                            }
                                            it = keys2;
                                            jSONObject = a11;
                                            z10 = z11;
                                        } else {
                                            jSONObject = a11;
                                            z10 = z11;
                                            it = keys2;
                                            this.f11242n.a(dp.f11082b, System.currentTimeMillis(), true);
                                            int i12 = a12.f11199x;
                                            if (i12 != sVar.f11199x) {
                                                this.f11240l.c(a12.f11176a, i12);
                                            }
                                            arrayList.add(a12);
                                        }
                                        a10.remove(indexOf);
                                    }
                                    a11 = jSONObject;
                                    z11 = z10;
                                    keys2 = it;
                                }
                            }
                            for (s sVar2 : a10) {
                                if (!arrayList4.contains(sVar2.f11178c)) {
                                    List<Integer> list = this.f11237i;
                                    if (list != null) {
                                        list.add(Integer.valueOf(sVar2.f11176a));
                                    }
                                    this.f11239k.a(sVar2.f11178c);
                                }
                            }
                            for (s sVar3 : arrayList3) {
                                if (!arrayList4.contains(sVar3.f11178c)) {
                                    List<Integer> list2 = this.f11237i;
                                    if (list2 != null) {
                                        list2.add(Integer.valueOf(sVar3.f11176a));
                                    }
                                    this.f11239k.a(sVar3.f11178c);
                                }
                            }
                            ArrayList<s> arrayList5 = new ArrayList();
                            if (arrayList2.size() != 0) {
                                arrayList5.addAll(arrayList2);
                            }
                            if (arrayList.size() != 0) {
                                arrayList5.addAll(arrayList);
                            }
                            for (s sVar4 : arrayList5) {
                                if (sVar4 != null) {
                                    if (arrayList.contains(sVar4)) {
                                        this.f11239k.a(sVar4.f11176a, sVar4.f11179d, (PackageInfo) null);
                                    } else if (arrayList2.contains(sVar4)) {
                                        a(sVar4);
                                    }
                                }
                            }
                        } else {
                            this.f11239k.c();
                            this.f11240l.b();
                        }
                    }
                } finally {
                    WeaponHI.iD();
                }
            }
        } catch (Throwable unused2) {
            this.f11239k.c();
            this.f11240l.b();
        }
    }

    private void a(s sVar) {
        try {
            if (!TextUtils.isEmpty(sVar.f11185j) && sVar.f11185j.length() >= 10) {
                if (!this.f11241m.exists()) {
                    this.f11241m.mkdir();
                }
                File file = new File(this.f11241m, sVar.f11176a + "-" + sVar.f11179d + ".tmp");
                File file2 = new File(this.f11241m, sVar.f11176a + "-" + sVar.f11179d + p1.a.f29680b);
                boolean a10 = l.a(this.f11238j).a(sVar.f11184i, file);
                if (!a10) {
                    a10 = l.a(this.f11238j).a(sVar.f11184i, file);
                }
                if (a10) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    int c10 = b.c(file.getAbsolutePath(), file2.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (c10 != 0) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        a10 = false;
                    }
                    if (c10 == 0 && file.exists()) {
                        file.delete();
                    }
                } else {
                    this.f11246s.put(Integer.valueOf(sVar.f11176a), new a(3));
                }
                String a11 = f.a(file2);
                if (a10 && sVar.f11185j.equals(a11)) {
                    dn.a(file2.getAbsolutePath(), Boolean.TRUE);
                    sVar.f11180e = file2.getAbsolutePath();
                    if (this.f11239k.a(sVar, (String) null, (String) null)) {
                        Map<Integer, a> map = this.f11246s;
                        if (map != null && !map.containsKey(Integer.valueOf(sVar.f11176a))) {
                            this.f11246s.put(Integer.valueOf(sVar.f11176a), new a(1));
                        }
                        this.f11242n.a(dp.f11082b, System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, a> map2 = this.f11246s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(sVar.f11176a))) {
                        this.f11246s.put(Integer.valueOf(sVar.f11176a), new a(4));
                    }
                    this.f11239k.a(sVar.f11176a, sVar.f11179d, (PackageInfo) null);
                    return;
                }
                if (file.exists()) {
                    file.length();
                    file.delete();
                }
                this.f11239k.a(sVar.f11176a, sVar.f11179d, (PackageInfo) null);
                return;
            }
            this.f11239k.a(sVar.f11176a, sVar.f11179d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.f11239k.a(sVar.f11176a, sVar.f11179d, (PackageInfo) null);
        }
    }
}
