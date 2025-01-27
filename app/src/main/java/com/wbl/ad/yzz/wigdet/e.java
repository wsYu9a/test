package com.wbl.ad.yzz.wigdet;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class e extends ViewSwitcher {
    public e(Context context) {
        super(context);
    }

    public final Spanned a(Context context, TextView textView, String str, Html.TagHandler tagHandler) {
        return (Spanned) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8407, this, context, textView, str, tagHandler);
    }

    public void a(String str, Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8402, this, str, context);
    }

    @Override // android.widget.ViewSwitcher, android.widget.ViewAnimator, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8401, this, view, Integer.valueOf(i2), layoutParams);
    }

    @Override // android.widget.ViewSwitcher, android.widget.ViewAnimator, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return (CharSequence) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8404, this, null);
    }

    public void setCurrentText(CharSequence charSequence) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8403, this, charSequence);
    }

    public void setText(CharSequence charSequence) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8494, this, charSequence);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
