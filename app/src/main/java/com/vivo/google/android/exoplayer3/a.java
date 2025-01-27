package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.l3;

/* loaded from: classes4.dex */
public abstract class a implements Renderer, g {
    public h configuration;
    public int index;
    public boolean readEndOfStream = true;
    public int state;
    public p3 stream;
    public boolean streamIsFinal;
    public long streamOffsetUs;
    public final int trackType;

    public a(int i2) {
        this.trackType = i2;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void disable() {
        g1.b(this.state == 1);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void enable(h hVar, Format[] formatArr, p3 p3Var, long j2, boolean z, long j3) {
        g1.b(this.state == 0);
        this.configuration = hVar;
        this.state = 1;
        onEnabled(z);
        replaceStream(formatArr, p3Var, j3);
        onPositionReset(j2, z);
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final g getCapabilities() {
        return this;
    }

    public final h getConfiguration() {
        return this.configuration;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public k6 getMediaClock() {
        return null;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final int getState() {
        return this.state;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final p3 getStream() {
        return this.stream;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer, com.vivo.google.android.exoplayer3.g
    public final int getTrackType() {
        return this.trackType;
    }

    @Override // com.vivo.google.android.exoplayer3.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i2, Object obj) {
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.readEndOfStream;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public final boolean isSourceReady() {
        return this.readEndOfStream ? this.streamIsFinal : ((l3.e) this.stream).a();
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void maybeThrowStreamError() {
        l3.this.j();
    }

    public abstract void onDisabled();

    public void onEnabled(boolean z) {
    }

    public abstract void onPositionReset(long j2, boolean z);

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void onStreamChanged(Format[] formatArr) {
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int readSource(com.vivo.google.android.exoplayer3.C0922c r21, com.vivo.google.android.exoplayer3.w r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.a.readSource(com.vivo.google.android.exoplayer3.c, com.vivo.google.android.exoplayer3.w, boolean):int");
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void replaceStream(Format[] formatArr, p3 p3Var, long j2) {
        g1.b(!this.streamIsFinal);
        this.stream = p3Var;
        this.readEndOfStream = false;
        this.streamOffsetUs = j2;
        onStreamChanged(formatArr);
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void resetPosition(long j2) {
        this.streamIsFinal = false;
        this.readEndOfStream = false;
        onPositionReset(j2, false);
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void setIndex(int i2) {
        this.index = i2;
    }

    public void skipSource(long j2) {
        p3 p3Var = this.stream;
        long j3 = j2 - this.streamOffsetUs;
        l3.e eVar = (l3.e) p3Var;
        l3 l3Var = l3.this;
        e0 valueAt = l3Var.o.valueAt(eVar.f27668a);
        if (!l3Var.F || j3 <= valueAt.f27309c.a()) {
            long a2 = valueAt.f27309c.a(j3, true);
            if (a2 == -1) {
                return;
            }
            valueAt.a(a2);
            return;
        }
        long d2 = valueAt.f27309c.d();
        if (d2 != -1) {
            valueAt.a(d2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void start() {
        g1.b(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public final void stop() {
        g1.b(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.vivo.google.android.exoplayer3.g
    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }
}
