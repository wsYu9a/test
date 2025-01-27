package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ChunkReader aOA;
    private long aOB;
    private ErrorBehaviour aOC;
    private final byte[] aOr;
    private final int aOs;
    private byte[] aOt;
    private int aOu;
    protected boolean aOv;
    protected boolean aOw;
    private int aOx;
    private long aOy;
    private DeflatedChunksSet aOz;
    protected boolean closed;

    /* renamed from: com.kwad.sdk.pngencrypt.b$1 */
    public class AnonymousClass1 extends d {
        public AnonymousClass1(int i10, String str, boolean z10, long j10, DeflatedChunksSet deflatedChunksSet) {
            super(i10, str, j10, deflatedChunksSet);
        }

        @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
        public final void Lm() {
            super.Lm();
            b.this.a(this);
        }
    }

    /* renamed from: com.kwad.sdk.pngencrypt.b$2 */
    public class AnonymousClass2 extends ChunkReader {
        public AnonymousClass2(int i10, String str, long j10, ChunkReader.ChunkReaderMode chunkReaderMode) {
            super(i10, str, j10, chunkReaderMode);
        }

        @Override // com.kwad.sdk.pngencrypt.ChunkReader
        public final void Lm() {
            b.this.a(this);
        }

        @Override // com.kwad.sdk.pngencrypt.ChunkReader
        public final void a(int i10, byte[] bArr, int i11, int i12) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("should never happen"));
        }
    }

    public b() {
        this(n.LP());
    }

    private static String Lq() {
        return "IHDR";
    }

    private static String Lr() {
        return "IEND";
    }

    private ChunkReader a(String str, int i10, long j10, boolean z10) {
        return new ChunkReader(i10, str, j10, z10 ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            public AnonymousClass2(int i102, String str2, long j102, ChunkReader.ChunkReaderMode chunkReaderMode) {
                super(i102, str2, j102, chunkReaderMode);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void Lm() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i102, byte[] bArr, int i11, int i12) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    private static void h(byte[] bArr) {
        if (Arrays.equals(bArr, n.LP())) {
            return;
        }
        com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    public boolean Ln() {
        return true;
    }

    public final long Lo() {
        return this.aOy;
    }

    public final DeflatedChunksSet Lp() {
        return this.aOz;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i10, int i11) {
        if (this.closed) {
            return -1;
        }
        if (i11 == 0) {
            return 0;
        }
        if (i11 < 0) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("This should not happen. Bad length: " + i11));
        }
        if (this.aOv) {
            ChunkReader chunkReader = this.aOA;
            if (chunkReader != null && !chunkReader.isDone()) {
                int b10 = this.aOA.b(bArr, i10, i11);
                if (b10 < 0) {
                    return -1;
                }
                this.aOy += b10;
                return b10;
            }
            int i12 = this.aOu;
            int i13 = 8 - i12;
            if (i13 <= i11) {
                i11 = i13;
            }
            System.arraycopy(bArr, i10, this.aOt, i12, i11);
            int i14 = this.aOu + i11;
            this.aOu = i14;
            this.aOy += i11;
            if (i14 == 8) {
                this.aOx++;
                c(n.g(this.aOt, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aOt, 4), this.aOy - 8);
                this.aOu = 0;
            }
        } else {
            int i15 = this.aOs;
            int i16 = this.aOu;
            int i17 = i15 - i16;
            if (i17 <= i11) {
                i11 = i17;
            }
            System.arraycopy(bArr, i10, this.aOt, i16, i11);
            int i18 = this.aOu + i11;
            this.aOu = i18;
            if (i18 == this.aOs) {
                h(this.aOt);
                this.aOu = 0;
                this.aOv = true;
            }
            this.aOy += i11;
        }
        return i11;
    }

    public void c(int i10, String str, long j10) {
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.aQs.matcher(str).matches()) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i10 < 0) {
            com.kwad.sdk.core.d.c.printStackTrace(new PngjException("Bad chunk len: " + i10));
        }
        if (str.equals("IDAT")) {
            this.aOB += i10;
        }
        boolean Ln = Ln();
        boolean w10 = w(i10, str);
        boolean gr = gr(str);
        DeflatedChunksSet deflatedChunksSet = this.aOz;
        boolean gu = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aOz.gu(str);
        if (!gr || w10) {
            this.aOA = a(str, i10, j10, w10);
        } else {
            if (!gu) {
                DeflatedChunksSet deflatedChunksSet2 = this.aOz;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.d.c.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.aOz = gq(str);
            }
            this.aOA = new d(i10, str, Ln, j10, this.aOz) { // from class: com.kwad.sdk.pngencrypt.b.1
                public AnonymousClass1(int i102, String str2, boolean Ln2, long j102, DeflatedChunksSet deflatedChunksSet3) {
                    super(i102, str2, j102, deflatedChunksSet3);
                }

                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void Lm() {
                    super.Lm();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.aOA;
        if (chunkReader == null || Ln2) {
            return;
        }
        chunkReader.bJ(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aOz;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    public abstract DeflatedChunksSet gq(String str);

    public boolean gr(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aOw;
    }

    public boolean w(int i10, String str) {
        return false;
    }

    private b(byte[] bArr) {
        this.aOt = new byte[8];
        this.aOu = 0;
        this.aOv = false;
        this.aOw = false;
        this.closed = false;
        this.aOx = 0;
        this.aOy = 0L;
        this.aOC = ErrorBehaviour.STRICT;
        this.aOr = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aOs = length;
        this.aOv = length <= 0;
    }

    public void a(ChunkReader chunkReader) {
        if (this.aOx == 1 && !Lq().equals(chunkReader.Ll().akr)) {
            String str = "Bad first chunk: " + chunkReader.Ll().akr + " expected: " + Lq();
            if (this.aOC.f11979c < ErrorBehaviour.SUPER_LENIENT.f11979c) {
                com.kwad.sdk.core.d.c.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.c.d("PNG_ENCRYPT", str);
            }
        }
        Lr();
        if (chunkReader.Ll().akr.equals(Lr())) {
            this.aOw = true;
            close();
        }
    }
}
