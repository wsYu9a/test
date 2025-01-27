package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.e.j7;
import com.martian.mibook.lib.account.response.TYWithdrawMoneyItem;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class e4 extends RecyclerView.Adapter<b> {

    /* renamed from: a */
    private final Context f14340a;

    /* renamed from: b */
    private int f14341b = 0;

    /* renamed from: c */
    private List<TYWithdrawMoneyItem> f14342c;

    /* renamed from: d */
    private a f14343d;

    public interface a {
        void a(int position, TYWithdrawMoneyItem tyWithdrawMoneyItem);
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        ThemeLinearLayout f14344a;

        /* renamed from: b */
        TextView f14345b;

        /* renamed from: c */
        TextView f14346c;

        public b(@NonNull j7 itemBinding) {
            super(itemBinding.getRoot());
            this.f14344a = itemBinding.f12209b;
            this.f14345b = itemBinding.f12211d;
            this.f14346c = itemBinding.f12210c;
        }
    }

    public e4(Context context, List<TYWithdrawMoneyItem> tyWithdrawMoneyItems) {
        this.f14340a = context;
        this.f14342c = tyWithdrawMoneyItems;
    }

    /* renamed from: F */
    public /* synthetic */ void G(final int position, final TYWithdrawMoneyItem tyWithdrawMoneyItem, View v) {
        a aVar = this.f14343d;
        if (aVar != null) {
            aVar.a(position, tyWithdrawMoneyItem);
        }
    }

    public TYWithdrawMoneyItem E() {
        List<TYWithdrawMoneyItem> list = this.f14342c;
        if (list == null || this.f14341b >= list.size()) {
            return null;
        }
        return this.f14342c.get(this.f14341b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: H */
    public void onBindViewHolder(@NonNull b viewHolder, final int position) {
        String str;
        final TYWithdrawMoneyItem tYWithdrawMoneyItem = this.f14342c.get(position);
        if (tYWithdrawMoneyItem == null) {
            return;
        }
        if (this.f14341b == position) {
            viewHolder.f14344a.setBackgroundResource(R.drawable.border_button_theme_default_middle);
            viewHolder.f14346c.setTextColor(ContextCompat.getColor(this.f14340a, R.color.white));
            viewHolder.f14345b.setTextColor(ContextCompat.getColor(this.f14340a, R.color.white));
        } else {
            viewHolder.f14344a.setBackgroundResource(com.martian.libmars.d.h.F().I0() ? R.drawable.border_background_withdraw_night : R.drawable.border_background_withdraw_day);
            viewHolder.f14345b.setTextColor(com.martian.libmars.d.h.F().r0());
            viewHolder.f14346c.setTextColor(ContextCompat.getColor(this.f14340a, R.color.theme_default));
        }
        String m = com.martian.rpauth.d.i.m(tYWithdrawMoneyItem.getMoney());
        TextView textView = viewHolder.f14345b;
        if (com.martian.libsupport.k.p(tYWithdrawMoneyItem.getDesc())) {
            str = this.f14340a.getString(R.string.immediately_withdraw) + m + "元";
        } else {
            str = tYWithdrawMoneyItem.getDesc();
        }
        textView.setText(str);
        viewHolder.f14346c.setText(m + "元");
        viewHolder.f14344a.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e4.this.G(position, tYWithdrawMoneyItem, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: I */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(j7.d(LayoutInflater.from(this.f14340a), null, false));
    }

    public void J(a onMoneyItemClickListener) {
        this.f14343d = onMoneyItemClickListener;
    }

    public void K(int position) {
        this.f14341b = position;
        notifyDataSetChanged();
    }

    public void L(List<TYWithdrawMoneyItem> tyWithdrawMoneyItems) {
        this.f14342c = tyWithdrawMoneyItems;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f14342c.isEmpty()) {
            return 0;
        }
        return this.f14342c.size();
    }
}
