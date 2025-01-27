package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;

/* loaded from: classes.dex */
public abstract class x3 extends FrameLayout {

    /* renamed from: a */
    public boolean f3490a;

    public x3(Context context) {
        super(context, null, 0);
    }

    public abstract void a(int i10);

    public abstract void a(VlionCustomParseAdData vlionCustomParseAdData, View view, boolean z10, boolean z11, int i10, boolean z12, boolean z13, VlionCustomInterstitialActivity.e eVar);

    public abstract void a(String str);

    public abstract void a(String str, boolean z10);

    public abstract void a(String str, boolean z10, boolean z11);

    public abstract boolean a();

    public abstract void b();

    public abstract void b(int i10);

    public abstract void c();

    public abstract void d();

    public abstract ViewGroup getAdViewContainer();

    public abstract void setImageGravity(int i10);

    public abstract void setProgress(int i10);
}
