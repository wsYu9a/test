package androidx.media3.common.util;

import androidx.annotation.Nullable;
import b5.c;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

@UnstableApi
/* loaded from: classes.dex */
public final class ParsableByteArray {
    private static final char[] CR_AND_LF = {'\r', '\n'};
    private static final char[] LF = {'\n'};
    private static final ImmutableSet<Charset> SUPPORTED_CHARSETS_FOR_READLINE = ImmutableSet.of(c.f1247a, c.f1249c, c.f1252f, c.f1250d, c.f1251e);
    private byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    private int findNextLineTerminator(Charset charset) {
        int i10;
        if (charset.equals(c.f1249c) || charset.equals(c.f1247a)) {
            i10 = 1;
        } else {
            if (!charset.equals(c.f1252f) && !charset.equals(c.f1251e) && !charset.equals(c.f1250d)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i10 = 2;
        }
        int i11 = this.position;
        while (true) {
            int i12 = this.limit;
            if (i11 >= i12 - (i10 - 1)) {
                return i12;
            }
            if ((charset.equals(c.f1249c) || charset.equals(c.f1247a)) && Util.isLinebreak(this.data[i11])) {
                return i11;
            }
            if (charset.equals(c.f1252f) || charset.equals(c.f1250d)) {
                byte[] bArr = this.data;
                if (bArr[i11] == 0 && Util.isLinebreak(bArr[i11 + 1])) {
                    return i11;
                }
            }
            if (charset.equals(c.f1251e)) {
                byte[] bArr2 = this.data;
                if (bArr2[i11 + 1] == 0 && Util.isLinebreak(bArr2[i11])) {
                    return i11;
                }
            }
            i11 += i10;
        }
    }

    private int peekCharacterAndSize(Charset charset) {
        byte d10;
        char k10;
        int i10 = 1;
        if ((charset.equals(c.f1249c) || charset.equals(c.f1247a)) && bytesLeft() >= 1) {
            d10 = (byte) Chars.d(UnsignedBytes.p(this.data[this.position]));
        } else {
            if ((charset.equals(c.f1252f) || charset.equals(c.f1250d)) && bytesLeft() >= 2) {
                byte[] bArr = this.data;
                int i11 = this.position;
                k10 = Chars.k(bArr[i11], bArr[i11 + 1]);
            } else {
                if (!charset.equals(c.f1251e) || bytesLeft() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.data;
                int i12 = this.position;
                k10 = Chars.k(bArr2[i12 + 1], bArr2[i12]);
            }
            d10 = (byte) k10;
            i10 = 2;
        }
        return (Chars.d(d10) << 16) + i10;
    }

    private char readCharacterIfInList(Charset charset, char[] cArr) {
        int peekCharacterAndSize = peekCharacterAndSize(charset);
        if (peekCharacterAndSize == 0) {
            return (char) 0;
        }
        char c10 = (char) (peekCharacterAndSize >> 16);
        if (!Chars.h(cArr, c10)) {
            return (char) 0;
        }
        this.position += peekCharacterAndSize & 65535;
        return c10;
    }

    private void skipLineTerminator(Charset charset) {
        if (readCharacterIfInList(charset, CR_AND_LF) == '\r') {
            readCharacterIfInList(charset, LF);
        }
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int capacity() {
        return this.data.length;
    }

    public void ensureCapacity(int i10) {
        if (i10 > capacity()) {
            this.data = Arrays.copyOf(this.data, i10);
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }

    public int limit() {
        return this.limit;
    }

    public char peekChar() {
        byte[] bArr = this.data;
        int i10 = this.position;
        return (char) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i10) {
        readBytes(parsableBitArray.data, 0, i10);
        parsableBitArray.setPosition(0);
    }

    @Nullable
    public String readDelimiterTerminatedString(char c10) {
        if (bytesLeft() == 0) {
            return null;
        }
        int i10 = this.position;
        while (i10 < this.limit && this.data[i10] != c10) {
            i10++;
        }
        byte[] bArr = this.data;
        int i11 = this.position;
        String fromUtf8Bytes = Util.fromUtf8Bytes(bArr, i11, i10 - i11);
        this.position = i10;
        if (i10 < this.limit) {
            this.position = i10 + 1;
        }
        return fromUtf8Bytes;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 24;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 16) | i12;
        int i15 = i10 + 3;
        this.position = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        this.position = i10 + 4;
        return (bArr[i15] & 255) | i16;
    }

    public int readInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = ((bArr[i10] & 255) << 24) >> 8;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return (bArr[i13] & 255) | i14;
    }

    @Nullable
    public String readLine() {
        return readLine(c.f1249c);
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        int i15 = i10 + 3;
        this.position = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.position = i10 + 4;
        return ((bArr[i15] & 255) << 24) | i16;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return ((bArr[i13] & 255) << 16) | i14;
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        this.position = i10 + 3;
        long j10 = (bArr[i10] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.position = i10 + 4;
        long j11 = j10 | ((bArr[r8] & 255) << 24);
        this.position = i10 + 5;
        long j12 = j11 | ((bArr[r7] & 255) << 32);
        this.position = i10 + 6;
        long j13 = j12 | ((bArr[r8] & 255) << 40);
        this.position = i10 + 7;
        long j14 = j13 | ((bArr[r7] & 255) << 48);
        this.position = i10 + 8;
        return ((bArr[r8] & 255) << 56) | j14;
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        this.position = i10 + 2;
        return (short) (((bArr[i11] & 255) << 8) | i12);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        this.position = i10 + 3;
        long j10 = (bArr[i10] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.position = i10 + 4;
        return ((bArr[r4] & 255) << 24) | j10;
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return ((bArr[i13] & 255) << 16) | i14;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readLittleEndianInt);
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        this.position = i10 + 2;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public long readLong() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        this.position = i10 + 3;
        long j10 = ((bArr[i10] & 255) << 56) | ((bArr[r2] & 255) << 48) | ((bArr[r7] & 255) << 40);
        this.position = i10 + 4;
        long j11 = j10 | ((bArr[r4] & 255) << 32);
        this.position = i10 + 5;
        long j12 = j11 | ((bArr[r7] & 255) << 24);
        this.position = i10 + 6;
        long j13 = j12 | ((bArr[r4] & 255) << 16);
        this.position = i10 + 7;
        long j14 = j13 | ((bArr[r7] & 255) << 8);
        this.position = i10 + 8;
        return (bArr[r4] & 255) | j14;
    }

    public String readNullTerminatedString(int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = this.position;
        int i12 = (i11 + i10) - 1;
        String fromUtf8Bytes = Util.fromUtf8Bytes(this.data, i11, (i12 >= this.limit || this.data[i12] != 0) ? i10 : i10 - 1);
        this.position += i10;
        return fromUtf8Bytes;
    }

    public short readShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i10 + 2;
        return (short) ((bArr[i11] & 255) | i12);
    }

    public String readString(int i10) {
        return readString(i10, c.f1249c);
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        return bArr[i10] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i10 + 2;
        int i13 = (bArr[i11] & 255) | i12;
        this.position = i10 + 4;
        return i13;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        this.position = i10 + 3;
        long j10 = ((bArr[i10] & 255) << 24) | ((bArr[r2] & 255) << 16) | ((bArr[r7] & 255) << 8);
        this.position = i10 + 4;
        return (bArr[r4] & 255) | j10;
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 16;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return (bArr[i13] & 255) | i14;
    }

    public int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readInt);
    }

    public long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException("Top bit not zero: " + readLong);
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i10 + 2;
        return (bArr[i11] & 255) | i12;
    }

    public long readUtf8EncodedLong() {
        int i10;
        int i11;
        long j10 = this.data[this.position];
        int i12 = 7;
        while (true) {
            if (i12 < 0) {
                break;
            }
            if (((1 << i12) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= r6 - 1;
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j10);
        }
        for (i10 = 1; i10 < i11; i10++) {
            if ((this.data[this.position + i10] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j10);
            }
            j10 = (j10 << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
        }
        this.position += i11;
        return j10;
    }

    @Nullable
    public Charset readUtfCharsetFromBom() {
        if (bytesLeft() >= 3) {
            byte[] bArr = this.data;
            int i10 = this.position;
            if (bArr[i10] == -17 && bArr[i10 + 1] == -69 && bArr[i10 + 2] == -65) {
                this.position = i10 + 3;
                return c.f1249c;
            }
        }
        if (bytesLeft() < 2) {
            return null;
        }
        byte[] bArr2 = this.data;
        int i11 = this.position;
        byte b10 = bArr2[i11];
        if (b10 == -2 && bArr2[i11 + 1] == -1) {
            this.position = i11 + 2;
            return c.f1250d;
        }
        if (b10 != -1 || bArr2[i11 + 1] != -2) {
            return null;
        }
        this.position = i11 + 2;
        return c.f1251e;
    }

    public void reset(int i10) {
        reset(capacity() < i10 ? new byte[i10] : this.data, i10);
    }

    public void setLimit(int i10) {
        Assertions.checkArgument(i10 >= 0 && i10 <= this.data.length);
        this.limit = i10;
    }

    public void setPosition(int i10) {
        Assertions.checkArgument(i10 >= 0 && i10 <= this.limit);
        this.position = i10;
    }

    public void skipBytes(int i10) {
        setPosition(this.position + i10);
    }

    public char peekChar(Charset charset) {
        Assertions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: " + charset);
        return (char) (peekCharacterAndSize(charset) >> 16);
    }

    @Nullable
    public String readLine(Charset charset) {
        Assertions.checkArgument(SUPPORTED_CHARSETS_FOR_READLINE.contains(charset), "Unsupported charset: " + charset);
        if (bytesLeft() == 0) {
            return null;
        }
        if (!charset.equals(c.f1247a)) {
            readUtfCharsetFromBom();
        }
        String readString = readString(findNextLineTerminator(charset) - this.position, charset);
        if (this.position == this.limit) {
            return readString;
        }
        skipLineTerminator(charset);
        return readString;
    }

    public String readString(int i10, Charset charset) {
        String str = new String(this.data, this.position, i10, charset);
        this.position += i10;
        return str;
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public ParsableByteArray(int i10) {
        this.data = new byte[i10];
        this.limit = i10;
    }

    public void readBytes(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.data, this.position, bArr, i10, i11);
        this.position += i11;
    }

    public void reset(byte[] bArr, int i10) {
        this.data = bArr;
        this.limit = i10;
        this.position = 0;
    }

    public void readBytes(ByteBuffer byteBuffer, int i10) {
        byteBuffer.put(this.data, this.position, i10);
        this.position += i10;
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    @Nullable
    public String readNullTerminatedString() {
        return readDelimiterTerminatedString((char) 0);
    }

    public ParsableByteArray(byte[] bArr, int i10) {
        this.data = bArr;
        this.limit = i10;
    }
}
