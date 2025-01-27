package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.j.o;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class d extends com.google.android.material.textfield.e {

    /* renamed from: d */
    private static final boolean f7918d;

    /* renamed from: e */
    private static final int f7919e = 50;

    /* renamed from: f */
    private static final int f7920f = 67;

    /* renamed from: g */
    private final TextWatcher f7921g;

    /* renamed from: h */
    private final View.OnFocusChangeListener f7922h;

    /* renamed from: i */
    private final TextInputLayout.e f7923i;

    /* renamed from: j */
    private final TextInputLayout.h f7924j;

    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.i k;
    private boolean l;
    private boolean m;
    private long n;
    private StateListDrawable o;
    private com.google.android.material.j.j p;

    @Nullable
    private AccessibilityManager q;
    private ValueAnimator r;
    private ValueAnimator s;

    class a implements TextWatcher {

        /* renamed from: com.google.android.material.textfield.d$a$a */
        class RunnableC0102a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ AutoCompleteTextView f7926a;

            RunnableC0102a(AutoCompleteTextView autoCompleteTextView) {
                this.f7926a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f7926a.isPopupShowing();
                d.this.C(isPopupShowing);
                d.this.l = isPopupShowing;
            }
        }

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d dVar = d.this;
            AutoCompleteTextView x = dVar.x(dVar.f7938a.getEditText());
            x.post(new RunnableC0102a(x));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            d.this.f7940c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            d.this.f7938a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.C(false);
            d.this.l = false;
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d */
    class C0103d extends TextInputLayout.e {
        C0103d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (d.this.f7938a.getEditText().getKeyListener() == null) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            d dVar = d.this;
            AutoCompleteTextView x = dVar.x(dVar.f7938a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.q.isTouchExplorationEnabled()) {
                d.this.F(x);
            }
        }
    }

    class e implements TextInputLayout.h {
        e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView x = d.this.x(textInputLayout.getEditText());
            d.this.D(x);
            d.this.u(x);
            d.this.E(x);
            x.setThreshold(0);
            x.removeTextChangedListener(d.this.f7921g);
            x.addTextChangedListener(d.this.f7921g);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f7923i);
            textInputLayout.setEndIconVisible(true);
        }
    }

    class f implements TextInputLayout.i {
        f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i2 != 3) {
                return;
            }
            autoCompleteTextView.removeTextChangedListener(d.this.f7921g);
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f7922h) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.f7918d) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.F((AutoCompleteTextView) d.this.f7938a.getEditText());
        }
    }

    class h implements View.OnTouchListener {

        /* renamed from: a */
        final /* synthetic */ AutoCompleteTextView f7934a;

        h(AutoCompleteTextView autoCompleteTextView) {
            this.f7934a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.B()) {
                    d.this.l = false;
                }
                d.this.F(this.f7934a);
            }
            return false;
        }
    }

    class i implements AutoCompleteTextView.OnDismissListener {
        i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.l = true;
            d.this.n = System.currentTimeMillis();
            d.this.C(false);
        }
    }

    class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f7940c.setChecked(dVar.m);
            d.this.s.start();
        }
    }

    static {
        f7918d = Build.VERSION.SDK_INT >= 21;
    }

    d(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f7921g = new a();
        this.f7922h = new c();
        this.f7923i = new C0103d(this.f7938a);
        this.f7924j = new e();
        this.k = new f();
        this.l = false;
        this.m = false;
        this.n = Long.MAX_VALUE;
    }

    private void A() {
        this.s = y(67, 0.0f, 1.0f);
        ValueAnimator y = y(50, 1.0f, 0.0f);
        this.r = y;
        y.addListener(new j());
    }

    public boolean B() {
        long currentTimeMillis = System.currentTimeMillis() - this.n;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    public void C(boolean z) {
        if (this.m != z) {
            this.m = z;
            this.s.cancel();
            this.r.start();
        }
    }

    public void D(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (f7918d) {
            int boxBackgroundMode = this.f7938a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.p);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.o);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void E(@NonNull AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f7922h);
        if (f7918d) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    public void F(@Nullable AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (B()) {
            this.l = false;
        }
        if (this.l) {
            this.l = false;
            return;
        }
        if (f7918d) {
            C(!this.m);
        } else {
            this.m = !this.m;
            this.f7940c.toggle();
        }
        if (!this.m) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    public void u(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.f7938a.getBoxBackgroundMode();
        com.google.android.material.j.j boxBackground = this.f7938a.getBoxBackground();
        int d2 = com.google.android.material.c.a.d(autoCompleteTextView, R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            w(autoCompleteTextView, d2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            v(autoCompleteTextView, d2, iArr, boxBackground);
        }
    }

    private void v(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull com.google.android.material.j.j jVar) {
        int boxBackgroundColor = this.f7938a.getBoxBackgroundColor();
        int[] iArr2 = {com.google.android.material.c.a.g(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f7918d) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), jVar, jVar));
            return;
        }
        com.google.android.material.j.j jVar2 = new com.google.android.material.j.j(jVar.getShapeAppearanceModel());
        jVar2.n0(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{jVar, jVar2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private void w(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull com.google.android.material.j.j jVar) {
        LayerDrawable layerDrawable;
        int d2 = com.google.android.material.c.a.d(autoCompleteTextView, R.attr.colorSurface);
        com.google.android.material.j.j jVar2 = new com.google.android.material.j.j(jVar.getShapeAppearanceModel());
        int g2 = com.google.android.material.c.a.g(i2, d2, 0.1f);
        jVar2.n0(new ColorStateList(iArr, new int[]{g2, 0}));
        if (f7918d) {
            jVar2.setTint(d2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{g2, d2});
            com.google.android.material.j.j jVar3 = new com.google.android.material.j.j(jVar.getShapeAppearanceModel());
            jVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar2, jVar3), jVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{jVar2, jVar});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    @NonNull
    public AutoCompleteTextView x(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator y(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.a.a.f6607a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private com.google.android.material.j.j z(float f2, float f3, float f4, int i2) {
        o m = o.a().K(f2).P(f2).x(f3).C(f3).m();
        com.google.android.material.j.j n = com.google.android.material.j.j.n(this.f7939b, f4);
        n.setShapeAppearanceModel(m);
        n.p0(0, i2, 0, i2);
        return n;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        float dimensionPixelOffset = this.f7939b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f7939b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f7939b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        com.google.android.material.j.j z = z(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        com.google.android.material.j.j z2 = z(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.p = z;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.o = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, z);
        this.o.addState(new int[0], z2);
        this.f7938a.setEndIconDrawable(AppCompatResources.getDrawable(this.f7939b, f7918d ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f7938a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f7938a.setEndIconOnClickListener(new g());
        this.f7938a.e(this.f7924j);
        this.f7938a.f(this.k);
        A();
        ViewCompat.setImportantForAccessibility(this.f7940c, 2);
        this.q = (AccessibilityManager) this.f7939b.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.e
    boolean b(int i2) {
        return i2 != 0;
    }

    @Override // com.google.android.material.textfield.e
    boolean d() {
        return true;
    }
}
