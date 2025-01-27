package k5;

import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@p
@a5.c
/* loaded from: classes2.dex */
public final class d0 {

    public class a implements u<List<String>> {

        /* renamed from: a */
        public final List<String> f27630a = Lists.q();

        @Override // k5.u
        public boolean b(String str) {
            this.f27630a.add(str);
            return true;
        }

        @Override // k5.u
        /* renamed from: c */
        public List<String> a() {
            return this.f27630a;
        }
    }

    public static final class b extends f {

        /* renamed from: a */
        public final URL f27631a;

        public /* synthetic */ b(URL url, a aVar) {
            this(url);
        }

        @Override // k5.f
        public InputStream m() throws IOException {
            return this.f27631a.openStream();
        }

        public String toString() {
            String valueOf = String.valueOf(this.f27631a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
            sb2.append("Resources.asByteSource(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        public b(URL url) {
            this.f27631a = (URL) b5.u.E(url);
        }
    }

    public static f a(URL url) {
        return new b(url, null);
    }

    public static j b(URL url, Charset charset) {
        return a(url).a(charset);
    }

    public static void c(URL url, OutputStream outputStream) throws IOException {
        a(url).f(outputStream);
    }

    @CanIgnoreReturnValue
    public static URL d(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        b5.u.y(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }

    @CanIgnoreReturnValue
    public static URL e(String str) {
        URL resource = ((ClassLoader) com.google.common.base.a.a(Thread.currentThread().getContextClassLoader(), d0.class.getClassLoader())).getResource(str);
        b5.u.u(resource != null, "resource %s not found.", str);
        return resource;
    }

    @CanIgnoreReturnValue
    @a0
    public static <T> T f(URL url, Charset charset, u<T> uVar) throws IOException {
        return (T) b(url, charset).q(uVar);
    }

    public static List<String> g(URL url, Charset charset) throws IOException {
        return (List) f(url, charset, new a());
    }

    public static byte[] h(URL url) throws IOException {
        return a(url).o();
    }

    public static String i(URL url, Charset charset) throws IOException {
        return b(url, charset).n();
    }
}
