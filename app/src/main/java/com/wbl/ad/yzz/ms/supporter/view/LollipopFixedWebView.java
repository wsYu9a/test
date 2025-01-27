package com.wbl.ad.yzz.ms.supporter.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class LollipopFixedWebView extends WebView {
    public LollipopFixedWebView(Context context) {
        super(a(context));
    }

    public static Context a(Context context) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11529, null, context);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(context), attributeSet, i2);
    }

    @TargetApi(21)
    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a(context), attributeSet, i2, i3);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(a(context), attributeSet, i2, z);
    }
}
