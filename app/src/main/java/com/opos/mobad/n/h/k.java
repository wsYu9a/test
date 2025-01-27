package com.opos.mobad.n.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class k extends LinearLayout {

    /* renamed from: a */
    private TextView f22873a;

    /* renamed from: b */
    private View f22874b;

    /* renamed from: c */
    private ImageView f22875c;

    /* renamed from: d */
    private int f22876d;

    /* renamed from: e */
    private a.InterfaceC0458a f22877e;

    /* renamed from: f */
    private a f22878f;

    /* renamed from: com.opos.mobad.n.h.k$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (k.this.f22877e != null) {
                k.this.f22877e.a(view, iArr, k.this.f22876d == 1);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.k$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (k.this.f22877e != null) {
                k.this.f22877e.d(view, iArr);
            }
        }
    }

    public interface a {
        void a(int i2);
    }

    public k(Context context) {
        super(context);
        this.f22876d = 0;
        c();
    }

    public static k a(Context context) {
        return new k(context);
    }

    private void b(int i2) {
        Resources resources;
        int i3;
        TextView textView = this.f22873a;
        if (textView == null || this.f22876d == i2) {
            return;
        }
        this.f22876d = i2;
        if (i2 == 0) {
            resources = getContext().getResources();
            i3 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i2 == 2) {
            textView.setVisibility(8);
            this.f22874b.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i3 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i3));
    }

    private void c() {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_title_bg);
        setGravity(16);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(a3, a2, a3, a2);
        this.f22873a = new TextView(getContext());
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.k.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (k.this.f22877e != null) {
                    k.this.f22877e.a(view, iArr, k.this.f22876d == 1);
                }
            }
        };
        this.f22873a.setOnClickListener(anonymousClass1);
        this.f22873a.setOnTouchListener(anonymousClass1);
        this.f22873a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        addView(this.f22873a, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f)));
        View view = new View(getContext());
        this.f22874b = view;
        view.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.f22874b.setVisibility(8);
        addView(this.f22874b, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.f22875c = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f22875c.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.f22875c.setVisibility(8);
        addView(this.f22875c, layoutParams2);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.k.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (k.this.f22877e != null) {
                    k.this.f22877e.d(view2, iArr);
                }
            }
        };
        this.f22875c.setOnTouchListener(anonymousClass2);
        this.f22875c.setOnClickListener(anonymousClass2);
    }

    public void a() {
        this.f22874b.setVisibility(0);
        this.f22875c.setVisibility(0);
    }

    public void a(int i2) {
        if (this.f22876d == i2) {
            return;
        }
        a aVar = this.f22878f;
        if (aVar != null) {
            aVar.a(i2);
        }
        b(i2);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22877e = interfaceC0458a;
    }

    public void a(a aVar) {
        this.f22878f = aVar;
    }

    public void b() {
        this.f22873a.setVisibility(8);
        this.f22874b.setVisibility(8);
        this.f22875c.setVisibility(0);
        ((LinearLayout.LayoutParams) this.f22875c.getLayoutParams()).leftMargin = 0;
    }
}
