package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.e.a;
import com.sigmob.sdk.downloader.f;

/* loaded from: classes4.dex */
public class e<T extends a> implements d {

    /* renamed from: a */
    public volatile T f19341a;

    /* renamed from: b */
    public final SparseArray<T> f19342b = new SparseArray<>();

    /* renamed from: c */
    public Boolean f19343c;

    /* renamed from: d */
    public final b<T> f19344d;

    public interface a {
        int a();

        void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar);
    }

    public interface b<T extends a> {
        T a(int i10);
    }

    public e(b<T> bVar) {
        this.f19344d = bVar;
    }

    public T a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T a10 = this.f19344d.a(fVar.b());
        synchronized (this) {
            try {
                if (this.f19341a == null) {
                    this.f19341a = a10;
                } else {
                    this.f19342b.put(fVar.b(), a10);
                }
                if (cVar != null) {
                    a10.a(cVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return a10;
    }

    public T b(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T t10;
        int b10 = fVar.b();
        synchronized (this) {
            try {
                t10 = (this.f19341a == null || this.f19341a.a() != b10) ? null : this.f19341a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (t10 == null) {
            t10 = this.f19342b.get(b10);
        }
        return (t10 == null && a()) ? a(fVar, cVar) : t10;
    }

    public T c(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T t10;
        int b10 = fVar.b();
        synchronized (this) {
            try {
                if (this.f19341a == null || this.f19341a.a() != b10) {
                    t10 = this.f19342b.get(b10);
                    this.f19342b.remove(b10);
                } else {
                    t10 = this.f19341a;
                    this.f19341a = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (t10 == null) {
            t10 = this.f19344d.a(b10);
            if (cVar != null) {
                t10.a(cVar);
            }
        }
        return t10;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        Boolean bool = this.f19343c;
        return bool != null && bool.booleanValue();
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z10) {
        this.f19343c = Boolean.valueOf(z10);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z10) {
        if (this.f19343c == null) {
            this.f19343c = Boolean.valueOf(z10);
        }
    }
}
