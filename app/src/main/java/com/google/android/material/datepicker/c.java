package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a */
    @NonNull
    final b f7024a;

    /* renamed from: b */
    @NonNull
    final b f7025b;

    /* renamed from: c */
    @NonNull
    final b f7026c;

    /* renamed from: d */
    @NonNull
    final b f7027d;

    /* renamed from: e */
    @NonNull
    final b f7028e;

    /* renamed from: f */
    @NonNull
    final b f7029f;

    /* renamed from: g */
    @NonNull
    final b f7030g;

    /* renamed from: h */
    @NonNull
    final Paint f7031h;

    c(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.g.b.f(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f7024a = b.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f7030g = b.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f7025b = b.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f7026c = b.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a2 = com.google.android.material.g.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f7027d = b.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f7028e = b.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f7029f = b.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f7031h = paint;
        paint.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
