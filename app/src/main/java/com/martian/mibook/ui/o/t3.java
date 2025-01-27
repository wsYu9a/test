package com.martian.mibook.ui.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.request.YWChannelBooksParams;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.ui.o.f4;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class t3 extends PagerAdapter {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14700a;

    /* renamed from: b */
    private final List<YWBookChannel.SubTab> f14701b;

    /* renamed from: c */
    private LoadingTip f14702c;

    /* renamed from: d */
    private final int f14703d;

    /* renamed from: e */
    private final Map<Integer, f4> f14704e = new HashMap();

    /* renamed from: f */
    private final int f14705f;

    /* renamed from: g */
    private boolean f14706g;

    class a extends com.martian.mibook.lib.account.d.g<YWChannelBooksParams, YWBookChannel> {

        /* renamed from: g */
        final /* synthetic */ int f14707g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class x0, Class x1, Context x2, final int val$position) {
            super(x0, x1, x2);
            this.f14707g = val$position;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            t3.this.j(errorResult, true);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<YWBookChannel> ywBookChannels) {
            if (ywBookChannels.get(0) == null || ywBookChannels.get(0).getBookList() == null || ywBookChannels.get(0).getBookList().isEmpty()) {
                t3.this.j(new b.d.c.b.c(-1, ""), false);
                return;
            }
            List<TYBookItem> bookList = ywBookChannels.get(0).getBookList();
            ((YWBookChannel.SubTab) t3.this.f14701b.get(this.f14707g)).setBookList(bookList);
            if (this.f14707g > 0) {
                MiConfigSingleton.V3().l3().K1(bookList);
            }
            t3.this.notifyDataSetChanged();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            t3.this.f14706g = show;
            if (!show || t3.this.f14702c == null) {
                return;
            }
            t3.this.f14702c.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
    }

    public t3(com.martian.libmars.activity.j1 activity, List<YWBookChannel.SubTab> subTabs, int mcid, int seed) {
        this.f14700a = activity;
        this.f14701b = subTabs == null ? new ArrayList<>() : subTabs;
        this.f14703d = mcid;
        this.f14705f = seed;
    }

    /* renamed from: f */
    public /* synthetic */ void g(final int position, int pos) {
        h(position);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h(final int position) {
        if (this.f14706g) {
            return;
        }
        a aVar = new a(YWChannelBooksParams.class, YWBookChannel.class, this.f14700a, position);
        ((YWChannelBooksParams) aVar.k()).setPage(0);
        ((YWChannelBooksParams) aVar.k()).setPageSize(8);
        ((YWChannelBooksParams) aVar.k()).setMcid(Integer.valueOf(this.f14703d));
        ((YWChannelBooksParams) aVar.k()).setExt(com.martian.libmars.d.h.F().n0(this.f14701b.get(position).getExt()));
        ((YWChannelBooksParams) aVar.k()).setCategory(com.martian.libmars.d.h.F().n0(e(position)));
        ((YWChannelBooksParams) aVar.k()).setSeed(Integer.valueOf(this.f14705f));
        aVar.j();
    }

    public List<TYBookItem> d(int position) {
        if (position < getCount()) {
            return this.f14701b.get(position).getBookList();
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public String e(int position) {
        f4 f4Var = this.f14704e.get(Integer.valueOf(position));
        if (f4Var == null) {
            return "";
        }
        String F = f4Var.F();
        return "全部".equalsIgnoreCase(F) ? "" : F;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f14701b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object object) {
        return -2;
    }

    public void i(LoadingTip tip) {
        this.f14702c = tip;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View inflate = View.inflate(this.f14700a, R.layout.bookmall_category_item, null);
        com.martian.mibook.e.g1 a2 = com.martian.mibook.e.g1.a(inflate);
        a2.f11990c.setVisibility(8);
        a2.f11992e.setVisibility(0);
        a2.f11993f.setVisibility(0);
        List<TYBookItem> d2 = d(position);
        if (d2 != null && !d2.isEmpty()) {
            k();
            if (this.f14701b.get(position).getCategories().isEmpty()) {
                a2.f11993f.setVisibility(8);
            } else {
                f4 f4Var = this.f14704e.get(Integer.valueOf(position));
                if (f4Var == null) {
                    f4Var = new f4(this.f14700a, this.f14701b.get(position).getCategories());
                    f4Var.L(new f4.a() { // from class: com.martian.mibook.ui.o.a0
                        @Override // com.martian.mibook.ui.o.f4.a
                        public final void a(int i2) {
                            t3.this.g(position, i2);
                        }
                    });
                    this.f14704e.put(Integer.valueOf(position), f4Var);
                }
                a2.f11993f.setLayoutManager(new LinearLayoutManager(this.f14700a, 0, false));
                a2.f11993f.setAdapter(f4Var);
                if (f4Var.E() > 3) {
                    a2.f11993f.scrollToPosition(f4Var.E());
                }
            }
            com.martian.mibook.j.y2.d(this.f14700a, d(position), a2.f11994g, a2.f11995h);
            container.addView(inflate);
        }
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void j(b.d.c.b.c errorResult, boolean isError) {
        LoadingTip loadingTip = this.f14702c;
        if (loadingTip == null) {
            return;
        }
        if (!isError) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
            return;
        }
        loadingTip.setLoadingTip(errorResult.c() == 100001 ? LoadingTip.LoadStatus.error : LoadingTip.LoadStatus.sereverError);
        if (com.martian.libsupport.k.p(errorResult.d())) {
            return;
        }
        this.f14702c.setTips(errorResult.d());
    }

    public void k() {
        LoadingTip loadingTip = this.f14702c;
        if (loadingTip == null) {
            return;
        }
        loadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    public void l(int position) {
        List<TYBookItem> bookList = this.f14701b.get(position).getBookList();
        if (bookList == null || bookList.isEmpty()) {
            h(position);
        }
    }
}
