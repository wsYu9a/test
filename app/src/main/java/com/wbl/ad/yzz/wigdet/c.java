package com.wbl.ad.yzz.wigdet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class c extends TextView {
    public c(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8476, this, accessibilityNodeInfo);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8475, this, Integer.valueOf(i2));
    }
}
