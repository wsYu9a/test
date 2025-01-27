package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;

/* loaded from: classes3.dex */
public abstract class a implements c {
    private c.e WO;
    private c.i WP;
    private c.b WQ;
    private c.InterfaceC0500c WR;
    private c.d WS;
    private c.a WT;
    private c.f aFr;
    private c.g aFs;
    private c.h aFt;

    public static void h(float f10) {
        if (f10 == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.eH("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.eH("autoVoice");
        }
    }

    public final void HM() {
        c.f fVar = this.aFr;
        if (fVar != null) {
            fVar.sB();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.aFr = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.WO = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.WS = dVar;
    }

    public final void notifyOnBufferingUpdate(int i10) {
        c.a aVar = this.WT;
        if (aVar != null) {
            aVar.aw(i10);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.WQ;
        if (bVar != null) {
            bVar.pO();
        }
    }

    public final boolean notifyOnError(int i10, int i11) {
        com.kwad.sdk.core.video.a.a.a.eH("videoPlayError");
        c.InterfaceC0500c interfaceC0500c = this.WR;
        return interfaceC0500c != null && interfaceC0500c.l(i10, i11);
    }

    public final boolean notifyOnInfo(int i10, int i11) {
        c.d dVar = this.WS;
        return dVar != null && dVar.m(i10, i11);
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.WO;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.aFs;
        if (gVar != null) {
            gVar.pP();
        }
    }

    public final void resetListeners() {
        this.aFr = null;
        this.WO = null;
        this.WT = null;
        this.WQ = null;
        this.aFs = null;
        this.WP = null;
        this.WR = null;
        this.WS = null;
        this.aFt = null;
    }

    public final void w(int i10, int i11) {
        c.i iVar = this.WP;
        if (iVar != null) {
            iVar.k(i10, i11);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.WQ = bVar;
    }

    public final void b(TimedText timedText) {
        c.h hVar = this.aFt;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.WT = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.aFs = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.WP = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0500c interfaceC0500c) {
        this.WR = interfaceC0500c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.aFt = hVar;
    }
}
