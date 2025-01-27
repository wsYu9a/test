package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class t extends RelativeLayout {

    /* renamed from: a */
    private v f22757a;

    /* renamed from: b */
    private com.opos.mobad.n.c.f f22758b;

    /* renamed from: c */
    private RelativeLayout f22759c;

    /* renamed from: d */
    private LinearLayout f22760d;

    /* renamed from: e */
    private TextView f22761e;

    /* renamed from: f */
    private TextView f22762f;

    /* renamed from: g */
    private a.InterfaceC0458a f22763g;

    /* renamed from: com.opos.mobad.n.g.t$1 */
    class AnonymousClass1 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ boolean f22764a;

        /* renamed from: com.opos.mobad.n.g.t$1$1 */
        class RunnableC04641 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22766a;

            RunnableC04641(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (z || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                t.this.f22758b.setImageBitmap(bitmap);
            }
        }

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (z) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (t.this.f22763g != null) {
                    t.this.f22763g.c(i2);
                }
            } else {
                if (i2 == 1 && t.this.f22763g != null) {
                    t.this.f22763g.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.t.1.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22766a;

                    RunnableC04641(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        t.this.f22758b.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public t(Context context) {
        super(context);
        b(context);
    }

    public static t a(Context context) {
        return new t(context);
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22760d = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f22761e = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_title_color));
        this.f22761e.setTextSize(1, 14.0f);
        this.f22761e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22761e.setSingleLine(true);
        TextPaint paint = this.f22761e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView2 = new TextView(getContext());
        this.f22762f = textView2;
        textView2.setTextColor(getResources().getColor(R.color.opos_mobad_des_color));
        this.f22762f.setTextSize(1, 12.0f);
        this.f22762f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22762f.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f22760d.addView(this.f22761e, layoutParams);
        this.f22760d.addView(this.f22762f, layoutParams2);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, boolean z) {
        this.f22758b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("BlockBottomAreaView", "iconUrl is null");
        } else {
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 42.0f);
            aVar.a(gVar.f22084a, gVar.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.t.1

                /* renamed from: a */
                final /* synthetic */ boolean f22764a;

                /* renamed from: com.opos.mobad.n.g.t$1$1 */
                class RunnableC04641 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22766a;

                    RunnableC04641(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        t.this.f22758b.setImageBitmap(bitmap);
                    }
                }

                AnonymousClass1(boolean z2) {
                    z = z2;
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap2) {
                    if (z) {
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (t.this.f22763g != null) {
                            t.this.f22763g.c(i2);
                        }
                    } else {
                        if (i2 == 1 && t.this.f22763g != null) {
                            t.this.f22763g.c(i2);
                        }
                        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.t.1.1

                            /* renamed from: a */
                            final /* synthetic */ Bitmap f22766a;

                            RunnableC04641(Bitmap bitmap22) {
                                bitmap = bitmap22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap22;
                                if (z || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                    return;
                                }
                                t.this.f22758b.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    private void b(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f)));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f22759c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.f22759c.setPadding(a2, a2, a2, a2);
        this.f22759c.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 42.0f), com.opos.cmn.an.h.f.a.a(getContext(), 42.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.addRule(15);
        this.f22759c.setVisibility(8);
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.f22758b = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        v a3 = v.a(context, "");
        this.f22757a = a3;
        a3.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        a();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.f22759c.getId());
        layoutParams4.addRule(0, this.f22757a.getId());
        this.f22759c.addView(this.f22758b, layoutParams2);
        addView(this.f22759c, layoutParams);
        addView(this.f22757a, layoutParams3);
        addView(this.f22760d, layoutParams4);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockBottomAreaView", "setListener " + interfaceC0458a);
        this.f22763g = interfaceC0458a;
        this.f22757a.a(interfaceC0458a);
    }

    public void a(com.opos.mobad.n.d.g gVar, String str, String str2, String str3, com.opos.mobad.c.a aVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f22757a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f22761e.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f22762f.setText(str3);
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a)) {
            this.f22759c.setVisibility(0);
            a(gVar, aVar, z);
            return;
        }
        this.f22759c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22760d.getLayoutParams();
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.width = -1;
        this.f22760d.setLayoutParams(layoutParams);
    }
}
