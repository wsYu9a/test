package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.ag;

/* loaded from: classes3.dex */
public final class b {
    private final a atY = new a();

    public final a CQ() {
        return this.atY;
    }

    public final b aq(long j10) {
        this.atY.f11968xc = j10;
        return this;
    }

    public final b b(a.C0484a c0484a) {
        this.atY.MJ = c0484a;
        return this;
    }

    public final b cL(int i10) {
        this.atY.lz = i10;
        return this;
    }

    public final b cM(int i10) {
        this.atY.atl = i10;
        return this;
    }

    public final b cN(int i10) {
        this.atY.atm = i10;
        return this;
    }

    public final b cO(int i10) {
        this.atY.downloadSource = i10;
        return this;
    }

    public final b cP(int i10) {
        this.atY.atE = i10;
        return this;
    }

    public final b cQ(int i10) {
        this.atY.atH = i10;
        return this;
    }

    public final b cR(int i10) {
        this.atY.atI = i10;
        return this;
    }

    public final b cS(int i10) {
        this.atY.atw = i10;
        return this;
    }

    public final b cT(int i10) {
        this.atY.atO = i10;
        return this;
    }

    public final b cU(int i10) {
        this.atY.atS = i10;
        return this;
    }

    public final b cV(int i10) {
        this.atY.cE(i10);
        return this;
    }

    public final b cW(int i10) {
        this.atY.atU = i10;
        return this;
    }

    public final b cX(int i10) {
        this.atY.ML = i10;
        return this;
    }

    public final b cY(int i10) {
        this.atY.atW = i10;
        return this;
    }

    public final b cZ(int i10) {
        this.atY.MK = i10;
        return this;
    }

    /* renamed from: do */
    public final b m35do(String str) {
        this.atY.MI = str;
        return this;
    }

    public final b dp(String str) {
        this.atY.atF = str;
        return this;
    }

    public final b dq(String str) {
        this.atY.atG = str;
        return this;
    }

    public final b dr(String str) {
        this.atY.atQ = str;
        return this;
    }

    public final b f(ag.a aVar) {
        this.atY.lB = aVar;
        return this;
    }

    public final b l(double d10) {
        this.atY.lC = d10;
        return this;
    }

    public final b v(int i10, int i11) {
        this.atY.atn = i10 + "," + i11;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.f.a<AdTrackLog> aVar) {
        a aVar2 = this.atY;
        if (aVar2.MJ == null) {
            aVar2.MJ = new a.C0484a();
        }
        this.atY.MJ.a(adTemplate, str, str2, aVar);
        return this;
    }
}
