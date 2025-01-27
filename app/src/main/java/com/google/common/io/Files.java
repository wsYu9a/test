package com.google.common.io;

import b5.v;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import com.kuaishou.weapon.p0.t;
import h5.x0;
import i5.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;
import k5.a0;
import k5.e;
import k5.f;
import k5.g;
import k5.i;
import k5.j;
import k5.m;
import k5.p;
import k5.u;
import org.threeten.bp.chrono.HijrahDate;

@p
@a5.c
/* loaded from: classes2.dex */
public final class Files {

    /* renamed from: a */
    public static final int f10148a = 10000;

    /* renamed from: b */
    public static final x0<File> f10149b = new b();

    public enum FilePredicate implements v<File> {
        IS_DIRECTORY { // from class: com.google.common.io.Files.FilePredicate.1
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }

            @Override // b5.v
            public boolean apply(File file) {
                return file.isDirectory();
            }
        },
        IS_FILE { // from class: com.google.common.io.Files.FilePredicate.2
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }

            @Override // b5.v
            public boolean apply(File file) {
                return file.isFile();
            }
        };

        /* renamed from: com.google.common.io.Files$FilePredicate$1 */
        public enum AnonymousClass1 extends FilePredicate {
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }

            @Override // b5.v
            public boolean apply(File file) {
                return file.isDirectory();
            }
        }

        /* renamed from: com.google.common.io.Files$FilePredicate$2 */
        public enum AnonymousClass2 extends FilePredicate {
            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }

            @Override // b5.v
            public boolean apply(File file) {
                return file.isFile();
            }
        }

        /* synthetic */ FilePredicate(a aVar) {
            this();
        }
    }

    public class a implements u<List<String>> {

        /* renamed from: a */
        public final List<String> f10150a = Lists.q();

        @Override // k5.u
        public boolean b(String str) {
            this.f10150a.add(str);
            return true;
        }

        @Override // k5.u
        /* renamed from: c */
        public List<String> a() {
            return this.f10150a;
        }
    }

    public class b implements x0<File> {
        @Override // h5.x0, h5.z
        /* renamed from: N */
        public Iterable<File> b(File file) {
            File[] listFiles;
            return (!file.isDirectory() || (listFiles = file.listFiles()) == null) ? ImmutableList.of() : Collections.unmodifiableList(Arrays.asList(listFiles));
        }
    }

    public static final class c extends e {

        /* renamed from: a */
        public final File f10151a;

        /* renamed from: b */
        public final ImmutableSet<FileWriteMode> f10152b;

        public /* synthetic */ c(File file, FileWriteMode[] fileWriteModeArr, a aVar) {
            this(file, fileWriteModeArr);
        }

        @Override // k5.e
        /* renamed from: f */
        public FileOutputStream c() throws IOException {
            return new FileOutputStream(this.f10151a, this.f10152b.contains(FileWriteMode.APPEND));
        }

        public String toString() {
            String valueOf = String.valueOf(this.f10151a);
            String valueOf2 = String.valueOf(this.f10152b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20 + valueOf2.length());
            sb2.append("Files.asByteSink(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        public c(File file, FileWriteMode... fileWriteModeArr) {
            this.f10151a = (File) b5.u.E(file);
            this.f10152b = ImmutableSet.copyOf(fileWriteModeArr);
        }
    }

    public static final class d extends f {

        /* renamed from: a */
        public final File f10153a;

        public /* synthetic */ d(File file, a aVar) {
            this(file);
        }

        @Override // k5.f
        public byte[] o() throws IOException {
            try {
                FileInputStream fileInputStream = (FileInputStream) m.a().b(m());
                return g.v(fileInputStream, fileInputStream.getChannel().size());
            } finally {
            }
        }

        @Override // k5.f
        public long p() throws IOException {
            if (this.f10153a.isFile()) {
                return this.f10153a.length();
            }
            throw new FileNotFoundException(this.f10153a.toString());
        }

        @Override // k5.f
        public Optional<Long> q() {
            return this.f10153a.isFile() ? Optional.of(Long.valueOf(this.f10153a.length())) : Optional.absent();
        }

        @Override // k5.f
        /* renamed from: t */
        public FileInputStream m() throws IOException {
            return new FileInputStream(this.f10153a);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f10153a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Files.asByteSource(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        public d(File file) {
            this.f10153a = (File) b5.u.E(file);
        }
    }

    @a0
    @Deprecated
    @CanIgnoreReturnValue
    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readLines(callback)")
    public static <T> T A(File file, Charset charset, u<T> uVar) throws IOException {
        return (T) e(file, charset).q(uVar);
    }

    public static List<String> B(File file, Charset charset) throws IOException {
        return (List) e(file, charset).q(new a());
    }

    public static String C(String str) {
        b5.u.E(str);
        if (str.length() == 0) {
            return p1.b.f29697h;
        }
        Iterable<String> n10 = com.google.common.base.c.h('/').g().n(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : n10) {
            str2.hashCode();
            if (!str2.equals(p1.b.f29697h)) {
                if (!str2.equals("..")) {
                    arrayList.add(str2);
                } else if (arrayList.size() <= 0 || ((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        String k10 = b5.p.o('/').k(arrayList);
        if (str.charAt(0) == '/') {
            String valueOf = String.valueOf(k10);
            k10 = valueOf.length() != 0 ? "/".concat(valueOf) : new String("/");
        }
        while (k10.startsWith("/../")) {
            k10 = k10.substring(3);
        }
        return k10.equals("/..") ? "/" : "".equals(k10) ? p1.b.f29697h : k10;
    }

    public static byte[] D(File file) throws IOException {
        return c(file).o();
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).read()")
    @Deprecated
    public static String E(File file, Charset charset) throws IOException {
        return e(file, charset).n();
    }

    public static void F(File file) throws IOException {
        b5.u.E(file);
        if (file.createNewFile() || file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        String valueOf = String.valueOf(file);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 38);
        sb2.append("Unable to update modification time of ");
        sb2.append(valueOf);
        throw new IOException(sb2.toString());
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset).write(from)")
    @Deprecated
    public static void G(CharSequence charSequence, File file, Charset charset) throws IOException {
        d(file, charset, new FileWriteMode[0]).c(charSequence);
    }

    public static void H(byte[] bArr, File file) throws IOException {
        b(file, new FileWriteMode[0]).d(bArr);
    }

    @InlineMe(imports = {"com.google.common.io.FileWriteMode", "com.google.common.io.Files"}, replacement = "Files.asCharSink(to, charset, FileWriteMode.APPEND).write(from)")
    @Deprecated
    public static void a(CharSequence charSequence, File file, Charset charset) throws IOException {
        d(file, charset, FileWriteMode.APPEND).c(charSequence);
    }

    public static e b(File file, FileWriteMode... fileWriteModeArr) {
        return new c(file, fileWriteModeArr, null);
    }

    public static f c(File file) {
        return new d(file, null);
    }

    public static i d(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return b(file, fileWriteModeArr).a(charset);
    }

    public static j e(File file, Charset charset) {
        return c(file).a(charset);
    }

    public static void f(File file, File file2) throws IOException {
        b5.u.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        c(file).g(b(file2, new FileWriteMode[0]));
    }

    public static void g(File file, OutputStream outputStream) throws IOException {
        c(file).f(outputStream);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(from, charset).copyTo(to)")
    @Deprecated
    public static void h(File file, Charset charset, Appendable appendable) throws IOException {
        e(file, charset).e(appendable);
    }

    public static void i(File file) throws IOException {
        b5.u.E(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        String valueOf = String.valueOf(file);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 39);
        sb2.append("Unable to create parent directories of ");
        sb2.append(valueOf);
        throw new IOException(sb2.toString());
    }

    @a5.a
    @Deprecated
    public static File j() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder(21);
        sb2.append(currentTimeMillis);
        sb2.append("-");
        String sb3 = sb2.toString();
        for (int i10 = 0; i10 < 10000; i10++) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 11);
            sb4.append(sb3);
            sb4.append(i10);
            File file2 = new File(file, sb4.toString());
            if (file2.mkdir()) {
                return file2;
            }
        }
        StringBuilder sb5 = new StringBuilder(String.valueOf(sb3).length() + 66 + String.valueOf(sb3).length());
        sb5.append("Failed to create directory within 10000 attempts (tried ");
        sb5.append(sb3);
        sb5.append("0 to ");
        sb5.append(sb3);
        sb5.append(HijrahDate.MAX_VALUE_OF_ERA);
        sb5.append(')');
        throw new IllegalStateException(sb5.toString());
    }

    public static boolean k(File file, File file2) throws IOException {
        b5.u.E(file);
        b5.u.E(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return c(file).e(c(file2));
        }
        return false;
    }

    @a5.a
    public static Traverser<File> l() {
        return Traverser.h(f10149b);
    }

    public static String m(String str) {
        b5.u.E(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    public static String n(String str) {
        b5.u.E(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).hash(hashFunction)")
    @Deprecated
    public static HashCode o(File file, k kVar) throws IOException {
        return c(file).j(kVar);
    }

    public static v<File> p() {
        return FilePredicate.IS_DIRECTORY;
    }

    public static v<File> q() {
        return FilePredicate.IS_FILE;
    }

    public static MappedByteBuffer r(File file) throws IOException {
        b5.u.E(file);
        return s(file, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer s(File file, FileChannel.MapMode mapMode) throws IOException {
        return u(file, mapMode, -1L);
    }

    public static MappedByteBuffer t(File file, FileChannel.MapMode mapMode, long j10) throws IOException {
        b5.u.p(j10 >= 0, "size (%s) may not be negative", j10);
        return u(file, mapMode, j10);
    }

    public static MappedByteBuffer u(File file, FileChannel.MapMode mapMode, long j10) throws IOException {
        b5.u.E(file);
        b5.u.E(mapMode);
        m a10 = m.a();
        try {
            FileChannel fileChannel = (FileChannel) a10.b(((RandomAccessFile) a10.b(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? t.f11211k : "rw"))).getChannel());
            if (j10 == -1) {
                j10 = fileChannel.size();
            }
            return fileChannel.map(mapMode, 0L, j10);
        } finally {
        }
    }

    public static void v(File file, File file2) throws IOException {
        b5.u.E(file);
        b5.u.E(file2);
        b5.u.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) {
            return;
        }
        f(file, file2);
        if (file.delete()) {
            return;
        }
        if (file2.delete()) {
            String valueOf = String.valueOf(file);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 17);
            sb2.append("Unable to delete ");
            sb2.append(valueOf);
            throw new IOException(sb2.toString());
        }
        String valueOf2 = String.valueOf(file2);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 17);
        sb3.append("Unable to delete ");
        sb3.append(valueOf2);
        throw new IOException(sb3.toString());
    }

    public static BufferedReader w(File file, Charset charset) throws FileNotFoundException {
        b5.u.E(file);
        b5.u.E(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    public static BufferedWriter x(File file, Charset charset) throws FileNotFoundException {
        b5.u.E(file);
        b5.u.E(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @a0
    @Deprecated
    @CanIgnoreReturnValue
    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asByteSource(file).read(processor)")
    public static <T> T y(File file, k5.d<T> dVar) throws IOException {
        return (T) c(file).n(dVar);
    }

    @InlineMe(imports = {"com.google.common.io.Files"}, replacement = "Files.asCharSource(file, charset).readFirstLine()")
    @CheckForNull
    @Deprecated
    public static String z(File file, Charset charset) throws IOException {
        return e(file, charset).o();
    }
}
