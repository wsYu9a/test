package k5;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.io.BaseEncoding;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.martian.libmars.widget.FoldedTextView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@p
@a5.c
/* loaded from: classes2.dex */
public abstract class f {

    public class a extends j {

        /* renamed from: a */
        public final Charset f27634a;

        public a(Charset charset) {
            this.f27634a = (Charset) b5.u.E(charset);
        }

        @Override // k5.j
        public f a(Charset charset) {
            return charset.equals(this.f27634a) ? f.this : super.a(charset);
        }

        @Override // k5.j
        public Reader m() throws IOException {
            return new InputStreamReader(f.this.m(), this.f27634a);
        }

        @Override // k5.j
        public String n() throws IOException {
            return new String(f.this.o(), this.f27634a);
        }

        public String toString() {
            String obj = f.this.toString();
            String valueOf = String.valueOf(this.f27634a);
            StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 15 + valueOf.length());
            sb2.append(obj);
            sb2.append(".asCharSource(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class b extends f {

        /* renamed from: a */
        public final byte[] f27636a;

        /* renamed from: b */
        public final int f27637b;

        /* renamed from: c */
        public final int f27638c;

        public b(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // k5.f
        public long f(OutputStream outputStream) throws IOException {
            outputStream.write(this.f27636a, this.f27637b, this.f27638c);
            return this.f27638c;
        }

        @Override // k5.f
        public HashCode j(i5.k kVar) throws IOException {
            return kVar.hashBytes(this.f27636a, this.f27637b, this.f27638c);
        }

        @Override // k5.f
        public boolean k() {
            return this.f27638c == 0;
        }

        @Override // k5.f
        public InputStream l() throws IOException {
            return m();
        }

        @Override // k5.f
        public InputStream m() {
            return new ByteArrayInputStream(this.f27636a, this.f27637b, this.f27638c);
        }

        @Override // k5.f
        @a0
        public <T> T n(k5.d<T> dVar) throws IOException {
            dVar.b(this.f27636a, this.f27637b, this.f27638c);
            return dVar.a();
        }

        @Override // k5.f
        public byte[] o() {
            byte[] bArr = this.f27636a;
            int i10 = this.f27637b;
            return Arrays.copyOfRange(bArr, i10, this.f27638c + i10);
        }

        @Override // k5.f
        public long p() {
            return this.f27638c;
        }

        @Override // k5.f
        public Optional<Long> q() {
            return Optional.of(Long.valueOf(this.f27638c));
        }

        @Override // k5.f
        public f r(long j10, long j11) {
            b5.u.p(j10 >= 0, "offset (%s) may not be negative", j10);
            b5.u.p(j11 >= 0, "length (%s) may not be negative", j11);
            long min = Math.min(j10, this.f27638c);
            return new b(this.f27636a, this.f27637b + ((int) min), (int) Math.min(j11, this.f27638c - min));
        }

        public String toString() {
            String k10 = b5.a.k(BaseEncoding.a().m(this.f27636a, this.f27637b, this.f27638c), 30, FoldedTextView.f12585y);
            StringBuilder sb2 = new StringBuilder(String.valueOf(k10).length() + 17);
            sb2.append("ByteSource.wrap(");
            sb2.append(k10);
            sb2.append(")");
            return sb2.toString();
        }

        public b(byte[] bArr, int i10, int i11) {
            this.f27636a = bArr;
            this.f27637b = i10;
            this.f27638c = i11;
        }
    }

    public static final class c extends f {

        /* renamed from: a */
        public final Iterable<? extends f> f27639a;

        public c(Iterable<? extends f> iterable) {
            this.f27639a = (Iterable) b5.u.E(iterable);
        }

        @Override // k5.f
        public boolean k() throws IOException {
            Iterator<? extends f> it = this.f27639a.iterator();
            while (it.hasNext()) {
                if (!it.next().k()) {
                    return false;
                }
            }
            return true;
        }

        @Override // k5.f
        public InputStream m() throws IOException {
            return new y(this.f27639a.iterator());
        }

        @Override // k5.f
        public long p() throws IOException {
            Iterator<? extends f> it = this.f27639a.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                j10 += it.next().p();
                if (j10 < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j10;
        }

        @Override // k5.f
        public Optional<Long> q() {
            Iterable<? extends f> iterable = this.f27639a;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            Iterator<? extends f> it = iterable.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                Optional<Long> q10 = it.next().q();
                if (!q10.isPresent()) {
                    return Optional.absent();
                }
                j10 += q10.get().longValue();
                if (j10 < 0) {
                    return Optional.of(Long.MAX_VALUE);
                }
            }
            return Optional.of(Long.valueOf(j10));
        }

        public String toString() {
            String valueOf = String.valueOf(this.f27639a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
            sb2.append("ByteSource.concat(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class d extends b {

        /* renamed from: d */
        public static final d f27640d = new d();

        public d() {
            super(new byte[0]);
        }

        @Override // k5.f
        public j a(Charset charset) {
            b5.u.E(charset);
            return j.h();
        }

        @Override // k5.f.b, k5.f
        public byte[] o() {
            return this.f27636a;
        }

        @Override // k5.f.b
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    public final class e extends f {

        /* renamed from: a */
        public final long f27641a;

        /* renamed from: b */
        public final long f27642b;

        public e(long j10, long j11) {
            b5.u.p(j10 >= 0, "offset (%s) may not be negative", j10);
            b5.u.p(j11 >= 0, "length (%s) may not be negative", j11);
            this.f27641a = j10;
            this.f27642b = j11;
        }

        @Override // k5.f
        public boolean k() throws IOException {
            return this.f27642b == 0 || super.k();
        }

        @Override // k5.f
        public InputStream l() throws IOException {
            return t(f.this.l());
        }

        @Override // k5.f
        public InputStream m() throws IOException {
            return t(f.this.m());
        }

        @Override // k5.f
        public Optional<Long> q() {
            Optional<Long> q10 = f.this.q();
            if (!q10.isPresent()) {
                return Optional.absent();
            }
            long longValue = q10.get().longValue();
            return Optional.of(Long.valueOf(Math.min(this.f27642b, longValue - Math.min(this.f27641a, longValue))));
        }

        @Override // k5.f
        public f r(long j10, long j11) {
            b5.u.p(j10 >= 0, "offset (%s) may not be negative", j10);
            b5.u.p(j11 >= 0, "length (%s) may not be negative", j11);
            long j12 = this.f27642b - j10;
            return j12 <= 0 ? f.i() : f.this.r(this.f27641a + j10, Math.min(j11, j12));
        }

        public final InputStream t(InputStream inputStream) throws IOException {
            long j10 = this.f27641a;
            if (j10 > 0) {
                try {
                    if (g.t(inputStream, j10) < this.f27641a) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } finally {
                }
            }
            return g.f(inputStream, this.f27642b);
        }

        public String toString() {
            String obj = f.this.toString();
            long j10 = this.f27641a;
            long j11 = this.f27642b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 50);
            sb2.append(obj);
            sb2.append(".slice(");
            sb2.append(j10);
            sb2.append(", ");
            sb2.append(j11);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static f b(Iterable<? extends f> iterable) {
        return new c(iterable);
    }

    public static f c(Iterator<? extends f> it) {
        return b(ImmutableList.copyOf(it));
    }

    public static f d(f... fVarArr) {
        return b(ImmutableList.copyOf(fVarArr));
    }

    public static f i() {
        return d.f27640d;
    }

    public static f s(byte[] bArr) {
        return new b(bArr);
    }

    public j a(Charset charset) {
        return new a(charset);
    }

    public boolean e(f fVar) throws IOException {
        int n10;
        b5.u.E(fVar);
        byte[] d10 = g.d();
        byte[] d11 = g.d();
        m a10 = m.a();
        try {
            InputStream inputStream = (InputStream) a10.b(m());
            InputStream inputStream2 = (InputStream) a10.b(fVar.m());
            do {
                n10 = g.n(inputStream, d10, 0, d10.length);
                if (n10 == g.n(inputStream2, d11, 0, d11.length) && Arrays.equals(d10, d11)) {
                }
                return false;
            } while (n10 == d10.length);
            a10.close();
            return true;
        } finally {
        }
    }

    @CanIgnoreReturnValue
    public long f(OutputStream outputStream) throws IOException {
        b5.u.E(outputStream);
        try {
            return g.b((InputStream) m.a().b(m()), outputStream);
        } finally {
        }
    }

    @CanIgnoreReturnValue
    public long g(k5.e eVar) throws IOException {
        b5.u.E(eVar);
        m a10 = m.a();
        try {
            return g.b((InputStream) a10.b(m()), (OutputStream) a10.b(eVar.c()));
        } finally {
        }
    }

    public final long h(InputStream inputStream) throws IOException {
        long j10 = 0;
        while (true) {
            long t10 = g.t(inputStream, 2147483647L);
            if (t10 <= 0) {
                return j10;
            }
            j10 += t10;
        }
    }

    public HashCode j(i5.k kVar) throws IOException {
        i5.m newHasher = kVar.newHasher();
        f(Funnels.a(newHasher));
        return newHasher.i();
    }

    public boolean k() throws IOException {
        Optional<Long> q10 = q();
        if (q10.isPresent()) {
            return q10.get().longValue() == 0;
        }
        m a10 = m.a();
        try {
            return ((InputStream) a10.b(m())).read() == -1;
        } catch (Throwable th2) {
            try {
                throw a10.c(th2);
            } finally {
                a10.close();
            }
        }
    }

    public InputStream l() throws IOException {
        InputStream m10 = m();
        return m10 instanceof BufferedInputStream ? (BufferedInputStream) m10 : new BufferedInputStream(m10);
    }

    public abstract InputStream m() throws IOException;

    @CanIgnoreReturnValue
    @a5.a
    public <T> T n(k5.d<T> dVar) throws IOException {
        b5.u.E(dVar);
        try {
            return (T) g.o((InputStream) m.a().b(m()), dVar);
        } finally {
        }
    }

    public byte[] o() throws IOException {
        m a10 = m.a();
        try {
            InputStream inputStream = (InputStream) a10.b(m());
            Optional<Long> q10 = q();
            return q10.isPresent() ? g.v(inputStream, q10.get().longValue()) : g.u(inputStream);
        } catch (Throwable th2) {
            try {
                throw a10.c(th2);
            } finally {
                a10.close();
            }
        }
    }

    public long p() throws IOException {
        Optional<Long> q10 = q();
        if (q10.isPresent()) {
            return q10.get().longValue();
        }
        m a10 = m.a();
        try {
            return h((InputStream) a10.b(m()));
        } catch (IOException unused) {
            a10.close();
            try {
                return g.e((InputStream) m.a().b(m()));
            } finally {
            }
        } finally {
        }
    }

    @a5.a
    public Optional<Long> q() {
        return Optional.absent();
    }

    public f r(long j10, long j11) {
        return new e(j10, j11);
    }
}
