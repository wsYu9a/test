package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.AdSize;

/* loaded from: classes.dex */
public class dg {

    /* renamed from: f */
    private static final int f5782f = 5;

    /* renamed from: c */
    private RelativeLayout f5785c;

    /* renamed from: d */
    private TextView f5786d;

    /* renamed from: e */
    private CountDownTimer f5787e;

    /* renamed from: g */
    private dj f5788g;

    /* renamed from: j */
    private Activity f5791j;
    private Boolean k;

    /* renamed from: a */
    public final String f5783a = "html5_intersitial";

    /* renamed from: h */
    private boolean f5789h = false;

    /* renamed from: i */
    private boolean f5790i = false;

    /* renamed from: b */
    protected final bq f5784b = bq.a();

    public dg(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    private boolean e() {
        return b();
    }

    private View f() {
        this.f5787e = new di(this, 6000L, 1000L).start();
        return this.f5785c;
    }

    private void g() {
        RelativeLayout relativeLayout = this.f5785c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.f5785c.getParent()).removeView(this.f5785c);
        }
        if (this.f5787e != null) {
            this.f5784b.a("cancel countDownTimer before it finished");
            try {
                this.f5787e.cancel();
            } catch (Exception e2) {
                this.f5784b.a(e2);
            }
        }
    }

    private RelativeLayout.LayoutParams h() {
        return null;
    }

    public void a() {
    }

    public void a(int i2, int i3) {
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        return true;
    }

    protected boolean b() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == 0;
    }

    protected void c() {
        Activity activity = this.f5791j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new dh(this));
    }

    public boolean d() {
        return this.f5789h;
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.f5784b.a("showInterstitialAdInit");
            boolean z = this.f5789h;
            if (z && !this.f5790i) {
                this.f5790i = true;
                this.f5789h = false;
                this.f5791j = activity;
                a();
                c();
                return;
            }
            if (this.f5790i) {
                this.f5784b.b("interstitial ad is showing now");
            } else {
                if (z) {
                    return;
                }
                this.f5784b.b("interstitial ad is not ready");
            }
        } catch (Exception e2) {
            this.f5784b.a(e2);
        }
    }
}
