package com.wbl.ad.yzz.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class MaxHeightFrameLayout extends FrameLayout {

    /* renamed from: a */
    public int f34384a;

    /* renamed from: b */
    public int f34385b;

    public MaxHeightFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8385, this, context, attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8388, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public MaxHeightFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public MaxHeightFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }
}
