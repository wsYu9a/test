package com.vivo.google.android.exoplayer3;

import android.media.AudioTrack;

/* loaded from: classes4.dex */
public class m extends Thread {

    /* renamed from: a */
    public final /* synthetic */ AudioTrack f27743a;

    public m(l lVar, AudioTrack audioTrack) {
        this.f27743a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f27743a.release();
    }
}
