package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
class x extends RecyclerView.Adapter<b> {

    /* renamed from: a */
    private final MaterialCalendar<?> f7116a;

    class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f7117a;

        a(int i2) {
            this.f7117a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x.this.f7116a.u(x.this.f7116a.n().f(n.b(this.f7117a, x.this.f7116a.p().f7073c)));
            x.this.f7116a.v(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f7119a;

        b(TextView textView) {
            super(textView);
            this.f7119a = textView;
        }
    }

    x(MaterialCalendar<?> materialCalendar) {
        this.f7116a = materialCalendar;
    }

    @NonNull
    private View.OnClickListener n(int i2) {
        return new a(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f7116a.n().l();
    }

    int o(int i2) {
        return i2 - this.f7116a.n().k().f7074d;
    }

    int p(int i2) {
        return this.f7116a.n().k().f7074d + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        int p = p(i2);
        String string = bVar.f7119a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        bVar.f7119a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(p)));
        bVar.f7119a.setContentDescription(String.format(string, Integer.valueOf(p)));
        c o = this.f7116a.o();
        Calendar t = w.t();
        com.google.android.material.datepicker.b bVar2 = t.get(1) == p ? o.f7029f : o.f7027d;
        Iterator<Long> it = this.f7116a.c().h0().iterator();
        while (it.hasNext()) {
            t.setTimeInMillis(it.next().longValue());
            if (t.get(1) == p) {
                bVar2 = o.f7028e;
            }
        }
        bVar2.f(bVar.f7119a);
        bVar.f7119a.setOnClickListener(n(p));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
