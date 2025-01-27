package sh;

import com.google.gson.annotations.SerializedName;
import com.martian.ads.ad.AdConfig;
import com.sntech.ads.AdCode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    @SerializedName("name")
    @l
    public String f30665a;

    /* renamed from: b */
    @SerializedName("innerAdCodeList")
    @l
    public List<C0787a> f30666b;

    /* renamed from: c */
    @SerializedName("levelsTotal")
    public int f30667c;

    /* renamed from: d */
    @SerializedName("changed")
    public boolean f30668d = true;

    /* renamed from: sh.a$a */
    public static final class C0787a implements Comparable<C0787a> {

        /* renamed from: b */
        @SerializedName("adCode")
        @k
        public AdCode f30669b;

        /* renamed from: c */
        @SerializedName("id")
        @l
        public String f30670c;

        /* renamed from: d */
        @SerializedName("platform")
        @l
        public String f30671d;

        /* renamed from: e */
        @SerializedName("price")
        public double f30672e;

        /* renamed from: f */
        @SerializedName("level")
        public int f30673f;

        public C0787a(@k AdCode adCode) {
            Intrinsics.checkNotNullParameter(adCode, "adCode");
            this.f30669b = adCode;
            this.f30670c = adCode.getId();
            this.f30671d = this.f30669b.getPlatform();
            this.f30672e = this.f30669b.getPrice();
        }

        public final int a(C0787a c0787a) {
            String str = c0787a.f30671d;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 66021) {
                    if (hashCode != 67034) {
                        if (hashCode != 87957) {
                            if (hashCode == 1921014029 && str.equals("KUAISHOU")) {
                                return 3;
                            }
                        } else if (str.equals("YLH")) {
                            return 2;
                        }
                    } else if (str.equals(AdConfig.UnionType.CSJ)) {
                        return 4;
                    }
                } else if (str.equals(AdConfig.UnionType.BQT)) {
                    return 1;
                }
            }
            return 0;
        }

        @Override // java.lang.Comparable
        public final int compareTo(C0787a c0787a) {
            C0787a innerAdCode = c0787a;
            Intrinsics.checkNotNullParameter(innerAdCode, "innerAdCode");
            double d10 = this.f30672e;
            double d11 = innerAdCode.f30672e;
            return d10 == d11 ? a(this) - a(innerAdCode) : d10 > d11 ? 1 : -1;
        }
    }
}
