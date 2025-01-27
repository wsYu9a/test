package com.vivo.mobilead.unified.base.view.t;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.RelativeLayout;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;

/* loaded from: classes4.dex */
public abstract class c extends RelativeLayout {
    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public abstract void a(com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, String str, int i2, int i3);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public abstract void setMediaListener(MediaListener mediaListener);

    public abstract void setRewardVideoAdListener(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener);
}
