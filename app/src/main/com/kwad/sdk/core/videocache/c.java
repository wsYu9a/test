package com.kwad.sdk.core.videocache;

import java.io.File;

/* loaded from: classes3.dex */
final class c {
    public final File aFZ;
    public final com.kwad.sdk.core.videocache.a.c aGa;
    public final com.kwad.sdk.core.videocache.a.a aGb;
    public final com.kwad.sdk.core.videocache.d.c aGc;
    public final com.kwad.sdk.core.videocache.b.b aGd;
    public final int aGe;
    public final int aGf;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i10, int i11) {
        this.aFZ = file;
        this.aGa = cVar;
        this.aGb = aVar;
        this.aGc = cVar2;
        this.aGd = bVar;
        this.aGe = i10;
        this.aGf = i11;
    }

    public final File eJ(String str) {
        return new File(this.aFZ, this.aGa.generate(str));
    }
}
