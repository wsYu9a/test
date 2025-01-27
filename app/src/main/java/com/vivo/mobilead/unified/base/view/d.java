package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class d extends LinearLayout {

    /* renamed from: a */
    private TextView f29843a;

    /* renamed from: b */
    private TextView f29844b;

    /* renamed from: c */
    private TextView f29845c;

    /* renamed from: d */
    private TextView f29846d;

    /* renamed from: e */
    private com.vivo.mobilead.unified.base.callback.a f29847e;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f29847e != null) {
                d.this.f29847e.b();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f29847e != null) {
                d.this.f29847e.a();
            }
        }
    }

    public d(Context context) {
        super(context);
        setOrientation(1);
        int a2 = com.vivo.mobilead.util.m.a(context, 20.0f);
        setPadding(a2, a2, a2, a2);
        setGravity(1);
        TextView textView = new TextView(context);
        this.f29843a = textView;
        textView.setTextSize(1, 16.0f);
        this.f29843a.setTypeface(Typeface.SANS_SERIF, 1);
        this.f29843a.setTextColor(-16777216);
        this.f29843a.setText("关闭提示");
        this.f29843a.setGravity(17);
        addView(this.f29843a, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(context);
        this.f29844b = textView2;
        textView2.setTextSize(1, 13.33f);
        this.f29844b.setTextColor(Color.parseColor("#666666"));
        this.f29844b.setText("现在关闭视频将无法获得奖励，确定关闭？");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = com.vivo.mobilead.util.m.a(context, 13.33f);
        addView(this.f29844b, layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 34.67f);
        TextView textView3 = new TextView(context);
        this.f29845c = textView3;
        textView3.setTextSize(1, 14.67f);
        this.f29845c.setTextColor(Color.parseColor("#415FFF"));
        this.f29845c.setText("关闭视频");
        this.f29845c.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.weight = 1.0f;
        linearLayout.addView(this.f29845c, layoutParams3);
        this.f29845c.setOnClickListener(new a());
        TextView textView4 = new TextView(context);
        this.f29846d = textView4;
        textView4.setTextSize(1, 14.67f);
        this.f29846d.setTextColor(Color.parseColor("#415FFF"));
        this.f29846d.setText("继续观看");
        this.f29846d.setGravity(17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(this.f29846d, layoutParams4);
        this.f29846d.setOnClickListener(new b());
        addView(linearLayout, layoutParams2);
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

    public void setActionClickListener(com.vivo.mobilead.unified.base.callback.a aVar) {
        this.f29847e = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }
}
