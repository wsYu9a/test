package com.opos.mobad.n.g;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class af extends RelativeLayout {

    /* renamed from: a */
    private ae f22409a;

    /* renamed from: b */
    private LinearLayout f22410b;

    /* renamed from: c */
    private TextView f22411c;

    /* renamed from: d */
    private int f22412d;

    /* renamed from: e */
    private a.InterfaceC0458a f22413e;

    /* renamed from: f */
    private a f22414f;

    /* renamed from: com.opos.mobad.n.g.af$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (af.this.f22413e != null) {
                af.this.f22413e.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.af$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (af.this.f22413e != null) {
                af.this.a();
                af.this.f22413e.a(view, iArr, af.this.f22412d == 1);
            }
        }
    }

    public interface a {
        void a(int i2);
    }

    public af(Context context, boolean z) {
        super(context);
        this.f22412d = 0;
        a(z);
    }

    public static af a(Context context, boolean z) {
        return new af(context, z);
    }

    public void a() {
        int i2 = this.f22412d;
        int i3 = i2 != 0 ? i2 == 1 ? 0 : -1 : 1;
        if (i3 == -1) {
            return;
        }
        a aVar = this.f22414f;
        if (aVar != null) {
            aVar.a(i3);
        }
        a(i3);
    }

    private void a(int i2) {
        Resources resources;
        int i3;
        TextView textView = this.f22411c;
        if (textView == null || this.f22412d == i2) {
            return;
        }
        this.f22412d = i2;
        if (i2 == 0) {
            resources = getContext().getResources();
            i3 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i2 == 2) {
            textView.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i3 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i3));
    }

    private void a(boolean z) {
        this.f22409a = ae.a(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(9);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams.leftMargin = a2;
        layoutParams.addRule(15);
        addView(this.f22409a, layoutParams);
        this.f22410b = new LinearLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        this.f22410b.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        this.f22410b.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = a2;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.af.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (af.this.f22413e != null) {
                    af.this.f22413e.d(view, iArr);
                }
            }
        };
        this.f22410b.setOnTouchListener(anonymousClass1);
        this.f22410b.setOnClickListener(anonymousClass1);
        addView(this.f22410b, layoutParams2);
        if (z) {
            this.f22411c = new TextView(getContext());
            AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.af.2
                AnonymousClass2() {
                }

                @Override // com.opos.mobad.n.c.g
                public void a(View view, int[] iArr) {
                    if (af.this.f22413e != null) {
                        af.this.a();
                        af.this.f22413e.a(view, iArr, af.this.f22412d == 1);
                    }
                }
            };
            this.f22411c.setOnClickListener(anonymousClass2);
            this.f22411c.setOnTouchListener(anonymousClass2);
            this.f22411c.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
            layoutParams3.addRule(0, this.f22410b.getId());
            layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
            addView(this.f22411c, layoutParams3);
        }
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22413e = interfaceC0458a;
        this.f22409a.a(interfaceC0458a);
    }

    public void a(a aVar) {
        this.f22414f = aVar;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2, int i2) {
        this.f22409a.a(z, str, z2, gVar, str2);
        a(i2);
    }
}
