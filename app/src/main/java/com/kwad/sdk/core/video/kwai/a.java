package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;

/* loaded from: classes2.dex */
public abstract class a implements c {
    private c.e QP;
    private c.h QQ;
    private c.b QR;
    private c.InterfaceC0220c QS;
    private c.d QT;
    private c.a QU;
    private c.f amO;
    private c.g amP;

    protected static void f(float f2) {
        com.kwad.sdk.core.video.kwai.kwai.a.cN(f2 == 0.0f ? "autoMute" : "autoVoice");
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.a aVar) {
        this.QU = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.b bVar) {
        this.QR = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.InterfaceC0220c interfaceC0220c) {
        this.QS = interfaceC0220c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.f fVar) {
        this.amO = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.g gVar) {
        this.amP = gVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.h hVar) {
        this.QQ = hVar;
    }

    protected final void b(TimedText timedText) {
        c.g gVar = this.amP;
        if (gVar != null) {
            gVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void b(c.e eVar) {
        this.QP = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void c(c.d dVar) {
        this.QT = dVar;
    }

    protected final void notifyOnBufferingUpdate(int i2) {
        c.a aVar = this.QU;
        if (aVar != null) {
            aVar.ax(i2);
        }
    }

    protected final void notifyOnCompletion() {
        c.b bVar = this.QR;
        if (bVar != null) {
            bVar.nU();
        }
    }

    protected final boolean notifyOnError(int i2, int i3) {
        c.InterfaceC0220c interfaceC0220c = this.QS;
        return interfaceC0220c != null && interfaceC0220c.j(i2, i3);
    }

    protected final boolean notifyOnInfo(int i2, int i3) {
        c.d dVar = this.QT;
        return dVar != null && dVar.k(i2, i3);
    }

    protected final void notifyOnPrepared() {
        c.e eVar = this.QP;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    protected final void notifyOnSeekComplete() {
        c.f fVar = this.amO;
        if (fVar != null) {
            fVar.nV();
        }
    }

    protected final void r(int i2, int i3) {
        c.h hVar = this.QQ;
        if (hVar != null) {
            hVar.i(i2, i3);
        }
    }

    public final void resetListeners() {
        this.QP = null;
        this.QU = null;
        this.QR = null;
        this.amO = null;
        this.QQ = null;
        this.QS = null;
        this.QT = null;
        this.amP = null;
    }
}
