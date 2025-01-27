package com.opos.mobad.f.a.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class g<T extends com.opos.mobad.ad.b> extends i<T> implements m<T> {

    /* renamed from: a */
    protected com.opos.mobad.f.a.b.a<T> f20585a;

    /* renamed from: d */
    private List<T> f20586d;

    /* renamed from: g */
    private T f20587g;

    /* renamed from: h */
    private int f20588h;

    /* renamed from: i */
    private int f20589i;

    /* renamed from: j */
    private Context f20590j;
    private AtomicBoolean k;

    public g(Context context, String str, int i2, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j2, int i3, com.opos.mobad.f.a.b.b<T> bVar, b.a aVar3) {
        super(str, i2, aVar, list, aVar2, j2, i3, bVar, aVar3);
        this.f20588h = 0;
        this.f20589i = 0;
        this.k = new AtomicBoolean(false);
        this.f20590j = context;
        this.f20585a = bVar;
        this.f20586d = new ArrayList(list.size());
        this.f20588h = com.opos.cmn.an.h.f.a.b(context);
        this.f20589i = com.opos.cmn.an.h.f.a.a(context, 57.0f);
    }

    private boolean g(int i2) {
        return i2 == 2 && this.k.get();
    }

    private void h() {
        com.opos.cmn.an.f.a.b("delegator", "clearCacheDestroyAd size =" + this.f20586d.size());
        if (this.f20586d.isEmpty()) {
            return;
        }
        Iterator<T> it = this.f20586d.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f20586d.clear();
    }

    @Override // com.opos.mobad.f.a.a.m
    public void a(int i2, int i3) {
        if (i2 == this.f20588h && i3 == this.f20589i) {
            return;
        }
        com.opos.cmn.an.f.a.a("SyncStateController", "BannerSizeChange w=" + i2 + ",h =" + i3);
        this.f20589i = i3;
        this.f20588h = i2;
        this.k.compareAndSet(false, true);
    }

    @Override // com.opos.mobad.f.a.a.i
    protected void a(e.a aVar, T t) {
        ((i) this).f20608b.put(Integer.valueOf(aVar.f23520a), t);
        ((i) this).f20609c.put(Integer.valueOf(aVar.f23520a), aVar);
    }

    @Override // com.opos.mobad.f.a.a.i
    protected void a(String str, List<Integer> list, int i2) {
        if (list == null || list.isEmpty()) {
            com.opos.cmn.an.f.a.a("SyncStateController", "error Map to load");
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            T t = ((i) this).f20608b.get(Integer.valueOf(intValue));
            if (g(intValue) || t.d() == 2) {
                com.opos.cmn.an.f.a.b("SyncStateController", "channel =" + intValue + " has loaded, need to reNew");
                e.a aVar = ((i) this).f20609c.get(Integer.valueOf(intValue));
                T b2 = this.f20585a.b(aVar, this);
                if (aVar != null && aVar.f23520a == 2 && (b2 instanceof com.opos.mobad.ad.a.a)) {
                    this.k.compareAndSet(true, false);
                    ((com.opos.mobad.ad.a.a) b2).a(com.opos.cmn.an.h.f.a.b(this.f20590j, this.f20588h), com.opos.cmn.an.h.f.a.b(this.f20590j, this.f20589i));
                }
                ((i) this).f20608b.put(Integer.valueOf(intValue), b2);
                t = b2;
            }
            if (intValue == 1) {
                t.a(str, i2);
            } else {
                t.a(str);
            }
        }
    }

    @Override // com.opos.mobad.f.a.a.i
    protected boolean a(T t, int i2) {
        if (!g(i2)) {
            return super.a((g<T>) t, i2);
        }
        com.opos.cmn.an.f.a.b("SyncStateController", "is channel enable but size change");
        return false;
    }

    @Override // com.opos.mobad.f.a.a.i
    protected boolean a(Map.Entry<Integer, T> entry, T t) {
        if (entry != null) {
            if (!com.opos.mobad.service.f.b().a(entry.getKey().intValue())) {
                return false;
            }
            if (!super.a((Map.Entry<Integer, Map.Entry<Integer, T>>) entry, (Map.Entry<Integer, T>) t) && g(entry.getKey().intValue())) {
                com.opos.cmn.an.f.a.a("SyncStateController", "channel need to load because of size changed ");
                return true;
            }
        }
        return super.a((Map.Entry<Integer, Map.Entry<Integer, T>>) entry, (Map.Entry<Integer, T>) t);
    }

    @Override // com.opos.mobad.f.a.a.i, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        if (!((i) this).f20609c.isEmpty()) {
            ((i) this).f20609c.clear();
        }
        h();
    }

    @Override // com.opos.mobad.f.a.a.i
    protected void c(String str, int i2) {
        h();
        T t = this.f20587g;
        if (t != null) {
            this.f20586d.add(t);
        }
        this.f20587g = ((i) this).f20608b.get(Integer.valueOf(i2));
        super.c(str, i2);
    }
}
