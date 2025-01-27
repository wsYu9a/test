package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends RelativeLayout implements com.opos.mobad.n.a {

    /* renamed from: a */
    private com.opos.mobad.n.c.f f22837a;

    /* renamed from: b */
    private TextView f22838b;

    /* renamed from: c */
    private TextView f22839c;

    /* renamed from: d */
    private j f22840d;

    /* renamed from: e */
    private e f22841e;

    /* renamed from: f */
    private LinearLayout f22842f;

    /* renamed from: g */
    private com.opos.mobad.c.a f22843g;

    /* renamed from: h */
    private boolean f22844h;

    /* renamed from: i */
    private int f22845i;

    /* renamed from: j */
    private boolean f22846j;
    private a.InterfaceC0458a k;

    /* renamed from: com.opos.mobad.n.h.f$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (f.this.k != null) {
                f.this.k.j(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.f$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (f.this.k != null) {
                f.this.k.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.f$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: com.opos.mobad.n.h.f$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22850a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (f.this.f22844h || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                f.this.f22837a.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (f.this.f22844h) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (f.this.k != null) {
                    f.this.k.c(i2);
                }
            } else {
                if (i2 == 1 && f.this.k != null) {
                    f.this.k.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.h.f.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22850a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (f.this.f22844h || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        f.this.f22837a.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public f(Context context, boolean z, com.opos.mobad.c.a aVar, int i2) {
        super(context);
        this.f22844h = false;
        this.f22846j = false;
        a(com.opos.mobad.c.b.a.a(getContext()) ? true : z);
        this.f22843g = aVar;
        this.f22845i = i2;
    }

    public static f a(Context context, com.opos.mobad.c.a aVar, int i2) {
        return new f(context, true, aVar, i2);
    }

    private void a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.f22842f = linearLayout2;
        linearLayout2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f22842f, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        Context context;
        float f2;
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams.addRule(11);
        if (z) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 53.0f);
            context = getContext();
            f2 = 28.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
            context = getContext();
            f2 = 54.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f2);
        relativeLayout.addView(imageView, layoutParams);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.f.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (f.this.k != null) {
                    f.this.k.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(anonymousClass2);
        imageView.setOnClickListener(anonymousClass2);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        j jVar;
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a) || TextUtils.isEmpty(aVar.f22066b) || (jVar = this.f22840d) == null) {
            return;
        }
        jVar.setVisibility(0);
        this.f22840d.a(aVar.f22065a, aVar.f22066b);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar) {
        this.f22837a.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("RewardEndPage", "iconUrl is null");
        } else {
            if (this.f22846j) {
                return;
            }
            this.f22846j = true;
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 60.0f);
            aVar.a(gVar.f22084a, gVar.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.h.f.3

                /* renamed from: com.opos.mobad.n.h.f$3$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22850a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (f.this.f22844h || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        f.this.f22837a.setImageBitmap(bitmap);
                    }
                }

                AnonymousClass3() {
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap2) {
                    if (f.this.f22844h) {
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (f.this.k != null) {
                            f.this.k.c(i2);
                        }
                    } else {
                        if (i2 == 1 && f.this.k != null) {
                            f.this.k.c(i2);
                        }
                        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.h.f.3.1

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22850a;

                            AnonymousClass1(Bitmap bitmap22) {
                                bitmap = bitmap22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap22;
                                if (f.this.f22844h || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                    return;
                                }
                                f.this.f22837a.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    private void a(com.opos.mobad.n.d.g gVar, String str, String str2, String str3, com.opos.mobad.c.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f22841e.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f22838b.setVisibility(0);
            this.f22838b.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f22839c.setVisibility(0);
            this.f22839c.setText(str3);
        }
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            this.f22837a.setVisibility(0);
            this.f22837a.setVisibility(8);
        } else {
            this.f22837a.setVisibility(0);
            a(gVar, aVar);
        }
    }

    private void a(String str, int i2) {
        if (TextUtils.isEmpty(str) || i2 >= 3) {
            return;
        }
        if (this.f22842f.getVisibility() != 0) {
            this.f22842f.setVisibility(0);
        }
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#8CFFFFFF"));
        textView.setTextSize(1, 10.0f);
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        textView.setText(str);
        textView.setPadding(a3, 0, a3, 0);
        textView.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_label_bg);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2);
        if (i2 > 0) {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        }
        this.f22842f.addView(textView, layoutParams);
    }

    private void a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(list.get(i2), i2);
        }
    }

    private void a(boolean z) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.f.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (f.this.k != null) {
                    f.this.k.j(view, iArr);
                }
            }
        };
        relativeLayout.setOnClickListener(anonymousClass1);
        relativeLayout.setOnTouchListener(anonymousClass1);
        b(linearLayout);
        c(linearLayout);
        a(linearLayout);
        d(linearLayout);
        a(relativeLayout, z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 360.0f), -2);
        layoutParams.addRule(13);
        relativeLayout.addView(linearLayout, layoutParams);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void b(LinearLayout linearLayout) {
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        this.f22837a = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f22837a.setVisibility(8);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 60.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f22837a, layoutParams);
    }

    private void c(LinearLayout linearLayout) {
        TextView textView = new TextView(getContext());
        this.f22838b = textView;
        textView.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.f22838b.setTextSize(1, 14.0f);
        this.f22838b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22838b.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.f22838b.setVisibility(8);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f22838b, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f22839c = textView2;
        textView2.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f22839c.setTextSize(1, 10.0f);
        this.f22839c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22839c.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        this.f22839c.setVisibility(8);
        layoutParams2.gravity = 1;
        linearLayout.addView(this.f22839c, layoutParams2);
        this.f22840d = j.a(getContext());
        new RelativeLayout.LayoutParams(-1, -2).addRule(5);
        this.f22840d.setGravity(3);
        this.f22840d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams3.gravity = 1;
        linearLayout.addView(this.f22840d, layoutParams3);
    }

    private void d(LinearLayout linearLayout) {
        this.f22841e = e.a(getContext(), "");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f22841e, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.k = interfaceC0458a;
        this.f22841e.a(interfaceC0458a);
        this.f22840d.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("RewardEndPage", "data is null");
            interfaceC0458a = this.k;
            if (interfaceC0458a == null) {
                return;
            }
        } else {
            com.opos.mobad.n.d.f e2 = hVar.e();
            if (e2 != null) {
                a(e2.f22080a, e2.f22083d, e2.f22081b, e2.f22082c, this.f22843g);
                a(e2);
                a(e2.n);
                return;
            } else {
                com.opos.cmn.an.f.a.d("", "render with data null");
                interfaceC0458a = this.k;
                if (interfaceC0458a == null) {
                    return;
                }
            }
        }
        interfaceC0458a.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.f22844h = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22845i;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: f */
    public RelativeLayout c() {
        return this;
    }
}
