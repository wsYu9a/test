package ya;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.data.AdSlots;
import com.martian.ads.data.AdsPosition;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.BookMallTab;
import com.martian.mibook.data.BookRankTab;
import com.martian.mibook.data.MiOptions;
import com.martian.mibook.lib.account.request.AdSlotsParams;
import com.martian.mibook.lib.model.data.abs.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class i1 {

    /* renamed from: g */
    public static final String f33235g = "mioptions_json_file";

    /* renamed from: h */
    public static final String f33236h = "ad_slots_json_file";

    /* renamed from: i */
    public static final String f33237i = "ads_position_json_file";

    /* renamed from: j */
    public static final String f33238j = "ads_position_seed";

    /* renamed from: k */
    public static final String f33239k = "ads_position_count";

    /* renamed from: a */
    public MiOptions f33240a;

    /* renamed from: b */
    public AdsPosition f33241b;

    /* renamed from: c */
    public final Context f33242c;

    /* renamed from: e */
    public long f33244e;

    /* renamed from: d */
    public boolean f33243d = true;

    /* renamed from: f */
    public int f33245f = -1;

    public class a extends TypeToken<List<AdSlots>> {
        public a() {
        }
    }

    public interface c {
        void a();
    }

    public i1(Context context) {
        this.f33242c = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(c cVar) {
        b bVar = new b(AdSlotsParams.class, AdsPosition.class, this.f33242c, cVar);
        if (this.f33243d) {
            ac.a.T(this.f33242c, "冷启");
            v();
        } else {
            ac.a.T(this.f33242c, "热启");
        }
        ((AdSlotsParams) bVar.k()).setSeed(Long.valueOf(this.f33244e));
        ((AdSlotsParams) bVar.k()).setCount(Integer.valueOf(this.f33245f));
        ((AdSlotsParams) bVar.k()).setCp(Boolean.valueOf(MiConfigSingleton.b2().C2()));
        bVar.n(4);
        bVar.j();
    }

    public void e() {
        new zd.a().start();
    }

    public AdSlots f(String str) {
        try {
            o();
            for (AdSlots adSlots : this.f33241b.getPositions()) {
                if (str.equalsIgnoreCase(adSlots.getPid())) {
                    return adSlots;
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String g(String str, String str2) {
        AdsPosition adsPosition = this.f33241b;
        if (adsPosition != null) {
            String str3 = adsPosition.getUnionAppids().get(str);
            return ba.l.q(str3) ? str2 : str3;
        }
        ac.a.T(this.f33242c, "配置失败：" + str);
        return str2;
    }

    public List<BookMallTab> h() {
        List<BookMallTab> bookMallTabs = l().getBookMallTabs();
        boolean W2 = MiConfigSingleton.b2().W2();
        if (bookMallTabs != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= bookMallTabs.size()) {
                    break;
                }
                BookMallTab bookMallTab = bookMallTabs.get(i10);
                if (bookMallTab != null && !TextUtils.isEmpty(bookMallTab.getName()) && (("推荐".equalsIgnoreCase(bookMallTab.getName()) || bookMallTab.getName().contains("推荐")) && !W2)) {
                    bookMallTabs.remove(bookMallTab);
                    break;
                }
                i10++;
            }
        }
        if (bookMallTabs == null || bookMallTabs.isEmpty() || bookMallTabs.size() < 2) {
            bookMallTabs = new ArrayList<>();
            if (W2) {
                bookMallTabs.add(new BookMallTab().setTid(0).setName(ConfigSingleton.D().s("推荐")));
            }
            bookMallTabs.add(new BookMallTab().setTid(n(true)).setName(m(1)));
            bookMallTabs.add(new BookMallTab().setTid(n(false)).setName(m(2)));
            bookMallTabs.add(new BookMallTab().setTid(5).setName(ConfigSingleton.D().s(Book.STATUS_FINISHED)));
            bookMallTabs.add(new BookMallTab().setTid(6).setName(ConfigSingleton.D().s("新书")));
            bookMallTabs.add(new BookMallTab().setTid(4).setName(ConfigSingleton.D().s("阅文好书")));
        } else {
            try {
                boolean z10 = true;
                for (BookMallTab bookMallTab2 : bookMallTabs) {
                    int tid = bookMallTab2.getTid();
                    if (tid == 1 || tid == 2) {
                        if (z10 && tid == MiConfigSingleton.b2().p()) {
                            break;
                        }
                        bookMallTab2.setTid(n(z10)).setName(m(z10 ? 1 : 2));
                        if (!z10) {
                            break;
                        }
                        z10 = false;
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return bookMallTabs;
    }

    public List<BookRankTab> i() {
        List<BookRankTab> bookRankTabs = l().getBookRankTabs();
        if (bookRankTabs != null && !bookRankTabs.isEmpty() && bookRankTabs.size() >= 2) {
            return bookRankTabs;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BookRankTab().setBtype(100).setName(ConfigSingleton.D().s("推荐榜")));
        arrayList.add(new BookRankTab().setBtype(110).setName(ConfigSingleton.D().s("完本榜")));
        arrayList.add(new BookRankTab().setBtype(10).setName(ConfigSingleton.D().s("人气榜")));
        arrayList.add(new BookRankTab().setBtype(20).setName(ConfigSingleton.D().s("收藏榜")));
        arrayList.add(new BookRankTab().setBtype(30).setName(ConfigSingleton.D().s("阅读榜")));
        arrayList.add(new BookRankTab().setBtype(80).setName(ConfigSingleton.D().s("热搜榜")));
        return arrayList;
    }

    public String j() {
        AdsPosition adsPosition = this.f33241b;
        return adsPosition == null ? "" : adsPosition.getGromoreAppid();
    }

    public int k() {
        if (this.f33245f == -1) {
            this.f33245f = ba.j.f(this.f33242c, f33239k, 1);
        }
        return this.f33245f;
    }

    public synchronized MiOptions l() {
        try {
            if (this.f33240a == null) {
                p();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f33240a;
    }

    public String m(int i10) {
        return i10 == 2 ? MiConfigSingleton.b2().p() == 2 ? "男生" : "女生" : MiConfigSingleton.b2().p() == 2 ? "女生" : "男生";
    }

    public int n(boolean z10) {
        return z10 ? MiConfigSingleton.b2().p() : MiConfigSingleton.b2().k2();
    }

    public void o() {
        List list;
        if (this.f33241b != null) {
            return;
        }
        try {
            String B = ba.g.B(this.f33242c, f33237i);
            if (!ba.l.q(B)) {
                this.f33241b = (AdsPosition) GsonUtils.b().fromJson(B, AdsPosition.class);
            }
        } catch (JsonSyntaxException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
            try {
                String B2 = ba.g.B(this.f33242c, f33236h);
                if (!ba.l.q(B2) && (list = (List) GsonUtils.b().fromJson(B2, new a().getType())) != null) {
                    AdsPosition adsPosition = new AdsPosition();
                    this.f33241b = adsPosition;
                    adsPosition.getPositions().addAll(list);
                }
            } catch (JsonSyntaxException | IOException e12) {
                e12.printStackTrace();
            }
        }
        if (this.f33241b == null) {
            this.f33241b = new AdsPosition();
        }
    }

    public final void p() {
        try {
            String B = ba.g.B(this.f33242c, f33235g);
            if (!ba.l.q(B)) {
                this.f33240a = (MiOptions) GsonUtils.b().fromJson(B, MiOptions.class);
            }
        } catch (JsonSyntaxException | IOException e10) {
            e10.printStackTrace();
        }
        if (this.f33240a == null) {
            this.f33240a = new MiOptions();
        }
    }

    public final void q(c cVar) {
        o();
        this.f33243d = false;
        cVar.a();
    }

    public void r(AdsPosition adsPosition) {
        this.f33241b = adsPosition;
        try {
            ba.g.F(this.f33242c, f33237i, GsonUtils.b().toJson(adsPosition));
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void s(String str) {
        try {
            MiOptions miOptions = (MiOptions) GsonUtils.b().fromJson(str, MiOptions.class);
            t(miOptions);
            ba.g.F(this.f33242c, f33235g, str);
            b8.e.s().G(miOptions.getEnableX1Sdk());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void t(MiOptions miOptions) {
        this.f33240a = miOptions;
        MiConfigSingleton.b2().q3(miOptions);
    }

    public boolean u() {
        return g(AdConfig.UnionType.CSJ, e0.f33164n).equalsIgnoreCase(j());
    }

    public final void v() {
        long j10 = this.f33244e;
        if (j10 == 0) {
            j10 = ba.j.h(this.f33242c, f33238j, -1L);
        }
        this.f33244e = System.currentTimeMillis();
        if (j10 <= 0 || !ConfigSingleton.D().K0(j10)) {
            this.f33245f = 1;
        } else {
            this.f33245f = k() + 1;
        }
        ba.j.n(this.f33242c, f33238j, this.f33244e);
        ba.j.m(this.f33242c, f33239k, this.f33245f);
        ac.a.T(this.f33242c, "冷启-" + this.f33245f);
    }

    public class b extends jb.e<AdSlotsParams, AdsPosition> {

        /* renamed from: h */
        public final /* synthetic */ c f33247h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Class cls, Class cls2, Context context, c cVar) {
            super(cls, cls2, context);
            this.f33247h = cVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            i1.this.q(this.f33247h);
        }

        @Override // y8.h, y8.b
        public void onUDDataReceived(List<AdsPosition> list) {
            if (list != null && !list.isEmpty() && list.get(0) != null) {
                AdsPosition adsPosition = list.get(0);
                if ((i1.this.f33241b == null && i1.this.f33243d) || (i1.this.f33241b != null && adsPosition.getUnionAppids().equals(i1.this.f33241b.getUnionAppids()))) {
                    i1.this.r(adsPosition);
                }
            }
            i1.this.q(this.f33247h);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
