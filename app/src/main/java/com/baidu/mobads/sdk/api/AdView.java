package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ax;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.cp;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class AdView extends RelativeLayout {
    private static final boolean AUTOPLAY = true;
    private static final float HEIGHT_FACTOR = 0.15f;
    protected static final String P_VERSION = "3.61";
    private AtomicBoolean hasCalledRequestMethod;
    private cp mAdProd;

    /* renamed from: com.baidu.mobads.sdk.api.AdView$1 */
    class AnonymousClass1 implements co.a {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onAttachedToWindow() {
            AdView.this.callRequest();
            AdView.this.mAdProd.o();
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        @SuppressLint({"MissingSuperCall"})
        public void onDetachedFromWindow() {
            AdView.this.mAdProd.p();
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            return AdView.this.mAdProd.a(i2, keyEvent);
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onLayoutComplete(int i2, int i3) {
            AdView.this.callRequest();
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onWindowFocusChanged(boolean z) {
            AdView.this.mAdProd.a(z);
        }

        @Override // com.baidu.mobads.sdk.internal.co.a
        public void onWindowVisibilityChanged(int i2) {
            AdView.this.mAdProd.b(i2);
        }
    }

    public AdView(Context context) {
        super(context);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
    }

    public void callRequest() {
        if (this.hasCalledRequestMethod.get()) {
            return;
        }
        this.hasCalledRequestMethod.set(true);
        this.mAdProd.a();
    }

    public void destroy() {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.e();
        }
    }

    public void setAppSid(String str) {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.g(str);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        bq.a().a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i2 = layoutParams.width;
        int i3 = layoutParams.height;
        DisplayMetrics f2 = ax.f(getContext());
        int i4 = f2.widthPixels;
        int i5 = f2.heightPixels;
        float f3 = f2.density;
        bq.a().a("AdView.setLayoutParams", Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f3));
        if (i2 <= 0) {
            i2 = Math.min(i4, i5);
        } else if (i2 > 0) {
            float f4 = 200.0f * f3;
            if (i2 < f4) {
                i2 = (int) f4;
            }
        }
        if (i3 <= 0) {
            i3 = (int) (Math.min(i4, i5) * HEIGHT_FACTOR);
        } else if (i3 > 0) {
            float f5 = f3 * 30.0f;
            if (i3 < f5) {
                i3 = (int) f5;
            }
        }
        layoutParams.width = i2;
        layoutParams.height = i3;
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.a(i2);
            this.mAdProd.c(i3);
        }
        bq.a().a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.a(adViewListener);
        }
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        co coVar = new co(context);
        this.mAdProd = new cp(this, context, coVar, str, z);
        coVar.a(new co.a() { // from class: com.baidu.mobads.sdk.api.AdView.1
            AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onAttachedToWindow() {
                AdView.this.callRequest();
                AdView.this.mAdProd.o();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                AdView.this.mAdProd.p();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                return AdView.this.mAdProd.a(i2, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onLayoutComplete(int i2, int i3) {
                AdView.this.callRequest();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowFocusChanged(boolean z2) {
                AdView.this.mAdProd.a(z2);
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowVisibilityChanged(int i2) {
                AdView.this.mAdProd.b(i2);
            }
        });
        addView(coVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
