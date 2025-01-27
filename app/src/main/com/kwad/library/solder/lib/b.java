package com.kwad.library.solder.lib;

import com.kwad.library.solder.lib.a.a;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;

/* loaded from: classes3.dex */
public class b<P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> implements com.kwad.library.solder.lib.ext.b<P, R> {
    com.kwad.library.solder.lib.ext.b<P, R> amb;
    com.kwad.library.solder.lib.ext.b<P, R> amc;

    public b(com.kwad.library.solder.lib.ext.b<P, R> bVar, com.kwad.library.solder.lib.ext.b<P, R> bVar2) {
        this.amb = bVar;
        this.amc = bVar2;
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r10, P p10) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.a((com.kwad.library.solder.lib.ext.b<P, R>) r10, (R) p10);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void b(R r10) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.b(r10);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void c(R r10) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.c(r10);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void d(R r10) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.d(r10);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void e(R r10) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.e(r10);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void f(R r10) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.f(r10);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public void a(R r10, PluginError pluginError) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.a((com.kwad.library.solder.lib.ext.b<P, R>) r10, pluginError);
        }
        com.kwad.library.solder.lib.ext.b<P, R> bVar2 = this.amc;
        if (bVar2 != null) {
            bVar2.a((com.kwad.library.solder.lib.ext.b<P, R>) r10, pluginError);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r10) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.amb;
        if (bVar != null) {
            bVar.a(r10);
        }
    }
}
