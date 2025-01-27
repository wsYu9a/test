package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import com.kwad.sdk.utils.ah;

/* loaded from: classes2.dex */
public final class a {
    private float Gy;
    private int HK;
    private int HL;
    private int HM;
    private int HN;
    private int HO;
    private int HP;
    private Context mContext;

    private a(Context context) {
        this.HK = 24;
        this.HL = 12;
        this.HM = 16;
        this.HN = 12;
        this.HO = 6;
        this.HP = 4;
        this.Gy = 1.0f;
        this.mContext = context;
    }

    public static a ah(Context context) {
        return new a(context);
    }

    public static a ai(Context context) {
        return new a(context, 17, 10, 12, 8, 4, 3);
    }

    public final void d(float f10) {
        this.Gy = f10;
    }

    public final int mB() {
        return (int) (((this.HK - this.HM) / 2) * this.Gy);
    }

    public final int mC() {
        return (int) (this.HN * this.Gy);
    }

    public final ah mD() {
        int a10 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.HO) * this.Gy);
        int a11 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.HP) * this.Gy);
        ah ahVar = new ah(0, 0);
        ahVar.eh(a10);
        ahVar.ei(a11);
        return ahVar;
    }

    public final int mE() {
        return (int) (com.kwad.sdk.c.a.a.b(this.mContext, this.HL) * this.Gy);
    }

    public final float mF() {
        return (com.kwad.sdk.c.a.a.a(this.mContext, this.HK) * this.Gy) / 2.0f;
    }

    public final ah mG() {
        int a10 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.HM) * this.Gy);
        return new ah(a10, a10);
    }

    public final ah me() {
        return new ah(0, (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.HK) * this.Gy));
    }

    private a(Context context, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.Gy = 1.0f;
        this.mContext = context;
        this.HK = 17;
        this.HL = 10;
        this.HM = 12;
        this.HN = 8;
        this.HO = 4;
        this.HP = 3;
    }
}
