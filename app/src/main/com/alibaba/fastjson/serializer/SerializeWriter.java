package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import m5.d;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.HijrahDate;

/* loaded from: classes.dex */
public final class SerializeWriter extends Writer {
    public static final char[] DIGITS;
    static final byte[] specicalFlags_doubleQuotes;
    static final byte[] specicalFlags_singleQuotes;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    static final int[] sizeTable = {9, 99, 999, HijrahDate.MAX_VALUE_OF_ERA, 99999, 999999, 9999999, 99999999, Year.MAX_VALUE, Integer.MAX_VALUE};
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    static final char[] replaceChars = new char[93];

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i10 = 14; i10 <= 31; i10++) {
            specicalFlags_doubleQuotes[i10] = 4;
            specicalFlags_singleQuotes[i10] = 4;
        }
        for (int i11 = 127; i11 < 160; i11++) {
            specicalFlags_doubleQuotes[i11] = 4;
            specicalFlags_singleQuotes[i11] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = Typography.quote;
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    public static void getChars(long j10, int i10, char[] cArr) {
        char c10;
        if (j10 < 0) {
            j10 = -j10;
            c10 = '-';
        } else {
            c10 = 0;
        }
        while (j10 > 2147483647L) {
            long j11 = j10 / 100;
            int i11 = (int) (j10 - (((j11 << 6) + (j11 << 5)) + (j11 << 2)));
            cArr[i10 - 1] = DigitOnes[i11];
            i10 -= 2;
            cArr[i10] = DigitTens[i11];
            j10 = j11;
        }
        int i12 = (int) j10;
        while (i12 >= 65536) {
            int i13 = i12 / 100;
            int i14 = i12 - (((i13 << 6) + (i13 << 5)) + (i13 << 2));
            cArr[i10 - 1] = DigitOnes[i14];
            i10 -= 2;
            cArr[i10] = DigitTens[i14];
            i12 = i13;
        }
        while (true) {
            int i15 = (52429 * i12) >>> 19;
            int i16 = i10 - 1;
            cArr[i16] = digits[i12 - ((i15 << 3) + (i15 << 1))];
            if (i15 == 0) {
                break;
            }
            i12 = i15;
            i10 = i16;
        }
        if (c10 != 0) {
            cArr[i10 - 2] = c10;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z10) {
                    write(34);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(replaceChars[charAt2]);
                    }
                }
                if (z10) {
                    write(34);
                }
                write(58);
                return;
            }
            expandCapacity(i10);
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            int i15 = i14 + 1;
            this.count = i15;
            cArr[i14] = Typography.quote;
            int i16 = i14 + 2;
            this.count = i16;
            cArr[i15] = Typography.quote;
            this.count = i14 + 3;
            cArr[i16] = d.f28378d;
            return;
        }
        int i17 = this.count;
        int i18 = i17 + length;
        str.getChars(0, length, this.buf, i17);
        this.count = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.buf;
            char c10 = cArr2[i19];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (z11) {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr3, i20, cArr3, i19 + 2, i18 - i19);
                    char[] cArr4 = this.buf;
                    cArr4[i19] = '\\';
                    cArr4[i20] = replaceChars[c10];
                    i18++;
                    i19 = i20;
                } else {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr5 = this.buf;
                    int i21 = i19 + 1;
                    System.arraycopy(cArr5, i21, cArr5, i19 + 3, (i18 - i19) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, 1, i19);
                    char[] cArr7 = this.buf;
                    cArr7[i17] = Typography.quote;
                    cArr7[i21] = '\\';
                    i19 += 2;
                    cArr7[i19] = replaceChars[c10];
                    i18 += 2;
                    cArr7[this.count - 2] = Typography.quote;
                    z11 = true;
                }
            }
            i19++;
        }
        this.buf[this.count - 1] = d.f28378d;
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z10) {
                    write(39);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(replaceChars[charAt2]);
                    }
                }
                if (z10) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i10);
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            int i15 = i14 + 1;
            this.count = i15;
            cArr[i14] = '\'';
            int i16 = i14 + 2;
            this.count = i16;
            cArr[i15] = '\'';
            this.count = i14 + 3;
            cArr[i16] = d.f28378d;
            return;
        }
        int i17 = this.count;
        int i18 = i17 + length;
        str.getChars(0, length, this.buf, i17);
        this.count = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.buf;
            char c10 = cArr2[i19];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (z11) {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr3, i20, cArr3, i19 + 2, i18 - i19);
                    char[] cArr4 = this.buf;
                    cArr4[i19] = '\\';
                    cArr4[i20] = replaceChars[c10];
                    i18++;
                    i19 = i20;
                } else {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr5 = this.buf;
                    int i21 = i19 + 1;
                    System.arraycopy(cArr5, i21, cArr5, i19 + 3, (i18 - i19) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, 1, i19);
                    char[] cArr7 = this.buf;
                    cArr7[i17] = '\'';
                    cArr7[i21] = '\\';
                    i19 += 2;
                    cArr7[i19] = replaceChars[c10];
                    i18 += 2;
                    cArr7[this.count - 2] = '\'';
                    z11 = true;
                }
            }
            i19++;
        }
        this.buf[i10 - 1] = d.f28378d;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z10) {
        if (z10) {
            this.features = serializerFeature.mask | this.features;
        } else {
            this.features = (~serializerFeature.mask) & this.features;
        }
    }

    public void expandCapacity(int i10) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i10) {
            i10 = length;
        }
        char[] cArr2 = new char[i10];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (str == null) {
            str = "UTF-8";
        }
        try {
            return new String(this.buf, 0, this.count).getBytes(str);
        } catch (UnsupportedEncodingException e10) {
            throw new JSONException("toBytes error", e10);
        }
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i10) {
        int i11 = 1;
        int i12 = this.count + 1;
        if (i12 > this.buf.length) {
            if (this.writer != null) {
                flush();
                this.buf[this.count] = (char) i10;
                this.count = i11;
            }
            expandCapacity(i12);
        }
        i11 = i12;
        this.buf[this.count] = (char) i10;
        this.count = i11;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        boolean z10 = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c10 = z10 ? '\'' : Typography.quote;
        if (length == 0) {
            write(z10 ? "''" : "\"\"");
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i10 = (length / 3) * 3;
        int i11 = length - 1;
        int i12 = this.count;
        int i13 = (((i11 / 3) + 1) << 2) + i12;
        int i14 = i13 + 2;
        if (i14 > this.buf.length) {
            if (this.writer != null) {
                write(c10);
                int i15 = 0;
                while (i15 < i10) {
                    int i16 = i15 + 2;
                    int i17 = ((bArr[i15 + 1] & 255) << 8) | ((bArr[i15] & 255) << 16);
                    i15 += 3;
                    int i18 = i17 | (bArr[i16] & 255);
                    write(cArr[(i18 >>> 18) & 63]);
                    write(cArr[(i18 >>> 12) & 63]);
                    write(cArr[(i18 >>> 6) & 63]);
                    write(cArr[i18 & 63]);
                }
                int i19 = length - i10;
                if (i19 > 0) {
                    int i20 = ((bArr[i10] & 255) << 10) | (i19 == 2 ? (bArr[i11] & 255) << 2 : 0);
                    write(cArr[i20 >> 12]);
                    write(cArr[(i20 >>> 6) & 63]);
                    write(i19 == 2 ? cArr[i20 & 63] : '=');
                    write(61);
                }
                write(c10);
                return;
            }
            expandCapacity(i14);
        }
        this.count = i14;
        int i21 = i12 + 1;
        this.buf[i12] = c10;
        int i22 = 0;
        while (i22 < i10) {
            int i23 = i22 + 2;
            int i24 = ((bArr[i22 + 1] & 255) << 8) | ((bArr[i22] & 255) << 16);
            i22 += 3;
            int i25 = i24 | (bArr[i23] & 255);
            char[] cArr2 = this.buf;
            cArr2[i21] = cArr[(i25 >>> 18) & 63];
            cArr2[i21 + 1] = cArr[(i25 >>> 12) & 63];
            int i26 = i21 + 3;
            cArr2[i21 + 2] = cArr[(i25 >>> 6) & 63];
            i21 += 4;
            cArr2[i26] = cArr[i25 & 63];
        }
        int i27 = length - i10;
        if (i27 > 0) {
            int i28 = ((bArr[i10] & 255) << 10) | (i27 == 2 ? (bArr[i11] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i13 - 3] = cArr[i28 >> 12];
            cArr3[i13 - 2] = cArr[(i28 >>> 6) & 63];
            cArr3[i13 - 1] = i27 == 2 ? cArr[i28 & 63] : '=';
            cArr3[i13] = '=';
        }
        this.buf[i13 + 1] = c10;
    }

    public void writeFieldName(String str, boolean z10) {
        int i10 = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i10) == 0) {
            if ((i10 & SerializerFeature.QuoteFieldNames.mask) != 0) {
                writeStringWithDoubleQuote(str, d.f28378d, z10);
                return;
            } else {
                writeKeyWithDoubleQuoteIfHasSpecial(str);
                return;
            }
        }
        if ((SerializerFeature.QuoteFieldNames.mask & i10) == 0) {
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else {
            writeStringWithSingleQuote(str);
            write(58);
        }
    }

    public void writeInt(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i11 = 0;
        while ((i10 < 0 ? -i10 : i10) > sizeTable[i11]) {
            i11++;
        }
        int i12 = i11 + 1;
        if (i10 < 0) {
            i12 = i11 + 2;
        }
        int i13 = this.count + i12;
        if (i13 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i12];
                getChars(i10, i12, cArr);
                write(cArr, 0, i12);
                return;
            }
            expandCapacity(i13);
        }
        getChars(i10, i13, this.buf);
        this.count = i13;
    }

    public void writeLong(long j10) {
        if (j10 == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j11 = j10 < 0 ? -j10 : j10;
        int i10 = 1;
        long j12 = 10;
        while (true) {
            if (i10 >= 19) {
                i10 = 0;
                break;
            } else {
                if (j11 < j12) {
                    break;
                }
                j12 *= 10;
                i10++;
            }
        }
        int i11 = i10 != 0 ? i10 : 19;
        if (j10 < 0) {
            i11++;
        }
        int i12 = this.count + i11;
        if (i12 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i11];
                getChars(j10, i11, cArr);
                write(cArr, 0, i11);
                return;
            }
            expandCapacity(i12);
        }
        getChars(j10, i12, this.buf);
        this.count = i12;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
    
        if (r14 == (-1)) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
    
        r12 = r8;
        r14 = r13;
        r15 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00dd, code lost:
    
        if (r14 == (-1)) goto L314;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(java.lang.String r17, char r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char, boolean):void");
    }

    public void writeStringWithSingleQuote(String str) {
        int i10 = 0;
        if (str == null) {
            int i11 = this.count + 4;
            if (i11 > this.buf.length) {
                expandCapacity(i11);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i11;
            return;
        }
        int length = str.length();
        int i12 = this.count + length + 2;
        if (i12 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i10 < str.length()) {
                    char charAt = str.charAt(i10);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        write(replaceChars[charAt]);
                    } else {
                        write(charAt);
                    }
                    i10++;
                }
                write(39);
                return;
            }
            expandCapacity(i12);
        }
        int i13 = this.count;
        int i14 = i13 + 1;
        int i15 = i14 + length;
        char[] cArr = this.buf;
        cArr[i13] = '\'';
        str.getChars(0, length, cArr, i14);
        this.count = i12;
        char c10 = 0;
        int i16 = -1;
        for (int i17 = i14; i17 < i15; i17++) {
            char c11 = this.buf[i17];
            if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i10++;
                i16 = i17;
                c10 = c11;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.buf.length) {
            expandCapacity(i18);
        }
        this.count = i18;
        if (i10 == 1) {
            char[] cArr2 = this.buf;
            int i19 = i16 + 1;
            System.arraycopy(cArr2, i19, cArr2, i16 + 2, (i15 - i16) - 1);
            char[] cArr3 = this.buf;
            cArr3[i16] = '\\';
            cArr3[i19] = replaceChars[c10];
        } else if (i10 > 1) {
            char[] cArr4 = this.buf;
            int i20 = i16 + 1;
            System.arraycopy(cArr4, i20, cArr4, i16 + 2, (i15 - i16) - 1);
            char[] cArr5 = this.buf;
            cArr5[i16] = '\\';
            cArr5[i20] = replaceChars[c10];
            int i21 = i15 + 1;
            for (int i22 = i16 - 1; i22 >= i14; i22--) {
                char[] cArr6 = this.buf;
                char c12 = cArr6[i22];
                if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i23 = i22 + 1;
                    System.arraycopy(cArr6, i23, cArr6, i22 + 2, (i21 - i22) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i22] = '\\';
                    cArr7[i23] = replaceChars[c12];
                    i21++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > cArr.length || i11 < 0 || (i12 = i10 + i11) > cArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.count + i11;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i14 = this.count;
                    int i15 = length - i14;
                    System.arraycopy(cArr, i10, cArr2, i14, i15);
                    this.count = this.buf.length;
                    flush();
                    i11 -= i15;
                    i10 += i15;
                } while (i11 > this.buf.length);
                i13 = i11;
            }
        }
        System.arraycopy(cArr, i10, this.buf, this.count, i11);
        this.count = i13;
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i10, i11).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter(Writer writer, int i10, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i10 |= serializerFeature.mask;
        }
        this.features = i10;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c10) {
        write(c10);
        return this;
    }

    public SerializeWriter(int i10) {
        this(null, i10);
    }

    public SerializeWriter(Writer writer, int i10) {
        this.writer = writer;
        if (i10 > 0) {
            this.buf = new char[i10];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i10);
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) {
        int i12;
        int i13 = this.count + i11;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i14 = this.count;
                    int i15 = length - i14;
                    i12 = i10 + i15;
                    str.getChars(i10, i12, cArr, i14);
                    this.count = this.buf.length;
                    flush();
                    i11 -= i15;
                    if (i11 <= this.buf.length) {
                        break;
                    } else {
                        i10 = i12;
                    }
                }
                i13 = i11;
                i10 = i12;
            }
        }
        str.getChars(i10, i11 + i10, this.buf, this.count);
        this.count = i13;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(boolean z10) {
        write(z10 ? "true" : "false");
    }
}
