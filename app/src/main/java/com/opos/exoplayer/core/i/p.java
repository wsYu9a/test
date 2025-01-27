package com.opos.exoplayer.core.i;

import java.util.PriorityQueue;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a */
    private final Object f19055a;

    /* renamed from: b */
    private final PriorityQueue<Integer> f19056b;

    /* renamed from: c */
    private int f19057c;

    public void a(int i2) {
        synchronized (this.f19055a) {
            this.f19056b.add(Integer.valueOf(i2));
            this.f19057c = Math.max(this.f19057c, i2);
        }
    }

    public void b(int i2) {
        synchronized (this.f19055a) {
            this.f19056b.remove(Integer.valueOf(i2));
            this.f19057c = this.f19056b.isEmpty() ? Integer.MIN_VALUE : this.f19056b.peek().intValue();
            this.f19055a.notifyAll();
        }
    }
}
