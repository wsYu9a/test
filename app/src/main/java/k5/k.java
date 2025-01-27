package k5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

@p
@a5.c
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a */
    public static final int f27665a = 2048;

    public static final class a extends Writer {

        /* renamed from: b */
        public static final a f27666b = new a();

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i10) {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            b5.u.E(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            b5.u.f0(i10, i11 + i10, cArr.length);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence) {
            return this;
        }

        @Override // java.io.Writer
        public void write(String str) {
            b5.u.E(str);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence, int i10, int i11) {
            b5.u.f0(i10, i11, charSequence == null ? 4 : charSequence.length());
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) {
            b5.u.f0(i10, i11 + i10, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c10) {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }

    @a5.a
    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new k5.a(appendable);
    }

    @CanIgnoreReturnValue
    public static long b(Readable readable, Appendable appendable) throws IOException {
        if (readable instanceof Reader) {
            return appendable instanceof StringBuilder ? c((Reader) readable, (StringBuilder) appendable) : d((Reader) readable, a(appendable));
        }
        b5.u.E(readable);
        b5.u.E(appendable);
        CharBuffer e10 = e();
        long j10 = 0;
        while (readable.read(e10) != -1) {
            s.b(e10);
            appendable.append(e10);
            j10 += e10.remaining();
            s.a(e10);
        }
        return j10;
    }

    @CanIgnoreReturnValue
    public static long c(Reader reader, StringBuilder sb2) throws IOException {
        b5.u.E(reader);
        b5.u.E(sb2);
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j10;
            }
            sb2.append(cArr, 0, read);
            j10 += read;
        }
    }

    @CanIgnoreReturnValue
    public static long d(Reader reader, Writer writer) throws IOException {
        b5.u.E(reader);
        b5.u.E(writer);
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j10;
            }
            writer.write(cArr, 0, read);
            j10 += read;
        }
    }

    public static CharBuffer e() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    @a5.a
    public static long f(Readable readable) throws IOException {
        CharBuffer e10 = e();
        long j10 = 0;
        while (true) {
            long read = readable.read(e10);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            s.a(e10);
        }
    }

    @a5.a
    public static Writer g() {
        return a.f27666b;
    }

    @a5.a
    @a0
    @CanIgnoreReturnValue
    public static <T> T h(Readable readable, u<T> uVar) throws IOException {
        String b10;
        b5.u.E(readable);
        b5.u.E(uVar);
        v vVar = new v(readable);
        do {
            b10 = vVar.b();
            if (b10 == null) {
                break;
            }
        } while (uVar.b(b10));
        return uVar.a();
    }

    @a5.a
    public static List<String> i(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        v vVar = new v(readable);
        while (true) {
            String b10 = vVar.b();
            if (b10 == null) {
                return arrayList;
            }
            arrayList.add(b10);
        }
    }

    @a5.a
    public static void j(Reader reader, long j10) throws IOException {
        b5.u.E(reader);
        while (j10 > 0) {
            long skip = reader.skip(j10);
            if (skip == 0) {
                throw new EOFException();
            }
            j10 -= skip;
        }
    }

    public static String k(Readable readable) throws IOException {
        return l(readable).toString();
    }

    public static StringBuilder l(Readable readable) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        if (readable instanceof Reader) {
            c((Reader) readable, sb2);
        } else {
            b(readable, sb2);
        }
        return sb2;
    }
}
