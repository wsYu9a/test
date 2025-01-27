package com.martian.mibook.mvvm.yuewen.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.BookRankTab;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.YWRankBooksParams;
import com.martian.mibook.mvvm.yuewen.repository.BookRankRepository;
import com.umeng.analytics.pro.bt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002FGB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0004J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR.\u0010+\u001a\u0004\u0018\u00010\u00142\b\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00107\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\"\u0004\b6\u00102R$\u0010:\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010.\u001a\u0004\b8\u00100\"\u0004\b9\u00102R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010=R\u001f\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;8\u0006¢\u0006\f\n\u0004\b\u0012\u0010=\u001a\u0004\b?\u0010@R\"\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020B\u0018\u00010\t0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010=R%\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020B\u0018\u00010\t0;8\u0006¢\u0006\f\n\u0004\b\u001d\u0010=\u001a\u0004\bD\u0010@¨\u0006H"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/yuewen/repository/BookRankRepository;", "<init>", "()V", bt.aJ, "()Lcom/martian/mibook/mvvm/yuewen/repository/BookRankRepository;", "", "n", "", "Lcom/martian/mibook/data/BookRankTab;", "o", "()Ljava/util/List;", "Lcom/martian/mibook/mvvm/net/request/YWRankBooksParams;", "rankBooksParams", "", "showLoading", "isLoadMore", "p", "(Lcom/martian/mibook/mvvm/net/request/YWRankBooksParams;ZZ)V", "", "h", "I", "s", "()I", "C", "(I)V", "cType", "i", t.f11211k, "B", "btype", "j", IAdInterListener.AdReqParam.WIDTH, ExifInterface.LONGITUDE_EAST, "rType", "value", "k", "Ljava/lang/Integer;", "q", "()Ljava/lang/Integer;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Integer;)V", "brtype", "", t.f11204d, "Ljava/lang/String;", bt.aO, "()Ljava/lang/String;", "D", "(Ljava/lang/String;)V", "category", "m", "x", "F", "source", "y", "G", TTDownloadField.TT_TAG, "Landroidx/lifecycle/MutableLiveData;", "Lcom/martian/mibook/lib/yuewen/response/YWFreeType;", "Landroidx/lifecycle/MutableLiveData;", "_mCategoryListLiveData", "u", "()Landroidx/lifecycle/MutableLiveData;", "mCategoryListLiveData", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$b;", "_mRankBookListLiveData", "v", "mRankBookListLiveData", "a", "b", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookRankViewModel extends BaseViewModel<BookRankRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    public int cType = 1;

    /* renamed from: i, reason: from kotlin metadata */
    public int btype;

    /* renamed from: j, reason: from kotlin metadata */
    public int rType;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public Integer brtype;

    /* renamed from: l */
    @l
    public String category;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public String source;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public String com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final MutableLiveData<YWFreeType> _mCategoryListLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final MutableLiveData<YWFreeType> mCategoryListLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<b>> _mRankBookListLiveData;

    /* renamed from: r */
    @k
    public final MutableLiveData<List<b>> mRankBookListLiveData;

    public static final class a {

        /* renamed from: a */
        @k
        public static final a f15752a = new a();

        /* renamed from: b */
        public static final int f15753b = 100;

        /* renamed from: c */
        public static final int f15754c = 110;

        /* renamed from: d */
        public static final int f15755d = 10;

        /* renamed from: e */
        public static final int f15756e = 20;

        /* renamed from: f */
        public static final int f15757f = 30;

        /* renamed from: g */
        public static final int f15758g = 80;

        /* renamed from: h */
        public static final int f15759h = 0;

        /* renamed from: i */
        public static final int f15760i = 30;

        /* renamed from: j */
        public static final int f15761j = 50;
    }

    public BookRankViewModel() {
        MutableLiveData<YWFreeType> mutableLiveData = new MutableLiveData<>();
        this._mCategoryListLiveData = mutableLiveData;
        this.mCategoryListLiveData = mutableLiveData;
        MutableLiveData<List<b>> mutableLiveData2 = new MutableLiveData<>();
        this._mRankBookListLiveData = mutableLiveData2;
        this.mRankBookListLiveData = mutableLiveData2;
    }

    public final void A(@l Integer num) {
        Unit unit;
        this.brtype = num;
        if (num != null) {
            int intValue = num.intValue();
            this.btype = intValue / 10;
            this.rType = intValue % 10;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.btype = 0;
            this.rType = 0;
        }
    }

    public final void B(int i10) {
        this.btype = i10;
    }

    public final void C(int i10) {
        this.cType = i10;
    }

    public final void D(@l String str) {
        this.category = str;
    }

    public final void E(int i10) {
        this.rType = i10;
    }

    public final void F(@l String str) {
        this.source = str;
    }

    public final void G(@l String str) {
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String = str;
    }

    public final void n() {
        j(new BookRankViewModel$getAllCategories$1(this, null), new BookRankViewModel$getAllCategories$2(this, null), true);
    }

    @k
    public final List<BookRankTab> o() {
        List<BookRankTab> i10 = MiConfigSingleton.b2().f2().i();
        Intrinsics.checkNotNullExpressionValue(i10, "getBookRankTabs(...)");
        return i10;
    }

    public final void p(@k YWRankBooksParams rankBooksParams, boolean showLoading, boolean isLoadMore) {
        Intrinsics.checkNotNullParameter(rankBooksParams, "rankBooksParams");
        j(new BookRankViewModel$getBookRankList$1(rankBooksParams, this, null), new BookRankViewModel$getBookRankList$2(isLoadMore, this, null), showLoading);
    }

    @l
    /* renamed from: q, reason: from getter */
    public final Integer getBrtype() {
        return this.brtype;
    }

    /* renamed from: r, reason: from getter */
    public final int getBtype() {
        return this.btype;
    }

    /* renamed from: s, reason: from getter */
    public final int getCType() {
        return this.cType;
    }

    @l
    /* renamed from: t, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @k
    public final MutableLiveData<YWFreeType> u() {
        return this.mCategoryListLiveData;
    }

    @k
    public final MutableLiveData<List<b>> v() {
        return this.mRankBookListLiveData;
    }

    /* renamed from: w, reason: from getter */
    public final int getRType() {
        return this.rType;
    }

    @l
    /* renamed from: x, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @l
    /* renamed from: y, reason: from getter */
    public final String getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String() {
        return this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: z */
    public BookRankRepository i() {
        return new BookRankRepository();
    }

    public static final class b {

        /* renamed from: a */
        @l
        public final TYBookItem f15762a;

        /* renamed from: b */
        @l
        public final Integer f15763b;

        /* renamed from: c */
        @l
        public Integer f15764c;

        /* renamed from: d */
        @l
        public String f15765d;

        public b(@l TYBookItem tYBookItem, @l Integer num, @l Integer num2, @l String str) {
            this.f15762a = tYBookItem;
            this.f15763b = num;
            this.f15764c = num2;
            this.f15765d = str;
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == 10) {
                    this.f15765d = ExtKt.c("根据实时阅读人气排行");
                    return;
                }
                if (intValue == 20) {
                    this.f15765d = ExtKt.c("根据实时收藏次数排行");
                    return;
                }
                if (intValue == 30) {
                    this.f15765d = ExtKt.c("根据实时阅读人数排行");
                    return;
                }
                if (intValue == 80) {
                    this.f15765d = ExtKt.c("根据实时搜索热度排行");
                    return;
                }
                if (intValue == 100) {
                    this.f15765d = ExtKt.c("根据实时阅读热度排行");
                } else {
                    if (intValue != 110) {
                        return;
                    }
                    this.f15765d = ExtKt.c("根据完结阅读热度排行");
                    this.f15764c = null;
                }
            }
        }

        public static /* synthetic */ b f(b bVar, TYBookItem tYBookItem, Integer num, Integer num2, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                tYBookItem = bVar.f15762a;
            }
            if ((i10 & 2) != 0) {
                num = bVar.f15763b;
            }
            if ((i10 & 4) != 0) {
                num2 = bVar.f15764c;
            }
            if ((i10 & 8) != 0) {
                str = bVar.f15765d;
            }
            return bVar.e(tYBookItem, num, num2, str);
        }

        @l
        public final TYBookItem a() {
            return this.f15762a;
        }

        @l
        public final Integer b() {
            return this.f15763b;
        }

        @l
        public final Integer c() {
            return this.f15764c;
        }

        @l
        public final String d() {
            return this.f15765d;
        }

        @k
        public final b e(@l TYBookItem tYBookItem, @l Integer num, @l Integer num2, @l String str) {
            return new b(tYBookItem, num, num2, str);
        }

        public boolean equals(@l Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f15762a, bVar.f15762a) && Intrinsics.areEqual(this.f15763b, bVar.f15763b) && Intrinsics.areEqual(this.f15764c, bVar.f15764c) && Intrinsics.areEqual(this.f15765d, bVar.f15765d);
        }

        @l
        public final Integer g() {
            return this.f15763b;
        }

        @l
        public final TYBookItem h() {
            return this.f15762a;
        }

        public int hashCode() {
            TYBookItem tYBookItem = this.f15762a;
            int hashCode = (tYBookItem == null ? 0 : tYBookItem.hashCode()) * 31;
            Integer num = this.f15763b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f15764c;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.f15765d;
            return hashCode3 + (str != null ? str.hashCode() : 0);
        }

        @l
        public final Integer i() {
            return this.f15764c;
        }

        @l
        public final String j() {
            return this.f15765d;
        }

        public final void k(@l Integer num) {
            this.f15764c = num;
        }

        public final void l(@l String str) {
            this.f15765d = str;
        }

        @k
        public String toString() {
            return "ItemData(bookItem=" + this.f15762a + ", bType=" + this.f15763b + ", rankStatus=" + this.f15764c + ", title=" + this.f15765d + ")";
        }

        public /* synthetic */ b(TYBookItem tYBookItem, Integer num, Integer num2, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(tYBookItem, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : num2, (i10 & 8) != 0 ? null : str);
        }
    }
}
