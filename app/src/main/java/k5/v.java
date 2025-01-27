package k5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.CheckForNull;

@p
@a5.a
@a5.c
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a */
    public final Readable f27689a;

    /* renamed from: b */
    @CheckForNull
    public final Reader f27690b;

    /* renamed from: c */
    public final CharBuffer f27691c;

    /* renamed from: d */
    public final char[] f27692d;

    /* renamed from: e */
    public final Queue<String> f27693e;

    /* renamed from: f */
    public final t f27694f;

    public class a extends t {
        public a() {
        }

        @Override // k5.t
        public void d(String str, String str2) {
            v.this.f27693e.add(str);
        }
    }

    public v(Readable readable) {
        CharBuffer e10 = k.e();
        this.f27691c = e10;
        this.f27692d = e10.array();
        this.f27693e = new ArrayDeque();
        this.f27694f = new a();
        this.f27689a = (Readable) b5.u.E(readable);
        this.f27690b = readable instanceof Reader ? (Reader) readable : null;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public String b() throws IOException {
        int read;
        while (true) {
            if (this.f27693e.peek() != null) {
                break;
            }
            s.a(this.f27691c);
            Reader reader = this.f27690b;
            if (reader != null) {
                char[] cArr = this.f27692d;
                read = reader.read(cArr, 0, cArr.length);
            } else {
                read = this.f27689a.read(this.f27691c);
            }
            if (read == -1) {
                this.f27694f.b();
                break;
            }
            this.f27694f.a(this.f27692d, 0, read);
        }
        return this.f27693e.poll();
    }
}
