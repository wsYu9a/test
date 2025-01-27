package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.k0;
import com.martian.libsupport.j;
import com.martian.mibook.activity.BonusDetailActivity;
import com.martian.mibook.activity.ReadingRecordActivity;
import com.martian.mibook.activity.SimilarityBookActivity;
import com.martian.mibook.activity.book.ArchiveListActivity;
import com.martian.mibook.activity.book.CoverSwitchActivity;
import com.martian.mibook.activity.book.search.SearchBookMainActivity;
import com.martian.mibook.activity.book.txt.BookScanActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.o0;
import com.martian.mibook.lib.account.request.BookUpdateInfoParams;
import com.martian.mibook.lib.account.request.BookshelfInfoPushParams;
import com.martian.mibook.lib.account.response.BookUpdateInfo;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.local.base.data.LocalBook;
import com.martian.mibook.lib.model.data.BookStoreCategories;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.request.GetInitialBooksParams;
import com.martian.mibook.lib.yuewen.response.TYInitialBookList;
import com.martian.mibook.ui.o.i3;
import com.martian.mibook.ui.o.m3;
import com.martian.mibook.ui.o.u3;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class u3 extends com.martian.libmars.f.h implements View.OnClickListener {
    private com.martian.mibook.e.i1 B;
    private com.martian.mibook.e.k1 C;
    private com.martian.mibook.ui.o.i3 E;
    private com.martian.mibook.e.q2 F;
    private PopupWindow G;
    private com.martian.mibook.ui.o.m3 H;
    private com.martian.mibook.e.q2 I;
    private PopupWindow J;
    private ProgressDialog K;
    private com.martian.mibook.e.j1 N;
    private MissionItem O;
    private MissionItem P;

    /* renamed from: j */
    private com.martian.libmars.b.d f13296j;
    private com.martian.mibook.b.b n;
    private b.d.a.k.b o;
    public com.martian.mibook.ui.o.u3 p;
    private com.martian.mibook.ui.o.n3 q;
    private List<BookWrapper> r;
    private com.martian.mibook.e.a3 s;
    private com.martian.mibook.e.o1 t;
    private o0.p u;
    private PopupWindow y;
    private long k = 0;
    private long l = 0;
    private boolean m = false;
    private final int v = 0;
    private final int w = 1;
    private boolean x = false;
    private boolean z = false;
    private boolean A = false;
    private int D = 0;
    private boolean L = false;
    private boolean M = true;

    class a extends com.martian.mibook.lib.account.d.g<BookUpdateInfoParams, BookUpdateInfo> {

        /* renamed from: g */
        final /* synthetic */ boolean f13297g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class x0, Class x1, Context x2, final boolean val$refreshContent) {
            super(x0, x1, x2);
            this.f13297g = val$refreshContent;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            u3.this.p();
            u3.this.D0(this.f13297g);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<BookUpdateInfo> bookUpdateInfos) {
            u3.this.p();
            if (bookUpdateInfos == null || bookUpdateInfos.isEmpty()) {
                u3.this.N2("没有新的更新", this.f13297g);
                u3.this.D0(this.f13297g);
                return;
            }
            com.martian.mibook.ui.o.u3 u3Var = u3.this.p;
            if (u3Var != null) {
                int C0 = u3Var.C0(bookUpdateInfos);
                if (C0 > 0) {
                    u3.this.s.f11687b.f11659i.setVisibility(0);
                    u3.this.N2(C0 + "本有新更新", this.f13297g);
                } else {
                    u3.this.N2("没有新的更新", this.f13297g);
                }
            }
            u3.this.D0(this.f13297g);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class b extends com.martian.mibook.lib.account.d.g<BookshelfInfoPushParams, Boolean> {
        b(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<Boolean> success) {
            MiConfigSingleton.V3().x6(false);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class c implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ BookWrapper f13300a;

        /* renamed from: b */
        final /* synthetic */ int f13301b;

        c(final BookWrapper val$position, final int val$bookWrapper) {
            this.f13300a = val$position;
            this.f13301b = val$bookWrapper;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            BookWrapper bookWrapper = this.f13300a;
            bookWrapper.book = book;
            u3.this.P2(bookWrapper, this.f13301b);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            u3.this.d("无效的书籍ID，请重新添加书架");
        }
    }

    class d extends b.d.a.k.b {
        d() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            ((com.martian.libmars.f.e) u3.this).f10082a.k1("观看成功");
            com.martian.mibook.lib.model.g.b.i0(((com.martian.libmars.f.e) u3.this).f10082a, "观看成功-书架");
            MiConfigSingleton.V3().g7();
            u3.this.w2();
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            ((com.martian.libmars.f.e) u3.this).f10082a.k1("视频加载失败");
        }
    }

    class e implements u3.d {
        e() {
        }

        @Override // com.martian.mibook.ui.o.u3.d
        public void a() {
            u3.this.t2("", "删除失败，请重试");
        }

        @Override // com.martian.mibook.ui.o.u3.d
        public void b() {
            u3.this.t2("批量删除中", "删除成功");
        }
    }

    class f implements u3.d {

        /* renamed from: a */
        final /* synthetic */ String f13305a;

        f(final String val$category) {
            this.f13305a = val$category;
        }

        @Override // com.martian.mibook.ui.o.u3.d
        public void a() {
            u3.this.t2("", "分类失败，请重试");
        }

        @Override // com.martian.mibook.ui.o.u3.d
        public void b() {
            u3.this.t2("批量分类中", "成功将选中的" + u3.this.p.c0() + "本小说分类至\"" + this.f13305a + "\"中");
        }
    }

    class g implements u3.d {

        /* renamed from: a */
        final /* synthetic */ String f13307a;

        g(final String val$tagName) {
            this.f13307a = val$tagName;
        }

        @Override // com.martian.mibook.ui.o.u3.d
        public void a() {
            u3.this.t2("", "归档失败，请重试");
        }

        @Override // com.martian.mibook.ui.o.u3.d
        public void b() {
            u3.this.t2("", "成功将选中的" + u3.this.p.c0() + "本小说归档至\"" + this.f13307a + "\"中");
        }
    }

    class h implements MiConfigSingleton.y {
        h() {
        }

        @Override // com.martian.mibook.application.MiConfigSingleton.y
        public void a(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.application.MiConfigSingleton.y
        public void b() {
            u3.this.d("同步成功");
            MiConfigSingleton.V3().U8();
            u3.this.n2();
        }

        @Override // com.martian.mibook.application.MiConfigSingleton.y
        public void onLoading(boolean show) {
        }
    }

    class i implements TextWatcher {
        i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            com.martian.mibook.ui.o.u3 u3Var = u3.this.p;
            if (u3Var != null) {
                u3Var.s0(s.toString());
            }
        }
    }

    class j implements o0.p {
        j() {
        }

        @Override // com.martian.mibook.application.o0.p
        public void a(MissionItem missionItem) {
            if (missionItem == null) {
                return;
            }
            u3.this.O = missionItem;
            u3.this.J2();
        }

        @Override // com.martian.mibook.application.o0.p
        public void b(MissionItem missionItem) {
            if (missionItem == null) {
                return;
            }
            u3.this.P = missionItem;
            u3.this.M2();
        }
    }

    class k extends com.martian.mibook.lib.account.d.q.y {
        k(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(IntervalBonus intervalBonus) {
            if (intervalBonus == null) {
                return;
            }
            MiConfigSingleton.V3().y7(intervalBonus.getLeftTime());
            u3.this.c3();
        }
    }

    class l extends com.martian.mibook.lib.account.d.q.x {
        l(com.martian.libmars.activity.j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            u3.this.x = false;
            MiConfigSingleton.V3().y7(-1L);
            if (((com.martian.libmars.f.e) u3.this).f10082a == null || errorResult == null) {
                return;
            }
            if (errorResult.c() == 40001) {
                u3.this.R2();
            }
            ((com.martian.libmars.f.e) u3.this).f10082a.k1(errorResult.d());
            u3.this.c3();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(final IntervalBonus intervalBonus) {
            u3.this.x = false;
            if (com.martian.libmars.utils.n0.c(((com.martian.libmars.f.e) u3.this).f10082a)) {
                return;
            }
            if (intervalBonus == null) {
                ((com.martian.libmars.f.e) u3.this).f10082a.k1("领取失败");
                return;
            }
            MiConfigSingleton.V3().V8(intervalBonus.getMoney(), intervalBonus.getCoins().intValue());
            BonusDetailActivity.E3(((com.martian.libmars.f.e) u3.this).f10082a, ((com.martian.libmars.f.e) u3.this).f10082a.getString(R.string.bonus_interval), intervalBonus.getMoney(), intervalBonus.getCoins().intValue(), 0, intervalBonus.getExtraId().longValue(), intervalBonus.getExtraCoins().intValue());
            MiConfigSingleton.V3().y7(intervalBonus.getLeftTime());
            u3.this.c3();
        }
    }

    class m extends b.d.c.c.g<Void, List<BookWrapper>> {
        m() {
        }

        @Override // b.d.c.c.g
        /* renamed from: f */
        public List<BookWrapper> doInBackground(Void[] params) {
            return MiConfigSingleton.V3().l3().e0();
        }

        @Override // b.d.c.c.g
        /* renamed from: g */
        public void onPostExecute(List<BookWrapper> bookWrappers) {
            super.onPostExecute(bookWrappers);
            if (((com.martian.libmars.f.e) u3.this).f10082a == null) {
                return;
            }
            u3.this.r = bookWrappers;
            u3.this.H0();
            if (MiConfigSingleton.V3().E6()) {
                int P3 = MiConfigSingleton.V3().P3();
                if (P3 >= 0 && P3 < u3.this.q.getCount()) {
                    u3.this.q.k(P3);
                    String g2 = u3.this.q.g();
                    String O3 = MiConfigSingleton.V3().O3();
                    if (!TextUtils.isEmpty(O3) && g2.equals(O3)) {
                        u3.this.s.f11687b.f11658h.setText(MiConfigSingleton.V3().n(g2));
                        if (g2.equals(BookStoreCategories.SECRETE_CATEGORY)) {
                            u3.this.T2(P3);
                        } else {
                            u3.this.A2(P3);
                        }
                    }
                }
            } else {
                u3.this.A2(0);
            }
            u3.this.v0(false);
            u3 u3Var = u3.this;
            com.martian.mibook.ui.o.u3 u3Var2 = u3Var.p;
            if (u3Var2 != null) {
                u3Var2.d0(u3Var.s.f11688c);
            }
        }

        @Override // b.d.c.c.g
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class n extends com.martian.mibook.lib.yuewen.e.a {

        /* renamed from: h */
        final /* synthetic */ boolean f13315h;

        n(final boolean val$refreshContent) {
            this.f13315h = val$refreshContent;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            MiConfigSingleton.V3().L4.K0(((com.martian.libmars.f.e) u3.this).f10082a, u3.this.f13296j);
            if (MiConfigSingleton.V3().e5()) {
                return;
            }
            u3.this.n2();
            u3.this.d("获取书籍列表失败");
        }

        @Override // com.martian.mibook.lib.yuewen.e.a, b.d.c.c.c, b.d.c.c.b
        /* renamed from: p */
        public boolean onPreDataReceived(TYInitialBookList tyInitialBookList) {
            if (tyInitialBookList == null || tyInitialBookList.getBookList() == null || ((com.martian.libmars.f.e) u3.this).f10082a == null) {
                return false;
            }
            if (MiConfigSingleton.V3().e5()) {
                return MiConfigSingleton.V3().l3().A2(((com.martian.libmars.f.e) u3.this).f10082a, tyInitialBookList);
            }
            MiConfigSingleton.V3().l3().z2(((com.martian.libmars.f.e) u3.this).f10082a, tyInitialBookList);
            return true;
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TYInitialBookList tyInitialBookList) {
            MiConfigSingleton.V3().i7();
            if (!MiConfigSingleton.V3().e5()) {
                MiConfigSingleton.V3().h7(true);
                if (u3.this.r != null) {
                    BookWrapper bookWrapper = new BookWrapper(null, null, null);
                    bookWrapper.isAdderItem = true;
                    u3.this.r.add(bookWrapper);
                }
                u3 u3Var = u3.this;
                com.martian.mibook.ui.o.u3 u3Var2 = u3Var.p;
                if (u3Var2 != null) {
                    u3Var2.d0(u3Var.s.f11688c);
                }
            }
            u3.this.n2();
            MiConfigSingleton.V3().L4.K0(((com.martian.libmars.f.e) u3.this).f10082a, u3.this.f13296j);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            u3.this.s(show);
            if (show) {
                return;
            }
            u3.this.C0(this.f13315h);
        }
    }

    class o extends b.d.a.k.b {
        o() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.getApps().isEmpty() || u3.this.r == null) {
                return;
            }
            u3.this.k0(appTaskList.getApps().get(0));
            u3.this.n2();
        }
    }

    class p implements com.martian.libmars.widget.recyclerview.f.c<BookWrapper> {
        p() {
        }

        @Override // com.martian.libmars.widget.recyclerview.f.c
        /* renamed from: c */
        public void a(ViewGroup parent, View view, BookWrapper bookWrapper, int position) {
            if (bookWrapper == null) {
                return;
            }
            if (u3.this.p.e0()) {
                u3.this.p.m0(bookWrapper);
                u3.this.e3();
            } else if (bookWrapper.isAdderItem) {
                com.martian.mibook.lib.model.g.b.S(((com.martian.libmars.f.e) u3.this).f10082a, MiConfigSingleton.V3().k() == 2 ? "女频书架" : "男频书架", "点击添加");
                u3.this.f13296j.d(com.martian.mibook.application.v0.f11603g, 1);
            } else if (bookWrapper.isAdsItem) {
                u3.this.E0().d((AppTask) bookWrapper.getCustomData());
            } else {
                u3.this.P2(bookWrapper, position);
            }
        }

        @Override // com.martian.libmars.widget.recyclerview.f.c
        /* renamed from: d */
        public boolean b(ViewGroup parent, View view, BookWrapper bookWrapper, int position) {
            if (bookWrapper != null && !bookWrapper.isAdderItem && !bookWrapper.isAdsItem && !u3.this.p.e0()) {
                com.martian.mibook.lib.model.g.b.B(((com.martian.libmars.f.e) u3.this).f10082a, "批量管理-长按");
                u3.this.X2(true);
                u3.this.p.m0(bookWrapper);
                u3.this.e3();
            }
            return false;
        }
    }

    class q implements u3.e {
        q() {
        }

        @Override // com.martian.mibook.ui.o.u3.e
        public void a() {
            u3.this.l2();
        }

        @Override // com.martian.mibook.ui.o.u3.e
        public void b() {
            u3.this.w2();
        }

        @Override // com.martian.mibook.ui.o.u3.e
        public void c(AppTask appTask, View view) {
            u3.this.E0().d(appTask);
        }

        @Override // com.martian.mibook.ui.o.u3.e
        public void d(AppTask appTask, ViewGroup adContainer, View adView, View mediaView) {
            u3.this.E0().g(((com.martian.libmars.f.e) u3.this).f10082a, appTask, adContainer, adView, mediaView, null, true);
        }
    }

    private void A0() {
        if (this.C == null || this.B == null) {
            this.B = com.martian.mibook.e.i1.a(View.inflate(this.f10082a, R.layout.bookrack_batch_bottom_view, null));
            com.martian.mibook.e.k1 a2 = com.martian.mibook.e.k1.a(View.inflate(this.f10082a, R.layout.bookrack_batch_top_view, null));
            this.C = a2;
            a2.f12232d.setPadding(0, this.f10082a.F0(), 0, 0);
            Window window = this.f10082a.getWindow();
            window.addContentView(this.C.getRoot(), new FrameLayout.LayoutParams(-1, -2));
            window.addContentView(this.B.getRoot(), new FrameLayout.LayoutParams(-1, -2, 80));
            this.C.f12230b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.Q0(view);
                }
            });
            this.C.f12231c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.S0(view);
                }
            });
            this.B.f12107d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.U0(view);
                }
            });
            this.B.f12108e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.W0(view);
                }
            });
            this.B.f12106c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.Y0(view);
                }
            });
            this.B.f12105b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.a1(view);
                }
            });
            boolean z = this.p.c0() > 0;
            this.B.f12107d.setSelectable(z);
            this.B.f12106c.setSelectable(z);
            this.B.f12108e.setSelectable(z);
            this.B.f12105b.setSelectable(z);
        }
        y0();
    }

    /* renamed from: A1 */
    public /* synthetic */ void B1(int position, String categoryName) {
        u0(categoryName);
        PopupWindow popupWindow = this.J;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void A2(int position) {
        this.q.k(position);
        this.s.f11687b.f11658h.setText(MiConfigSingleton.V3().n(this.q.g()));
        C2(position);
        PopupWindow popupWindow = this.y;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private void B0(final String title) {
        if (TextUtils.isEmpty(title)) {
            d("请输入自定义分类名称");
        } else {
            u0(title);
        }
    }

    public void C0(boolean manual) {
        List<BookWrapper> list;
        if (t0()) {
            if ((manual || MartianRPUserManager.t() - this.k > 30000) && (list = this.r) != null && list.size() > 1) {
                this.k = MartianRPUserManager.t();
                k2();
            }
        }
    }

    /* renamed from: C1 */
    public /* synthetic */ void D1(View v) {
        PopupWindow popupWindow = this.J;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        F2(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D0(final boolean refreshContent) {
        if (MiConfigSingleton.V3().e5() && MiConfigSingleton.V3().f5()) {
            MiConfigSingleton.V3().L4.K0(this.f10082a, this.f13296j);
            C0(refreshContent);
        } else {
            if (MiConfigSingleton.V3().v3() < 0) {
                MiConfigSingleton.V3().L4.K0(this.f10082a, this.f13296j);
                return;
            }
            n nVar = new n(refreshContent);
            nVar.n();
            ((GetInitialBooksParams) nVar.k()).setCtype(Integer.valueOf(MiConfigSingleton.V3().v3()));
            ((GetInitialBooksParams) nVar.k()).setNewUser(Boolean.valueOf(!MiConfigSingleton.V3().e5()));
            nVar.j();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void D2() {
        if (this.H == null) {
            com.martian.mibook.ui.o.m3 m3Var = new com.martian.mibook.ui.o.m3(this.f10082a, MiConfigSingleton.V3().l3().Z());
            this.H = m3Var;
            m3Var.j(new m3.a() { // from class: com.martian.mibook.f.d1
                @Override // com.martian.mibook.ui.o.m3.a
                public final void a(int i2, String str) {
                    u3.this.B1(i2, str);
                }
            });
            com.martian.mibook.e.q2 a2 = com.martian.mibook.e.q2.a(this.f10082a.getLayoutInflater().inflate(R.layout.dialog_tag, (ViewGroup) null));
            this.I = a2;
            a2.f12560e.setAdapter((ListAdapter) this.H);
            this.I.f12561f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.s1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.D1(view);
                }
            });
            this.I.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.f.t0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return u3.this.F1(view, motionEvent);
                }
            });
        }
        this.H.i();
        this.I.f12559d.setVisibility(MiConfigSingleton.V3().I0() ? 0 : 8);
        if (this.H.getCount() > 6) {
            View view = this.H.getView(0, null, this.I.f12560e);
            view.measure(0, 0);
            ViewGroup.LayoutParams layoutParams = this.I.f12560e.getLayoutParams();
            double measuredHeight = view.getMeasuredHeight();
            Double.isNaN(measuredHeight);
            layoutParams.height = (int) (measuredHeight * 5.5d);
        }
        PopupWindow popupWindow = this.J;
        if (popupWindow == null) {
            this.J = com.martian.mibook.j.v2.j(this.I.getRoot(), this.s.f11687b.f11655e, this.f10082a);
        } else {
            popupWindow.showAtLocation(this.f10082a.getWindow().getDecorView(), 80, 0, 0);
        }
    }

    public com.martian.mibook.b.b E0() {
        if (this.n == null) {
            this.n = new com.martian.mibook.b.b(this.f10082a, com.martian.mibook.b.b.u, b.d.a.j.b.n);
        }
        return this.n;
    }

    /* renamed from: E1 */
    public /* synthetic */ boolean F1(View v, MotionEvent event) {
        int top = this.I.getRoot().findViewById(R.id.bookrack_category).getTop();
        int y = (int) event.getY();
        if (event.getAction() == 1 && y < top) {
            this.J.dismiss();
        }
        return true;
    }

    private String F0(boolean checkAll) {
        Book book;
        List<BookWrapper> list = this.r;
        String str = "";
        if (list == null) {
            return "";
        }
        for (BookWrapper bookWrapper : list) {
            if (!bookWrapper.isAdsItem && !bookWrapper.isAdderItem && bookWrapper.item != null && ((book = bookWrapper.book) == null || !book.isLocal())) {
                if (bookWrapper.item.isReaded() && bookWrapper.item.getChapterSize() != null && (!checkAll || !BookStoreCategories.SECRETE_CATEGORY.equalsIgnoreCase(bookWrapper.item.getDirName()))) {
                    if (MiConfigSingleton.V3().l3().C2(bookWrapper.book) && (checkAll || !Book.STATUS_FINISHED.equalsIgnoreCase(bookWrapper.book.getStatus()))) {
                        str = com.martian.libsupport.k.p(str) ? bookWrapper.item.getSourceString() : str + "," + bookWrapper.item.getSourceString();
                    }
                }
            }
        }
        return str;
    }

    private void F2(final int type) {
        com.martian.libmars.utils.k0.V(this.f10082a, getString(type == 0 ? R.string.bookrack_create_group : R.string.bookrack_create_archive), getString(R.string.input_ud_tag_name), false, false, new k0.i() { // from class: com.martian.mibook.f.y0
            @Override // com.martian.libmars.utils.k0.i
            public final void a(String str) {
                u3.this.L1(type, str);
            }
        });
    }

    private List<BookWrapper> G0() {
        ArrayList arrayList = new ArrayList();
        for (BookWrapper bookWrapper : this.r) {
            if (arrayList.size() == this.p.c0()) {
                break;
            }
            if (bookWrapper.isSelect()) {
                arrayList.add(bookWrapper);
            }
        }
        return arrayList;
    }

    /* renamed from: G1 */
    public /* synthetic */ void H1(AdapterView parent, View view, int position, long id) {
        if (!com.martian.libsupport.k.n((String) this.q.getItem(position), BookStoreCategories.SECRETE_CATEGORY)) {
            A2(position);
            return;
        }
        T2(position);
        PopupWindow popupWindow = this.y;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private void G2(final BookWrapper bookWrapper, final int position) {
        com.martian.libmars.activity.j1 j1Var = this.f10082a;
        com.martian.libmars.utils.k0.P(j1Var, j1Var.getString(R.string.delete_hint), "本地文件不存在，是否删除《" + bookWrapper.getBookName() + "》?\n(该书的所有缓存内容将被清空)", new k0.l() { // from class: com.martian.mibook.f.h0
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                u3.this.N1(position, bookWrapper);
            }
        });
    }

    private void H2(final int position) {
        I2(position, null, "请设置四位数字密码");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void I0() {
        com.martian.mibook.e.q2 a2 = com.martian.mibook.e.q2.a(this.f10082a.getLayoutInflater().inflate(R.layout.dialog_tag, (ViewGroup) null));
        this.F = a2;
        a2.f12562g.setText(getString(R.string.choose_tag));
        com.martian.mibook.ui.o.i3 i3Var = new com.martian.mibook.ui.o.i3(this.f10082a, MiConfigSingleton.V3().l3().C0());
        this.E = i3Var;
        this.F.f12560e.setAdapter((ListAdapter) i3Var);
        this.F.f12559d.setVisibility(MiConfigSingleton.V3().I0() ? 0 : 8);
        if (MiConfigSingleton.V3().l3().C0().size() > 5) {
            View view = this.E.getView(0, null, this.F.f12560e);
            view.measure(0, 0);
            ViewGroup.LayoutParams layoutParams = this.F.f12560e.getLayoutParams();
            double measuredHeight = view.getMeasuredHeight();
            Double.isNaN(measuredHeight);
            layoutParams.height = (int) (measuredHeight * 5.5d);
        }
        this.G = com.martian.mibook.j.v2.j(this.F.getRoot(), this.s.f11687b.f11655e, this.f10082a);
        this.F.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.f.g1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return u3.this.c1(view2, motionEvent);
            }
        });
    }

    /* renamed from: I1 */
    public /* synthetic */ boolean J1(AdapterView parent, View view, int position, long id) {
        if (this.A && MiConfigSingleton.V3().M4.j()) {
            d(MiConfigSingleton.V3().M4.f());
        }
        this.A = !this.A;
        return true;
    }

    private void I2(final int position, final String firstPwd, String hint) {
        com.martian.libmars.utils.k0.V(this.f10082a, !com.martian.libsupport.k.p(firstPwd) ? "确认密码" : "设置密码", hint, false, true, new k0.i() { // from class: com.martian.mibook.f.n1
            @Override // com.martian.libmars.utils.k0.i
            public final void a(String str) {
                u3.this.P1(firstPwd, position, str);
            }
        });
    }

    public void J2() {
        if (this.O == null || com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        this.t.f12458b.setVisibility(0);
        if (com.martian.libmars.d.h.F().I0()) {
            this.t.f12461e.setImageResource(R.drawable.bg_bookrack_header_night);
        }
        this.l = System.currentTimeMillis();
        this.t.f12462f.setVisibility(8);
        this.t.f12460d.removeAllViews();
        View inflate = LayoutInflater.from(this.f10082a).inflate(R.layout.item_bookrack_mission, (ViewGroup) null);
        com.martian.mibook.e.l3 a2 = com.martian.mibook.e.l3.a(inflate);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.R1(view);
            }
        });
        a2.f12294f.setVisibility(0);
        a2.f12291c.setVisibility(0);
        a2.f12294f.setMaxLines(1);
        a2.f12294f.setText(this.O.getTitle());
        a2.f12291c.setText(com.martian.libsupport.k.v(this.O.getDesc()));
        com.martian.libmars.utils.n0.p(this.f10082a, this.O.getIcon(), a2.f12290b, MiConfigSingleton.V3().i3(), MiConfigSingleton.V3().e2(), 2);
        if (!this.O.isExposed()) {
            this.O.setExposed(true);
            com.martian.mibook.lib.model.g.b.C(this.f10082a, this.O.getRecommend() + "-曝光");
        }
        if (com.martian.libsupport.k.p(this.O.getTitle()) || this.O.getTitle().length() > 7) {
            a2.f12292d.setVisibility(8);
        } else {
            a2.f12292d.setVisibility(0);
        }
        this.t.f12460d.addView(inflate);
    }

    /* renamed from: K0 */
    public /* synthetic */ void L0(Integer type) {
        if (this.P == null || type.intValue() != this.P.getType()) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.f.l1
            @Override // java.lang.Runnable
            public final void run() {
                u3.this.e1();
            }
        }, 1000L);
    }

    /* renamed from: K1 */
    public /* synthetic */ void L1(final int type, String tagName) {
        if (type == 0) {
            B0(tagName);
        } else {
            z0(tagName);
        }
    }

    /* renamed from: M0 */
    public /* synthetic */ void N0(Integer position) {
        if (position == null || position.intValue() != com.martian.mibook.application.v0.A) {
            return;
        }
        this.s.f11688c.smoothScrollToPosition(0);
    }

    /* renamed from: M1 */
    public /* synthetic */ void N1(final int position, final BookWrapper bookWrapper) {
        while (position < this.r.size()) {
            if (this.r.get(position) == bookWrapper) {
                MiConfigSingleton.V3().l3().D(position);
                d("删除成功");
                S2(bookWrapper);
                n2();
                return;
            }
            position++;
        }
        d("删除失败");
    }

    public void M2() {
        if (this.P == null || com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        this.t.f12459c.setVisibility(0);
        this.t.f12463g.setVisibility(0);
        this.t.f12466j.setText(this.P.getTitle());
        this.t.f12465i.setText(this.P.getDesc());
        this.t.f12464h.setText(this.P.getButtonText());
        this.t.f12463g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.h2(view);
            }
        });
        com.martian.mibook.lib.model.g.b.C(this.f10082a, this.P.getRecommend() + "-曝光");
    }

    public void N2(String msg, boolean refreshContent) {
        if (!refreshContent || MiConfigSingleton.V3().M0()) {
            return;
        }
        d(msg);
    }

    /* renamed from: O1 */
    public /* synthetic */ void P1(final String firstPwd, final int position, String text) {
        if (TextUtils.isEmpty(text)) {
            d("密码不能为空,请重试");
            return;
        }
        if (TextUtils.isEmpty(firstPwd)) {
            if (text.length() == 4) {
                I2(position, text, "请再输入一次密码");
                return;
            } else {
                d("请输入四位数字密码");
                return;
            }
        }
        if (!text.equals(firstPwd)) {
            d("两次密码输入不致，请重试");
            return;
        }
        MiConfigSingleton.V3().M4.D(text);
        d("设置成功，长按两次私密分类可显示密码");
        MiConfigSingleton.V3().m7();
        A2(position);
        this.z = true;
    }

    /* renamed from: P0 */
    public /* synthetic */ void Q0(View view) {
        X2(false);
    }

    public void P2(final BookWrapper bookWrapper, final int position) {
        if (bookWrapper == null || position < 0) {
            return;
        }
        Book book = bookWrapper.book;
        if (book == null) {
            String sourceString = bookWrapper.mibook.getSourceString();
            if (TextUtils.isEmpty(sourceString)) {
                this.f10082a.k1("无法识别的书籍");
                return;
            } else {
                MiConfigSingleton.V3().l3().m(com.martian.mibook.lib.model.manager.d.k(sourceString), new c(bookWrapper, position));
                return;
            }
        }
        if (MiConfigSingleton.V3().l3().S(book) == null) {
            MiConfigSingleton.V3().l3().s1(book);
        }
        if (book.isLocal()) {
            if (!((LocalBook) book).exists()) {
                G2(bookWrapper, position);
                return;
            } else if (bookWrapper.isCaching) {
                d("智能分章中，先去换个封面呗～～");
                return;
            }
        }
        if (bookWrapper.hasUpdate()) {
            bookWrapper.setHasUpdate(false);
            bookWrapper.setUpdateCategoryRading(true);
            MiConfigSingleton.V3().l3().k1(bookWrapper.item);
        }
        com.martian.mibook.lib.model.g.b.S(this.f10082a, MiConfigSingleton.V3().k() == 2 ? "女频书架" : "男频书架", "点击阅读");
        List<BookWrapper> list = this.r;
        if (list != null && list.size() > 2) {
            List<BookWrapper> list2 = this.r;
            if (bookWrapper == list2.get(list2.size() - 2)) {
                com.martian.libmars.activity.j1 j1Var = this.f10082a;
                StringBuilder sb = new StringBuilder();
                sb.append(MiConfigSingleton.V3().k() != 2 ? "男频书架" : "女频书架");
                sb.append("-最后一本-点击");
                com.martian.mibook.lib.model.g.b.B(j1Var, sb.toString());
            }
        }
        com.martian.mibook.j.s2.g0(this.f10082a, bookWrapper.mibook, MiConfigSingleton.V3().l3().x2(book, bookWrapper.item.isReaded()), bookWrapper.item.getReadingChapterIndex(), bookWrapper.item.getReadingContentPos(), bookWrapper.item.getReadingContentLength(), true);
    }

    /* renamed from: Q1 */
    public /* synthetic */ void R1(View v) {
        com.martian.mibook.lib.model.g.b.C(this.f10082a, this.O.getRecommend() + "-点击");
        if (this.O.getType() != 16) {
            this.f13296j.d(com.martian.mibook.application.v0.f11601e, this.O);
        } else {
            if ((this.O.getOrigin() instanceof MiReadingRecord) && com.martian.mibook.j.s2.j0(this.f10082a, (MiReadingRecord) this.O.getOrigin())) {
                return;
            }
            this.f10082a.k1("打开失败");
        }
    }

    public void Q2() {
        MiConfigSingleton.V3().T8(this.f10082a, new h());
    }

    /* renamed from: R0 */
    public /* synthetic */ void S0(View view) {
        s2();
    }

    public void R2() {
        if (MiConfigSingleton.V3().L3() >= 0 || !MiConfigSingleton.V3().x5()) {
            c3();
        } else {
            new k(this.f10082a).j();
        }
    }

    /* renamed from: S1 */
    public /* synthetic */ void T1(final PopupWindow menuPopupWindow, View v) {
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "批量管理");
        X2(true);
        menuPopupWindow.dismiss();
    }

    private void S2(final BookWrapper bookWrapper) {
        if (!bookWrapper.isCaching || bookWrapper.book == null) {
            return;
        }
        MiConfigSingleton.V3().q3().i(bookWrapper.book);
    }

    /* renamed from: T0 */
    public /* synthetic */ void U0(View view) {
        q2();
    }

    public void T2(final int position) {
        if (!MiConfigSingleton.V3().M4.j()) {
            H2(position);
            return;
        }
        if (this.z) {
            A2(position);
        } else if (MiConfigSingleton.V3().h5()) {
            com.martian.libmars.utils.k0.V(this.f10082a, "输入密码", "请输入4位私密分类密码", true, true, new k0.i() { // from class: com.martian.mibook.f.j1
                @Override // com.martian.libmars.utils.k0.i
                public final void a(String str) {
                    u3.this.j2(position, str);
                }
            });
        } else {
            H2(position);
        }
    }

    /* renamed from: U1 */
    public /* synthetic */ void V1(final PopupWindow menuPopupWindow, View v) {
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "导入图书");
        this.f10082a.startActivity(BookScanActivity.class);
        menuPopupWindow.dismiss();
    }

    private void U2() {
        if (b()) {
            if (this.k > 0 && MartianRPUserManager.t() - this.k > 30000) {
                C0(false);
            }
            if (this.l <= 0 || System.currentTimeMillis() - this.l <= 30000) {
                return;
            }
            Y2();
        }
    }

    /* renamed from: V0 */
    public /* synthetic */ void W0(View view) {
        r2();
    }

    private void V2() {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (BookWrapper bookWrapper : this.r) {
            if (bookWrapper != null && bookWrapper.item != null && !bookWrapper.isAdsItem && !bookWrapper.isAdderItem) {
                if (i2 > 0) {
                    sb.append("/");
                }
                sb.append(bookWrapper.getBookName());
                i2++;
                if (i2 >= 5) {
                    break;
                }
            }
        }
        if (com.martian.libsupport.k.p(sb.toString())) {
            return;
        }
        MiConfigSingleton.V3().P7(sb.toString());
    }

    /* renamed from: W1 */
    public /* synthetic */ void X1(final PopupWindow menuPopupWindow, View view) {
        List<BookWrapper> L = MiConfigSingleton.V3().l3().L(false, false);
        if (L == null || L.size() <= 0) {
            this.f10082a.k1("暂无书籍");
        } else {
            com.martian.mibook.lib.model.g.b.B(this.f10082a, "智能找书");
            startActivity(SimilarityBookActivity.class);
        }
        menuPopupWindow.dismiss();
    }

    private void W2() {
        boolean z = this.p.c0() > 0;
        this.B.f12107d.setAlpha(z ? 1.0f : 0.6f);
        this.B.f12106c.setAlpha(z ? 1.0f : 0.6f);
        this.B.f12108e.setAlpha(z ? 1.0f : 0.6f);
        if (MiConfigSingleton.V3().l3().a1()) {
            this.B.f12105b.setAlpha(z ? 1.0f : 0.6f);
        } else {
            this.B.f12105b.setAlpha(this.p.c0() != 1 ? 0.6f : 1.0f);
        }
    }

    /* renamed from: X0 */
    public /* synthetic */ void Y0(View view) {
        p2();
    }

    /* renamed from: Y1 */
    public /* synthetic */ void Z1(final PopupWindow menuPopupWindow, View v) {
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "归档图书");
        this.f10082a.startActivity(ArchiveListActivity.class);
        menuPopupWindow.dismiss();
    }

    private void Y2() {
        if (MiConfigSingleton.V3().j5()) {
            return;
        }
        MiConfigSingleton.V3().L4.C(this.f10082a, this.u);
        MiConfigSingleton.V3().L4.N(this.f10082a, this.u);
    }

    /* renamed from: Z0 */
    public /* synthetic */ void a1(View view) {
        if (r0()) {
            B2();
        }
    }

    private void Z2(boolean batch) {
        if (this.s.f11689d.f11780c.getVisibility() == 0) {
            this.s.f11689d.getRoot().setAlpha(batch ? 0.4f : 1.0f);
            this.s.f11689d.f11779b.setVisibility(batch ? 0 : 8);
        }
    }

    /* renamed from: a2 */
    public /* synthetic */ void b2(final PopupWindow menuPopupWindow, View v) {
        if (MiConfigSingleton.V3().n3() == 1) {
            MiConfigSingleton.V3().f7(0);
            com.martian.mibook.lib.model.g.b.B(this.f10082a, "列表视图");
        } else {
            MiConfigSingleton.V3().f7(1);
            com.martian.mibook.lib.model.g.b.B(this.f10082a, "封面视图");
        }
        H0();
        menuPopupWindow.dismiss();
    }

    private void a3() {
        com.martian.mibook.ui.o.n3 n3Var = this.q;
        if (n3Var == null) {
            return;
        }
        if (MiConfigSingleton.V3().l3().Z().getAllCategoryBookSize(n3Var.h(), this.q.g()) <= 0) {
            this.q.k(0);
        }
    }

    /* renamed from: b1 */
    public /* synthetic */ boolean c1(View v, MotionEvent event) {
        int top = this.F.getRoot().findViewById(R.id.bookrack_category).getTop();
        int y = (int) event.getY();
        if (event.getAction() == 1 && y < top) {
            this.G.dismiss();
        }
        return true;
    }

    private void b3() {
        List<BookWrapper> G0 = G0();
        if (G0.size() > 0) {
            Iterator<BookWrapper> it = G0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MiBookStoreItem miBookStoreItem = it.next().item;
                if (miBookStoreItem != null && !miBookStoreItem.isFlagTop()) {
                    this.M = true;
                    break;
                }
                this.M = false;
            }
        } else {
            this.M = true;
        }
        this.B.f12108e.setText(MiConfigSingleton.V3().n(this.M ? "置顶" : "取消置顶"));
    }

    /* renamed from: c2 */
    public /* synthetic */ void d2(final PopupWindow menuPopupWindow, View v) {
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "搜索书架");
        this.s.f11689d.f11780c.setVisibility(0);
        menuPopupWindow.dismiss();
        com.martian.mibook.j.s2.Q(this.f10082a, this.s.f11689d.f11782e);
    }

    /* renamed from: d1 */
    public /* synthetic */ void e1() {
        MiConfigSingleton.V3().L4.N(this.f10082a, this.u);
    }

    private void d3(boolean selectAll) {
        this.C.f12231c.setText(getString(selectAll ? R.string.cancel_select_all : R.string.select_all));
    }

    /* renamed from: e2 */
    public /* synthetic */ void f2(final PopupWindow menuPopupWindow, View v) {
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "云同步");
        q0();
        menuPopupWindow.dismiss();
    }

    @SuppressLint({"SetTextI18n"})
    public void e3() {
        String str;
        W2();
        b3();
        int c0 = this.p.c0();
        ThemeTextView themeTextView = this.B.f12107d;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.cd_delete));
        if (c0 > 0) {
            str = "(" + c0 + ")";
        } else {
            str = "";
        }
        sb.append(str);
        themeTextView.setText(sb.toString());
        if (MiConfigSingleton.V3().l3().a1()) {
            this.B.f12105b.setText(this.f10082a.getString(R.string.more));
        } else {
            this.B.f12105b.setText(this.f10082a.getString(R.string.detail));
        }
        d3(c0 >= this.p.a0());
    }

    /* renamed from: g1 */
    public /* synthetic */ void h1(View v) {
        if (MiConfigSingleton.V3().l2(this.f10082a, 1003)) {
            if (MiConfigSingleton.V3().x4() == null) {
                this.f10082a.k1("账号尚未生成完毕，请稍后重试");
            } else if (MiConfigSingleton.V3().L3() > MartianRPUserManager.t()) {
                com.martian.mibook.lib.model.g.b.B(this.f10082a, "时段奖励-倒计时-点击");
                com.martian.libmars.utils.k0.W(this.f10082a, "温馨提示", "倒计时结束即可领取奖励", "朕知道了", null, null);
            } else {
                com.martian.mibook.lib.model.g.b.B(this.f10082a, "时段奖励-红包-点击");
                j0();
            }
        }
    }

    /* renamed from: g2 */
    public /* synthetic */ void h2(View v) {
        com.martian.mibook.lib.model.g.b.C(this.f10082a, this.P.getRecommend() + "-点击");
        if (this.P.getType() == 13) {
            this.P.diractForward = false;
        }
        this.f13296j.d(com.martian.mibook.application.v0.f11601e, this.P);
    }

    /* renamed from: i1 */
    public /* synthetic */ void j1() {
        X2(false);
    }

    /* renamed from: i2 */
    public /* synthetic */ void j2(final int position, String text) {
        if (TextUtils.isEmpty(text)) {
            d("密码不能为空,请重试");
            return;
        }
        if (MiConfigSingleton.V3().M4.l(text)) {
            A2(position);
            this.z = true;
            return;
        }
        int i2 = this.D + 1;
        this.D = i2;
        if (i2 < 3) {
            d("密码不正确，请重试");
        } else {
            d("长按两次私密分类可显示密码");
            this.D = 0;
        }
    }

    private void j0() {
        if (this.x) {
            this.f10082a.k1("奖励领取中");
        } else {
            this.x = true;
            new l(this.f10082a).j();
        }
    }

    public void k0(AppTask appTask) {
        List<BookWrapper> list = this.r;
        if (list == null || list.isEmpty()) {
            return;
        }
        BookWrapper bookWrapper = this.r.get(0);
        if (bookWrapper.isAdsItem) {
            bookWrapper.customData = appTask;
            return;
        }
        BookWrapper bookWrapper2 = new BookWrapper(null, null, null);
        bookWrapper2.customData = appTask;
        bookWrapper2.isAdsItem = true;
        this.r.add(0, bookWrapper2);
    }

    /* renamed from: k1 */
    public /* synthetic */ void l1(int position) {
        PopupWindow popupWindow = this.G;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.p != null) {
            m0(this.E.c(position).f10608a);
        }
    }

    private void k2() {
        if (com.martian.libmars.utils.n0.B(this.f10082a)) {
            if (this.o == null) {
                this.o = new o();
            }
            MiConfigSingleton.V3().N4.x(this.f10082a, true, this.o);
        }
    }

    private void l0(String tagName) {
        j.d b2 = this.E.b(tagName);
        if (b2 == null) {
            this.E.a(new j.d(tagName, 1L));
        } else {
            b2.f10609b = Long.valueOf(b2.f10609b.longValue() + 1);
        }
    }

    private void m0(final String tagName) {
        K2(true, "批量归档中");
        this.p.S(tagName, new g(tagName));
    }

    /* renamed from: m1 */
    public /* synthetic */ void n1(View v) {
        PopupWindow popupWindow = this.G;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        F2(1);
    }

    private void m2(ThemeTextView textView) {
        boolean z = this.p.c0() == 1;
        textView.setAlpha(z ? 1.0f : 0.6f);
        textView.setSelectable(z);
    }

    private void n0() {
        if (this.r == null) {
            new m().execute(new Void[0]);
        } else {
            n2();
            U2();
        }
    }

    public synchronized void n2() {
        if (com.martian.libmars.utils.n0.c(this.f10082a)) {
            return;
        }
        com.martian.mibook.ui.o.u3 u3Var = this.p;
        if (u3Var != null) {
            u3Var.D0();
        }
        com.martian.mibook.ui.o.n3 n3Var = this.q;
        if (n3Var != null) {
            n3Var.notifyDataSetChanged();
        }
    }

    private void o0() {
        com.martian.libmars.b.d dVar = new com.martian.libmars.b.d();
        this.f13296j = dVar;
        dVar.c(com.martian.mibook.application.v0.k, new rx.k.b() { // from class: com.martian.mibook.f.c1
            @Override // rx.k.b
            public final void call(Object obj) {
                u3.this.L0((Integer) obj);
            }
        });
        this.f13296j.c(com.martian.mibook.application.v0.l, new rx.k.b() { // from class: com.martian.mibook.f.h1
            @Override // rx.k.b
            public final void call(Object obj) {
                u3.this.N0((Integer) obj);
            }
        });
    }

    /* renamed from: o1 */
    public /* synthetic */ void p1(final boolean isRecommendedBook, boolean isChecked) {
        if (this.p != null) {
            K2(true, "删除中");
            this.p.X(new e());
            if (isRecommendedBook && isChecked) {
                com.martian.libmars.utils.k0.P(this.f10082a, getString(R.string.confirm_message), "关闭书籍推荐将无法接收最新的爆款热门小说，确定关闭吗？（关闭后可在设置中开启）", new k0.l() { // from class: com.martian.mibook.f.r0
                    @Override // com.martian.libmars.utils.k0.l
                    public final void a() {
                        MiConfigSingleton.V3().t7(true);
                    }
                });
            }
        }
    }

    private void p0() {
        List<BookWrapper> G0 = G0();
        com.martian.mibook.lib.model.g.b.B(this.f10082a, this.M ? "置顶" : "取消置顶");
        for (BookWrapper bookWrapper : G0) {
            int i2 = 0;
            while (true) {
                if (i2 < this.r.size()) {
                    BookWrapper bookWrapper2 = this.r.get(i2);
                    if (!bookWrapper2.isSelect() || bookWrapper2 != bookWrapper) {
                        i2++;
                    } else if (this.M) {
                        MiConfigSingleton.V3().l3().G0(bookWrapper2, i2);
                    } else {
                        MiConfigSingleton.V3().l3().t(bookWrapper2, i2);
                    }
                }
            }
        }
        n2();
        v2();
    }

    /* renamed from: q1 */
    public /* synthetic */ boolean r1(final PopupWindow morePopWindow, View v, MotionEvent event) {
        int top = this.N.getRoot().findViewById(R.id.bookrack_batch_shade).getTop();
        int y = (int) event.getY();
        if (event.getAction() == 1 && y < top) {
            morePopWindow.dismiss();
        }
        return true;
    }

    private boolean r0() {
        if (!x0()) {
            return false;
        }
        if (this.p.c0() > 0) {
            return true;
        }
        d("至少选中1本小说");
        return false;
    }

    private boolean s0() {
        if (this.p.c0() == 1) {
            return true;
        }
        this.f10082a.k1("仅可以操作一本书籍");
        return false;
    }

    /* renamed from: s1 */
    public /* synthetic */ void t1(final PopupWindow morePopWindow, final List selectBookWrapper, View v) {
        if (s0()) {
            morePopWindow.dismiss();
            v2();
            Book book = ((BookWrapper) selectBookWrapper.get(0)).book;
            if (book != null) {
                com.martian.mibook.j.s2.R(this.f10082a, book);
            } else {
                this.f10082a.k1("无法识别的书籍");
            }
        }
    }

    private boolean t0() {
        if (MiConfigSingleton.V3().j5()) {
            return false;
        }
        if (MiConfigSingleton.V3().M0()) {
            this.k = MartianRPUserManager.t() - 30000;
            return false;
        }
        if (!MiConfigSingleton.V3().h6()) {
            return !MiConfigSingleton.V3().y8();
        }
        if (!this.m) {
            if (this.k > 0) {
                w2();
            }
            this.m = true;
        }
        return false;
    }

    public void t2(String loadingMsg, String showMsg) {
        K2(false, loadingMsg);
        d(showMsg);
        u2();
        v2();
    }

    private void u0(String category) {
        if (this.p == null) {
            return;
        }
        K2(true, "批量分类中");
        this.p.T(category, new f(category));
    }

    /* renamed from: u1 */
    public /* synthetic */ void v1(final PopupWindow morePopWindow, View view) {
        morePopWindow.dismiss();
        o2();
    }

    private void u2() {
        a3();
        A2(this.q.h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v0(final boolean refreshContent) {
        String F0 = F0(false);
        if (com.martian.libsupport.k.p(F0)) {
            N2("没有新的更新", refreshContent);
            p();
            D0(refreshContent);
        } else {
            a aVar = new a(BookUpdateInfoParams.class, BookUpdateInfo.class, this.f10082a, refreshContent);
            ((BookUpdateInfoParams) aVar.k()).setSourceStrings(F0);
            aVar.j();
            w0();
        }
    }

    private void v2() {
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.f.p0
            @Override // java.lang.Runnable
            public final void run() {
                u3.this.j1();
            }
        }, 100L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w0() {
        if (MiConfigSingleton.V3().g5()) {
            String F0 = F0(true);
            if (com.martian.libsupport.k.p(F0)) {
                return;
            }
            b bVar = new b(BookshelfInfoPushParams.class, Boolean.class, this.f10082a);
            ((BookshelfInfoPushParams) bVar.k()).setSourceStrings(F0);
            bVar.j();
        }
    }

    /* renamed from: w1 */
    public /* synthetic */ void x1(final PopupWindow morePopWindow, final List selectBookWrapper, View view) {
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "换个封面");
        if (s0()) {
            morePopWindow.dismiss();
            v2();
            O2((BookWrapper) selectBookWrapper.get(0));
        }
    }

    public void w2() {
        List<BookWrapper> list = this.r;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<BookWrapper> it = this.r.iterator();
        while (it.hasNext()) {
            if (it.next().isAdsItem) {
                it.remove();
            }
        }
        n2();
    }

    private boolean x0() {
        if (this.L) {
            d("处理中，请稍候");
            return false;
        }
        com.martian.mibook.ui.o.u3 u3Var = this.p;
        if (u3Var != null && u3Var.a0() > 0) {
            return true;
        }
        d("没有可操作的小说");
        return false;
    }

    private void y0() {
        this.p.U();
        e3();
    }

    /* renamed from: y1 */
    public /* synthetic */ void z1(final PopupWindow morePopWindow, final List selectBookWrapper, View view) {
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "换个书名");
        if (s0()) {
            morePopWindow.dismiss();
            v2();
            MiConfigSingleton.V3().l3().U2(this.f10082a, (BookWrapper) selectBookWrapper.get(0), this.p);
        }
    }

    private void y2() {
        I0();
        this.E.f(new i3.a() { // from class: com.martian.mibook.f.o0
            @Override // com.martian.mibook.ui.o.i3.a
            public final void a(int i2) {
                u3.this.l1(i2);
            }
        });
        this.F.f12561f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.n1(view);
            }
        });
    }

    private void z0(final String title) {
        if (this.p == null) {
            return;
        }
        if (TextUtils.isEmpty(title)) {
            d("请输入自定义标签内容");
        } else {
            l0(title);
            m0(title);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void B2() {
        if (com.martian.libmars.utils.n0.C(this.f10082a)) {
            final List<BookWrapper> G0 = G0();
            if (G0.size() <= 0) {
                this.f10082a.k1("暂无可操作的书籍");
                return;
            }
            if (!MiConfigSingleton.V3().l3().a1()) {
                if (G0.size() == 1) {
                    BookWrapper bookWrapper = G0.get(0);
                    Book book = bookWrapper.book;
                    if (book == null || !book.isLocal()) {
                        com.martian.mibook.j.s2.R(this.f10082a, bookWrapper.book);
                        return;
                    } else {
                        O2(bookWrapper);
                        return;
                    }
                }
                return;
            }
            if (this.N == null) {
                this.N = com.martian.mibook.e.j1.a(this.f10082a.getLayoutInflater().inflate(R.layout.bookrack_batch_more_view, (ViewGroup) null));
            }
            m2(this.N.f12160d);
            m2(this.N.f12162f);
            m2(this.N.f12163g);
            final PopupWindow l2 = com.martian.mibook.j.v2.l(this.N.getRoot(), this.s.f11687b.f11655e, this.f10082a, false, false);
            this.N.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.f.r1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return u3.this.r1(l2, view, motionEvent);
                }
            });
            this.N.f12158b.setVisibility(MiConfigSingleton.V3().I0() ? 0 : 8);
            Iterator<BookWrapper> it = G0.iterator();
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Book book2 = it.next().book;
                if (book2 != null && !book2.isLocal()) {
                    z = false;
                    break;
                }
                z = true;
            }
            if (z) {
                this.N.f12164h.setVisibility(0);
                this.N.f12161e.setVisibility(8);
                this.N.f12159c.setVisibility(8);
            } else {
                this.N.f12164h.setVisibility(8);
                this.N.f12161e.setVisibility(0);
                this.N.f12159c.setVisibility(0);
            }
            this.N.f12160d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.t1(l2, G0, view);
                }
            });
            this.N.f12159c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.k1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.v1(l2, view);
                }
            });
            this.N.f12162f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.x1(l2, G0, view);
                }
            });
            this.N.f12163g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u3.this.z1(l2, G0, view);
                }
            });
        }
    }

    public void C2(int categoryIndex) {
        String categoryItem = MiConfigSingleton.V3().l3().Z().getCategoryItem(categoryIndex);
        com.martian.mibook.ui.o.u3 u3Var = this.p;
        if (u3Var != null) {
            u3Var.u0(categoryItem);
        } else {
            d("分类出错，请退出重试");
        }
    }

    public void E2() {
        List<BookWrapper> list = this.r;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.s.f11687b.f11659i.setVisibility(8);
        View inflate = this.f10082a.getLayoutInflater().inflate(R.layout.bookrack_class, (ViewGroup) null);
        com.martian.mibook.e.l1 a2 = com.martian.mibook.e.l1.a(inflate);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        this.y = popupWindow;
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.y.setOutsideTouchable(true);
        this.y.setFocusable(true);
        this.y.showAsDropDown(this.s.f11687b.f11658h, 0, 0);
        com.martian.mibook.ui.o.n3 n3Var = this.q;
        if (n3Var != null) {
            n3Var.notifyDataSetChanged();
            this.q.j(new ArrayList(this.r));
        }
        a2.f12286b.setAdapter((ListAdapter) this.q);
        a2.f12286b.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.f.w0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                u3.this.H1(adapterView, view, i2, j2);
            }
        });
        a2.f12286b.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.martian.mibook.f.p1
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i2, long j2) {
                return u3.this.J1(adapterView, view, i2, j2);
            }
        });
    }

    public void H0() {
        if (this.r == null) {
            return;
        }
        if (this.p == null) {
            BookWrapper bookWrapper = new BookWrapper(null, null, null);
            bookWrapper.isAdderItem = true;
            this.r.add(bookWrapper);
            if (t0()) {
                AppTask x3 = MiConfigSingleton.V3().x3(com.martian.mibook.b.b.u);
                x3.iconUrl = "";
                k0(x3);
            }
            com.martian.mibook.ui.o.u3 u3Var = new com.martian.mibook.ui.o.u3(this.f10082a, this.r, new p());
            this.p = u3Var;
            u3Var.y0(new q());
            this.p.z0(MiConfigSingleton.V3().g0());
            V2();
        } else {
            n2();
        }
        if (MiConfigSingleton.V3().n3() == 1) {
            this.s.f11688c.setLayoutManager(new GridLayoutManager(this.f10082a, 3));
        } else {
            this.s.f11688c.setLayoutManager(new LinearLayoutManager(this.f10082a));
        }
        this.s.f11688c.setAdapter(this.p);
    }

    public void K2(boolean loading, String msg) {
        this.L = loading;
        if (this.K == null) {
            this.K = new ProgressDialog(this.f10082a);
        }
        this.K.setMessage(msg);
        if (loading) {
            this.K.show();
        } else {
            this.K.dismiss();
        }
    }

    public void L2() {
        com.martian.mibook.j.s2.n(this.f10082a, this.s.f11689d.f11782e);
        View inflate = this.f10082a.getLayoutInflater().inflate(R.layout.bookrack_menu, (ViewGroup) null);
        com.martian.mibook.e.n1 a2 = com.martian.mibook.e.n1.a(inflate);
        if (MiConfigSingleton.V3().n3() == 1) {
            a2.o.setImageResource(R.drawable.menu_icon_list_cover);
            a2.p.setText(this.f10082a.getString(R.string.listview));
        } else {
            a2.o.setImageResource(R.drawable.menu_icon_grid_cover);
            a2.p.setText(this.f10082a.getString(R.string.cover_view));
        }
        com.martian.mibook.lib.model.g.b.B(this.f10082a, "更多选项");
        final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(this.s.f11687b.f11655e, 0, 0);
        if (MiConfigSingleton.V3().l3().a1()) {
            a2.f12406e.setVisibility(0);
            a2.f12407f.setVisibility(0);
        } else {
            a2.f12406e.setVisibility(8);
            a2.f12407f.setVisibility(8);
        }
        a2.f12406e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.Z1(popupWindow, view);
            }
        });
        a2.f12408g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.b2(popupWindow, view);
            }
        });
        a2.f12410i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.d2(popupWindow, view);
            }
        });
        a2.f12405d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.f2(popupWindow, view);
            }
        });
        a2.f12403b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.T1(popupWindow, view);
            }
        });
        a2.f12404c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.V1(popupWindow, view);
            }
        });
        a2.k.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.X1(popupWindow, view);
            }
        });
    }

    public void O2(BookWrapper bookWrapper) {
        Bundle bundle = new Bundle();
        bundle.putString(MiConfigSingleton.L0, bookWrapper.getBookName());
        MiBook miBook = bookWrapper.mibook;
        if (miBook != null) {
            bundle.putString(MiConfigSingleton.I0, miBook.getBookId());
        }
        this.f10082a.startActivity(CoverSwitchActivity.class, bundle);
    }

    public void X2(boolean batch) {
        if (!batch || x0()) {
            this.p.p0(batch);
            q(!batch);
            Z2(batch);
            if (batch) {
                A0();
            }
            com.martian.libmars.utils.h0.a(this.f10082a, this.C.getRoot(), batch, com.martian.libmars.utils.h0.f10145b);
            com.martian.libmars.utils.h0.a(this.f10082a, this.B.getRoot(), batch, com.martian.libmars.utils.h0.f10144a);
        }
    }

    @Override // com.martian.libmars.f.e
    protected void c() {
    }

    public void c3() {
        long L3 = MiConfigSingleton.V3().L3();
        if (L3 <= MartianRPUserManager.t()) {
            this.s.f11687b.f11660j.setVisibility(8);
            this.s.f11687b.k.setVisibility(0);
        } else {
            this.s.f11687b.f11660j.setVisibility(0);
            this.s.f11687b.k.setVisibility(8);
            this.s.f11687b.f11660j.p(L3, "领取");
        }
    }

    @Override // com.martian.libmars.f.h
    public int h() {
        return R.layout.fragment_bookrack;
    }

    public void l2() {
        com.martian.mibook.lib.model.g.b.i0(this.f10082a, "点击-书架");
        MiConfigSingleton.V3().N4.t(this.f10082a, b.d.a.j.b.f4373f, new d());
    }

    @Override // com.martian.libmars.f.h
    public void m() {
        v0(!MiConfigSingleton.V3().M0());
        Y2();
    }

    public void o2() {
        if (r0()) {
            y2();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.br_header_bar_more) {
            L2();
            return;
        }
        if (id == R.id.br_class) {
            com.martian.mibook.lib.model.g.b.B(this.f10082a, "书籍分类");
            E2();
            return;
        }
        if (id == R.id.btn_clear_search_text) {
            com.martian.mibook.lib.model.g.b.B(this.f10082a, "清空关键字");
            this.s.f11689d.f11782e.setText("");
            this.s.f11689d.f11780c.setVisibility(8);
            com.martian.mibook.j.s2.n(this.f10082a, this.s.f11689d.f11782e);
            return;
        }
        if (id != R.id.bookshelf_main_search_icon) {
            if (id == R.id.bookshelf_reading_history) {
                com.martian.mibook.lib.model.g.b.B(this.f10082a, "阅读记录");
                this.f10082a.startActivity(ReadingRecordActivity.class);
                return;
            }
            return;
        }
        com.martian.libmars.activity.j1 j1Var = this.f10082a;
        StringBuilder sb = new StringBuilder();
        sb.append("书架搜索-");
        sb.append(MiConfigSingleton.V3().k() == 2 ? "女频" : "男频");
        com.martian.mibook.lib.model.g.b.S(j1Var, sb.toString(), "点击搜索");
        startActivity(SearchBookMainActivity.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.martian.libmars.b.d dVar = this.f13296j;
        if (dVar != null) {
            dVar.b();
        }
        MiConfigSingleton.V3().l3().u();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.s.f11687b.f11660j.s();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        c3();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle outState) {
        this.s.f11689d.f11782e.clearFocus();
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        n0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (MiConfigSingleton.V3().E6()) {
            MiConfigSingleton.V3().G7(this.q.h());
            MiConfigSingleton.V3().F7(this.q.g());
        }
        MiConfigSingleton.V3().L4.u0();
        MiConfigSingleton.V3().l3().q3();
        MiConfigSingleton.V3().l3().r3();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View baseView, Bundle savedInstanceState) {
        super.onViewCreated(baseView, savedInstanceState);
        com.martian.mibook.e.a3 a2 = com.martian.mibook.e.a3.a(g());
        this.s = a2;
        ((LinearLayout.LayoutParams) a2.f11687b.f11657g.getLayoutParams()).topMargin = this.f10082a.F0();
        this.s.f11687b.f11654d.setOnClickListener(this);
        this.s.f11687b.f11653c.setOnClickListener(this);
        this.s.f11687b.f11652b.setOnClickListener(this);
        this.s.f11687b.f11652b.setVisibility(MiConfigSingleton.V3().W3().getEnableSearch() ? 0 : 8);
        this.s.f11687b.f11655e.setOnClickListener(this);
        this.s.f11689d.f11781d.setOnClickListener(this);
        this.s.f11689d.f11782e.clearFocus();
        this.s.f11689d.f11782e.addTextChangedListener(new i());
        View inflate = this.f10082a.getLayoutInflater().inflate(R.layout.bookrack_mission, (ViewGroup) null);
        this.t = com.martian.mibook.e.o1.a(inflate);
        this.s.f11688c.m(inflate);
        this.u = new j();
        this.q = new com.martian.mibook.ui.o.n3(this.f10082a, MiConfigSingleton.V3().l3().Z());
        o0();
        Y2();
        R2();
        this.s.f11687b.l.setVisibility(MiConfigSingleton.V3().A5() ? 8 : 0);
        this.s.f11687b.l.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u3.this.h1(view);
            }
        });
        com.martian.mibook.lib.model.g.b.S(this.f10082a, MiConfigSingleton.V3().k() == 2 ? "女频书架" : "男频书架", "展示");
    }

    public void p2() {
        if (r0()) {
            D2();
        }
    }

    public void q0() {
        if (MiConfigSingleton.V3().n2(this.f10082a)) {
            com.martian.libmars.utils.k0.Q(this.f10082a, getResources().getString(R.string.cloud_sync), "本地书架将和云端书架进行合并，是否进行云端同步？", getResources().getString(R.string.search_close), getResources().getString(R.string.confirm), true, new k0.l() { // from class: com.martian.mibook.f.n0
                @Override // com.martian.libmars.utils.k0.l
                public final void a() {
                    u3.this.Q2();
                }
            }, new k0.j() { // from class: com.martian.mibook.f.m1
                @Override // com.martian.libmars.utils.k0.j
                public final void a() {
                    MiConfigSingleton.V3().U8();
                }
            });
        }
    }

    public void q2() {
        if (r0()) {
            z2();
        }
    }

    public void r2() {
        if (r0()) {
            p0();
        }
    }

    public void s2() {
        if (x0()) {
            this.p.o0();
            e3();
        }
    }

    @Override // com.martian.libmars.f.e, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        U2();
    }

    public void x2(Runnable runnable) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        }
    }

    public void z2() {
        com.martian.mibook.ui.o.u3 u3Var = this.p;
        final boolean z = u3Var != null && u3Var.f0();
        com.martian.libmars.utils.k0.R(this.f10082a, getString(R.string.delete_hint), "是否删除选中的" + this.p.c0() + "本小说?", z ? "不再接收书架书籍推荐" : "清除书籍缓存", !z, new k0.g() { // from class: com.martian.mibook.f.f1
            @Override // com.martian.libmars.utils.k0.g
            public final void a(boolean z2) {
                u3.this.p1(z, z2);
            }
        });
    }
}
