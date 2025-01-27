package com.opos.mobad.f.a.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class f<T extends com.opos.mobad.ad.b> extends h<T> implements m<T> {

    /* renamed from: a */
    protected com.opos.mobad.f.a.b.a<T> f20578a;

    /* renamed from: c */
    private List<T> f20579c;

    /* renamed from: d */
    private T f20580d;

    /* renamed from: g */
    private int f20581g;

    /* renamed from: h */
    private int f20582h;

    /* renamed from: i */
    private Context f20583i;

    /* renamed from: j */
    private AtomicBoolean f20584j;

    public f(Context context, String str, int i2, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.b<T> bVar, b.a aVar3) {
        super(str, i2, aVar, list, aVar2, j2, bVar, aVar3);
        this.f20580d = null;
        this.f20581g = 0;
        this.f20582h = 0;
        this.f20584j = new AtomicBoolean(false);
        this.f20583i = context;
        this.f20578a = bVar;
        this.f20579c = new ArrayList(list.size());
        this.f20581g = com.opos.cmn.an.h.f.a.b(context);
        this.f20582h = com.opos.cmn.an.h.f.a.a(context, 57.0f);
    }

    private void h() {
        com.opos.cmn.an.f.a.b("delegator", "clearCacheDestroyAd size =" + this.f20579c.size());
        if (this.f20579c.isEmpty()) {
            return;
        }
        Iterator<T> it = this.f20579c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f20579c.clear();
    }

    private boolean i(int i2) {
        return i2 == 2 && this.f20584j.get();
    }

    @Override // com.opos.mobad.f.a.a.m
    public void a(int i2, int i3) {
        if (i2 == this.f20581g && i3 == this.f20582h) {
            return;
        }
        this.f20582h = i3;
        this.f20581g = i2;
        this.f20584j.compareAndSet(false, true);
        h(2);
    }

    @Override // com.opos.mobad.f.a.a.h
    protected void a(String str, e.a aVar) {
        com.opos.cmn.an.f.a.b("SyncStateController", "loadChannelAd channel =" + aVar.f23520a);
        T t = ((h) this).f20592b.get(Integer.valueOf(aVar.f23520a));
        if (i(aVar.f23520a) || t.d() == 2) {
            com.opos.cmn.an.f.a.b("SyncStateController", "channel =" + aVar.f23520a + " has loaded, need to reNew");
            t = this.f20578a.b(aVar, this);
            if (aVar.f23520a == 2 && (t instanceof com.opos.mobad.ad.a.a)) {
                this.f20584j.compareAndSet(true, false);
                ((com.opos.mobad.ad.a.a) t).a(com.opos.cmn.an.h.f.a.b(this.f20583i, this.f20581g), com.opos.cmn.an.h.f.a.b(this.f20583i, this.f20582h));
            }
            ((h) this).f20592b.put(Integer.valueOf(aVar.f23520a), t);
        }
        if (aVar.f23520a == 1) {
            t.a(str, (int) aVar.f23522c);
        } else {
            t.a(str);
        }
    }

    @Override // com.opos.mobad.f.a.a.h
    protected boolean a(T t, int i2) {
        if (!i(i2)) {
            return super.a((f<T>) t, i2);
        }
        com.opos.cmn.an.f.a.b("SyncStateController", "is channel enable but size change");
        return false;
    }

    @Override // com.opos.mobad.f.a.a.h, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        h();
    }

    @Override // com.opos.mobad.f.a.a.h
    protected boolean b(int i2, int i3, String str) {
        if (!i(i2)) {
            return super.b(i2, i3, str);
        }
        com.opos.cmn.an.f.a.a("delegator", "interceptToStartNext :" + i2 + ",code: " + i3 + ", msg:" + str);
        a(i2, i3, str);
        return true;
    }

    @Override // com.opos.mobad.f.a.a.h
    protected void f(int i2) {
        h();
        T t = this.f20580d;
        if (t != null) {
            this.f20579c.add(t);
        }
        this.f20580d = ((h) this).f20592b.get(Integer.valueOf(i2));
        super.f(i2);
    }
}
