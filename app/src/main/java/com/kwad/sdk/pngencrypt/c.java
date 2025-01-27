package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class c extends b {
    protected k auQ;
    protected k auR;
    protected e auS;
    protected int auT = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e auU = null;
    private long auW = 0;
    private boolean auX = true;
    private boolean auY = false;
    private Set<String> auZ = new HashSet();
    private long ava = 0;
    private long avb = 0;
    private long avc = 0;
    private ChunkLoadBehaviour ave = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean auV = false;
    private g avd = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] avf;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            avf = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                avf[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
    }

    private int Bq() {
        return this.auT;
    }

    private k Bv() {
        return this.auR;
    }

    private void ei(String str) {
        if (str.equals("IHDR")) {
            if (this.auT < 0) {
                this.auT = 0;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("PLTE")) {
            int i2 = this.auT;
            if (i2 == 0 || i2 == 1) {
                this.auT = 2;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk here " + str));
            return;
        }
        if (str.equals("IDAT")) {
            int i3 = this.auT;
            if (i3 >= 0 && i3 <= 4) {
                this.auT = 4;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("IEND")) {
            if (this.auT >= 4) {
                this.auT = 6;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        int i4 = this.auT;
        if (i4 <= 1) {
            this.auT = 1;
        } else if (i4 <= 3) {
            this.auT = 3;
        } else {
            this.auT = 5;
        }
    }

    private static boolean ej(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.em(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean Bl() {
        return this.auX;
    }

    public final boolean Br() {
        return Bq() < 4;
    }

    public final j Bs() {
        DeflatedChunksSet Bn = Bn();
        if (Bn instanceof j) {
            return (j) Bn;
        }
        return null;
    }

    public final k Bt() {
        return this.auQ;
    }

    public final e Bu() {
        return this.auS;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.Bj().awG.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.Bj());
            k Ce = iVar.Ce();
            this.auQ = Ce;
            this.auR = Ce;
            if (iVar.Cc()) {
                this.auS = new e(this.auR);
            }
            this.auU = new com.kwad.sdk.pngencrypt.chunk.e(this.auQ);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aux;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && ej(chunkReader.Bj().awG)) {
            this.auW += chunkReader.Bj().len;
        }
        if (chunkReader.aux == chunkReaderMode2 || this.auY) {
            try {
                this.auU.a(this.avd.a(chunkReader.Bj(), Bt()), this.auT);
            } catch (PngjException e2) {
                throw e2;
            }
        }
    }

    public final void ab(long j2) {
        this.ava = j2;
    }

    public final void ac(long j2) {
        this.avb = j2;
    }

    public final void ad(long j2) {
        this.avc = j2;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i2, int i3) {
        return super.b(bArr, i2, i3);
    }

    public final void bn(boolean z) {
        this.auX = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void c(int i2, String str, long j2) {
        ei(str);
        super.c(i2, str, j2);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.auT != 6) {
            this.auT = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final DeflatedChunksSet eg(String str) {
        return new j(str, this.auV, Bv(), this.auS);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean eh(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean l(int i2, String str) {
        if (super.l(i2, str)) {
            return true;
        }
        if (this.ava > 0 && i2 + Bm() > this.ava) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.ava + " offset:" + Bm() + " len=" + i2));
        }
        if (this.auZ.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.em(str)) {
            return false;
        }
        long j2 = this.avb;
        if (j2 > 0 && i2 > j2) {
            return true;
        }
        long j3 = this.avc;
        if (j3 > 0 && i2 > j3 - this.auW) {
            return true;
        }
        int i3 = AnonymousClass1.avf[this.ave.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.eo(str)) {
            return true;
        }
        return false;
    }
}
