package com.vivo.mobilead.unified.base.view.q;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.vivo.ad.h.b.f;
import com.vivo.mobilead.unified.base.callback.g;
import com.vivo.mobilead.util.m;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends LinearLayout {

    /* renamed from: a */
    private TextView f30001a;

    /* renamed from: b */
    private GridView f30002b;

    /* renamed from: c */
    private com.vivo.mobilead.unified.base.view.q.a f30003c;

    /* renamed from: d */
    private LinearLayout f30004d;

    /* renamed from: e */
    private TextView f30005e;

    /* renamed from: f */
    private TextView f30006f;

    /* renamed from: g */
    private View f30007g;

    /* renamed from: h */
    private boolean f30008h;

    /* renamed from: i */
    private b f30009i;

    /* renamed from: j */
    private ViewTreeObserver.OnPreDrawListener f30010j;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!c.this.isShown() || c.this.f30009i == null) {
                return true;
            }
            c.this.f30009i.a(c.this.f30002b);
            return true;
        }
    }

    public interface b {
        void a(GridView gridView);
    }

    public c(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.f30010j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.f30010j);
    }

    public void setExposureListener(b bVar) {
        this.f30009i = bVar;
    }

    public void setOnADWidgetItemClickListener(g gVar) {
        com.vivo.mobilead.unified.base.view.q.a aVar = this.f30003c;
        if (aVar != null) {
            aVar.a(gVar);
        }
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f30006f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setOnExitClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f30005e;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public c(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.f30008h = m.c(context) == 1;
        setOrientation(1);
        setGravity(1);
        setBackground(f.b(context, 20.0f, "#FFFFFF"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        int a2 = this.f30008h ? m.a(context, 32.2f) : m.a(context, 14.0f);
        linearLayout.setPadding(a2, 0, a2, 0);
        TextView textView = new TextView(context);
        this.f30001a = textView;
        textView.setTextColor(Color.parseColor("#000000"));
        this.f30001a.setTextSize(1, 16.0f);
        this.f30001a.setText("精品游戏推荐");
        this.f30001a.setMaxLines(1);
        this.f30001a.setTypeface(Typeface.DEFAULT_BOLD);
        this.f30001a.setGravity(17);
        this.f30001a.setIncludeFontPadding(false);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a3 = this.f30008h ? m.a(context, 20.0f) : m.a(context, 14.0f);
        this.f30001a.setPadding(0, a3, 0, a3);
        this.f30001a.setBackground(f.a(context, 20.0f, new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#DDE5FF")}));
        this.f30002b = new GridView(context);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f30004d = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f30004d.setGravity(16);
        b(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        this.f30004d.addView(this.f30005e, layoutParams2);
        this.f30004d.addView(this.f30007g, new LinearLayout.LayoutParams(m.a(context, 1.0f), m.a(context, 20.0f)));
        this.f30004d.addView(this.f30006f, layoutParams2);
        linearLayout.addView(this.f30002b);
        linearLayout.addView(this.f30004d);
        addView(this.f30001a, layoutParams);
        addView(linearLayout);
    }

    private void b(Context context) {
        int a2 = m.a(context, 17.0f);
        int a3 = m.a(context, 17.0f);
        if (!this.f30008h) {
            a2 = m.a(context, 14.0f);
            a3 = m.a(context, 14.0f);
        }
        TextView textView = new TextView(context);
        this.f30006f = textView;
        textView.setTextColor(Color.parseColor("#5C81FF"));
        this.f30006f.setTextSize(1, 16.0f);
        this.f30006f.setText("再玩一会");
        this.f30006f.setPadding(a2, a3, a2, a3);
        this.f30006f.setGravity(17);
        this.f30006f.setIncludeFontPadding(false);
        TextView textView2 = new TextView(context);
        this.f30005e = textView2;
        textView2.setTextColor(Color.parseColor("#666666"));
        this.f30005e.setTextSize(1, 16.0f);
        this.f30005e.setText("退出游戏");
        this.f30005e.setPadding(a2, a3, a2, a3);
        this.f30005e.setGravity(17);
        this.f30005e.setIncludeFontPadding(false);
        View view = new View(context);
        this.f30007g = view;
        view.setBackgroundColor(Color.parseColor("#F2F2F2"));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public c(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30008h = true;
        this.f30010j = new a();
        a(context);
    }

    public void a(List<com.vivo.ad.model.b> list) {
        LinearLayout.LayoutParams layoutParams;
        if (list == null || list.size() == 0) {
            return;
        }
        com.vivo.ad.model.b bVar = list.get(0);
        if (bVar != null && bVar.c() != null) {
            this.f30001a.setText(bVar.c().f());
        }
        if (list.size() == 6) {
            this.f30002b.setNumColumns(3);
        } else if (list.size() == 8) {
            this.f30002b.setNumColumns(4);
        } else if (list.size() == 9) {
            if (m.c(getContext()) == 2) {
                list.remove(list.size() - 1);
                this.f30002b.setNumColumns(4);
            } else {
                this.f30002b.setNumColumns(3);
            }
        }
        this.f30003c = new com.vivo.mobilead.unified.base.view.q.a(getContext(), list);
        if (this.f30008h) {
            this.f30002b.setHorizontalSpacing(m.a(getContext(), 28.0f));
            this.f30002b.setVerticalSpacing(m.a(getContext(), 20.0f));
        } else {
            if (list.size() == 8) {
                this.f30002b.setHorizontalSpacing(m.a(getContext(), 10.0f));
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(m.a(getContext(), 264.0f), -2);
            }
            this.f30002b.setLayoutParams(layoutParams);
            this.f30002b.setVerticalSpacing(m.a(getContext(), 14.0f));
        }
        this.f30002b.setVerticalScrollBarEnabled(false);
        this.f30002b.setAdapter((ListAdapter) this.f30003c);
    }
}
