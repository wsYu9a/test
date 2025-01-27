package com.martian.mibook.ui.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.request.YWChannelBooksParams;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class s3 extends PagerAdapter {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14686a;

    /* renamed from: b */
    private final List<YWBookChannel.SubTab> f14687b;

    /* renamed from: c */
    private LoadingTip f14688c;

    /* renamed from: d */
    private final int f14689d;

    class a extends com.martian.mibook.lib.account.d.g<YWChannelBooksParams, YWBookChannel> {

        /* renamed from: g */
        final /* synthetic */ int f14690g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class x0, Class x1, Context x2, final int val$position) {
            super(x0, x1, x2);
            this.f14690g = val$position;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            s3.this.h(errorResult, true);
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<YWBookChannel> ywBookChannels) {
            if (ywBookChannels.get(0) == null || ywBookChannels.get(0).getBookList() == null || ywBookChannels.get(0).getBookList().isEmpty()) {
                s3.this.h(new b.d.c.b.c(-1, ""), false);
                return;
            }
            List<TYBookItem> bookList = ywBookChannels.get(0).getBookList();
            ((YWBookChannel.SubTab) s3.this.f14687b.get(this.f14690g)).setBookList(bookList);
            if (this.f14690g > 0) {
                MiConfigSingleton.V3().l3().K1(bookList);
            }
            s3.this.notifyDataSetChanged();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (!show || s3.this.f14688c == null) {
                return;
            }
            s3.this.f14688c.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
    }

    public s3(com.martian.libmars.activity.j1 activity, List<YWBookChannel.SubTab> subTabs, int mcid) {
        this.f14686a = activity;
        this.f14687b = subTabs == null ? new ArrayList<>() : subTabs;
        this.f14689d = mcid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f(final int position) {
        a aVar = new a(YWChannelBooksParams.class, YWBookChannel.class, this.f14686a, position);
        ((YWChannelBooksParams) aVar.k()).setPage(0);
        ((YWChannelBooksParams) aVar.k()).setPageSize(8);
        ((YWChannelBooksParams) aVar.k()).setMcid(Integer.valueOf(this.f14689d));
        ((YWChannelBooksParams) aVar.k()).setExt(com.martian.libmars.d.h.F().n0(this.f14687b.get(position).getExt()));
        aVar.j();
    }

    public String c(int position) {
        return position >= this.f14687b.size() ? "" : this.f14687b.get(position).getExt();
    }

    public List<TYBookItem> d(int position) {
        if (position < getCount()) {
            return this.f14687b.get(position).getBookList();
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public String e(int position) {
        return position >= this.f14687b.size() ? "" : this.f14687b.get(position).getTitle();
    }

    public void g(LoadingTip tip) {
        this.f14688c = tip;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f14687b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object object) {
        return -2;
    }

    public void h(b.d.c.b.c errorResult, boolean isError) {
        LoadingTip loadingTip = this.f14688c;
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
        this.f14688c.setTips(errorResult.d());
    }

    public void i() {
        LoadingTip loadingTip = this.f14688c;
        if (loadingTip == null) {
            return;
        }
        loadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = View.inflate(this.f14686a, R.layout.bookmall_category_item, null);
        com.martian.mibook.e.g1 a2 = com.martian.mibook.e.g1.a(inflate);
        a2.f11990c.setVisibility(0);
        a2.f11992e.setVisibility(8);
        List<TYBookItem> d2 = d(position);
        if (d2 != null && !d2.isEmpty()) {
            i();
            if (d2.size() < 4) {
                a2.f11991d.setPadding(0, 0, 0, 0);
                a2.f11991d.setOrientation(1);
                com.martian.mibook.j.y2.j(this.f14686a, a2.f11991d, d(position), false);
            } else {
                com.martian.mibook.j.y2.f(this.f14686a, d2, a2.f11991d, false, 0, true);
            }
            if (d2.size() > 4) {
                com.martian.mibook.j.y2.f(this.f14686a, d2, a2.f11989b, false, 4, true);
            }
            container.addView(inflate);
        }
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void j(int position) {
        if (position >= getCount() || !this.f14687b.get(position).getBookList().isEmpty()) {
            return;
        }
        f(position);
    }
}
