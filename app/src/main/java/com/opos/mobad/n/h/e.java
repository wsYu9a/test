package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class e extends TextView {

    /* renamed from: a */
    com.opos.mobad.n.c.g f22833a;

    /* renamed from: b */
    private String f22834b;

    /* renamed from: c */
    private a.InterfaceC0458a f22835c;

    /* renamed from: com.opos.mobad.n.h.e$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            com.opos.cmn.an.f.a.b("RewardEndClickButton", "onBtnClick");
            if (e.this.f22835c != null) {
                e.this.f22835c.k(view, iArr);
            }
        }
    }

    public e(Context context, String str, int i2, int i3, int i4) {
        super(context);
        this.f22834b = "立即安装";
        this.f22833a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.e.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardEndClickButton", "onBtnClick");
                if (e.this.f22835c != null) {
                    e.this.f22835c.k(view, iArr);
                }
            }
        };
        this.f22834b = TextUtils.isEmpty(str) ? this.f22834b : str;
        a(i2, i3, i4);
    }

    public static e a(Context context, String str) {
        return new e(context, str, R.drawable.opos_mobad_drawable_reward_endclick_btn, 14, 44);
    }

    private void a(int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), i4));
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        setPadding(a2, a3, a2, a3);
        setLayoutParams(layoutParams);
        setBackgroundResource(i2);
        setGravity(17);
        setTextSize(1, i3);
        setTextColor(Color.parseColor("#000000"));
        setText(this.f22834b);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f22833a);
        setOnTouchListener(this.f22833a);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22835c = interfaceC0458a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setText(str);
    }
}
