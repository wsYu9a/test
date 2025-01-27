package com.wbl.ad.yzz.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.mobads.sdk.api.XNativeView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class FixBaiduXNativeView extends XNativeView {
    public FixBaiduXNativeView(Context context) {
        super(context);
    }

    @Override // com.baidu.mobads.sdk.api.XNativeView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8386, this, null);
    }

    public FixBaiduXNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixBaiduXNativeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
