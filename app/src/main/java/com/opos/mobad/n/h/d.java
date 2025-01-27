package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: classes4.dex */
public class d extends RelativeLayout {

    /* renamed from: a */
    private TextView f22829a;

    /* renamed from: b */
    private a f22830b;

    /* renamed from: com.opos.mobad.n.h.d$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (d.this.f22830b != null) {
                d.this.f22830b.a(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.d$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (d.this.f22830b != null) {
                d.this.f22830b.b(view, iArr);
            }
        }
    }

    public interface a {
        void a(View view, int[] iArr);

        void b(View view, int[] iArr);
    }

    public d(Context context) {
        super(context);
        a();
    }

    public static d a(Context context) {
        return new d(context);
    }

    private void a() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(0);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout relativeLayout3 = new RelativeLayout(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        relativeLayout2.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_dialog_bg);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(View.generateViewId());
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#2D40E9"));
        textView.setGravity(1);
        textView.setTextSize(1, 14.0f);
        textView.setText("关闭视频");
        TextPaint paint = textView.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(textView, layoutParams);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.d.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (d.this.f22830b != null) {
                    d.this.f22830b.a(view, iArr);
                }
            }
        };
        textView.setOnClickListener(anonymousClass1);
        textView.setOnTouchListener(anonymousClass1);
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundColor(Color.parseColor("#33000000"));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), a2));
        TextView textView3 = new TextView(getContext());
        textView3.setTextColor(Color.parseColor("#2D40E9"));
        textView3.setTextSize(1, 14.0f);
        textView3.setGravity(1);
        textView3.setText("继续观看");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a2);
        layoutParams2.weight = 1.0f;
        TextPaint paint2 = textView3.getPaint();
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        linearLayout.addView(textView3, layoutParams2);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.d.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (d.this.f22830b != null) {
                    d.this.f22830b.b(view, iArr);
                }
            }
        };
        textView3.setOnClickListener(anonymousClass2);
        textView3.setOnTouchListener(anonymousClass2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        relativeLayout3.addView(linearLayout, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.f22829a = textView4;
        textView4.setId(View.generateViewId());
        this.f22829a.setTextColor(Color.parseColor("#D9000000"));
        this.f22829a.setTextSize(1, 16.0f);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        TextPaint paint3 = this.f22829a.getPaint();
        paint3.setStrokeWidth(1.0f);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        frameLayout.setPadding(a3, a3, a3, 0);
        frameLayout.addView(this.f22829a, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(14);
        layoutParams5.addRule(2, linearLayout.getId());
        relativeLayout3.addView(frameLayout, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), -2);
        layoutParams6.addRule(15);
        relativeLayout2.addView(relativeLayout3, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), com.opos.cmn.an.h.f.a.a(getContext(), 143.0f));
        layoutParams7.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams7);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(a aVar) {
        this.f22830b = aVar;
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f22829a.setText(charSequence);
    }
}
