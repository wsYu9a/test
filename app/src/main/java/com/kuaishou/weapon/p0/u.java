package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.OapsKey;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a */
    public static final int f9412a = 1;

    /* renamed from: b */
    public static final int f9413b = 2;

    /* renamed from: c */
    public static final int f9414c = 4;

    /* renamed from: d */
    public static final int f9415d = 0;

    /* renamed from: e */
    public static final int f9416e = 8;

    /* renamed from: f */
    public static final int f9417f = 1;

    /* renamed from: g */
    public static final int f9418g = 3;

    /* renamed from: h */
    public static final int f9419h = 4;
    private static long o;

    /* renamed from: j */
    private Context f9421j;
    private q k;
    private t l;
    private File m;
    private Cdo n;
    private int p;
    private boolean r;
    private int q = 0;

    /* renamed from: i */
    List<Integer> f9420i = new ArrayList();
    private Map<Integer, a> s = new HashMap();

    class a {

        /* renamed from: a */
        int f9422a;

        public a(int i2) {
            this.f9422a = i2;
        }
    }

    public u(Context context, int i2, boolean z) {
        this.p = 0;
        this.r = false;
        this.f9421j = context;
        this.k = q.a(context);
        this.l = t.a(context);
        this.n = Cdo.a(context);
        this.m = new File(context.getFilesDir(), ".tmp");
        this.p = i2;
        this.r = z;
    }

    private void a(s sVar) {
        File file;
        Object obj;
        long j2;
        Object obj2;
        try {
            if (!TextUtils.isEmpty(sVar.f9400j) && sVar.f9400j.length() >= 10) {
                if (!this.m.exists()) {
                    this.m.mkdir();
                }
                File file2 = new File(this.m, sVar.f9391a + "-" + sVar.f9394d + ".tmp");
                File file3 = new File(this.m, sVar.f9391a + "-" + sVar.f9394d + ".zip");
                boolean a2 = l.a(this.f9421j).a(sVar.f9399i, file2);
                if (!a2) {
                    a2 = l.a(this.f9421j).a(sVar.f9399i, file2);
                }
                if (a2) {
                    if (file3.exists()) {
                        file3.delete();
                    }
                    int c2 = b.c(file2.getAbsolutePath(), file3.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (c2 != 0) {
                        long length = file3.exists() ? file3.length() : -1L;
                        if (file3.exists()) {
                            file3.delete();
                        }
                        HashMap hashMap = new HashMap();
                        file = file3;
                        hashMap.put(com.kwad.sdk.ranger.e.TAG, cj.p);
                        StringBuilder sb = new StringBuilder();
                        obj2 = com.kwad.sdk.ranger.e.TAG;
                        sb.append(sVar.f9391a);
                        hashMap.put(OapsKey.KEY_PAGEKEY, sb.toString());
                        hashMap.put("pv", sVar.f9394d);
                        hashMap.put("m", sVar.f9400j);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(length);
                        hashMap.put("len", sb2.toString());
                        hashMap.put(t.f9404d, ExifInterface.GPS_DIRECTION_TRUE);
                        bg.a(this.f9421j, "1002001", hashMap);
                        a2 = false;
                    } else {
                        file = file3;
                        obj2 = com.kwad.sdk.ranger.e.TAG;
                    }
                    if (c2 == 0 && file2.exists()) {
                        file2.delete();
                    }
                    obj = obj2;
                } else {
                    file = file3;
                    HashMap hashMap2 = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sVar.f9391a);
                    hashMap2.put(OapsKey.KEY_PAGEKEY, sb3.toString());
                    hashMap2.put("pv", sVar.f9394d);
                    hashMap2.put("m", sVar.f9400j);
                    obj = com.kwad.sdk.ranger.e.TAG;
                    hashMap2.put(obj, "download fail");
                    hashMap2.put(t.f9404d, ExifInterface.GPS_DIRECTION_TRUE);
                    bg.a(this.f9421j, "1002001", hashMap2);
                    this.s.put(Integer.valueOf(sVar.f9391a), new a(3));
                }
                String a3 = f.a(file);
                if (a2 && sVar.f9400j.equals(a3)) {
                    dm.a(file.getAbsolutePath(), Boolean.TRUE);
                    sVar.f9395e = file.getAbsolutePath();
                    if (this.k.a(sVar, (String) null, (String) null)) {
                        Map<Integer, a> map = this.s;
                        if (map != null && !map.containsKey(Integer.valueOf(sVar.f9391a))) {
                            this.s.put(Integer.valueOf(sVar.f9391a), new a(1));
                        }
                        this.n.a(Cdo.f9298b, System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, a> map2 = this.s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(sVar.f9391a))) {
                        this.s.put(Integer.valueOf(sVar.f9391a), new a(4));
                    }
                    this.k.a(sVar.f9391a, sVar.f9394d, (PackageInfo) null);
                    return;
                }
                if (file2.exists()) {
                    j2 = file2.length();
                    file2.delete();
                } else {
                    j2 = -1;
                }
                this.k.a(sVar.f9391a, sVar.f9394d, (PackageInfo) null);
                HashMap hashMap3 = new HashMap();
                hashMap3.put(obj, cj.q);
                hashMap3.put("ret", a2 ? "1" : "0");
                hashMap3.put("am", sVar.f9400j);
                hashMap3.put("acm", a3);
                hashMap3.put("p", file.getAbsolutePath());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(j2);
                hashMap3.put("len", sb4.toString());
                hashMap3.put(t.f9404d, ExifInterface.GPS_DIRECTION_TRUE);
                bg.a(this.f9421j, "1002001", hashMap3);
                return;
            }
            this.k.a(sVar.f9391a, sVar.f9394d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.k.a(sVar.f9391a, sVar.f9394d, (PackageInfo) null);
        }
    }

    public JSONObject a() {
        try {
            String str = ct.f9230a + ct.f9236g;
            String a2 = cu.a(this.f9421j);
            if (!TextUtils.isEmpty(a2)) {
                str = str + "?" + a2;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c2 = cu.c(this.f9421j);
            if (c2 != null) {
                jSONObject.put(MiConfigSingleton.t0, new bm(this.f9421j).c(c2.toString()));
            }
            l a3 = l.a(this.f9421j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(a3.a(mVar));
            int optInt = jSONObject2.optInt("result", 0);
            if (optInt != 1) {
                if (optInt != -7) {
                    return null;
                }
                Cdo.a(this.f9421j).a(Cdo.f9297a, 1, false);
                return null;
            }
            String a4 = new bm(this.f9421j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(a4)) {
                if (this.q == 0) {
                    this.q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(a4);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            Cdo cdo = this.n;
            if (cdo == null) {
                return null;
            }
            cdo.a(Cdo.f9298b, System.currentTimeMillis(), true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z;
        String str;
        try {
            try {
                synchronized (u.class) {
                    int i2 = this.p;
                    if (i2 == 1 || i2 == 2 || i2 == 4 || this.r || System.currentTimeMillis() - o >= com.alipay.mobilesecuritysdk.constant.a.k) {
                        this.l.d();
                        o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.n.a(Cdo.f9298b)) - (this.n.a(Cdo.f9299c, 6) * 3600000) > 0) {
                            List<s> a2 = this.l.a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject a3 = a();
                            if (a3 == null) {
                                throw new Exception("pluginJsonObject is null ");
                            }
                            boolean z2 = false;
                            try {
                                boolean b2 = dl.b(this.f9421j);
                                Iterator<String> keys = a3.keys();
                                HashSet hashSet = new HashSet();
                                boolean z3 = false;
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (b2 && next.endsWith("64")) {
                                        if (next.length() > 3) {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            str = next.substring(0, next.length() - 3) + ".32";
                                            hashSet.add(str);
                                            z3 = true;
                                        } else {
                                            z3 = true;
                                        }
                                    } else if (b2 || !next.endsWith("32")) {
                                        if (b2 && next.endsWith("v8")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                str = next.substring(0, next.length() - 3) + ".v7";
                                                hashSet.add(str);
                                                z3 = true;
                                            }
                                        } else if (!b2 && next.endsWith("v7")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                            }
                                        }
                                        z3 = true;
                                    } else if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".64";
                                        hashSet.add(str);
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                }
                                if (z3) {
                                    Iterator it2 = hashSet.iterator();
                                    while (it2.hasNext()) {
                                        a3.remove((String) it2.next());
                                    }
                                }
                                z2 = z3;
                            } catch (Throwable unused) {
                            }
                            Iterator<String> keys2 = a3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                s a4 = o.a(a3.optJSONObject(next2));
                                if (a4 != null) {
                                    if (z2 && !a4.y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                        a4.y = true;
                                    }
                                    if (a4.v) {
                                        arrayList4.add(next2);
                                    }
                                    if (!a4.y) {
                                        arrayList3.add(a4);
                                    }
                                    int indexOf = a2.indexOf(a4);
                                    if (indexOf < 0 || !a4.y) {
                                        it = keys2;
                                        jSONObject = a3;
                                        z = z2;
                                        if (a4.y) {
                                            arrayList2.add(a4);
                                        }
                                    } else {
                                        s sVar = a2.get(indexOf);
                                        if (dm.b(a4.f9394d, sVar.f9394d)) {
                                            int i3 = a4.x;
                                            if (i3 != sVar.x) {
                                                this.l.c(a4.f9391a, i3);
                                            }
                                            if (!this.l.d(a4.f9391a)) {
                                                arrayList2.add(a4);
                                            }
                                            it = keys2;
                                            jSONObject = a3;
                                            z = z2;
                                        } else {
                                            jSONObject = a3;
                                            z = z2;
                                            it = keys2;
                                            this.n.a(Cdo.f9298b, System.currentTimeMillis(), true);
                                            int i4 = a4.x;
                                            if (i4 != sVar.x) {
                                                this.l.c(a4.f9391a, i4);
                                            }
                                            arrayList.add(a4);
                                        }
                                        a2.remove(indexOf);
                                    }
                                    a3 = jSONObject;
                                    z2 = z;
                                    keys2 = it;
                                }
                            }
                            for (s sVar2 : a2) {
                                if (!arrayList4.contains(sVar2.f9393c)) {
                                    List<Integer> list = this.f9420i;
                                    if (list != null) {
                                        list.add(Integer.valueOf(sVar2.f9391a));
                                    }
                                    this.k.a(sVar2.f9393c);
                                }
                            }
                            for (s sVar3 : arrayList3) {
                                if (!arrayList4.contains(sVar3.f9393c)) {
                                    List<Integer> list2 = this.f9420i;
                                    if (list2 != null) {
                                        list2.add(Integer.valueOf(sVar3.f9391a));
                                    }
                                    this.k.a(sVar3.f9393c);
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
                                        this.k.a(sVar4.f9391a, sVar4.f9394d, (PackageInfo) null);
                                    } else if (arrayList2.contains(sVar4)) {
                                        a(sVar4);
                                    }
                                }
                            }
                        } else {
                            this.k.c();
                            this.l.b();
                        }
                    }
                }
            } catch (Throwable unused2) {
                this.k.c();
                this.l.b();
            }
        } finally {
            WeaponHI.iD();
        }
    }
}
