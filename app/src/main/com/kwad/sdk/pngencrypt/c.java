package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class c extends b {
    protected k aOE;
    protected k aOF;
    protected e aOG;
    protected int aOH = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e aOI = null;
    private long aOK = 0;
    private boolean aOL = true;
    private boolean aOM = false;
    private Set<String> aON = new HashSet();
    private long aOO = 0;
    private long aOP = 0;
    private long aOQ = 0;
    private ChunkLoadBehaviour aOS = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean aOJ = false;
    private g aOR = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aOT;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aOT = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aOT[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z10) {
    }

    private int Ls() {
        return this.aOH;
    }

    private k Lx() {
        return this.aOF;
    }

    private void gs(String str) {
        if (str.equals("IHDR")) {
            if (this.aOH < 0) {
                this.aOH = 0;
                return;
            }
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("PLTE")) {
            int i10 = this.aOH;
            if (i10 == 0 || i10 == 1) {
                this.aOH = 2;
                return;
            }
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("unexpected chunk here " + str));
            return;
        }
        if (str.equals("IDAT")) {
            int i11 = this.aOH;
            if (i11 >= 0 && i11 <= 4) {
                this.aOH = 4;
                return;
            }
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("IEND")) {
            if (this.aOH >= 4) {
                this.aOH = 6;
                return;
            }
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        int i12 = this.aOH;
        if (i12 <= 1) {
            this.aOH = 1;
        } else if (i12 <= 3) {
            this.aOH = 3;
        } else {
            this.aOH = 5;
        }
    }

    private static boolean gt(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.gw(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean Ln() {
        return this.aOL;
    }

    public final boolean Lt() {
        return Ls() < 4;
    }

    public final j Lu() {
        DeflatedChunksSet Lp = Lp();
        if (Lp instanceof j) {
            return (j) Lp;
        }
        return null;
    }

    public final k Lv() {
        return this.aOE;
    }

    public final e Lw() {
        return this.aOG;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.Ll().akr.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.Ll());
            k Mg = iVar.Mg();
            this.aOE = Mg;
            this.aOF = Mg;
            if (iVar.Me()) {
                this.aOG = new e(this.aOF);
            }
            this.aOI = new com.kwad.sdk.pngencrypt.chunk.e(this.aOE);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aOl;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && gt(chunkReader.Ll().akr)) {
            this.aOK += chunkReader.Ll().len;
        }
        if (chunkReader.aOl == chunkReaderMode2 || this.aOM) {
            this.aOI.a(this.aOR.a(chunkReader.Ll(), Lv()), this.aOH);
        }
    }

    public final void aJ(long j10) {
        this.aOO = j10;
    }

    public final void aK(long j10) {
        this.aOP = j10;
    }

    public final void aL(long j10) {
        this.aOQ = j10;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i10, int i11) {
        return super.b(bArr, i10, i11);
    }

    public final void bK(boolean z10) {
        this.aOL = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i10, String str, long j10) {
        gs(str);
        super.c(i10, str, j10);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aOH != 6) {
            this.aOH = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet gq(String str) {
        return new j(str, this.aOJ, Lx(), this.aOG);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean gr(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean w(int i10, String str) {
        if (super.w(i10, str)) {
            return true;
        }
        if (this.aOO > 0 && i10 + Lo() > this.aOO) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.aOO + " offset:" + Lo() + " len=" + i10));
        }
        if (this.aON.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.gw(str)) {
            return false;
        }
        long j10 = this.aOP;
        if (j10 > 0 && i10 > j10) {
            return true;
        }
        long j11 = this.aOQ;
        if (j11 > 0 && i10 > j11 - this.aOK) {
            return true;
        }
        int i11 = AnonymousClass1.aOT[this.aOS.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.gy(str)) {
            return true;
        }
        return false;
    }
}
