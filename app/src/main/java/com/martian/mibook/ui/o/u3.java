package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.ads.ad.DefaultAd;
import com.martian.ads.ad.GDTAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.ViewWrapper;
import com.martian.free.response.TFBook;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.u0;
import com.martian.mibook.lib.account.response.BookUpdateInfo;
import com.martian.mibook.lib.model.data.BookStoreCategories;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class u3 extends com.martian.libmars.widget.recyclerview.e.d<BookWrapper> implements u0.b {

    /* renamed from: h */
    public static final int f14721h = 0;

    /* renamed from: i */
    public static final int f14722i = 1;

    /* renamed from: j */
    public static final int f14723j = 2;
    public static final int k = 3;
    public static final int l = 4;
    private String m;
    private String n;
    private final com.martian.libmars.activity.j1 o;
    private e p;
    private boolean q;
    private int r;
    private final com.martian.mibook.application.u0 s;
    private int t;

    class a implements com.martian.libmars.widget.recyclerview.h.a<BookWrapper> {
        a() {
        }

        @Override // com.martian.libmars.widget.recyclerview.h.a
        public int b(int type) {
            return type != 0 ? type != 2 ? type != 3 ? type != 4 ? R.layout.bookrack_grid_book_item : R.layout.book_store_ads_item : R.layout.book_store_grid_book_more_item : R.layout.book_store_list_book_more_item : R.layout.book_store_list_book_item;
        }

        @Override // com.martian.libmars.widget.recyclerview.h.a
        /* renamed from: c */
        public int a(int position, BookWrapper bookWrapper) {
            if (bookWrapper == null) {
                return 1;
            }
            if (bookWrapper.isAdsItem) {
                return 4;
            }
            return MiConfigSingleton.V3().n3() == 0 ? bookWrapper.isAdderItem ? 2 : 0 : bookWrapper.isAdderItem ? 3 : 1;
        }
    }

    class b implements k0.o {
        b() {
        }

        @Override // com.martian.libmars.utils.k0.o
        public void a() {
        }

        @Override // com.martian.libmars.utils.k0.o
        public void b() {
            com.martian.mibook.j.s2.p0(u3.this.o, "书架-关闭广告-点击");
        }

        @Override // com.martian.libmars.utils.k0.o
        public void c() {
            if (u3.this.p != null) {
                u3.this.p.a();
            }
        }
    }

    class c {
        c() {
        }

        public void a() {
            u3.this.v0(BookStoreCategories.ALL_BOOK_CATEGORY.equalsIgnoreCase(u3.this.n) ? TextUtils.isEmpty(u3.this.m) ? MiConfigSingleton.V3().l3().L(false, true) : MiConfigSingleton.V3().l3().J(u3.this.m) : MiConfigSingleton.V3().l3().K(u3.this.n, u3.this.m, true));
        }
    }

    public interface d {
        void a();

        void b();
    }

    public interface e {
        void a();

        void b();

        void c(AppTask appTask, View view);

        void d(AppTask appTask, ViewGroup adContainer, View adView, View mediaView);
    }

    public u3(com.martian.libmars.activity.j1 activity, final List<BookWrapper> datas, com.martian.libmars.widget.recyclerview.f.c<BookWrapper> listener) {
        super(activity, datas, new a());
        this.q = false;
        this.r = 0;
        this.t = 0;
        N(listener);
        this.n = BookStoreCategories.ALL_BOOK_CATEGORY;
        this.o = activity;
        this.s = new com.martian.mibook.application.u0();
    }

    private void A0() {
        if (!MiConfigSingleton.V3().j5()) {
            com.martian.mibook.lib.model.g.b.k0(this.o, "书架-关闭广告-展示");
            com.martian.libmars.activity.j1 j1Var = this.o;
            com.martian.libmars.utils.k0.X(j1Var, j1Var.getString(R.string.ads_close), this.o.getString(R.string.bookrack_ads_close_video), this.o.getString(R.string.vip_for_bookrack), false, new b());
        } else {
            e eVar = this.p;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    private void B0(int layoutId, View adsView) {
        View findViewById;
        View view;
        if (layoutId == R.layout.book_store_list_ads_item) {
            view = adsView.findViewById(R.id.list_ads_view);
            findViewById = adsView.findViewById(R.id.list_ads_shade);
        } else {
            findViewById = adsView.findViewById(R.id.grid_ads_shade);
            view = adsView;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        if (!e0()) {
            layoutParams.width = 0;
            layoutParams.height = 0;
            findViewById.setVisibility(8);
            view.setAlpha(1.0f);
            return;
        }
        view.measure(0, 0);
        layoutParams.width = view.getMeasuredWidth();
        layoutParams.height = view.getMeasuredHeight();
        findViewById.setVisibility(0);
        view.setAlpha(0.4f);
    }

    private int W(int position) {
        while (position < this.f10476c.size()) {
            BookWrapper bookWrapper = (BookWrapper) this.f10476c.get(position);
            if (bookWrapper.isAdsItem || bookWrapper.isAdderItem) {
                return position + 1;
            }
            if (bookWrapper.isSelect()) {
                if (!MiConfigSingleton.V3().l3().F(bookWrapper.mibook)) {
                    return this.f10476c.size();
                }
                this.f10476c.remove(position);
                return position;
            }
            position++;
        }
        return this.f10476c.size();
    }

    private c b0() {
        return new c();
    }

    /* renamed from: g0 */
    public /* synthetic */ void h0(final AppTask appTask, View v) {
        e eVar = this.p;
        if (eVar != null) {
            eVar.c(appTask, v);
        }
    }

    /* renamed from: i0 */
    public /* synthetic */ boolean j0(View v) {
        A0();
        return true;
    }

    /* renamed from: k0 */
    public /* synthetic */ void l0(View v) {
        A0();
    }

    private void q0(final com.martian.libmars.widget.recyclerview.d holder, final BookWrapper bookWrapper) {
        if (bookWrapper == null) {
            return;
        }
        if (e0()) {
            holder.a0(R.id.bp_item_select, true);
            if (bookWrapper.isSelect()) {
                holder.a0(R.id.bookrack_grid_shade, true);
                holder.K(R.id.bp_item_select, R.drawable.icon_bookrack_batch_checked);
            } else {
                holder.a0(R.id.bookrack_grid_shade, false);
                holder.K(R.id.bp_item_select, R.drawable.icon_bookrack_batch_checkin);
            }
        } else {
            holder.a0(R.id.bookrack_grid_shade, false);
            holder.a0(R.id.bp_item_select, false);
        }
        String bookName = bookWrapper.getBookName();
        holder.W(R.id.bookrack_grid_bookname, bookName);
        ImageView imageView = (ImageView) holder.getView(R.id.bookrack_grid_cover);
        TextView textView = (TextView) holder.getView(R.id.tv_reading_record);
        Book book = bookWrapper.book;
        if (book == null) {
            com.martian.libmars.utils.n0.b(this.f10474a, imageView);
            holder.K(R.id.bookrack_grid_cover, R.drawable.cover_default);
            holder.a0(R.id.bookrack_grid_update_sign, false);
            textView.setVisibility(4);
            return;
        }
        if (bookWrapper.item.getChapterSize() == null || bookWrapper.item.getChapterSize().intValue() == -1) {
            bookWrapper.item.setChapterSize(Integer.valueOf((int) MiConfigSingleton.V3().l3().h0(book)));
        }
        if (book.isLocal() && com.martian.libsupport.k.p(bookWrapper.getCover()) && !com.martian.libsupport.k.p(bookName)) {
            holder.a0(R.id.bookrack_grid_title_name, true);
            if (bookName.length() > 4) {
                bookName = bookName.substring(0, 4);
            }
            holder.W(R.id.bookrack_grid_title_name, bookName);
        } else {
            holder.a0(R.id.bookrack_grid_title_name, false);
        }
        MiBookManager.d2(this.o, bookWrapper.book, imageView);
        textView.setVisibility(0);
        if (e0()) {
            holder.W(R.id.tv_reading_record, bookWrapper.item.getDirName());
        } else if (bookWrapper.item.isReaded()) {
            int intValue = bookWrapper.item.getReadingChapterIndex().intValue() + 1;
            int intValue2 = bookWrapper.item.getChapterSize().intValue();
            if (intValue2 > 0) {
                holder.W(R.id.tv_reading_record, intValue + "/" + intValue2 + "章");
            } else {
                holder.W(R.id.tv_reading_record, this.f10474a.getString(R.string.reading_record_grid) + intValue + "章");
            }
        } else {
            holder.W(R.id.tv_reading_record, book.getCategory());
        }
        TextView textView2 = (TextView) holder.getView(R.id.bookrack_grid_update_sign);
        textView2.setVisibility(0);
        textView2.setAlpha(e0() ? 0.4f : 1.0f);
        holder.a0(R.id.bg_bookrack_promote, false);
        if (this.t < 3 && bookWrapper.item.isPromoteBook()) {
            textView2.setText(this.f10474a.getString(R.string.recommend));
            textView2.setBackgroundResource(R.drawable.border_book_mark_recommend_grid);
            holder.a0(R.id.bg_bookrack_promote, true);
        } else if (bookWrapper.item.isRecommendBook()) {
            textView2.setText(this.f10474a.getString(R.string.recommend));
            textView2.setBackgroundResource(R.drawable.border_book_mark_blue_grid);
        } else if (bookWrapper.hasUpdate()) {
            textView2.setText(this.f10474a.getString(R.string.update));
            textView2.setBackgroundResource(R.drawable.border_book_mark_red_grid);
        } else if (!bookWrapper.item.isFlagTop()) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f10474a.getString(R.string.book_top));
            textView2.setBackgroundResource(R.drawable.border_book_mark_green_grid);
        }
    }

    private void r0(final com.martian.libmars.widget.recyclerview.d holder, final BookWrapper bookWrapper) {
        String str;
        if (bookWrapper == null) {
            return;
        }
        if (e0()) {
            holder.a0(R.id.bp_item_select, true);
            holder.K(R.id.bp_item_select, bookWrapper.isSelect() ? R.drawable.icon_bookrack_batch_checked : R.drawable.icon_bookrack_batch_checkin);
        } else {
            holder.a0(R.id.bp_item_select, false);
        }
        String bookName = bookWrapper.getBookName();
        holder.W(R.id.tv_url_name, bookName);
        ImageView imageView = (ImageView) holder.getView(R.id.iv_cover);
        Book book = bookWrapper.book;
        if (book == null) {
            MiBook miBook = bookWrapper.mibook;
            com.martian.libmars.utils.n0.b(this.f10474a, imageView);
            holder.K(R.id.iv_cover, R.drawable.cover_default);
            holder.W(R.id.tv_url, miBook.getUrl());
            holder.a0(R.id.iv_update_sign, false);
            holder.a0(R.id.tv_reading_record, false);
            return;
        }
        if (bookWrapper.item.getChapterSize() == null || bookWrapper.item.getChapterSize().intValue() == -1) {
            bookWrapper.item.setChapterSize(Integer.valueOf((int) MiConfigSingleton.V3().l3().h0(book)));
        }
        holder.a0(R.id.tv_reading_record, true);
        if (e0()) {
            holder.W(R.id.tv_reading_record, bookWrapper.item.getDirName());
        } else if (bookWrapper.item.isReaded()) {
            int intValue = bookWrapper.item.getReadingChapterIndex().intValue() + 1;
            int intValue2 = bookWrapper.item.getChapterSize().intValue();
            if (intValue2 > 0) {
                holder.W(R.id.tv_reading_record, intValue + "/" + intValue2 + "章");
            } else {
                holder.W(R.id.tv_reading_record, this.f10474a.getString(R.string.reading_rate) + intValue + "章");
            }
        } else {
            holder.W(R.id.tv_reading_record, book.getCategory());
        }
        if (book.isLocal() && com.martian.libsupport.k.p(bookWrapper.getCover()) && !com.martian.libsupport.k.p(bookName)) {
            holder.a0(R.id.tv_title_name, true);
            if (bookName.length() > 4) {
                bookName = bookName.substring(0, 4);
            }
            holder.W(R.id.tv_title_name, bookName);
        } else {
            holder.a0(R.id.tv_title_name, false);
        }
        MiBookManager.d2(this.o, bookWrapper.book, imageView);
        TextView textView = (TextView) holder.getView(R.id.tv_url);
        String lastChapter = book.getLastChapter();
        if (com.martian.libsupport.k.p(lastChapter)) {
            textView.setText(this.f10474a.getString(R.string.latest_chapter_empty));
        } else {
            if (bookWrapper.book.isSerialEnd()) {
                str = bookWrapper.book.getStatus() + ": " + lastChapter;
            } else {
                str = "更新至:" + lastChapter;
            }
            textView.setText(str);
        }
        TextView textView2 = (TextView) holder.getView(R.id.iv_update_sign);
        textView2.setVisibility(0);
        textView2.setAlpha(e0() ? 0.4f : 1.0f);
        holder.a0(R.id.bg_bookrack_promote, false);
        if (this.t < 3 && bookWrapper.item.isPromoteBook()) {
            textView2.setText(this.f10474a.getString(R.string.recommend));
            textView2.setBackgroundResource(R.drawable.border_book_mark_recommend_grid);
            holder.a0(R.id.bg_bookrack_promote, true);
        } else if (bookWrapper.item.isRecommendBook()) {
            textView2.setText(this.f10474a.getString(R.string.recommend));
            textView2.setBackgroundResource(R.drawable.border_book_mark_blue_list);
        } else if (bookWrapper.hasUpdate()) {
            textView2.setText(this.f10474a.getString(R.string.update));
            textView2.setBackgroundResource(R.drawable.border_book_mark_red_list);
        } else if (!bookWrapper.item.isFlagTop()) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f10474a.getString(R.string.book_top));
            textView2.setBackgroundResource(R.drawable.border_book_mark_green_list);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void t0(com.martian.libmars.widget.recyclerview.d holder, BookWrapper bookWrapper, int layoutId) {
        ViewGroup viewGroup;
        if (bookWrapper != null) {
            Object obj = bookWrapper.customData;
            if (obj instanceof AppTask) {
                final AppTask appTask = (AppTask) obj;
                ViewGroup viewGroup2 = (ViewGroup) holder.getView(R.id.ad_container);
                View findViewWithTag = viewGroup2.findViewWithTag(appTask);
                if (findViewWithTag != null) {
                    B0(layoutId, findViewWithTag);
                    return;
                }
                viewGroup2.removeAllViews();
                View inflate = this.o.getLayoutInflater().inflate(layoutId, GDTAd.isGdtFlowAd(appTask) ? null : viewGroup2);
                inflate.setTag(appTask);
                ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.fl_gdt_container);
                ViewGroup viewGroup4 = (ViewGroup) inflate.findViewById(R.id.iv_video_view);
                ViewWrapper viewWrapper = appTask.customView;
                if (viewWrapper == null) {
                    inflate.setClickable(true);
                    inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.d0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            u3.this.h0(appTask, view);
                        }
                    });
                    inflate.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.ui.o.b0
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            return u3.this.j0(view);
                        }
                    });
                    inflate.setVisibility(0);
                    if (viewGroup3 != null) {
                        viewGroup3.setVisibility(8);
                    }
                    com.martian.libmars.utils.n0.p(this.f10474a, appTask.getPosterUrl(), (ImageView) inflate.findViewById(R.id.iv_app_icon), MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
                    ((ImageView) inflate.findViewById(R.id.iv_ads_logo)).setImageResource(appTask.adsIconRes());
                    TextView textView = (TextView) inflate.findViewById(R.id.tv_ads_logo_desc);
                    if (DefaultAd.isDefaultAd(appTask)) {
                        textView.setText(this.f10474a.getString(R.string.recommend));
                    } else {
                        textView.setText(this.f10474a.getString(R.string.ads));
                    }
                    if (!appTask.isVideoAd || appTask.videoView == null) {
                        viewGroup4.setVisibility(8);
                    } else {
                        viewGroup4.setVisibility(0);
                        if (viewGroup4.getTag() == appTask) {
                            return;
                        }
                        if (appTask.videoView.getView().getParent() != null && (viewGroup = (ViewGroup) appTask.videoView.getView().getParent()) != null) {
                            viewGroup.removeAllViews();
                        }
                        viewGroup4.removeAllViews();
                        viewGroup4.addView(appTask.videoView.getView());
                        viewGroup4.setTag(appTask);
                        appTask.videoView.init();
                    }
                    inflate.findViewById(R.id.br_close_ads_icon).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.c0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            u3.this.l0(view);
                        }
                    });
                    TextView textView2 = (TextView) inflate.findViewById(R.id.tv_app_title);
                    if (textView2 != null) {
                        textView2.setText(appTask.getTitle());
                    }
                    TextView textView3 = (TextView) inflate.findViewById(R.id.tv_app_desc);
                    if (textView3 != null) {
                        textView3.setText(appTask.getDesc() + this.o.getString(R.string.long_click_close_ad));
                    }
                } else if (viewGroup3 != null) {
                    View view = viewWrapper.getView();
                    ViewParent parent = view.getParent();
                    if (parent != null && parent != viewGroup3) {
                        ((ViewGroup) parent).removeAllViews();
                    }
                    if (parent != viewGroup3) {
                        viewGroup3.removeAllViews();
                        viewGroup3.addView(view);
                    }
                    inflate.setVisibility(8);
                    viewGroup3.setVisibility(0);
                }
                B0(layoutId, inflate);
                e eVar = this.p;
                if (eVar != null) {
                    eVar.d(appTask, viewGroup2, inflate, viewGroup4);
                }
            }
        }
    }

    private void w0(com.martian.libmars.widget.recyclerview.d holder, BookWrapper bookWrapper) {
        if (bookWrapper == null || !bookWrapper.isAdderItem) {
            return;
        }
        holder.a0(R.id.book_adder_grid_container, !e0());
        holder.H(R.id.iv_book_more_view, MiConfigSingleton.V3().I0() ? R.drawable.border_background_book_more_night : R.drawable.border_background_book_more_day);
    }

    private void x0(com.martian.libmars.widget.recyclerview.d holder, BookWrapper bookWrapper) {
        if (bookWrapper == null || !bookWrapper.isAdderItem) {
            return;
        }
        holder.a0(R.id.book_adder_list_container, !e0());
        holder.H(R.id.iv_book_list_more_view, MiConfigSingleton.V3().I0() ? R.drawable.border_background_book_more_night : R.drawable.border_background_book_more_day);
    }

    public int C0(List<BookUpdateInfo> bookInfos) {
        MiBookStoreItem miBookStoreItem;
        BookUpdateInfo bookUpdateInfo;
        boolean z;
        HashMap hashMap = new HashMap();
        for (BookUpdateInfo bookUpdateInfo2 : bookInfos) {
            hashMap.put(bookUpdateInfo2.getSourceString(), bookUpdateInfo2);
        }
        if (hashMap.isEmpty()) {
            return 0;
        }
        Iterator it = new ArrayList(this.f10476c).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            BookWrapper bookWrapper = (BookWrapper) it.next();
            if (hashMap.isEmpty()) {
                break;
            }
            if (bookWrapper != null && (miBookStoreItem = bookWrapper.item) != null && !bookWrapper.isAdsItem && !bookWrapper.isAdderItem && bookWrapper.book != null && (bookUpdateInfo = (BookUpdateInfo) hashMap.get(miBookStoreItem.getSourceString())) != null) {
                hashMap.remove(bookWrapper.item.getSourceString());
                boolean z2 = true;
                if (bookUpdateInfo.hasChapterUpdated(bookWrapper.book.getLastUpdated())) {
                    i2++;
                    bookWrapper.setHasUpdate(true);
                    bookWrapper.item.setChapterSize(bookUpdateInfo.getChapterSize());
                    bookWrapper.book.setLatestChapterUpdateTime(bookUpdateInfo.getLatestChapterUpdateTime());
                    bookWrapper.book.setLastChapter(bookUpdateInfo.getLatestChapter());
                    bookWrapper.hasChapterUpdate = MiConfigSingleton.V3().l3().p0(bookWrapper.book) && MiConfigSingleton.V3().l3().n0(bookWrapper.book);
                    z = true;
                } else {
                    z = false;
                }
                Book book = bookWrapper.book;
                if (book instanceof YWBook) {
                    YWBook yWBook = (YWBook) book;
                    if (bookUpdateInfo.getStatus() != null) {
                        yWBook.setStatus(bookUpdateInfo.getStatus());
                    }
                    if (bookUpdateInfo.getDistType().equals(yWBook.getDistType())) {
                        z2 = z;
                    } else {
                        yWBook.setDistType(bookUpdateInfo.getDistType());
                    }
                    z = z2;
                } else if ((book instanceof TFBook) && bookUpdateInfo.getStatus() != null) {
                    ((TFBook) bookWrapper.book).setStatus(bookUpdateInfo.getStatus());
                }
                if (z) {
                    MiConfigSingleton.V3().l3().s1(bookWrapper.book);
                }
            }
        }
        notifyDataSetChanged();
        return i2;
    }

    public void D0() {
        b0().a();
    }

    public void S(String newTag, d listener) {
        if (MiConfigSingleton.V3().l3().h(newTag)) {
            if (listener != null) {
                listener.b();
            }
        } else if (listener != null) {
            listener.a();
        }
    }

    public void T(String newCategory, d listener) {
        for (T t : this.f10476c) {
            if (!t.isAdderItem && !t.isAdsItem && t.isSelect()) {
                MiConfigSingleton.V3().l3().j1(t, newCategory);
            }
        }
        if (listener != null) {
            listener.b();
        }
    }

    public void U() {
        this.r = 0;
        n0(false);
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: V */
    public void b(com.martian.libmars.widget.recyclerview.d helper, BookWrapper bookWrapper) {
        int C = helper.C();
        if (C == R.layout.book_store_list_book_item) {
            r0(helper, bookWrapper);
            return;
        }
        if (C == R.layout.bookrack_grid_book_item) {
            q0(helper, bookWrapper);
            return;
        }
        if (C == R.layout.book_store_ads_item) {
            t0(helper, bookWrapper, MiConfigSingleton.V3().n3() == 0 ? R.layout.book_store_list_ads_item : R.layout.book_store_grid_ads_item);
        } else if (C == R.layout.book_store_list_book_more_item) {
            x0(helper, bookWrapper);
        } else if (C == R.layout.book_store_grid_book_more_item) {
            w0(helper, bookWrapper);
        }
    }

    public void X(d listener) {
        int i2 = 0;
        while (i2 < this.f10476c.size()) {
            i2 = W(i2);
        }
        if (listener != null) {
            listener.b();
        }
    }

    public String Y() {
        return this.m;
    }

    public String Z() {
        return this.n;
    }

    public int a0() {
        int i2 = 0;
        for (T t : this.f10476c) {
            if (!t.isAdderItem && !t.isAdsItem) {
                i2++;
            }
        }
        return i2;
    }

    public int c0() {
        return this.r;
    }

    public void d0(RecyclerView irc) {
        if (this.s == null || !MiConfigSingleton.V3().l3().V2()) {
            return;
        }
        this.s.f(irc, this);
    }

    public boolean e0() {
        return this.q;
    }

    public boolean f0() {
        if (c0() != 1) {
            return false;
        }
        for (T t : this.f10476c) {
            if (t.isSelect()) {
                MiBookStoreItem miBookStoreItem = t.item;
                return miBookStoreItem != null && miBookStoreItem.isRecommendBook();
            }
        }
        return false;
    }

    @Override // com.martian.mibook.application.u0.b
    public void j(int position) {
        BookWrapper bookWrapper;
        MiBookStoreItem miBookStoreItem;
        if (this.f10476c.isEmpty() || position < 0 || position >= this.f10476c.size() || (bookWrapper = (BookWrapper) this.f10476c.get(position)) == null || (miBookStoreItem = bookWrapper.item) == null || miBookStoreItem.isReaded()) {
            return;
        }
        MiConfigSingleton.V3().l3().e2(this.o, bookWrapper.item.getSourceString());
    }

    public void m0(BookWrapper bookWrapper) {
        bookWrapper.setSelect(!bookWrapper.isSelect());
        if (bookWrapper.isSelect()) {
            this.r++;
        } else {
            this.r--;
        }
        notifyDataSetChanged();
    }

    public void n0(boolean selectAll) {
        for (T t : this.f10476c) {
            if (!t.isAdsItem && !t.isAdderItem) {
                t.setSelect(selectAll);
            }
        }
    }

    public void o0() {
        int a0 = a0();
        if (this.r < a0) {
            this.r = a0;
            n0(true);
        } else {
            this.r = 0;
            n0(false);
        }
        notifyDataSetChanged();
    }

    public void p0(boolean batch) {
        this.q = batch;
        notifyDataSetChanged();
    }

    public void s0(String keyword) {
        this.m = keyword;
        b0().a();
    }

    public void u0(String category) {
        this.n = category;
        b0().a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v0(List<BookWrapper> data) {
        this.f10476c = data;
        notifyDataSetChanged();
    }

    public void y0(e listener) {
        this.p = listener;
    }

    public void z0(int times) {
        this.t = times;
    }
}
