package com.opos.mobad.n.g;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;
import com.opos.mobad.n.g.ad;

/* loaded from: classes4.dex */
public class ah extends RelativeLayout {

    /* renamed from: a */
    private TextView f22429a;

    /* renamed from: b */
    private int f22430b;

    /* renamed from: c */
    private a.InterfaceC0458a f22431c;

    /* renamed from: d */
    private ad.a f22432d;

    /* renamed from: com.opos.mobad.n.g.ah$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ah.this.f22431c != null) {
                ah.this.b();
                ah.this.f22431c.a(view, iArr, ah.this.f22430b == 1);
            }
        }
    }

    public ah(Context context) {
        super(context);
        this.f22430b = 0;
        a();
    }

    public static ah a(Context context) {
        return new ah(context);
    }

    private void a() {
        this.f22429a = new TextView(getContext());
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ah.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ah.this.f22431c != null) {
                    ah.this.b();
                    ah.this.f22431c.a(view, iArr, ah.this.f22430b == 1);
                }
            }
        };
        this.f22429a.setOnClickListener(anonymousClass1);
        this.f22429a.setOnTouchListener(anonymousClass1);
        this.f22429a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        addView(this.f22429a, layoutParams);
    }

    public void b() {
        int i2 = this.f22430b;
        int i3 = i2 != 0 ? i2 == 1 ? 0 : -1 : 1;
        if (i3 == -1) {
            return;
        }
        ad.a aVar = this.f22432d;
        if (aVar != null) {
            aVar.a(i3);
        }
        b(i3);
    }

    private void b(int i2) {
        Resources resources;
        int i3;
        TextView textView = this.f22429a;
        if (textView == null || this.f22430b == i2) {
            return;
        }
        this.f22430b = i2;
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

    public void a(int i2) {
        b(i2);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22431c = interfaceC0458a;
    }

    public void a(ad.a aVar) {
        this.f22432d = aVar;
    }
}
