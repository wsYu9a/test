package com.martian.mibook.ui.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class f4 extends RecyclerView.Adapter<b> {

    /* renamed from: a */
    private int f14363a = 0;

    /* renamed from: b */
    private final Context f14364b;

    /* renamed from: c */
    private List<String> f14365c;

    /* renamed from: d */
    private a f14366d;

    public interface a {
        void a(int position);
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        final TextView f14367a;

        /* renamed from: b */
        final View f14368b;

        public b(@NonNull View itemView) {
            super(itemView);
            this.f14367a = (TextView) itemView.findViewById(R.id.tag_title);
            this.f14368b = itemView.findViewById(R.id.tag_view);
        }
    }

    public f4(Context context, List<String> categories) {
        this.f14364b = context;
        this.f14365c = categories;
    }

    /* renamed from: G */
    public /* synthetic */ void H(final int position, View view) {
        if (this.f14366d == null || position == this.f14363a) {
            return;
        }
        M(position);
        this.f14366d.a(position);
    }

    public int E() {
        return this.f14363a;
    }

    public String F() {
        return this.f14365c.get(this.f14363a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: I */
    public void onBindViewHolder(@NonNull b viewHolder, final int position) {
        if (com.martian.libsupport.k.p(this.f14365c.get(position))) {
            return;
        }
        viewHolder.f14367a.setText(this.f14365c.get(position));
        boolean I0 = com.martian.libmars.d.h.F().I0();
        int i2 = this.f14363a;
        int i3 = R.drawable.border_search_background_night_card;
        if (position == i2) {
            viewHolder.f14367a.setTextColor(ContextCompat.getColor(this.f14364b, R.color.theme_default));
            TextView textView = viewHolder.f14367a;
            if (!I0) {
                i3 = R.drawable.border_mission_button;
            }
            textView.setBackgroundResource(i3);
            viewHolder.f14367a.getPaint().setFakeBoldText(true);
        } else {
            viewHolder.f14367a.setTextColor(com.martian.libmars.d.h.F().r0());
            TextView textView2 = viewHolder.f14367a;
            if (!I0) {
                i3 = R.drawable.border_search_background_day;
            }
            textView2.setBackgroundResource(i3);
            viewHolder.f14367a.getPaint().setFakeBoldText(false);
        }
        viewHolder.f14368b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f4.this.H(position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: J */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(View.inflate(this.f14364b, R.layout.rank_tag_item, null));
    }

    public void K(List<String> tags) {
        this.f14365c = tags;
        notifyDataSetChanged();
    }

    public void L(a onItemClickListener) {
        this.f14366d = onItemClickListener;
    }

    public void M(int position) {
        if (position < 0 || position >= getItemCount()) {
            return;
        }
        this.f14363a = position;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f14365c;
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
