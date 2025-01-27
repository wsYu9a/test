package k5;

import com.google.common.base.Optional;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.martian.libmars.widget.FoldedTextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@p
@a5.c
/* loaded from: classes2.dex */
public abstract class j {

    public final class a extends f {

        /* renamed from: a */
        public final Charset f27657a;

        public a(Charset charset) {
            this.f27657a = (Charset) b5.u.E(charset);
        }

        @Override // k5.f
        public j a(Charset charset) {
            return charset.equals(this.f27657a) ? j.this : super.a(charset);
        }

        @Override // k5.f
        public InputStream m() throws IOException {
            return new c0(j.this.m(), this.f27657a, 8192);
        }

        public String toString() {
            String obj = j.this.toString();
            String valueOf = String.valueOf(this.f27657a);
            StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 15 + valueOf.length());
            sb2.append(obj);
            sb2.append(".asByteSource(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class b extends j {

        /* renamed from: b */
        public static final com.google.common.base.c f27659b = com.google.common.base.c.m("\r\n|\n|\r");

        /* renamed from: a */
        public final CharSequence f27660a;

        public class a extends AbstractIterator<String> {

            /* renamed from: d */
            public Iterator<String> f27661d;

            public a() {
                this.f27661d = b.f27659b.n(b.this.f27660a).iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public String a() {
                if (this.f27661d.hasNext()) {
                    String next = this.f27661d.next();
                    if (this.f27661d.hasNext() || !next.isEmpty()) {
                        return next;
                    }
                }
                return b();
            }
        }

        public b(CharSequence charSequence) {
            this.f27660a = (CharSequence) b5.u.E(charSequence);
        }

        @Override // k5.j
        public boolean i() {
            return this.f27660a.length() == 0;
        }

        @Override // k5.j
        public long j() {
            return this.f27660a.length();
        }

        @Override // k5.j
        public Optional<Long> k() {
            return Optional.of(Long.valueOf(this.f27660a.length()));
        }

        @Override // k5.j
        public Reader m() {
            return new h(this.f27660a);
        }

        @Override // k5.j
        public String n() {
            return this.f27660a.toString();
        }

        @Override // k5.j
        @CheckForNull
        public String o() {
            Iterator<String> t10 = t();
            if (t10.hasNext()) {
                return t10.next();
            }
            return null;
        }

        @Override // k5.j
        public ImmutableList<String> p() {
            return ImmutableList.copyOf(t());
        }

        @Override // k5.j
        @a0
        public <T> T q(u<T> uVar) throws IOException {
            Iterator<String> t10 = t();
            while (t10.hasNext() && uVar.b(t10.next())) {
            }
            return uVar.a();
        }

        public final Iterator<String> t() {
            return new a();
        }

        public String toString() {
            String k10 = b5.a.k(this.f27660a, 30, FoldedTextView.f12585y);
            StringBuilder sb2 = new StringBuilder(String.valueOf(k10).length() + 17);
            sb2.append("CharSource.wrap(");
            sb2.append(k10);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class c extends j {

        /* renamed from: a */
        public final Iterable<? extends j> f27663a;

        public c(Iterable<? extends j> iterable) {
            this.f27663a = (Iterable) b5.u.E(iterable);
        }

        @Override // k5.j
        public boolean i() throws IOException {
            Iterator<? extends j> it = this.f27663a.iterator();
            while (it.hasNext()) {
                if (!it.next().i()) {
                    return false;
                }
            }
            return true;
        }

        @Override // k5.j
        public long j() throws IOException {
            Iterator<? extends j> it = this.f27663a.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                j10 += it.next().j();
            }
            return j10;
        }

        @Override // k5.j
        public Optional<Long> k() {
            Iterator<? extends j> it = this.f27663a.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                Optional<Long> k10 = it.next().k();
                if (!k10.isPresent()) {
                    return Optional.absent();
                }
                j10 += k10.get().longValue();
            }
            return Optional.of(Long.valueOf(j10));
        }

        @Override // k5.j
        public Reader m() throws IOException {
            return new z(this.f27663a.iterator());
        }

        public String toString() {
            String valueOf = String.valueOf(this.f27663a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
            sb2.append("CharSource.concat(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class d extends e {

        /* renamed from: c */
        public static final d f27664c = new d();

        public d() {
            super("");
        }

        @Override // k5.j.b
        public String toString() {
            return "CharSource.empty()";
        }
    }

    public static class e extends b {
        public e(String str) {
            super(str);
        }

        @Override // k5.j
        public long e(Appendable appendable) throws IOException {
            appendable.append(this.f27660a);
            return this.f27660a.length();
        }

        @Override // k5.j
        public long f(i iVar) throws IOException {
            b5.u.E(iVar);
            try {
                ((Writer) m.a().b(iVar.b())).write((String) this.f27660a);
                return this.f27660a.length();
            } finally {
            }
        }

        @Override // k5.j.b, k5.j
        public Reader m() {
            return new StringReader((String) this.f27660a);
        }
    }

    public static j b(Iterable<? extends j> iterable) {
        return new c(iterable);
    }

    public static j c(Iterator<? extends j> it) {
        return b(ImmutableList.copyOf(it));
    }

    public static j d(j... jVarArr) {
        return b(ImmutableList.copyOf(jVarArr));
    }

    public static j h() {
        return d.f27664c;
    }

    public static j r(CharSequence charSequence) {
        return charSequence instanceof String ? new e((String) charSequence) : new b(charSequence);
    }

    @a5.a
    public f a(Charset charset) {
        return new a(charset);
    }

    @CanIgnoreReturnValue
    public long e(Appendable appendable) throws IOException {
        b5.u.E(appendable);
        try {
            return k.b((Reader) m.a().b(m()), appendable);
        } finally {
        }
    }

    @CanIgnoreReturnValue
    public long f(i iVar) throws IOException {
        b5.u.E(iVar);
        m a10 = m.a();
        try {
            return k.b((Reader) a10.b(m()), (Writer) a10.b(iVar.b()));
        } finally {
        }
    }

    public final long g(Reader reader) throws IOException {
        long j10 = 0;
        while (true) {
            long skip = reader.skip(Long.MAX_VALUE);
            if (skip == 0) {
                return j10;
            }
            j10 += skip;
        }
    }

    public boolean i() throws IOException {
        Optional<Long> k10 = k();
        if (k10.isPresent()) {
            return k10.get().longValue() == 0;
        }
        m a10 = m.a();
        try {
            return ((Reader) a10.b(m())).read() == -1;
        } catch (Throwable th2) {
            try {
                throw a10.c(th2);
            } finally {
                a10.close();
            }
        }
    }

    @a5.a
    public long j() throws IOException {
        Optional<Long> k10 = k();
        if (k10.isPresent()) {
            return k10.get().longValue();
        }
        try {
            return g((Reader) m.a().b(m()));
        } finally {
        }
    }

    @a5.a
    public Optional<Long> k() {
        return Optional.absent();
    }

    public BufferedReader l() throws IOException {
        Reader m10 = m();
        return m10 instanceof BufferedReader ? (BufferedReader) m10 : new BufferedReader(m10);
    }

    public abstract Reader m() throws IOException;

    public String n() throws IOException {
        try {
            return k.k((Reader) m.a().b(m()));
        } finally {
        }
    }

    @CheckForNull
    public String o() throws IOException {
        try {
            return ((BufferedReader) m.a().b(l())).readLine();
        } finally {
        }
    }

    public ImmutableList<String> p() throws IOException {
        try {
            BufferedReader bufferedReader = (BufferedReader) m.a().b(l());
            ArrayList q10 = Lists.q();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return ImmutableList.copyOf((Collection) q10);
                }
                q10.add(readLine);
            }
        } finally {
        }
    }

    @a5.a
    @a0
    @CanIgnoreReturnValue
    public <T> T q(u<T> uVar) throws IOException {
        b5.u.E(uVar);
        try {
            return (T) k.h((Reader) m.a().b(m()), uVar);
        } finally {
        }
    }
}
