package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
class j extends BaseAdapter {

    /* renamed from: a */
    private static final int f7040a = 4;

    /* renamed from: b */
    private static final int f7041b;

    /* renamed from: c */
    @NonNull
    private final Calendar f7042c;

    /* renamed from: d */
    private final int f7043d;

    /* renamed from: e */
    private final int f7044e;

    static {
        f7041b = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public j() {
        Calendar v = w.v();
        this.f7042c = v;
        this.f7043d = v.getMaximum(7);
        this.f7044e = v.getFirstDayOfWeek();
    }

    private int b(int i2) {
        int i3 = i2 + this.f7044e;
        int i4 = this.f7043d;
        return i3 > i4 ? i3 - i4 : i3;
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: a */
    public Integer getItem(int i2) {
        if (i2 >= this.f7043d) {
            return null;
        }
        return Integer.valueOf(b(i2));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7043d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f7042c.set(7, b(i2));
        textView.setText(this.f7042c.getDisplayName(7, f7041b, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f7042c.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
