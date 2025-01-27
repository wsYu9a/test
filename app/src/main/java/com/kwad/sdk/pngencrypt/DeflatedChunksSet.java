package com.kwad.sdk.pngencrypt;

import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public class DeflatedChunksSet {
    protected final boolean auV;
    protected byte[] avl;
    private int avm;
    private int avn;
    private int avo;
    State avp;
    private final boolean avq;
    private d avr;
    private long avs;
    private long avt;
    int avu;
    int avv;
    public final String avw;
    private Inflater inf;

    enum State {
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

    public DeflatedChunksSet(String str, boolean z, int i2, int i3, Inflater inflater, byte[] bArr) {
        boolean z2;
        State state = State.WAITING_FOR_INPUT;
        this.avp = state;
        this.avs = 0L;
        this.avt = 0L;
        this.avu = -1;
        this.avv = -1;
        this.avw = str;
        this.auV = z;
        this.avn = i2;
        if (i2 <= 0 || i3 < i2) {
            throw new PngjException("bad inital row len " + i2);
        }
        if (inflater != null) {
            this.inf = inflater;
            z2 = false;
        } else {
            this.inf = new Inflater();
            z2 = true;
        }
        this.avq = z2;
        this.avl = (bArr == null || bArr.length < i2) ? new byte[i3] : bArr;
        this.avo = -1;
        this.avp = state;
        try {
            bK(i2);
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[Catch: RuntimeException -> 0x0083, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0083, blocks: (B:2:0x0000, B:4:0x0006, B:5:0x0010, B:9:0x001a, B:11:0x001e, B:13:0x0029, B:15:0x002f, B:18:0x0037, B:19:0x0051, B:22:0x0046, B:23:0x005c, B:25:0x0062, B:26:0x0077, B:28:0x007d, B:32:0x0065, B:34:0x006d, B:35:0x0070, B:38:0x0075, B:39:0x0023), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean Bw() {
        /*
            r6 = this;
            com.kwad.sdk.pngencrypt.DeflatedChunksSet$State r0 = r6.avp     // Catch: java.lang.RuntimeException -> L83
            com.kwad.sdk.pngencrypt.DeflatedChunksSet$State r1 = com.kwad.sdk.pngencrypt.DeflatedChunksSet.State.ROW_READY     // Catch: java.lang.RuntimeException -> L83
            if (r0 != r1) goto L10
            com.kwad.sdk.pngencrypt.PngjException r0 = new com.kwad.sdk.pngencrypt.PngjException     // Catch: java.lang.RuntimeException -> L83
            java.lang.String r1 = "invalid state"
            r0.<init>(r1)     // Catch: java.lang.RuntimeException -> L83
            com.kwad.sdk.core.d.b.printStackTrace(r0)     // Catch: java.lang.RuntimeException -> L83
        L10:
            com.kwad.sdk.pngencrypt.DeflatedChunksSet$State r0 = r6.avp     // Catch: java.lang.RuntimeException -> L83
            boolean r0 = r0.isDone()     // Catch: java.lang.RuntimeException -> L83
            r1 = 0
            if (r0 == 0) goto L1a
            return r1
        L1a:
            byte[] r0 = r6.avl     // Catch: java.lang.RuntimeException -> L83
            if (r0 == 0) goto L23
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L83
            int r2 = r6.avn     // Catch: java.lang.RuntimeException -> L83
            if (r0 >= r2) goto L29
        L23:
            int r0 = r6.avn     // Catch: java.lang.RuntimeException -> L83
            byte[] r0 = new byte[r0]     // Catch: java.lang.RuntimeException -> L83
            r6.avl = r0     // Catch: java.lang.RuntimeException -> L83
        L29:
            int r0 = r6.avm     // Catch: java.lang.RuntimeException -> L83
            int r2 = r6.avn     // Catch: java.lang.RuntimeException -> L83
            if (r0 >= r2) goto L5c
            java.util.zip.Inflater r0 = r6.inf     // Catch: java.lang.RuntimeException -> L83
            boolean r0 = r0.finished()     // Catch: java.lang.RuntimeException -> L83
            if (r0 != 0) goto L5c
            java.util.zip.Inflater r0 = r6.inf     // Catch: java.util.zip.DataFormatException -> L45 java.lang.RuntimeException -> L83
            byte[] r2 = r6.avl     // Catch: java.util.zip.DataFormatException -> L45 java.lang.RuntimeException -> L83
            int r3 = r6.avm     // Catch: java.util.zip.DataFormatException -> L45 java.lang.RuntimeException -> L83
            int r4 = r6.avn     // Catch: java.util.zip.DataFormatException -> L45 java.lang.RuntimeException -> L83
            int r4 = r4 - r3
            int r0 = r0.inflate(r2, r3, r4)     // Catch: java.util.zip.DataFormatException -> L45 java.lang.RuntimeException -> L83
            goto L51
        L45:
            r0 = move-exception
            com.kwad.sdk.pngencrypt.PngjException r2 = new com.kwad.sdk.pngencrypt.PngjException     // Catch: java.lang.RuntimeException -> L83
            java.lang.String r3 = "error decompressing zlib stream "
            r2.<init>(r3, r0)     // Catch: java.lang.RuntimeException -> L83
            com.kwad.sdk.core.d.b.printStackTrace(r2)     // Catch: java.lang.RuntimeException -> L83
            r0 = 0
        L51:
            int r2 = r6.avm     // Catch: java.lang.RuntimeException -> L83
            int r2 = r2 + r0
            r6.avm = r2     // Catch: java.lang.RuntimeException -> L83
            long r2 = r6.avt     // Catch: java.lang.RuntimeException -> L83
            long r4 = (long) r0     // Catch: java.lang.RuntimeException -> L83
            long r2 = r2 + r4
            r6.avt = r2     // Catch: java.lang.RuntimeException -> L83
        L5c:
            int r0 = r6.avm     // Catch: java.lang.RuntimeException -> L83
            int r2 = r6.avn     // Catch: java.lang.RuntimeException -> L83
            if (r0 != r2) goto L65
        L62:
            com.kwad.sdk.pngencrypt.DeflatedChunksSet$State r0 = com.kwad.sdk.pngencrypt.DeflatedChunksSet.State.ROW_READY     // Catch: java.lang.RuntimeException -> L83
            goto L77
        L65:
            java.util.zip.Inflater r0 = r6.inf     // Catch: java.lang.RuntimeException -> L83
            boolean r0 = r0.finished()     // Catch: java.lang.RuntimeException -> L83
            if (r0 != 0) goto L70
            com.kwad.sdk.pngencrypt.DeflatedChunksSet$State r0 = com.kwad.sdk.pngencrypt.DeflatedChunksSet.State.WAITING_FOR_INPUT     // Catch: java.lang.RuntimeException -> L83
            goto L77
        L70:
            int r0 = r6.avm     // Catch: java.lang.RuntimeException -> L83
            if (r0 <= 0) goto L75
            goto L62
        L75:
            com.kwad.sdk.pngencrypt.DeflatedChunksSet$State r0 = com.kwad.sdk.pngencrypt.DeflatedChunksSet.State.DONE     // Catch: java.lang.RuntimeException -> L83
        L77:
            r6.avp = r0     // Catch: java.lang.RuntimeException -> L83
            com.kwad.sdk.pngencrypt.DeflatedChunksSet$State r2 = com.kwad.sdk.pngencrypt.DeflatedChunksSet.State.ROW_READY     // Catch: java.lang.RuntimeException -> L83
            if (r0 != r2) goto L82
            r6.Bx()     // Catch: java.lang.RuntimeException -> L83
            r0 = 1
            return r0
        L82:
            return r1
        L83:
            r0 = move-exception
            r6.close()
            goto L89
        L88:
            throw r0
        L89:
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.pngencrypt.DeflatedChunksSet.Bw():boolean");
    }

    public final int BA() {
        return this.avo;
    }

    protected void Bx() {
    }

    protected int By() {
        throw new PngjException("not implemented");
    }

    public final void Bz() {
        if (isDone()) {
            return;
        }
        this.avp = State.DONE;
    }

    protected final void a(d dVar) {
        if (!this.avw.equals(dVar.Bj().awG)) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.Bj().awG + ", expected:" + this.avw));
        }
        this.avr = dVar;
        int i2 = this.avu + 1;
        this.avu = i2;
        int i3 = this.avv;
        if (i3 >= 0) {
            dVar.bJ(i2 + i3);
        }
    }

    public final void bK(int i2) {
        this.avm = 0;
        this.avo++;
        if (i2 <= 0 || this.inf.finished()) {
            this.avn = 0;
            Bz();
            return;
        }
        this.avp = State.WAITING_FOR_INPUT;
        this.avn = i2;
        if (this.auV) {
            return;
        }
        Bw();
    }

    protected final void c(byte[] bArr, int i2, int i3) {
        this.avs += i3;
        if (i3 <= 0 || this.avp.isDone()) {
            return;
        }
        if (this.avp == State.ROW_READY) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i2, i3);
        if (!this.auV) {
            Bw();
            return;
        }
        while (Bw()) {
            bK(By());
            isDone();
        }
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.avp.isClosed()) {
                this.avp = State.CLOSED;
            }
            if (!this.avq || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final boolean ek(String str) {
        if (this.avp.isClosed()) {
            return false;
        }
        if (str.equals(this.avw)) {
            return true;
        }
        if (this.avp.isDone()) {
            if (!this.avp.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.avw + " set is not done");
    }

    public final boolean isClosed() {
        return this.avp.isClosed();
    }

    public final boolean isDone() {
        return this.avp.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.avr.Bj().awG + " state=" + this.avp + " rows=" + this.avo + " bytes=" + this.avs + "/" + this.avt).toString();
    }
}
