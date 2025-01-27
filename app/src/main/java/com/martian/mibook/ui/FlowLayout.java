package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FlowLayout extends LinearLayout implements g.a {

    /* renamed from: a */
    private final int f14143a;

    /* renamed from: b */
    private int f14144b;

    /* renamed from: c */
    private final int f14145c;

    /* renamed from: d */
    private final float f14146d;

    /* renamed from: e */
    private final int f14147e;

    /* renamed from: f */
    private int f14148f;

    /* renamed from: g */
    private final boolean f14149g;

    /* renamed from: h */
    private final boolean f14150h;

    /* renamed from: i */
    private final int f14151i;

    /* renamed from: j */
    private final int f14152j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private int q;
    private final int r;
    private int s;
    private List<String> t;
    private a u;

    public interface a {
        void a(String title, int position);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f14143a = com.martian.libmars.d.h.b(26.0f);
        this.f14144b = 0;
        this.f14148f = com.martian.libmars.d.h.F().r0();
        this.s = 0;
        this.t = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.SearchLayout);
        this.f14147e = obtainStyledAttributes.getInteger(5, 0);
        this.f14146d = obtainStyledAttributes.getDimension(14, 0.0f);
        this.f14150h = obtainStyledAttributes.getBoolean(4, true);
        this.f14149g = obtainStyledAttributes.getBoolean(0, false);
        this.f14151i = obtainStyledAttributes.getInteger(13, 4);
        this.f14152j = obtainStyledAttributes.getInteger(11, 12);
        this.k = obtainStyledAttributes.getInteger(10, 4);
        this.l = obtainStyledAttributes.getInteger(12, 12);
        this.m = obtainStyledAttributes.getInteger(9, 6);
        this.n = obtainStyledAttributes.getInteger(7, 4);
        this.o = obtainStyledAttributes.getInteger(6, 6);
        this.p = obtainStyledAttributes.getInteger(8, 4);
        this.q = obtainStyledAttributes.getInteger(1, 100);
        this.r = obtainStyledAttributes.getInteger(3, 100);
        this.f14145c = displayMetrics.widthPixels - ((int) obtainStyledAttributes.getDimension(2, 0.0f));
        setOrientation(1);
        l();
        obtainStyledAttributes.recycle();
    }

    static /* synthetic */ boolean b(final ImageView moreIcon, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            moreIcon.setAlpha(0.6f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        moreIcon.setAlpha(1.0f);
        return false;
    }

    /* renamed from: c */
    public /* synthetic */ void d(final ImageView moreIcon, View v) {
        this.q = 100;
        moreIcon.setVisibility(8);
        k(this.t, this.s);
    }

    static /* synthetic */ boolean e(final TextView textView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            textView.setAlpha(0.6f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        textView.setAlpha(1.0f);
        return false;
    }

    /* renamed from: f */
    public /* synthetic */ void h(final int position, final String name, View view) {
        setSelectPosition(position);
        a aVar = this.u;
        if (aVar != null) {
            aVar.a(name, position);
        }
    }

    private int getIconWidth() {
        return this.f14143a + com.martian.libmars.d.h.b(this.n);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private ImageView getMoreIcon() {
        final ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(com.martian.ttbookhd.R.drawable.icon_more);
        if (this.f14149g) {
            imageView.setBackgroundResource(com.martian.libmars.d.h.F().I0() ? com.martian.ttbookhd.R.drawable.border_search_background_night : com.martian.ttbookhd.R.drawable.border_search_background_day);
        }
        imageView.setColorFilter(this.f14148f);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.ui.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FlowLayout.b(imageView, view, motionEvent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlowLayout.this.d(imageView, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = this.f14143a;
        layoutParams.width = i2;
        layoutParams.height = i2;
        int b2 = com.martian.libmars.d.h.b(6.0f);
        imageView.setPadding(b2, b2, b2, b2);
        layoutParams.setMargins(com.martian.libmars.d.h.b(this.n), ((((((((int) this.f14146d) + com.martian.libmars.d.h.b(4.0f)) + com.martian.libmars.d.h.b(this.f14151i)) + com.martian.libmars.d.h.b(this.k)) + com.martian.libmars.d.h.b(this.m)) + com.martian.libmars.d.h.b(this.o)) - this.f14143a) / 2, 0, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private void i() {
        List<String> list = this.t;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            TextView textView = (TextView) findViewWithTag(Integer.valueOf(i2));
            if (textView != null) {
                m(textView, i2);
            }
        }
    }

    private void k(List<String> info, int index) {
        if (info.isEmpty()) {
            return;
        }
        this.t = info;
        LinearLayout linearLayout = getLinearLayout();
        int i2 = 1;
        int i3 = 0;
        while (index < this.t.size()) {
            TextView a2 = a(this.t.get(index), index);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
            a2.measure(getMeasuredWidth(), getMeasuredHeight());
            int measuredWidth = a2.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            i3 += measuredWidth;
            if (this.f14145c >= (i2 == this.q ? getIconWidth() : 0) + i3) {
                linearLayout.addView(a2);
            } else {
                if (i2 >= this.r) {
                    return;
                }
                if (i2 >= this.q) {
                    linearLayout.addView(getMoreIcon());
                    this.s = index;
                    return;
                } else {
                    i2++;
                    linearLayout = getLinearLayout();
                    linearLayout.addView(a2);
                    i3 = measuredWidth;
                }
            }
            index++;
        }
    }

    private void l() {
        if (com.martian.libmars.d.h.F().I0()) {
            int i2 = this.f14147e;
            if (i2 == 1) {
                this.f14148f = com.martian.ttbookhd.R.color.night_text_color_secondary;
                return;
            } else if (i2 != 2) {
                this.f14148f = com.martian.ttbookhd.R.color.night_text_color_primary;
                return;
            } else {
                this.f14148f = com.martian.ttbookhd.R.color.night_text_color_thirdly;
                return;
            }
        }
        int i3 = this.f14147e;
        if (i3 == 1) {
            this.f14148f = com.martian.ttbookhd.R.color.day_text_color_secondary;
        } else if (i3 != 2) {
            this.f14148f = com.martian.ttbookhd.R.color.day_text_color_primary;
        } else {
            this.f14148f = com.martian.ttbookhd.R.color.day_text_color_thirdly;
        }
    }

    private void m(TextView textView, int position) {
        if (this.f14149g) {
            if (MiConfigSingleton.V3().I0()) {
                textView.setBackgroundResource(com.martian.ttbookhd.R.drawable.border_search_background_night);
            } else {
                textView.setBackgroundResource(com.martian.ttbookhd.R.drawable.border_search_background_day);
            }
            textView.setTextColor(ContextCompat.getColor(getContext(), this.f14148f));
            return;
        }
        if (this.f14144b != position) {
            textView.setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.ttbookhd.R.color.transparent));
            textView.setTextColor(ContextCompat.getColor(getContext(), this.f14148f));
            return;
        }
        textView.setTextColor(ContextCompat.getColor(getContext(), com.martian.ttbookhd.R.color.theme_default));
        if (MiConfigSingleton.V3().I0()) {
            textView.setBackgroundResource(com.martian.ttbookhd.R.drawable.border_search_background_night);
        } else {
            textView.setBackgroundResource(com.martian.ttbookhd.R.drawable.border_search_background_day);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public TextView a(final String name, final int position) {
        final TextView textView = new TextView(getContext());
        textView.setTag(Integer.valueOf(position));
        textView.setTextSize(0, this.f14146d);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(com.martian.libmars.d.h.b(this.f14152j), com.martian.libmars.d.h.b(this.f14151i), com.martian.libmars.d.h.b(this.l), com.martian.libmars.d.h.b(this.k));
        m(textView, position);
        textView.setText(name);
        if (this.f14150h) {
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.ui.d
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return FlowLayout.e(textView, view, motionEvent);
                }
            });
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlowLayout.this.h(position, name, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.martian.libmars.d.h.b(this.n), com.martian.libmars.d.h.b(this.m), com.martian.libmars.d.h.b(this.p), com.martian.libmars.d.h.b(this.o));
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    @Override // g.a
    public void g() {
        i();
    }

    public LinearLayout getLinearLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(linearLayout);
        return linearLayout;
    }

    public int getSelectPosition() {
        return this.f14144b;
    }

    public String getSelectedItem() {
        return this.f14144b >= this.t.size() ? "" : this.t.get(this.f14144b);
    }

    public void j() {
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        com.martian.libmars.d.h.F().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.martian.libmars.d.h.F().j1(this);
    }

    public void setData(List<String> info) {
        k(info, 0);
    }

    public void setOnItemTitleClickListener(a onItemTitleClickListener) {
        this.u = onItemTitleClickListener;
    }

    public void setSelectPosition(int mSelectPosition) {
        this.f14144b = mSelectPosition;
        i();
    }
}
