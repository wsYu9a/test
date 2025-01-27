package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class h extends RelativeLayout {

    /* renamed from: a */
    private a.InterfaceC0458a f22857a;

    /* renamed from: com.opos.mobad.n.h.h$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (h.this.f22857a != null) {
                h.this.f22857a.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.h$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (h.this.f22857a != null) {
                h.this.f22857a.d(view, iArr);
            }
        }
    }

    public h(Context context, boolean z) {
        super(context);
        a(z);
    }

    public static h a(Context context) {
        return new h(context, true);
    }

    private void a(boolean z) {
        Context context;
        float f2;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.h.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (h.this.f22857a != null) {
                    h.this.f22857a.g(view, iArr);
                }
            }
        };
        relativeLayout.setOnClickListener(anonymousClass1);
        relativeLayout.setOnTouchListener(anonymousClass1);
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
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.h.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (h.this.f22857a != null) {
                    h.this.f22857a.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(anonymousClass2);
        imageView.setOnClickListener(anonymousClass2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        ProgressBar progressBar = new ProgressBar(getContext());
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 40.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams2.addRule(13);
        progressBar.setVisibility(0);
        linearLayout.addView(progressBar, layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#4DFFFFFF"));
        textView.setTextSize(1, 14.0f);
        textView.setText("正在加载...");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        linearLayout.addView(textView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        relativeLayout.addView(linearLayout, layoutParams4);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    public static h b(Context context) {
        return new h(context, false);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22857a = interfaceC0458a;
    }
}
