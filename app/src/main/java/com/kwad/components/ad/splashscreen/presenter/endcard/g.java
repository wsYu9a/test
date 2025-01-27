package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ah;

/* loaded from: classes2.dex */
public final class g {
    private float Gy;
    private Context mContext;

    public g(Context context, float f10) {
        this.mContext = context;
        this.Gy = f10;
    }

    private int g(Context context, int i10) {
        return (int) (com.kwad.sdk.c.a.a.h(context, i10) * this.Gy);
    }

    public final ah lW() {
        return new ah(g(this.mContext, R.dimen.ksad_splash_endcard_title_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_title_iconh_land));
    }

    public final ah lX() {
        return new ah(g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconh_land));
    }

    public final ah lY() {
        int g10 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land);
        int g11 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconh_land);
        int g12 = g(this.mContext, R.dimen.ksad_splash_endcard_app_margin_top_land);
        ah ahVar = new ah(g10, g11);
        ahVar.ef(g12);
        return ahVar;
    }

    public final int lZ() {
        return com.kwad.sdk.c.a.a.px2dip(this.mContext, (int) (g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land) * 0.24f));
    }

    public final ah ma() {
        return new ah(g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconh_land));
    }

    public final ah mb() {
        int g10 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_h_land);
        int g11 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_margin_top_land);
        ah ahVar = new ah(0, g10);
        ahVar.ef(g11);
        return ahVar;
    }

    public final ah mc() {
        return new ah(0, g(this.mContext, R.dimen.ksad_splash_endcard_appver_h_land));
    }

    public final ah md() {
        int g10 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_h_land);
        int g11 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_margin_top_land);
        ah ahVar = new ah(0, g10);
        ahVar.ef(g11);
        return ahVar;
    }

    public final ah me() {
        int g10 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_h_land);
        int g11 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_margin_top_land);
        ah ahVar = new ah(0, g10);
        ahVar.ef(g11);
        return ahVar;
    }

    public final int mf() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appname_text_sp_land);
    }

    public final int mg() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appver_text_sp_land);
    }

    public final int mh() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_text_sp_land);
    }

    public final int mi() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_title_text_sp_land);
    }

    public final int mj() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_subtitle_text_sp_land);
    }
}
