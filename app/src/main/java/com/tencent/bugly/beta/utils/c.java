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
    private static HashMap<Long, String> f24674a = new HashMap<>();

    /* renamed from: c */
    private String f24676c;

    /* renamed from: b */
    private com.tencent.bugly.beta.utils.a f24675b = null;

    /* renamed from: d */
    private long f24677d = 0;

    /* renamed from: e */
    private long f24678e = 0;

    /* renamed from: f */
    private HashMap<String, b> f24679f = null;

    /* renamed from: g */
    private byte[] f24680g = new byte[16];

    /* renamed from: h */
    private long f24681h = 0;

    /* renamed from: i */
    private long f24682i = 0;

    /* renamed from: j */
    private String f24683j = null;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long u = 0;

    public static class a {

        /* renamed from: a */
        private long f24684a = -1;

        /* renamed from: b */
        private long f24685b = 0;

        /* renamed from: c */
        private long f24686c = 0;

        /* renamed from: d */
        private long f24687d = -1;

        /* renamed from: e */
        private long f24688e = -1;

        /* renamed from: f */
        private long f24689f = 0;

        /* renamed from: g */
        private long f24690g = 0;

        /* renamed from: h */
        private long f24691h = 0;

        /* renamed from: i */
        private long f24692i = 0;

        /* renamed from: j */
        private long f24693j = 0;

        public long a() {
            return this.f24687d;
        }

        public long b() {
            return this.f24693j;
        }

        public long c() {
            return this.f24684a;
        }

        public long d() {
            return this.f24688e;
        }

        public long e() {
            return this.f24689f;
        }

        public synchronized void f(long j2) {
            this.f24690g = j2;
        }

        public synchronized void g(long j2) {
            this.f24684a = j2;
        }

        public synchronized void h(long j2) {
            this.f24688e = j2;
        }

        public synchronized void i(long j2) {
            this.f24689f = j2;
        }

        public synchronized void j(long j2) {
            this.f24685b = j2;
        }

        public synchronized void a(long j2) {
            this.f24687d = j2;
        }

        public synchronized void b(long j2) {
            this.f24692i = j2;
        }

        public synchronized void c(long j2) {
            this.f24693j = j2;
        }

        public synchronized void d(long j2) {
            this.f24686c = j2;
        }

        public synchronized void e(long j2) {
            this.f24691h = j2;
        }
    }

    public static class b {

        /* renamed from: a */
        private String f24694a = null;

        /* renamed from: b */
        private long f24695b = -1;

        /* renamed from: c */
        private long f24696c = -1;

        /* renamed from: d */
        private long f24697d = 0;

        /* renamed from: e */
        private long f24698e = 0;

        public long a() {
            return this.f24696c;
        }

        public synchronized void b(long j2) {
            this.f24698e = j2;
        }

        public synchronized void c(long j2) {
            this.f24696c = j2;
        }

        public synchronized void d(long j2) {
            this.f24697d = j2;
        }

        public synchronized void a(String str) {
            this.f24694a = str;
        }

        public synchronized void a(long j2) {
            this.f24695b = j2;
        }
    }

    public c(String str) {
        this.f24676c = null;
        this.f24676c = str;
        f24674a.put(3L, "x86");
        f24674a.put(7L, "x86");
        f24674a.put(8L, "mips");
        f24674a.put(10L, "mips");
        f24674a.put(40L, "armeabi");
        f24674a.put(62L, "x86_64");
        f24674a.put(183L, "arm64-v8a");
    }

    private long b(byte b2) {
        if (1 == b2) {
            return 32L;
        }
        return 2 == b2 ? 64L : 0L;
    }

    private synchronized void b() {
        com.tencent.bugly.beta.utils.a aVar = this.f24675b;
        if (aVar == null) {
            return;
        }
        if (aVar.a()) {
            this.f24675b = null;
        }
    }

    private String c() {
        return this.f24683j;
    }

    private long d() {
        return this.n;
    }

    private long e() {
        return this.t;
    }

    private long f() {
        return this.u;
    }

    private synchronized boolean g() {
        if (this.f24675b != null) {
            b();
        }
        try {
            this.f24675b = new com.tencent.bugly.beta.utils.a(this.f24676c, this.f24678e);
        } catch (Exception e2) {
            Log.e("ElfParser", e2.getMessage());
            return false;
        }
        return true;
    }

    private synchronized boolean h() {
        if (this.f24675b != null) {
            b();
        }
        try {
            this.f24675b = new com.tencent.bugly.beta.utils.a(this.f24676c);
        } catch (Exception e2) {
            Log.e("ElfParser", e2.getMessage());
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
            this.f24681h = this.f24675b.i();
            long i2 = this.f24675b.i();
            this.f24682i = i2;
            this.f24683j = a(i2, this.f24677d);
            this.k = this.f24675b.g();
            long j2 = this.f24677d;
            if (32 == j2) {
                long g2 = this.f24675b.g();
                this.k = g2;
                this.l = g2;
                this.m = this.f24675b.g();
                this.n = this.f24675b.g();
            } else {
                if (64 != j2) {
                    Log.e("ElfParser", "File format error");
                    return false;
                }
                long h2 = this.f24675b.h();
                this.k = h2;
                this.l = h2;
                this.m = this.f24675b.h();
                this.n = this.f24675b.h();
            }
            this.o = this.f24675b.g();
            this.p = this.f24675b.i();
            this.q = this.f24675b.i();
            this.r = this.f24675b.i();
            this.s = this.f24675b.i();
            this.t = this.f24675b.i();
            this.u = this.f24675b.i();
            return true;
        } catch (IOException e2) {
            Log.e("ElfParser", e2.getMessage());
            return false;
        }
    }

    private synchronized boolean k() {
        if (!this.f24675b.a(this.f24680g)) {
            Log.e("ElfParser", "Fail to parseElfHeader elf indentification");
            return false;
        }
        if (!a(this.f24680g)) {
            Log.e("ElfParser", "Not a elf file: " + this.f24676c);
            return false;
        }
        long b2 = b(this.f24680g[4]);
        this.f24677d = b2;
        if (0 == b2) {
            Log.e("ElfParser", "File format error: " + ((int) this.f24680g[4]));
            return false;
        }
        long a2 = a(this.f24680g[5]);
        this.f24678e = a2;
        if (com.tencent.bugly.beta.utils.a.f24658a != a2) {
            this.f24675b.a(a2);
            return true;
        }
        Log.e("ElfParser", "Endian error: " + ((int) this.f24680g[5]));
        return false;
    }

    private synchronized a l() {
        a aVar = new a();
        try {
            aVar.g(this.f24675b.g());
            aVar.j(this.f24675b.g());
            long j2 = this.f24677d;
            if (32 == j2) {
                aVar.d(this.f24675b.g());
                aVar.a(this.f24675b.g());
                aVar.h(this.f24675b.g());
                aVar.i(this.f24675b.g());
            } else {
                if (64 != j2) {
                    Log.e("ElfParser", "File format error");
                    return null;
                }
                aVar.d(this.f24675b.h());
                aVar.a(this.f24675b.h());
                aVar.h(this.f24675b.h());
                aVar.i(this.f24675b.h());
            }
            aVar.f(this.f24675b.g());
            aVar.e(this.f24675b.g());
            long j3 = this.f24677d;
            if (32 == j3) {
                aVar.b(this.f24675b.g());
                aVar.c(this.f24675b.g());
            } else {
                if (64 != j3) {
                    Log.e("ElfParser", "File format error");
                    return null;
                }
                aVar.b(this.f24675b.h());
                aVar.c(this.f24675b.h());
            }
            return aVar;
        } catch (IOException e2) {
            Log.e("ElfParser", e2.getMessage());
            return null;
        }
    }

    private synchronized boolean m() {
        HashMap<String, b> a2;
        a2 = a(d(), e(), f());
        this.f24679f = a2;
        return a2 != null;
    }

    public synchronized String a() {
        if (!i()) {
            Log.e("ElfParser", "Failed to parseElfHeader elf header");
            return null;
        }
        String c2 = c();
        if (!c2.equals("armeabi")) {
            return c2;
        }
        if (!m()) {
            Log.e("ElfParser", "Failed to parseElfHeader section table");
            return c2;
        }
        b bVar = this.f24679f.get(".ARM.attributes");
        if (bVar == null) {
            Log.e("ElfParser", "No .ARM.attributes section in the elf file");
            return c2;
        }
        return com.tencent.bugly.beta.utils.b.a(this.f24676c, this.f24678e, bVar.a());
    }

    private synchronized HashMap<String, b> b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            Vector vector = new Vector();
            for (int i2 = 0; i2 < j2; i2++) {
                vector.add(l());
            }
            a aVar = (a) vector.get((int) j3);
            long length = new File(this.f24676c).length();
            X.a("File length = %d", Long.valueOf(length));
            if (aVar.d() >= length) {
                X.e("The SO file is invalid or has a shell.", new Object[0]);
                return null;
            }
            d dVar = new d(this.f24676c, aVar.d(), aVar.e());
            HashMap<String, b> hashMap = new HashMap<>();
            Iterator it = vector.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                String a2 = dVar.a(aVar2.c());
                b bVar = new b();
                bVar.a(a2);
                bVar.a(aVar2.a());
                bVar.c(aVar2.d());
                bVar.d(aVar2.e());
                bVar.b(aVar2.b());
                hashMap.put(a2, bVar);
            }
            dVar.a();
            return hashMap;
        }
        X.e("The SO file is invalid or has a shell.", new Object[0]);
        return null;
    }

    private static String a(long j2, long j3) {
        String str = f24674a.get(Long.valueOf(j2));
        return (64 == j3 && str.equals("mips")) ? "mips64" : str;
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 3 && Byte.MAX_VALUE == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3];
    }

    private long a(byte b2) {
        if (1 == b2) {
            return com.tencent.bugly.beta.utils.a.f24660c;
        }
        if (2 == b2) {
            return com.tencent.bugly.beta.utils.a.f24659b;
        }
        return com.tencent.bugly.beta.utils.a.f24658a;
    }

    private synchronized HashMap<String, b> a(long j2, long j3, long j4) {
        if (!g()) {
            b();
            return null;
        }
        if (!this.f24675b.b(j2)) {
            b();
            return null;
        }
        HashMap<String, b> b2 = b(j3, j4);
        b();
        return b2;
    }
}
