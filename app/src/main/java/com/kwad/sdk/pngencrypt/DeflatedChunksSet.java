package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes3.dex */
public class DeflatedChunksSet {
    protected final boolean aOJ;
    protected byte[] aOZ;
    private int aPa;
    private int aPb;
    private int aPc;
    State aPd;
    private final boolean aPe;
    private d aPf;
    private long aPg;
    private long aPh;
    int aPi;
    int aPj;
    public final String aPk;
    private Inflater inf;

    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z10, int i10, int i11, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.aPd = state;
        this.aPg = 0L;
        this.aPh = 0L;
        this.aPi = -1;
        this.aPj = -1;
        this.aPk = str;
        this.aOJ = z10;
        this.aPb = i10;
        if (i10 <= 0 || i11 < i10) {
            throw new PngjException("bad inital row len " + i10);
        }
        if (inflater != null) {
            this.inf = inflater;
            this.aPe = false;
        } else {
            this.inf = new Inflater();
            this.aPe = true;
        }
        this.aOZ = (bArr == null || bArr.length < i10) ? new byte[i11] : bArr;
        this.aPc = -1;
        this.aPd = state;
        try {
            dI(i10);
        } catch (RuntimeException e10) {
            close();
            throw e10;
        }
    }

    private boolean Ly() {
        int i10;
        try {
            if (this.aPd == State.ROW_READY) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException("invalid state"));
            }
            if (this.aPd.isDone()) {
                return false;
            }
            byte[] bArr = this.aOZ;
            if (bArr == null || bArr.length < this.aPb) {
                this.aOZ = new byte[this.aPb];
            }
            if (this.aPa < this.aPb && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.aOZ;
                    int i11 = this.aPa;
                    i10 = inflater.inflate(bArr2, i11, this.aPb - i11);
                } catch (DataFormatException e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(new PngjException("error decompressing zlib stream ", e10));
                    i10 = 0;
                }
                this.aPa += i10;
                this.aPh += i10;
            }
            State state = this.aPa == this.aPb ? State.ROW_READY : !this.inf.finished() ? State.WAITING_FOR_INPUT : this.aPa > 0 ? State.ROW_READY : State.DONE;
            this.aPd = state;
            if (state != State.ROW_READY) {
                return false;
            }
            Lz();
            return true;
        } catch (RuntimeException e11) {
            close();
            throw e11;
        }
    }

    public int LA() {
        throw new PngjException("not implemented");
    }

    public final void LB() {
        if (isDone()) {
            return;
        }
        this.aPd = State.DONE;
    }

    public final int LC() {
        return this.aPc;
    }

    public void Lz() {
    }

    public final void a(d dVar) {
        if (!this.aPk.equals(dVar.Ll().akr)) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.Ll().akr + ", expected:" + this.aPk));
        }
        this.aPf = dVar;
        int i10 = this.aPi + 1;
        this.aPi = i10;
        int i11 = this.aPj;
        if (i11 >= 0) {
            dVar.dH(i10 + i11);
        }
    }

    public final void c(byte[] bArr, int i10, int i11) {
        this.aPg += i11;
        if (i11 <= 0 || this.aPd.isDone()) {
            return;
        }
        if (this.aPd == State.ROW_READY) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i10, i11);
        if (!this.aOJ) {
            Ly();
            return;
        }
        while (Ly()) {
            dI(LA());
            isDone();
        }
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.aPd.isClosed()) {
                this.aPd = State.CLOSED;
            }
            if (!this.aPe || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final void dI(int i10) {
        this.aPa = 0;
        this.aPc++;
        if (i10 <= 0) {
            this.aPb = 0;
            LB();
        } else {
            if (this.inf.finished()) {
                this.aPb = 0;
                LB();
                return;
            }
            this.aPd = State.WAITING_FOR_INPUT;
            this.aPb = i10;
            if (this.aOJ) {
                return;
            }
            Ly();
        }
    }

    public final boolean gu(String str) {
        if (this.aPd.isClosed()) {
            return false;
        }
        if (str.equals(this.aPk)) {
            return true;
        }
        if (this.aPd.isDone()) {
            if (!this.aPd.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.aPk + " set is not done");
    }

    public final boolean isClosed() {
        return this.aPd.isClosed();
    }

    public final boolean isDone() {
        return this.aPd.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aPf.Ll().akr + " state=" + this.aPd + " rows=" + this.aPc + " bytes=" + this.aPg + "/" + this.aPh).toString();
    }
}
