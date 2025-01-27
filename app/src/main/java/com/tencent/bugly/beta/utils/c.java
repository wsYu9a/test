package com.tencent.bugly.beta.utils;

import android.util.Log;
import com.tencent.bugly.proguard.X;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static HashMap<Long, String> f22184a = new HashMap<>();

    /* renamed from: c */
    private String f22186c;

    /* renamed from: b */
    private com.tencent.bugly.beta.utils.a f22185b = null;

    /* renamed from: d */
    private long f22187d = 0;

    /* renamed from: e */
    private long f22188e = 0;

    /* renamed from: f */
    private HashMap<String, b> f22189f = null;

    /* renamed from: g */
    private byte[] f22190g = new byte[16];

    /* renamed from: h */
    private long f22191h = 0;

    /* renamed from: i */
    private long f22192i = 0;

    /* renamed from: j */
    private String f22193j = null;

    /* renamed from: k */
    private long f22194k = 0;

    /* renamed from: l */
    private long f22195l = 0;

    /* renamed from: m */
    private long f22196m = 0;

    /* renamed from: n */
    private long f22197n = 0;

    /* renamed from: o */
    private long f22198o = 0;

    /* renamed from: p */
    private long f22199p = 0;

    /* renamed from: q */
    private long f22200q = 0;

    /* renamed from: r */
    private long f22201r = 0;

    /* renamed from: s */
    private long f22202s = 0;

    /* renamed from: t */
    private long f22203t = 0;

    /* renamed from: u */
    private long f22204u = 0;

    public static class a {

        /* renamed from: a */
        private long f22205a = -1;

        /* renamed from: b */
        private long f22206b = 0;

        /* renamed from: c */
        private long f22207c = 0;

        /* renamed from: d */
        private long f22208d = -1;

        /* renamed from: e */
        private long f22209e = -1;

        /* renamed from: f */
        private long f22210f = 0;

        /* renamed from: g */
        private long f22211g = 0;

        /* renamed from: h */
        private long f22212h = 0;

        /* renamed from: i */
        private long f22213i = 0;

        /* renamed from: j */
        private long f22214j = 0;

        public long a() {
            return this.f22208d;
        }

        public long b() {
            return this.f22214j;
        }

        public long c() {
            return this.f22205a;
        }

        public long d() {
            return this.f22209e;
        }

        public long e() {
            return this.f22210f;
        }

        public synchronized void f(long j10) {
            this.f22211g = j10;
        }

        public synchronized void g(long j10) {
            this.f22205a = j10;
        }

        public synchronized void h(long j10) {
            this.f22209e = j10;
        }

        public synchronized void i(long j10) {
            this.f22210f = j10;
        }

        public synchronized void j(long j10) {
            this.f22206b = j10;
        }

        public synchronized void a(long j10) {
            this.f22208d = j10;
        }

        public synchronized void b(long j10) {
            this.f22213i = j10;
        }

        public synchronized void c(long j10) {
            this.f22214j = j10;
        }

        public synchronized void d(long j10) {
            this.f22207c = j10;
        }

        public synchronized void e(long j10) {
            this.f22212h = j10;
        }
    }

    public static class b {

        /* renamed from: a */
        private String f22215a = null;

        /* renamed from: b */
        private long f22216b = -1;

        /* renamed from: c */
        private long f22217c = -1;

        /* renamed from: d */
        private long f22218d = 0;

        /* renamed from: e */
        private long f22219e = 0;

        public long a() {
            return this.f22217c;
        }

        public synchronized void b(long j10) {
            this.f22219e = j10;
        }

        public synchronized void c(long j10) {
            this.f22217c = j10;
        }

        public synchronized void d(long j10) {
            this.f22218d = j10;
        }

        public synchronized void a(String str) {
            this.f22215a = str;
        }

        public synchronized void a(long j10) {
            this.f22216b = j10;
        }
    }

    public c(String str) {
        this.f22186c = str;
        f22184a.put(3L, "x86");
        f22184a.put(7L, "x86");
        f22184a.put(8L, "mips");
        f22184a.put(10L, "mips");
        f22184a.put(40L, "armeabi");
        f22184a.put(62L, "x86_64");
        f22184a.put(183L, "arm64-v8a");
    }

    private long b(byte b10) {
        if (1 == b10) {
            return 32L;
        }
        return 2 == b10 ? 64L : 0L;
    }

    private String c() {
        return this.f22193j;
    }

    private long d() {
        return this.f22197n;
    }

    private long e() {
        return this.f22203t;
    }

    private long f() {
        return this.f22204u;
    }

    private synchronized boolean g() {
        if (this.f22185b != null) {
            b();
        }
        try {
            this.f22185b = new com.tencent.bugly.beta.utils.a(this.f22186c, this.f22188e);
        } catch (Exception e10) {
            Log.e("ElfParser", e10.getMessage());
            return false;
        }
        return true;
    }

    private synchronized boolean h() {
        if (this.f22185b != null) {
            b();
        }
        try {
            this.f22185b = new com.tencent.bugly.beta.utils.a(this.f22186c);
        } catch (Exception e10) {
            Log.e("ElfParser", e10.getMessage());
            return false;
        }
        return true;
    }

    private boolean i() {
        if (!h()) {
            return false;
        }
        if (j()) {
            b();
            return true;
        }
        b();
        return false;
    }

    private synchronized boolean j() {
        if (!k()) {
            Log.e("ElfParser", "Faile to parseElfHeader header indent of elf");
            return false;
        }
        try {
            this.f22191h = this.f22185b.i();
            long i10 = this.f22185b.i();
            this.f22192i = i10;
            this.f22193j = a(i10, this.f22187d);
            this.f22194k = this.f22185b.g();
            long j10 = this.f22187d;
            if (32 == j10) {
                long g10 = this.f22185b.g();
                this.f22194k = g10;
                this.f22195l = g10;
                this.f22196m = this.f22185b.g();
                this.f22197n = this.f22185b.g();
            } else {
                if (64 != j10) {
                    Log.e("ElfParser", "File format error");
                    return false;
                }
                long h10 = this.f22185b.h();
                this.f22194k = h10;
                this.f22195l = h10;
                this.f22196m = this.f22185b.h();
                this.f22197n = this.f22185b.h();
            }
            this.f22198o = this.f22185b.g();
            this.f22199p = this.f22185b.i();
            this.f22200q = this.f22185b.i();
            this.f22201r = this.f22185b.i();
            this.f22202s = this.f22185b.i();
            this.f22203t = this.f22185b.i();
            this.f22204u = this.f22185b.i();
            return true;
        } catch (IOException e10) {
            Log.e("ElfParser", e10.getMessage());
            return false;
        }
    }

    private synchronized boolean k() {
        if (!this.f22185b.a(this.f22190g)) {
            Log.e("ElfParser", "Fail to parseElfHeader elf indentification");
            return false;
        }
        if (!a(this.f22190g)) {
            Log.e("ElfParser", "Not a elf file: " + this.f22186c);
            return false;
        }
        long b10 = b(this.f22190g[4]);
        this.f22187d = b10;
        if (0 == b10) {
            Log.e("ElfParser", "File format error: " + ((int) this.f22190g[4]));
            return false;
        }
        long a10 = a(this.f22190g[5]);
        this.f22188e = a10;
        if (com.tencent.bugly.beta.utils.a.f22167a != a10) {
            this.f22185b.a(a10);
            return true;
        }
        Log.e("ElfParser", "Endian error: " + ((int) this.f22190g[5]));
        return false;
    }

    private synchronized a l() {
        try {
            a aVar = new a();
            try {
                aVar.g(this.f22185b.g());
                aVar.j(this.f22185b.g());
                long j10 = this.f22187d;
                if (32 == j10) {
                    aVar.d(this.f22185b.g());
                    aVar.a(this.f22185b.g());
                    aVar.h(this.f22185b.g());
                    aVar.i(this.f22185b.g());
                } else {
                    if (64 != j10) {
                        Log.e("ElfParser", "File format error");
                        return null;
                    }
                    aVar.d(this.f22185b.h());
                    aVar.a(this.f22185b.h());
                    aVar.h(this.f22185b.h());
                    aVar.i(this.f22185b.h());
                }
                aVar.f(this.f22185b.g());
                aVar.e(this.f22185b.g());
                long j11 = this.f22187d;
                if (32 == j11) {
                    aVar.b(this.f22185b.g());
                    aVar.c(this.f22185b.g());
                } else {
                    if (64 != j11) {
                        Log.e("ElfParser", "File format error");
                        return null;
                    }
                    aVar.b(this.f22185b.h());
                    aVar.c(this.f22185b.h());
                }
                return aVar;
            } catch (IOException e10) {
                Log.e("ElfParser", e10.getMessage());
                return null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized boolean m() {
        HashMap<String, b> a10;
        a10 = a(d(), e(), f());
        this.f22189f = a10;
        return a10 != null;
    }

    public synchronized String a() {
        if (!i()) {
            Log.e("ElfParser", "Failed to parseElfHeader elf header");
            return null;
        }
        String c10 = c();
        if (!c10.equals("armeabi")) {
            return c10;
        }
        if (!m()) {
            Log.e("ElfParser", "Failed to parseElfHeader section table");
            return c10;
        }
        b bVar = this.f22189f.get(".ARM.attributes");
        if (bVar == null) {
            Log.e("ElfParser", "No .ARM.attributes section in the elf file");
            return c10;
        }
        return com.tencent.bugly.beta.utils.b.a(this.f22186c, this.f22188e, bVar.a());
    }

    private synchronized void b() {
        com.tencent.bugly.beta.utils.a aVar = this.f22185b;
        if (aVar == null) {
            return;
        }
        if (aVar.a()) {
            this.f22185b = null;
        }
    }

    private synchronized HashMap<String, b> b(long j10, long j11) {
        try {
            if (j10 > 0 && j11 > 0) {
                Vector vector = new Vector();
                for (int i10 = 0; i10 < j10; i10++) {
                    vector.add(l());
                }
                a aVar = (a) vector.get((int) j11);
                long length = new File(this.f22186c).length();
                X.a("File length = %d", Long.valueOf(length));
                if (aVar.d() >= length) {
                    X.e("The SO file is invalid or has a shell.", new Object[0]);
                    return null;
                }
                d dVar = new d(this.f22186c, aVar.d(), aVar.e());
                HashMap<String, b> hashMap = new HashMap<>();
                Iterator it = vector.iterator();
                while (it.hasNext()) {
                    a aVar2 = (a) it.next();
                    String a10 = dVar.a(aVar2.c());
                    b bVar = new b();
                    bVar.a(a10);
                    bVar.a(aVar2.a());
                    bVar.c(aVar2.d());
                    bVar.d(aVar2.e());
                    bVar.b(aVar2.b());
                    hashMap.put(a10, bVar);
                }
                dVar.a();
                return hashMap;
            }
            X.e("The SO file is invalid or has a shell.", new Object[0]);
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static String a(long j10, long j11) {
        String str = f22184a.get(Long.valueOf(j10));
        return (64 == j11 && str.equals("mips")) ? "mips64" : str;
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 3 && Byte.MAX_VALUE == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3];
    }

    private long a(byte b10) {
        if (1 == b10) {
            return com.tencent.bugly.beta.utils.a.f22169c;
        }
        if (2 == b10) {
            return com.tencent.bugly.beta.utils.a.f22168b;
        }
        return com.tencent.bugly.beta.utils.a.f22167a;
    }

    private synchronized HashMap<String, b> a(long j10, long j11, long j12) {
        if (!g()) {
            b();
            return null;
        }
        if (!this.f22185b.b(j10)) {
            b();
            return null;
        }
        HashMap<String, b> b10 = b(j11, j12);
        b();
        return b10;
    }
}
