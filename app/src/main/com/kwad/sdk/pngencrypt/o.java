package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class o implements Closeable {
    protected ErrorBehaviour aOC = ErrorBehaviour.STRICT;
    public final k aPC;
    public final boolean aPY;
    protected final c aPZ;
    protected final a aQa;
    protected final w aQb;
    protected int aQc;
    private i<? extends Object> aQd;

    public o(InputStream inputStream, boolean z10) {
        this.aQc = -1;
        a aVar = new a(inputStream);
        this.aQa = aVar;
        boolean z11 = true;
        aVar.bI(true);
        c LV = LV();
        this.aPZ = LV;
        try {
            if (aVar.b(LV, 36) != 36) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.aPC = LV.Lv();
            if (LV.Lw() == null) {
                z11 = false;
            }
            this.aPY = z11;
            aL(5024024L);
            aJ(901001001L);
            aK(2024024L);
            this.aQb = new w(LV.aOI);
            a(m.LO());
            this.aQc = -1;
        } catch (RuntimeException e10) {
            this.aQa.close();
            this.aPZ.close();
            throw e10;
        }
    }

    private void LR() {
        while (true) {
            c cVar = this.aPZ;
            if (cVar.aOH >= 4) {
                return;
            }
            if (this.aQa.a(cVar) <= 0) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    private void LU() {
        this.aPZ.bK(false);
    }

    private static c LV() {
        return new c(false);
    }

    private void a(i<? extends Object> iVar) {
        this.aQd = iVar;
    }

    private void aJ(long j10) {
        this.aPZ.aJ(901001001L);
    }

    private void aK(long j10) {
        this.aPZ.aK(2024024L);
    }

    private void aL(long j10) {
        this.aPZ.aL(5024024L);
    }

    public final w LS() {
        if (this.aPZ.Lt()) {
            LR();
        }
        return this.aQb;
    }

    public final void LT() {
        LU();
        if (this.aPZ.Lt()) {
            LR();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aPZ);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aQa);
    }

    public final void end() {
        try {
            if (this.aPZ.Lt()) {
                LR();
            }
            if (this.aPZ.Lu() != null && !this.aPZ.Lu().isDone()) {
                this.aPZ.Lu().LB();
            }
            while (!this.aPZ.isDone() && this.aQa.a(this.aPZ) > 0) {
            }
            close();
        } catch (Throwable th2) {
            close();
            throw th2;
        }
    }

    public final String toString() {
        return this.aPC.toString() + " interlaced=" + this.aPY;
    }
}
