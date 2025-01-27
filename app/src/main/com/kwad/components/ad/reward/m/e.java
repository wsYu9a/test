package com.kwad.components.ad.reward.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class e {
    private g rO;

    @Nullable
    private com.kwad.components.ad.reward.f.a zw;

    @Nullable
    private d zx;

    @Nullable
    private b zy;

    @NonNull
    private com.kwad.components.ad.l.a zz;
    private int zv = 0;
    private int zA = 0;
    private List<l> zB = new CopyOnWriteArrayList();

    public e(g gVar) {
        this.rO = gVar;
        this.zz = new a(gVar.mAdTemplate);
    }

    private com.kwad.components.ad.l.a kg() {
        return this.zz;
    }

    public final void a(int i10, com.kwad.components.ad.l.a aVar) {
        this.zv = i10;
        if (i10 == 1) {
            this.zx = (d) aVar;
        } else if (i10 == 2) {
            this.zw = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i10 == 3) {
            this.zy = (b) aVar;
        }
        this.zz = aVar;
        Iterator<l> it = this.zB.iterator();
        while (it.hasNext()) {
            this.zz.b(it.next());
        }
        this.zB.clear();
    }

    public final void b(@Nullable l lVar) {
        kg().a(lVar);
        if (lVar != null) {
            this.zB.remove(lVar);
        }
    }

    public final long getPlayDuration() {
        return kg().getPlayDuration();
    }

    public final void kd() {
        d dVar = this.zx;
        if (dVar != null) {
            dVar.kd();
        } else {
            b bVar = this.zy;
            if (bVar != null) {
                bVar.kd();
            }
        }
        this.rO.fS();
    }

    public final void ke() {
        d dVar = this.zx;
        if (dVar != null) {
            dVar.ke();
        }
    }

    public final boolean kh() {
        return this.zw != null;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.a ki() {
        return this.zw;
    }

    @Nullable
    public final b kj() {
        return this.zy;
    }

    public final void pause() {
        kg().pause();
    }

    public final void release() {
        kg().release();
    }

    public final void resume() {
        int i10;
        kg().resume();
        com.kwad.components.ad.reward.f.a aVar = this.zw;
        if (aVar == null || (i10 = this.zA) <= 0) {
            return;
        }
        aVar.setAudioEnabled(i10 == 2, false);
    }

    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.zA = z10 ? 2 : 1;
        kg().setAudioEnabled(z10, z11);
    }

    public final void skipToEnd() {
        kg().skipToEnd();
    }

    public final void b(i.a aVar) {
        d dVar = this.zx;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void a(@Nullable l lVar) {
        if (kg().kc()) {
            this.zB.add(lVar);
        } else {
            kg().b(lVar);
        }
    }

    public final void a(i.a aVar) {
        d dVar = this.zx;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }
}
