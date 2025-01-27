package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class ae extends LinearLayout {

    /* renamed from: a */
    com.opos.mobad.n.c.g f22395a;

    /* renamed from: b */
    private com.opos.mobad.n.c.l f22396b;

    /* renamed from: c */
    private TextView f22397c;

    /* renamed from: d */
    private FrameLayout f22398d;

    /* renamed from: e */
    private a.InterfaceC0458a f22399e;

    /* renamed from: f */
    private a f22400f;

    /* renamed from: com.opos.mobad.n.g.ae$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            com.opos.cmn.an.f.a.b("BlockTipBar", "onFeedBackClick");
            if (ae.this.f22399e != null) {
                ae.this.f22399e.a(view, iArr);
            }
        }
    }

    static class a {

        /* renamed from: a */
        public final int f22402a;

        /* renamed from: b */
        public final int f22403b;

        /* renamed from: c */
        public final int f22404c;

        /* renamed from: d */
        public final int f22405d;

        /* renamed from: e */
        public final float f22406e;

        /* renamed from: f */
        public final int f22407f;

        /* renamed from: g */
        public final boolean f22408g;

        public a(int i2, int i3, int i4, int i5, float f2, int i6, boolean z) {
            this.f22402a = i2;
            this.f22404c = i4;
            this.f22403b = i3;
            this.f22405d = i5;
            this.f22406e = f2;
            this.f22407f = i6;
            this.f22408g = z;
        }
    }

    public ae(Context context, a aVar) {
        super(context);
        this.f22395a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ae.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BlockTipBar", "onFeedBackClick");
                if (ae.this.f22399e != null) {
                    ae.this.f22399e.a(view, iArr);
                }
            }
        };
        this.f22400f = aVar;
        a();
    }

    public static ae a(Context context) {
        return new ae(context, new a(10, 33, 14, 3, 3.0f, 637534208, true));
    }

    private void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f22400f.f22407f);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.f22400f.f22406e));
        com.opos.mobad.n.e.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.f22400f.f22405d), 0, 0, 0);
        setOrientation(0);
        com.opos.mobad.n.c.l lVar = new com.opos.mobad.n.c.l(getContext());
        this.f22396b = lVar;
        lVar.setTextColor(Color.parseColor("#FFFFFF"));
        this.f22396b.setTextSize(1, this.f22400f.f22402a);
        this.f22396b.setGravity(17);
        this.f22396b.setMaxEms(6);
        this.f22396b.setEllipsize(TextUtils.TruncateAt.END);
        this.f22396b.setLetterSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 0.67f));
        this.f22396b.setSingleLine();
        this.f22396b.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.f22396b, layoutParams);
        this.f22398d = new FrameLayout(getContext());
        TextView textView = new TextView(getContext());
        this.f22397c = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_feedback_down_arrow);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams2.gravity = 17;
        this.f22398d.addView(this.f22397c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 2.0f), 0, 0, 0);
        addView(this.f22398d, layoutParams3);
    }

    public static ae b(Context context) {
        return new ae(context, new a(10, 33, 14, 3, 3.0f, context.getResources().getColor(R.color.opos_mobad_small_bar_bg_color), true));
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockTipBar", "setListener " + interfaceC0458a);
        this.f22399e = interfaceC0458a;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        a(z, z2, gVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.n.d.g gVar, String str) {
        Drawable drawable = null;
        FrameLayout frameLayout = this.f22398d;
        if (z) {
            frameLayout.setVisibility(0);
            this.f22398d.setOnClickListener(this.f22395a);
            this.f22398d.setOnTouchListener(this.f22395a);
            this.f22396b.setOnClickListener(this.f22395a);
            this.f22396b.setOnTouchListener(this.f22395a);
        } else {
            frameLayout.setVisibility(8);
            this.f22396b.setOnClickListener(null);
            this.f22396b.setOnTouchListener(null);
        }
        if (!z2 || this.f22396b.getVisibility() == 0) {
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a)) {
            drawable = com.opos.mobad.n.e.a(getContext(), gVar.f22084a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(drawable != null ? drawable : "null");
        com.opos.cmn.an.f.a.b("BlockTipBar", sb.toString());
        ViewGroup.LayoutParams layoutParams = this.f22396b.getLayoutParams();
        if (drawable != null) {
            com.opos.mobad.n.e.a(this.f22396b, drawable);
            layoutParams.width = com.opos.cmn.an.h.f.a.a(getContext(), this.f22400f.f22403b);
            layoutParams.height = com.opos.cmn.an.h.f.a.a(getContext(), this.f22400f.f22404c);
        } else {
            com.opos.mobad.n.c.l lVar = this.f22396b;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            lVar.setText(str);
            layoutParams.width = -2;
            layoutParams.height = -2;
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f22400f.f22405d);
            setPadding(a2, 0, z ? 0 : a2, 0);
        }
        this.f22396b.setLayoutParams(layoutParams);
        this.f22396b.setVisibility(0);
    }
}
