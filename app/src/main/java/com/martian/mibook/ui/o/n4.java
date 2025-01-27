package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.u0;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.ttbookhd.R;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes4.dex */
public class n4 extends com.martian.libmars.widget.recyclerview.e.c<TYBookItem> implements u0.b {

    /* renamed from: g */
    private final com.martian.libmars.activity.j1 f14583g;

    /* renamed from: h */
    private boolean f14584h;

    /* renamed from: i */
    private boolean f14585i;

    /* renamed from: j */
    private BookRankActivity.a f14586j;
    private final Set<String> k;
    private final com.martian.mibook.application.u0 l;
    private String m;
    private String n;

    public n4(com.martian.libmars.activity.j1 activity) {
        super(activity, R.layout.bs_book_store_item);
        this.f14584h = false;
        this.f14585i = false;
        this.k = new HashSet();
        this.m = "";
        this.n = "";
        this.f14583g = activity;
        this.l = new com.martian.mibook.application.u0();
    }

    private SpannableString P(String name) {
        return com.martian.libsupport.k.l(this.f14583g, name, this.n, R.color.theme_default);
    }

    /* renamed from: R */
    public /* synthetic */ void S(final TYBookItem tyBookItem, final com.martian.libmars.widget.recyclerview.d holder, View v) {
        c0(tyBookItem, F(holder));
    }

    /* renamed from: T */
    public /* synthetic */ void U(final TYBookItem tyBookItem, final com.martian.libmars.widget.recyclerview.d holder, View v) {
        c0(tyBookItem, F(holder));
    }

    private void V(final com.martian.libmars.widget.recyclerview.d holder, final TYBookItem tyBookItem) {
        if (tyBookItem == null) {
            return;
        }
        com.martian.libmars.utils.n0.p(this.f14583g, tyBookItem.getCoverUrl(), (ImageView) holder.getView(R.id.bs_list_cover), MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
        TextView textView = (TextView) holder.getView(R.id.bs_list_book_name);
        TextView textView2 = (TextView) holder.getView(R.id.bs_list_author_name);
        TextView textView3 = (TextView) holder.getView(R.id.bs_list_short_content);
        String title = tyBookItem.getTitle();
        String bookInfo = tyBookItem.getBookInfo();
        String v = com.martian.libsupport.k.v(tyBookItem.getIntro());
        if (com.martian.libsupport.k.p(this.n)) {
            textView.setText(title);
            textView2.setText(bookInfo);
            textView3.setText(com.martian.libsupport.k.v(v));
        } else {
            if (!com.martian.libsupport.k.p(title)) {
                if (title.contains(this.n)) {
                    textView.setText(P(title));
                } else {
                    textView.setText(title);
                }
            }
            StringBuilder sb = new StringBuilder();
            if (!tyBookItem.getRoleList().isEmpty()) {
                sb.append("主角：");
                for (String str : tyBookItem.getRoleList()) {
                    sb.append(" ");
                    sb.append(str);
                }
            }
            if (sb.toString().contains(this.n)) {
                textView2.setText(P(sb.toString()));
            } else if (bookInfo.contains(this.n)) {
                textView2.setText(P(bookInfo));
            } else {
                textView2.setText(bookInfo);
            }
            if (!com.martian.libsupport.k.p(v)) {
                if (v.contains(this.n)) {
                    textView3.setText(P(v));
                } else {
                    textView3.setText(v);
                }
            }
        }
        if (this.f14584h) {
            holder.H(R.id.bs_list_book_mark, R.drawable.bg_book_rank_4);
            if (this.f14585i) {
                holder.W(R.id.bs_list_book_mark, "NO." + (F(holder) + 2));
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NO.");
                sb2.append(F(holder) - 1);
                holder.W(R.id.bs_list_book_mark, sb2.toString());
            }
        } else {
            holder.a0(R.id.bs_list_book_mark, false);
        }
        b0((TextView) holder.getView(R.id.bs_list_score), tyBookItem);
        holder.N(R.id.book_item_root, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n4.this.S(tyBookItem, holder, view);
            }
        });
        holder.N(R.id.bs_list_cover, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n4.this.U(tyBookItem, holder, view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    private void b0(@NonNull TextView textView, @NonNull TYBookItem bookItem) {
        if (this.f14584h && !com.martian.libsupport.k.p(bookItem.getRankDesc())) {
            textView.setVisibility(0);
            textView.setText(bookItem.getRankDesc());
        } else {
            if (bookItem.getScore() <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            double score = bookItem.getScore();
            Double.isNaN(score);
            textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(score / 10.0d)) + "分");
        }
    }

    private void c0(TYBookItem tyBookItem, int position) {
        BookRankActivity.a aVar = this.f14586j;
        if (aVar != null) {
            if (this.f14585i) {
                aVar.p(position + 2);
            } else {
                aVar.p(position - 1);
            }
        }
        if (!com.martian.libsupport.k.p(this.m) && !com.martian.libsupport.k.p(tyBookItem.getRecommend()) && !tyBookItem.getRecommend().contains(this.m)) {
            tyBookItem.setRecommend(tyBookItem.getRecommend() + this.m);
        }
        com.martian.mibook.j.s2.V(this.f14583g, tyBookItem, this.f14586j);
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, TYBookItem tyBookItem) {
        V(helper, tyBookItem);
    }

    public void Q(RecyclerView irc) {
        com.martian.mibook.application.u0 u0Var = this.l;
        if (u0Var != null) {
            u0Var.f(irc, this);
        }
    }

    public void W(String keyword) {
        this.n = keyword;
    }

    public void X(boolean labelShow) {
        this.f14584h = labelShow;
        notifyDataSetChanged();
    }

    public void Y(BookRankActivity.a rankInfo) {
        this.f14586j = rankInfo;
    }

    public void Z(String type) {
        this.m = type;
    }

    public void a0(boolean withTop) {
        this.f14585i = withTop;
    }

    @Override // com.martian.mibook.application.u0.b
    public void j(int position) {
        TYBookItem tYBookItem;
        if (this.f10476c.isEmpty() || position < 0 || position >= this.f10476c.size() || (tYBookItem = (TYBookItem) this.f10476c.get(position)) == null || this.k.contains(tYBookItem.getSourceId())) {
            return;
        }
        if (position == 0) {
            com.martian.mibook.lib.model.g.b.S(this.f14583g, tYBookItem.getRecommend() + this.m, "展示");
        }
        this.k.add(tYBookItem.getSourceId());
        MiConfigSingleton.V3().l3().I1(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
    }
}
