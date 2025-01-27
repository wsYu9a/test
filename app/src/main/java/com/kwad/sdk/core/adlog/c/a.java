package com.kwad.sdk.core.adlog.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

@KsJson
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public String MI;
    public a.C0484a MJ;
    public long Nk;
    public int Qq;

    @NonNull
    public AdTemplate adTemplate;
    public String adnName;
    public int adnType;
    public int asm;
    public int atA;
    public String atC;
    public int atD;
    public int atE;
    public String atF;
    public String atG;
    public int atH;
    public int atI;
    public long atJ;
    public long atK;
    public int atN;
    public int atO;
    public String atQ;
    public int atS;
    public int atT;
    public int atU;
    public int atV;
    public String atX;
    public JSONObject ati;
    public int atj;
    public int atk;
    public int atl;
    public int atm;
    public String atn;
    public String atr;
    public String ats;
    public String att;
    public int atu;
    public int atv;
    public int atx;
    public String aty;
    public int atz;
    public int downloadSource;
    public ag.a lB;
    public double lC;
    public int lz;

    /* renamed from: xc */
    public long f11968xc;
    public long ato = -1;
    public int atp = -1;
    public long atq = -1;
    public int atw = -1;
    public int MK = 0;
    public String atB = "";
    public int atL = -1;
    public int atM = -1;
    public int downloadStatus = 0;
    public int atP = -1;
    public int MH = -1;
    public int atR = -1;
    public int adxResult = -1;
    public int ML = -1;
    public int atW = 0;

    public static a CP() {
        return new a();
    }

    public final void a(@Nullable h hVar) {
        if (hVar != null) {
            this.atX = hVar.Gr();
        }
    }

    public final a ao(long j10) {
        this.f11968xc = j10;
        return this;
    }

    public final a ap(long j10) {
        this.Nk = j10;
        return this;
    }

    public final void cE(int i10) {
        if (i10 == 0) {
            this.atT = 1;
        } else if (i10 == 1) {
            this.atT = 2;
        } else {
            if (i10 != 2) {
                return;
            }
            this.atT = 3;
        }
    }

    public final a cF(int i10) {
        this.lz = i10;
        return this;
    }

    public final a cG(int i10) {
        this.MK = i10;
        return this;
    }

    public final a cH(int i10) {
        this.ML = i10;
        return this;
    }

    public final a cI(int i10) {
        this.MH = i10;
        return this;
    }

    public final a cJ(int i10) {
        this.Qq = i10;
        return this;
    }

    public final a cK(int i10) {
        this.atD = i10;
        return this;
    }

    public final a dn(String str) {
        this.MI = str;
        return this;
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0484a c0484a = this.MJ;
        if (c0484a == null) {
            a.C0484a c0484a2 = new a.C0484a();
            this.MJ = c0484a2;
            c0484a2.a(adTemplate, null, null, null);
        } else if (c0484a.asL == null) {
            c0484a.a(adTemplate, null, null, null);
        }
    }

    public final a a(a.C0484a c0484a) {
        this.MJ = c0484a;
        return this;
    }

    public final a e(ag.a aVar) {
        this.lB = aVar;
        return this;
    }
}
