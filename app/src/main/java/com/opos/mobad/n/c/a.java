package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.msp.mobad.api.R;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends FrameLayout {

    /* renamed from: a */
    private n f21985a;

    /* renamed from: b */
    private o f21986b;

    /* renamed from: c */
    private TextView[] f21987c;

    /* renamed from: d */
    private ImageView[] f21988d;

    /* renamed from: e */
    private com.opos.mobad.c.b.c f21989e;

    /* renamed from: f */
    private boolean f21990f;

    /* renamed from: g */
    private int f21991g;

    /* renamed from: h */
    private int f21992h;

    /* renamed from: i */
    private final int f21993i;

    /* renamed from: com.opos.mobad.n.c.a$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.f21990f) {
                a.this.f21985a.setCurrentItem(a.this.f21985a.getCurrentItem() + 1);
                if (a.this.f21986b != null && a.this.f21992h > 0) {
                    a.this.f21986b.a(a.this.f21992h);
                }
            }
            a.this.f21989e.a(a.this.f21991g + a.this.f21992h);
        }
    }

    /* renamed from: com.opos.mobad.n.c.a$2 */
    class AnonymousClass2 implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        int f21995a = 0;

        /* renamed from: b */
        final /* synthetic */ boolean f21996b;

        AnonymousClass2(boolean z) {
            z = z;
        }

        private void a(int i2) {
            int i3 = 0;
            while (i3 < a.this.f21987c.length) {
                if (a.this.f21987c[i3] != null) {
                    a.this.f21987c[i3].setSelected(i3 == i2);
                }
                i3++;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            n nVar;
            com.opos.cmn.an.f.a.b("CarouselVerticalViewPager", "onPageScrollStateChanged " + i2);
            int i3 = 1;
            if (i2 == 1 || i2 == 2) {
                a.this.f21990f = true;
                return;
            }
            if (i2 == 0) {
                int i4 = this.f21995a;
                if (i4 != 0) {
                    if (i4 == a.this.f21993i + 1) {
                        nVar = a.this.f21985a;
                    }
                    a.this.f21990f = false;
                }
                nVar = a.this.f21985a;
                i3 = a.this.f21993i;
                nVar.setCurrentItem(i3, false);
                a.this.f21990f = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            int i3;
            this.f21995a = i2;
            com.opos.cmn.an.f.a.b("CarouselVerticalViewPager", "onPageSelected position = " + i2);
            if (z) {
                if (i2 == 0 || i2 == a.this.f21993i) {
                    i2 = a.this.f21993i;
                } else if (i2 == 1 || i2 == a.this.f21993i + 1) {
                    i3 = 0;
                    a(i3);
                }
                i3 = i2 - 1;
                a(i3);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.c.a$a */
    static class C0459a extends PagerAdapter {

        /* renamed from: a */
        private ImageView[] f21998a;

        public C0459a(ImageView[] imageViewArr) {
            this.f21998a = imageViewArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            if (i2 >= 0) {
                ImageView[] imageViewArr = this.f21998a;
                if (i2 < imageViewArr.length) {
                    viewGroup.removeView(imageViewArr[i2]);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f21998a.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            if (i2 >= 0) {
                ImageView[] imageViewArr = this.f21998a;
                if (i2 < imageViewArr.length) {
                    ImageView imageView = imageViewArr[i2];
                    viewGroup.addView(imageView);
                    return imageView;
                }
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public a(Context context, int i2, boolean z, int i3) {
        super(context, null);
        this.f21990f = false;
        this.f21991g = 5000;
        this.f21992h = 0;
        this.f21993i = i2;
        this.f21992h = i3;
        this.f21989e = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), new Runnable() { // from class: com.opos.mobad.n.c.a.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f21990f) {
                    a.this.f21985a.setCurrentItem(a.this.f21985a.getCurrentItem() + 1);
                    if (a.this.f21986b != null && a.this.f21992h > 0) {
                        a.this.f21986b.a(a.this.f21992h);
                    }
                }
                a.this.f21989e.a(a.this.f21991g + a.this.f21992h);
            }
        });
        this.f21987c = new TextView[i2];
        this.f21988d = new ImageView[i2 + 2];
        a(i2, z);
    }

    public static a a(Context context, int i2, boolean z) {
        return new a(context, i2, z, 0);
    }

    private void a() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            o oVar = new o(this.f21985a.getContext(), new AccelerateInterpolator());
            this.f21986b = oVar;
            declaredField.set(this.f21985a, oVar);
            this.f21986b.a(this.f21992h);
        } catch (Exception unused) {
            this.f21986b = null;
        }
    }

    private void a(int i2, boolean z) {
        this.f21985a = new n(getContext());
        if (this.f21992h > 0) {
            a();
        }
        addView(this.f21985a, new FrameLayout.LayoutParams(-1, -1));
        for (int i3 = 0; i3 < i2 + 2; i3++) {
            this.f21988d[i3] = new ImageView(getContext());
            this.f21988d[i3].setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (z) {
            b(i2);
        }
        this.f21985a.setAdapter(new C0459a(this.f21988d));
        this.f21985a.setCurrentItem(1, false);
        this.f21985a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.opos.mobad.n.c.a.2

            /* renamed from: a */
            int f21995a = 0;

            /* renamed from: b */
            final /* synthetic */ boolean f21996b;

            AnonymousClass2(boolean z2) {
                z = z2;
            }

            private void a(int i22) {
                int i32 = 0;
                while (i32 < a.this.f21987c.length) {
                    if (a.this.f21987c[i32] != null) {
                        a.this.f21987c[i32].setSelected(i32 == i22);
                    }
                    i32++;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
                n nVar;
                com.opos.cmn.an.f.a.b("CarouselVerticalViewPager", "onPageScrollStateChanged " + i22);
                int i32 = 1;
                if (i22 == 1 || i22 == 2) {
                    a.this.f21990f = true;
                    return;
                }
                if (i22 == 0) {
                    int i4 = this.f21995a;
                    if (i4 != 0) {
                        if (i4 == a.this.f21993i + 1) {
                            nVar = a.this.f21985a;
                        }
                        a.this.f21990f = false;
                    }
                    nVar = a.this.f21985a;
                    i32 = a.this.f21993i;
                    nVar.setCurrentItem(i32, false);
                    a.this.f21990f = false;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f2, int i32) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
                int i32;
                this.f21995a = i22;
                com.opos.cmn.an.f.a.b("CarouselVerticalViewPager", "onPageSelected position = " + i22);
                if (z) {
                    if (i22 == 0 || i22 == a.this.f21993i) {
                        i22 = a.this.f21993i;
                    } else if (i22 == 1 || i22 == a.this.f21993i + 1) {
                        i32 = 0;
                        a(i32);
                    }
                    i32 = i22 - 1;
                    a(i32);
                }
            }
        });
    }

    public static a b(Context context, int i2, boolean z) {
        return new a(context, i2, z, 300);
    }

    private void b(int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        for (int i3 = 0; i3 < i2; i3++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a3, a3);
            this.f21987c[i3] = new TextView(getContext());
            this.f21987c[i3].setBackground(getResources().getDrawable(R.drawable.opos_mobad_drawable_view_pager_selector));
            this.f21987c[i3].setSelected(true);
            if (i3 == 0) {
                this.f21987c[i3].setSelected(true);
            } else {
                layoutParams.topMargin = a2;
                this.f21987c[i3].setSelected(false);
            }
            linearLayout.addView(this.f21987c[i3], layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        layoutParams2.gravity = 21;
        addView(linearLayout, layoutParams2);
    }

    public void a(int i2) {
        this.f21991g = i2;
        this.f21989e.a(i2);
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        for (ImageView imageView : this.f21988d) {
            imageView.setOnClickListener(gVar);
            imageView.setOnTouchListener(gVar);
        }
    }

    public void a(List<Bitmap> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        int i2 = this.f21993i;
        if (size > i2) {
            list = list.subList(0, i2);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Bitmap bitmap = list.get(i3);
            if (bitmap != null) {
                if (i3 == 0 && this.f21988d[this.f21993i + 1].getDrawable() == null) {
                    this.f21988d[this.f21993i + 1].setImageBitmap(bitmap);
                }
                if (i3 == this.f21993i && this.f21988d[0].getDrawable() == null) {
                    this.f21988d[0].setImageBitmap(bitmap);
                }
                int i4 = i3 + 1;
                if (this.f21988d[i4].getDrawable() == null) {
                    this.f21988d[i4].setImageBitmap(bitmap);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21989e.a();
    }
}
