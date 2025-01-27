package com.martian.mibook.ui.adapter;

import ac.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import je.i;
import l9.m0;
import ya.h2;

/* loaded from: classes3.dex */
public class TYBookItemListAdapter extends CommonRecycleViewAdapter<TYBookItem> implements h2.b {

    /* renamed from: i */
    public final Activity f15879i;

    /* renamed from: j */
    public boolean f15880j;

    /* renamed from: k */
    public boolean f15881k;

    /* renamed from: l */
    public BookRankActivity.RankInfo f15882l;

    /* renamed from: m */
    public final Set<String> f15883m;

    /* renamed from: n */
    public final h2 f15884n;

    /* renamed from: o */
    public String f15885o;

    /* renamed from: p */
    public String f15886p;

    public TYBookItemListAdapter(Activity activity) {
        super(activity, R.layout.bs_book_store_item);
        this.f15880j = false;
        this.f15881k = false;
        this.f15883m = new HashSet();
        this.f15885o = "";
        this.f15886p = "";
        this.f15879i = activity;
        this.f15884n = new h2();
    }

    @SuppressLint({"SetTextI18n"})
    private void G(@NonNull TextView textView, @NonNull TYBookItem tYBookItem) {
        if (this.f15880j && !l.q(tYBookItem.getRankDesc())) {
            textView.setVisibility(0);
            textView.setText(tYBookItem.getRankDesc());
        } else {
            if (tYBookItem.getScore() <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(tYBookItem.getScore() / 10.0d)) + "分");
        }
    }

    private SpannableString w(String str) {
        return l.m(this.f15879i, str, this.f15886p, com.martian.libmars.R.color.theme_default);
    }

    public final void A(ViewHolderHelper viewHolderHelper, TYBookItem tYBookItem) {
        if (tYBookItem == null) {
            return;
        }
        m0.p(this.f15879i, tYBookItem.getCoverUrl(), (ImageView) viewHolderHelper.g(R.id.bs_list_cover), MiConfigSingleton.b2().L1(), MiConfigSingleton.b2().x1(), 2);
        TextView textView = (TextView) viewHolderHelper.g(R.id.bs_list_book_name);
        TextView textView2 = (TextView) viewHolderHelper.g(R.id.bs_list_author_name);
        TextView textView3 = (TextView) viewHolderHelper.g(R.id.bs_list_short_content);
        String title = tYBookItem.getTitle();
        String bookInfo = tYBookItem.getBookInfo();
        String y10 = l.y(tYBookItem.getIntro());
        if (l.q(this.f15886p)) {
            textView.setText(title);
            textView2.setText(bookInfo);
            textView3.setText(l.y(y10));
        } else {
            if (!l.q(title)) {
                if (title.contains(this.f15886p)) {
                    textView.setText(w(title));
                } else {
                    textView.setText(title);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (!tYBookItem.getRoleList().isEmpty()) {
                sb2.append("主角：");
                for (String str : tYBookItem.getRoleList()) {
                    sb2.append(" ");
                    sb2.append(str);
                }
            }
            if (sb2.toString().contains(this.f15886p)) {
                textView2.setText(w(sb2.toString()));
            } else if (bookInfo.contains(this.f15886p)) {
                textView2.setText(w(bookInfo));
            } else {
                textView2.setText(bookInfo);
            }
            if (!l.q(y10)) {
                if (y10.contains(this.f15886p)) {
                    textView3.setText(w(y10));
                } else {
                    textView3.setText(y10);
                }
            }
        }
        if (this.f15880j) {
            viewHolderHelper.k(R.id.bs_list_book_mark, R.drawable.bg_book_rank_4);
            if (this.f15881k) {
                viewHolderHelper.A(R.id.bs_list_book_mark, "NO." + (m(viewHolderHelper) + 2));
            } else {
                int i10 = R.id.bs_list_book_mark;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("NO.");
                sb3.append(m(viewHolderHelper) - 1);
                viewHolderHelper.A(i10, sb3.toString());
            }
        } else {
            viewHolderHelper.E(R.id.bs_list_book_mark, false);
        }
        G((TextView) viewHolderHelper.g(R.id.bs_list_score), tYBookItem);
        viewHolderHelper.r(R.id.book_item_root, new View.OnClickListener() { // from class: ce.r

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f1973c;

            /* renamed from: d */
            public final /* synthetic */ ViewHolderHelper f1974d;

            public /* synthetic */ r(TYBookItem tYBookItem2, ViewHolderHelper viewHolderHelper2) {
                tYBookItem = tYBookItem2;
                viewHolderHelper = viewHolderHelper2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TYBookItemListAdapter.this.y(tYBookItem, viewHolderHelper, view);
            }
        });
        viewHolderHelper2.r(R.id.bs_list_cover, new View.OnClickListener() { // from class: ce.s

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f1976c;

            /* renamed from: d */
            public final /* synthetic */ ViewHolderHelper f1977d;

            public /* synthetic */ s(TYBookItem tYBookItem2, ViewHolderHelper viewHolderHelper2) {
                tYBookItem = tYBookItem2;
                viewHolderHelper = viewHolderHelper2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TYBookItemListAdapter.this.z(tYBookItem, viewHolderHelper, view);
            }
        });
    }

    public void B(String str) {
        this.f15886p = str;
    }

    public void C(boolean z10) {
        this.f15880j = z10;
        notifyDataSetChanged();
    }

    public void D(BookRankActivity.RankInfo rankInfo) {
        this.f15882l = rankInfo;
    }

    public void E(String str) {
        this.f15885o = str;
    }

    public void F(boolean z10) {
        this.f15881k = z10;
    }

    public final void H(TYBookItem tYBookItem, int i10) {
        BookRankActivity.RankInfo rankInfo = this.f15882l;
        if (rankInfo != null) {
            if (this.f15881k) {
                rankInfo.setRank(i10 + 2);
            } else {
                rankInfo.setRank(i10 - 1);
            }
        }
        if (!l.q(this.f15885o) && !l.q(tYBookItem.getRecommend()) && !tYBookItem.getRecommend().contains(this.f15885o)) {
            tYBookItem.setRecommend(tYBookItem.getRecommend() + this.f15885o);
        }
        i.I(this.f15879i, tYBookItem, this.f15882l);
    }

    @Override // ya.h2.b
    public void e(int i10) {
        TYBookItem tYBookItem;
        if (this.f12824e.isEmpty() || i10 < 0 || i10 >= this.f12824e.size() || (tYBookItem = (TYBookItem) this.f12824e.get(i10)) == null || this.f15883m.contains(tYBookItem.getSourceId())) {
            return;
        }
        if (i10 == 0) {
            a.K(this.f15879i, tYBookItem.getRecommend() + this.f15885o, "展示");
        }
        this.f15883m.add(tYBookItem.getSourceId());
        MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: v */
    public void k(ViewHolderHelper viewHolderHelper, TYBookItem tYBookItem) {
        A(viewHolderHelper, tYBookItem);
    }

    public void x(RecyclerView recyclerView) {
        h2 h2Var = this.f15884n;
        if (h2Var != null) {
            h2Var.h(recyclerView, this);
        }
    }

    public final /* synthetic */ void y(TYBookItem tYBookItem, ViewHolderHelper viewHolderHelper, View view) {
        H(tYBookItem, m(viewHolderHelper));
    }

    public final /* synthetic */ void z(TYBookItem tYBookItem, ViewHolderHelper viewHolderHelper, View view) {
        H(tYBookItem, m(viewHolderHelper));
    }
}
