package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] auD;
    private final int auE;
    private byte[] auF;
    private int auG;
    protected boolean auH;
    protected boolean auI;
    private int auJ;
    private long auK;
    private DeflatedChunksSet auL;
    private ChunkReader auM;
    private long auN;
    private ErrorBehaviour auO;
    protected boolean closed;

    /* renamed from: com.kwad.sdk.pngencrypt.b$1 */
    final class AnonymousClass1 extends d {
        AnonymousClass1(int i2, String str, boolean z, long j2, DeflatedChunksSet deflatedChunksSet) {
            super(i2, str, j2, deflatedChunksSet);
        }

        @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
        protected final void Bk() {
            super.Bk();
            b.this.a(this);
        }
    }

    /* renamed from: com.kwad.sdk.pngencrypt.b$2 */
    final class AnonymousClass2 extends ChunkReader {
        AnonymousClass2(int i2, String str, long j2, ChunkReader.ChunkReaderMode chunkReaderMode) {
            super(i2, str, j2, chunkReaderMode);
        }

        @Override // com.kwad.sdk.pngencrypt.ChunkReader
        protected final void Bk() {
            b.this.a(this);
        }

        @Override // com.kwad.sdk.pngencrypt.ChunkReader
        protected final void a(int i2, byte[] bArr, int i3, int i4) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("should never happen"));
        }
    }

    public b() {
        this(n.BN());
    }

    private b(byte[] bArr) {
        this.auF = new byte[8];
        this.auG = 0;
        this.auH = false;
        this.auI = false;
        this.closed = false;
        this.auJ = 0;
        this.auK = 0L;
        this.auO = ErrorBehaviour.STRICT;
        this.auD = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.auE = length;
        this.auH = length <= 0;
    }

    private static String Bo() {
        return "IHDR";
    }

    private static String Bp() {
        return "IEND";
    }

    private ChunkReader a(String str, int i2, long j2, boolean z) {
        return new ChunkReader(i2, str, j2, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            AnonymousClass2(int i22, String str2, long j22, ChunkReader.ChunkReaderMode chunkReaderMode) {
                super(i22, str2, j22, chunkReaderMode);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void Bk() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void a(int i22, byte[] bArr, int i3, int i4) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    private static void h(byte[] bArr) {
        if (Arrays.equals(bArr, n.BN())) {
            return;
        }
        com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    protected boolean Bl() {
        return true;
    }

    public final long Bm() {
        return this.auK;
    }

    public final DeflatedChunksSet Bn() {
        return this.auL;
    }

    protected void a(ChunkReader chunkReader) {
        if (this.auJ == 1 && !Bo().equals(chunkReader.Bj().awG)) {
            String str = "Bad first chunk: " + chunkReader.Bj().awG + " expected: " + Bo();
            if (this.auO.f9541c < ErrorBehaviour.SUPER_LENIENT.f9541c) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", str);
            }
        }
        Bp();
        if (chunkReader.Bj().awG.equals(Bp())) {
            this.auI = true;
            close();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i2, int i3) {
        int i4;
        long j2;
        long j3;
        if (this.closed) {
            return -1;
        }
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen. Bad length: " + i3));
        }
        if (this.auH) {
            ChunkReader chunkReader = this.auM;
            if (chunkReader == null || chunkReader.isDone()) {
                int i5 = this.auG;
                int i6 = 8 - i5;
                if (i6 <= i3) {
                    i3 = i6;
                }
                System.arraycopy(bArr, i2, this.auF, i5, i3);
                int i7 = this.auG + i3;
                this.auG = i7;
                i4 = i3 + 0;
                this.auK += i3;
                if (i7 == 8) {
                    this.auJ++;
                    c(n.g(this.auF, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.auF, 4), this.auK - 8);
                    this.auG = 0;
                }
                return i4;
            }
            int b2 = this.auM.b(bArr, i2, i3);
            if (b2 < 0) {
                return -1;
            }
            i4 = b2 + 0;
            j2 = this.auK;
            j3 = b2;
        } else {
            int i8 = this.auE;
            int i9 = this.auG;
            int i10 = i8 - i9;
            if (i10 <= i3) {
                i3 = i10;
            }
            System.arraycopy(bArr, i2, this.auF, i9, i3);
            int i11 = this.auG + i3;
            this.auG = i11;
            if (i11 == this.auE) {
                h(this.auF);
                this.auG = 0;
                this.auH = true;
            }
            i4 = i3 + 0;
            j2 = this.auK;
            j3 = i3;
        }
        this.auK = j2 + j3;
        return i4;
    }

    protected void c(int i2, String str, long j2) {
        com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "New chunk: " + str + " " + i2 + " off:" + j2);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.awE.matcher(str).matches()) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk len: " + i2));
        }
        if (str.equals("IDAT")) {
            this.auN += i2;
        }
        boolean Bl = Bl();
        boolean l = l(i2, str);
        boolean eh = eh(str);
        DeflatedChunksSet deflatedChunksSet = this.auL;
        boolean ek = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.auL.ek(str);
        if (!eh || l) {
            this.auM = a(str, i2, j2, l);
        } else {
            if (!ek) {
                DeflatedChunksSet deflatedChunksSet2 = this.auL;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.d.b.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.auL = eg(str);
            }
            this.auM = new d(i2, str, Bl, j2, this.auL) { // from class: com.kwad.sdk.pngencrypt.b.1
                AnonymousClass1(int i22, String str2, boolean Bl2, long j22, DeflatedChunksSet deflatedChunksSet3) {
                    super(i22, str2, j22, deflatedChunksSet3);
                }

                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                protected final void Bk() {
                    super.Bk();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.auM;
        if (chunkReader == null || Bl2) {
            return;
        }
        chunkReader.bm(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.auL;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    protected abstract DeflatedChunksSet eg(String str);

    protected boolean eh(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.auI;
    }

    protected boolean l(int i2, String str) {
        return false;
    }
}
