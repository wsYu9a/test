package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.sigmob.sdk.downloader.core.breakpoint.m;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class l implements m.a, j {

    /* renamed from: e */
    public static final String f19063e = "RemitStoreOnSQLite";

    /* renamed from: a */
    public final n f19064a;

    /* renamed from: b */
    public final i f19065b;

    /* renamed from: c */
    public final e f19066c;

    /* renamed from: d */
    public final j f19067d;

    public l(i iVar) {
        this.f19064a = new n(this);
        this.f19065b = iVar;
        this.f19067d = iVar.f19060b;
        this.f19066c = iVar.f19059a;
    }

    public static void j(int i10) {
        g a10 = com.sigmob.sdk.downloader.g.j().a();
        if (a10 instanceof l) {
            ((l) a10).f19064a.f19077b = Math.max(0, i10);
        } else {
            throw new IllegalStateException("The current store is " + a10 + " not RemitStoreOnSQLite!");
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f fVar) {
        return this.f19065b.b(fVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean c(int i10) {
        return this.f19065b.c(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void d(int i10) {
        this.f19066c.d(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean e(int i10) {
        return this.f19065b.e(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void f(int i10) throws IOException {
        this.f19066c.d(i10);
        c h10 = this.f19067d.h(i10);
        if (h10 == null || h10.e() == null || h10.j() <= 0) {
            return;
        }
        this.f19066c.a(h10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void g(int i10) {
        this.f19067d.g(i10);
        this.f19064a.a(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c h(int i10) {
        return this.f19065b.h(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c i(int i10) {
        return null;
    }

    public l(n nVar, i iVar, j jVar, e eVar) {
        this.f19064a = nVar;
        this.f19065b = iVar;
        this.f19067d = jVar;
        this.f19066c = eVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) throws IOException {
        return this.f19064a.c(fVar.b()) ? this.f19067d.a(fVar) : this.f19065b.a(fVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void b(int i10) {
        this.f19065b.b(i10);
        this.f19064a.d(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        return this.f19065b.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.f19065b.a(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(int i10) {
        return this.f19065b.a(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i10, long j10) throws IOException {
        if (this.f19064a.c(cVar.g())) {
            this.f19067d.a(cVar, i10, j10);
        } else {
            this.f19065b.a(cVar, i10, j10);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i10, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.f19067d.a(i10, aVar, exc);
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.f19064a.a(i10);
        } else {
            this.f19064a.b(i10);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void a(List<Integer> list) throws IOException {
        SQLiteDatabase writableDatabase = this.f19066c.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                f(it.next().intValue());
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) throws IOException {
        return this.f19064a.c(cVar.g()) ? this.f19067d.a(cVar) : this.f19065b.a(cVar);
    }
}
