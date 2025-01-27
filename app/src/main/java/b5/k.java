package b5;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@g
@a5.c
/* loaded from: classes2.dex */
public class k implements Closeable {

    /* renamed from: f */
    public static final String f1256f = "com.google.common.base.internal.Finalizer";

    /* renamed from: b */
    public final ReferenceQueue<Object> f1258b;

    /* renamed from: c */
    public final PhantomReference<Object> f1259c;

    /* renamed from: d */
    public final boolean f1260d;

    /* renamed from: e */
    public static final Logger f1255e = Logger.getLogger(k.class.getName());

    /* renamed from: g */
    public static final Method f1257g = c(d(new d(), new a(), new b()));

    public static class a implements c {

        /* renamed from: a */
        public static final String f1261a = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        @Override // b5.k.c
        @CheckForNull
        public Class<?> a() {
            try {
                return c(b()).loadClass(k.f1256f);
            } catch (Exception e10) {
                k.f1255e.log(Level.WARNING, f1261a, (Throwable) e10);
                return null;
            }
        }

        public URL b() throws IOException {
            String concat = String.valueOf(k.f1256f.replace('.', '/')).concat(o5.c.f29046d);
            URL resource = getClass().getClassLoader().getResource(concat);
            if (resource == null) {
                throw new FileNotFoundException(concat);
            }
            String url = resource.toString();
            if (url.endsWith(concat)) {
                return new URL(resource, url.substring(0, url.length() - concat.length()));
            }
            throw new IOException(url.length() != 0 ? "Unsupported path style: ".concat(url) : new String("Unsupported path style: "));
        }

        public URLClassLoader c(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    public static class b implements c {
        @Override // b5.k.c
        public Class<?> a() {
            try {
                return Class.forName("c5.a");
            } catch (ClassNotFoundException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public interface c {
        @CheckForNull
        Class<?> a();
    }

    public static class d implements c {

        /* renamed from: a */
        @a5.d
        public static boolean f1262a;

        @Override // b5.k.c
        @CheckForNull
        public Class<?> a() {
            if (f1262a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(k.f1256f);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                k.f1255e.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public k() {
        boolean z10 = true;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f1258b = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.f1259c = phantomReference;
        try {
            f1257g.invoke(null, j.class, referenceQueue, phantomReference);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (Throwable th2) {
            f1255e.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th2);
            z10 = false;
        }
        this.f1260d = z10;
    }

    public static Method c(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e10) {
            throw new AssertionError(e10);
        }
    }

    public static Class<?> d(c... cVarArr) {
        for (c cVar : cVarArr) {
            Class<?> a10 = cVar.a();
            if (a10 != null) {
                return a10;
            }
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b() {
        if (this.f1260d) {
            return;
        }
        while (true) {
            Reference<? extends Object> poll = this.f1258b.poll();
            if (poll == 0) {
                return;
            }
            poll.clear();
            try {
                ((j) poll).a();
            } catch (Throwable th2) {
                f1255e.log(Level.SEVERE, "Error cleaning up after reference.", th2);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1259c.enqueue();
        b();
    }
}
