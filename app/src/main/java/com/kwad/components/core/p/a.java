package com.kwad.components.core.p;

/* loaded from: classes2.dex */
public class a {
    private static volatile a Pp;
    private int LY;
    private int Pq;
    private boolean Pr;
    private boolean Ps;
    private int Pt;
    private boolean Pu;

    private a() {
    }

    public static a pt() {
        if (Pp == null) {
            synchronized (a.class) {
                if (Pp == null) {
                    Pp = new a();
                }
            }
        }
        return Pp;
    }

    public final void aF(int i2) {
        this.Pq = i2;
    }

    public final void aG(int i2) {
        this.Pt = i2;
    }

    public final void aH(int i2) {
        this.LY = i2;
    }

    public final void aI(boolean z) {
        this.Pr = true;
    }

    public final void aJ(boolean z) {
        this.Ps = z;
    }

    public final void aK(boolean z) {
        this.Pu = z;
    }

    public final void clear() {
        this.Ps = false;
        this.Pr = false;
        this.Pt = 0;
        this.Pu = false;
        this.Pq = -1;
        this.LY = 0;
    }

    public final int pA() {
        return this.LY;
    }

    public final int pu() {
        return this.Pq;
    }

    public final boolean pv() {
        return this.Pr;
    }

    public final boolean pw() {
        return this.Ps;
    }

    public final boolean px() {
        int i2 = this.Pt;
        return i2 == 1 || i2 == 3;
    }

    public final int py() {
        return this.Pt;
    }

    public final boolean pz() {
        return this.Pu;
    }
}
