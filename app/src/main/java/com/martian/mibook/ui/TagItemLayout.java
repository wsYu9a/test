package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class TagItemLayout extends LinearLayout implements g.a {

    /* renamed from: a */
    private int f14166a;

    /* renamed from: b */
    private final int f14167b;

    /* renamed from: c */
    private final float f14168c;

    /* renamed from: d */
    private final int f14169d;

    /* renamed from: e */
    private int f14170e;

    /* renamed from: f */
    private final int f14171f;

    /* renamed from: g */
    private final int f14172g;

    /* renamed from: h */
    private final int f14173h;

    /* renamed from: i */
    private final int f14174i;

    /* renamed from: j */
    private final int f14175j;
    private List<TYCategoryTagItem> k;
    private a l;

    public interface a {
        void a(TYCategoryTagItem tagItem, int position);
    }

    public TagItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f14166a = 0;
        this.f14170e = com.martian.libmars.d.h.F().r0();
        this.k = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.SearchLayout);
        this.f14169d = obtainStyledAttributes.getInteger(5, 0);
        this.f14168c = obtainStyledAttributes.getDimension(14, 14.0f);
        this.f14171f = obtainStyledAttributes.getInteger(13, 4);
        this.f14172g = obtainStyledAttributes.getInteger(11, 12);
        this.f14173h = obtainStyledAttributes.getInteger(10, 4);
        this.f14174i = obtainStyledAttributes.getInteger(12, 12);
        this.f14175j = obtainStyledAttributes.getInteger(3, 100);
        this.f14167b = displayMetrics.widthPixels - com.martian.libmars.d.h.b(32.0f);
        setOrientation(1);
        i();
        obtainStyledAttributes.recycle();
    }

    static /* synthetic */ boolean c(final LinearLayout linearLayout, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            Iterator<View> it = i.a.a(linearLayout).iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.6f);
            }
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        Iterator<View> it2 = i.a.a(linearLayout).iterator();
        while (it2.hasNext()) {
            it2.next().setAlpha(1.0f);
        }
        return false;
    }

    /* renamed from: d */
    public /* synthetic */ void e(final int position, final TYCategoryTagItem tagInfo, View view) {
        setSelectPosition(position);
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(tagInfo, position);
        }
    }

    private void f() {
        List<TYCategoryTagItem> list = this.k;
        if (list == null || list.isEmpty()) {
            return;
        }
        i();
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            j(i2);
        }
    }

    private void i() {
        if (com.martian.libmars.d.h.F().I0()) {
            int i2 = this.f14169d;
            if (i2 == 1) {
                this.f14170e = com.martian.ttbookhd.R.color.night_text_color_secondary;
                return;
            } else if (i2 != 2) {
                this.f14170e = com.martian.ttbookhd.R.color.night_text_color_primary;
                return;
            } else {
                this.f14170e = com.martian.ttbookhd.R.color.night_text_color_thirdly;
                return;
            }
        }
        int i3 = this.f14169d;
        if (i3 == 1) {
            this.f14170e = com.martian.ttbookhd.R.color.day_text_color_secondary;
        } else if (i3 != 2) {
            this.f14170e = com.martian.ttbookhd.R.color.day_text_color_primary;
        } else {
            this.f14170e = com.martian.ttbookhd.R.color.day_text_color_thirdly;
        }
    }

    private void j(int position) {
        LinearLayout linearLayout = (LinearLayout) findViewWithTag(this.k.get(position));
        if (linearLayout != null) {
            if (MiConfigSingleton.V3().I0()) {
                linearLayout.setBackgroundResource(com.martian.ttbookhd.R.drawable.border_search_background_night);
            } else {
                linearLayout.setBackgroundResource(com.martian.ttbookhd.R.drawable.border_search_background_day);
            }
            TextView textView = (TextView) linearLayout.findViewWithTag(Integer.valueOf(position));
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(getContext(), this.f14170e));
            }
        }
    }

    private void setTagItemData(List<TYCategoryTagItem> info) {
        int i2;
        if (info.isEmpty()) {
            return;
        }
        this.k = info;
        int b2 = com.martian.libmars.d.h.b(8.0f);
        int i3 = 1;
        LinearLayout b3 = b(1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.k.size(); i5++) {
            LinearLayout a2 = a(this.k.get(i5), i5);
            a2.measure(getMeasuredWidth(), getMeasuredHeight());
            int measuredWidth = a2.getMeasuredWidth();
            int i6 = (this.f14167b - i4) - measuredWidth;
            if (i6 >= 0) {
                if (i6 < com.martian.libmars.d.h.b(24.0f)) {
                    ((LinearLayout.LayoutParams) a2.getLayoutParams()).setMargins(0, 0, 0, 0);
                    i2 = 0;
                } else {
                    i2 = b2;
                }
                b3.addView(a2);
                i4 += measuredWidth + i2;
            } else {
                if (i3 >= this.f14175j) {
                    return;
                }
                i3++;
                b3 = b(i3);
                b3.addView(a2);
                i4 = measuredWidth + b2;
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public LinearLayout a(final TYCategoryTagItem tagInfo, final int position) {
        final LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag(tagInfo);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.martian.libmars.d.h.b(8.0f), 0);
        layoutParams.gravity = 16;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.ui.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return TagItemLayout.c(linearLayout, view, motionEvent);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TagItemLayout.this.e(position, tagInfo, view);
            }
        });
        if (tagInfo.getType() == 1) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(com.martian.ttbookhd.R.drawable.icon_hot_tag);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            int b2 = com.martian.libmars.d.h.b(16.0f);
            layoutParams2.width = b2;
            layoutParams2.height = b2;
            layoutParams2.gravity = 16;
            layoutParams2.setMargins(com.martian.libmars.d.h.b(8.0f), 0, com.martian.libmars.d.h.b(4.0f), 0);
            imageView.setLayoutParams(layoutParams2);
            linearLayout.addView(imageView);
        }
        TextView textView = new TextView(getContext());
        textView.setTag(Integer.valueOf(position));
        textView.setTextSize(0, this.f14168c);
        textView.setLines(1);
        textView.setPadding(tagInfo.getType() != 1 ? com.martian.libmars.d.h.b(this.f14172g) : 0, com.martian.libmars.d.h.b(this.f14171f), com.martian.libmars.d.h.b(this.f14174i), com.martian.libmars.d.h.b(this.f14173h));
        j(position);
        textView.setText(tagInfo.getName());
        linearLayout.addView(textView);
        return linearLayout;
    }

    public LinearLayout b(int lines) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, lines > 1 ? com.martian.libmars.d.h.b(12.0f) : 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        return linearLayout;
    }

    @Override // g.a
    public void g() {
        f();
    }

    public int getSelectPosition() {
        return this.f14166a;
    }

    public TYCategoryTagItem getSelectedItem() {
        if (this.f14166a >= this.k.size()) {
            return null;
        }
        return this.k.get(this.f14166a);
    }

    public void h() {
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

    public void setData(List<TYCategoryTagItem> info) {
        List<TYCategoryTagItem> list = this.k;
        if (list == null || list.isEmpty()) {
            setTagItemData(info);
        }
    }

    public void setOnItemTitleClickListener(a onItemTitleClickListener) {
        this.l = onItemTitleClickListener;
    }

    public void setSelectPosition(int mSelectPosition) {
        this.f14166a = mSelectPosition;
        f();
    }
}
