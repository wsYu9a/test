package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class t implements f<Long> {
    public static final Parcelable.Creator<t> CREATOR = new b();

    /* renamed from: a */
    @Nullable
    private Long f7106a;

    class a extends e {

        /* renamed from: f */
        final /* synthetic */ q f7107f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, com.google.android.material.datepicker.a aVar, q qVar) {
            super(str, dateFormat, textInputLayout, aVar);
            this.f7107f = qVar;
        }

        @Override // com.google.android.material.datepicker.e
        void a() {
            this.f7107f.a();
        }

        @Override // com.google.android.material.datepicker.e
        void b(@Nullable Long l) {
            if (l == null) {
                t.this.d();
            } else {
                t.this.j0(l.longValue());
            }
            this.f7107f.b(t.this.i0());
        }
    }

    static class b implements Parcelable.Creator<t> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public t createFromParcel(@NonNull Parcel parcel) {
            t tVar = new t();
            tVar.f7106a = (Long) parcel.readValue(Long.class.getClassLoader());
            return tVar;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public t[] newArray(int i2) {
            return new t[i2];
        }
    }

    public void d() {
        this.f7106a = null;
    }

    @Override // com.google.android.material.datepicker.f
    public int a0() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.f
    public int b0(Context context) {
        return com.google.android.material.g.b.f(context, R.attr.materialCalendarTheme, k.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.f
    @NonNull
    public String c0(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l = this.f7106a;
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, g.i(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.f
    @NonNull
    public Collection<Pair<Long, Long>> d0() {
        return new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.f
    @Nullable
    /* renamed from: e */
    public Long i0() {
        return this.f7106a;
    }

    @Override // com.google.android.material.datepicker.f
    /* renamed from: f */
    public void e0(@Nullable Long l) {
        this.f7106a = l == null ? null : Long.valueOf(w.a(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.f
    public View f0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, com.google.android.material.datepicker.a aVar, @NonNull q<Long> qVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.e.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat p = w.p();
        String q = w.q(inflate.getResources(), p);
        Long l = this.f7106a;
        if (l != null) {
            editText.setText(p.format(l));
        }
        editText.addTextChangedListener(new a(q, p, textInputLayout, aVar, qVar));
        com.google.android.material.internal.u.l(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.f
    public boolean g0() {
        return this.f7106a != null;
    }

    @Override // com.google.android.material.datepicker.f
    @NonNull
    public Collection<Long> h0() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f7106a;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.f
    public void j0(long j2) {
        this.f7106a = Long.valueOf(j2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.f7106a);
    }
}
