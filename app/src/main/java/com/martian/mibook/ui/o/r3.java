package com.martian.mibook.ui.o;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.BookCategoryActivity;
import com.martian.mibook.activity.book.BookRankActivity;
import com.martian.mibook.activity.book.FinishedOrNewBooksActivity;
import com.martian.mibook.activity.book.YWChannelBooksActivity;
import com.martian.mibook.activity.book.YWDiscountBooksActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.u0;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.request.YWChannelBooksParams;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class r3 extends com.martian.libmars.widget.recyclerview.e.d<YWBookChannel> implements u0.b {

    /* renamed from: h */
    public static final int f14659h = 0;

    /* renamed from: i */
    public static final int f14660i = 1;

    /* renamed from: j */
    public static final int f14661j = 2;
    public static final int k = -1;
    public static final int l = -2;
    public static final int m = -4;
    public static final int n = -1000007;
    public static final int o = -1000008;
    public static final int p = -1000005;
    public static final int q = -1000006;
    public static final int r = -1000009;
    public static final int s = -1000010;
    public static final int t = -1000099;
    public static final int u = -3000001;
    public static final int v = -3000002;
    private g A;
    private s3 B;
    private t3 C;
    private final com.martian.libmars.activity.j1 w;
    private int x;
    private final int y;
    private final com.martian.mibook.application.u0 z;

    class a implements com.martian.libmars.widget.recyclerview.h.a<YWBookChannel> {
        a() {
        }

        @Override // com.martian.libmars.widget.recyclerview.h.a
        public int b(int type) {
            return type != -4 ? type != 1 ? type != -2 ? type != -1 ? R.layout.bs_book_store_item_list : R.layout.bs_book_store_item_list_category : R.layout.bs_book_store_item_grid_rank : R.layout.bs_book_store_item_grid : R.layout.bs_book_store_item_gender_guide;
        }

        @Override // com.martian.libmars.widget.recyclerview.h.a
        /* renamed from: c */
        public int a(int position, YWBookChannel ywBookChannel) {
            if (ywBookChannel == null) {
                return 1;
            }
            Integer mcid = ywBookChannel.getMcid();
            if (mcid != null) {
                if (mcid.intValue() == -1000099) {
                    return -4;
                }
                List<YWBookChannel.SubTab> subtabs = ywBookChannel.getSubtabs();
                if (subtabs != null && !subtabs.isEmpty()) {
                    if (mcid.intValue() == -1000006 || mcid.intValue() == -1000005) {
                        return -2;
                    }
                    if (mcid.intValue() == -1000010 || mcid.intValue() == -1000009) {
                        return -1;
                    }
                }
            }
            return ywBookChannel.getLayoutType();
        }
    }

    class b extends com.martian.libmars.utils.tablayout.f {

        /* renamed from: b */
        final /* synthetic */ List f14662b;

        /* renamed from: c */
        final /* synthetic */ ViewPager f14663c;

        b(final List val$categoryVp, final ViewPager val$subTabs) {
            this.f14662b = val$categoryVp;
            this.f14663c = val$subTabs;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public int a() {
            List list = this.f14662b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.h b(Context context) {
            return null;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.j c(Context context, final int index) {
            com.martian.libmars.utils.tablayout.o oVar = new com.martian.libmars.utils.tablayout.o(context, false);
            boolean I0 = com.martian.libmars.d.h.F().I0();
            oVar.setText(((YWBookChannel.SubTab) this.f14662b.get(index)).getTitle());
            oVar.setTextSize(14.0f);
            oVar.setPadding(com.martian.libmars.d.h.b(12.0f), com.martian.libmars.d.h.b(5.0f), com.martian.libmars.d.h.b(12.0f), com.martian.libmars.d.h.b(5.0f));
            oVar.setNormalColor(com.martian.libmars.d.h.F().r0());
            oVar.setSelectedColor(ContextCompat.getColor(((com.martian.libmars.widget.recyclerview.e.c) r3.this).f10474a, R.color.theme_default));
            int i2 = R.drawable.border_search_background_night_card;
            oVar.setmSelectedRes(I0 ? R.drawable.border_search_background_night_card : R.drawable.border_mission_button);
            oVar.setTextStyleMode(1);
            if (!I0) {
                i2 = R.drawable.border_search_background_day;
            }
            oVar.setmNormalRes(i2);
            final ViewPager viewPager = this.f14663c;
            oVar.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPager.this.setCurrentItem(index);
                }
            });
            return oVar;
        }
    }

    class c implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        final /* synthetic */ MagicIndicator f14665a;

        c(final MagicIndicator val$magicIndicator) {
            this.f14665a = val$magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f14665a.b(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            this.f14665a.c(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            this.f14665a.d(position);
            r3.this.B.j(position);
        }
    }

    class d extends com.martian.libmars.utils.tablayout.f {

        /* renamed from: b */
        final /* synthetic */ List f14667b;

        /* renamed from: c */
        final /* synthetic */ ViewPager f14668c;

        d(final List val$bookRankVp, final ViewPager val$subTabs) {
            this.f14667b = val$bookRankVp;
            this.f14668c = val$subTabs;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public int a() {
            return this.f14667b.size();
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.h b(Context context) {
            return null;
        }

        @Override // com.martian.libmars.utils.tablayout.f
        public com.martian.libmars.utils.tablayout.j c(Context context, final int index) {
            com.martian.libmars.utils.tablayout.m mVar = new com.martian.libmars.utils.tablayout.m(context, false);
            mVar.setText(((YWBookChannel.SubTab) this.f14667b.get(index)).getTitle());
            mVar.setTextSize(18.0f);
            mVar.setMinScaleType(true);
            mVar.setTextStyleMode(1);
            mVar.setPadding(0, 0, com.martian.libmars.d.h.b(20.0f), 0);
            mVar.setNormalColor(com.martian.libmars.d.h.F().r0());
            mVar.setSelectedColor(com.martian.libmars.d.h.F().p0());
            final ViewPager viewPager = this.f14668c;
            mVar.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPager.this.setCurrentItem(index);
                }
            });
            return mVar;
        }
    }

    class e implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        final /* synthetic */ MagicIndicator f14670a;

        e(final MagicIndicator val$magicIndicator) {
            this.f14670a = val$magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f14670a.b(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            this.f14670a.c(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            this.f14670a.d(position);
            if (r3.this.C != null) {
                r3.this.C.l(position);
            }
        }
    }

    class f extends com.martian.mibook.lib.yuewen.e.h {

        /* renamed from: h */
        final /* synthetic */ View f14672h;

        /* renamed from: i */
        final /* synthetic */ View f14673i;

        /* renamed from: j */
        final /* synthetic */ YWBookChannel f14674j;

        f(final View val$ywBookChannel, final View val$refreshProgressbar, final YWBookChannel val$refreshLoadIcon) {
            this.f14672h = val$ywBookChannel;
            this.f14673i = val$refreshProgressbar;
            this.f14674j = val$refreshLoadIcon;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f14672h.setVisibility(0);
            this.f14673i.setVisibility(8);
            r3.this.w.k1(errorResult.d());
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWChannelBookList ywChannelBookList) {
            this.f14672h.setVisibility(0);
            this.f14673i.setVisibility(8);
            if (ywChannelBookList == null || this.f14674j.getBookList() == null || ywChannelBookList.getBookList().isEmpty()) {
                return;
            }
            this.f14674j.setBookList(ywChannelBookList.getBookList());
            YWBookChannel yWBookChannel = this.f14674j;
            yWBookChannel.setPageIndex(Integer.valueOf(yWBookChannel.getPageIndex().intValue() + 1));
            MiConfigSingleton.V3().l3().K1(this.f14674j.getBookList());
            r3.this.notifyDataSetChanged();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    public interface g {
        void a();

        void b();
    }

    public r3(com.martian.libmars.activity.j1 activity, final List<YWBookChannel> datas, int seed, int ctype) {
        super(activity, datas, new a());
        this.w = activity;
        this.x = seed;
        this.y = ctype;
        this.z = new com.martian.mibook.application.u0();
    }

    private void B0(final com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        if (this.B != null) {
            return;
        }
        List<YWBookChannel.SubTab> subtabs = ywBookChannel.getSubtabs();
        final ViewPager viewPager = (ViewPager) holder.getView(R.id.list_item_category_vp);
        final MagicIndicator magicIndicator = (MagicIndicator) holder.getView(R.id.magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(this.f10474a);
        commonNavigator.setMarginHorizontal(com.martian.libmars.d.h.b(8.0f));
        commonNavigator.setLeftPadding(com.martian.libmars.d.h.b(4.0f));
        commonNavigator.setAdapter(new b(subtabs, viewPager));
        magicIndicator.setNavigator(commonNavigator);
        subtabs.get(0).setBookList(ywBookChannel.getBookList());
        this.B = new s3(this.w, subtabs, ywBookChannel.getMcid().intValue());
        LoadingTip loadingTip = (LoadingTip) holder.getView(R.id.list_item_category_loading_tip);
        this.B.g(loadingTip);
        loadingTip.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.mibook.ui.o.x
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                r3.this.b0(viewPager);
            }
        });
        viewPager.setAdapter(this.B);
        viewPager.addOnPageChangeListener(new c(magicIndicator));
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) holder.getView(R.id.list_category_view);
        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) holder.getView(R.id.content_more);
        themeLinearLayout.setSelectableLayout(true);
        themeLinearLayout2.setSelectableLayout(false);
        holder.N(R.id.list_category_view, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.this.d0(ywBookChannel, magicIndicator, view);
            }
        });
    }

    private void C0(final com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        holder.a0(R.id.grid_item_bottom_view, true);
        holder.a0(R.id.grid_item_top_view, false);
        holder.a0(R.id.grid_item_vertical_view, false);
        ((IntervalCountdownTextView) holder.getView(R.id.tv_time)).n(ywBookChannel.getTargetTime());
        holder.N(R.id.content_more, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.this.f0(view);
            }
        });
        com.martian.mibook.j.y2.f(this.w, ywBookChannel.getBookList(), (LinearLayout) holder.getView(R.id.grid_item_bottom_view), true, 0, true);
    }

    private void D0(final com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        String title = ywBookChannel.getTitle();
        holder.a0(R.id.title_view, !com.martian.libsupport.k.p(title));
        holder.W(R.id.content_title, title);
        ImageView imageView = (ImageView) holder.getView(R.id.tv_bg);
        if (com.martian.libsupport.k.p(ywBookChannel.getTopBgUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            com.martian.libmars.utils.n0.k(this.w, ywBookChannel.getTopBgUrl(), imageView);
        }
        holder.a0(R.id.content_more, true);
        holder.W(R.id.author_book_more, this.w.getString(R.string.search_recommend_tags));
        holder.K(R.id.author_book_more_view, R.drawable.loan_more);
        B0(holder, ywBookChannel);
    }

    private void E0(com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        holder.W(R.id.content_title, ywBookChannel.getTitle());
        holder.a0(R.id.content_more, false);
        final View view = holder.getView(R.id.tv_close);
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                r3.this.l0(view2);
            }
        });
        holder.N(R.id.tv_gender_male, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                r3.this.h0(view, view2);
            }
        });
        holder.N(R.id.tv_gender_female, new View.OnClickListener() { // from class: com.martian.mibook.ui.o.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                r3.this.j0(view, view2);
            }
        });
    }

    private void F0(final com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        Integer mcid = ywBookChannel.getMcid();
        List<TYBookItem> bookList = ywBookChannel.getBookList();
        boolean z = true;
        if (com.martian.libsupport.k.p(ywBookChannel.getTitle())) {
            holder.a0(R.id.title_view, false);
        } else {
            holder.a0(R.id.title_view, true);
            holder.W(R.id.content_title, ywBookChannel.getTitle());
        }
        ImageView imageView = (ImageView) holder.getView(R.id.tv_bg);
        if (com.martian.libsupport.k.p(ywBookChannel.getTopBgUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            com.martian.libmars.utils.n0.k(this.w, ywBookChannel.getTopBgUrl(), imageView);
        }
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) holder.getView(R.id.grid_item_root);
        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) holder.getView(R.id.content_more);
        themeLinearLayout.setSelectableLayout(false);
        themeLinearLayout2.setSelectableLayout(false);
        int bottomType = ywBookChannel.getBottomType();
        if (bottomType > 0) {
            holder.a0(R.id.content_more, true);
            if (bottomType == 1) {
                holder.W(R.id.author_book_more, this.w.getString(R.string.search_recommend_tags));
                holder.K(R.id.author_book_more_view, R.drawable.loan_more);
                themeLinearLayout.setSelectableLayout(true);
                themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r3.this.n0(ywBookChannel, view);
                    }
                });
            } else {
                holder.W(R.id.author_book_more, this.w.getString(R.string.switch_more));
                holder.K(R.id.author_book_more_view, R.drawable.icon_bookmall_refresh);
                themeLinearLayout2.setSelectableLayout(true);
                themeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r3.this.p0(ywBookChannel, holder, view);
                    }
                });
            }
        } else {
            holder.a0(R.id.content_more, false);
        }
        boolean z2 = mcid.intValue() == -1000007 || mcid.intValue() == -1000008;
        holder.a0(R.id.tv_time, z2);
        if (z2) {
            C0(holder, ywBookChannel);
            return;
        }
        if (mcid.intValue() == -3000001 || mcid.intValue() == -3000002) {
            z0(holder, ywBookChannel);
            return;
        }
        int size = bookList.size();
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.grid_item_top_view);
        linearLayout.setVisibility(size == 6 ? 8 : 0);
        holder.a0(R.id.grid_item_bottom_view, size == 5 || size == 8);
        if (size != 6 && size != 7) {
            z = false;
        }
        holder.a0(R.id.grid_item_vertical_view, z);
        if (size <= 4 || size >= 8) {
            linearLayout.setPadding(com.martian.libmars.d.h.b(6.0f), 0, com.martian.libmars.d.h.b(6.0f), 0);
            com.martian.mibook.j.y2.f(this.w, bookList, linearLayout, false, 0, true);
        } else if (size == 5 || size == 7) {
            linearLayout.setPadding(0, 0, 0, 0);
            linearLayout.removeAllViews();
            com.martian.mibook.j.y2.k(linearLayout, this.w, bookList.get(0), null);
        }
        if (size == 6 || size == 7) {
            com.martian.mibook.j.y2.i(this.w, bookList, (LinearLayout) holder.getView(R.id.grid_item_left_view), (LinearLayout) holder.getView(R.id.grid_item_right_view), size - 6);
        } else if (size == 5 || size >= 8) {
            com.martian.mibook.j.y2.f(this.w, bookList, (LinearLayout) holder.getView(R.id.grid_item_bottom_view), false, size - 4, true);
        }
    }

    private void G0(com.martian.libmars.widget.recyclerview.d holder, YWBookChannel ywBookChannel) {
        String title = ywBookChannel.getTitle();
        holder.a0(R.id.title_view, !com.martian.libsupport.k.p(title));
        holder.W(R.id.content_title, title);
        ImageView imageView = (ImageView) holder.getView(R.id.tv_bg);
        if (com.martian.libsupport.k.p(ywBookChannel.getTopBgUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            com.martian.libmars.utils.n0.k(this.w, ywBookChannel.getTopBgUrl(), imageView);
        }
        holder.a0(R.id.content_more, true);
        holder.W(R.id.author_book_more, this.w.getString(R.string.whole_rank));
        holder.K(R.id.author_book_more_view, R.drawable.loan_more);
        I0(holder, ywBookChannel);
    }

    private void H0(final com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        String title = ywBookChannel.getTitle();
        holder.a0(R.id.title_view, !com.martian.libsupport.k.p(title));
        holder.W(R.id.content_title, title);
        int bottomType = ywBookChannel.getBottomType();
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) holder.getView(R.id.list_item_root);
        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) holder.getView(R.id.content_more);
        themeLinearLayout.setSelectableLayout(false);
        themeLinearLayout2.setSelectableLayout(false);
        holder.a0(R.id.content_more, bottomType > 0);
        if (bottomType <= 1) {
            holder.W(R.id.author_book_more, this.w.getString(R.string.search_recommend_tags));
            holder.K(R.id.author_book_more_view, R.drawable.loan_more);
            if (bottomType == 1) {
                themeLinearLayout.setSelectableLayout(true);
                themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r3.this.r0(ywBookChannel, view);
                    }
                });
            }
        } else {
            holder.W(R.id.author_book_more, this.w.getString(R.string.switch_more));
            holder.K(R.id.author_book_more_view, R.drawable.icon_bookmall_refresh);
            themeLinearLayout2.setSelectableLayout(true);
            themeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r3.this.t0(ywBookChannel, holder, view);
                }
            });
        }
        ImageView imageView = (ImageView) holder.getView(R.id.tv_bg);
        if (com.martian.libsupport.k.p(ywBookChannel.getTopBgUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            com.martian.libmars.utils.n0.k(this.w, ywBookChannel.getTopBgUrl(), imageView);
        }
        com.martian.mibook.j.y2.j(this.w, (LinearLayout) holder.getView(R.id.bookmall_list_view), ywBookChannel.getBookList(), bottomType == 0);
    }

    private void I0(com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        if (this.C != null) {
            return;
        }
        final MagicIndicator magicIndicator = (MagicIndicator) holder.getView(R.id.title_magic_indicator);
        MagicIndicator magicIndicator2 = (MagicIndicator) holder.getView(R.id.grid_magic_indicator);
        final ViewPager viewPager = (ViewPager) holder.getView(R.id.grid_item_rank_vp);
        magicIndicator2.setVisibility(8);
        final List<YWBookChannel.SubTab> subtabs = ywBookChannel.getSubtabs();
        if (subtabs == null || subtabs.isEmpty()) {
            holder.a0(R.id.content_title, !com.martian.libsupport.k.p(ywBookChannel.getTitle()));
            magicIndicator.setVisibility(8);
        } else {
            holder.a0(R.id.content_title, false);
            magicIndicator.setVisibility(0);
            if (subtabs.get(0).getCategories().isEmpty()) {
                ((RelativeLayout) holder.getView(R.id.grid_item_rank_vp_view)).getLayoutParams().height = com.martian.libmars.d.h.b(336.0f);
            }
            subtabs.get(0).setBookList(ywBookChannel.getBookList());
            CommonNavigator commonNavigator = new CommonNavigator(this.f10474a);
            commonNavigator.setMarginHorizontal(0);
            commonNavigator.setAdapter(new d(subtabs, viewPager));
            magicIndicator.setNavigator(commonNavigator);
        }
        this.C = new t3(this.w, subtabs, ywBookChannel.getMcid().intValue(), this.x);
        LoadingTip loadingTip = (LoadingTip) holder.getView(R.id.grid_item_rank_loading_tip);
        this.C.i(loadingTip);
        loadingTip.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.mibook.ui.o.r
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                r3.this.v0(viewPager);
            }
        });
        viewPager.setAdapter(this.C);
        viewPager.addOnPageChangeListener(new e(magicIndicator));
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) holder.getView(R.id.grid_rank_view);
        themeLinearLayout.setSelectableLayout(true);
        ((ThemeLinearLayout) holder.getView(R.id.content_more)).setSelectableLayout(false);
        themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r3.this.x0(subtabs, magicIndicator, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void T(final YWBookChannel ywBookChannel, final View refreshLoadIcon, final View refreshProgressbar) {
        refreshLoadIcon.setVisibility(8);
        refreshProgressbar.setVisibility(0);
        f fVar = new f(refreshLoadIcon, refreshProgressbar, ywBookChannel);
        ((YWChannelBooksParams) fVar.k()).setMcid(ywBookChannel.getMcid());
        ((YWChannelBooksParams) fVar.k()).setPage(ywBookChannel.getPageIndex());
        ((YWChannelBooksParams) fVar.k()).setSeed(Integer.valueOf(this.x));
        ((YWChannelBooksParams) fVar.k()).setPageSize(ywBookChannel.getSize());
        fVar.j();
    }

    private void U(final View tv_close, final int gender) {
        com.martian.libmars.activity.j1 j1Var;
        int i2;
        com.martian.libmars.activity.j1 j1Var2 = this.w;
        String string = j1Var2.getString(R.string.prompt);
        StringBuilder sb = new StringBuilder();
        sb.append(this.w.getString(R.string.gender_set));
        if (gender == 2) {
            j1Var = this.w;
            i2 = R.string.female;
        } else {
            j1Var = this.w;
            i2 = R.string.male;
        }
        sb.append(j1Var.getString(i2));
        sb.append(this.w.getString(R.string.novel));
        sb.append(this.w.getString(R.string.gender_change_hint3));
        com.martian.libmars.utils.k0.P(j1Var2, string, sb.toString(), new k0.l() { // from class: com.martian.mibook.ui.o.l
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                r3.this.Z(gender, tv_close);
            }
        });
    }

    private boolean W(YWBookChannel ywBookChannel) {
        if (ywBookChannel == null) {
            return false;
        }
        if (com.martian.apptask.g.g.b(this.w, ywBookChannel.getBottomDeeplink())) {
            com.martian.apptask.g.g.u(this.w, ywBookChannel.getBottomDeeplink(), "", "", true);
            return true;
        }
        if (com.martian.libsupport.k.p(ywBookChannel.getBottomUrl())) {
            return false;
        }
        MiWebViewActivity.f5(this.w, ywBookChannel.getBottomUrl());
        return true;
    }

    /* renamed from: Y */
    public /* synthetic */ void Z(final int gender, final View tv_close) {
        g gVar;
        MiConfigSingleton.V3().q7(gender);
        if (gender == 2 && (gVar = this.A) != null) {
            gVar.b();
        }
        if (tv_close != null) {
            tv_close.performClick();
        }
    }

    /* renamed from: a0 */
    public /* synthetic */ void b0(final ViewPager categoryVp) {
        this.B.j(categoryVp.getCurrentItem());
    }

    /* renamed from: c0 */
    public /* synthetic */ void d0(final YWBookChannel ywBookChannel, final MagicIndicator magicIndicator, View view) {
        String title;
        if (W(ywBookChannel)) {
            return;
        }
        if (ywBookChannel.getMcid().intValue() == -1000010 || ywBookChannel.getMcid().intValue() == -1000009) {
            BookCategoryActivity.t2(this.w, this.y);
            return;
        }
        String e2 = this.B.e(magicIndicator.getSelectPosition());
        if (com.martian.libsupport.k.p(e2) || "全部".equalsIgnoreCase(e2)) {
            title = ywBookChannel.getTitle();
        } else {
            title = ywBookChannel.getTitle() + "-" + e2;
        }
        YWChannelBooksActivity.r2(this.w, title, ywBookChannel.getMcid(), this.x, 0, this.B.c(magicIndicator.getSelectPosition()));
    }

    /* renamed from: e0 */
    public /* synthetic */ void f0(View view) {
        MiConfigSingleton.V3().e7(this.y);
        this.w.startActivity(YWDiscountBooksActivity.class);
    }

    /* renamed from: g0 */
    public /* synthetic */ void h0(final View tv_close, View view) {
        U(tv_close, 1);
    }

    /* renamed from: i0 */
    public /* synthetic */ void j0(final View tv_close, View view) {
        U(tv_close, 2);
    }

    /* renamed from: k0 */
    public /* synthetic */ void l0(View view) {
        List<T> list = this.f10476c;
        if (list == 0 || list.size() <= 1 || !((YWBookChannel) this.f10476c.get(1)).getMcid().equals(Integer.valueOf(t))) {
            return;
        }
        this.f10476c.remove(1);
        notifyDataSetChanged();
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* renamed from: m0 */
    public /* synthetic */ void n0(final YWBookChannel ywBookChannel, View view) {
        if (W(ywBookChannel)) {
            return;
        }
        if (ywBookChannel.getTid() != null) {
            FinishedOrNewBooksActivity.startActivity(this.w, ywBookChannel.getTid().intValue(), this.y, ywBookChannel.getTitle());
        } else {
            YWChannelBooksActivity.r2(this.w, ywBookChannel.getTitle(), ywBookChannel.getMcid(), this.x, ((ywBookChannel.getPageIndex().intValue() - 1) * ywBookChannel.getSize().intValue()) / 10, "");
        }
    }

    /* renamed from: o0 */
    public /* synthetic */ void p0(final YWBookChannel ywBookChannel, final com.martian.libmars.widget.recyclerview.d holder, View view) {
        T(ywBookChannel, holder.getView(R.id.author_book_more_view), holder.getView(R.id.book_more_progressbar));
        com.martian.mibook.lib.model.g.b.S(this.f10474a, ywBookChannel.getTitle(), "换一批");
    }

    /* renamed from: q0 */
    public /* synthetic */ void r0(final YWBookChannel ywBookChannel, View view) {
        if (W(ywBookChannel)) {
            return;
        }
        if (ywBookChannel.getTid() != null) {
            FinishedOrNewBooksActivity.startActivity(this.w, ywBookChannel.getTid().intValue(), this.y, ywBookChannel.getTitle());
        } else {
            YWChannelBooksActivity.r2(this.w, ywBookChannel.getTitle(), ywBookChannel.getMcid(), this.x, ((ywBookChannel.getPageIndex().intValue() - 1) * ywBookChannel.getSize().intValue()) / 10, "");
        }
    }

    /* renamed from: s0 */
    public /* synthetic */ void t0(final YWBookChannel ywBookChannel, final com.martian.libmars.widget.recyclerview.d holder, View view) {
        T(ywBookChannel, holder.getView(R.id.author_book_more_view), holder.getView(R.id.book_more_progressbar));
        com.martian.mibook.lib.model.g.b.S(this.f10474a, ywBookChannel.getTitle(), "换一批");
    }

    /* renamed from: u0 */
    public /* synthetic */ void v0(final ViewPager bookRankVp) {
        this.C.l(bookRankVp.getCurrentItem());
    }

    /* renamed from: w0 */
    public /* synthetic */ void x0(final List subTabs, final MagicIndicator magicIndicator, View view) {
        int parseInt;
        if (subTabs != null) {
            try {
                parseInt = Integer.parseInt(((YWBookChannel.SubTab) subTabs.get(magicIndicator.getSelectPosition())).getExt());
            } catch (Exception unused) {
            }
            BookRankActivity.w2(this.w, this.y, new BookRankActivity.a().j(parseInt).l(this.C.e(magicIndicator.getSelectPosition())).r("书城-"));
        }
        parseInt = 100;
        BookRankActivity.w2(this.w, this.y, new BookRankActivity.a().j(parseInt).l(this.C.e(magicIndicator.getSelectPosition())).r("书城-"));
    }

    private void z0(final com.martian.libmars.widget.recyclerview.d holder, final YWBookChannel ywBookChannel) {
        holder.a0(R.id.grid_item_bottom_view, true);
        holder.a0(R.id.grid_item_top_view, false);
        holder.a0(R.id.grid_item_vertical_view, false);
        com.martian.mibook.j.y2.b(this.w, ywBookChannel.getBookList(), (LinearLayout) holder.getView(R.id.grid_item_bottom_view));
    }

    public void A0(g bookmallActionListener) {
        this.A = bookmallActionListener;
    }

    public void J0(int newSeed) {
        this.x = newSeed;
    }

    public boolean K0() {
        return get(0) != null && get(0).getLayoutType() == 2;
    }

    public void S(YWBookChannel bookChannel) {
        List<T> list;
        if (bookChannel == null || bookChannel.getBookList() == null || (list = this.f10476c) == 0) {
            return;
        }
        if (list.isEmpty()) {
            this.f10476c.add(bookChannel);
        } else {
            YWBookChannel yWBookChannel = (YWBookChannel) this.f10476c.get(r0.size() - 1);
            if (yWBookChannel != null && yWBookChannel.getBookList() != null) {
                yWBookChannel.getBookList().addAll(bookChannel.getBookList());
                MiConfigSingleton.V3().l3().K1(bookChannel.getBookList());
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: V */
    public void b(com.martian.libmars.widget.recyclerview.d helper, YWBookChannel ywBookChannel) {
        if (ywBookChannel == null) {
            return;
        }
        if (helper.C() == R.layout.bs_book_store_item_grid) {
            F0(helper, ywBookChannel);
            return;
        }
        if (helper.C() == R.layout.bs_book_store_item_list_category) {
            D0(helper, ywBookChannel);
            return;
        }
        if (helper.C() == R.layout.bs_book_store_item_grid_rank) {
            G0(helper, ywBookChannel);
        } else if (helper.C() == R.layout.bs_book_store_item_gender_guide) {
            E0(helper, ywBookChannel);
        } else {
            H0(helper, ywBookChannel);
        }
    }

    public void X(RecyclerView irc) {
        com.martian.mibook.application.u0 u0Var = this.z;
        if (u0Var != null) {
            u0Var.f(irc, this);
        }
    }

    @Override // com.martian.mibook.application.u0.b
    public void j(int position) {
        YWBookChannel yWBookChannel;
        if (this.f10476c.isEmpty() || position < 0 || position >= this.f10476c.size() || (yWBookChannel = (YWBookChannel) this.f10476c.get(position)) == null || yWBookChannel.isExposed()) {
            return;
        }
        yWBookChannel.setExposed(Boolean.TRUE);
        MiConfigSingleton.V3().l3().K1(yWBookChannel.getBookList());
    }

    public void y0() {
        this.C = null;
        this.B = null;
    }
}
