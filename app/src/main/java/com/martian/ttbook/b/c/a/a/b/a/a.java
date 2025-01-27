package com.martian.ttbook.b.c.a.a.b.a;

import androidx.core.os.EnvironmentCompat;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: b */
    public e f15211b;

    /* renamed from: c */
    public d f15212c;

    /* renamed from: d */
    public com.martian.ttbook.b.c.a.a.d.b.e f15213d;

    /* renamed from: e */
    public int f15214e = 0;

    /* renamed from: f */
    public long f15215f = 0;

    /* renamed from: g */
    public boolean f15216g = false;

    /* renamed from: h */
    public boolean f15217h = true;
    public WeakReference<com.martian.ttbook.b.c.a.a.d.b.m.a> k = null;

    /* renamed from: a */
    public String f15210a = UUID.randomUUID().toString();

    /* renamed from: j */
    public Object[] f15218j = com.martian.ttbook.b.c.a.a.b.n();

    public a(d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        this.f15212c = dVar;
        this.f15213d = eVar;
    }

    public void a(i iVar) {
        new k(this.f15212c, this.f15213d).a(2).b(iVar).c(k.b.n, this.f15210a).h();
        this.f15211b.a(iVar);
    }

    public com.martian.ttbook.b.c.a.a.d.b.m.a i() {
        return null;
    }

    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = this.f15210a;
        d dVar = this.f15212c;
        objArr[1] = dVar == null ? EnvironmentCompat.MEDIA_UNKNOWN : dVar.f15675i;
        objArr[2] = Integer.valueOf(this.f15214e);
        objArr[3] = Long.valueOf(this.f15215f);
        objArr[4] = Boolean.valueOf(this.f15216g);
        objArr[5] = Boolean.valueOf(this.f15217h);
        return String.format("AdBase{adId=%s, coid=%s, clickTimes=%s, exposureTime=%s, hasExposure=%s, hasShowInvoked=%s}", objArr);
    }
}
