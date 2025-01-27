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
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import com.martian.mibook.ui.TagItemLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l9.u0;

/* loaded from: classes3.dex */
public class TagItemLayout extends LinearLayout implements k9.a {

    /* renamed from: b */
    public final int f15847b;

    /* renamed from: c */
    public final float f15848c;

    /* renamed from: d */
    public int f15849d;

    /* renamed from: e */
    public final int f15850e;

    /* renamed from: f */
    public List<TYCategoryTagItem> f15851f;

    /* renamed from: g */
    public a f15852g;

    public interface a {
        void a(TYCategoryTagItem tYCategoryTagItem, int i10);
    }

    public TagItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15849d = ConfigSingleton.D().h0();
        this.f15851f = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagItemLayout);
        this.f15848c = obtainStyledAttributes.getDimension(R.styleable.TagItemLayout_tagItemTextSize, 14.0f);
        this.f15850e = obtainStyledAttributes.getInteger(R.styleable.TagItemLayout_tagItemMaxLines, 100);
        this.f15847b = displayMetrics.widthPixels - ConfigSingleton.i(32.0f);
        setOrientation(1);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ boolean e(LinearLayout linearLayout, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            Iterator<View> it = u0.a(linearLayout).iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.6f);
            }
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        Iterator<View> it2 = u0.a(linearLayout).iterator();
        while (it2.hasNext()) {
            it2.next().setAlpha(1.0f);
        }
        return false;
    }

    private void g() {
        List<TYCategoryTagItem> list = this.f15851f;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f15849d = ConfigSingleton.D().h0();
        for (int i10 = 0; i10 < this.f15851f.size(); i10++) {
            h(i10);
        }
    }

    private void setTagItemData(List<TYCategoryTagItem> list) {
        int i10;
        if (list.isEmpty()) {
            return;
        }
        this.f15851f = list;
        int i11 = ConfigSingleton.i(8.0f);
        int i12 = 1;
        LinearLayout d10 = d(1);
        int i13 = 0;
        for (int i14 = 0; i14 < this.f15851f.size(); i14++) {
            LinearLayout c10 = c(this.f15851f.get(i14), i14);
            c10.measure(getMeasuredWidth(), getMeasuredHeight());
            int measuredWidth = c10.getMeasuredWidth();
            int i15 = (this.f15847b - i13) - measuredWidth;
            if (i15 >= 0) {
                if (i15 < ConfigSingleton.i(24.0f)) {
                    ((LinearLayout.LayoutParams) c10.getLayoutParams()).setMargins(0, 0, 0, 0);
                    i10 = 0;
                } else {
                    i10 = i11;
                }
                d10.addView(c10);
                i13 += measuredWidth + i10;
            } else {
                if (i12 >= this.f15850e) {
                    return;
                }
                i12++;
                d10 = d(i12);
                d10.addView(c10);
                i13 = measuredWidth + i11;
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public LinearLayout c(TYCategoryTagItem tYCategoryTagItem, int i10) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag(tYCategoryTagItem);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, ConfigSingleton.i(8.0f), 0);
        layoutParams.gravity = 16;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: be.n

            /* renamed from: b */
            public final /* synthetic */ LinearLayout f1597b;

            public /* synthetic */ n(LinearLayout linearLayout2) {
                linearLayout = linearLayout2;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean e10;
                e10 = TagItemLayout.e(linearLayout, view, motionEvent);
                return e10;
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: be.o

            /* renamed from: c */
            public final /* synthetic */ TYCategoryTagItem f1599c;

            /* renamed from: d */
            public final /* synthetic */ int f1600d;

            public /* synthetic */ o(TYCategoryTagItem tYCategoryTagItem2, int i102) {
                tYCategoryTagItem = tYCategoryTagItem2;
                i10 = i102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TagItemLayout.this.f(tYCategoryTagItem, i10, view);
            }
        });
        if (tYCategoryTagItem2.getType() == 1) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.icon_hot_tag);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            int i11 = ConfigSingleton.i(16.0f);
            layoutParams2.width = i11;
            layoutParams2.height = i11;
            layoutParams2.gravity = 16;
            layoutParams2.setMargins(ConfigSingleton.i(8.0f), 0, ConfigSingleton.i(4.0f), 0);
            imageView.setLayoutParams(layoutParams2);
            linearLayout2.addView(imageView);
        }
        TextView textView = new TextView(getContext());
        textView.setTag(Integer.valueOf(i102));
        textView.setTextSize(0, this.f15848c);
        textView.setLines(1);
        float f10 = 4;
        textView.setPadding(tYCategoryTagItem2.getType() != 1 ? ConfigSingleton.i(12) : 0, ConfigSingleton.i(f10), ConfigSingleton.i(12), ConfigSingleton.i(f10));
        h(i102);
        textView.setText(tYCategoryTagItem2.getName());
        linearLayout2.addView(textView);
        return linearLayout2;
    }

    public LinearLayout d(int i10) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i10 > 1 ? ConfigSingleton.i(12.0f) : 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        return linearLayout;
    }

    public final /* synthetic */ void f(TYCategoryTagItem tYCategoryTagItem, int i10, View view) {
        a aVar = this.f15852g;
        if (aVar != null) {
            aVar.a(tYCategoryTagItem, i10);
        }
    }

    public final void h(int i10) {
        LinearLayout linearLayout = (LinearLayout) findViewWithTag(this.f15851f.get(i10));
        if (linearLayout != null) {
            if (MiConfigSingleton.b2().A0()) {
                linearLayout.setBackgroundResource(com.martian.libmars.R.drawable.border_search_background_night);
            } else {
                linearLayout.setBackgroundResource(com.martian.libmars.R.drawable.border_search_background_day);
            }
            TextView textView = (TextView) linearLayout.findViewWithTag(Integer.valueOf(i10));
            if (textView != null) {
                textView.setTextColor(this.f15849d);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        g();
    }

    public void setData(List<TYCategoryTagItem> list) {
        List<TYCategoryTagItem> list2 = this.f15851f;
        if (list2 == null || list2.isEmpty()) {
            setTagItemData(list);
        }
    }

    public void setOnItemTitleClickListener(a aVar) {
        this.f15852g = aVar;
    }
}
