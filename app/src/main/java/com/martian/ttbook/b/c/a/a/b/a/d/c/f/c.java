package com.martian.ttbook.b.c.a.a.b.a.d.c.f;

import android.app.Activity;
import android.view.View;
import com.martian.ttbook.b.c.a.a.b.a.d.c.d;
import com.martian.ttbook.b.c.a.a.b.a.d.p;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.c.j;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAd;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private UnifiedVivoInterstitialAd f15393a;

    /* renamed from: b */
    private UnifiedVivoInterstitialAdListener f15394b;

    public c(p<View> pVar) {
        this.f15394b = d.a().d(pVar);
    }

    private void f(String str, Activity activity, e eVar) {
        UnifiedVivoInterstitialAd unifiedVivoInterstitialAd = new UnifiedVivoInterstitialAd(activity, com.martian.ttbook.b.c.a.a.b.a.d.c.b.g(str).build(), this.f15394b);
        this.f15393a = unifiedVivoInterstitialAd;
        if (eVar instanceof j) {
            unifiedVivoInterstitialAd.setMediaListener(d.a().f(new com.martian.ttbook.b.c.a.a.b.a.d.c.c((j) eVar)));
        }
    }

    public void a() {
        this.f15393a = null;
    }

    public void b(int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.j(this.f15393a, i2);
    }

    public void c(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.h(this.f15393a, i3);
    }

    public void d(Activity activity) {
        UnifiedVivoInterstitialAd unifiedVivoInterstitialAd = this.f15393a;
        if (unifiedVivoInterstitialAd != null) {
            unifiedVivoInterstitialAd.showVideoAd(activity);
        }
    }

    public void e(Activity activity, String str, e eVar) {
        com.martian.ttbook.b.c.a.a.e.d.g("VVINTAG", "handle #3");
        f(str, activity, eVar);
        this.f15393a.loadAd();
    }

    public UnifiedVivoInterstitialAd g() {
        return this.f15393a;
    }

    public void h(Activity activity, String str, e eVar) {
        com.martian.ttbook.b.c.a.a.e.d.g("VVINTAG", "handle #3");
        f(str, activity, eVar);
        this.f15393a.loadVideoAd();
    }

    public void i() {
        UnifiedVivoInterstitialAd unifiedVivoInterstitialAd = this.f15393a;
        if (unifiedVivoInterstitialAd != null) {
            unifiedVivoInterstitialAd.showAd();
        }
    }
}
