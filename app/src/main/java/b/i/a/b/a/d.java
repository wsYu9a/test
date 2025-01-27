package b.i.a.b.a;

import b.i.a.b.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static final Object f5097a = new Object();

    /* renamed from: c */
    private File f5099c;

    /* renamed from: b */
    private final Object f5098b = new Object();

    /* renamed from: d */
    private HashMap<File, a> f5100d = new HashMap<>();

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f5099c = new File(str);
    }

    private File b() {
        File file;
        synchronized (this.f5098b) {
            file = this.f5099c;
        }
        return file;
    }

    public static File c(File file) {
        return new File(String.valueOf(file.getPath()) + ".bak");
    }

    private File d(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File g(String str) {
        return d(b(), String.valueOf(str) + ".xml");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        if (r2 == null) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bb, code lost:
    
        if (r3 == null) goto L202;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c0 A[Catch: all -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0085, blocks: (B:37:0x0082, B:54:0x00c0), top: B:21:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b.i.a.b.a.b a(java.lang.String r10, int r11) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.b.a.d.a(java.lang.String, int):b.i.a.b.a.b");
    }

    private static final class a implements b {

        /* renamed from: a */
        private static final Object f5101a = new Object();

        /* renamed from: b */
        private final File f5102b;

        /* renamed from: c */
        private final File f5103c;

        /* renamed from: d */
        private final int f5104d;

        /* renamed from: e */
        private Map f5105e;

        /* renamed from: f */
        private boolean f5106f = false;

        /* renamed from: g */
        private WeakHashMap<b.InterfaceC0058b, Object> f5107g;

        a(File file, int i2, Map map) {
            this.f5102b = file;
            this.f5103c = d.c(file);
            this.f5104d = i2;
            this.f5105e = map == null ? new HashMap() : map;
            this.f5107g = new WeakHashMap<>();
        }

        private FileOutputStream b(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }

        public boolean i() {
            if (this.f5102b.exists()) {
                if (this.f5103c.exists()) {
                    this.f5102b.delete();
                } else if (!this.f5102b.renameTo(this.f5103c)) {
                    return false;
                }
            }
            try {
                FileOutputStream b2 = b(this.f5102b);
                if (b2 == null) {
                    return false;
                }
                e.g(this.f5105e, b2);
                b2.close();
                this.f5103c.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.f5102b.exists()) {
                    this.f5102b.delete();
                }
                return false;
            }
        }

        @Override // b.i.a.b.a.b
        /* renamed from: a */
        public boolean mo36a() {
            return this.f5102b != null && new File(this.f5102b.getAbsolutePath()).exists();
        }

        public void e(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f5105e = map;
                }
            }
        }

        public void f(boolean z) {
            synchronized (this) {
                this.f5106f = z;
            }
        }

        @Override // b.i.a.b.a.b
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f5105e);
            }
            return hashMap;
        }

        @Override // b.i.a.b.a.b
        public long getLong(String str, long j2) {
            synchronized (this) {
                Long l = (Long) this.f5105e.get(str);
                if (l != null) {
                    j2 = l.longValue();
                }
            }
            return j2;
        }

        @Override // b.i.a.b.a.b
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.f5105e.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        public boolean h() {
            boolean z;
            synchronized (this) {
                z = this.f5106f;
            }
            return z;
        }

        /* renamed from: b.i.a.b.a.d$a$a */
        public final class C0059a implements b.a {

            /* renamed from: a */
            private final Map<String, Object> f5108a = new HashMap();

            /* renamed from: b */
            private boolean f5109b = false;

            public C0059a() {
            }

            @Override // b.i.a.b.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.f5108a.put(str, str2);
                }
                return this;
            }

            @Override // b.i.a.b.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.f5109b = true;
                }
                return this;
            }

            @Override // b.i.a.b.a.b.a
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC0058b> hashSet;
                boolean i2;
                synchronized (d.f5097a) {
                    z = a.this.f5107g.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f5107g.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.f5109b) {
                            a.this.f5105e.clear();
                            this.f5109b = false;
                        }
                        for (Map.Entry<String, Object> entry : this.f5108a.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f5105e.remove(key);
                            } else {
                                a.this.f5105e.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.f5108a.clear();
                    }
                    i2 = a.this.i();
                    if (i2) {
                        a.this.f(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.InterfaceC0058b interfaceC0058b : hashSet) {
                            if (interfaceC0058b != null) {
                                interfaceC0058b.a(a.this, str);
                            }
                        }
                    }
                }
                return i2;
            }

            @Override // b.i.a.b.a.b.a
            public b.a a(String str, int i2) {
                synchronized (this) {
                    this.f5108a.put(str, Integer.valueOf(i2));
                }
                return this;
            }

            @Override // b.i.a.b.a.b.a
            public b.a a(String str, long j2) {
                synchronized (this) {
                    this.f5108a.put(str, Long.valueOf(j2));
                }
                return this;
            }

            @Override // b.i.a.b.a.b.a
            public b.a a(String str, float f2) {
                synchronized (this) {
                    this.f5108a.put(str, Float.valueOf(f2));
                }
                return this;
            }

            @Override // b.i.a.b.a.b.a
            public b.a a(String str, boolean z) {
                synchronized (this) {
                    this.f5108a.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // b.i.a.b.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.f5108a.put(str, this);
                }
                return this;
            }
        }

        @Override // b.i.a.b.a.b
        public b.a a() {
            return new C0059a();
        }
    }
}
