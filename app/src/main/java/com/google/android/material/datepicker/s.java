package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class s implements f<Pair<Long, Long>> {
    public static final Parcelable.Creator<s> CREATOR = new c();

    /* renamed from: a */
    private String f7092a;

    /* renamed from: b */
    private final String f7093b = " ";

    /* renamed from: c */
    @Nullable
    private Long f7094c = null;

    /* renamed from: d */
    @Nullable
    private Long f7095d = null;

    /* renamed from: e */
    @Nullable
    private Long f7096e = null;

    /* renamed from: f */
    @Nullable
    private Long f7097f = null;

    class a extends e {

        /* renamed from: f */
        final /* synthetic */ TextInputLayout f7098f;

        /* renamed from: g */
        final /* synthetic */ TextInputLayout f7099g;

        /* renamed from: h */
        final /* synthetic */ q f7100h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, com.google.android.material.datepicker.a aVar, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, q qVar) {
            super(str, dateFormat, textInputLayout, aVar);
            this.f7098f = textInputLayout2;
            this.f7099g = textInputLayout3;
            this.f7100h = qVar;
        }

        @Override // com.google.android.material.datepicker.e
        void a() {
            s.this.f7096e = null;
            s.this.l(this.f7098f, this.f7099g, this.f7100h);
        }

        @Override // com.google.android.material.datepicker.e
        void b(@Nullable Long l) {
            s.this.f7096e = l;
            s.this.l(this.f7098f, this.f7099g, this.f7100h);
        }
    }

    class b extends e {

        /* renamed from: f */
        final /* synthetic */ TextInputLayout f7102f;

        /* renamed from: g */
        final /* synthetic */ TextInputLayout f7103g;

        /* renamed from: h */
        final /* synthetic */ q f7104h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, com.google.android.material.datepicker.a aVar, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, q qVar) {
            super(str, dateFormat, textInputLayout, aVar);
            this.f7102f = textInputLayout2;
            this.f7103g = textInputLayout3;
            this.f7104h = qVar;
        }

        @Override // com.google.android.material.datepicker.e
        void a() {
            s.this.f7097f = null;
            s.this.l(this.f7102f, this.f7103g, this.f7104h);
        }

        @Override // com.google.android.material.datepicker.e
        void b(@Nullable Long l) {
            s.this.f7097f = l;
            s.this.l(this.f7102f, this.f7103g, this.f7104h);
        }
    }

    static class c implements Parcelable.Creator<s> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public s createFromParcel(@NonNull Parcel parcel) {
            s sVar = new s();
            sVar.f7094c = (Long) parcel.readValue(Long.class.getClassLoader());
            sVar.f7095d = (Long) parcel.readValue(Long.class.getClassLoader());
            return sVar;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public s[] newArray(int i2) {
            return new s[i2];
        }
    }

    private void g(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f7092a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean i(long j2, long j3) {
        return j2 <= j3;
    }

    private void j(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f7092a);
        textInputLayout2.setError(" ");
    }

    public void l(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull q<Pair<Long, Long>> qVar) {
        Long l = this.f7096e;
        if (l == null || this.f7097f == null) {
            g(textInputLayout, textInputLayout2);
            qVar.a();
        } else if (!i(l.longValue(), this.f7097f.longValue())) {
            j(textInputLayout, textInputLayout2);
            qVar.a();
        } else {
            this.f7094c = this.f7096e;
            this.f7095d = this.f7097f;
            qVar.b(i0());
        }
    }

    @Override // com.google.android.material.datepicker.f
    public int a0() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.f
    public int b0(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return com.google.android.material.g.b.f(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, k.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.f
    @NonNull
    public String c0(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l = this.f7094c;
        if (l == null && this.f7095d == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l2 = this.f7095d;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, g.c(l.longValue()));
        }
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, g.c(l2.longValue()));
        }
        Pair<String, String> a2 = g.a(l, l2);
        return resources.getString(R.string.mtrl_picker_range_header_selected, a2.first, a2.second);
    }

    @Override // com.google.android.material.datepicker.f
    @NonNull
    public Collection<Pair<Long, Long>> d0() {
        if (this.f7094c == null || this.f7095d == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.f7094c, this.f7095d));
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.f
    public View f0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, com.google.android.material.datepicker.a aVar, @NonNull q<Pair<Long, Long>> qVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.e.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f7092a = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat p = w.p();
        Long l = this.f7094c;
        if (l != null) {
            editText.setText(p.format(l));
            this.f7096e = this.f7094c;
        }
        Long l2 = this.f7095d;
        if (l2 != null) {
            editText2.setText(p.format(l2));
            this.f7097f = this.f7095d;
        }
        String q = w.q(inflate.getResources(), p);
        editText.addTextChangedListener(new a(q, p, textInputLayout, aVar, textInputLayout, textInputLayout2, qVar));
        editText2.addTextChangedListener(new b(q, p, textInputLayout2, aVar, textInputLayout, textInputLayout2, qVar));
        com.google.android.material.internal.u.l(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.f
    public boolean g0() {
        Long l = this.f7094c;
        return (l == null || this.f7095d == null || !i(l.longValue(), this.f7095d.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.f
    @NonNull
    /* renamed from: h */
    public Pair<Long, Long> i0() {
        return new Pair<>(this.f7094c, this.f7095d);
    }

    @Override // com.google.android.material.datepicker.f
    @NonNull
    public Collection<Long> h0() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f7094c;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.f7095d;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.f
    public void j0(long j2) {
        Long l = this.f7094c;
        if (l == null) {
            this.f7094c = Long.valueOf(j2);
        } else if (this.f7095d == null && i(l.longValue(), j2)) {
            this.f7095d = Long.valueOf(j2);
        } else {
            this.f7095d = null;
            this.f7094c = Long.valueOf(j2);
        }
    }

    @Override // com.google.android.material.datepicker.f
    /* renamed from: k */
    public void e0(@NonNull Pair<Long, Long> pair) {
        Long l = pair.first;
        if (l != null && pair.second != null) {
            Preconditions.checkArgument(i(l.longValue(), pair.second.longValue()));
        }
        Long l2 = pair.first;
        this.f7094c = l2 == null ? null : Long.valueOf(w.a(l2.longValue()));
        Long l3 = pair.second;
        this.f7095d = l3 != null ? Long.valueOf(w.a(l3.longValue())) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.f7094c);
        parcel.writeValue(this.f7095d);
    }
}
