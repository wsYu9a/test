package com.kwad.components.ad.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public class a {
    public b Gj;
    private boolean Gk = false;
    private i Gl = new j() { // from class: com.kwad.components.ad.h.a.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            a.this.mAdTemplate.setmCurPlayTime(-1L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            if (!a.this.Gk) {
                a.this.lH();
            } else if (d.uQ()) {
                a.this.lH();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.mAdTemplate.setmCurPlayTime(j3);
        }
    };

    @NonNull
    public AdTemplate mAdTemplate;
    protected DetailVideoView mDetailVideoView;

    /* renamed from: com.kwad.components.ad.h.a$1 */
    final class AnonymousClass1 extends j {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            a.this.mAdTemplate.setmCurPlayTime(-1L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            if (!a.this.Gk) {
                a.this.lH();
            } else if (d.uQ()) {
                a.this.lH();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.mAdTemplate.setmCurPlayTime(j3);
        }
    }

    public a(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.mDetailVideoView = detailVideoView;
        this.Gj = new b(this.mDetailVideoView);
        lF();
    }

    private void lF() {
        this.Gj.c(this.Gl);
    }

    private void lG() {
        i iVar;
        b bVar = this.Gj;
        if (bVar == null || (iVar = this.Gl) == null) {
            return;
        }
        bVar.d(iVar);
        this.Gl = null;
    }

    public void lH() {
        com.kwad.components.core.m.a.pb().g(this.mAdTemplate, 21008);
        this.Gk = true;
    }

    @WorkerThread
    public void release() {
        this.Gk = false;
        lG();
    }

    @WorkerThread
    public void releaseSync() {
        this.Gk = false;
        lG();
    }
}
