package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
class F implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24951a;

    /* renamed from: b */
    final /* synthetic */ int f24952b;

    /* renamed from: c */
    final /* synthetic */ H f24953c;

    F(H h2, int i2, int i3) {
        this.f24953c = h2;
        this.f24951a = i2;
        this.f24952b = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        List<E> c2;
        Map map;
        Map map2;
        String str2;
        Map map3;
        String str3;
        E e2;
        String str4;
        String str5;
        String str6;
        Map map4;
        String str7;
        Map map5;
        try {
            str = this.f24953c.f24959d;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c2 = this.f24953c.c(this.f24951a);
            if (c2 == null) {
                c2 = new ArrayList();
            }
            map = this.f24953c.f24960e;
            if (map.get(Integer.valueOf(this.f24951a)) == null) {
                HashMap hashMap = new HashMap();
                map5 = this.f24953c.f24960e;
                map5.put(Integer.valueOf(this.f24951a), hashMap);
            }
            map2 = this.f24953c.f24960e;
            Map map6 = (Map) map2.get(Integer.valueOf(this.f24951a));
            str2 = this.f24953c.f24959d;
            if (map6.get(str2) == null) {
                e2 = new E();
                e2.f24944a = this.f24951a;
                e2.f24950g = H.f24957b;
                str6 = this.f24953c.f24959d;
                e2.f24945b = str6;
                e2.f24949f = com.tencent.bugly.crashreport.common.info.a.m().E;
                e2.f24948e = com.tencent.bugly.crashreport.common.info.a.m().l;
                e2.f24946c = System.currentTimeMillis();
                e2.f24947d = this.f24952b;
                map4 = this.f24953c.f24960e;
                Map map7 = (Map) map4.get(Integer.valueOf(this.f24951a));
                str7 = this.f24953c.f24959d;
                map7.put(str7, e2);
            } else {
                map3 = this.f24953c.f24960e;
                Map map8 = (Map) map3.get(Integer.valueOf(this.f24951a));
                str3 = this.f24953c.f24959d;
                e2 = (E) map8.get(str3);
                e2.f24947d = this.f24952b;
            }
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (E e3 : c2) {
                if (e3.f24950g == e2.f24950g && (str5 = e3.f24945b) != null && str5.equalsIgnoreCase(e2.f24945b)) {
                    z = true;
                    e3.f24947d = e2.f24947d;
                }
                String str8 = e3.f24948e;
                if ((str8 != null && !str8.equalsIgnoreCase(e2.f24948e)) || (((str4 = e3.f24949f) != null && !str4.equalsIgnoreCase(e2.f24949f)) || e3.f24947d <= 0)) {
                    arrayList.add(e3);
                }
            }
            c2.removeAll(arrayList);
            if (!z) {
                c2.add(e2);
            }
            this.f24953c.a(this.f24951a, (int) c2);
        } catch (Exception unused) {
            X.b("saveCrashRecord failed", new Object[0]);
        }
    }
}
