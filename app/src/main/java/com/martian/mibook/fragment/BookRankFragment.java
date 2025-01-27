package com.martian.mibook.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.l;
import ce.i;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.fragment.StrFragment;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.BookRankTopBinding;
import com.martian.mibook.databinding.FragmentBookRankBinding;
import com.martian.mibook.fragment.BookRankFragment;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.request.YWRankBooksParams;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.ui.FlowLayout;
import com.martian.mibook.ui.adapter.TYBookItemListAdapter;
import com.martian.mibook.ui.adapter.yuewen.YWCategoryTitleAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jc.m;
import l9.m0;

/* loaded from: classes3.dex */
public class BookRankFragment extends StrFragment implements s9.a {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;

    /* renamed from: w */
    public static final String f13623w = "CATEGORY_TYPE";

    /* renamed from: x */
    public static final int f13624x = 0;

    /* renamed from: y */
    public static final int f13625y = 50;

    /* renamed from: z */
    public static final int f13626z = 30;

    /* renamed from: l */
    public BookRankActivity.RankInfo f13628l;

    /* renamed from: p */
    public YWCategoryTitleAdapter f13632p;

    /* renamed from: q */
    public TYBookItemListAdapter f13633q;

    /* renamed from: r */
    public i f13634r;

    /* renamed from: s */
    public FragmentBookRankBinding f13635s;

    /* renamed from: t */
    public BookRankTopBinding f13636t;

    /* renamed from: v */
    public YWFreeType f13638v;

    /* renamed from: k */
    public int f13627k = 0;

    /* renamed from: m */
    public int f13629m = 0;

    /* renamed from: n */
    public int f13630n = 0;

    /* renamed from: o */
    public final List<String> f13631o = new ArrayList();

    /* renamed from: u */
    public final Set<String> f13637u = new HashSet();

    public class a implements MiBookManager.y {
        public a() {
        }

        @Override // com.martian.mibook.application.MiBookManager.y
        public void a(YWFreeType yWFreeType) {
            BookRankFragment.this.w0(yWFreeType);
            BookRankFragment.this.A();
        }

        @Override // com.martian.mibook.application.MiBookManager.y
        public void b() {
            BookRankFragment.this.A();
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) BookRankFragment.this.f13635s.rankIrc.getLayoutManager();
            if (linearLayoutManager != null) {
                if (linearLayoutManager.findLastVisibleItemPosition() <= 5) {
                    BookRankFragment.this.f13635s.bookStatusView.setVisibility(8);
                } else {
                    BookRankFragment.this.f13635s.bookStatusView.setVisibility(0);
                    BookRankFragment.this.f13635s.bookStatus.setText(BookRankFragment.this.h0());
                }
            }
        }
    }

    public class c extends m {
        public c() {
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            BookRankFragment.this.x0();
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWChannelBookList yWChannelBookList) {
            BookRankFragment.this.v0(yWChannelBookList);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                BookRankFragment.this.y0();
            }
        }
    }

    public static String e0(Activity activity, int i10) {
        if (m0.c(activity)) {
            return "";
        }
        int i11 = i10 % 10;
        return i11 == 0 ? activity.getString(R.string.category_rank_daily) : i11 == 1 ? activity.getString(R.string.category_rank_weekly) : i11 == 2 ? activity.getString(R.string.category_rank_monthly) : activity.getString(R.string.category_rank_all);
    }

    public static String f0(Activity activity, BookRankActivity.RankInfo rankInfo) {
        return m0.c(activity) ? "" : rankInfo.getRType() == 0 ? activity.getString(R.string.category_rank_daily) : rankInfo.getRType() == 1 ? activity.getString(R.string.category_rank_weekly) : rankInfo.getRType() == 2 ? activity.getString(R.string.category_rank_monthly) : activity.getString(R.string.category_rank_all);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private View j0() {
        View inflate = View.inflate(this.f12349c, R.layout.book_rank_top, null);
        BookRankTopBinding bind = BookRankTopBinding.bind(inflate);
        this.f13636t = bind;
        bind.categoryTitleIrc.setOnTouchListener(new View.OnTouchListener() { // from class: db.i
            public /* synthetic */ i() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean l02;
                l02 = BookRankFragment.this.l0(view, motionEvent);
                return l02;
            }
        });
        this.f13636t.categoryBookType.setOnItemTitleClickListener(new FlowLayout.a() { // from class: db.j
            public /* synthetic */ j() {
            }

            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i10) {
                BookRankFragment.this.m0(str, i10);
            }
        });
        this.f13636t.categoryBookStatusView.setOnItemTitleClickListener(new FlowLayout.a() { // from class: db.k
            public /* synthetic */ k() {
            }

            @Override // com.martian.mibook.ui.FlowLayout.a
            public final void a(String str, int i10) {
                BookRankFragment.this.n0(str, i10);
            }
        });
        B0();
        return inflate;
    }

    public static BookRankFragment t0(int i10, int i11, BookRankActivity.RankInfo rankInfo) {
        BookRankFragment bookRankFragment = new BookRankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MagicIndicator.f12461e, i10);
        bundle.putInt(f13623w, i11);
        if (rankInfo != null) {
            bundle.putString(BookRankActivity.C, GsonUtils.b().toJson(rankInfo));
        }
        bookRankFragment.setArguments(bundle);
        return bookRankFragment;
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public void A() {
        this.f13630n = 0;
        A0();
        this.f13633q.l().setRefresh(true);
        b0();
    }

    public final void A0() {
        this.f13636t.categoryRank.setText(f0(this.f12349c, this.f13628l));
    }

    public final void B0() {
        if (this.f13636t.categoryBookStatusView.getChildCount() <= 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f12349c.getString(R.string.withdraw_money_all));
            arrayList.add(this.f12349c.getString(R.string.bookstores_finish));
            arrayList.add(this.f12349c.getString(R.string.serialise));
            this.f13636t.categoryBookStatusView.setData(arrayList);
        }
    }

    public final void C0(TYBookItem tYBookItem, boolean z10) {
        m0.z(this.f12349c, tYBookItem.getCoverUrl(), this.f13636t.lvAccountImage1, 2, MiConfigSingleton.b2().L1());
        if (!l.q(tYBookItem.getBookName())) {
            this.f13636t.lvAccountNickname1.setText(tYBookItem.getBookName());
        }
        this.f13636t.lvAccountImage1.setOnClickListener(new View.OnClickListener() { // from class: db.f

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f25432c;

            public /* synthetic */ f(TYBookItem tYBookItem2) {
                tYBookItem = tYBookItem2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookRankFragment.this.q0(tYBookItem, view);
            }
        });
        if (l.q(tYBookItem2.getRankDesc())) {
            this.f13636t.lvAccountMoods1.setVisibility(z10 ? 4 : 8);
        } else {
            this.f13636t.lvAccountMoods1.setVisibility(0);
            this.f13636t.lvAccountMoods1.setText(tYBookItem2.getRankDesc());
        }
        u0(tYBookItem2);
    }

    public final void D0(TYBookItem tYBookItem, boolean z10) {
        m0.z(this.f12349c, tYBookItem.getCoverUrl(), this.f13636t.lvAccountImage2, 2, MiConfigSingleton.b2().L1());
        if (!l.q(tYBookItem.getBookName())) {
            this.f13636t.lvAccountNickname2.setText(tYBookItem.getBookName());
        }
        this.f13636t.lvAccountImage2.setOnClickListener(new View.OnClickListener() { // from class: db.e

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f25430c;

            public /* synthetic */ e(TYBookItem tYBookItem2) {
                tYBookItem = tYBookItem2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookRankFragment.this.r0(tYBookItem, view);
            }
        });
        if (l.q(tYBookItem2.getRankDesc())) {
            this.f13636t.lvAccountMoods2.setVisibility(z10 ? 4 : 8);
        } else {
            this.f13636t.lvAccountMoods2.setVisibility(0);
            this.f13636t.lvAccountMoods2.setText(tYBookItem2.getRankDesc());
        }
        u0(tYBookItem2);
    }

    public final void E0(TYBookItem tYBookItem, boolean z10) {
        m0.z(this.f12349c, tYBookItem.getCoverUrl(), this.f13636t.lvAccountImage3, 2, MiConfigSingleton.b2().L1());
        if (!l.q(tYBookItem.getBookName())) {
            this.f13636t.lvAccountNickname3.setText(tYBookItem.getBookName());
        }
        this.f13636t.lvAccountImage3.setOnClickListener(new View.OnClickListener() { // from class: db.d

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f25427c;

            public /* synthetic */ d(TYBookItem tYBookItem2) {
                tYBookItem = tYBookItem2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookRankFragment.this.s0(tYBookItem, view);
            }
        });
        if (l.q(tYBookItem2.getRankDesc())) {
            this.f13636t.lvAccountMoods3.setVisibility(z10 ? 4 : 8);
        } else {
            this.f13636t.lvAccountMoods3.setVisibility(0);
            this.f13636t.lvAccountMoods3.setText(tYBookItem2.getRankDesc());
        }
        u0(tYBookItem2);
    }

    public final void a0(List<TYBookItem> list) {
        boolean z10;
        int i10 = 0;
        while (true) {
            if (i10 >= 3) {
                z10 = false;
                break;
            } else {
                if (!l.q(list.get(i10).getRankDesc())) {
                    z10 = true;
                    break;
                }
                i10++;
            }
        }
        z0(true);
        C0(list.get(0), z10);
        D0(list.get(1), z10);
        E0(list.get(2), z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b0() {
        if (r()) {
            c cVar = new c();
            ((YWRankBooksParams) cVar.k()).setCtype(Integer.valueOf(this.f13629m));
            ((YWRankBooksParams) cVar.k()).setBrtype(Integer.valueOf(this.f13628l.getBrtype()));
            ((YWRankBooksParams) cVar.k()).setStatus(Integer.valueOf(this.f13628l.getRankStatus()));
            ((YWRankBooksParams) cVar.k()).setPage(Integer.valueOf(this.f13630n));
            if (this.f13636t.categoryBookType.getSelectPosition() > 0) {
                ((YWRankBooksParams) cVar.k()).setCategory(ConfigSingleton.D().f0(this.f13636t.categoryBookType.getSelectedItem()));
            }
            cVar.j();
        }
    }

    public final int d0(int i10) {
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        if (i10 != 7) {
            return i10 != 8 ? 0 : 6;
        }
        return 5;
    }

    public final String g0() {
        int rankStatus = this.f13628l.getRankStatus();
        if (rankStatus == 30) {
            return this.f12349c.getString(R.string.serialise) + "·";
        }
        if (rankStatus != 50) {
            return "";
        }
        return this.f12349c.getString(R.string.bookstores_finish) + "·";
    }

    public final String h0() {
        String str;
        YWCategoryTitleAdapter yWCategoryTitleAdapter = this.f13632p;
        String str2 = "";
        if (yWCategoryTitleAdapter == null || l.q(yWCategoryTitleAdapter.k())) {
            str = "";
        } else {
            str = this.f13632p.k() + "·";
        }
        if (this.f13636t.categoryBookType.getSelectPosition() > 0) {
            str2 = this.f13636t.categoryBookType.getSelectedItem() + "·";
        }
        return str + str2 + g0() + f0(this.f12349c, this.f13628l);
    }

    public final int i0(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? 0 : 30;
        }
        return 50;
    }

    public final void k0() {
        this.f13636t.categoryTitleIrc.setLayoutManager(new LinearLayoutManager(this.f12349c, 0, false));
        if (this.f13632p == null) {
            YWCategoryTitleAdapter yWCategoryTitleAdapter = new YWCategoryTitleAdapter(this.f12349c);
            this.f13632p = yWCategoryTitleAdapter;
            yWCategoryTitleAdapter.p(this.f13628l.getBtype());
            this.f13636t.categoryTitleIrc.setAdapter(this.f13632p);
            if (this.f13632p.j() > 0) {
                this.f13636t.categoryTitleIrc.smoothScrollToPosition(this.f13632p.j());
            }
            this.f13632p.q(new YWCategoryTitleAdapter.a() { // from class: db.c
                public /* synthetic */ c() {
                }

                @Override // com.martian.mibook.ui.adapter.yuewen.YWCategoryTitleAdapter.a
                public final void a(int i10) {
                    BookRankFragment.this.o0(i10);
                }
            });
        }
    }

    public final /* synthetic */ boolean l0(View view, MotionEvent motionEvent) {
        I(motionEvent.getAction() == 1);
        return false;
    }

    @Override // com.martian.libmars.fragment.LazyFragment
    public void m() {
        if (this.f13638v == null) {
            MiConfigSingleton.b2().M1().M2(this.f13629m, new a());
        } else {
            A();
        }
    }

    public final /* synthetic */ void m0(String str, int i10) {
        BookRankActivity.RankInfo rankInfo = this.f13628l;
        if (i10 <= 0) {
            str = "";
        }
        rankInfo.setCategory(str);
        A();
    }

    public final /* synthetic */ void n0(String str, int i10) {
        this.f13628l.setRankStatus(i0(i10));
        A();
    }

    public final /* synthetic */ void o0(int i10) {
        this.f13628l.setBrtype(this.f13632p.l() + this.f13628l.getRType());
        A();
    }

    @Override // s9.a
    public void onLoadMore(View view) {
        this.f13633q.l().setRefresh(this.f13633q.getSize() <= 0);
        this.f13635s.rankIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        b0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MagicIndicator.f12461e, this.f13627k);
        bundle.putInt(f13623w, this.f13629m);
        bundle.putString(BookRankActivity.C, GsonUtils.b().toJson(this.f13628l));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f13627k = bundle.getInt(MagicIndicator.f12461e, 0);
            this.f13629m = bundle.getInt(f13623w);
            str = bundle.getString(BookRankActivity.C);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13627k = arguments.getInt(MagicIndicator.f12461e, 0);
                this.f13629m = arguments.getInt(f13623w);
                str = arguments.getString(BookRankActivity.C);
            } else {
                str = "";
            }
        }
        if (!l.q(str)) {
            this.f13628l = (BookRankActivity.RankInfo) GsonUtils.b().fromJson(str, BookRankActivity.RankInfo.class);
        }
        if (this.f13628l == null) {
            this.f13628l = new BookRankActivity.RankInfo();
        }
        this.f13635s = FragmentBookRankBinding.bind(t());
        TYBookItemListAdapter tYBookItemListAdapter = new TYBookItemListAdapter(this.f12349c);
        this.f13633q = tYBookItemListAdapter;
        tYBookItemListAdapter.D(this.f13628l);
        this.f13633q.C(true);
        this.f13635s.rankIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        this.f13635s.rankIrc.setLayoutManager(new LinearLayoutManager(this.f12349c));
        this.f13635s.rankIrc.setOnLoadMoreListener(this);
        this.f13635s.rankIrc.k(j0());
        this.f13635s.rankIrc.setAdapter(this.f13633q);
        this.f13635s.rankIrc.addOnScrollListener(new b());
        this.f13635s.categoryLoadingTip.setOnReloadListener(new LoadingTip.b() { // from class: db.g
            public /* synthetic */ g() {
            }

            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                BookRankFragment.this.A();
            }
        });
        this.f13635s.bookStatusView.setOnClickListener(new View.OnClickListener() { // from class: db.h
            public /* synthetic */ h() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BookRankFragment.this.p0(view2);
            }
        });
        k0();
        YWFreeType F1 = MiConfigSingleton.b2().M1().F1(this.f13629m);
        this.f13638v = F1;
        w0(F1);
    }

    public final /* synthetic */ void p0(View view) {
        if (this.f13633q.getSize() <= 100) {
            this.f13635s.rankIrc.smoothScrollToPosition(0);
        } else {
            this.f13635s.rankIrc.scrollToPosition(0);
        }
    }

    public final /* synthetic */ void q0(TYBookItem tYBookItem, View view) {
        this.f13628l.setRank(1);
        je.i.I(this.f12349c, tYBookItem, this.f13628l);
    }

    public final /* synthetic */ void r0(TYBookItem tYBookItem, View view) {
        this.f13628l.setRank(2);
        je.i.I(this.f12349c, tYBookItem, this.f13628l);
    }

    public final /* synthetic */ void s0(TYBookItem tYBookItem, View view) {
        this.f13628l.setRank(3);
        je.i.I(this.f12349c, tYBookItem, this.f13628l);
    }

    @Override // com.martian.libmars.fragment.StrFragment
    public int u() {
        return R.layout.fragment_book_rank;
    }

    public final void u0(TYBookItem tYBookItem) {
        if (this.f13637u.contains(tYBookItem.getSourceId())) {
            return;
        }
        MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        this.f13637u.add(tYBookItem.getSourceId());
    }

    public final void v0(YWChannelBookList yWChannelBookList) {
        BookRankActivity.RankInfo rankInfo;
        if (m0.c(this.f12349c)) {
            return;
        }
        BookRankTopBinding bookRankTopBinding = this.f13636t;
        if (bookRankTopBinding != null && (rankInfo = this.f13628l) != null) {
            bookRankTopBinding.categoryBookStatusView.setVisibility(rankInfo.getBtype() == 110 ? 8 : 0);
        }
        H();
        this.f13630n++;
        if (yWChannelBookList != null && yWChannelBookList.getBookList() != null && yWChannelBookList.getBookList().size() > 0) {
            if (!l.q(this.f13628l.getSource())) {
                for (TYBookItem tYBookItem : yWChannelBookList.getBookList()) {
                    tYBookItem.setRecommend(this.f13628l.getSource() + tYBookItem.getRecommend());
                }
            }
            if (this.f13633q.l().isRefresh()) {
                if (yWChannelBookList.getBookList().size() >= 3) {
                    a0(yWChannelBookList.getBookList());
                    yWChannelBookList.getBookList().remove(0);
                    yWChannelBookList.getBookList().remove(0);
                    yWChannelBookList.getBookList().remove(0);
                    this.f13633q.F(true);
                } else {
                    z0(false);
                    this.f13633q.F(false);
                }
                this.f13633q.a(yWChannelBookList.getBookList());
                this.f13633q.x(this.f13635s.rankIrc);
                ((RelativeLayout.LayoutParams) this.f13635s.categoryLoadingTip.getLayoutParams()).setMargins(0, this.f13636t.bookRankTopView.getHeight(), 0, 0);
            } else if (yWChannelBookList.getBookList().size() > 0) {
                this.f13635s.rankIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                this.f13633q.h(yWChannelBookList.getBookList());
            } else {
                this.f13635s.rankIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            }
        } else if (this.f13633q.getSize() >= 10) {
            this.f13635s.rankIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
        } else {
            this.f13635s.rankIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
        }
        if (this.f13633q.getSize() <= 0) {
            this.f13635s.categoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
            return;
        }
        this.f13635s.categoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        BookRankTopBinding bookRankTopBinding2 = this.f13636t;
        if (bookRankTopBinding2 != null) {
            bookRankTopBinding2.bookRankTopView.setVisibility(0);
        }
    }

    public final void w0(YWFreeType yWFreeType) {
        if (yWFreeType == null || m0.c(this.f12349c)) {
            return;
        }
        this.f13638v = yWFreeType;
        this.f13631o.add(this.f12349c.getString(R.string.withdraw_money_all));
        int i10 = 1;
        for (YWCategory yWCategory : this.f13638v.getCategoryList()) {
            if (!l.q(yWCategory.getCategoryName())) {
                this.f13631o.add(yWCategory.getCategoryName());
                if (this.f13628l.getCategoryId() != -1 && this.f13628l.getCategoryId() == yWCategory.getCategoryId()) {
                    this.f13636t.categoryBookType.setSelectPosition(i10);
                    this.f13632p.p(this.f13628l.getBtype());
                    this.f13636t.categoryTitleIrc.smoothScrollToPosition(this.f13632p.j());
                } else if (!l.q(this.f13628l.getCategory()) && this.f13628l.getCategory().equalsIgnoreCase(yWCategory.getCategoryName())) {
                    this.f13636t.categoryBookType.setSelectPosition(i10);
                    this.f13632p.p(this.f13628l.getBtype());
                    this.f13636t.categoryTitleIrc.smoothScrollToPosition(this.f13632p.j());
                }
                i10++;
            }
        }
        this.f13636t.categoryBookType.setData(this.f13631o);
    }

    public void x0() {
        if (m0.C(this.f12349c)) {
            H();
            TYBookItemListAdapter tYBookItemListAdapter = this.f13633q;
            if (tYBookItemListAdapter == null || tYBookItemListAdapter.getSize() <= 0) {
                this.f13635s.categoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.network_error);
            }
        }
    }

    public void y0() {
        if (m0.C(this.f12349c) && this.f13633q.l().isRefresh() && this.f13633q.getSize() <= 0) {
            this.f13635s.categoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
    }

    public final void z0(boolean z10) {
        this.f13636t.bookGrabRankView.setVisibility(z10 ? 0 : 8);
    }
}
