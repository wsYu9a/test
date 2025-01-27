package com.martian.mibook.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.ui.adapter.RankTagsAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public class RankTagsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c */
    public final Context f15869c;

    /* renamed from: d */
    public final List<String> f15870d;

    /* renamed from: e */
    public a f15871e;

    /* renamed from: f */
    public int f15872f = 0;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b */
        public final TextView f15873b;

        /* renamed from: c */
        public final View f15874c;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.f15873b = (TextView) view.findViewById(R.id.tag_title);
            this.f15874c = view.findViewById(R.id.tag_view);
        }
    }

    public interface a {
        void a(int i10);
    }

    public RankTagsAdapter(Context context, List<String> list) {
        this.f15869c = context;
        this.f15870d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<String> list = this.f15870d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public String j(int i10) {
        return (i10 < 0 || i10 >= getPageSize()) ? "" : this.f15870d.get(i10);
    }

    public String k() {
        return this.f15870d.get(this.f15872f);
    }

    public int l() {
        return this.f15872f;
    }

    public final /* synthetic */ void m(int i10, View view) {
        if (i10 == this.f15872f) {
            return;
        }
        q(i10);
        a aVar = this.f15871e;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i10) {
        viewHolder.f15873b.setText(j(i10));
        boolean A0 = ConfigSingleton.D().A0();
        if (i10 == this.f15872f) {
            viewHolder.f15873b.setTextColor(ContextCompat.getColor(this.f15869c, com.martian.libmars.R.color.theme_default));
            viewHolder.f15873b.setBackgroundResource(A0 ? com.martian.libmars.R.drawable.border_search_background_night_card : R.drawable.border_mission_button);
            viewHolder.f15873b.getPaint().setFakeBoldText(true);
        } else {
            viewHolder.f15873b.setTextColor(ConfigSingleton.D().j0());
            viewHolder.f15873b.setBackgroundResource(A0 ? com.martian.libmars.R.drawable.border_search_background_night_card : com.martian.libmars.R.drawable.border_search_background_day);
            viewHolder.f15873b.getPaint().setFakeBoldText(false);
        }
        viewHolder.f15874c.setOnClickListener(new View.OnClickListener() { // from class: ce.m

            /* renamed from: c */
            public final /* synthetic */ int f1952c;

            public /* synthetic */ m(int i102) {
                i10 = i102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankTagsAdapter.this.m(i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new ViewHolder(View.inflate(this.f15869c, R.layout.rank_tag_item, null));
    }

    public void p(a aVar) {
        this.f15871e = aVar;
    }

    public void q(int i10) {
        int i11;
        if (i10 < 0 || i10 >= getPageSize() || (i11 = this.f15872f) == i10) {
            return;
        }
        this.f15872f = i10;
        notifyItemChanged(i11);
        notifyItemChanged(i10);
    }
}
