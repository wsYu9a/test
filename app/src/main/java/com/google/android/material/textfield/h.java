package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class h extends e {

    /* renamed from: d */
    private final TextWatcher f7956d;

    /* renamed from: e */
    private final TextInputLayout.h f7957e;

    /* renamed from: f */
    private final TextInputLayout.i f7958f;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f7940c.setChecked(!r1.g());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements TextInputLayout.h {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h.this.f7940c.setChecked(!r4.g());
            editText.removeTextChangedListener(h.this.f7956d);
            editText.addTextChangedListener(h.this.f7956d);
        }
    }

    class c implements TextInputLayout.i {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.removeTextChangedListener(h.this.f7956d);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = h.this.f7938a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (h.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
        }
    }

    h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f7956d = new a();
        this.f7957e = new b();
        this.f7958f = new c();
    }

    public boolean g() {
        EditText editText = this.f7938a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.f7938a.setEndIconDrawable(AppCompatResources.getDrawable(this.f7939b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f7938a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.f7938a.setEndIconOnClickListener(new d());
        this.f7938a.e(this.f7957e);
        this.f7938a.f(this.f7958f);
        EditText editText = this.f7938a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
