package com.kwad.components.core.q;

/* loaded from: classes3.dex */
public class a {
    private static volatile a UZ;
    private int Re;
    private int Va;
    private boolean Vb;
    private boolean Vc;
    private int Vd;
    private boolean Ve;

    private a() {
    }

    public static a rJ() {
        if (UZ == null) {
            synchronized (a.class) {
                try {
                    if (UZ == null) {
                        UZ = new a();
                    }
                } finally {
                }
            }
        }
        return UZ;
    }

    public final void aI(int i10) {
        this.Va = i10;
    }

    public final void aJ(int i10) {
        this.Vd = i10;
    }

    public final void aK(int i10) {
        this.Re = i10;
    }

    public final void aL(boolean z10) {
        this.Vb = true;
    }

    public final void aM(boolean z10) {
        this.Vc = z10;
    }

    public final void aN(boolean z10) {
        this.Ve = z10;
    }

    public final void clear() {
        this.Vc = false;
        this.Vb = false;
        this.Vd = 0;
        this.Ve = false;
        this.Va = -1;
        this.Re = 0;
    }

    public final int rK() {
        return this.Va;
    }

    public final boolean rL() {
        return this.Vb;
    }

    public final boolean rM() {
        return this.Vc;
    }

    public final boolean rN() {
        int i10 = this.Vd;
        return i10 == 1 || i10 == 3;
    }

    public final int rO() {
        return this.Vd;
    }

    public final boolean rP() {
        return this.Ve;
    }

    public final int rQ() {
        return this.Re;
    }
}
