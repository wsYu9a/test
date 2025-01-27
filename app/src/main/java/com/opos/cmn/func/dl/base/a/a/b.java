package com.opos.cmn.func.dl.base.a.a;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private static final Object f17231a = new Object();

    /* renamed from: b */
    private a f17232b;

    /* renamed from: c */
    private int f17233c;

    public final a a() {
        synchronized (f17231a) {
            a aVar = this.f17232b;
            if (aVar == null) {
                return new a();
            }
            this.f17232b = aVar.f17230f;
            aVar.f17230f = null;
            this.f17233c--;
            return aVar;
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.f17228d = 0L;
        aVar.f17225a = 0;
        aVar.f17226b = 0;
        aVar.f17227c = 0;
        aVar.f17230f = null;
        synchronized (f17231a) {
            int i2 = this.f17233c;
            if (i2 < 100) {
                aVar.f17230f = this.f17232b;
                this.f17232b = aVar;
                this.f17233c = i2 + 1;
            }
        }
    }
}
