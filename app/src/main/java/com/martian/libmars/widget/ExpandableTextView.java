package com.martian.libmars.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
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

/* loaded from: classes2.dex */
public class ExpandableTextView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private static final String f10321a = ExpandableTextView.class.getSimpleName();

    /* renamed from: b */
    private static final int f10322b = 8;

    /* renamed from: c */
    private static final int f10323c = 300;

    /* renamed from: d */
    private static final float f10324d = 0.7f;

    /* renamed from: e */
    protected TextView f10325e;

    /* renamed from: f */
    protected ImageButton f10326f;

    /* renamed from: g */
    private boolean f10327g;

    /* renamed from: h */
    private boolean f10328h;

    /* renamed from: i */
    private int f10329i;

    /* renamed from: j */
    private int f10330j;
    private int k;
    private int l;
    private Drawable m;
    private Drawable n;
    private int o;
    private float p;
    private boolean q;
    private c r;
    private SparseBooleanArray s;
    private int t;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ExpandableTextView.this.clearAnimation();
            ExpandableTextView.this.q = false;
            if (ExpandableTextView.this.r != null) {
                ExpandableTextView.this.r.a(ExpandableTextView.this.f10325e, !r0.f10328h);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            ExpandableTextView.h(expandableTextView.f10325e, expandableTextView.p);
        }
    }

    class b extends Animation {

        /* renamed from: a */
        private final View f10332a;

        /* renamed from: b */
        private final int f10333b;

        /* renamed from: c */
        private final int f10334c;

        public b(View view, int startHeight, int endHeight) {
            this.f10332a = view;
            this.f10333b = startHeight;
            this.f10334c = endHeight;
            setDuration(ExpandableTextView.this.o);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            int i2 = this.f10334c;
            int i3 = (int) (((i2 - r0) * interpolatedTime) + this.f10333b);
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.f10325e.setMaxHeight(i3 - expandableTextView.l);
            if (Float.compare(ExpandableTextView.this.p, 1.0f) != 0) {
                ExpandableTextView expandableTextView2 = ExpandableTextView.this;
                ExpandableTextView.h(expandableTextView2.f10325e, expandableTextView2.p + (interpolatedTime * (1.0f - ExpandableTextView.this.p)));
            }
            this.f10332a.getLayoutParams().height = i3;
            this.f10332a.requestLayout();
        }

        @Override // android.view.animation.Animation
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public interface c {
        void a(TextView textView, boolean isExpanded);
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    @TargetApi(11)
    public static void h(View view, float alpha) {
        view.setAlpha(alpha);
    }

    private void i() {
        TextView textView = (TextView) findViewById(R.id.expandable_text);
        this.f10325e = textView;
        textView.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.expand_collapse);
        this.f10326f = imageButton;
        imageButton.setImageDrawable(this.f10328h ? this.m : this.n);
        this.f10326f.setOnClickListener(this);
    }

    @TargetApi(21)
    private static Drawable j(@NonNull Context context, @DrawableRes int resId) {
        Resources resources = context.getResources();
        return m() ? resources.getDrawable(resId, context.getTheme()) : resources.getDrawable(resId);
    }

    private static int k(@NonNull TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    private void l(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
        this.k = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_maxCollapsedLines, 8);
        this.o = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_animDuration, 300);
        this.p = obtainStyledAttributes.getFloat(R.styleable.ExpandableTextView_animAlphaStart, f10324d);
        this.m = obtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_expandDrawable);
        this.n = obtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_collapseDrawable);
        obtainStyledAttributes.recycle();
        setVisibility(8);
    }

    private static boolean m() {
        return com.martian.libsupport.l.r();
    }

    /* renamed from: n */
    public /* synthetic */ void o() {
        this.l = getHeight() - this.f10325e.getHeight();
    }

    @Nullable
    public CharSequence getText() {
        TextView textView = this.f10325e;
        return textView == null ? "" : textView.getText();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f10326f.getVisibility() != 0) {
            return;
        }
        boolean z = !this.f10328h;
        this.f10328h = z;
        this.f10326f.setImageDrawable(z ? this.m : this.n);
        SparseBooleanArray sparseBooleanArray = this.s;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(this.t, this.f10328h);
        }
        this.q = true;
        b bVar = this.f10328h ? new b(this, getHeight(), this.f10329i) : new b(this, getHeight(), (getHeight() + this.f10330j) - this.f10325e.getHeight());
        bVar.setFillAfter(true);
        bVar.setAnimationListener(new a());
        clearAnimation();
        startAnimation(bVar);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        i();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.q;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!this.f10327g || getVisibility() == 8) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        this.f10327g = false;
        this.f10326f.setVisibility(8);
        this.f10325e.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f10325e.getLineCount() <= this.k) {
            return;
        }
        this.f10330j = k(this.f10325e);
        if (this.f10328h) {
            this.f10325e.setMaxLines(this.k);
        }
        this.f10326f.setVisibility(0);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f10328h) {
            this.f10325e.post(new Runnable() { // from class: com.martian.libmars.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandableTextView.this.o();
                }
            });
            this.f10329i = getMeasuredHeight();
        }
    }

    public void p(@Nullable CharSequence text, @NonNull SparseBooleanArray collapsedStatus, int position) {
        this.s = collapsedStatus;
        this.t = position;
        boolean z = collapsedStatus.get(position, true);
        clearAnimation();
        this.f10328h = z;
        this.f10326f.setImageDrawable(z ? this.m : this.n);
        setText(text);
        getLayoutParams().height = -2;
        requestLayout();
    }

    public void setOnExpandStateChangeListener(@Nullable c listener) {
        this.r = listener;
    }

    public void setText(@Nullable CharSequence text) {
        this.f10327g = true;
        this.f10325e.setText(text);
        setVisibility(TextUtils.isEmpty(text) ? 8 : 0);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10328h = true;
        l(attrs);
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10328h = true;
        l(attrs);
    }
}
