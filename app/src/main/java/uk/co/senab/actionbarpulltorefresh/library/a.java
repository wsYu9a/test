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
import uk.d;

/* loaded from: classes5.dex */
public class a extends d {

    /* renamed from: m */
    public static final int f31148m = 0;

    /* renamed from: n */
    public static final int f31149n = 1;

    /* renamed from: a */
    public View f31150a;

    /* renamed from: b */
    public ViewGroup f31151b;

    /* renamed from: c */
    public TextView f31152c;

    /* renamed from: d */
    public SmoothProgressBar f31153d;

    /* renamed from: e */
    public CharSequence f31154e;

    /* renamed from: f */
    public CharSequence f31155f;

    /* renamed from: g */
    public CharSequence f31156g;

    /* renamed from: h */
    public int f31157h;

    /* renamed from: i */
    public long f31158i;

    /* renamed from: j */
    public int f31159j;

    /* renamed from: k */
    public int f31160k = -2;

    /* renamed from: l */
    public final Interpolator f31161l = new AccelerateInterpolator();

    /* renamed from: uk.co.senab.actionbarpulltorefresh.library.a$a */
    public class C0794a extends AnimatorListenerAdapter {
        public C0794a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View o10 = a.this.o();
            if (o10 != null) {
                o10.setVisibility(8);
            }
            a.this.g();
        }
    }

    public a() {
        int p10 = p();
        if (Build.VERSION.SDK_INT >= p10) {
            return;
        }
        throw new IllegalStateException("This HeaderTransformer is designed to run on SDK " + p10 + "+. If using ActionBarSherlock or ActionBarCompat you should use the appropriate provided extra.");
    }

    public static TypedArray q(Context context, int i10, int[] iArr) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        return context.obtainStyledAttributes(typedValue.resourceId, iArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // uk.d
    public boolean a() {
        ObjectAnimator objectAnimator;
        boolean z10 = this.f31150a.getVisibility() != 8;
        if (z10) {
            if (this.f31151b.getAlpha() >= 0.5f) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.f31151b, "translationY", 0.0f, -r5.getHeight()), ObjectAnimator.ofFloat(this.f31150a, "alpha", 1.0f, 0.0f));
                objectAnimator = animatorSet;
            } else {
                objectAnimator = ObjectAnimator.ofFloat(this.f31150a, "alpha", 1.0f, 0.0f);
            }
            objectAnimator.setDuration(this.f31158i);
            objectAnimator.addListener(new C0794a());
            objectAnimator.start();
        }
        return z10;
    }

    @Override // uk.d
    public void b(Activity activity, Configuration configuration) {
        x(activity, o());
    }

    @Override // uk.d
    public void c(float f10) {
        SmoothProgressBar smoothProgressBar = this.f31153d;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            float interpolation = this.f31161l.getInterpolation(f10);
            this.f31153d.setProgress(Math.round(r0.getMax() * interpolation));
        }
    }

    @Override // uk.d
    public void d() {
        ViewGroup viewGroup = this.f31151b;
        if (viewGroup != null) {
            ObjectAnimator.ofFloat(viewGroup, "alpha", 1.0f, 0.0f).start();
        }
    }

    @Override // uk.d
    public void e() {
        TextView textView = this.f31152c;
        if (textView != null) {
            textView.setText(this.f31155f);
        }
        SmoothProgressBar smoothProgressBar = this.f31153d;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            this.f31153d.setIndeterminate(true);
        }
    }

    @Override // uk.d
    public void f() {
        TextView textView = this.f31152c;
        if (textView != null) {
            textView.setText(this.f31156g);
        }
        SmoothProgressBar smoothProgressBar = this.f31153d;
        if (smoothProgressBar != null) {
            smoothProgressBar.setProgress(smoothProgressBar.getMax());
        }
    }

    @Override // uk.d
    public void g() {
        SmoothProgressBar smoothProgressBar = this.f31153d;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            this.f31153d.setProgress(0);
            this.f31153d.setIndeterminate(false);
        }
        TextView textView = this.f31152c;
        if (textView != null) {
            textView.setVisibility(0);
            this.f31152c.setText(this.f31154e);
        }
        ViewGroup viewGroup = this.f31151b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            wk.a.b(this.f31151b, 1.0f);
        }
    }

    @Override // uk.d
    public void h(Activity activity, View view) {
        this.f31150a = view;
        this.f31153d = (SmoothProgressBar) view.findViewById(R.id.ptr_progress);
        this.f31152c = (TextView) view.findViewById(R.id.ptr_text);
        this.f31151b = (ViewGroup) view.findViewById(R.id.ptr_content);
        this.f31154e = activity.getString(R.string.pull_to_refresh_pull_label);
        this.f31155f = activity.getString(R.string.pull_to_refresh_refreshing_label);
        this.f31156g = activity.getString(R.string.pull_to_refresh_release_label);
        this.f31158i = activity.getResources().getInteger(android.R.integer.config_shortAnimTime);
        this.f31157h = activity.getResources().getColor(R.color.default_progress_bar_color);
        x(activity, view);
        k();
        j();
        g();
    }

    @Override // uk.d
    public boolean i() {
        boolean z10 = this.f31150a.getVisibility() != 0;
        if (z10) {
            this.f31150a.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.f31151b, "translationY", -r5.getHeight(), 0.0f), ObjectAnimator.ofFloat(this.f31150a, "alpha", 0.0f, 1.0f));
            animatorSet.setDuration(this.f31158i);
            animatorSet.start();
        }
        return z10;
    }

    public final void j() {
        if (this.f31153d != null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RectShape());
            shapeDrawable.getPaint().setColor(this.f31157h);
            this.f31153d.setProgressDrawable(new ClipDrawable(shapeDrawable, 17, 1));
        }
    }

    public final void k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f31160k);
        int i10 = this.f31159j;
        if (i10 == 0) {
            layoutParams.addRule(8, R.id.ptr_content);
        } else if (i10 == 1) {
            layoutParams.addRule(3, R.id.ptr_content);
        }
        this.f31153d.setLayoutParams(layoutParams);
    }

    public Drawable l(Context context) {
        TypedArray q10 = q(context, android.R.attr.actionBarStyle, new int[]{android.R.attr.background});
        try {
            return q10.getDrawable(0);
        } finally {
            q10.recycle();
        }
    }

    public int m(Context context) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        try {
            return obtainStyledAttributes.getDimensionPixelSize(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public int n(Context context) {
        TypedArray q10 = q(context, android.R.attr.actionBarStyle, new int[]{android.R.attr.titleTextStyle});
        try {
            return q10.getResourceId(0, 0);
        } finally {
            q10.recycle();
        }
    }

    public View o() {
        return this.f31150a;
    }

    public int p() {
        return 14;
    }

    public void r(int i10) {
        if (i10 != this.f31157h) {
            this.f31157h = i10;
            this.f31153d.setSmoothProgressDrawableColor(i10);
            j();
        }
    }

    public void s(int i10) {
        if (this.f31160k != i10) {
            this.f31160k = i10;
            k();
        }
    }

    public void t(int i10) {
        if (this.f31159j != i10) {
            this.f31159j = i10;
            k();
        }
    }

    public void u(CharSequence charSequence) {
        this.f31154e = charSequence;
        TextView textView = this.f31152c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void v(CharSequence charSequence) {
        this.f31155f = charSequence;
    }

    public void w(CharSequence charSequence) {
        this.f31156g = charSequence;
    }

    public final void x(Activity activity, View view) {
        int resourceId;
        TypedArray q10 = q(activity, R.attr.ptrHeaderStyle, R.styleable.PullToRefreshHeader);
        if (this.f31151b != null) {
            this.f31151b.getLayoutParams().height = q10.getDimensionPixelSize(1, m(activity));
            this.f31151b.requestLayout();
        }
        Drawable drawable = q10.hasValue(0) ? q10.getDrawable(0) : l(activity);
        if (drawable != null) {
            this.f31152c.setBackgroundDrawable(drawable);
            if (this.f31151b != null && drawable.getOpacity() == -1) {
                this.f31151b.setBackgroundResource(0);
            }
        }
        Context context = view.getContext();
        int resourceId2 = q10.getResourceId(2, n(context));
        if (resourceId2 != 0) {
            this.f31152c.setTextAppearance(context, resourceId2);
        }
        if (q10.hasValue(3)) {
            this.f31157h = q10.getColor(3, this.f31157h);
        }
        this.f31159j = q10.getInt(4, 1);
        if (q10.hasValue(5)) {
            this.f31160k = q10.getDimensionPixelSize(5, this.f31160k);
        }
        if (q10.hasValue(6)) {
            this.f31154e = q10.getString(6);
        }
        if (q10.hasValue(7)) {
            this.f31155f = q10.getString(7);
        }
        if (q10.hasValue(8)) {
            this.f31156g = q10.getString(8);
        }
        if (q10.hasValue(9) && (resourceId = q10.getResourceId(9, 0)) != 0) {
            this.f31153d.a(resourceId);
        }
        q10.recycle();
    }
}
