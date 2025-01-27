package com.sigmob.sdk.downloader.core.breakpoint;

import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public final int f19005a;

    /* renamed from: b */
    public final String f19006b;

    /* renamed from: c */
    public String f19007c;

    /* renamed from: d */
    public final File f19008d;

    /* renamed from: e */
    public File f19009e;

    /* renamed from: f */
    public final g.a f19010f;

    /* renamed from: g */
    public final List<a> f19011g = new ArrayList();

    /* renamed from: h */
    public final boolean f19012h;

    /* renamed from: i */
    public boolean f19013i;

    public c(int i10, String str, File file, String str2) {
        this.f19005a = i10;
        this.f19006b = str;
        this.f19008d = file;
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) str2)) {
            this.f19010f = new g.a();
            this.f19012h = true;
        } else {
            this.f19010f = new g.a(str2);
            this.f19012h = false;
            this.f19009e = new File(file, str2);
        }
    }

    public void a(a aVar) {
        this.f19011g.add(aVar);
    }

    public a b(int i10) {
        return this.f19011g.get(i10);
    }

    public String c() {
        return this.f19007c;
    }

    public File d() {
        String a10 = this.f19010f.a();
        if (a10 == null) {
            return null;
        }
        if (this.f19009e == null) {
            this.f19009e = new File(this.f19008d, a10);
        }
        return this.f19009e;
    }

    public String e() {
        return this.f19010f.a();
    }

    public g.a f() {
        return this.f19010f;
    }

    public int g() {
        return this.f19005a;
    }

    public File h() {
        return this.f19008d;
    }

    public long i() {
        if (l()) {
            return j();
        }
        Object[] array = this.f19011g.toArray();
        long j10 = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    j10 += ((a) obj).b();
                }
            }
        }
        return j10;
    }

    public long j() {
        Object[] array = this.f19011g.toArray();
        long j10 = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    j10 += ((a) obj).c();
                }
            }
        }
        return j10;
    }

    public String k() {
        return this.f19006b;
    }

    public boolean l() {
        return this.f19013i;
    }

    public boolean m() {
        return this.f19011g.size() == 1;
    }

    public boolean n() {
        return this.f19012h;
    }

    public void o() {
        this.f19011g.clear();
    }

    public void p() {
        this.f19011g.clear();
        this.f19007c = null;
    }

    public String toString() {
        return "id[" + this.f19005a + "] url[" + this.f19006b + "] etag[" + this.f19007c + "] taskOnlyProvidedParentPath[" + this.f19012h + "] parent path[" + this.f19008d + "] filename[" + this.f19010f.a() + "] block(s):" + this.f19011g.toString();
    }

    public c(int i10, String str, File file, String str2, boolean z10) {
        this.f19005a = i10;
        this.f19006b = str;
        this.f19008d = file;
        this.f19010f = com.sigmob.sdk.downloader.core.c.a((CharSequence) str2) ? new g.a() : new g.a(str2);
        this.f19012h = z10;
    }

    public c a() {
        c cVar = new c(this.f19005a, this.f19006b, this.f19008d, this.f19010f.a(), this.f19012h);
        cVar.f19013i = this.f19013i;
        Iterator<a> it = this.f19011g.iterator();
        while (it.hasNext()) {
            cVar.f19011g.add(it.next().a());
        }
        return cVar;
    }

    public int b() {
        return this.f19011g.size();
    }

    public boolean c(int i10) {
        return i10 == this.f19011g.size() - 1;
    }

    public c a(int i10) {
        c cVar = new c(i10, this.f19006b, this.f19008d, this.f19010f.a(), this.f19012h);
        cVar.f19013i = this.f19013i;
        Iterator<a> it = this.f19011g.iterator();
        while (it.hasNext()) {
            cVar.f19011g.add(it.next().a());
        }
        return cVar;
    }

    public c a(int i10, String str) {
        c cVar = new c(i10, str, this.f19008d, this.f19010f.a(), this.f19012h);
        cVar.f19013i = this.f19013i;
        Iterator<a> it = this.f19011g.iterator();
        while (it.hasNext()) {
            cVar.f19011g.add(it.next().a());
        }
        return cVar;
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar) {
        if (!this.f19008d.equals(fVar.c()) || !this.f19006b.equals(fVar.e())) {
            return false;
        }
        String a10 = fVar.a();
        if (a10 != null && a10.equals(this.f19010f.a())) {
            return true;
        }
        if (this.f19012h && fVar.C()) {
            return a10 == null || a10.equals(this.f19010f.a());
        }
        return false;
    }

    public void a(c cVar) {
        this.f19011g.clear();
        this.f19011g.addAll(cVar.f19011g);
    }

    public void a(boolean z10) {
        this.f19013i = z10;
    }

    public void a(String str) {
        this.f19007c = str;
    }
}
