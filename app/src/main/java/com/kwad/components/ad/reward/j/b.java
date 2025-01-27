package com.kwad.components.ad.reward.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;

/* loaded from: classes.dex */
public final class b {

    @Nullable
    private IAdLivePlayModule eV;

    @NonNull
    private a gU;
    private int xD = 0;

    public b(@NonNull a aVar) {
        this.gU = aVar;
    }

    public final void a(@Nullable i iVar, @Nullable AdLivePlayStateListener adLivePlayStateListener) {
        if (!jF()) {
            this.gU.a(iVar);
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.registerAdLivePlayStateListener(adLivePlayStateListener);
        }
    }

    public final void a(@Nullable IAdLivePlayModule iAdLivePlayModule) {
        this.eV = iAdLivePlayModule;
    }

    public final void b(@Nullable i iVar, @Nullable AdLivePlayStateListener adLivePlayStateListener) {
        if (!jF()) {
            this.gU.b(iVar);
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.unRegisterAdLivePlayStateListener(adLivePlayStateListener);
        }
    }

    public final long getPlayDuration() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        return iAdLivePlayModule != null ? iAdLivePlayModule.getPlayDuration() : this.gU.getPlayDuration();
    }

    public final boolean jF() {
        return this.eV != null;
    }

    @Nullable
    public final IAdLivePlayModule jG() {
        return this.eV;
    }

    @NonNull
    public final a jH() {
        return this.gU;
    }

    public final void pause() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.pause();
        } else {
            this.gU.pause();
        }
    }

    public final void release() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
        this.gU.release();
    }

    public final void releaseSync() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
        this.gU.releaseSync();
    }

    public final void resume() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule == null) {
            this.gU.resume();
            return;
        }
        iAdLivePlayModule.resume();
        int i2 = this.xD;
        if (i2 > 0) {
            this.eV.setAudioEnabled(i2 == 2, false);
        }
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.xD = z ? 2 : 1;
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.setAudioEnabled(z, z2);
        } else {
            this.gU.setAudioEnabled(z, z2);
        }
    }

    public final void skipToEnd() {
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.skipToEnd();
        } else {
            this.gU.skipToEnd();
        }
    }
}
