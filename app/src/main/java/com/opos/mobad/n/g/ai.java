package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class ai implements com.opos.mobad.n.a {

    /* renamed from: a */
    private com.opos.mobad.n.c.j f22434a;

    /* renamed from: b */
    private RelativeLayout f22435b;

    /* renamed from: c */
    private RelativeLayout f22436c;

    /* renamed from: d */
    private TextView f22437d;

    /* renamed from: e */
    private TextView f22438e;

    /* renamed from: f */
    private com.opos.mobad.c.d.a f22439f;

    /* renamed from: g */
    private final int f22440g;

    /* renamed from: h */
    private final int f22441h;

    /* renamed from: i */
    private Context f22442i;

    /* renamed from: j */
    private a.InterfaceC0458a f22443j;
    private com.opos.mobad.n.d.d l;
    private volatile int m = 0;
    private com.opos.mobad.n.c.g n = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ai.5
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ai.this.f22443j != null) {
                ai.this.f22443j.g(view, iArr);
            }
        }
    };
    private Handler k = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.g.ai$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ai.this.f22443j != null) {
                ai.this.f22443j.f(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.ai$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ai.this.f22443j != null) {
                ai.this.f22443j.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.ai$3 */
    class AnonymousClass3 implements a.InterfaceC0428a {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (ai.this.m == 4) {
                com.opos.cmn.an.f.a.b("NativeTemplateView", "has destroy");
                return;
            }
            com.opos.cmn.an.f.a.b("NativeTemplateView", "is view visible =" + z);
            if (!z) {
                ai.this.m = 2;
            } else if (ai.this.m == 0) {
                ai.this.m = 1;
                if (ai.this.l != null) {
                    ai.this.g();
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.ai$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.g f22447a;

        /* renamed from: b */
        final /* synthetic */ int f22448b;

        /* renamed from: c */
        final /* synthetic */ int f22449c;

        /* renamed from: d */
        final /* synthetic */ ImageView f22450d;

        /* renamed from: com.opos.mobad.n.g.ai$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22452a;

            AnonymousClass1(Bitmap bitmap) {
                a2 = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (ai.this.m == 4 || (bitmap = a2) == null || bitmap.isRecycled()) {
                    return;
                }
                imageView.setImageBitmap(a2);
            }
        }

        AnonymousClass4(com.opos.mobad.n.d.g gVar, int i2, int i3, ImageView imageView) {
            gVar = gVar;
            i2 = i2;
            i3 = i3;
            imageView = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                if (ai.this.m == 4) {
                    return;
                }
                if (new File(gVar.f22084a).exists()) {
                    Bitmap a2 = com.opos.cmn.an.d.c.a.a(gVar.f22084a, i2, i3);
                    if (a2 != null && !a2.isRecycled()) {
                        ai.this.k.post(new Runnable() { // from class: com.opos.mobad.n.g.ai.4.1

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22452a;

                            AnonymousClass1(Bitmap a22) {
                                a2 = a22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap;
                                if (ai.this.m == 4 || (bitmap = a2) == null || bitmap.isRecycled()) {
                                    return;
                                }
                                imageView.setImageBitmap(a2);
                            }
                        });
                        return;
                    }
                    str = "null bitmap or error state" + ai.this.m;
                } else {
                    str = "icon not exit";
                }
                com.opos.cmn.an.f.a.b("NativeTemplateView", str);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("NativeTemplateView", "load img fail", th);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.ai$5 */
    class AnonymousClass5 extends com.opos.mobad.n.c.g {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ai.this.f22443j != null) {
                ai.this.f22443j.g(view, iArr);
            }
        }
    }

    public ai(Context context, aj ajVar, int i2, int i3, float f2) {
        this.f22440g = i3;
        this.f22442i = context;
        this.f22441h = i2;
        a(ajVar, f2);
        f();
    }

    public static com.opos.mobad.n.a a(Context context, aj ajVar, int i2) {
        return new ai(context, ajVar, i2, 0, 1.2260536f);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(this.n);
        view.setOnTouchListener(this.n);
    }

    private void a(RelativeLayout relativeLayout, com.opos.mobad.n.d.d dVar) {
        ImageView fVar = new com.opos.mobad.n.c.f(this.f22442i, com.opos.cmn.an.h.f.a.a(r1, 6.0f));
        fVar.setId(View.generateViewId());
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        a(fVar);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22442i, 324.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f22442i, 182.25f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams.addRule(12);
        relativeLayout.addView(fVar, layoutParams);
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list != null && list.size() > 0) {
            a(a2, a3, dVar.f22075g.get(0), fVar);
        }
        TextView textView = new TextView(this.f22442i);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.f22442i, 18.0f));
        textView.setTextColor(-671088640);
        textView.setGravity(19);
        textView.setSingleLine();
        textView.setMaxEms(13);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f22442i, 25.875f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(2, fVar.getId());
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 13.5f);
        relativeLayout.addView(textView, layoutParams2);
        textView.setText(dVar.f22073e);
        a(textView);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        Context context;
        float f2;
        RelativeLayout relativeLayout = new RelativeLayout(this.f22442i);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22442i, 324.0f);
        int i2 = this.f22440g;
        if (i2 == 0) {
            a(relativeLayout, dVar);
            context = this.f22442i;
            f2 = 221.625f;
        } else if (i2 != 2) {
            c(relativeLayout, dVar);
            context = this.f22442i;
            f2 = 77.625f;
        } else {
            b(relativeLayout, dVar);
            context = this.f22442i;
            f2 = 105.75f;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, com.opos.cmn.an.h.f.a.a(context, f2));
        layoutParams.addRule(2, this.f22436c.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 13.5f);
        this.f22435b.addView(relativeLayout, layoutParams);
    }

    private void a(aj ajVar, float f2) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22442i);
        }
        com.opos.mobad.n.c.j jVar = new com.opos.mobad.n.c.j(this.f22442i, new j.a(ajVar.f22455a, ajVar.f22456b, f2));
        this.f22434a = jVar;
        jVar.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f22434a.setForceDarkAllowed(false);
        }
        this.f22435b = new RelativeLayout(this.f22442i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f22442i, 18.0f));
        gradientDrawable.setColor(-1);
        this.f22435b.setBackground(gradientDrawable);
        this.f22435b.setVisibility(4);
        this.f22434a.addView(this.f22435b, new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this.f22442i);
        this.f22436c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        TextView textView = new TextView(this.f22442i);
        this.f22437d = textView;
        textView.setId(View.generateViewId());
        this.f22437d.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.f22442i, 15.75f));
        this.f22437d.setTextColor(-1);
        this.f22437d.setGravity(17);
        this.f22437d.setSingleLine();
        this.f22437d.setEllipsize(TextUtils.TruncateAt.END);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f22442i, 16.0f));
        gradientDrawable2.setColor(Color.parseColor("#28CE43"));
        this.f22437d.setBackground(gradientDrawable2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22442i, 90.0f), com.opos.cmn.an.h.f.a.a(this.f22442i, 31.5f));
        layoutParams.addRule(11);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ai.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ai.this.f22443j != null) {
                    ai.this.f22443j.f(view, iArr);
                }
            }
        };
        this.f22437d.setOnClickListener(anonymousClass1);
        this.f22437d.setOnTouchListener(anonymousClass1);
        this.f22436c.addView(this.f22437d, layoutParams);
        TextView textView2 = new TextView(this.f22442i);
        this.f22438e = textView2;
        textView2.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.f22442i, 13.5f));
        this.f22438e.setTextColor(-1946157056);
        this.f22438e.setGravity(19);
        this.f22438e.setSingleLine();
        this.f22438e.setMaxEms(10);
        this.f22438e.setEllipsize(TextUtils.TruncateAt.END);
        a(this.f22438e);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(15);
        this.f22436c.addView(this.f22438e, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22442i, 324.0f), com.opos.cmn.an.h.f.a.a(this.f22442i, 31.5f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 13.5f);
        this.f22435b.addView(this.f22436c, layoutParams3);
        TextView textView3 = new TextView(this.f22442i);
        textView3.setBackground(this.f22442i.getResources().getDrawable(R.drawable.opos_mobad_close_bn));
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22442i, 14.32f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 19.845f);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 19.74f);
        layoutParams4.addRule(11);
        this.f22435b.addView(textView3, layoutParams4);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ai.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ai.this.f22443j != null) {
                    ai.this.f22443j.d(view, iArr);
                }
            }
        };
        textView3.setOnClickListener(anonymousClass2);
        textView3.setOnTouchListener(anonymousClass2);
    }

    public static com.opos.mobad.n.a b(Context context, aj ajVar, int i2) {
        return new ai(context, ajVar, i2, 2, 2.0253165f);
    }

    private void b(RelativeLayout relativeLayout, com.opos.mobad.n.d.d dVar) {
        LinearLayout linearLayout = new LinearLayout(this.f22442i);
        linearLayout.setId(View.generateViewId());
        a(linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        ImageView fVar = new com.opos.mobad.n.c.f(this.f22442i, com.opos.cmn.an.h.f.a.a(r6, 6.0f));
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(fVar, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 6.75f);
        ImageView fVar2 = new com.opos.mobad.n.c.f(this.f22442i, com.opos.cmn.an.h.f.a.a(r4, 6.0f));
        fVar2.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(fVar2, layoutParams2);
        ImageView fVar3 = new com.opos.mobad.n.c.f(this.f22442i, com.opos.cmn.an.h.f.a.a(r6, 6.0f));
        fVar3.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(fVar3, layoutParams2);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22442i, 103.5f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f22442i, 66.375f);
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list != null && list.size() >= 3) {
            a(a2, a3, dVar.f22075g.get(0), fVar);
            a(a2, a3, dVar.f22075g.get(1), fVar2);
            a(a2, a3, dVar.f22075g.get(2), fVar3);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22442i, 324.0f), com.opos.cmn.an.h.f.a.a(this.f22442i, 66.375f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        relativeLayout.addView(linearLayout, layoutParams3);
        TextView textView = new TextView(this.f22442i);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.f22442i, 18.0f));
        textView.setTextColor(-671088640);
        textView.setMaxEms(13);
        textView.setGravity(19);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f22442i, 23.0f));
        layoutParams4.addRule(9);
        layoutParams4.addRule(2, linearLayout.getId());
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 13.5f);
        relativeLayout.addView(textView, layoutParams4);
        textView.setText(dVar.f22073e);
        a(textView);
    }

    public static com.opos.mobad.n.a c(Context context, aj ajVar, int i2) {
        return new ai(context, ajVar, i2, 1, 2.3357663f);
    }

    private void c(RelativeLayout relativeLayout, com.opos.mobad.n.d.d dVar) {
        ImageView fVar = new com.opos.mobad.n.c.f(this.f22442i, com.opos.cmn.an.h.f.a.a(r1, 6.0f));
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        fVar.setId(View.generateViewId());
        a(fVar);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22442i, 119.25f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f22442i, 77.625f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams.addRule(9);
        relativeLayout.addView(fVar, layoutParams);
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list != null && list.size() > 0) {
            a(a2, a3, dVar.f22075g.get(0), fVar);
        }
        FrameLayout frameLayout = new FrameLayout(this.f22442i);
        TextView textView = new TextView(this.f22442i);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(this.f22442i, 18.0f));
        textView.setTextColor(-671088640);
        textView.setGravity(51);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(3);
        textView.setLineSpacing(com.opos.cmn.an.h.f.a.a(this.f22442i, 3.5f), 1.0f);
        textView.setText(dVar.f22073e);
        a(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 51;
        frameLayout.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22442i, 168.75f), com.opos.cmn.an.h.f.a.a(this.f22442i, 77.625f));
        layoutParams3.addRule(1, fVar.getId());
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 11.25f);
        relativeLayout.addView(frameLayout, layoutParams3);
    }

    private void f() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22442i);
        this.f22439f = aVar;
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.ai.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (ai.this.m == 4) {
                    com.opos.cmn.an.f.a.b("NativeTemplateView", "has destroy");
                    return;
                }
                com.opos.cmn.an.f.a.b("NativeTemplateView", "is view visible =" + z);
                if (!z) {
                    ai.this.m = 2;
                } else if (ai.this.m == 0) {
                    ai.this.m = 1;
                    if (ai.this.l != null) {
                        ai.this.g();
                    }
                }
            }
        });
        this.f22435b.addView(this.f22439f, new RelativeLayout.LayoutParams(0, 0));
    }

    public void g() {
        if (this.m == 1) {
            this.m = 3;
            com.opos.cmn.an.f.a.b("NativeTemplateView", "NT onWindowVisibility");
            a.InterfaceC0458a interfaceC0458a = this.f22443j;
            if (interfaceC0458a != null) {
                interfaceC0458a.b();
            }
            this.f22439f.a((a.InterfaceC0428a) null);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    public void a(int i2, int i3, com.opos.mobad.n.d.g gVar, ImageView imageView) {
        String str;
        if (imageView == null) {
            str = "null imageView";
        } else {
            if (gVar != null) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.g.ai.4

                    /* renamed from: a */
                    final /* synthetic */ com.opos.mobad.n.d.g f22447a;

                    /* renamed from: b */
                    final /* synthetic */ int f22448b;

                    /* renamed from: c */
                    final /* synthetic */ int f22449c;

                    /* renamed from: d */
                    final /* synthetic */ ImageView f22450d;

                    /* renamed from: com.opos.mobad.n.g.ai$4$1 */
                    class AnonymousClass1 implements Runnable {

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22452a;

                        AnonymousClass1(Bitmap a22) {
                            a2 = a22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap;
                            if (ai.this.m == 4 || (bitmap = a2) == null || bitmap.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(a2);
                        }
                    }

                    AnonymousClass4(com.opos.mobad.n.d.g gVar2, int i22, int i32, ImageView imageView2) {
                        gVar = gVar2;
                        i2 = i22;
                        i3 = i32;
                        imageView = imageView2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        try {
                            if (ai.this.m == 4) {
                                return;
                            }
                            if (new File(gVar.f22084a).exists()) {
                                Bitmap a22 = com.opos.cmn.an.d.c.a.a(gVar.f22084a, i2, i3);
                                if (a22 != null && !a22.isRecycled()) {
                                    ai.this.k.post(new Runnable() { // from class: com.opos.mobad.n.g.ai.4.1

                                        /* renamed from: a */
                                        final /* synthetic */ Bitmap f22452a;

                                        AnonymousClass1(Bitmap a222) {
                                            a2 = a222;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Bitmap bitmap;
                                            if (ai.this.m == 4 || (bitmap = a2) == null || bitmap.isRecycled()) {
                                                return;
                                            }
                                            imageView.setImageBitmap(a2);
                                        }
                                    });
                                    return;
                                }
                                str2 = "null bitmap or error state" + ai.this.m;
                            } else {
                                str2 = "icon not exit";
                            }
                            com.opos.cmn.an.f.a.b("NativeTemplateView", str2);
                        } catch (Throwable th) {
                            com.opos.cmn.an.f.a.b("NativeTemplateView", "load img fail", th);
                        }
                    }
                });
                return;
            }
            str = "null file";
        }
        com.opos.cmn.an.f.a.b("NativeTemplateView", str);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22443j = interfaceC0458a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        List<com.opos.mobad.n.d.g> list;
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null || (list = a2.f22075g) == null || list.size() <= 0) {
            this.f22443j.b(1);
            return;
        }
        if (this.m != 4) {
            if (this.l == null) {
                this.f22443j.e();
            }
            this.l = a2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22442i, 46.62f), com.opos.cmn.an.h.f.a.a(this.f22442i, 18.0f));
            layoutParams.addRule(15);
            View a3 = com.opos.mobad.n.e.a(a2, this.f22436c, layoutParams);
            a3.setId(View.generateViewId());
            a(a3);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f22438e.getLayoutParams();
            layoutParams2.addRule(1, a3.getId());
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22442i, 8.75f);
            this.f22437d.setText(a2.l);
            this.f22438e.setText(a2.f22074f);
            a(a2);
            this.f22434a.setVisibility(0);
            this.f22435b.setVisibility(0);
            g();
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22434a;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.f22434a.removeAllViews();
        this.f22434a.setVisibility(8);
        this.m = 4;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22441h;
    }
}
