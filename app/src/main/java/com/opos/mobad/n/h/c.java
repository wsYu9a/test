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
public class c extends TextView {

    /* renamed from: a */
    com.opos.mobad.n.c.g f22825a;

    /* renamed from: b */
    private String f22826b;

    /* renamed from: c */
    private a.InterfaceC0458a f22827c;

    /* renamed from: com.opos.mobad.n.h.c$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            com.opos.cmn.an.f.a.b("RewardClickButton", "onBtnClick");
            if (c.this.f22827c != null) {
                c.this.f22827c.f(view, iArr);
            }
        }
    }

    public c(Context context, String str, int i2, int i3, int i4) {
        super(context);
        this.f22826b = "立即安装";
        this.f22825a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.c.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardClickButton", "onBtnClick");
                if (c.this.f22827c != null) {
                    c.this.f22827c.f(view, iArr);
                }
            }
        };
        this.f22826b = TextUtils.isEmpty(str) ? this.f22826b : str;
        a(i2, i3, i4);
    }

    public static c a(Context context, String str) {
        return new c(context, str, R.drawable.opos_mobad_drawable_reward_block_click_btn, 12, 28);
    }

    private void a(int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), i4));
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        setPadding(a2, a3, a2, a3);
        setLayoutParams(layoutParams);
        setBackgroundResource(i2);
        setGravity(17);
        setTextSize(1, i3);
        setTextColor(Color.parseColor("#000000"));
        setText(this.f22826b);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f22825a);
        setOnTouchListener(this.f22825a);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("RewardClickButton", "setListener " + interfaceC0458a);
        this.f22827c = interfaceC0458a;
    }
}
