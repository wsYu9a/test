package uk.co.senab.actionbarpulltorefresh.library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

/* loaded from: classes5.dex */
public class c extends e {

    /* renamed from: a */
    public static final int f37145a = 0;

    /* renamed from: b */
    public static final int f37146b = 1;

    /* renamed from: c */
    private View f37147c;

    /* renamed from: d */
    private ViewGroup f37148d;

    /* renamed from: e */
    private TextView f37149e;

    /* renamed from: f */
    private SmoothProgressBar f37150f;

    /* renamed from: g */
    private CharSequence f37151g;

    /* renamed from: h */
    private CharSequence f37152h;

    /* renamed from: i */
    private CharSequence f37153i;

    /* renamed from: j */
    private int f37154j;
    private long k;
    private int l;
    private int m = -2;
    private final Interpolator n = new AccelerateInterpolator();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View o = c.this.o();
            if (o != null) {
                o.setVisibility(8);
            }
            c.this.g();
        }
    }

    protected c() {
        int p = p();
        if (Build.VERSION.SDK_INT >= p) {
            return;
        }
        throw new IllegalStateException("This HeaderTransformer is designed to run on SDK " + p + "+. If using ActionBarSherlock or ActionBarCompat you should use the appropriate provided extra.");
    }

    private void j() {
        if (this.f37150f != null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RectShape());
            shapeDrawable.getPaint().setColor(this.f37154j);
            this.f37150f.setProgressDrawable(new ClipDrawable(shapeDrawable, 17, 1));
        }
    }

    private void k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.m);
        int i2 = this.l;
        if (i2 == 0) {
            layoutParams.addRule(8, R.id.ptr_content);
        } else if (i2 == 1) {
            layoutParams.addRule(3, R.id.ptr_content);
        }
        this.f37150f.setLayoutParams(layoutParams);
    }

    protected static TypedArray q(Context context, int i2, int[] iArr) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return context.obtainStyledAttributes(typedValue.resourceId, iArr);
    }

    private void x(Activity activity, View view) {
        int resourceId;
        TypedArray q = q(activity, R.attr.ptrHeaderStyle, R.styleable.PullToRefreshHeader);
        if (this.f37148d != null) {
            this.f37148d.getLayoutParams().height = q.getDimensionPixelSize(1, m(activity));
            this.f37148d.requestLayout();
        }
        Drawable drawable = q.hasValue(0) ? q.getDrawable(0) : l(activity);
        if (drawable != null) {
            this.f37149e.setBackgroundDrawable(drawable);
            if (this.f37148d != null && drawable.getOpacity() == -1) {
                this.f37148d.setBackgroundResource(0);
            }
        }
        Context context = view.getContext();
        int resourceId2 = q.getResourceId(2, n(context));
        if (resourceId2 != 0) {
            this.f37149e.setTextAppearance(context, resourceId2);
        }
        if (q.hasValue(3)) {
            this.f37154j = q.getColor(3, this.f37154j);
        }
        this.l = q.getInt(4, 1);
        if (q.hasValue(5)) {
            this.m = q.getDimensionPixelSize(5, this.m);
        }
        if (q.hasValue(6)) {
            this.f37151g = q.getString(6);
        }
        if (q.hasValue(7)) {
            this.f37152h = q.getString(7);
        }
        if (q.hasValue(8)) {
            this.f37153i = q.getString(8);
        }
        if (q.hasValue(9) && (resourceId = q.getResourceId(9, 0)) != 0) {
            this.f37150f.a(resourceId);
        }
        q.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public boolean a() {
        ObjectAnimator objectAnimator;
        boolean z = this.f37147c.getVisibility() != 8;
        if (z) {
            if (this.f37148d.getAlpha() >= 0.5f) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.f37148d, "translationY", 0.0f, -r4.getHeight()), ObjectAnimator.ofFloat(this.f37147c, "alpha", 1.0f, 0.0f));
                objectAnimator = animatorSet;
            } else {
                objectAnimator = ObjectAnimator.ofFloat(this.f37147c, "alpha", 1.0f, 0.0f);
            }
            objectAnimator.setDuration(this.k);
            objectAnimator.addListener(new a());
            objectAnimator.start();
        }
        return z;
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public void b(Activity activity, Configuration configuration) {
        x(activity, o());
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public void c(float f2) {
        SmoothProgressBar smoothProgressBar = this.f37150f;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            float interpolation = this.n.getInterpolation(f2);
            this.f37150f.setProgress(Math.round(r0.getMax() * interpolation));
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public void d() {
        ViewGroup viewGroup = this.f37148d;
        if (viewGroup != null) {
            ObjectAnimator.ofFloat(viewGroup, "alpha", 1.0f, 0.0f).start();
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public void e() {
        TextView textView = this.f37149e;
        if (textView != null) {
            textView.setText(this.f37152h);
        }
        SmoothProgressBar smoothProgressBar = this.f37150f;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            this.f37150f.setIndeterminate(true);
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public void f() {
        TextView textView = this.f37149e;
        if (textView != null) {
            textView.setText(this.f37153i);
        }
        SmoothProgressBar smoothProgressBar = this.f37150f;
        if (smoothProgressBar != null) {
            smoothProgressBar.setProgress(smoothProgressBar.getMax());
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public void g() {
        SmoothProgressBar smoothProgressBar = this.f37150f;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            this.f37150f.setProgress(0);
            this.f37150f.setIndeterminate(false);
        }
        TextView textView = this.f37149e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f37149e.setText(this.f37151g);
        }
        ViewGroup viewGroup = this.f37148d;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            uk.co.senab.actionbarpulltorefresh.library.j.a.b(this.f37148d, 1.0f);
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public void h(Activity activity, View view) {
        this.f37147c = view;
        this.f37150f = (SmoothProgressBar) view.findViewById(R.id.ptr_progress);
        this.f37149e = (TextView) view.findViewById(R.id.ptr_text);
        this.f37148d = (ViewGroup) view.findViewById(R.id.ptr_content);
        this.f37151g = activity.getString(R.string.pull_to_refresh_pull_label);
        this.f37152h = activity.getString(R.string.pull_to_refresh_refreshing_label);
        this.f37153i = activity.getString(R.string.pull_to_refresh_release_label);
        this.k = activity.getResources().getInteger(android.R.integer.config_shortAnimTime);
        this.f37154j = activity.getResources().getColor(R.color.default_progress_bar_color);
        x(activity, view);
        k();
        j();
        g();
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.e
    public boolean i() {
        boolean z = this.f37147c.getVisibility() != 0;
        if (z) {
            this.f37147c.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.f37148d, "translationY", -r4.getHeight(), 0.0f), ObjectAnimator.ofFloat(this.f37147c, "alpha", 0.0f, 1.0f));
            animatorSet.setDuration(this.k);
            animatorSet.start();
        }
        return z;
    }

    protected Drawable l(Context context) {
        TypedArray q = q(context, android.R.attr.actionBarStyle, new int[]{android.R.attr.background});
        try {
            return q.getDrawable(0);
        } finally {
            q.recycle();
        }
    }

    protected int m(Context context) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        try {
            return obtainStyledAttributes.getDimensionPixelSize(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected int n(Context context) {
        TypedArray q = q(context, android.R.attr.actionBarStyle, new int[]{android.R.attr.titleTextStyle});
        try {
            return q.getResourceId(0, 0);
        } finally {
            q.recycle();
        }
    }

    public View o() {
        return this.f37147c;
    }

    protected int p() {
        return 14;
    }

    public void r(int i2) {
        if (i2 != this.f37154j) {
            this.f37154j = i2;
            this.f37150f.setSmoothProgressDrawableColor(i2);
            j();
        }
    }

    public void s(int i2) {
        if (this.m != i2) {
            this.m = i2;
            k();
        }
    }

    public void t(int i2) {
        if (this.l != i2) {
            this.l = i2;
            k();
        }
    }

    public void u(CharSequence charSequence) {
        this.f37151g = charSequence;
        TextView textView = this.f37149e;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void v(CharSequence charSequence) {
        this.f37152h = charSequence;
    }

    public void w(CharSequence charSequence) {
        this.f37153i = charSequence;
    }
}
