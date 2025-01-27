package com.opos.exoplayer.core.c.a;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.a.b;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.m;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class c extends b {

    /* renamed from: b */
    private static final int[] f17772b = {5512, 11025, 22050, 44100};

    /* renamed from: c */
    private boolean f17773c;

    /* renamed from: d */
    private boolean f17774d;

    /* renamed from: e */
    private int f17775e;

    public c(n nVar) {
        super(nVar);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(m mVar) {
        Format a2;
        if (this.f17773c) {
            mVar.d(1);
        } else {
            int g2 = mVar.g();
            int i2 = (g2 >> 4) & 15;
            this.f17775e = i2;
            if (i2 == 2) {
                a2 = Format.a(null, "audio/mpeg", null, -1, -1, 1, f17772b[(g2 >> 2) & 3], null, null, 0, null);
            } else if (i2 == 7 || i2 == 8) {
                a2 = Format.a((String) null, i2 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, (g2 & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
            } else {
                if (i2 != 10) {
                    throw new b.a("Audio format not supported: " + this.f17775e);
                }
                this.f17773c = true;
            }
            this.f17771a.a(a2);
            this.f17774d = true;
            this.f17773c = true;
        }
        return true;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(m mVar, long j2) {
        if (this.f17775e == 2) {
            int b2 = mVar.b();
            this.f17771a.a(mVar, b2);
            this.f17771a.a(j2, 1, b2, 0, null);
            return;
        }
        int g2 = mVar.g();
        if (g2 != 0 || this.f17774d) {
            if (this.f17775e != 10 || g2 == 1) {
                int b3 = mVar.b();
                this.f17771a.a(mVar, b3);
                this.f17771a.a(j2, 1, b3, 0, null);
                return;
            }
            return;
        }
        int b4 = mVar.b();
        byte[] bArr = new byte[b4];
        mVar.a(bArr, 0, b4);
        Pair<Integer, Integer> a2 = com.opos.exoplayer.core.i.c.a(bArr);
        this.f17771a.a(Format.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(bArr), null, 0, null));
        this.f17774d = true;
    }
}
