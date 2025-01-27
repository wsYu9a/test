package b.d.e.a.j;

import com.martian.ttbook.sdk.client.AdBiddingLossReason;

/* loaded from: classes4.dex */
public class h {

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f4548a;

        static {
            int[] iArr = new int[AdBiddingLossReason.values().length];
            f4548a = iArr;
            try {
                iArr[AdBiddingLossReason.LOW_PRICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4548a[AdBiddingLossReason.TIME_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4548a[AdBiddingLossReason.NO_AD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4548a[AdBiddingLossReason.AD_DATA_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4548a[AdBiddingLossReason.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int a(AdBiddingLossReason adBiddingLossReason) {
        int i2 = a.f4548a[adBiddingLossReason.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 != 3) {
            return i2 != 4 ? 10001 : 4;
        }
        return 3;
    }
}
