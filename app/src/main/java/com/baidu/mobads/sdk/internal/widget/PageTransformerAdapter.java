package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes2.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a */
    private final LinearLayoutManager f7264a;

    /* renamed from: b */
    private ViewPager2.PageTransformer f7265b;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f7264a = linearLayoutManager;
    }

    public ViewPager2.PageTransformer a() {
        return this.f7265b;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f7265b == null) {
            return;
        }
        float f11 = -f10;
        for (int i12 = 0; i12 < this.f7264a.getChildCount(); i12++) {
            View childAt = this.f7264a.getChildAt(i12);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i12), Integer.valueOf(this.f7264a.getChildCount())));
            }
            this.f7265b.transformPage(childAt, (this.f7264a.getPosition(childAt) - i10) + f11);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i10) {
    }

    public void a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f7265b = pageTransformer;
    }
}
