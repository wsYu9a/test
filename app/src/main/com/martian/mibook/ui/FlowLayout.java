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
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.ui.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FlowLayout extends LinearLayout implements k9.a {

    /* renamed from: b */
    public final int f15814b;

    /* renamed from: c */
    public int f15815c;

    /* renamed from: d */
    public final int f15816d;

    /* renamed from: e */
    public final float f15817e;

    /* renamed from: f */
    public final int f15818f;

    /* renamed from: g */
    public int f15819g;

    /* renamed from: h */
    public final boolean f15820h;

    /* renamed from: i */
    public final boolean f15821i;

    /* renamed from: j */
    public final int f15822j;

    /* renamed from: k */
    public final int f15823k;

    /* renamed from: l */
    public final int f15824l;

    /* renamed from: m */
    public final int f15825m;

    /* renamed from: n */
    public final int f15826n;

    /* renamed from: o */
    public final int f15827o;

    /* renamed from: p */
    public final int f15828p;

    /* renamed from: q */
    public final int f15829q;

    /* renamed from: r */
    public int f15830r;

    /* renamed from: s */
    public final int f15831s;

    /* renamed from: t */
    public int f15832t;

    /* renamed from: u */
    public boolean f15833u;

    /* renamed from: v */
    public List<String> f15834v;

    /* renamed from: w */
    public a f15835w;

    public interface a {
        void a(String str, int i10);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15814b = ConfigSingleton.i(26.0f);
        this.f15815c = 0;
        this.f15832t = 0;
        this.f15833u = true;
        this.f15834v = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SearchLayout);
        this.f15818f = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textColorType, 0);
        this.f15817e = obtainStyledAttributes.getDimension(R.styleable.SearchLayout_Sear_textSize, 0.0f);
        this.f15821i = obtainStyledAttributes.getBoolean(R.styleable.SearchLayout_Sear_selectableLayout, true);
        this.f15820h = obtainStyledAttributes.getBoolean(R.styleable.SearchLayout_Sear_allBackground, false);
        this.f15822j = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textPaddingTop, 4);
        this.f15823k = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textPaddingLeft, 12);
        this.f15824l = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textPaddingBottom, 4);
        this.f15825m = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textPaddingRight, 12);
        this.f15826n = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textMarginTop, 6);
        this.f15827o = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textMarginLeft, 4);
        this.f15828p = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textMarginBottom, 6);
        this.f15829q = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_textMarginRight, 4);
        this.f15830r = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_initLines, 100);
        this.f15831s = obtainStyledAttributes.getInteger(R.styleable.SearchLayout_Sear_maxLines, 100);
        this.f15816d = displayMetrics.widthPixels - ((int) obtainStyledAttributes.getDimension(R.styleable.SearchLayout_Sear_margin, 0.0f));
        setOrientation(1);
        m();
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ boolean f(ImageView imageView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            imageView.setAlpha(0.6f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        imageView.setAlpha(1.0f);
        return false;
    }

    private int getIconWidth() {
        return this.f15814b + ConfigSingleton.i(this.f15827o);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private ImageView getMoreIcon() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.icon_more);
        if (this.f15820h) {
            imageView.setBackgroundResource(ConfigSingleton.D().A0() ? R.drawable.border_search_background_night : R.drawable.border_search_background_day);
        }
        imageView.setColorFilter(ContextCompat.getColor(getContext(), this.f15819g));
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: be.g

            /* renamed from: b */
            public final /* synthetic */ ImageView f1579b;

            public /* synthetic */ g(ImageView imageView2) {
                imageView = imageView2;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f10;
                f10 = FlowLayout.f(imageView, view, motionEvent);
                return f10;
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: be.h

            /* renamed from: c */
            public final /* synthetic */ ImageView f1581c;

            public /* synthetic */ h(ImageView imageView2) {
                imageView = imageView2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlowLayout.this.g(imageView, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i10 = this.f15814b;
        layoutParams.width = i10;
        layoutParams.height = i10;
        int i11 = ConfigSingleton.i(6.0f);
        imageView2.setPadding(i11, i11, i11, i11);
        layoutParams.setMargins(ConfigSingleton.i(this.f15827o), ((((((((int) this.f15817e) + ConfigSingleton.i(4.0f)) + ConfigSingleton.i(this.f15822j)) + ConfigSingleton.i(this.f15824l)) + ConfigSingleton.i(this.f15826n)) + ConfigSingleton.i(this.f15828p)) - this.f15814b) / 2, 0, 0);
        imageView2.setLayoutParams(layoutParams);
        return imageView2;
    }

    public static /* synthetic */ boolean h(TextView textView, View view, MotionEvent motionEvent) {
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

    private void j() {
        List<String> list = this.f15834v;
        if (list == null || list.isEmpty()) {
            return;
        }
        m();
        for (int i10 = 0; i10 < this.f15834v.size(); i10++) {
            TextView textView = (TextView) findViewWithTag(Integer.valueOf(i10));
            if (textView != null) {
                n(textView, i10);
            }
        }
        ImageView imageView = (ImageView) findViewWithTag("more");
        if (imageView != null) {
            if (this.f15820h) {
                imageView.setBackgroundResource(ConfigSingleton.D().A0() ? R.drawable.border_search_background_night : R.drawable.border_search_background_day);
            }
            imageView.setColorFilter(ContextCompat.getColor(getContext(), this.f15819g));
        }
    }

    private void l(List<String> list, int i10) {
        if (list.isEmpty()) {
            return;
        }
        this.f15834v = list;
        LinearLayout linearLayout = getLinearLayout();
        int i11 = 1;
        int i12 = 0;
        while (i10 < this.f15834v.size()) {
            TextView e10 = e(this.f15834v.get(i10), i10);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) e10.getLayoutParams();
            e10.measure(getMeasuredWidth(), getMeasuredHeight());
            int measuredWidth = e10.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            i12 += measuredWidth;
            if (this.f15816d >= (i11 == this.f15830r ? getIconWidth() : 0) + i12) {
                linearLayout.addView(e10);
            } else {
                if (i11 >= this.f15831s) {
                    return;
                }
                if (i11 >= this.f15830r) {
                    ImageView moreIcon = getMoreIcon();
                    moreIcon.setTag("more");
                    linearLayout.addView(moreIcon);
                    this.f15832t = i10;
                    return;
                }
                i11++;
                linearLayout = getLinearLayout();
                linearLayout.addView(e10);
                i12 = measuredWidth;
            }
            i10++;
        }
    }

    private void m() {
        if (ConfigSingleton.D().A0()) {
            int i10 = this.f15818f;
            if (i10 == 1) {
                this.f15819g = R.color.night_text_color_secondary;
                return;
            } else if (i10 != 2) {
                this.f15819g = R.color.night_text_color_primary;
                return;
            } else {
                this.f15819g = R.color.night_text_color_thirdly;
                return;
            }
        }
        int i11 = this.f15818f;
        if (i11 == 1) {
            this.f15819g = R.color.day_text_color_secondary;
        } else if (i11 != 2) {
            this.f15819g = R.color.day_text_color_primary;
        } else {
            this.f15819g = R.color.day_text_color_thirdly;
        }
    }

    private void n(TextView textView, int i10) {
        if (this.f15820h) {
            if (MiConfigSingleton.b2().A0()) {
                textView.setBackgroundResource(R.drawable.border_search_background_night);
            } else {
                textView.setBackgroundResource(R.drawable.border_search_background_day);
            }
            textView.setTextColor(ContextCompat.getColor(getContext(), this.f15819g));
            return;
        }
        if (this.f15815c != i10) {
            textView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.transparent));
            textView.setTextColor(ContextCompat.getColor(getContext(), this.f15819g));
            return;
        }
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.theme_default));
        if (MiConfigSingleton.b2().A0()) {
            textView.setBackgroundResource(R.drawable.border_search_background_night);
        } else {
            textView.setBackgroundResource(R.drawable.border_search_background_day);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public TextView e(String str, int i10) {
        TextView textView = new TextView(getContext());
        textView.setTag(Integer.valueOf(i10));
        textView.setTextSize(0, this.f15817e);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(ConfigSingleton.i(this.f15823k), ConfigSingleton.i(this.f15822j), ConfigSingleton.i(this.f15825m), ConfigSingleton.i(this.f15824l));
        n(textView, i10);
        textView.setText(this.f15833u ? ConfigSingleton.D().s(str) : str);
        if (this.f15821i) {
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: be.i

                /* renamed from: b */
                public final /* synthetic */ TextView f1582b;

                public /* synthetic */ i(TextView textView2) {
                    textView = textView2;
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean h10;
                    h10 = FlowLayout.h(textView, view, motionEvent);
                    return h10;
                }
            });
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: be.j

            /* renamed from: c */
            public final /* synthetic */ int f1584c;

            /* renamed from: d */
            public final /* synthetic */ String f1585d;

            public /* synthetic */ j(int i102, String str2) {
                i10 = i102;
                str = str2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlowLayout.this.i(i10, str, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(ConfigSingleton.i(this.f15827o), ConfigSingleton.i(this.f15826n), ConfigSingleton.i(this.f15829q), ConfigSingleton.i(this.f15828p));
        textView2.setLayoutParams(layoutParams);
        return textView2;
    }

    public final /* synthetic */ void g(ImageView imageView, View view) {
        this.f15830r = 100;
        imageView.setVisibility(8);
        l(this.f15834v, this.f15832t);
    }

    public LinearLayout getLinearLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(linearLayout);
        return linearLayout;
    }

    public int getSelectPosition() {
        return this.f15815c;
    }

    public String getSelectedItem() {
        return this.f15815c >= this.f15834v.size() ? "" : this.f15834v.get(this.f15815c);
    }

    public final /* synthetic */ void i(int i10, String str, View view) {
        setSelectPosition(i10);
        if (this.f15835w != null) {
            this.f15835w.a(ConfigSingleton.D().f0(str), i10);
        }
    }

    public void k() {
        removeAllViews();
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
        j();
    }

    public void setConvertToTraditional(boolean z10) {
        this.f15833u = z10;
    }

    public void setData(List<String> list) {
        l(list, 0);
    }

    public void setOnItemTitleClickListener(a aVar) {
        this.f15835w = aVar;
    }

    public void setSelectPosition(int i10) {
        this.f15815c = i10;
        j();
    }
}
