package cn.vlion.ad.inland.ku;

import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import com.kwad.sdk.api.model.AdnName;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: cn.vlion.ad.inland.ku.a$a */
    public static /* synthetic */ class C0040a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f3975a;

        static {
            int[] iArr = new int[VlionBidderSource.values().length];
            f3975a = iArr;
            try {
                iArr[VlionBidderSource.ChuanShanJia.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3975a[VlionBidderSource.YouLiangHui.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3975a[VlionBidderSource.BaiDu.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String a(VlionBidderSource vlionBidderSource) {
        if (vlionBidderSource == null) {
            return AdnName.OTHER;
        }
        int i10 = C0040a.f3975a[vlionBidderSource.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? AdnName.OTHER : "baidu" : AdnName.GUANGDIANTONG : AdnName.CHUANSHANJIA;
    }
}
