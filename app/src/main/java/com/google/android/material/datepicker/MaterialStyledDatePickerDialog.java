package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
/* loaded from: classes.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {

    /* renamed from: a */
    @AttrRes
    private static final int f7001a = 16843612;

    /* renamed from: b */
    @StyleRes
    private static final int f7002b = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;

    /* renamed from: c */
    @NonNull
    private final Drawable f7003c;

    /* renamed from: d */
    @NonNull
    private final Rect f7004d;

    public MaterialStyledDatePickerDialog(@NonNull Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.f7003c);
        getWindow().getDecorView().setOnTouchListener(new com.google.android.material.dialog.a(this, this.f7004d));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2) {
        this(context, i2, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        this(context, 0, onDateSetListener, i2, i3, i4);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i2, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i3, int i4, int i5) {
        super(context, i2, onDateSetListener, i3, i4, i5);
        Context context2 = getContext();
        int f2 = com.google.android.material.g.b.f(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i6 = f7002b;
        com.google.android.material.j.j jVar = new com.google.android.material.j.j(context2, null, 16843612, i6);
        if (Build.VERSION.SDK_INT >= 21) {
            jVar.n0(ColorStateList.valueOf(f2));
        } else {
            jVar.n0(ColorStateList.valueOf(0));
        }
        Rect a2 = com.google.android.material.dialog.b.a(context2, 16843612, i6);
        this.f7004d = a2;
        this.f7003c = com.google.android.material.dialog.b.b(jVar, a2);
    }
}
