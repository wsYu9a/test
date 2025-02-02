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
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes2.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_DURATION = 100;
    private static final int ANIMATION_SCALE_DURATION = 150;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private final TextWatcher clearTextEndIconTextWatcher;
    private final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener;

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$1 */
    public class AnonymousClass1 implements TextWatcher {
        public AnonymousClass1() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() != null) {
                return;
            }
            ClearTextEndIconDelegate.this.animateIcon(ClearTextEndIconDelegate.hasText(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$2 */
    public class AnonymousClass2 implements View.OnFocusChangeListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            ClearTextEndIconDelegate.this.animateIcon((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z10);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$3 */
    public class AnonymousClass3 implements TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass3() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && ClearTextEndIconDelegate.hasText(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.onFocusChangeListener);
            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            editText.addTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$4 */
    public class AnonymousClass4 implements TextInputLayout.OnEndIconChangedListener {
        public AnonymousClass4() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i10) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i10 != 2) {
                return;
            }
            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.onFocusChangeListener) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$5 */
    public class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
            if (text != null) {
                text.clear();
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$6 */
    public class AnonymousClass6 extends AnimatorListenerAdapter {
        public AnonymousClass6() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$7 */
    public class AnonymousClass7 extends AnimatorListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$8 */
    public class AnonymousClass8 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass8() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$9 */
    public class AnonymousClass9 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass9() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClearTextEndIconDelegate.this.endIconView.setScaleX(floatValue);
            ClearTextEndIconDelegate.this.endIconView.setScaleY(floatValue);
        }
    }

    public ClearTextEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.clearTextEndIconTextWatcher = new TextWatcher() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            public AnonymousClass1() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@NonNull Editable editable) {
                if (ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() != null) {
                    return;
                }
                ClearTextEndIconDelegate.this.animateIcon(ClearTextEndIconDelegate.hasText(editable));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z10) {
                ClearTextEndIconDelegate.this.animateIcon((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z10);
            }
        };
        this.clearTextOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.3
            public AnonymousClass3() {
            }

            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                EditText editText = textInputLayout2.getEditText();
                textInputLayout2.setEndIconVisible(editText.hasFocus() && ClearTextEndIconDelegate.hasText(editText.getText()));
                textInputLayout2.setEndIconCheckable(false);
                editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.onFocusChangeListener);
                editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                editText.addTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            }
        };
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            public AnonymousClass4() {
            }

            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i10) {
                EditText editText = textInputLayout2.getEditText();
                if (editText == null || i10 != 2) {
                    return;
                }
                editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.onFocusChangeListener) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        };
    }

    public void animateIcon(boolean z10) {
        boolean z11 = this.textInputLayout.isEndIconVisible() == z10;
        if (z10) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z11) {
                this.iconInAnim.end();
                return;
            }
            return;
        }
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (z11) {
            this.iconOutAnim.end();
        }
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            public AnonymousClass8() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.9
            public AnonymousClass9() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate.this.endIconView.setScaleX(floatValue);
                ClearTextEndIconDelegate.this.endIconView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    public static boolean hasText(@NonNull Editable editable) {
        return editable.length() > 0;
    }

    private void initAnimators() {
        ValueAnimator scaleAnimator = getScaleAnimator();
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(scaleAnimator, alphaAnimator);
        this.iconInAnim.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            public AnonymousClass6() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        ValueAnimator alphaAnimator2 = getAlphaAnimator(1.0f, 0.0f);
        this.iconOutAnim = alphaAnimator2;
        alphaAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.7
            public AnonymousClass7() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.5
            public AnonymousClass5() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Editable text = ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onSuffixVisibilityChanged(boolean z10) {
        if (this.textInputLayout.getSuffixText() == null) {
            return;
        }
        animateIcon(z10);
    }
}
