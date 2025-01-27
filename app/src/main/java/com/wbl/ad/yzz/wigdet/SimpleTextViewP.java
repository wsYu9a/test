package com.wbl.ad.yzz.wigdet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class SimpleTextViewP extends TextView {
    public SimpleTextViewP(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8504, this, accessibilityNodeInfo);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8503, this, Integer.valueOf(i2));
    }

    public SimpleTextViewP(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleTextViewP(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SimpleTextViewP(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
