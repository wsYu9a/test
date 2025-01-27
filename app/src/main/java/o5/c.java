package o5;

import b5.u;
import b5.v;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import e5.w;
import e5.z1;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import k5.d0;
import o5.c;

@d
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: b */
    public static final Logger f29044b = Logger.getLogger(c.class.getName());

    /* renamed from: c */
    public static final com.google.common.base.c f29045c = com.google.common.base.c.k(" ").g();

    /* renamed from: d */
    public static final String f29046d = ".class";

    /* renamed from: a */
    public final ImmutableSet<C0751c> f29047a;

    public static final class a extends C0751c {

        /* renamed from: d */
        public final String f29048d;

        public a(File file, String str, ClassLoader classLoader) {
            super(file, str, classLoader);
            this.f29048d = c.e(str);
        }

        public String g() {
            return this.f29048d;
        }

        public String h() {
            return j.b(this.f29048d);
        }

        public String i() {
            int lastIndexOf = this.f29048d.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return b5.b.m('0', '9').V(this.f29048d.substring(lastIndexOf + 1));
            }
            String h10 = h();
            return h10.isEmpty() ? this.f29048d : this.f29048d.substring(h10.length() + 1);
        }

        public boolean j() {
            return this.f29048d.indexOf(36) == -1;
        }

        public Class<?> k() {
            try {
                return this.f29053c.loadClass(this.f29048d);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // o5.c.C0751c
        public String toString() {
            return this.f29048d;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final File f29049a;

        /* renamed from: b */
        public final ClassLoader f29050b;

        public b(File file, ClassLoader classLoader) {
            this.f29049a = (File) u.E(file);
            this.f29050b = (ClassLoader) u.E(classLoader);
        }

        public final File a() {
            return this.f29049a;
        }

        public final void b(File file, Set<File> set, ImmutableSet.a<C0751c> aVar) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        c(file, aVar);
                    } else {
                        e(file, set, aVar);
                    }
                }
            } catch (SecurityException e10) {
                Logger logger = c.f29044b;
                String valueOf = String.valueOf(file);
                String valueOf2 = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 16 + valueOf2.length());
                sb2.append("Cannot access ");
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                logger.warning(sb2.toString());
            }
        }

        public final void c(File file, ImmutableSet.a<C0751c> aVar) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            d(file, "", hashSet, aVar);
        }

        public final void d(File file, String str, Set<File> set, ImmutableSet.a<C0751c> aVar) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Logger logger = c.f29044b;
                String valueOf = String.valueOf(file);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
                sb2.append("Cannot read directory ");
                sb2.append(valueOf);
                logger.warning(sb2.toString());
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(name).length());
                        sb3.append(str);
                        sb3.append(name);
                        sb3.append("/");
                        d(canonicalFile, sb3.toString(), set, aVar);
                        set.remove(canonicalFile);
                    }
                } else {
                    String valueOf2 = String.valueOf(str);
                    String valueOf3 = String.valueOf(name);
                    String concat = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
                    if (!concat.equals("META-INF/MANIFEST.MF")) {
                        aVar.g(C0751c.e(file2, concat, this.f29050b));
                    }
                }
            }
        }

        public final void e(File file, Set<File> set, ImmutableSet.a<C0751c> aVar) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    z1<File> it = c.h(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        File next = it.next();
                        if (set.add(next.getCanonicalFile())) {
                            b(next, set, aVar);
                        }
                    }
                    f(jarFile, aVar);
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                    } catch (IOException unused2) {
                    }
                    throw th2;
                }
            } catch (IOException unused3) {
            }
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f29049a.equals(bVar.f29049a) && this.f29050b.equals(bVar.f29050b);
        }

        public final void f(JarFile jarFile, ImmutableSet.a<C0751c> aVar) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    aVar.g(C0751c.e(new File(jarFile.getName()), nextElement.getName(), this.f29050b));
                }
            }
        }

        public ImmutableSet<C0751c> g() throws IOException {
            return h(new HashSet());
        }

        public ImmutableSet<C0751c> h(Set<File> set) throws IOException {
            ImmutableSet.a<C0751c> builder = ImmutableSet.builder();
            set.add(this.f29049a);
            b(this.f29049a, set, builder);
            return builder.e();
        }

        public int hashCode() {
            return this.f29049a.hashCode();
        }

        public String toString() {
            return this.f29049a.toString();
        }
    }

    /* renamed from: o5.c$c */
    public static class C0751c {

        /* renamed from: a */
        public final File f29051a;

        /* renamed from: b */
        public final String f29052b;

        /* renamed from: c */
        public final ClassLoader f29053c;

        public C0751c(File file, String str, ClassLoader classLoader) {
            this.f29051a = (File) u.E(file);
            this.f29052b = (String) u.E(str);
            this.f29053c = (ClassLoader) u.E(classLoader);
        }

        public static C0751c e(File file, String str, ClassLoader classLoader) {
            return str.endsWith(c.f29046d) ? new a(file, str, classLoader) : new C0751c(file, str, classLoader);
        }

        public final k5.f a() {
            return d0.a(f());
        }

        public final k5.j b(Charset charset) {
            return d0.b(f(), charset);
        }

        public final File c() {
            return this.f29051a;
        }

        public final String d() {
            return this.f29052b;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof C0751c)) {
                return false;
            }
            C0751c c0751c = (C0751c) obj;
            return this.f29052b.equals(c0751c.f29052b) && this.f29053c == c0751c.f29053c;
        }

        public final URL f() {
            URL resource = this.f29053c.getResource(this.f29052b);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.f29052b);
        }

        public int hashCode() {
            return this.f29052b.hashCode();
        }

        public String toString() {
            return this.f29052b;
        }
    }

    public c(ImmutableSet<C0751c> immutableSet) {
        this.f29047a = immutableSet;
    }

    public static c b(ClassLoader classLoader) throws IOException {
        ImmutableSet<b> l10 = l(classLoader);
        HashSet hashSet = new HashSet();
        z1<b> it = l10.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().a());
        }
        ImmutableSet.a builder = ImmutableSet.builder();
        z1<b> it2 = l10.iterator();
        while (it2.hasNext()) {
            builder.c(it2.next().h(hashSet));
        }
        return new c(builder.e());
    }

    public static ImmutableList<URL> d(ClassLoader classLoader) {
        return classLoader instanceof URLClassLoader ? ImmutableList.copyOf(((URLClassLoader) classLoader).getURLs()) : classLoader.equals(ClassLoader.getSystemClassLoader()) ? m() : ImmutableList.of();
    }

    @a5.d
    public static String e(String str) {
        return str.substring(0, str.length() - 6).replace('/', '.');
    }

    @a5.d
    public static ImmutableMap<File, ClassLoader> f(ClassLoader classLoader) {
        LinkedHashMap c02 = Maps.c0();
        ClassLoader parent = classLoader.getParent();
        if (parent != null) {
            c02.putAll(f(parent));
        }
        z1<URL> it = d(classLoader).iterator();
        while (it.hasNext()) {
            URL next = it.next();
            if (next.getProtocol().equals(com.sigmob.sdk.base.k.f18193y)) {
                File n10 = n(next);
                if (!c02.containsKey(n10)) {
                    c02.put(n10, classLoader);
                }
            }
        }
        return ImmutableMap.copyOf((Map) c02);
    }

    @a5.d
    public static URL g(File file, String str) throws MalformedURLException {
        return new URL(file.toURI().toURL(), str);
    }

    @a5.d
    public static ImmutableSet<File> h(File file, @CheckForNull Manifest manifest) {
        if (manifest == null) {
            return ImmutableSet.of();
        }
        ImmutableSet.a builder = ImmutableSet.builder();
        String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (value != null) {
            for (String str : f29045c.n(value)) {
                try {
                    URL g10 = g(file, str);
                    if (g10.getProtocol().equals(com.sigmob.sdk.base.k.f18193y)) {
                        builder.g(n(g10));
                    }
                } catch (MalformedURLException unused) {
                    Logger logger = f29044b;
                    String valueOf = String.valueOf(str);
                    logger.warning(valueOf.length() != 0 ? "Invalid Class-Path entry: ".concat(valueOf) : new String("Invalid Class-Path entry: "));
                }
            }
        }
        return builder.e();
    }

    public static ImmutableSet<b> l(ClassLoader classLoader) {
        ImmutableSet.a builder = ImmutableSet.builder();
        z1<Map.Entry<File, ClassLoader>> it = f(classLoader).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<File, ClassLoader> next = it.next();
            builder.g(new b(next.getKey(), next.getValue()));
        }
        return builder.e();
    }

    @a5.d
    public static ImmutableList<URL> m() {
        ImmutableList.a builder = ImmutableList.builder();
        for (String str : com.google.common.base.c.k(StandardSystemProperty.PATH_SEPARATOR.value()).n(StandardSystemProperty.JAVA_CLASS_PATH.value())) {
            try {
                try {
                    builder.a(new File(str).toURI().toURL());
                } catch (SecurityException unused) {
                    builder.a(new URL(com.sigmob.sdk.base.k.f18193y, (String) null, new File(str).getAbsolutePath()));
                }
            } catch (MalformedURLException e10) {
                Logger logger = f29044b;
                Level level = Level.WARNING;
                String valueOf = String.valueOf(str);
                logger.log(level, valueOf.length() != 0 ? "malformed classpath entry: ".concat(valueOf) : new String("malformed classpath entry: "), (Throwable) e10);
            }
        }
        return builder.e();
    }

    @a5.d
    public static File n(URL url) {
        u.d(url.getProtocol().equals(com.sigmob.sdk.base.k.f18193y));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public ImmutableSet<a> c() {
        return w.r(this.f29047a).n(a.class).F();
    }

    public ImmutableSet<C0751c> getResources() {
        return this.f29047a;
    }

    public ImmutableSet<a> i() {
        return w.r(this.f29047a).n(a.class).m(new v() { // from class: o5.b
            @Override // b5.v
            public final boolean apply(Object obj) {
                return ((c.a) obj).j();
            }
        }).F();
    }

    public ImmutableSet<a> j(String str) {
        u.E(str);
        ImmutableSet.a builder = ImmutableSet.builder();
        z1<a> it = i().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.h().equals(str)) {
                builder.g(next);
            }
        }
        return builder.e();
    }

    public ImmutableSet<a> k(String str) {
        u.E(str);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1);
        sb2.append(str);
        sb2.append('.');
        String sb3 = sb2.toString();
        ImmutableSet.a builder = ImmutableSet.builder();
        z1<a> it = i().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.g().startsWith(sb3)) {
                builder.g(next);
            }
        }
        return builder.e();
    }
}
