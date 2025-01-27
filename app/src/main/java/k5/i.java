package k5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

@p
@a5.c
/* loaded from: classes2.dex */
public abstract class i {
    public Writer a() throws IOException {
        Writer b10 = b();
        return b10 instanceof BufferedWriter ? (BufferedWriter) b10 : new BufferedWriter(b10);
    }

    public abstract Writer b() throws IOException;

    public void c(CharSequence charSequence) throws IOException {
        b5.u.E(charSequence);
        try {
            Writer writer = (Writer) m.a().b(b());
            writer.append(charSequence);
            writer.flush();
        } finally {
        }
    }

    @CanIgnoreReturnValue
    public long d(Readable readable) throws IOException {
        b5.u.E(readable);
        try {
            Writer writer = (Writer) m.a().b(b());
            long b10 = k.b(readable, writer);
            writer.flush();
            return b10;
        } finally {
        }
    }

    public void e(Iterable<? extends CharSequence> iterable) throws IOException {
        f(iterable, System.getProperty("line.separator"));
    }

    public void f(Iterable<? extends CharSequence> iterable, String str) throws IOException {
        b5.u.E(iterable);
        b5.u.E(str);
        try {
            Writer writer = (Writer) m.a().b(a());
            Iterator<? extends CharSequence> it = iterable.iterator();
            while (it.hasNext()) {
                writer.append(it.next()).append((CharSequence) str);
            }
            writer.flush();
        } finally {
        }
    }
}
