package com.martian.mibook.ui.adapter.yuewen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.BookRankTab;
import com.martian.mibook.ui.adapter.yuewen.YWCategoryTitleAdapter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class YWCategoryTitleAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: g */
    public static final int f15894g = 10;

    /* renamed from: h */
    public static final int f15895h = 20;

    /* renamed from: i */
    public static final int f15896i = 30;

    /* renamed from: j */
    public static int f15897j = 40;

    /* renamed from: k */
    public static int f15898k = 50;

    /* renamed from: l */
    public static int f15899l = 70;

    /* renamed from: m */
    public static final int f15900m = 80;

    /* renamed from: n */
    public static final int f15901n = 100;

    /* renamed from: o */
    public static final int f15902o = 110;

    /* renamed from: d */
    public final Context f15904d;

    /* renamed from: f */
    public a f15906f;

    /* renamed from: c */
    public int f15903c = 0;

    /* renamed from: e */
    public final List<BookRankTab> f15905e = MiConfigSingleton.b2().f2().i();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b */
        public final TextView f15907b;

        /* renamed from: c */
        public final View f15908c;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.f15907b = (TextView) view.findViewById(R.id.category_title);
            this.f15908c = view.findViewById(R.id.category_title_view);
        }
    }

    public interface a {
        void a(int i10);
    }

    public YWCategoryTitleAdapter(Context context) {
        this.f15904d = context;
    }

    public /* synthetic */ void m(int i10, View view) {
        if (this.f15906f == null || i10 == this.f15903c) {
            return;
        }
        r(i10);
        this.f15906f.a(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<BookRankTab> list = this.f15905e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public int j() {
        return this.f15903c;
    }

    public String k() {
        return this.f15905e.get(this.f15903c).getName();
    }

    public int l() {
        return this.f15905e.get(this.f15903c).getBtype();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i10) {
        if (l.q(this.f15905e.get(i10).getName())) {
            return;
        }
        viewHolder.f15907b.setText(this.f15905e.get(i10).getName());
        if (i10 == this.f15903c) {
            viewHolder.f15907b.setTextColor(ContextCompat.getColor(this.f15904d, com.martian.libmars.R.color.white));
            viewHolder.f15907b.setBackgroundResource(com.martian.libmars.R.drawable.border_button_round_default);
        } else {
            viewHolder.f15907b.setTextColor(ConfigSingleton.D().j0());
            viewHolder.f15907b.setBackgroundColor(ContextCompat.getColor(this.f15904d, com.martian.libmars.R.color.transparent));
        }
        viewHolder.f15908c.setOnClickListener(new View.OnClickListener() { // from class: de.e

            /* renamed from: c */
            public final /* synthetic */ int f25513c;

            public /* synthetic */ e(int i102) {
                i10 = i102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YWCategoryTitleAdapter.this.m(i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new ViewHolder(View.inflate(this.f15904d, R.layout.book_category_title_item, null));
    }

    public void p(int i10) {
        Iterator<BookRankTab> it = this.f15905e.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (it.next().getBtype() == i10) {
                r(i11);
                return;
            }
            i11++;
        }
    }

    public void q(a aVar) {
        this.f15906f = aVar;
    }

    public void r(int i10) {
        if (i10 < 0 || i10 >= getPageSize()) {
            return;
        }
        this.f15903c = i10;
        notifyDataSetChanged();
    }
}
