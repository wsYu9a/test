package com.martian.mibook.application;

import android.content.Context;
import com.martian.ads.data.AdSlots;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.data.BookMallTab;
import com.martian.mibook.data.BookRankTab;
import com.martian.mibook.data.MiOptions;
import com.martian.mibook.lib.account.request.AdSlotsParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class p0 {

    /* renamed from: a */
    private static final String f11566a = "splash";

    /* renamed from: b */
    private static final String f11567b = "readingFlow";

    /* renamed from: c */
    private static final String f11568c = "readingBanner";

    /* renamed from: d */
    private static final String f11569d = "mioptions_json_file";

    /* renamed from: e */
    private static final String f11570e = "ad_slots_json_file";

    /* renamed from: f */
    private MiOptions f11571f;

    /* renamed from: g */
    private final Context f11572g;

    /* renamed from: h */
    private List<AdSlots> f11573h;

    /* loaded from: classes3.dex */
    class a extends com.google.gson.b.a<List<AdSlots>> {
        a() {
        }
    }

    /* loaded from: classes3.dex */
    class b extends com.martian.mibook.lib.account.d.g<AdSlotsParams, AdSlots> {
        b(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(final List<AdSlots> adSlotsList) {
            p0.this.k(adSlotsList);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    p0(Context context) {
        this.f11572g = context;
        j();
        i();
    }

    private void b() {
        new b(AdSlotsParams.class, AdSlots.class, this.f11572g).j();
    }

    public void a() {
        new com.martian.mibook.i.a().start();
        b();
    }

    public AdSlots c(String pid) {
        List<AdSlots> list = this.f11573h;
        if (list != null && !list.isEmpty()) {
            try {
                for (AdSlots adSlots : this.f11573h) {
                    if (pid.equalsIgnoreCase(adSlots.getPid())) {
                        return adSlots;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public List<BookMallTab> d() {
        List<BookMallTab> bookMallTabs = f().getBookMallTabs();
        if (bookMallTabs == null || bookMallTabs.isEmpty() || bookMallTabs.size() < 2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BookMallTab().setTid(0).setName("推荐"));
            arrayList.add(new BookMallTab().setTid(h(1)).setName(g(1)));
            arrayList.add(new BookMallTab().setTid(h(2)).setName(g(2)));
            arrayList.add(new BookMallTab().setTid(3).setName("文学"));
            return arrayList;
        }
        try {
            boolean z = true;
            for (BookMallTab bookMallTab : bookMallTabs) {
                int tid = bookMallTab.getTid();
                if (tid == 1 || tid == 2) {
                    if (z && tid == MiConfigSingleton.V3().k()) {
                        return bookMallTabs;
                    }
                    bookMallTab.setTid(h(z ? 1 : 2)).setName(g(z ? 1 : 2));
                    if (!z) {
                        return bookMallTabs;
                    }
                    z = false;
                }
            }
            return bookMallTabs;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bookMallTabs;
        }
    }

    public List<BookRankTab> e() {
        List<BookRankTab> bookRankTabs = f().getBookRankTabs();
        if (bookRankTabs != null && !bookRankTabs.isEmpty() && bookRankTabs.size() >= 2) {
            return bookRankTabs;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BookRankTab().setBtype(100).setName(com.martian.libmars.d.h.F().n("推荐榜")));
        arrayList.add(new BookRankTab().setBtype(110).setName(com.martian.libmars.d.h.F().n("完本榜")));
        arrayList.add(new BookRankTab().setBtype(10).setName(com.martian.libmars.d.h.F().n("人气榜")));
        arrayList.add(new BookRankTab().setBtype(20).setName(com.martian.libmars.d.h.F().n("收藏榜")));
        arrayList.add(new BookRankTab().setBtype(30).setName(com.martian.libmars.d.h.F().n("阅读榜")));
        arrayList.add(new BookRankTab().setBtype(80).setName(com.martian.libmars.d.h.F().n("热搜榜")));
        return arrayList;
    }

    public synchronized MiOptions f() {
        if (this.f11571f == null) {
            j();
        }
        return this.f11571f;
    }

    public String g(int position) {
        return position == 2 ? MiConfigSingleton.V3().k() == 2 ? "男生" : "女生" : MiConfigSingleton.V3().k() == 2 ? "女生" : "男生";
    }

    public int h(int position) {
        return position == 2 ? MiConfigSingleton.V3().k() == 2 ? 1 : 2 : MiConfigSingleton.V3().k() == 2 ? 2 : 1;
    }

    public void i() {
        try {
            String B = com.martian.libsupport.e.B(this.f11572g, f11570e);
            if (!com.martian.libsupport.k.p(B)) {
                this.f11573h = (List) GsonUtils.b().fromJson(B, new a().getType());
            }
        } catch (IOException unused) {
        }
        if (this.f11573h == null) {
            this.f11573h = new ArrayList();
        }
    }

    public void j() {
        this.f11571f = new MiOptions();
        try {
            String B = com.martian.libsupport.e.B(this.f11572g, f11569d);
            if (com.martian.libsupport.k.p(B)) {
                return;
            }
            this.f11571f = (MiOptions) GsonUtils.b().fromJson(B, MiOptions.class);
        } catch (IOException unused) {
        }
    }

    public void k(List<AdSlots> adSlots) {
        if (adSlots == null || adSlots.isEmpty()) {
            return;
        }
        this.f11573h = adSlots;
        try {
            com.martian.libsupport.e.E(this.f11572g, f11570e, GsonUtils.b().toJson(adSlots));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void l(String json) {
        try {
            com.martian.libsupport.e.E(this.f11572g, f11569d, json);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void m(MiOptions options) {
        this.f11571f = options;
        MiConfigSingleton.V3().A7(-1);
    }
}
