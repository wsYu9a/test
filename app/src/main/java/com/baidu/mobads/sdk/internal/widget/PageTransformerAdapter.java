package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a */
    private final LinearLayoutManager f5880a;

    /* renamed from: b */
    private ViewPager2.PageTransformer f5881b;

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f5880a = linearLayoutManager;
    }

    ViewPager2.PageTransformer a() {
        return this.f5881b;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i2, float f2, int i3) {
        if (this.f5881b == null) {
            return;
        }
        float f3 = -f2;
        for (int i4 = 0; i4 < this.f5880a.getChildCount(); i4++) {
            View childAt = this.f5880a.getChildAt(i4);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i4), Integer.valueOf(this.f5880a.getChildCount())));
            }
            this.f5881b.transformPage(childAt, (this.f5880a.getPosition(childAt) - i2) + f3);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i2) {
    }

    void a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f5881b = pageTransformer;
    }
}
