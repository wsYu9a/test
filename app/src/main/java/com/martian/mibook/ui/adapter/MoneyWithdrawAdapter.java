package com.martian.mibook.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.databinding.WithdrawMoneyItemBinding;
import com.martian.mibook.lib.account.response.TYWithdrawMoneyItem;
import com.martian.mibook.ui.adapter.MoneyWithdrawAdapter;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class MoneyWithdrawAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c */
    public final Context f15862c;

    /* renamed from: d */
    public int f15863d = 0;

    /* renamed from: e */
    public List<TYWithdrawMoneyItem> f15864e;

    /* renamed from: f */
    public a f15865f;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b */
        public ThemeLinearLayout f15866b;

        /* renamed from: c */
        public TextView f15867c;

        /* renamed from: d */
        public TextView f15868d;

        public ViewHolder(@NonNull WithdrawMoneyItemBinding withdrawMoneyItemBinding) {
            super(withdrawMoneyItemBinding.getRoot());
            this.f15866b = withdrawMoneyItemBinding.withdrawMoney;
            this.f15867c = withdrawMoneyItemBinding.withdrawMoneyTitle;
            this.f15868d = withdrawMoneyItemBinding.withdrawMoneyDesc;
        }
    }

    public interface a {
        void a(int i10, TYWithdrawMoneyItem tYWithdrawMoneyItem);
    }

    public MoneyWithdrawAdapter(Context context, List<TYWithdrawMoneyItem> list) {
        this.f15862c = context;
        this.f15864e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        if (this.f15864e.isEmpty()) {
            return 0;
        }
        return this.f15864e.size();
    }

    public TYWithdrawMoneyItem j() {
        List<TYWithdrawMoneyItem> list = this.f15864e;
        if (list == null || this.f15863d >= list.size()) {
            return null;
        }
        return this.f15864e.get(this.f15863d);
    }

    public final /* synthetic */ void k(int i10, TYWithdrawMoneyItem tYWithdrawMoneyItem, View view) {
        a aVar = this.f15865f;
        if (aVar != null) {
            aVar.a(i10, tYWithdrawMoneyItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: l */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i10) {
        String str;
        TYWithdrawMoneyItem tYWithdrawMoneyItem = this.f15864e.get(i10);
        if (tYWithdrawMoneyItem == null) {
            return;
        }
        if (this.f15863d == i10) {
            viewHolder.f15866b.setBackgroundResource(R.drawable.border_button_theme_default_middle);
            viewHolder.f15868d.setTextColor(ContextCompat.getColor(this.f15862c, R.color.white));
            viewHolder.f15867c.setTextColor(ContextCompat.getColor(this.f15862c, R.color.white));
        } else {
            viewHolder.f15866b.setBackgroundResource(ConfigSingleton.D().A0() ? R.drawable.border_background_withdraw_night : R.drawable.border_background_withdraw_day);
            viewHolder.f15867c.setTextColor(ConfigSingleton.D().j0());
            viewHolder.f15868d.setTextColor(ContextCompat.getColor(this.f15862c, R.color.theme_default));
        }
        String n10 = f.n(tYWithdrawMoneyItem.getMoney());
        TextView textView = viewHolder.f15867c;
        if (l.q(tYWithdrawMoneyItem.getDesc())) {
            str = this.f15862c.getString(com.martian.mibook.R.string.immediately_withdraw) + n10 + "元";
        } else {
            str = tYWithdrawMoneyItem.getDesc();
        }
        textView.setText(str);
        viewHolder.f15868d.setText(n10 + "元");
        viewHolder.f15866b.setOnClickListener(new View.OnClickListener() { // from class: ce.l

            /* renamed from: c */
            public final /* synthetic */ int f1949c;

            /* renamed from: d */
            public final /* synthetic */ TYWithdrawMoneyItem f1950d;

            public /* synthetic */ l(int i102, TYWithdrawMoneyItem tYWithdrawMoneyItem2) {
                i10 = i102;
                tYWithdrawMoneyItem = tYWithdrawMoneyItem2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyWithdrawAdapter.this.k(i10, tYWithdrawMoneyItem, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new ViewHolder(WithdrawMoneyItemBinding.inflate(LayoutInflater.from(this.f15862c), null, false));
    }

    public void n(a aVar) {
        this.f15865f = aVar;
    }

    public void o(int i10) {
        this.f15863d = i10;
        notifyDataSetChanged();
    }

    public void p(List<TYWithdrawMoneyItem> list) {
        this.f15864e = list;
        notifyDataSetChanged();
    }
}
