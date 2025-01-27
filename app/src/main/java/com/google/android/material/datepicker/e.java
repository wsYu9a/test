package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
abstract class e implements TextWatcher {

    /* renamed from: a */
    private final String f7033a;

    /* renamed from: b */
    private final DateFormat f7034b;

    /* renamed from: c */
    @NonNull
    private final TextInputLayout f7035c;

    /* renamed from: d */
    private final a f7036d;

    /* renamed from: e */
    private final String f7037e;

    e(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, a aVar) {
        this.f7033a = str;
        this.f7034b = dateFormat;
        this.f7035c = textInputLayout;
        this.f7036d = aVar;
        this.f7037e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
    }

    void a() {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    abstract void b(@Nullable Long l);

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f7035c.setError(null);
            b(null);
            return;
        }
        try {
            Date parse = this.f7034b.parse(charSequence.toString());
            this.f7035c.setError(null);
            long time = parse.getTime();
            if (this.f7036d.g().c(time) && this.f7036d.m(time)) {
                b(Long.valueOf(parse.getTime()));
            } else {
                this.f7035c.setError(String.format(this.f7037e, g.c(time)));
                a();
            }
        } catch (ParseException unused) {
            String string = this.f7035c.getContext().getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(this.f7035c.getContext().getString(R.string.mtrl_picker_invalid_format_use), this.f7033a);
            String format2 = String.format(this.f7035c.getContext().getString(R.string.mtrl_picker_invalid_format_example), this.f7034b.format(new Date(w.t().getTimeInMillis())));
            this.f7035c.setError(string + "\n" + format + "\n" + format2);
            a();
        }
    }
}
