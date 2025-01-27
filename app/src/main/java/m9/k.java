package m9;

import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.utils.tablayout.MagicIndicator;

/* loaded from: classes3.dex */
public class k {

    public class a implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        public final /* synthetic */ MagicIndicator f28554a;

        public a(MagicIndicator magicIndicator) {
            this.f28554a = magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            this.f28554a.a(i10);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            this.f28554a.b(i10, f10, i11);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            this.f28554a.c(i10);
        }
    }

    public static void a(MagicIndicator magicIndicator, ViewPager viewPager) {
        if (magicIndicator == null || viewPager == null) {
            return;
        }
        viewPager.addOnPageChangeListener(new a(magicIndicator));
    }
}
