package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.Context;
import java.io.IOException;

/* loaded from: classes4.dex */
public class i implements j {

    /* renamed from: c */
    public static final String f19058c = "BreakpointStoreOnSQLite";

    /* renamed from: a */
    public final e f19059a;

    /* renamed from: b */
    public final h f19060b;

    public i(Context context) {
        e eVar = new e(context.getApplicationContext());
        this.f19059a = eVar;
        this.f19060b = new h(eVar.c(), eVar.a(), eVar.b());
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    public void b() {
        this.f19059a.close();
    }

    public j c() {
        return new l(this);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean e(int i10) {
        if (!this.f19060b.e(i10)) {
            return false;
        }
        this.f19059a.a(i10);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void g(int i10) {
        this.f19060b.g(i10);
        this.f19059a.d(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c h(int i10) {
        return this.f19060b.h(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c i(int i10) {
        return null;
    }

    public i(e eVar, h hVar) {
        this.f19059a = eVar;
        this.f19060b = hVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) throws IOException {
        c a10 = this.f19060b.a(fVar);
        this.f19059a.a(a10);
        return a10;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f fVar) {
        return this.f19060b.b(fVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean c(int i10) {
        if (!this.f19060b.c(i10)) {
            return false;
        }
        this.f19059a.b(i10);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        return this.f19060b.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void b(int i10) {
        this.f19060b.b(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.f19060b.a(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(int i10) {
        return this.f19060b.a(i10);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i10, long j10) throws IOException {
        this.f19060b.a(cVar, i10, j10);
        this.f19059a.a(cVar, i10, cVar.b(i10).c());
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i10, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.f19060b.a(i10, aVar, exc);
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.f19059a.d(i10);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) throws IOException {
        boolean a10 = this.f19060b.a(cVar);
        this.f19059a.c(cVar);
        String e10 = cVar.e();
        com.sigmob.sdk.downloader.core.c.a(f19058c, "update " + cVar);
        if (cVar.n() && e10 != null) {
            this.f19059a.a(cVar.k(), e10);
        }
        return a10;
    }
}
