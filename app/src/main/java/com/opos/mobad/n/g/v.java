package com.opos.mobad.n.g;

import android.content.Context;
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
public class v extends TextView {

    /* renamed from: a */
    com.opos.mobad.n.c.g f22771a;

    /* renamed from: b */
    private String f22772b;

    /* renamed from: c */
    private a.InterfaceC0458a f22773c;

    /* renamed from: com.opos.mobad.n.g.v$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            com.opos.cmn.an.f.a.b("BlockClickButton", "onBtnClick");
            if (v.this.f22773c != null) {
                v.this.f22773c.f(view, iArr);
            }
        }
    }

    public v(Context context, String str, int i2, int i3, int i4, int i5) {
        super(context);
        this.f22772b = "下载";
        this.f22771a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.v.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BlockClickButton", "onBtnClick");
                if (v.this.f22773c != null) {
                    v.this.f22773c.f(view, iArr);
                }
            }
        };
        this.f22772b = TextUtils.isEmpty(str) ? this.f22772b : str;
        a(i2, i3, i4, i5);
    }

    public static v a(Context context, String str) {
        return new v(context, str, R.drawable.opos_mobad_drawable_circlr_block_click_btn, context.getResources().getColor(R.color.opos_mobad_white_color), 12, 28);
    }

    private void a(int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), i5));
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        setPadding(a2, a3, a2, a3);
        setLayoutParams(layoutParams);
        setBackgroundResource(i2);
        setGravity(17);
        setTextSize(1, i4);
        setTextColor(i3);
        setText(this.f22772b);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        TextPaint paint = getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setOnClickListener(this.f22771a);
        setOnTouchListener(this.f22771a);
    }

    public static v b(Context context, String str) {
        return new v(context, str, R.drawable.opos_mobad_drawable_circlr_block_click_white_btn, context.getResources().getColor(R.color.opos_mobad_button_bg_white_color), 10, 26);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockClickButton", "setListener " + interfaceC0458a);
        this.f22773c = interfaceC0458a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setText(str);
    }
}
