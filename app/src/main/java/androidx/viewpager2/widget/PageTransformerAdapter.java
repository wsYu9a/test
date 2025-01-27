package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a */
    private final LinearLayoutManager f4112a;

    /* renamed from: b */
    private ViewPager2.PageTransformer f4113b;

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f4112a = linearLayoutManager;
    }

    ViewPager2.PageTransformer a() {
        return this.f4113b;
    }

    void b(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f4113b = pageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i2, float f2, int i3) {
        if (this.f4113b == null) {
            return;
        }
        float f3 = -f2;
        for (int i4 = 0; i4 < this.f4112a.getChildCount(); i4++) {
            View childAt = this.f4112a.getChildAt(i4);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i4), Integer.valueOf(this.f4112a.getChildCount())));
            }
            this.f4113b.transformPage(childAt, (this.f4112a.getPosition(childAt) - i2) + f3);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i2) {
    }
}
