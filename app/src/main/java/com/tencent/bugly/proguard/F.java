package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class F implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f22592a;

    /* renamed from: b */
    final /* synthetic */ int f22593b;

    /* renamed from: c */
    final /* synthetic */ H f22594c;

    public F(H h10, int i10, int i11) {
        this.f22594c = h10;
        this.f22592a = i10;
        this.f22593b = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        List<E> c10;
        Map map;
        Map map2;
        String str2;
        Map map3;
        String str3;
        E e10;
        String str4;
        String str5;
        String str6;
        Map map4;
        String str7;
        Map map5;
        try {
            str = this.f22594c.f22600d;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c10 = this.f22594c.c(this.f22592a);
            if (c10 == null) {
                c10 = new ArrayList();
            }
            map = this.f22594c.f22601e;
            if (map.get(Integer.valueOf(this.f22592a)) == null) {
                HashMap hashMap = new HashMap();
                map5 = this.f22594c.f22601e;
                map5.put(Integer.valueOf(this.f22592a), hashMap);
            }
            map2 = this.f22594c.f22601e;
            Map map6 = (Map) map2.get(Integer.valueOf(this.f22592a));
            str2 = this.f22594c.f22600d;
            if (map6.get(str2) == null) {
                e10 = new E();
                e10.f22585a = this.f22592a;
                e10.f22591g = H.f22598b;
                str6 = this.f22594c.f22600d;
                e10.f22586b = str6;
                e10.f22590f = com.tencent.bugly.crashreport.common.info.a.m().E;
                e10.f22589e = com.tencent.bugly.crashreport.common.info.a.m().f22304l;
                e10.f22587c = System.currentTimeMillis();
                e10.f22588d = this.f22593b;
                map4 = this.f22594c.f22601e;
                Map map7 = (Map) map4.get(Integer.valueOf(this.f22592a));
                str7 = this.f22594c.f22600d;
                map7.put(str7, e10);
            } else {
                map3 = this.f22594c.f22601e;
                Map map8 = (Map) map3.get(Integer.valueOf(this.f22592a));
                str3 = this.f22594c.f22600d;
                e10 = (E) map8.get(str3);
                e10.f22588d = this.f22593b;
            }
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (E e11 : c10) {
                if (e11.f22591g == e10.f22591g && (str5 = e11.f22586b) != null && str5.equalsIgnoreCase(e10.f22586b)) {
                    e11.f22588d = e10.f22588d;
                    z10 = true;
                }
                String str8 = e11.f22589e;
                if ((str8 != null && !str8.equalsIgnoreCase(e10.f22589e)) || (((str4 = e11.f22590f) != null && !str4.equalsIgnoreCase(e10.f22590f)) || e11.f22588d <= 0)) {
                    arrayList.add(e11);
                }
            }
            c10.removeAll(arrayList);
            if (!z10) {
                c10.add(e10);
            }
            this.f22594c.a(this.f22592a, (int) c10);
        } catch (Exception unused) {
            X.b("saveCrashRecord failed", new Object[0]);
        }
    }
}
