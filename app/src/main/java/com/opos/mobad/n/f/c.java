package com.opos.mobad.n.f;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class c extends RelativeLayout {

    /* renamed from: a */
    k f22179a;

    /* renamed from: b */
    ImageView f22180b;

    /* renamed from: c */
    private int f22181c;

    /* renamed from: d */
    private a.InterfaceC0458a f22182d;

    /* renamed from: com.opos.mobad.n.f.c$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (c.this.f22182d != null) {
                c.this.f22182d.j(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.c$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (c.this.f22182d != null) {
                c.this.f22182d.k(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.c$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ObjectAnimator f22185a;

        AnonymousClass3(ObjectAnimator objectAnimator) {
            ofFloat = objectAnimator;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.setVisibility(0);
            ofFloat.start();
        }
    }

    public c(Context context, int i2) {
        super(context);
        setVisibility(4);
        setBackgroundColor(0);
        this.f22181c = i2;
        a();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.c.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (c.this.f22182d != null) {
                    c.this.f22182d.j(view, iArr);
                }
            }
        };
        setOnClickListener(anonymousClass1);
        setOnTouchListener(anonymousClass1);
    }

    public static c a(Context context) {
        return new c(context, 2);
    }

    private void a() {
        ImageView imageView = new ImageView(getContext());
        this.f22180b = imageView;
        imageView.setId(View.generateViewId());
        this.f22180b.setScaleType(ImageView.ScaleType.FIT_XY);
        b();
        c();
    }

    public static c b(Context context) {
        return new c(context, 3);
    }

    private void b() {
        int i2 = this.f22181c;
        this.f22179a = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? k.f(getContext(), 64, 18, 14, -1275068416) : k.b(getContext(), 64, 18, 14, -1) : k.b(getContext(), 64, 18, 14, -1275068416) : k.d(getContext(), 67, 24, 14, -1) : k.d(getContext(), 64, 18, 14, -1275068416);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.c.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (c.this.f22182d != null) {
                    c.this.f22182d.k(view, iArr);
                }
            }
        };
        this.f22179a.c().setOnClickListener(anonymousClass2);
        this.f22179a.c().setOnTouchListener(anonymousClass2);
    }

    public static c c(Context context) {
        return new c(context, 0);
    }

    private void c() {
        int i2 = this.f22181c;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4 && i2 != 5) {
                            return;
                        }
                    }
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 155.0f));
            layoutParams.addRule(10);
            addView(this.f22180b, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, this.f22180b.getId());
            addView(this.f22179a, layoutParams2);
            return;
        }
        addView(this.f22180b, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f22179a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public static c d(Context context) {
        return new c(context, 1);
    }

    private void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(180L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.c.3

            /* renamed from: a */
            final /* synthetic */ ObjectAnimator f22185a;

            AnonymousClass3(ObjectAnimator ofFloat2) {
                ofFloat = ofFloat2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.setVisibility(0);
                ofFloat.start();
            }
        });
    }

    public static c e(Context context) {
        return new c(context, 4);
    }

    public static c f(Context context) {
        return new c(context, 5);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f22179a.a(bitmap);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22182d = interfaceC0458a;
    }

    public void a(String str, String str2, String str3) {
        this.f22179a.a(str, str2, str3, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }
}
