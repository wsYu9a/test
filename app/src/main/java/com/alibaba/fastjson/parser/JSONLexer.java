package com.alibaba.fastjson.parser;

import androidx.media3.common.C;
import b5.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;
import l5.c;
import okio.internal._BufferKt;

/* loaded from: classes.dex */
public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = 26;
    static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    protected static final int[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    private static final ThreadLocal<char[]> sbufLocal;
    protected int bp;
    public Calendar calendar;

    /* renamed from: ch */
    protected char f6309ch;
    public boolean disableCircularReferenceDetect;
    protected int eofPos;
    protected boolean exp;
    public int features;
    protected long fieldHash;
    protected boolean hasSpecial;
    protected boolean isDouble;
    protected final int len;
    public Locale locale;
    public int matchStat;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected final String text;
    public TimeZone timeZone;
    protected int token;

    static {
        int i10;
        try {
            i10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i10 = -1;
        }
        char c10 = 0;
        V6 = i10 >= 23;
        sbufLocal = new ThreadLocal<>();
        digits = new int[103];
        for (int i11 = 48; i11 <= 57; i11++) {
            digits[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            digits[i12] = i12 - 87;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            digits[i13] = i13 - 55;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            IA[CA[i14]] = i14;
        }
        IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        char c11 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c11 >= zArr.length) {
                break;
            }
            if (c11 >= 'A' && c11 <= 'Z') {
                zArr[c11] = true;
            } else if (c11 >= 'a' && c11 <= 'z') {
                zArr[c11] = true;
            } else if (c11 == '_') {
                zArr[c11] = true;
            }
            c11 = (char) (c11 + 1);
        }
        identifierFlags = new boolean[256];
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c10 >= zArr2.length) {
                return;
            }
            if (c10 >= 'A' && c10 <= 'Z') {
                zArr2[c10] = true;
            } else if (c10 >= 'a' && c10 <= 'z') {
                zArr2[c10] = true;
            } else if (c10 == '_') {
                zArr2[c10] = true;
            } else if (c10 >= '0' && c10 <= '9') {
                zArr2[c10] = true;
            }
            c10 = (char) (c10 + 1);
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean checkDate(char c10, char c11, char c12, char c13, char c14, char c15, int i10, int i11) {
        if (c10 >= '1' && c10 <= '3' && c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9') {
            if (c14 == '0') {
                if (c15 < '1' || c15 > '9') {
                    return false;
                }
            } else if (c14 != '1' || (c15 != '0' && c15 != '1' && c15 != '2')) {
                return false;
            }
            if (i10 == 48) {
                return i11 >= 49 && i11 <= 57;
            }
            if (i10 != 49 && i10 != 50) {
                return i10 == 51 && (i11 == 48 || i11 == 49);
            }
            if (i11 >= 48 && i11 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001d, code lost:
    
        if (r5 <= '4') goto L96;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkTime(char r4, char r5, char r6, char r7, char r8, char r9) {
        /*
            r0 = 57
            r1 = 0
            r2 = 48
            if (r4 != r2) goto Lc
            if (r5 < r2) goto Lb
            if (r5 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r4 != r3) goto L15
            if (r5 < r2) goto L14
            if (r5 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r4 != r3) goto L42
            if (r5 < r2) goto L42
            r4 = 52
            if (r5 <= r4) goto L20
            goto L42
        L20:
            r4 = 54
            r5 = 53
            if (r6 < r2) goto L2d
            if (r6 > r5) goto L2d
            if (r7 < r2) goto L2c
            if (r7 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r6 != r4) goto L42
            if (r7 == r2) goto L32
            return r1
        L32:
            if (r8 < r2) goto L3b
            if (r8 > r5) goto L3b
            if (r9 < r2) goto L3a
            if (r9 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r8 != r4) goto L42
            if (r9 == r2) goto L40
            return r1
        L40:
            r4 = 1
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.checkTime(char, char, char, char, char, char):boolean");
    }

    public static final byte[] decodeFast(String str, int i10, int i11) {
        int i12;
        if (i11 == 0) {
            return new byte[0];
        }
        int i13 = (i10 + i11) - 1;
        int i14 = i10;
        while (i14 < i13 && IA[str.charAt(i14)] < 0) {
            i14++;
        }
        while (i13 > 0 && IA[str.charAt(i13)] < 0) {
            i13--;
        }
        int i15 = str.charAt(i13) == '=' ? str.charAt(i13 + (-1)) == '=' ? 2 : 1 : 0;
        int i16 = (i13 - i14) + 1;
        if (i11 > 76) {
            i12 = (str.charAt(76) == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i15;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = IA;
            int i21 = i14 + 4;
            int i22 = iArr[str.charAt(i14 + 3)] | (iArr[str.charAt(i14 + 1)] << 12) | (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i14 + 2)] << 6);
            bArr[i19] = (byte) (i22 >> 16);
            int i23 = i19 + 2;
            bArr[i19 + 1] = (byte) (i22 >> 8);
            i19 += 3;
            bArr[i23] = (byte) i22;
            if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                i14 = i21;
            } else {
                i14 += 6;
                i20 = 0;
            }
        }
        if (i19 < i17) {
            int i24 = 0;
            int i25 = 0;
            while (i14 <= i13 - i15) {
                i24 |= IA[str.charAt(i14)] << (18 - (i25 * 6));
                i25++;
                i14++;
            }
            int i26 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i24 >> i26);
                i26 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    private int matchFieldHash(long j10) {
        char c10 = this.f6309ch;
        int i10 = 1;
        while (c10 != '\"' && c10 != '\'') {
            if (c10 != ' ' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '\f' && c10 != '\b') {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return 0;
            }
            int i11 = i10 + 1;
            int i12 = this.bp + i10;
            c10 = i12 >= this.len ? EOI : this.text.charAt(i12);
            i10 = i11;
        }
        int i13 = this.bp + i10;
        long j11 = -3750763034362895579L;
        while (true) {
            if (i13 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i13);
            if (charAt == c10) {
                i10 += (i13 - this.bp) - i10;
                break;
            }
            j11 = (charAt ^ j11) * 1099511628211L;
            i13++;
        }
        if (j11 != j10) {
            this.fieldHash = j11;
            this.matchStat = -2;
            return 0;
        }
        int i14 = i10 + 1;
        int i15 = this.bp + i14;
        char charAt2 = i15 >= this.len ? EOI : this.text.charAt(i15);
        while (charAt2 != ':') {
            if (charAt2 > ' ' || !(charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i16 = i14 + 1;
            int i17 = this.bp + i14;
            charAt2 = i17 >= this.len ? EOI : this.text.charAt(i17);
            i14 = i16;
        }
        return i14 + 1;
    }

    private static String readString(char[] cArr, int i10) {
        int i11;
        int i12;
        int i13 = 5;
        char[] cArr2 = new char[i10];
        int i14 = 0;
        int i15 = 0;
        while (i14 < i10) {
            char c10 = cArr[i14];
            if (c10 != '\\') {
                cArr2[i15] = c10;
                i15++;
            } else {
                int i16 = i14 + 1;
                char c11 = cArr[i16];
                if (c11 == '\"') {
                    i11 = i15 + 1;
                    cArr2[i15] = Typography.quote;
                } else if (c11 != '\'') {
                    if (c11 != 'F') {
                        if (c11 == '\\') {
                            i11 = i15 + 1;
                            cArr2[i15] = '\\';
                        } else if (c11 == 'b') {
                            i11 = i15 + 1;
                            cArr2[i15] = '\b';
                        } else if (c11 != 'f') {
                            if (c11 == 'n') {
                                i11 = i15 + 1;
                                cArr2[i15] = '\n';
                            } else if (c11 == 'r') {
                                i11 = i15 + 1;
                                cArr2[i15] = '\r';
                            } else if (c11 != 'x') {
                                switch (c11) {
                                    case '/':
                                        i11 = i15 + 1;
                                        cArr2[i15] = '/';
                                        break;
                                    case '0':
                                        i11 = i15 + 1;
                                        cArr2[i15] = 0;
                                        break;
                                    case '1':
                                        i11 = i15 + 1;
                                        cArr2[i15] = 1;
                                        break;
                                    case '2':
                                        i11 = i15 + 1;
                                        cArr2[i15] = 2;
                                        break;
                                    case '3':
                                        i11 = i15 + 1;
                                        cArr2[i15] = 3;
                                        break;
                                    case '4':
                                        i11 = i15 + 1;
                                        cArr2[i15] = 4;
                                        break;
                                    case '5':
                                        i11 = i15 + 1;
                                        cArr2[i15] = 5;
                                        break;
                                    case '6':
                                        i12 = i15 + 1;
                                        cArr2[i15] = 6;
                                        i15 = i12;
                                        i14 = i16;
                                        break;
                                    case '7':
                                        i12 = i15 + 1;
                                        cArr2[i15] = 7;
                                        i15 = i12;
                                        i14 = i16;
                                        break;
                                    default:
                                        switch (c11) {
                                            case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP /* 116 */:
                                                i12 = i15 + 1;
                                                cArr2[i15] = '\t';
                                                i15 = i12;
                                                i14 = i16;
                                                break;
                                            case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE /* 117 */:
                                                char c12 = cArr[i14 + 2];
                                                char c13 = cArr[i14 + 3];
                                                char c14 = cArr[i14 + 4];
                                                i14 += i13;
                                                cArr2[i15] = (char) Integer.parseInt(new String(new char[]{c12, c13, c14, cArr[i14]}), 16);
                                                i15++;
                                                break;
                                            case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST /* 118 */:
                                                cArr2[i15] = 11;
                                                i15++;
                                                i14 = i16;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                int[] iArr = digits;
                                int i17 = iArr[cArr[i14 + 2]] * 16;
                                i14 += 3;
                                cArr2[i15] = (char) (i17 + iArr[cArr[i14]]);
                                i15++;
                                i14++;
                                i13 = 5;
                            }
                        }
                    }
                    i11 = i15 + 1;
                    cArr2[i15] = '\f';
                } else {
                    i11 = i15 + 1;
                    cArr2[i15] = '\'';
                }
                i15 = i11;
                i14 = i16;
                i14++;
                i13 = 5;
            }
            i14++;
            i13 = 5;
        }
        return new String(cArr2, 0, i15);
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.f6309ch));
        String stringVal = stringVal();
        if (stringVal.equals("null")) {
            this.token = 8;
            return;
        }
        if (stringVal.equals("true")) {
            this.token = 6;
            return;
        }
        if (stringVal.equals("false")) {
            this.token = 7;
            return;
        }
        if (stringVal.equals("new")) {
            this.token = 9;
            return;
        }
        if (stringVal.equals("undefined")) {
            this.token = 23;
            return;
        }
        if (stringVal.equals("Set")) {
            this.token = 21;
        } else if (stringVal.equals("TreeSet")) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    private void setCalendar(char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c10 - '0') * 1000) + ((c11 - '0') * 100) + ((c12 - '0') * 10) + (c13 - '0'));
        this.calendar.set(2, (((c14 - '0') * 10) + (c15 - '0')) - 1);
        this.calendar.set(5, ((c16 - '0') * 10) + (c17 - '0'));
    }

    private final String subString(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i10 + i11, cArr, 0);
            return new String(this.sbuf, 0, i11);
        }
        char[] cArr2 = new char[i11];
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    public char charAt(int i10) {
        return i10 >= this.len ? EOI : this.text.charAt(i10);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z10) {
        if (z10) {
            this.features |= feature.mask;
        } else {
            this.features &= ~feature.mask;
        }
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z10 ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z10) {
        char[] cArr;
        boolean z11;
        int i10 = (this.np + this.sp) - 1;
        char charAt = i10 >= this.len ? EOI : this.text.charAt(i10);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z10) {
                return decimalValue();
            }
            char charAt2 = this.text.charAt((this.np + this.sp) - 1);
            int i11 = this.sp;
            if (charAt2 == 'L' || charAt2 == 'S' || charAt2 == 'B' || charAt2 == 'F' || charAt2 == 'D') {
                i11--;
            }
            int i12 = this.np;
            char[] cArr2 = this.sbuf;
            int i13 = 0;
            if (i11 < cArr2.length) {
                this.text.getChars(i12, i12 + i11, cArr2, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr3 = new char[i11];
                this.text.getChars(i12, i12 + i11, cArr3, 0);
                cArr = cArr3;
            }
            if (i11 > 9 || this.exp) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i11)));
            }
            char c10 = cArr[0];
            int i14 = 2;
            if (c10 == '-') {
                c10 = cArr[1];
                z11 = true;
            } else if (c10 == '+') {
                c10 = cArr[1];
                z11 = false;
            } else {
                z11 = false;
                i14 = 1;
            }
            int i15 = c10 - '0';
            while (i14 < i11) {
                char c11 = cArr[i14];
                if (c11 == '.') {
                    i13 = 1;
                } else {
                    i15 = (i15 * 10) + (c11 - '0');
                    if (i13 != 0) {
                        i13 *= 10;
                    }
                }
                i14++;
            }
            double d10 = i15 / i13;
            if (z11) {
                d10 = -d10;
            }
            return Double.valueOf(d10);
        } catch (NumberFormatException e10) {
            throw new JSONException(e10.getMessage() + ", " + info());
        }
    }

    public String info() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pos ");
        sb2.append(this.bp);
        sb2.append(", json : ");
        sb2.append(this.len < 65536 ? this.text : this.text.substring(0, 65536));
        return sb2.toString();
    }

    public final int intValue() {
        int i10;
        boolean z10;
        int i11 = this.np;
        int i12 = this.sp + i11;
        int i13 = 0;
        if ((i11 >= this.len ? EOI : this.text.charAt(i11)) == '-') {
            i11++;
            i10 = Integer.MIN_VALUE;
            z10 = true;
        } else {
            i10 = -2147483647;
            z10 = false;
        }
        if (i11 < i12) {
            i13 = -((i11 >= this.len ? EOI : this.text.charAt(i11)) - '0');
            i11++;
        }
        while (i11 < i12) {
            int i14 = i11 + 1;
            char charAt = i11 >= this.len ? EOI : this.text.charAt(i11);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i11 = i14;
                break;
            }
            int i15 = charAt - '0';
            if (i13 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i16 = i13 * 10;
            if (i16 < i10 + i15) {
                throw new NumberFormatException(numberString());
            }
            i13 = i16 - i15;
            i11 = i14;
        }
        if (!z10) {
            return -i13;
        }
        if (i11 > this.np + 1) {
            return i13;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() throws NumberFormatException {
        char c10;
        boolean z10;
        long j10;
        long j11;
        int i10 = this.np;
        int i11 = this.sp + i10;
        int i12 = i11 - 1;
        char charAt = i12 >= this.len ? EOI : this.text.charAt(i12);
        if (charAt == 'B') {
            i11--;
            c10 = 'B';
        } else if (charAt == 'L') {
            i11--;
            c10 = 'L';
        } else if (charAt != 'S') {
            c10 = a.O;
        } else {
            i11--;
            c10 = 'S';
        }
        int i13 = this.np;
        if ((i13 >= this.len ? EOI : this.text.charAt(i13)) == '-') {
            i10++;
            j10 = Long.MIN_VALUE;
            z10 = true;
        } else {
            z10 = false;
            j10 = C.TIME_UNSET;
        }
        if (i10 < i11) {
            j11 = -((i10 >= this.len ? EOI : this.text.charAt(i10)) - '0');
            i10++;
        } else {
            j11 = 0;
        }
        while (i10 < i11) {
            int i14 = i10 + 1;
            int charAt2 = (i10 >= this.len ? EOI : this.text.charAt(i10)) - '0';
            if (j11 < _BufferKt.OVERFLOW_ZONE) {
                return new BigInteger(numberString());
            }
            long j12 = j11 * 10;
            long j13 = charAt2;
            if (j12 < j10 + j13) {
                return new BigInteger(numberString());
            }
            j11 = j12 - j13;
            i10 = i14;
        }
        if (!z10) {
            long j14 = -j11;
            return (j14 > 2147483647L || c10 == 'L') ? Long.valueOf(j14) : c10 == 'S' ? Short.valueOf((short) j14) : c10 == 'B' ? Byte.valueOf((byte) j14) : Integer.valueOf((int) j14);
        }
        if (i10 > this.np + 1) {
            return (j11 < -2147483648L || c10 == 'L') ? Long.valueOf(j11) : c10 == 'S' ? Short.valueOf((short) j11) : c10 == 'B' ? Byte.valueOf((byte) j11) : Integer.valueOf((int) j11);
        }
        throw new NumberFormatException(numberString());
    }

    public final boolean isBlankInput() {
        int i10 = 0;
        while (true) {
            char charAt = charAt(i10);
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || !(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\f' || charAt == '\b')) {
                break;
            }
            i10++;
        }
        return false;
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005f -> B:6:0x0027). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r2 = r13.charAt(r0)
            r3 = 45
            r4 = 1
            if (r2 != r3) goto L15
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r5 = r2
            r2 = 1
            goto L1b
        L15:
            r2 = 0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L1b:
            if (r0 >= r1) goto L29
            int r3 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L27:
            r0 = r3
            goto L2b
        L29:
            r7 = 0
        L2b:
            if (r0 >= r1) goto L76
            int r3 = r0 + 1
            int r9 = r13.len
            if (r0 < r9) goto L36
            r0 = 26
            goto L3c
        L36:
            java.lang.String r9 = r13.text
            char r0 = r9.charAt(r0)
        L3c:
            r9 = 76
            if (r0 == r9) goto L75
            r9 = 83
            if (r0 == r9) goto L75
            r9 = 66
            if (r0 != r9) goto L49
            goto L75
        L49:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L6b
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r5 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L61
            long r7 = r7 - r9
            goto L27
        L61:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L6b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L75:
            r0 = r3
        L76:
            if (r2 == 0) goto L88
            int r1 = r13.np
            int r1 = r1 + r4
            if (r0 <= r1) goto L7e
            return r7
        L7e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L88:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.longValue():long");
    }

    public boolean matchField(long j10) {
        char c10 = this.f6309ch;
        int i10 = this.bp + 1;
        int i11 = 1;
        while (c10 != '\"' && c10 != '\'') {
            if (c10 > ' ' || !(c10 == ' ' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\f' || c10 == '\b')) {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return false;
            }
            int i12 = i11 + 1;
            int i13 = this.bp + i11;
            c10 = i13 >= this.len ? EOI : this.text.charAt(i13);
            i11 = i12;
        }
        int i14 = i10;
        long j11 = -3750763034362895579L;
        while (true) {
            if (i14 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i14);
            if (charAt == c10) {
                i11 += (i14 - i10) + 1;
                break;
            }
            j11 = 1099511628211L * (j11 ^ charAt);
            i14++;
        }
        if (j11 != j10) {
            this.matchStat = -2;
            this.fieldHash = j11;
            return false;
        }
        int i15 = i11 + 1;
        int i16 = this.bp + i11;
        char charAt2 = i16 >= this.len ? EOI : this.text.charAt(i16);
        while (charAt2 != ':') {
            if (charAt2 > ' ' || !(charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i17 = i15 + 1;
            int i18 = this.bp + i15;
            charAt2 = i18 >= this.len ? EOI : this.text.charAt(i18);
            i15 = i17;
        }
        int i19 = this.bp + i15;
        char charAt3 = i19 >= this.len ? EOI : this.text.charAt(i19);
        if (charAt3 == '{') {
            int i20 = i19 + 1;
            this.bp = i20;
            this.f6309ch = i20 >= this.len ? EOI : this.text.charAt(i20);
            this.token = 12;
        } else if (charAt3 == '[') {
            int i21 = i19 + 1;
            this.bp = i21;
            this.f6309ch = i21 >= this.len ? EOI : this.text.charAt(i21);
            this.token = 14;
        } else {
            this.bp = i19;
            this.f6309ch = i19 >= this.len ? EOI : this.text.charAt(i19);
            nextToken();
        }
        return true;
    }

    public char next() {
        int i10 = this.bp + 1;
        this.bp = i10;
        char charAt = i10 >= this.len ? EOI : this.text.charAt(i10);
        this.f6309ch = charAt;
        return charAt;
    }

    public final void nextIdent() {
        char c10;
        while (true) {
            c10 = this.f6309ch;
            if (c10 > ' ' || !(c10 == ' ' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\f' || c10 == '\b')) {
                break;
            } else {
                next();
            }
        }
        if (c10 == '_' || Character.isLetter(c10)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a1, code lost:
    
        if (r16.token == 20) goto L444;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
    
        r16.token = 20;
        r1 = r16.eofPos;
        r16.bp = r1;
        r16.pos = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ab, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b3, code lost:
    
        throw new com.alibaba.fastjson.JSONException("EOF error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00fe, code lost:
    
        scanIdent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0101, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void nextToken() {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.nextToken():void");
    }

    public final void nextTokenWithChar(char c10) {
        this.sp = 0;
        while (true) {
            char c11 = this.f6309ch;
            if (c11 == c10) {
                int i10 = this.bp + 1;
                this.bp = i10;
                this.f6309ch = i10 >= this.len ? EOI : this.text.charAt(i10);
                nextToken();
                return;
            }
            if (c11 != ' ' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != '\f' && c11 != '\b') {
                throw new JSONException("not match " + c10 + " - " + this.f6309ch);
            }
            next();
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i10 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        return subString(this.np, i10);
    }

    public boolean scanBoolean() {
        int i10;
        boolean z10 = false;
        if (this.text.startsWith("false", this.bp)) {
            i10 = 5;
        } else {
            if (this.text.startsWith("true", this.bp)) {
                i10 = 4;
            } else {
                char c10 = this.f6309ch;
                if (c10 == '1') {
                    i10 = 1;
                } else {
                    if (c10 != '0') {
                        this.matchStat = -1;
                        return false;
                    }
                    i10 = 1;
                }
            }
            z10 = true;
        }
        int i11 = this.bp + i10;
        this.bp = i11;
        this.f6309ch = charAt(i11);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanFieldBoolean(long r13) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldBoolean(long):boolean");
    }

    public Date scanFieldDate(long j10) {
        int i10;
        char charAt;
        char c10;
        int i11;
        Date date;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return null;
        }
        int i12 = this.bp;
        char c11 = this.f6309ch;
        int i13 = matchFieldHash + 1;
        int i14 = i12 + matchFieldHash;
        int i15 = this.len;
        char c12 = EOI;
        char charAt2 = i14 >= i15 ? EOI : this.text.charAt(i14);
        if (charAt2 == '\"') {
            int i16 = this.bp;
            int i17 = i16 + i13;
            int i18 = matchFieldHash + 2;
            int i19 = i16 + i13;
            if (i19 < this.len) {
                this.text.charAt(i19);
            }
            int indexOf = this.text.indexOf(34, this.bp + i18);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i20 = indexOf - i17;
            this.bp = i17;
            if (!scanISO8601DateIfMatch(false, i20)) {
                this.bp = i12;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            int i21 = i18 + i20;
            i11 = i21 + 1;
            c10 = charAt(i21 + i12);
            this.bp = i12;
        } else {
            if (charAt2 < '0' || charAt2 > '9') {
                this.matchStat = -1;
                return null;
            }
            long j11 = charAt2 - '0';
            while (true) {
                i10 = i13 + 1;
                int i22 = this.bp + i13;
                charAt = i22 >= this.len ? EOI : this.text.charAt(i22);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j11 = (j11 * 10) + (charAt - '0');
                i13 = i10;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return null;
            }
            if (charAt == '\"') {
                i11 = i13 + 2;
                int i23 = this.bp + i10;
                c10 = i23 >= this.len ? EOI : this.text.charAt(i23);
            } else {
                c10 = charAt;
                i11 = i10;
            }
            if (j11 < 0) {
                this.matchStat = -1;
                return null;
            }
            date = new Date(j11);
        }
        if (c10 == ',') {
            int i24 = this.bp + (i11 - 1) + 1;
            this.bp = i24;
            if (i24 < this.len) {
                c12 = this.text.charAt(i24);
            }
            this.f6309ch = c12;
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (c10 != '}') {
            this.bp = i12;
            this.f6309ch = c11;
            this.matchStat = -1;
            return null;
        }
        char charAt3 = charAt(this.bp + i11);
        if (charAt3 == ',') {
            this.token = 16;
            int i25 = this.bp + i11 + 1;
            this.bp = i25;
            if (i25 < this.len) {
                c12 = this.text.charAt(i25);
            }
            this.f6309ch = c12;
        } else if (charAt3 == ']') {
            this.token = 15;
            int i26 = this.bp + i11 + 1;
            this.bp = i26;
            if (i26 < this.len) {
                c12 = this.text.charAt(i26);
            }
            this.f6309ch = c12;
        } else if (charAt3 == '}') {
            this.token = 13;
            int i27 = this.bp + i11 + 1;
            this.bp = i27;
            if (i27 < this.len) {
                c12 = this.text.charAt(i27);
            }
            this.f6309ch = c12;
        } else {
            if (charAt3 != 26) {
                this.bp = i12;
                this.f6309ch = c11;
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i11;
            this.f6309ch = EOI;
        }
        this.matchStat = 4;
        return date;
    }

    public final double scanFieldDouble(long j10) {
        int i10;
        char charAt;
        int i11;
        double parseDouble;
        int i12;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return c.f27899e;
        }
        int i13 = matchFieldHash + 1;
        char charAt3 = charAt(this.bp + matchFieldHash);
        int i14 = this.bp;
        int i15 = (i14 + i13) - 1;
        boolean z10 = charAt3 == '-';
        if (z10) {
            charAt3 = charAt(i14 + i13);
            i13 = matchFieldHash + 2;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return c.f27899e;
        }
        int i16 = charAt3 - '0';
        while (true) {
            i10 = i13 + 1;
            charAt = charAt(this.bp + i13);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i16 = (i16 * 10) + (charAt - '0');
            i13 = i10;
        }
        if (charAt == '.') {
            int i17 = i13 + 2;
            char charAt4 = charAt(this.bp + i10);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return c.f27899e;
            }
            i16 = (i16 * 10) + (charAt4 - '0');
            int i18 = 10;
            while (true) {
                i12 = i17 + 1;
                charAt2 = charAt(this.bp + i17);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i16 = (i16 * 10) + (charAt2 - '0');
                i18 *= 10;
                i17 = i12;
            }
            i10 = i12;
            int i19 = i18;
            charAt = charAt2;
            i11 = i19;
        } else {
            i11 = 1;
        }
        boolean z11 = charAt == 'e' || charAt == 'E';
        if (z11) {
            int i20 = i10 + 1;
            charAt = charAt(this.bp + i10);
            if (charAt == '+' || charAt == '-') {
                i10 += 2;
                charAt = charAt(this.bp + i20);
            } else {
                i10 = i20;
            }
            while (charAt >= '0' && charAt <= '9') {
                charAt = charAt(this.bp + i10);
                i10++;
            }
        }
        int i21 = ((this.bp + i10) - i15) - 1;
        if (z11 || i21 >= 10) {
            parseDouble = Double.parseDouble(subString(i15, i21));
        } else {
            parseDouble = i16 / i11;
            if (z10) {
                parseDouble = -parseDouble;
            }
        }
        if (charAt == ',') {
            this.bp += i10 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return parseDouble;
        }
        if (charAt != '}') {
            this.matchStat = -1;
            return c.f27899e;
        }
        char charAt5 = charAt(this.bp + i10);
        if (charAt5 == ',') {
            this.token = 16;
            this.bp += i10;
            next();
        } else if (charAt5 == ']') {
            this.token = 15;
            this.bp += i10;
            next();
        } else if (charAt5 == '}') {
            this.token = 13;
            this.bp += i10;
            next();
        } else {
            if (charAt5 != 26) {
                this.matchStat = -1;
                return c.f27899e;
            }
            this.bp += i10;
            this.token = 20;
            this.f6309ch = EOI;
        }
        this.matchStat = 4;
        return parseDouble;
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0232, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0234, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0121 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0130  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x011e -> B:67:0x011f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double[] scanFieldDoubleArray(long r20) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray(long):double[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x00ef, code lost:
    
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00f1, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x029e, code lost:
    
        r6 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02a1, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double[][] scanFieldDoubleArray2(long r21) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray2(long):double[][]");
    }

    public final float scanFieldFloat(long j10) {
        int i10;
        char charAt;
        int i11;
        float parseFloat;
        int i12;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0.0f;
        }
        int i13 = matchFieldHash + 1;
        char charAt3 = charAt(this.bp + matchFieldHash);
        int i14 = this.bp;
        int i15 = (i14 + i13) - 1;
        boolean z10 = charAt3 == '-';
        if (z10) {
            charAt3 = charAt(i14 + i13);
            i13 = matchFieldHash + 2;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i16 = charAt3 - '0';
        while (true) {
            i10 = i13 + 1;
            charAt = charAt(this.bp + i13);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i16 = (i16 * 10) + (charAt - '0');
            i13 = i10;
        }
        if (charAt == '.') {
            int i17 = i13 + 2;
            char charAt4 = charAt(this.bp + i10);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            i16 = (i16 * 10) + (charAt4 - '0');
            int i18 = 10;
            while (true) {
                i12 = i17 + 1;
                charAt2 = charAt(this.bp + i17);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i16 = (i16 * 10) + (charAt2 - '0');
                i18 *= 10;
                i17 = i12;
            }
            i10 = i12;
            int i19 = i18;
            charAt = charAt2;
            i11 = i19;
        } else {
            i11 = 1;
        }
        boolean z11 = charAt == 'e' || charAt == 'E';
        if (z11) {
            int i20 = i10 + 1;
            charAt = charAt(this.bp + i10);
            if (charAt == '+' || charAt == '-') {
                i10 += 2;
                charAt = charAt(this.bp + i20);
            } else {
                i10 = i20;
            }
            while (charAt >= '0' && charAt <= '9') {
                charAt = charAt(this.bp + i10);
                i10++;
            }
        }
        int i21 = ((this.bp + i10) - i15) - 1;
        if (z11 || i21 >= 10) {
            parseFloat = Float.parseFloat(subString(i15, i21));
        } else {
            parseFloat = i16 / i11;
            if (z10) {
                parseFloat = -parseFloat;
            }
        }
        if (charAt == ',') {
            this.bp += i10 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        }
        if (charAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        }
        char charAt5 = charAt(this.bp + i10);
        if (charAt5 == ',') {
            this.token = 16;
            this.bp += i10;
            next();
        } else if (charAt5 == ']') {
            this.token = 15;
            this.bp += i10;
            next();
        } else if (charAt5 == '}') {
            this.token = 13;
            this.bp += i10;
            next();
        } else {
            if (charAt5 != 26) {
                this.matchStat = -1;
                return 0.0f;
            }
            this.bp += i10;
            this.token = 20;
            this.f6309ch = EOI;
        }
        this.matchStat = 4;
        return parseFloat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x00db, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x00dd, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0121 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0130  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x011e -> B:67:0x011f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(long r20) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray(long):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x00ef, code lost:
    
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00f1, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x029a, code lost:
    
        r6 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x029d, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] scanFieldFloatArray2(long r21) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray2(long):float[][]");
    }

    public int scanFieldInt(long j10) {
        int i10;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.bp + matchFieldHash;
        int i13 = this.len;
        char c10 = EOI;
        char charAt2 = i12 >= i13 ? EOI : this.text.charAt(i12);
        boolean z10 = charAt2 == '\"';
        if (z10) {
            int i14 = matchFieldHash + 2;
            int i15 = this.bp + i11;
            charAt2 = i15 >= this.len ? EOI : this.text.charAt(i15);
            i11 = i14;
            z10 = true;
        }
        boolean z11 = charAt2 == '-';
        if (z11) {
            int i16 = i11 + 1;
            int i17 = this.bp + i11;
            charAt2 = i17 >= this.len ? EOI : this.text.charAt(i17);
            i11 = i16;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i18 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i19 = this.bp + i11;
            charAt = i19 >= this.len ? EOI : this.text.charAt(i19);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i18 = (i18 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0;
            }
            int i20 = i11 + 2;
            int i21 = this.bp + i10;
            charAt = i21 >= this.len ? EOI : this.text.charAt(i21);
            i10 = i20;
        }
        if (i18 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (charAt != ',') {
            if (charAt > ' ' || !(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\f' || charAt == '\b')) {
                if (charAt != '}') {
                    this.matchStat = -1;
                    return 0;
                }
                char charAt3 = charAt(this.bp + i10);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i22 = this.bp + i10 + 1;
                    this.bp = i22;
                    if (i22 < this.len) {
                        c10 = this.text.charAt(i22);
                    }
                    this.f6309ch = c10;
                } else if (charAt3 == ']') {
                    this.token = 15;
                    int i23 = this.bp + i10 + 1;
                    this.bp = i23;
                    if (i23 < this.len) {
                        c10 = this.text.charAt(i23);
                    }
                    this.f6309ch = c10;
                } else if (charAt3 == '}') {
                    this.token = 13;
                    int i24 = this.bp + i10 + 1;
                    this.bp = i24;
                    if (i24 < this.len) {
                        c10 = this.text.charAt(i24);
                    }
                    this.f6309ch = c10;
                } else {
                    if (charAt3 != 26) {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.token = 20;
                    this.bp += i10;
                    this.f6309ch = EOI;
                }
                this.matchStat = 4;
                return z11 ? -i18 : i18;
            }
            int i25 = i10 + 1;
            int i26 = this.bp + i10;
            charAt = i26 >= this.len ? EOI : this.text.charAt(i26);
            i10 = i25;
        }
        int i27 = this.bp + (i10 - 1) + 1;
        this.bp = i27;
        if (i27 < this.len) {
            c10 = this.text.charAt(i27);
        }
        this.f6309ch = c10;
        this.matchStat = 3;
        this.token = 16;
        return z11 ? -i18 : i18;
    }

    public final int[] scanFieldIntArray(long j10) {
        boolean z10;
        int[] iArr;
        int i10;
        int i11;
        char charAt;
        int i12;
        char charAt2;
        int i13;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        int[] iArr2 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i14 = matchFieldHash + 1;
        int i15 = this.bp + matchFieldHash;
        if ((i15 >= this.len ? EOI : this.text.charAt(i15)) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i16 = matchFieldHash + 2;
        int i17 = this.bp + i14;
        char charAt3 = i17 >= this.len ? EOI : this.text.charAt(i17);
        int[] iArr3 = new int[16];
        if (charAt3 != ']') {
            int i18 = 0;
            while (true) {
                if (charAt3 == '-') {
                    int i19 = i16 + 1;
                    int i20 = this.bp + i16;
                    charAt3 = i20 >= this.len ? EOI : this.text.charAt(i20);
                    i16 = i19;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (charAt3 < '0') {
                    iArr = iArr2;
                    i10 = -1;
                    break;
                }
                if (charAt3 > '9') {
                    i10 = -1;
                    iArr = null;
                    break;
                }
                int i21 = charAt3 - '0';
                while (true) {
                    i11 = i16 + 1;
                    int i22 = this.bp + i16;
                    charAt = i22 >= this.len ? EOI : this.text.charAt(i22);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i21 = (i21 * 10) + (charAt - '0');
                    i16 = i11;
                }
                if (i18 >= iArr3.length) {
                    int[] iArr4 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr4, 0, i18);
                    iArr3 = iArr4;
                }
                i12 = i18 + 1;
                if (z10) {
                    i21 = -i21;
                }
                iArr3[i18] = i21;
                if (charAt == ',') {
                    int i23 = i16 + 2;
                    int i24 = this.bp + i11;
                    charAt = i24 >= this.len ? EOI : this.text.charAt(i24);
                    i11 = i23;
                } else if (charAt == ']') {
                    int i25 = i16 + 2;
                    int i26 = this.bp + i11;
                    charAt2 = i26 >= this.len ? EOI : this.text.charAt(i26);
                    i13 = i25;
                }
                i18 = i12;
                iArr2 = null;
                charAt3 = charAt;
                i16 = i11;
            }
            this.matchStat = i10;
            return iArr;
        }
        i13 = matchFieldHash + 3;
        int i27 = this.bp + i16;
        charAt2 = i27 >= this.len ? EOI : this.text.charAt(i27);
        i12 = 0;
        if (i12 != iArr3.length) {
            int[] iArr5 = new int[i12];
            System.arraycopy(iArr3, 0, iArr5, 0, i12);
            iArr3 = iArr5;
        }
        if (charAt2 == ',') {
            this.bp += i13 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        }
        if (charAt2 != '}') {
            this.matchStat = -1;
            return null;
        }
        char charAt4 = charAt(this.bp + i13);
        if (charAt4 == ',') {
            this.token = 16;
            this.bp += i13;
            next();
        } else if (charAt4 == ']') {
            this.token = 15;
            this.bp += i13;
            next();
        } else if (charAt4 == '}') {
            this.token = 13;
            this.bp += i13;
            next();
        } else {
            if (charAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.bp += i13;
            this.token = 20;
            this.f6309ch = EOI;
        }
        this.matchStat = 4;
        return iArr3;
    }

    public long scanFieldLong(long j10) {
        int i10;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.bp + matchFieldHash;
        char charAt2 = i12 >= this.len ? EOI : this.text.charAt(i12);
        boolean z10 = charAt2 == '\"';
        if (z10) {
            int i13 = matchFieldHash + 2;
            int i14 = this.bp + i11;
            charAt2 = i14 >= this.len ? EOI : this.text.charAt(i14);
            i11 = i13;
        }
        boolean z11 = charAt2 == '-';
        if (z11) {
            int i15 = i11 + 1;
            int i16 = this.bp + i11;
            i11 = i15;
            charAt2 = i16 >= this.len ? EOI : this.text.charAt(i16);
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j11 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i17 = this.bp + i11;
            charAt = i17 >= this.len ? EOI : this.text.charAt(i17);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j11 = (j11 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0L;
            }
            int i18 = i11 + 2;
            int i19 = this.bp + i10;
            charAt = i19 >= this.len ? EOI : this.text.charAt(i19);
            i10 = i18;
        }
        if (j11 < 0) {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == ',') {
            int i20 = this.bp + (i10 - 1) + 1;
            this.bp = i20;
            this.f6309ch = i20 >= this.len ? EOI : this.text.charAt(i20);
            this.matchStat = 3;
            this.token = 16;
            return z11 ? -j11 : j11;
        }
        if (charAt != '}') {
            this.matchStat = -1;
            return 0L;
        }
        char charAt3 = charAt(this.bp + i10);
        if (charAt3 == ',') {
            this.token = 16;
            int i21 = this.bp + i10 + 1;
            this.bp = i21;
            this.f6309ch = i21 >= this.len ? EOI : this.text.charAt(i21);
        } else if (charAt3 == ']') {
            this.token = 15;
            int i22 = this.bp + i10 + 1;
            this.bp = i22;
            this.f6309ch = i22 >= this.len ? EOI : this.text.charAt(i22);
        } else if (charAt3 == '}') {
            this.token = 13;
            int i23 = this.bp + i10 + 1;
            this.bp = i23;
            this.f6309ch = i23 >= this.len ? EOI : this.text.charAt(i23);
        } else {
            if (charAt3 != 26) {
                this.matchStat = -1;
                return 0L;
            }
            this.token = 20;
            this.bp += i10;
            this.f6309ch = EOI;
        }
        this.matchStat = 4;
        return z11 ? -j11 : j11;
    }

    public String scanFieldString(long j10) {
        String str;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return null;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.bp + matchFieldHash;
        if (i11 >= this.len) {
            throw new JSONException("unclosed str, " + info());
        }
        if (this.text.charAt(i11) != '\"') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        }
        int i12 = this.bp + i10;
        int indexOf = this.text.indexOf(34, i12);
        if (indexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        if (V6) {
            str = this.text.substring(i12, indexOf);
        } else {
            int i13 = indexOf - i12;
            str = new String(sub_chars(this.bp + i10, i13), 0, i13);
        }
        if (str.indexOf(92) != -1) {
            boolean z10 = false;
            while (true) {
                int i14 = indexOf - 1;
                int i15 = 0;
                while (i14 >= 0 && this.text.charAt(i14) == '\\') {
                    i15++;
                    i14--;
                    z10 = true;
                }
                if (i15 % 2 == 0) {
                    break;
                }
                indexOf = this.text.indexOf(34, indexOf + 1);
            }
            int i16 = indexOf - i12;
            char[] sub_chars = sub_chars(this.bp + i10, i16);
            if (z10) {
                str = readString(sub_chars, i16);
            } else {
                str = new String(sub_chars, 0, i16);
                if (str.indexOf(92) != -1) {
                    str = readString(sub_chars, i16);
                }
            }
        }
        int i17 = indexOf + 1;
        int i18 = this.len;
        char c10 = EOI;
        char charAt = i17 >= i18 ? EOI : this.text.charAt(i17);
        if (charAt == ',') {
            int i19 = indexOf + 2;
            this.bp = i19;
            if (i19 < this.len) {
                c10 = this.text.charAt(i19);
            }
            this.f6309ch = c10;
            this.matchStat = 3;
            this.token = 16;
            return str;
        }
        if (charAt != '}') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        }
        int i20 = indexOf + 2;
        char charAt2 = i20 >= this.len ? EOI : this.text.charAt(i20);
        if (charAt2 == ',') {
            this.token = 16;
            this.bp = i20;
            next();
        } else if (charAt2 == ']') {
            this.token = 15;
            this.bp = i20;
            next();
        } else if (charAt2 == '}') {
            this.token = 13;
            this.bp = i20;
            next();
        } else {
            if (charAt2 != 26) {
                this.matchStat = -1;
                return this.stringDefaultValue;
            }
            this.token = 20;
            this.bp = i20;
            this.f6309ch = EOI;
        }
        this.matchStat = 4;
        return str;
    }

    public long scanFieldSymbol(long j10) {
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.bp + matchFieldHash;
        int i12 = this.len;
        char c10 = EOI;
        if ((i11 >= i12 ? EOI : this.text.charAt(i11)) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j11 = -3750763034362895579L;
        while (true) {
            int i13 = i10 + 1;
            int i14 = this.bp + i10;
            char charAt = i14 >= this.len ? EOI : this.text.charAt(i14);
            if (charAt == '\"') {
                int i15 = i10 + 2;
                int i16 = this.bp + i13;
                char charAt2 = i16 >= this.len ? EOI : this.text.charAt(i16);
                if (charAt2 == ',') {
                    int i17 = this.bp + i10 + 1 + 1;
                    this.bp = i17;
                    if (i17 < this.len) {
                        c10 = this.text.charAt(i17);
                    }
                    this.f6309ch = c10;
                    this.matchStat = 3;
                    return j11;
                }
                if (charAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i18 = this.bp + i15;
                char charAt3 = i18 >= this.len ? EOI : this.text.charAt(i18);
                if (charAt3 == ',') {
                    this.token = 16;
                    this.bp += i10 + 2;
                    next();
                } else if (charAt3 == ']') {
                    this.token = 15;
                    this.bp += i10 + 2;
                    next();
                } else if (charAt3 == '}') {
                    this.token = 13;
                    this.bp += i10 + 2;
                    next();
                } else {
                    if (charAt3 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.bp += i10 + 2;
                    this.f6309ch = EOI;
                }
                this.matchStat = 4;
                return j11;
            }
            j11 = (j11 ^ charAt) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i10 = i13;
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z10) {
        return scanISO8601DateIfMatch(z10, this.len - this.bp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
    
        if (r0 != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c4, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long scanLongValue() {
        /*
            r13 = this;
            r0 = 0
            r13.np = r0
            char r1 = r13.f6309ch
            r2 = 45
            r3 = 1
            if (r1 != r2) goto L3d
            r13.np = r3
            int r0 = r13.bp
            int r0 = r0 + r3
            r13.bp = r0
            int r1 = r13.len
            if (r0 >= r1) goto L22
            java.lang.String r1 = r13.text
            char r0 = r1.charAt(r0)
            r13.f6309ch = r0
            r0 = -9223372036854775808
            r1 = r0
            r0 = 1
            goto L42
        L22:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, "
            r1.append(r2)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L3d:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L42:
            r4 = 0
        L44:
            char r6 = r13.f6309ch
            r7 = 48
            if (r6 < r7) goto Lc1
            r7 = 57
            if (r6 > r7) goto Lc1
            int r6 = r6 + (-48)
            r7 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            java.lang.String r9 = ", "
            java.lang.String r10 = "error long value, "
            int r11 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r11 < 0) goto La2
            r7 = 10
            long r4 = r4 * r7
            long r6 = (long) r6
            long r11 = r1 + r6
            int r8 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r8 < 0) goto L83
            long r4 = r4 - r6
            int r6 = r13.np
            int r6 = r6 + r3
            r13.np = r6
            int r6 = r13.bp
            int r6 = r6 + r3
            r13.bp = r6
            int r7 = r13.len
            if (r6 < r7) goto L7a
            r6 = 26
            goto L80
        L7a:
            java.lang.String r7 = r13.text
            char r6 = r7.charAt(r6)
        L80:
            r13.f6309ch = r6
            goto L44
        L83:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r4)
            r1.append(r9)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La2:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r4)
            r1.append(r9)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        Lc1:
            if (r0 != 0) goto Lc4
            long r4 = -r4
        Lc4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanLongValue():long");
    }

    public final void scanNumber() {
        char c10;
        char c11;
        int i10 = this.bp;
        this.np = i10;
        this.exp = false;
        if (this.f6309ch == '-') {
            this.sp++;
            int i11 = i10 + 1;
            this.bp = i11;
            this.f6309ch = i11 >= this.len ? EOI : this.text.charAt(i11);
        }
        while (true) {
            c10 = this.f6309ch;
            if (c10 < '0' || c10 > '9') {
                break;
            }
            this.sp++;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.f6309ch = i12 >= this.len ? EOI : this.text.charAt(i12);
        }
        this.isDouble = false;
        if (c10 == '.') {
            this.sp++;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.f6309ch = i13 >= this.len ? EOI : this.text.charAt(i13);
            this.isDouble = true;
            while (true) {
                char c12 = this.f6309ch;
                if (c12 < '0' || c12 > '9') {
                    break;
                }
                this.sp++;
                int i14 = this.bp + 1;
                this.bp = i14;
                this.f6309ch = i14 >= this.len ? EOI : this.text.charAt(i14);
            }
        }
        char c13 = this.f6309ch;
        if (c13 == 'L') {
            this.sp++;
            next();
        } else if (c13 == 'S') {
            this.sp++;
            next();
        } else if (c13 == 'B') {
            this.sp++;
            next();
        } else if (c13 == 'F') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c13 == 'D') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c13 == 'e' || c13 == 'E') {
            this.sp++;
            int i15 = this.bp + 1;
            this.bp = i15;
            char charAt = i15 >= this.len ? EOI : this.text.charAt(i15);
            this.f6309ch = charAt;
            if (charAt == '+' || charAt == '-') {
                this.sp++;
                int i16 = this.bp + 1;
                this.bp = i16;
                this.f6309ch = i16 >= this.len ? EOI : this.text.charAt(i16);
            }
            while (true) {
                c11 = this.f6309ch;
                if (c11 < '0' || c11 > '9') {
                    break;
                }
                this.sp++;
                int i17 = this.bp + 1;
                this.bp = i17;
                this.f6309ch = i17 >= this.len ? EOI : this.text.charAt(i17);
            }
            if (c11 == 'D' || c11 == 'F') {
                this.sp++;
                next();
            }
            this.exp = true;
            this.isDouble = true;
        }
        if (this.isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0283 A[Catch: NumberFormatException -> 0x0297, TryCatch #0 {NumberFormatException -> 0x0297, blocks: (B:105:0x0270, B:110:0x027e, B:112:0x0283, B:116:0x0294, B:117:0x028b, B:119:0x0292, B:124:0x029b, B:127:0x02a1, B:129:0x02a6, B:132:0x02ac, B:134:0x027b, B:135:0x02b1, B:137:0x02b9, B:139:0x02be), top: B:102:0x026c }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x029b A[Catch: NumberFormatException -> 0x0297, TryCatch #0 {NumberFormatException -> 0x0297, blocks: (B:105:0x0270, B:110:0x027e, B:112:0x0283, B:116:0x0294, B:117:0x028b, B:119:0x0292, B:124:0x029b, B:127:0x02a1, B:129:0x02a6, B:132:0x02ac, B:134:0x027b, B:135:0x02b1, B:137:0x02b9, B:139:0x02be), top: B:102:0x026c }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a6 A[Catch: NumberFormatException -> 0x0297, TryCatch #0 {NumberFormatException -> 0x0297, blocks: (B:105:0x0270, B:110:0x027e, B:112:0x0283, B:116:0x0294, B:117:0x028b, B:119:0x0292, B:124:0x029b, B:127:0x02a1, B:129:0x02a6, B:132:0x02ac, B:134:0x027b, B:135:0x02b1, B:137:0x02b9, B:139:0x02be), top: B:102:0x026c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Number scanNumberValue() {
        /*
            Method dump skipped, instructions count: 745
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanNumberValue():java.lang.Number");
    }

    public final void scanString() {
        char c10 = this.f6309ch;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        int i11 = indexOf - i10;
        char[] sub_chars = sub_chars(this.bp + 1, i11);
        boolean z10 = false;
        while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
            int i12 = 1;
            for (int i13 = i11 - 2; i13 >= 0 && sub_chars[i13] == '\\'; i13--) {
                i12++;
            }
            if (i12 % 2 == 0) {
                break;
            }
            int indexOf2 = this.text.indexOf(c10, indexOf + 1);
            int i14 = (indexOf2 - indexOf) + i11;
            if (i14 >= sub_chars.length) {
                int length = (sub_chars.length * 3) / 2;
                if (length < i14) {
                    length = i14;
                }
                char[] cArr = new char[length];
                System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                sub_chars = cArr;
            }
            this.text.getChars(indexOf, indexOf2, sub_chars, i11);
            indexOf = indexOf2;
            i11 = i14;
            z10 = true;
        }
        if (!z10) {
            for (int i15 = 0; i15 < i11; i15++) {
                if (sub_chars[i15] == '\\') {
                    z10 = true;
                }
            }
        }
        this.sbuf = sub_chars;
        this.sp = i11;
        this.np = this.bp;
        this.hasSpecial = z10;
        int i16 = indexOf + 1;
        this.bp = i16;
        this.f6309ch = i16 >= this.len ? EOI : this.text.charAt(i16);
        this.token = 4;
    }

    public String scanStringValue(char c10) {
        String str;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        if (V6) {
            str = this.text.substring(i10, indexOf);
        } else {
            int i11 = indexOf - i10;
            str = new String(sub_chars(this.bp + 1, i11), 0, i11);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i12 = 0;
                for (int i13 = indexOf - 1; i13 >= 0 && this.text.charAt(i13) == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                indexOf = this.text.indexOf(c10, indexOf + 1);
            }
            int i14 = indexOf - i10;
            str = readString(sub_chars(this.bp + 1, i14), i14);
        }
        int i15 = indexOf + 1;
        this.bp = i15;
        this.f6309ch = i15 >= this.len ? EOI : this.text.charAt(i15);
        return str;
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c10;
        while (true) {
            c10 = this.f6309ch;
            if (c10 != ' ' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '\f' && c10 != '\b') {
                break;
            }
            next();
        }
        if (c10 == '\"') {
            return scanSymbol(symbolTable, Typography.quote);
        }
        if (c10 == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c10 == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c10 == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c10 != 26) {
            return scanSymbolUnQuoted(symbolTable);
        }
        this.token = 20;
        return null;
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i10 = this.f6309ch;
        boolean[] zArr = firstIdentifierFlags;
        if (i10 < zArr.length && !zArr[i10]) {
            throw new JSONException("illegal identifier : " + this.f6309ch + ", " + info());
        }
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            boolean[] zArr2 = identifierFlags;
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i10 = (i10 * 31) + next;
            this.sp++;
        }
        this.f6309ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && this.text.startsWith("null", this.np)) {
            return null;
        }
        return symbolTable.addSymbol(this.text, this.np, this.sp, i10);
    }

    public void setTime(char c10, char c11, char c12, char c13, char c14, char c15) {
        this.calendar.set(11, ((c10 - '0') * 10) + (c11 - '0'));
        this.calendar.set(12, ((c12 - '0') * 10) + (c13 - '0'));
        this.calendar.set(13, ((c14 - '0') * 10) + (c15 - '0'));
    }

    public void setTimeZone(char c10, char c11, char c12) {
        int i10 = (((c11 - '0') * 10) + (c12 - '0')) * 3600000;
        if (c10 == '-') {
            i10 = -i10;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i10) {
            String[] availableIDs = TimeZone.getAvailableIDs(i10);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    public void skipComment() {
        next();
        char c10 = this.f6309ch;
        if (c10 == '/') {
            do {
                next();
            } while (this.f6309ch != '\n');
            next();
        } else {
            if (c10 != '*') {
                throw new JSONException("invalid comment");
            }
            next();
            while (true) {
                char c11 = this.f6309ch;
                if (c11 == 26) {
                    return;
                }
                if (c11 == '*') {
                    next();
                    if (this.f6309ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        }
    }

    public final void skipWhitespace() {
        while (true) {
            char c10 = this.f6309ch;
            if (c10 > '/') {
                return;
            }
            if (c10 == ' ' || c10 == '\r' || c10 == '\n' || c10 == '\t' || c10 == '\f' || c10 == '\b') {
                next();
            } else if (c10 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringVal() {
        return this.hasSpecial ? readString(this.sbuf, this.sp) : subString(this.np + 1, this.sp);
    }

    public final char[] sub_chars(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i11 + i10, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i11];
        this.sbuf = cArr2;
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }

    public JSONLexer(char[] cArr, int i10) {
        this(cArr, i10, JSON.DEFAULT_PARSER_FEATURE);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0208 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanISO8601DateIfMatch(boolean r37, int r38) {
        /*
            Method dump skipped, instructions count: 1591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    public JSONLexer(char[] cArr, int i10, int i11) {
        this(new String(cArr, 0, i10), i11);
    }

    public JSONLexer(String str, int i10) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i10;
        this.text = str;
        int length = str.length();
        this.len = length;
        int i11 = (-1) + 1;
        this.bp = i11;
        char charAt = i11 >= length ? EOI : str.charAt(i11);
        this.f6309ch = charAt;
        if (charAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i10) != 0 ? "" : null;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i10) != 0;
    }

    public String scanSymbol(SymbolTable symbolTable, char c10) {
        String readString;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf != -1) {
            int i11 = indexOf - i10;
            char[] sub_chars = sub_chars(this.bp + 1, i11);
            boolean z10 = false;
            while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
                int i12 = 1;
                for (int i13 = i11 - 2; i13 >= 0 && sub_chars[i13] == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c10, indexOf + 1);
                int i14 = (indexOf2 - indexOf) + i11;
                if (i14 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i14) {
                        length = i14;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i11);
                indexOf = indexOf2;
                i11 = i14;
                z10 = true;
            }
            if (z10) {
                readString = readString(sub_chars, i11);
            } else {
                int i15 = 0;
                for (int i16 = 0; i16 < i11; i16++) {
                    char c11 = sub_chars[i16];
                    i15 = (i15 * 31) + c11;
                    if (c11 == '\\') {
                        z10 = true;
                    }
                }
                if (z10) {
                    readString = readString(sub_chars, i11);
                } else {
                    readString = i11 < 20 ? symbolTable.addSymbol(sub_chars, 0, i11, i15) : new String(sub_chars, 0, i11);
                }
            }
            int i17 = indexOf + 1;
            this.bp = i17;
            this.f6309ch = i17 >= this.len ? EOI : this.text.charAt(i17);
            return readString;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i10 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        int i11 = this.np;
        char[] cArr = this.sbuf;
        if (i10 < cArr.length) {
            this.text.getChars(i11, i11 + i10, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i10);
        }
        char[] cArr2 = new char[i10];
        this.text.getChars(i11, i10 + i11, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void nextToken(int i10) {
        this.sp = 0;
        while (true) {
            if (i10 != 2) {
                char c10 = EOI;
                if (i10 == 4) {
                    char c11 = this.f6309ch;
                    if (c11 == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    }
                    if (c11 >= '0' && c11 <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (c11 == '{') {
                        this.token = 12;
                        int i11 = this.bp + 1;
                        this.bp = i11;
                        if (i11 < this.len) {
                            c10 = this.text.charAt(i11);
                        }
                        this.f6309ch = c10;
                        return;
                    }
                } else if (i10 == 12) {
                    char c12 = this.f6309ch;
                    if (c12 == '{') {
                        this.token = 12;
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        if (i12 < this.len) {
                            c10 = this.text.charAt(i12);
                        }
                        this.f6309ch = c10;
                        return;
                    }
                    if (c12 == '[') {
                        this.token = 14;
                        int i13 = this.bp + 1;
                        this.bp = i13;
                        if (i13 < this.len) {
                            c10 = this.text.charAt(i13);
                        }
                        this.f6309ch = c10;
                        return;
                    }
                } else if (i10 != 18) {
                    if (i10 != 20) {
                        switch (i10) {
                            case 14:
                                char c13 = this.f6309ch;
                                if (c13 != '[') {
                                    if (c13 == '{') {
                                        this.token = 12;
                                        next();
                                        break;
                                    }
                                } else {
                                    this.token = 14;
                                    next();
                                    break;
                                }
                                break;
                            case 15:
                                if (this.f6309ch == ']') {
                                    this.token = 15;
                                    next();
                                    break;
                                }
                                break;
                            case 16:
                                char c14 = this.f6309ch;
                                if (c14 != ',') {
                                    if (c14 != '}') {
                                        if (c14 != ']') {
                                            if (c14 == 26) {
                                                this.token = 20;
                                                break;
                                            }
                                        } else {
                                            this.token = 15;
                                            int i14 = this.bp + 1;
                                            this.bp = i14;
                                            if (i14 < this.len) {
                                                c10 = this.text.charAt(i14);
                                            }
                                            this.f6309ch = c10;
                                            break;
                                        }
                                    } else {
                                        this.token = 13;
                                        int i15 = this.bp + 1;
                                        this.bp = i15;
                                        if (i15 < this.len) {
                                            c10 = this.text.charAt(i15);
                                        }
                                        this.f6309ch = c10;
                                        break;
                                    }
                                } else {
                                    this.token = 16;
                                    int i16 = this.bp + 1;
                                    this.bp = i16;
                                    if (i16 < this.len) {
                                        c10 = this.text.charAt(i16);
                                    }
                                    this.f6309ch = c10;
                                    break;
                                }
                                break;
                        }
                        return;
                    }
                    if (this.f6309ch == 26) {
                        this.token = 20;
                        return;
                    }
                } else {
                    nextIdent();
                    return;
                }
            } else {
                char c15 = this.f6309ch;
                if (c15 >= '0' && c15 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c15 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c15 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c15 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            char c16 = this.f6309ch;
            if (c16 != ' ' && c16 != '\n' && c16 != '\r' && c16 != '\t' && c16 != '\f' && c16 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }
}
