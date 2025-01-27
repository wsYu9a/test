package com.google.common.io;

import b5.r;
import b5.u;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import k5.p;

@a5.b(emulated = true)
@p
/* loaded from: classes2.dex */
public abstract class BaseEncoding {

    /* renamed from: a */
    public static final BaseEncoding f10104a = new h("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* renamed from: b */
    public static final BaseEncoding f10105b = new h("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* renamed from: c */
    public static final BaseEncoding f10106c = new j("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* renamed from: d */
    public static final BaseEncoding f10107d = new j("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* renamed from: e */
    public static final BaseEncoding f10108e = new g("base16()", "0123456789ABCDEF");

    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th2) {
            super(th2);
        }
    }

    public class a extends k5.e {

        /* renamed from: a */
        public final /* synthetic */ k5.i f10109a;

        public a(k5.i iVar) {
            this.f10109a = iVar;
        }

        @Override // k5.e
        public OutputStream c() throws IOException {
            return BaseEncoding.this.p(this.f10109a.b());
        }
    }

    public class b extends k5.f {

        /* renamed from: a */
        public final /* synthetic */ k5.j f10111a;

        public b(k5.j jVar) {
            this.f10111a = jVar;
        }

        @Override // k5.f
        public InputStream m() throws IOException {
            return BaseEncoding.this.k(this.f10111a.m());
        }
    }

    public class e extends Writer {

        /* renamed from: b */
        public final /* synthetic */ Appendable f10119b;

        /* renamed from: c */
        public final /* synthetic */ Writer f10120c;

        public e(Appendable appendable, Writer writer) {
            this.f10119b = appendable;
            this.f10120c = writer;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f10120c.close();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            this.f10120c.flush();
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.f10119b.append((char) i10);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public static final class f {

        /* renamed from: a */
        public final String f10121a;

        /* renamed from: b */
        public final char[] f10122b;

        /* renamed from: c */
        public final int f10123c;

        /* renamed from: d */
        public final int f10124d;

        /* renamed from: e */
        public final int f10125e;

        /* renamed from: f */
        public final int f10126f;

        /* renamed from: g */
        public final byte[] f10127g;

        /* renamed from: h */
        public final boolean[] f10128h;

        public f(String str, char[] cArr) {
            this.f10121a = (String) u.E(str);
            this.f10122b = (char[]) u.E(cArr);
            try {
                int p10 = l5.f.p(cArr.length, RoundingMode.UNNECESSARY);
                this.f10124d = p10;
                int min = Math.min(8, Integer.lowestOneBit(p10));
                try {
                    this.f10125e = 8 / min;
                    this.f10126f = p10 / min;
                    this.f10123c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i10 = 0; i10 < cArr.length; i10++) {
                        char c10 = cArr[i10];
                        u.f(c10 < 128, "Non-ASCII character: %s", c10);
                        u.f(bArr[c10] == -1, "Duplicate character: %s", c10);
                        bArr[c10] = (byte) i10;
                    }
                    this.f10127g = bArr;
                    boolean[] zArr = new boolean[this.f10125e];
                    for (int i11 = 0; i11 < this.f10126f; i11++) {
                        zArr[l5.f.g(i11 * 8, this.f10124d, RoundingMode.CEILING)] = true;
                    }
                    this.f10128h = zArr;
                } catch (ArithmeticException e10) {
                    String str2 = new String(cArr);
                    throw new IllegalArgumentException(str2.length() != 0 ? "Illegal alphabet ".concat(str2) : new String("Illegal alphabet "), e10);
                }
            } catch (ArithmeticException e11) {
                int length = cArr.length;
                StringBuilder sb2 = new StringBuilder(35);
                sb2.append("Illegal alphabet length ");
                sb2.append(length);
                throw new IllegalArgumentException(sb2.toString(), e11);
            }
        }

        public boolean b(char c10) {
            return c10 <= 127 && this.f10127g[c10] != -1;
        }

        public int c(char c10) throws DecodingException {
            if (c10 > 127) {
                String valueOf = String.valueOf(Integer.toHexString(c10));
                throw new DecodingException(valueOf.length() != 0 ? "Unrecognized character: 0x".concat(valueOf) : new String("Unrecognized character: 0x"));
            }
            byte b10 = this.f10127g[c10];
            if (b10 != -1) {
                return b10;
            }
            if (c10 <= ' ' || c10 == 127) {
                String valueOf2 = String.valueOf(Integer.toHexString(c10));
                throw new DecodingException(valueOf2.length() != 0 ? "Unrecognized character: 0x".concat(valueOf2) : new String("Unrecognized character: 0x"));
            }
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("Unrecognized character: ");
            sb2.append(c10);
            throw new DecodingException(sb2.toString());
        }

        public char d(int i10) {
            return this.f10122b[i10];
        }

        public final boolean e() {
            for (char c10 : this.f10122b) {
                if (b5.a.c(c10)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof f) {
                return Arrays.equals(this.f10122b, ((f) obj).f10122b);
            }
            return false;
        }

        public final boolean f() {
            for (char c10 : this.f10122b) {
                if (b5.a.d(c10)) {
                    return true;
                }
            }
            return false;
        }

        public boolean g(int i10) {
            return this.f10128h[i10 % this.f10125e];
        }

        public f h() {
            if (!f()) {
                return this;
            }
            u.h0(!e(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f10122b.length];
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.f10122b;
                if (i10 >= cArr2.length) {
                    return new f(String.valueOf(this.f10121a).concat(".lowerCase()"), cArr);
                }
                cArr[i10] = b5.a.e(cArr2[i10]);
                i10++;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.f10122b);
        }

        public boolean i(char c10) {
            byte[] bArr = this.f10127g;
            return c10 < bArr.length && bArr[c10] != -1;
        }

        public f j() {
            if (!e()) {
                return this;
            }
            u.h0(!f(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f10122b.length];
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.f10122b;
                if (i10 >= cArr2.length) {
                    return new f(String.valueOf(this.f10121a).concat(".upperCase()"), cArr);
                }
                cArr[i10] = b5.a.h(cArr2[i10]);
                i10++;
            }
        }

        public String toString() {
            return this.f10121a;
        }
    }

    public static final class g extends j {

        /* renamed from: j */
        public final char[] f10129j;

        public g(String str, String str2) {
            this(new f(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.j
        public BaseEncoding D(f fVar, @CheckForNull Character ch2) {
            return new g(fVar);
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            u.E(bArr);
            if (charSequence.length() % 2 == 1) {
                int length = charSequence.length();
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Invalid input length ");
                sb2.append(length);
                throw new DecodingException(sb2.toString());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequence.length()) {
                bArr[i11] = (byte) ((this.f10133f.c(charSequence.charAt(i10)) << 4) | this.f10133f.c(charSequence.charAt(i10 + 1)));
                i10 += 2;
                i11++;
            }
            return i11;
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            u.E(appendable);
            u.f0(i10, i10 + i11, bArr.length);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = bArr[i10 + i12] & 255;
                appendable.append(this.f10129j[i13]);
                appendable.append(this.f10129j[i13 | 256]);
            }
        }

        public g(f fVar) {
            super(fVar, null);
            this.f10129j = new char[512];
            u.d(fVar.f10122b.length == 16);
            for (int i10 = 0; i10 < 256; i10++) {
                this.f10129j[i10] = fVar.d(i10 >>> 4);
                this.f10129j[i10 | 256] = fVar.d(i10 & 15);
            }
        }
    }

    public static final class h extends j {
        public h(String str, String str2, @CheckForNull Character ch2) {
            this(new f(str, str2.toCharArray()), ch2);
        }

        @Override // com.google.common.io.BaseEncoding.j
        public BaseEncoding D(f fVar, @CheckForNull Character ch2) {
            return new h(fVar, ch2);
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            u.E(bArr);
            CharSequence y10 = y(charSequence);
            if (!this.f10133f.g(y10.length())) {
                int length = y10.length();
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Invalid input length ");
                sb2.append(length);
                throw new DecodingException(sb2.toString());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < y10.length()) {
                int i12 = i10 + 2;
                int c10 = (this.f10133f.c(y10.charAt(i10)) << 18) | (this.f10133f.c(y10.charAt(i10 + 1)) << 12);
                int i13 = i11 + 1;
                bArr[i11] = (byte) (c10 >>> 16);
                if (i12 < y10.length()) {
                    int i14 = i10 + 3;
                    int c11 = c10 | (this.f10133f.c(y10.charAt(i12)) << 6);
                    int i15 = i11 + 2;
                    bArr[i13] = (byte) ((c11 >>> 8) & 255);
                    if (i14 < y10.length()) {
                        i10 += 4;
                        i11 += 3;
                        bArr[i15] = (byte) ((c11 | this.f10133f.c(y10.charAt(i14))) & 255);
                    } else {
                        i11 = i15;
                        i10 = i14;
                    }
                } else {
                    i11 = i13;
                    i10 = i12;
                }
            }
            return i11;
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            u.E(appendable);
            int i12 = i10 + i11;
            u.f0(i10, i12, bArr.length);
            while (i11 >= 3) {
                int i13 = i10 + 2;
                int i14 = ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10] & 255) << 16);
                i10 += 3;
                int i15 = i14 | (bArr[i13] & 255);
                appendable.append(this.f10133f.d(i15 >>> 18));
                appendable.append(this.f10133f.d((i15 >>> 12) & 63));
                appendable.append(this.f10133f.d((i15 >>> 6) & 63));
                appendable.append(this.f10133f.d(i15 & 63));
                i11 -= 3;
            }
            if (i10 < i12) {
                C(appendable, bArr, i10, i12 - i10);
            }
        }

        public h(f fVar, @CheckForNull Character ch2) {
            super(fVar, ch2);
            u.d(fVar.f10122b.length == 64);
        }
    }

    public static final class i extends BaseEncoding {

        /* renamed from: f */
        public final BaseEncoding f10130f;

        /* renamed from: g */
        public final String f10131g;

        /* renamed from: h */
        public final int f10132h;

        public i(BaseEncoding baseEncoding, String str, int i10) {
            this.f10130f = (BaseEncoding) u.E(baseEncoding);
            this.f10131g = (String) u.E(str);
            this.f10132h = i10;
            u.k(i10 > 0, "Cannot add a separator after every %s chars", i10);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding A(char c10) {
            return this.f10130f.A(c10).B(this.f10131g, this.f10132h);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding B(String str, int i10) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean f(CharSequence charSequence) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < charSequence.length(); i10++) {
                char charAt = charSequence.charAt(i10);
                if (this.f10131g.indexOf(charAt) < 0) {
                    sb2.append(charAt);
                }
            }
            return this.f10130f.f(sb2);
        }

        @Override // com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb2 = new StringBuilder(charSequence.length());
            for (int i10 = 0; i10 < charSequence.length(); i10++) {
                char charAt = charSequence.charAt(i10);
                if (this.f10131g.indexOf(charAt) < 0) {
                    sb2.append(charAt);
                }
            }
            return this.f10130f.i(bArr, sb2);
        }

        @Override // com.google.common.io.BaseEncoding
        @a5.c
        public InputStream k(Reader reader) {
            return this.f10130f.k(BaseEncoding.r(reader, this.f10131g));
        }

        @Override // com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            this.f10130f.n(BaseEncoding.w(appendable, this.f10131g, this.f10132h), bArr, i10, i11);
        }

        @Override // com.google.common.io.BaseEncoding
        @a5.c
        public OutputStream p(Writer writer) {
            return this.f10130f.p(BaseEncoding.x(writer, this.f10131g, this.f10132h));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding s() {
            return this.f10130f.s().B(this.f10131g, this.f10132h);
        }

        @Override // com.google.common.io.BaseEncoding
        public int t(int i10) {
            return this.f10130f.t(i10);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f10130f);
            String str = this.f10131g;
            int i10 = this.f10132h;
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 31 + String.valueOf(str).length());
            sb2.append(valueOf);
            sb2.append(".withSeparator(\"");
            sb2.append(str);
            sb2.append("\", ");
            sb2.append(i10);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public int u(int i10) {
            int u10 = this.f10130f.u(i10);
            return u10 + (this.f10131g.length() * l5.f.g(Math.max(0, u10 - 1), this.f10132h, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding v() {
            return this.f10130f.v().B(this.f10131g, this.f10132h);
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence y(CharSequence charSequence) {
            return this.f10130f.y(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding z() {
            return this.f10130f.z().B(this.f10131g, this.f10132h);
        }
    }

    public static class j extends BaseEncoding {

        /* renamed from: f */
        public final f f10133f;

        /* renamed from: g */
        @CheckForNull
        public final Character f10134g;

        /* renamed from: h */
        @CheckForNull
        @LazyInit
        public transient BaseEncoding f10135h;

        /* renamed from: i */
        @CheckForNull
        @LazyInit
        public transient BaseEncoding f10136i;

        public class a extends OutputStream {

            /* renamed from: b */
            public int f10137b = 0;

            /* renamed from: c */
            public int f10138c = 0;

            /* renamed from: d */
            public int f10139d = 0;

            /* renamed from: e */
            public final /* synthetic */ Writer f10140e;

            public a(Writer writer) {
                this.f10140e = writer;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                int i10 = this.f10138c;
                if (i10 > 0) {
                    int i11 = this.f10137b;
                    f fVar = j.this.f10133f;
                    this.f10140e.write(fVar.d((i11 << (fVar.f10124d - i10)) & fVar.f10123c));
                    this.f10139d++;
                    if (j.this.f10134g != null) {
                        while (true) {
                            int i12 = this.f10139d;
                            j jVar = j.this;
                            if (i12 % jVar.f10133f.f10125e == 0) {
                                break;
                            }
                            this.f10140e.write(jVar.f10134g.charValue());
                            this.f10139d++;
                        }
                    }
                }
                this.f10140e.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.f10140e.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i10) throws IOException {
                this.f10137b = (i10 & 255) | (this.f10137b << 8);
                this.f10138c += 8;
                while (true) {
                    int i11 = this.f10138c;
                    f fVar = j.this.f10133f;
                    int i12 = fVar.f10124d;
                    if (i11 < i12) {
                        return;
                    }
                    this.f10140e.write(fVar.d((this.f10137b >> (i11 - i12)) & fVar.f10123c));
                    this.f10139d++;
                    this.f10138c -= j.this.f10133f.f10124d;
                }
            }
        }

        public j(String str, String str2, @CheckForNull Character ch2) {
            this(new f(str, str2.toCharArray()), ch2);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding A(char c10) {
            Character ch2;
            return (8 % this.f10133f.f10124d == 0 || ((ch2 = this.f10134g) != null && ch2.charValue() == c10)) ? this : D(this.f10133f, Character.valueOf(c10));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding B(String str, int i10) {
            for (int i11 = 0; i11 < str.length(); i11++) {
                u.u(!this.f10133f.i(str.charAt(i11)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch2 = this.f10134g;
            if (ch2 != null) {
                u.u(str.indexOf(ch2.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new i(this, str, i10);
        }

        public void C(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            u.E(appendable);
            u.f0(i10, i10 + i11, bArr.length);
            int i12 = 0;
            u.d(i11 <= this.f10133f.f10126f);
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                j10 = (j10 | (bArr[i10 + i13] & 255)) << 8;
            }
            int i14 = ((i11 + 1) * 8) - this.f10133f.f10124d;
            while (i12 < i11 * 8) {
                f fVar = this.f10133f;
                appendable.append(fVar.d(((int) (j10 >>> (i14 - i12))) & fVar.f10123c));
                i12 += this.f10133f.f10124d;
            }
            if (this.f10134g != null) {
                while (i12 < this.f10133f.f10126f * 8) {
                    appendable.append(this.f10134g.charValue());
                    i12 += this.f10133f.f10124d;
                }
            }
        }

        public BaseEncoding D(f fVar, @CheckForNull Character ch2) {
            return new j(fVar, ch2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.f10133f.equals(jVar.f10133f) && r.a(this.f10134g, jVar.f10134g);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean f(CharSequence charSequence) {
            u.E(charSequence);
            CharSequence y10 = y(charSequence);
            if (!this.f10133f.g(y10.length())) {
                return false;
            }
            for (int i10 = 0; i10 < y10.length(); i10++) {
                if (!this.f10133f.b(y10.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.f10133f.hashCode() ^ r.b(this.f10134g);
        }

        @Override // com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            f fVar;
            u.E(bArr);
            CharSequence y10 = y(charSequence);
            if (!this.f10133f.g(y10.length())) {
                int length = y10.length();
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Invalid input length ");
                sb2.append(length);
                throw new DecodingException(sb2.toString());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < y10.length()) {
                long j10 = 0;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    fVar = this.f10133f;
                    if (i12 >= fVar.f10125e) {
                        break;
                    }
                    j10 <<= fVar.f10124d;
                    if (i10 + i12 < y10.length()) {
                        j10 |= this.f10133f.c(y10.charAt(i13 + i10));
                        i13++;
                    }
                    i12++;
                }
                int i14 = fVar.f10126f;
                int i15 = (i14 * 8) - (i13 * fVar.f10124d);
                int i16 = (i14 - 1) * 8;
                while (i16 >= i15) {
                    bArr[i11] = (byte) ((j10 >>> i16) & 255);
                    i16 -= 8;
                    i11++;
                }
                i10 += this.f10133f.f10125e;
            }
            return i11;
        }

        @Override // com.google.common.io.BaseEncoding
        @a5.c
        public InputStream k(Reader reader) {
            u.E(reader);
            return new b(reader);
        }

        @Override // com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            u.E(appendable);
            u.f0(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (i12 < i11) {
                C(appendable, bArr, i10 + i12, Math.min(this.f10133f.f10126f, i11 - i12));
                i12 += this.f10133f.f10126f;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        @a5.c
        public OutputStream p(Writer writer) {
            u.E(writer);
            return new a(writer);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding s() {
            BaseEncoding baseEncoding = this.f10136i;
            if (baseEncoding == null) {
                f h10 = this.f10133f.h();
                baseEncoding = h10 == this.f10133f ? this : D(h10, this.f10134g);
                this.f10136i = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public int t(int i10) {
            return (int) (((this.f10133f.f10124d * i10) + 7) / 8);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.f10133f.toString());
            if (8 % this.f10133f.f10124d != 0) {
                if (this.f10134g == null) {
                    sb2.append(".omitPadding()");
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append(this.f10134g);
                    sb2.append("')");
                }
            }
            return sb2.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public int u(int i10) {
            f fVar = this.f10133f;
            return fVar.f10125e * l5.f.g(i10, fVar.f10126f, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding v() {
            return this.f10134g == null ? this : D(this.f10133f, null);
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence y(CharSequence charSequence) {
            u.E(charSequence);
            Character ch2 = this.f10134g;
            if (ch2 == null) {
                return charSequence;
            }
            char charValue = ch2.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding z() {
            BaseEncoding baseEncoding = this.f10135h;
            if (baseEncoding == null) {
                f j10 = this.f10133f.j();
                baseEncoding = j10 == this.f10133f ? this : D(j10, this.f10134g);
                this.f10135h = baseEncoding;
            }
            return baseEncoding;
        }

        public j(f fVar, @CheckForNull Character ch2) {
            this.f10133f = (f) u.E(fVar);
            u.u(ch2 == null || !fVar.i(ch2.charValue()), "Padding character %s was already in alphabet", ch2);
            this.f10134g = ch2;
        }

        public class b extends InputStream {

            /* renamed from: b */
            public int f10142b = 0;

            /* renamed from: c */
            public int f10143c = 0;

            /* renamed from: d */
            public int f10144d = 0;

            /* renamed from: e */
            public boolean f10145e = false;

            /* renamed from: f */
            public final /* synthetic */ Reader f10146f;

            public b(Reader reader) {
                this.f10146f = reader;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f10146f.close();
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
            
                r1 = r5.f10144d;
                r2 = new java.lang.StringBuilder(41);
                r2.append("Padding cannot start at index ");
                r2.append(r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
            
                throw new com.google.common.io.BaseEncoding.DecodingException(r2.toString());
             */
            @Override // java.io.InputStream
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public int read() throws java.io.IOException {
                /*
                    r5 = this;
                L0:
                    java.io.Reader r0 = r5.f10146f
                    int r0 = r0.read()
                    r1 = -1
                    if (r0 != r1) goto L36
                    boolean r0 = r5.f10145e
                    if (r0 != 0) goto L35
                    com.google.common.io.BaseEncoding$j r0 = com.google.common.io.BaseEncoding.j.this
                    com.google.common.io.BaseEncoding$f r0 = r0.f10133f
                    int r2 = r5.f10144d
                    boolean r0 = r0.g(r2)
                    if (r0 == 0) goto L1a
                    goto L35
                L1a:
                    com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                    int r1 = r5.f10144d
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r3 = 32
                    r2.<init>(r3)
                    java.lang.String r3 = "Invalid input length "
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r1 = r2.toString()
                    r0.<init>(r1)
                    throw r0
                L35:
                    return r1
                L36:
                    int r1 = r5.f10144d
                    r2 = 1
                    int r1 = r1 + r2
                    r5.f10144d = r1
                    char r0 = (char) r0
                    com.google.common.io.BaseEncoding$j r1 = com.google.common.io.BaseEncoding.j.this
                    java.lang.Character r1 = r1.f10134g
                    if (r1 == 0) goto L7c
                    char r1 = r1.charValue()
                    if (r1 != r0) goto L7c
                    boolean r0 = r5.f10145e
                    if (r0 != 0) goto L79
                    int r0 = r5.f10144d
                    if (r0 == r2) goto L5e
                    com.google.common.io.BaseEncoding$j r1 = com.google.common.io.BaseEncoding.j.this
                    com.google.common.io.BaseEncoding$f r1 = r1.f10133f
                    int r0 = r0 + (-1)
                    boolean r0 = r1.g(r0)
                    if (r0 == 0) goto L5e
                    goto L79
                L5e:
                    com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                    int r1 = r5.f10144d
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r3 = 41
                    r2.<init>(r3)
                    java.lang.String r3 = "Padding cannot start at index "
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r1 = r2.toString()
                    r0.<init>(r1)
                    throw r0
                L79:
                    r5.f10145e = r2
                    goto L0
                L7c:
                    boolean r1 = r5.f10145e
                    if (r1 != 0) goto La8
                    int r1 = r5.f10142b
                    com.google.common.io.BaseEncoding$j r2 = com.google.common.io.BaseEncoding.j.this
                    com.google.common.io.BaseEncoding$f r2 = r2.f10133f
                    int r3 = r2.f10124d
                    int r1 = r1 << r3
                    r5.f10142b = r1
                    int r0 = r2.c(r0)
                    r0 = r0 | r1
                    r5.f10142b = r0
                    int r1 = r5.f10143c
                    com.google.common.io.BaseEncoding$j r2 = com.google.common.io.BaseEncoding.j.this
                    com.google.common.io.BaseEncoding$f r2 = r2.f10133f
                    int r2 = r2.f10124d
                    int r1 = r1 + r2
                    r5.f10143c = r1
                    r2 = 8
                    if (r1 < r2) goto L0
                    int r1 = r1 - r2
                    r5.f10143c = r1
                    int r0 = r0 >> r1
                    r0 = r0 & 255(0xff, float:3.57E-43)
                    return r0
                La8:
                    com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                    int r2 = r5.f10144d
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r4 = 61
                    r3.<init>(r4)
                    java.lang.String r4 = "Expected padding character but found '"
                    r3.append(r4)
                    r3.append(r0)
                    java.lang.String r0 = "' at index "
                    r3.append(r0)
                    r3.append(r2)
                    java.lang.String r0 = r3.toString()
                    r1.<init>(r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.j.b.read():int");
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = i11 + i10;
                u.f0(i10, i12, bArr.length);
                int i13 = i10;
                while (i13 < i12) {
                    int read = read();
                    if (read == -1) {
                        int i14 = i13 - i10;
                        if (i14 == 0) {
                            return -1;
                        }
                        return i14;
                    }
                    bArr[i13] = (byte) read;
                    i13++;
                }
                return i13 - i10;
            }
        }
    }

    public static BaseEncoding a() {
        return f10108e;
    }

    public static BaseEncoding b() {
        return f10106c;
    }

    public static BaseEncoding c() {
        return f10107d;
    }

    public static BaseEncoding d() {
        return f10104a;
    }

    public static BaseEncoding e() {
        return f10105b;
    }

    public static byte[] q(byte[] bArr, int i10) {
        if (i10 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        return bArr2;
    }

    @a5.c
    public static Reader r(Reader reader, String str) {
        u.E(reader);
        u.E(str);
        return new c(reader, str);
    }

    public static Appendable w(Appendable appendable, String str, int i10) {
        u.E(appendable);
        u.E(str);
        u.d(i10 > 0);
        return new d(i10, appendable, str);
    }

    @a5.c
    public static Writer x(Writer writer, String str, int i10) {
        return new e(w(writer, str, i10), writer);
    }

    public abstract BaseEncoding A(char c10);

    public abstract BaseEncoding B(String str, int i10);

    public abstract boolean f(CharSequence charSequence);

    public final byte[] g(CharSequence charSequence) {
        try {
            return h(charSequence);
        } catch (DecodingException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public final byte[] h(CharSequence charSequence) throws DecodingException {
        CharSequence y10 = y(charSequence);
        byte[] bArr = new byte[t(y10.length())];
        return q(bArr, i(bArr, y10));
    }

    public abstract int i(byte[] bArr, CharSequence charSequence) throws DecodingException;

    @a5.c
    public final k5.f j(k5.j jVar) {
        u.E(jVar);
        return new b(jVar);
    }

    @a5.c
    public abstract InputStream k(Reader reader);

    public String l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public final String m(byte[] bArr, int i10, int i11) {
        u.f0(i10, i10 + i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(u(i11));
        try {
            n(sb2, bArr, i10, i11);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public abstract void n(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException;

    @a5.c
    public final k5.e o(k5.i iVar) {
        u.E(iVar);
        return new a(iVar);
    }

    @a5.c
    public abstract OutputStream p(Writer writer);

    public abstract BaseEncoding s();

    public abstract int t(int i10);

    public abstract int u(int i10);

    public abstract BaseEncoding v();

    public CharSequence y(CharSequence charSequence) {
        return (CharSequence) u.E(charSequence);
    }

    public abstract BaseEncoding z();

    public class c extends Reader {

        /* renamed from: b */
        public final /* synthetic */ Reader f10113b;

        /* renamed from: c */
        public final /* synthetic */ String f10114c;

        public c(Reader reader, String str) {
            this.f10113b = reader;
            this.f10114c = str;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f10113b.close();
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            int read;
            do {
                read = this.f10113b.read();
                if (read == -1) {
                    break;
                }
            } while (this.f10114c.indexOf((char) read) >= 0);
            return read;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public class d implements Appendable {

        /* renamed from: b */
        public int f10115b;

        /* renamed from: c */
        public final /* synthetic */ int f10116c;

        /* renamed from: d */
        public final /* synthetic */ Appendable f10117d;

        /* renamed from: e */
        public final /* synthetic */ String f10118e;

        public d(int i10, Appendable appendable, String str) {
            this.f10116c = i10;
            this.f10117d = appendable;
            this.f10118e = str;
            this.f10115b = i10;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            if (this.f10115b == 0) {
                this.f10117d.append(this.f10118e);
                this.f10115b = this.f10116c;
            }
            this.f10117d.append(c10);
            this.f10115b--;
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@CheckForNull CharSequence charSequence, int i10, int i11) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Appendable
        public Appendable append(@CheckForNull CharSequence charSequence) {
            throw new UnsupportedOperationException();
        }
    }
}
