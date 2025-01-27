package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class a extends com.google.android.material.textfield.e {

    /* renamed from: d */
    private static final int f7902d = 100;

    /* renamed from: e */
    private static final int f7903e = 150;

    /* renamed from: f */
    private static final float f7904f = 0.8f;

    /* renamed from: g */
    private final TextWatcher f7905g;

    /* renamed from: h */
    private final View.OnFocusChangeListener f7906h;

    /* renamed from: i */
    private final TextInputLayout.h f7907i;

    /* renamed from: j */
    private final TextInputLayout.i f7908j;
    private AnimatorSet k;
    private ValueAnimator l;

    /* renamed from: com.google.android.material.textfield.a$a */
    class C0101a implements TextWatcher {
        C0101a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (a.this.f7938a.getSuffixText() != null) {
                return;
            }
            a.this.i(a.l(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            a.this.i((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z);
        }
    }

    class c implements TextInputLayout.h {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.l(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f7906h);
            editText.removeTextChangedListener(a.this.f7905g);
            editText.addTextChangedListener(a.this.f7905g);
        }
    }

    class d implements TextInputLayout.i {
        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 2) {
                return;
            }
            editText.removeTextChangedListener(a.this.f7905g);
            if (editText.getOnFocusChangeListener() == a.this.f7906h) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.f7938a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f7938a.setEndIconVisible(true);
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f7938a.setEndIconVisible(false);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            a.this.f7940c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f7940c.setScaleX(floatValue);
            a.this.f7940c.setScaleY(floatValue);
        }
    }

    a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f7905g = new C0101a();
        this.f7906h = new b();
        this.f7907i = new c();
        this.f7908j = new d();
    }

    public void i(boolean z) {
        boolean z2 = this.f7938a.O() == z;
        if (z) {
            this.l.cancel();
            this.k.start();
            if (z2) {
                this.k.end();
                return;
            }
            return;
        }
        this.k.cancel();
        this.l.start();
        if (z2) {
            this.l.end();
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.a.a.f6607a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new h());
        return ofFloat;
    }

    private ValueAnimator k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f7904f, 1.0f);
        ofFloat.setInterpolator(com.google.android.material.a.a.f6610d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    public static boolean l(@NonNull Editable editable) {
        return editable.length() > 0;
    }

    private void m() {
        ValueAnimator k = k();
        ValueAnimator j2 = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.k = animatorSet;
        animatorSet.playTogether(k, j2);
        this.k.addListener(new f());
        ValueAnimator j3 = j(1.0f, 0.0f);
        this.l = j3;
        j3.addListener(new g());
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.f7938a.setEndIconDrawable(AppCompatResources.getDrawable(this.f7939b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f7938a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f7938a.setEndIconOnClickListener(new e());
        this.f7938a.e(this.f7907i);
        this.f7938a.f(this.f7908j);
        m();
    }

    @Override // com.google.android.material.textfield.e
    void c(boolean z) {
        if (this.f7938a.getSuffixText() == null) {
            return;
        }
        i(z);
    }
}
