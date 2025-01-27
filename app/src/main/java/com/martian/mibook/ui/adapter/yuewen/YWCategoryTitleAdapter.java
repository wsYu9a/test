package com.martian.mibook.ui.adapter.yuewen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.BookRankTab;
import com.martian.ttbookhd.R;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class YWCategoryTitleAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: a */
    public static final int f14178a = 10;

    /* renamed from: b */
    public static final int f14179b = 20;

    /* renamed from: c */
    public static final int f14180c = 30;

    /* renamed from: d */
    public static int f14181d = 40;

    /* renamed from: e */
    public static int f14182e = 50;

    /* renamed from: f */
    public static int f14183f = 70;

    /* renamed from: g */
    public static final int f14184g = 80;

    /* renamed from: h */
    public static final int f14185h = 100;

    /* renamed from: i */
    public static final int f14186i = 110;
    private final Context k;
    private a m;

    /* renamed from: j */
    private int f14187j = 0;
    private final List<BookRankTab> l = MiConfigSingleton.V3().e4().e();

    public interface a {
        void a(int position);
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f14188a;

        /* renamed from: b */
        final View f14189b;

        public b(@NonNull View itemView) {
            super(itemView);
            this.f14188a = (TextView) itemView.findViewById(R.id.category_title);
            this.f14189b = itemView.findViewById(R.id.category_title_view);
        }
    }

    public YWCategoryTitleAdapter(Context context) {
        this.k = context;
    }

    /* renamed from: H */
    public /* synthetic */ void I(final int position, View view) {
        if (this.m == null || position == this.f14187j) {
            return;
        }
        N(position);
        this.m.a(position);
    }

    public int E() {
        return this.f14187j;
    }

    public String F() {
        return this.l.get(this.f14187j).getName();
    }

    public int G() {
        return this.l.get(this.f14187j).getBtype();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: J */
    public void onBindViewHolder(@NonNull b viewHolder, final int position) {
        if (k.p(this.l.get(position).getName())) {
            return;
        }
        viewHolder.f14188a.setText(this.l.get(position).getName());
        if (position == this.f14187j) {
            viewHolder.f14188a.setTextColor(ContextCompat.getColor(this.k, R.color.white));
            viewHolder.f14188a.setBackgroundResource(R.drawable.border_button_round_default);
        } else {
            viewHolder.f14188a.setTextColor(h.F().r0());
            viewHolder.f14188a.setBackgroundColor(ContextCompat.getColor(this.k, R.color.transparent));
        }
        viewHolder.f14189b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.adapter.yuewen.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YWCategoryTitleAdapter.this.I(position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: K */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(View.inflate(this.k, R.layout.book_category_title_item, null));
    }

    public void L(int bType) {
        Iterator<BookRankTab> it = this.l.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().getBtype() == bType) {
                N(i2);
                return;
            }
            i2++;
        }
    }

    public void M(a onItemClickListener) {
        this.m = onItemClickListener;
    }

    public void N(int position) {
        if (position < 0 || position >= getItemCount()) {
            return;
        }
        this.f14187j = position;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BookRankTab> list = this.l;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }
}
