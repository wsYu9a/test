package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class b extends RelativeLayout {

    /* renamed from: a */
    private c f22811a;

    /* renamed from: b */
    private com.opos.mobad.n.c.f f22812b;

    /* renamed from: c */
    private RelativeLayout f22813c;

    /* renamed from: d */
    private LinearLayout f22814d;

    /* renamed from: e */
    private TextView f22815e;

    /* renamed from: f */
    private TextView f22816f;

    /* renamed from: g */
    private j f22817g;

    /* renamed from: h */
    private boolean f22818h;

    /* renamed from: i */
    private boolean f22819i;

    /* renamed from: j */
    private a.InterfaceC0458a f22820j;

    /* renamed from: com.opos.mobad.n.h.b$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f22818h || b.this.f22820j == null) {
                return;
            }
            b.this.f22820j.g(view, iArr);
        }
    }

    /* renamed from: com.opos.mobad.n.h.b$2 */
    class AnonymousClass2 implements a.InterfaceC0426a {

        /* renamed from: com.opos.mobad.n.h.b$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22823a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (b.this.f22818h || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                b.this.f22812b.setImageBitmap(bitmap);
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (b.this.f22818h) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (b.this.f22820j != null) {
                    b.this.f22820j.c(i2);
                }
            } else {
                if (i2 == 1 && b.this.f22820j != null) {
                    b.this.f22820j.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.h.b.2.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22823a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.f22818h || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        b.this.f22812b.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public b(Context context) {
        super(context);
        this.f22818h = false;
        this.f22819i = false;
        b(context);
    }

    public static b a(Context context) {
        return new b(context);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar) {
        this.f22812b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("RewardBottomAreaView", "iconUrl is null");
        } else {
            if (this.f22819i) {
                return;
            }
            this.f22819i = true;
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 44.0f);
            aVar.a(gVar.f22084a, gVar.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.h.b.2

                /* renamed from: com.opos.mobad.n.h.b$2$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22823a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.f22818h || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        b.this.f22812b.setImageBitmap(bitmap);
                    }
                }

                AnonymousClass2() {
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap2) {
                    if (b.this.f22818h) {
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (b.this.f22820j != null) {
                            b.this.f22820j.c(i2);
                        }
                    } else {
                        if (i2 == 1 && b.this.f22820j != null) {
                            b.this.f22820j.c(i2);
                        }
                        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.h.b.2.1

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22823a;

                            AnonymousClass1(Bitmap bitmap22) {
                                bitmap = bitmap22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap22;
                                if (b.this.f22818h || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                    return;
                                }
                                b.this.f22812b.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22814d = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f22815e = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.f22815e.setTextSize(1, 14.0f);
        this.f22815e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22815e.setSingleLine(true);
        TextPaint paint = this.f22815e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        TextView textView2 = new TextView(getContext());
        this.f22816f = textView2;
        textView2.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f22816f.setTextSize(1, 10.0f);
        this.f22816f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22816f.setSingleLine(true);
        this.f22816f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.f22817g = j.a(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(5);
        this.f22817g.setGravity(3);
        this.f22817g.setVisibility(8);
        relativeLayout.addView(this.f22816f, layoutParams3);
        relativeLayout.addView(this.f22817g, layoutParams4);
        this.f22814d.addView(this.f22815e, layoutParams);
        this.f22814d.addView(relativeLayout, layoutParams2);
    }

    private void b(Context context) {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_bottom_bg);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        setPadding(a2, a2, a2, a2);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f22813c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.f22813c.setPadding(a3, a3, a3, a3);
        this.f22813c.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 44.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
        layoutParams.addRule(15);
        this.f22813c.setVisibility(0);
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        this.f22812b = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        c a4 = c.a(context, "");
        this.f22811a = a4;
        a4.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        b();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.f22813c.getId());
        layoutParams4.addRule(0, this.f22811a.getId());
        this.f22813c.addView(this.f22812b, layoutParams2);
        addView(this.f22813c, layoutParams);
        addView(this.f22811a, layoutParams3);
        addView(this.f22814d, layoutParams4);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.b.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f22818h || b.this.f22820j == null) {
                    return;
                }
                b.this.f22820j.g(view, iArr);
            }
        };
        setOnClickListener(anonymousClass1);
        setOnTouchListener(anonymousClass1);
    }

    public void a() {
        this.f22818h = true;
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("RewardBottomAreaView", "setListener " + interfaceC0458a);
        this.f22820j = interfaceC0458a;
        this.f22811a.a(interfaceC0458a);
        this.f22817g.a(interfaceC0458a);
    }

    public void a(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a) || TextUtils.isEmpty(aVar.f22066b)) {
            this.f22816f.setVisibility(0);
            return;
        }
        j jVar = this.f22817g;
        if (jVar != null) {
            jVar.setVisibility(0);
            this.f22817g.a(aVar.f22065a, aVar.f22066b);
        }
    }

    public void a(com.opos.mobad.n.d.g gVar, String str, String str2, String str3, com.opos.mobad.c.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f22811a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f22815e.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f22816f.setText(str3);
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a)) {
            this.f22813c.setVisibility(0);
            a(gVar, aVar);
            return;
        }
        this.f22813c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22814d.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.width = -1;
        this.f22814d.setLayoutParams(layoutParams);
    }
}
