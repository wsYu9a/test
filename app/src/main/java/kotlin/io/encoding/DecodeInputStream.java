package kotlin.io.encoding;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.sigmob.sdk.videocache.sourcestorage.a;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@ExperimentalEncodingApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J(\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "input", "base64", "Lkotlin/io/encoding/Base64;", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferEndIndex", "", "byteBufferLength", "getByteBufferLength", "()I", "byteBufferStartIndex", "isClosed", "", "isEOF", "singleByteBuffer", "symbolBuffer", "close", "", "copyByteBufferInto", "dst", "dstOffset", a.f20681d, "decodeSymbolBufferInto", "dstEndIndex", "symbolBufferLength", "handlePaddingSymbol", "read", "destination", TypedValues.CycleType.S_WAVE_OFFSET, "readNextSymbol", "resetByteBufferIfEmpty", "shiftByteBufferToStartIfNeeded", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DecodeInputStream extends InputStream {

    @k
    private final Base64 base64;

    @k
    private final byte[] byteBuffer;
    private int byteBufferEndIndex;
    private int byteBufferStartIndex;

    @k
    private final InputStream input;
    private boolean isClosed;
    private boolean isEOF;

    @k
    private final byte[] singleByteBuffer;

    @k
    private final byte[] symbolBuffer;

    public DecodeInputStream(@k InputStream input, @k Base64 base64) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(base64, "base64");
        this.input = input;
        this.base64 = base64;
        this.singleByteBuffer = new byte[1];
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[1024];
    }

    private final void copyByteBufferInto(byte[] dst, int dstOffset, int r62) {
        byte[] bArr = this.byteBuffer;
        int i10 = this.byteBufferStartIndex;
        ArraysKt.copyInto(bArr, dst, dstOffset, i10, i10 + r62);
        this.byteBufferStartIndex += r62;
        resetByteBufferIfEmpty();
    }

    private final int decodeSymbolBufferInto(byte[] dst, int dstOffset, int dstEndIndex, int symbolBufferLength) {
        int i10 = this.byteBufferEndIndex;
        this.byteBufferEndIndex = i10 + this.base64.decodeIntoByteArray(this.symbolBuffer, this.byteBuffer, i10, 0, symbolBufferLength);
        int min = Math.min(getByteBufferLength(), dstEndIndex - dstOffset);
        copyByteBufferInto(dst, dstOffset, min);
        shiftByteBufferToStartIfNeeded();
        return min;
    }

    private final int getByteBufferLength() {
        return this.byteBufferEndIndex - this.byteBufferStartIndex;
    }

    private final int handlePaddingSymbol(int symbolBufferLength) {
        this.symbolBuffer[symbolBufferLength] = Base64.padSymbol;
        if ((symbolBufferLength & 3) != 2) {
            return symbolBufferLength + 1;
        }
        int readNextSymbol = readNextSymbol();
        if (readNextSymbol >= 0) {
            this.symbolBuffer[symbolBufferLength + 1] = (byte) readNextSymbol;
        }
        return symbolBufferLength + 2;
    }

    private final int readNextSymbol() {
        int read;
        if (!this.base64.getIsMimeScheme()) {
            return this.input.read();
        }
        do {
            read = this.input.read();
            if (read == -1) {
                break;
            }
        } while (!Base64Kt.isInMimeAlphabet(read));
        return read;
    }

    private final void resetByteBufferIfEmpty() {
        if (this.byteBufferStartIndex == this.byteBufferEndIndex) {
            this.byteBufferStartIndex = 0;
            this.byteBufferEndIndex = 0;
        }
    }

    private final void shiftByteBufferToStartIfNeeded() {
        byte[] bArr = this.byteBuffer;
        int length = bArr.length;
        int i10 = this.byteBufferEndIndex;
        if ((this.symbolBuffer.length / 4) * 3 > length - i10) {
            ArraysKt.copyInto(bArr, bArr, 0, this.byteBufferStartIndex, i10);
            this.byteBufferEndIndex -= this.byteBufferStartIndex;
            this.byteBufferStartIndex = 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.input.close();
    }

    @Override // java.io.InputStream
    public int read() {
        int i10 = this.byteBufferStartIndex;
        if (i10 < this.byteBufferEndIndex) {
            int i11 = this.byteBuffer[i10] & 255;
            this.byteBufferStartIndex = i10 + 1;
            resetByteBufferIfEmpty();
            return i11;
        }
        int read = read(this.singleByteBuffer, 0, 1);
        if (read == -1) {
            return -1;
        }
        if (read == 1) {
            return this.singleByteBuffer[0] & 255;
        }
        throw new IllegalStateException("Unreachable".toString());
    }

    @Override // java.io.InputStream
    public int read(@k byte[] destination, int r11, int r12) {
        int i10;
        boolean z10;
        boolean z11;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (r11 >= 0 && r12 >= 0 && (i10 = r11 + r12) <= destination.length) {
            if (!this.isClosed) {
                if (this.isEOF) {
                    return -1;
                }
                if (r12 == 0) {
                    return 0;
                }
                if (getByteBufferLength() >= r12) {
                    copyByteBufferInto(destination, r11, r12);
                    return r12;
                }
                int byteBufferLength = (((r12 - getByteBufferLength()) + 2) / 3) * 4;
                int i11 = r11;
                while (true) {
                    z10 = this.isEOF;
                    if (z10 || byteBufferLength <= 0) {
                        break;
                    }
                    int min = Math.min(this.symbolBuffer.length, byteBufferLength);
                    int i12 = 0;
                    while (true) {
                        z11 = this.isEOF;
                        if (z11 || i12 >= min) {
                            break;
                        }
                        int readNextSymbol = readNextSymbol();
                        if (readNextSymbol == -1) {
                            this.isEOF = true;
                        } else if (readNextSymbol != 61) {
                            this.symbolBuffer[i12] = (byte) readNextSymbol;
                            i12++;
                        } else {
                            i12 = handlePaddingSymbol(i12);
                            this.isEOF = true;
                        }
                    }
                    if (!z11 && i12 != min) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    byteBufferLength -= i12;
                    i11 += decodeSymbolBufferInto(destination, i11, i10, i12);
                }
                if (i11 == r11 && z10) {
                    return -1;
                }
                return i11 - r11;
            }
            throw new IOException("The input stream is closed.");
        }
        throw new IndexOutOfBoundsException("offset: " + r11 + ", length: " + r12 + ", buffer size: " + destination.length);
    }
}
