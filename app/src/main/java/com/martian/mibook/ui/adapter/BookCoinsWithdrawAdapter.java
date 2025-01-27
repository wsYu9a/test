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
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.WithdrawMoneyItemBinding;
import com.martian.mibook.lib.account.response.TYWithdrawBookCoins;
import com.martian.mibook.ui.adapter.BookCoinsWithdrawAdapter;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class BookCoinsWithdrawAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c */
    public final Context f15853c;

    /* renamed from: d */
    public int f15854d = 0;

    /* renamed from: e */
    public List<TYWithdrawBookCoins> f15855e;

    /* renamed from: f */
    public a f15856f;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b */
        public ThemeLinearLayout f15857b;

        /* renamed from: c */
        public TextView f15858c;

        /* renamed from: d */
        public TextView f15859d;

        public ViewHolder(@NonNull WithdrawMoneyItemBinding withdrawMoneyItemBinding) {
            super(withdrawMoneyItemBinding.getRoot());
            this.f15857b = withdrawMoneyItemBinding.withdrawMoney;
            this.f15858c = withdrawMoneyItemBinding.withdrawMoneyTitle;
            this.f15859d = withdrawMoneyItemBinding.withdrawMoneyDesc;
        }
    }

    public interface a {
        void a(int i10, TYWithdrawBookCoins tYWithdrawBookCoins);
    }

    public BookCoinsWithdrawAdapter(Context context, List<TYWithdrawBookCoins> list) {
        this.f15853c = context;
        this.f15855e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<TYWithdrawBookCoins> list = this.f15855e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final /* synthetic */ void j(int i10, TYWithdrawBookCoins tYWithdrawBookCoins, View view) {
        a aVar = this.f15856f;
        if (aVar != null) {
            aVar.a(i10, tYWithdrawBookCoins);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: k */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i10) {
        String str;
        TYWithdrawBookCoins tYWithdrawBookCoins = this.f15855e.get(i10);
        if (tYWithdrawBookCoins == null) {
            return;
        }
        if (this.f15854d == i10) {
            viewHolder.f15857b.setBackgroundResource(R.drawable.border_button_theme_default_middle);
            viewHolder.f15859d.setTextColor(ContextCompat.getColor(this.f15853c, R.color.white));
            viewHolder.f15858c.setTextColor(ContextCompat.getColor(this.f15853c, R.color.white));
        } else {
            viewHolder.f15857b.setBackgroundResource(MiConfigSingleton.b2().A0() ? R.drawable.border_background_withdraw_night : R.drawable.border_background_withdraw_day);
            viewHolder.f15859d.setTextColor(ContextCompat.getColor(this.f15853c, R.color.theme_default));
            viewHolder.f15858c.setTextColor(ConfigSingleton.D().j0());
        }
        TextView textView = viewHolder.f15858c;
        if (l.q(tYWithdrawBookCoins.getDesc())) {
            str = tYWithdrawBookCoins.getBookCoins() + this.f15853c.getString(com.martian.mibook.lib.account.R.string.txs_coin);
        } else {
            str = tYWithdrawBookCoins.getDesc();
        }
        textView.setText(str);
        viewHolder.f15859d.setText(f.n(tYWithdrawBookCoins.getMoney()) + "元");
        viewHolder.f15857b.setOnClickListener(new View.OnClickListener() { // from class: ce.j

            /* renamed from: c */
            public final /* synthetic */ int f1946c;

            /* renamed from: d */
            public final /* synthetic */ TYWithdrawBookCoins f1947d;

            public /* synthetic */ j(int i102, TYWithdrawBookCoins tYWithdrawBookCoins2) {
                i10 = i102;
                tYWithdrawBookCoins = tYWithdrawBookCoins2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookCoinsWithdrawAdapter.this.j(i10, tYWithdrawBookCoins, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new ViewHolder(WithdrawMoneyItemBinding.inflate(LayoutInflater.from(this.f15853c), null, false));
    }

    public void m(List<TYWithdrawBookCoins> list) {
        this.f15855e = list;
        notifyDataSetChanged();
    }

    public void n(a aVar) {
        this.f15856f = aVar;
    }

    public void o(int i10) {
        this.f15854d = i10;
        notifyDataSetChanged();
    }
}
