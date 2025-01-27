package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.msp.mobad.api.R;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends FrameLayout {

    /* renamed from: a */
    private ViewPager f21999a;

    /* renamed from: b */
    private TextView[] f22000b;

    /* renamed from: c */
    private ImageView[] f22001c;

    /* renamed from: d */
    private com.opos.mobad.c.b.c f22002d;

    /* renamed from: e */
    private boolean f22003e;

    /* renamed from: f */
    private int f22004f;

    /* renamed from: g */
    private final int f22005g;

    /* renamed from: com.opos.mobad.n.c.b$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.f22003e) {
                b.this.f21999a.setCurrentItem(b.this.f21999a.getCurrentItem() + 1);
            }
            b.this.f22002d.a(b.this.f22004f);
        }
    }

    /* renamed from: com.opos.mobad.n.c.b$2 */
    class AnonymousClass2 implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        int f22007a = 0;

        AnonymousClass2() {
        }

        private void a(int i2) {
            int i3 = 0;
            while (i3 < b.this.f22000b.length) {
                b.this.f22000b[i3].setSelected(i3 == i2);
                i3++;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            ViewPager viewPager;
            com.opos.cmn.an.f.a.b("viewPager", "onPageScrollStateChanged " + i2);
            int i3 = 1;
            if (i2 == 1 || i2 == 2) {
                b.this.f22003e = true;
                return;
            }
            if (i2 == 0) {
                int i4 = this.f22007a;
                if (i4 != 0) {
                    if (i4 == b.this.f22005g + 1) {
                        viewPager = b.this.f21999a;
                    }
                    b.this.f22003e = false;
                }
                viewPager = b.this.f21999a;
                i3 = b.this.f22005g;
                viewPager.setCurrentItem(i3, false);
                b.this.f22003e = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            int i3;
            this.f22007a = i2;
            com.opos.cmn.an.f.a.b("viewPager", "onPageSelected position = " + i2);
            if (i2 == 0 || i2 == b.this.f22005g) {
                i2 = b.this.f22005g;
            } else if (i2 == 1 || i2 == b.this.f22005g + 1) {
                i3 = 0;
                a(i3);
            }
            i3 = i2 - 1;
            a(i3);
        }
    }

    static class a extends PagerAdapter {

        /* renamed from: a */
        private ImageView[] f22009a;

        public a(ImageView[] imageViewArr) {
            this.f22009a = imageViewArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            if (i2 >= 0) {
                ImageView[] imageViewArr = this.f22009a;
                if (i2 < imageViewArr.length) {
                    viewGroup.removeView(imageViewArr[i2]);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f22009a.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            if (i2 >= 0) {
                ImageView[] imageViewArr = this.f22009a;
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

    public b(Context context, int i2) {
        super(context, null);
        this.f22003e = false;
        this.f22004f = 3000;
        this.f22005g = i2;
        this.f22002d = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), new Runnable() { // from class: com.opos.mobad.n.c.b.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.f22003e) {
                    b.this.f21999a.setCurrentItem(b.this.f21999a.getCurrentItem() + 1);
                }
                b.this.f22002d.a(b.this.f22004f);
            }
        });
        this.f22000b = new TextView[i2];
        this.f22001c = new ImageView[i2 + 2];
        b(i2);
    }

    private void b(int i2) {
        ViewPager viewPager = new ViewPager(getContext());
        this.f21999a = viewPager;
        addView(viewPager, new FrameLayout.LayoutParams(-1, -1));
        for (int i3 = 0; i3 < i2 + 2; i3++) {
            this.f22001c[i3] = new ImageView(getContext());
            this.f22001c[i3].setScaleType(ImageView.ScaleType.FIT_XY);
        }
        c(i2);
        this.f21999a.setAdapter(new a(this.f22001c));
        this.f21999a.setCurrentItem(1, false);
        this.f21999a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.opos.mobad.n.c.b.2

            /* renamed from: a */
            int f22007a = 0;

            AnonymousClass2() {
            }

            private void a(int i22) {
                int i32 = 0;
                while (i32 < b.this.f22000b.length) {
                    b.this.f22000b[i32].setSelected(i32 == i22);
                    i32++;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
                ViewPager viewPager2;
                com.opos.cmn.an.f.a.b("viewPager", "onPageScrollStateChanged " + i22);
                int i32 = 1;
                if (i22 == 1 || i22 == 2) {
                    b.this.f22003e = true;
                    return;
                }
                if (i22 == 0) {
                    int i4 = this.f22007a;
                    if (i4 != 0) {
                        if (i4 == b.this.f22005g + 1) {
                            viewPager2 = b.this.f21999a;
                        }
                        b.this.f22003e = false;
                    }
                    viewPager2 = b.this.f21999a;
                    i32 = b.this.f22005g;
                    viewPager2.setCurrentItem(i32, false);
                    b.this.f22003e = false;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f2, int i32) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
                int i32;
                this.f22007a = i22;
                com.opos.cmn.an.f.a.b("viewPager", "onPageSelected position = " + i22);
                if (i22 == 0 || i22 == b.this.f22005g) {
                    i22 = b.this.f22005g;
                } else if (i22 == 1 || i22 == b.this.f22005g + 1) {
                    i32 = 0;
                    a(i32);
                }
                i32 = i22 - 1;
                a(i32);
            }
        });
    }

    private void c(int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 1.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int a4 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        for (int i3 = 0; i3 < i2; i3++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a4, a4);
            this.f22000b[i3] = new TextView(getContext());
            this.f22000b[i3].setBackground(getResources().getDrawable(R.drawable.opos_mobad_drawable_view_pager_selector));
            this.f22000b[i3].setSelected(true);
            if (i3 == 0) {
                layoutParams.leftMargin = a2;
                this.f22000b[i3].setSelected(true);
            } else {
                layoutParams.leftMargin = a3;
                this.f22000b[i3].setSelected(false);
            }
            if (i3 == i2 - 1) {
                layoutParams.rightMargin = a2;
            }
            linearLayout.addView(this.f22000b[i3], layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 32.0f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 13.0f);
        layoutParams2.gravity = 81;
        addView(linearLayout, layoutParams2);
    }

    public void a(int i2) {
        this.f22004f = i2;
        this.f22002d.a(i2);
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        for (ImageView imageView : this.f22001c) {
            imageView.setOnClickListener(gVar);
            imageView.setOnTouchListener(gVar);
        }
    }

    public void a(List<Bitmap> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        int i2 = this.f22005g;
        if (size > i2) {
            list = list.subList(0, i2);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Bitmap bitmap = list.get(i3);
            if (bitmap != null) {
                if (i3 == 0 && this.f22001c[this.f22005g + 1].getDrawable() == null) {
                    this.f22001c[this.f22005g + 1].setImageBitmap(bitmap);
                }
                if (i3 == this.f22005g && this.f22001c[0].getDrawable() == null) {
                    this.f22001c[0].setImageBitmap(bitmap);
                }
                int i4 = i3 + 1;
                if (this.f22001c[i4].getDrawable() == null) {
                    this.f22001c[i4].setImageBitmap(bitmap);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f22002d.a();
    }
}
