package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes.dex */
class p extends RecyclerView.Adapter<b> {

    /* renamed from: a */
    @NonNull
    private final com.google.android.material.datepicker.a f7083a;

    /* renamed from: b */
    private final f<?> f7084b;

    /* renamed from: c */
    private final MaterialCalendar.k f7085c;

    /* renamed from: d */
    private final int f7086d;

    class a implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        final /* synthetic */ MaterialCalendarGridView f7087a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f7087a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (this.f7087a.getAdapter().j(i2)) {
                p.this.f7085c.a(this.f7087a.getAdapter().getItem(i2).longValue());
            }
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f7089a;

        /* renamed from: b */
        final MaterialCalendarGridView f7090b;

        b(@NonNull LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f7089a = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f7090b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    p(@NonNull Context context, f<?> fVar, @NonNull com.google.android.material.datepicker.a aVar, MaterialCalendar.k kVar) {
        n k = aVar.k();
        n h2 = aVar.h();
        n j2 = aVar.j();
        if (k.compareTo(j2) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (j2.compareTo(h2) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f7086d = (o.f7078a * MaterialCalendar.q(context)) + (k.x(context) ? MaterialCalendar.q(context) : 0);
        this.f7083a = aVar;
        this.f7084b = fVar;
        this.f7085c = kVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f7083a.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return this.f7083a.k().j(i2).i();
    }

    @NonNull
    n n(int i2) {
        return this.f7083a.k().j(i2);
    }

    @NonNull
    CharSequence o(int i2) {
        return n(i2).h();
    }

    int p(@NonNull n nVar) {
        return this.f7083a.k().k(nVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        n j2 = this.f7083a.k().j(i2);
        bVar.f7089a.setText(j2.h());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f7090b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !j2.equals(materialCalendarGridView.getAdapter().f7079b)) {
            o oVar = new o(j2, this.f7084b, this.f7083a);
            materialCalendarGridView.setNumColumns(j2.f7075e);
            materialCalendarGridView.setAdapter((ListAdapter) oVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: r */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!k.x(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f7086d));
        return new b(linearLayout, true);
    }
}
