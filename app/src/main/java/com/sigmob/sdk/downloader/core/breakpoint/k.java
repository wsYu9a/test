package com.sigmob.sdk.downloader.core.breakpoint;

import android.util.SparseArray;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    public final HashMap<String, Integer> f19061a;

    /* renamed from: b */
    public final SparseArray<String> f19062b;

    public k() {
        this(new HashMap(), new SparseArray());
    }

    public void a(com.sigmob.sdk.downloader.f fVar, int i10) {
        String a10 = a(fVar);
        this.f19061a.put(a10, Integer.valueOf(i10));
        this.f19062b.put(i10, a10);
    }

    public Integer b(com.sigmob.sdk.downloader.f fVar) {
        Integer num = this.f19061a.get(a(fVar));
        if (num != null) {
            return num;
        }
        return null;
    }

    public k(HashMap<String, Integer> hashMap, SparseArray<String> sparseArray) {
        this.f19061a = hashMap;
        this.f19062b = sparseArray;
    }

    public String a(com.sigmob.sdk.downloader.f fVar) {
        return fVar.e() + fVar.A() + fVar.a();
    }

    public void a(int i10) {
        String str = this.f19062b.get(i10);
        if (str != null) {
            this.f19061a.remove(str);
            this.f19062b.remove(i10);
        }
    }
}
