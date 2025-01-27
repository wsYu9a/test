package com.martian.mibook.mvvm.yuewen.adapter.holder;

import androidx.viewpager2.widget.ViewPager2;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder$setViewPagerData$1;
import id.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$setViewPagerData$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrolled", "", c.f26972i, "", "positionOffset", "", "positionOffsetPixels", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ItemCategoryHolder$setViewPagerData$1 extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a */
    public final /* synthetic */ ItemCategoryHolder f15549a;

    public ItemCategoryHolder$setViewPagerData$1(ItemCategoryHolder itemCategoryHolder) {
        this.f15549a = itemCategoryHolder;
    }

    public static final void b(ItemCategoryHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YWBookChannel yWBookChannel = this$0.bookChannel;
        if (yWBookChannel != null) {
            yWBookChannel.setExposed(Boolean.FALSE);
        }
        this$0.f(this$0.getBindingAdapterPosition());
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r32, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(r32, positionOffset, positionOffsetPixels);
        this.f15549a.getBinding().viewpager.postDelayed(new Runnable() { // from class: ud.d
            public /* synthetic */ d() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ItemCategoryHolder$setViewPagerData$1.b(ItemCategoryHolder.this);
            }
        }, 500L);
    }
}
