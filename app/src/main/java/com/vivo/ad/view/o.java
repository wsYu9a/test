package com.vivo.ad.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vivo.ad.view.p;
import com.vivo.mobilead.util.k0;

/* loaded from: classes4.dex */
public class o extends LinearLayout {

    /* renamed from: a */
    private TextView f27041a;

    /* renamed from: b */
    private TextView f27042b;

    /* renamed from: c */
    private com.vivo.ad.model.b f27043c;

    /* renamed from: d */
    private p f27044d;

    /* renamed from: e */
    private boolean f27045e;

    /* renamed from: f */
    private String f27046f;

    /* renamed from: g */
    private p.h f27047g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.f27045e = false;
            k0.a(o.this.f27043c, o.this.f27046f);
            o.this.b();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.f27045e = true;
            k0.a(o.this.f27043c, o.this.f27046f);
            o.this.b();
        }
    }

    public o(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setDialogListener(p.h hVar) {
        this.f27047g = hVar;
    }

    public void setTextColor(int i2) {
        TextView textView = this.f27041a;
        if (textView != null) {
            textView.setTextColor(i2);
        }
        TextView textView2 = this.f27042b;
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
    }

    private o(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b() {
        if (this.f27043c == null) {
            return;
        }
        p pVar = new p(getContext(), this.f27043c, this.f27046f);
        this.f27044d = pVar;
        p.h hVar = this.f27047g;
        if (hVar != null) {
            pVar.a(hVar);
        }
        p pVar2 = this.f27044d;
        if (pVar2 == null || pVar2.isShowing()) {
            return;
        }
        this.f27044d.a(this.f27045e);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    private o(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27045e = false;
        this.f27046f = "";
        a();
    }

    private void a() {
        setOrientation(0);
        this.f27041a = new TextView(getContext());
        this.f27042b = new TextView(getContext());
        this.f27041a.setTextColor(Color.parseColor("#5c81ff"));
        this.f27041a.setText("隐私");
        this.f27041a.setTextSize(1, 11.0f);
        this.f27042b.setTextColor(Color.parseColor("#5c81ff"));
        this.f27042b.setText("权限");
        this.f27042b.setTextSize(1, 11.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = com.vivo.mobilead.util.m.b(getContext(), 7.0f);
        layoutParams.rightMargin = com.vivo.mobilead.util.m.b(getContext(), 7.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.vivo.mobilead.util.m.b(getContext(), 7.0f);
        addView(this.f27041a, layoutParams);
        addView(this.f27042b, layoutParams2);
        this.f27041a.setOnClickListener(new a());
        this.f27042b.setOnClickListener(new b());
    }

    public void a(com.vivo.ad.model.b bVar, String str) {
        this.f27043c = bVar;
        this.f27046f = str;
    }

    public void a(float f2, float f3, float f4, int i2) {
        TextView textView = this.f27041a;
        if (textView != null) {
            textView.setShadowLayer(f2, f3, f4, i2);
        }
        TextView textView2 = this.f27042b;
        if (textView2 != null) {
            textView2.setShadowLayer(f2, f3, f4, i2);
        }
    }
}
