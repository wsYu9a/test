package com.martian.libmars.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.martian.libmars.R;
import com.martian.libmars.widget.ExpandableTextView;

/* loaded from: classes3.dex */
public class ExpandableTextView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: r */
    public static final String f12557r = "ExpandableTextView";

    /* renamed from: s */
    public static final int f12558s = 8;

    /* renamed from: t */
    public static final int f12559t = 300;

    /* renamed from: u */
    public static final float f12560u = 0.7f;

    /* renamed from: b */
    public TextView f12561b;

    /* renamed from: c */
    public ImageButton f12562c;

    /* renamed from: d */
    public boolean f12563d;

    /* renamed from: e */
    public boolean f12564e;

    /* renamed from: f */
    public int f12565f;

    /* renamed from: g */
    public int f12566g;

    /* renamed from: h */
    public int f12567h;

    /* renamed from: i */
    public int f12568i;

    /* renamed from: j */
    public Drawable f12569j;

    /* renamed from: k */
    public Drawable f12570k;

    /* renamed from: l */
    public int f12571l;

    /* renamed from: m */
    public float f12572m;

    /* renamed from: n */
    public boolean f12573n;

    /* renamed from: o */
    public c f12574o;

    /* renamed from: p */
    public SparseBooleanArray f12575p;

    /* renamed from: q */
    public int f12576q;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ExpandableTextView.this.clearAnimation();
            ExpandableTextView.this.f12573n = false;
            if (ExpandableTextView.this.f12574o != null) {
                ExpandableTextView.this.f12574o.a(ExpandableTextView.this.f12561b, !r0.f12564e);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            ExpandableTextView.i(expandableTextView.f12561b, expandableTextView.f12572m);
        }
    }

    public class b extends Animation {

        /* renamed from: b */
        public final View f12578b;

        /* renamed from: c */
        public final int f12579c;

        /* renamed from: d */
        public final int f12580d;

        public b(View view, int i10, int i11) {
            this.f12578b = view;
            this.f12579c = i10;
            this.f12580d = i11;
            setDuration(ExpandableTextView.this.f12571l);
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            int i10 = this.f12580d;
            int i11 = (int) (((i10 - r0) * f10) + this.f12579c);
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.f12561b.setMaxHeight(i11 - expandableTextView.f12568i);
            if (Float.compare(ExpandableTextView.this.f12572m, 1.0f) != 0) {
                ExpandableTextView expandableTextView2 = ExpandableTextView.this;
                ExpandableTextView.i(expandableTextView2.f12561b, expandableTextView2.f12572m + (f10 * (1.0f - ExpandableTextView.this.f12572m)));
            }
            this.f12578b.getLayoutParams().height = i11;
            this.f12578b.requestLayout();
        }

        @Override // android.view.animation.Animation
        public void initialize(int i10, int i11, int i12, int i13) {
            super.initialize(i10, i11, i12, i13);
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public interface c {
        void a(TextView textView, boolean z10);
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public static void i(View view, float f10) {
        view.setAlpha(f10);
    }

    public static Drawable k(@NonNull Context context, @DrawableRes int i10) {
        return context.getResources().getDrawable(i10, context.getTheme());
    }

    public static int l(@NonNull TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    @Nullable
    public CharSequence getText() {
        TextView textView = this.f12561b;
        return textView == null ? "" : textView.getText();
    }

    public final void j() {
        TextView textView = (TextView) findViewById(R.id.expandable_text);
        this.f12561b = textView;
        textView.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.expand_collapse);
        this.f12562c = imageButton;
        imageButton.setImageDrawable(this.f12564e ? this.f12569j : this.f12570k);
        this.f12562c.setOnClickListener(this);
    }

    public final void m(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView);
        this.f12567h = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_maxCollapsedLines, 8);
        this.f12571l = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_animDuration, 300);
        this.f12572m = obtainStyledAttributes.getFloat(R.styleable.ExpandableTextView_animAlphaStart, 0.7f);
        this.f12569j = obtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_expandDrawable);
        this.f12570k = obtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_collapseDrawable);
        obtainStyledAttributes.recycle();
        setVisibility(8);
    }

    public final /* synthetic */ void n() {
        this.f12568i = getHeight() - this.f12561b.getHeight();
    }

    public void o(@Nullable CharSequence charSequence, @NonNull SparseBooleanArray sparseBooleanArray, int i10) {
        this.f12575p = sparseBooleanArray;
        this.f12576q = i10;
        boolean z10 = sparseBooleanArray.get(i10, true);
        clearAnimation();
        this.f12564e = z10;
        this.f12562c.setImageDrawable(z10 ? this.f12569j : this.f12570k);
        setText(charSequence);
        getLayoutParams().height = -2;
        requestLayout();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f12562c.getVisibility() != 0) {
            return;
        }
        boolean z10 = !this.f12564e;
        this.f12564e = z10;
        this.f12562c.setImageDrawable(z10 ? this.f12569j : this.f12570k);
        SparseBooleanArray sparseBooleanArray = this.f12575p;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(this.f12576q, this.f12564e);
        }
        this.f12573n = true;
        b bVar = this.f12564e ? new b(this, getHeight(), this.f12565f) : new b(this, getHeight(), (getHeight() + this.f12566g) - this.f12561b.getHeight());
        bVar.setFillAfter(true);
        bVar.setAnimationListener(new a());
        clearAnimation();
        startAnimation(bVar);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        j();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f12573n;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!this.f12563d || getVisibility() == 8) {
            super.onMeasure(i10, i11);
            return;
        }
        this.f12563d = false;
        this.f12562c.setVisibility(8);
        this.f12561b.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i10, i11);
        if (this.f12561b.getLineCount() <= this.f12567h) {
            return;
        }
        this.f12566g = l(this.f12561b);
        if (this.f12564e) {
            this.f12561b.setMaxLines(this.f12567h);
        }
        this.f12562c.setVisibility(0);
        super.onMeasure(i10, i11);
        if (this.f12564e) {
            this.f12561b.post(new Runnable() { // from class: n9.e
                public /* synthetic */ e() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ExpandableTextView.this.n();
                }
            });
            this.f12565f = getMeasuredHeight();
        }
    }

    public void setOnExpandStateChangeListener(@Nullable c cVar) {
        this.f12574o = cVar;
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.f12563d = true;
        this.f12561b.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12564e = true;
        m(attributeSet);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12564e = true;
        m(attributeSet);
    }
}
