package com.kwad.components.core.video.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;

/* loaded from: classes3.dex */
public final class d extends com.kwad.components.core.video.a.a {
    private long XJ;
    private long XK;
    private long XL;
    private String XM;
    private boolean XN;
    private boolean XO;
    private boolean XP;
    private long XQ;
    private long XR;
    private long XS;
    private long XT;
    private i vx;
    private String zo;

    /* renamed from: com.kwad.components.core.video.a.d$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ boolean XU;
        final /* synthetic */ b XV;
        final /* synthetic */ int XW;
        final /* synthetic */ int XX;

        public AnonymousClass1(boolean z10, b bVar, int i10, int i11) {
            z10 = z10;
            clone = bVar;
            i10 = i10;
            i11 = i11;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (z10) {
                com.kwad.sdk.commercial.b.s(clone);
            } else {
                com.kwad.sdk.commercial.b.t(d.this.o(i10, i11));
            }
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.commercial.c.a {
        public long UK;
        public String XZ;
        public int code;
        public long creativeId;
        public long llsid;
        public String msg;
        public String videoUrl;
    }

    @KsJson
    public static class b extends com.kwad.sdk.commercial.c.a implements Cloneable {
        public long UK;
        public int XH;
        public String XZ;
        public long Ya;
        public long Yb;
        public long Yc;
        public long creativeId;
        public long llsid;
        public long videoDuration;
        public String videoUrl;

        /* renamed from: tb */
        public final b clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException unused) {
                return new b();
            }
        }
    }

    private d(@NonNull AdTemplate adTemplate) {
        this.XN = false;
        this.XO = false;
        this.XP = false;
        try {
            AdInfo eb2 = e.eb(adTemplate);
            this.zo = com.kwad.sdk.core.response.b.a.K(eb2);
            this.XJ = e.dY(adTemplate);
            this.XK = e.el(adTemplate);
            this.XL = com.kwad.sdk.core.response.b.a.cn(eb2);
            this.XM = com.kwad.sdk.core.response.b.a.cj(eb2);
            this.vx = new i();
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    public static com.kwad.components.core.video.a.a aF(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awB) ? new d(adTemplate) : new com.kwad.components.core.video.a.b();
    }

    private void b(boolean z10, int i10, int i11) {
        if (this.XP) {
            this.vx.sU();
            this.XT = SystemClock.elapsedRealtime();
            a(z10, i10, i11);
            reset();
        }
    }

    public a o(int i10, int i11) {
        a aVar = new a();
        aVar.code = i10;
        aVar.msg = String.valueOf(i11);
        aVar.videoUrl = this.zo;
        aVar.llsid = this.XJ;
        aVar.creativeId = this.XK;
        aVar.UK = this.XL;
        aVar.XZ = this.XM;
        return aVar;
    }

    private void reset() {
        this.vx.reset();
        this.XQ = 0L;
        this.XR = 0L;
        this.XT = 0L;
        this.XS = 0L;
        this.XN = false;
        this.XO = false;
        this.XP = false;
    }

    private b ta() {
        b bVar = new b();
        long j10 = this.XR;
        long j11 = this.XQ;
        bVar.Ya = j10 - j11;
        bVar.Yb = this.XS - j11;
        bVar.Yc = this.vx.sW().sZ();
        bVar.videoDuration = this.XT - this.XQ;
        bVar.XH = this.vx.sW().sY();
        bVar.videoUrl = this.zo;
        bVar.llsid = this.XJ;
        bVar.creativeId = this.XK;
        bVar.UK = this.XL;
        bVar.XZ = this.XM;
        return bVar;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayError(int i10, int i11) {
        super.onMediaPlayError(i10, i11);
        this.vx.sU();
        b(false, i10, i11);
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayPaused() {
        super.onMediaPlayPaused();
        this.vx.sU();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayStart() {
        super.onMediaPlayStart();
        if (this.XO) {
            return;
        }
        this.XR = SystemClock.elapsedRealtime();
        this.XO = true;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlaying() {
        super.onMediaPlaying();
        ps();
        this.vx.sU();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onRelease() {
        b(true, 0, 0);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onReset() {
        b(false, 0, 0);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onStart() {
        if (this.XN) {
            return;
        }
        this.XQ = SystemClock.elapsedRealtime();
        this.XN = true;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPaused() {
        super.onVideoPlayBufferingPaused();
        this.vx.sT();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPlaying() {
        super.onVideoPlayBufferingPlaying();
        this.vx.sT();
    }

    @Override // com.kwad.components.core.video.a.a
    public final void ps() {
        if (this.XP) {
            return;
        }
        this.XS = SystemClock.elapsedRealtime();
        this.XP = true;
    }

    private void a(boolean z10, int i10, int i11) {
        h.execute(new bd() { // from class: com.kwad.components.core.video.a.d.1
            final /* synthetic */ boolean XU;
            final /* synthetic */ b XV;
            final /* synthetic */ int XW;
            final /* synthetic */ int XX;

            public AnonymousClass1(boolean z102, b bVar, int i102, int i112) {
                z10 = z102;
                clone = bVar;
                i10 = i102;
                i11 = i112;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (z10) {
                    com.kwad.sdk.commercial.b.s(clone);
                } else {
                    com.kwad.sdk.commercial.b.t(d.this.o(i10, i11));
                }
            }
        });
    }

    public static com.kwad.components.core.video.a.a a(AdTemplate adTemplate, AdTemplate adTemplate2, String str) {
        if (!com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awB)) {
            return new com.kwad.components.core.video.a.b();
        }
        if (adTemplate != null) {
            return new d(adTemplate);
        }
        return adTemplate2 == null ? new d(str) : new d(adTemplate2);
    }

    private d(String str) {
        this.XN = false;
        this.XO = false;
        this.XP = false;
        this.zo = str;
        this.vx = new i();
    }
}
