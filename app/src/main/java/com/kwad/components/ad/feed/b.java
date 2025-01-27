package com.kwad.components.ad.feed;

import android.content.Context;
import com.kwad.components.ad.feed.a.g;
import com.kwad.components.ad.feed.a.h;
import com.kwad.components.ad.feed.a.i;
import com.kwad.components.ad.feed.a.j;
import com.kwad.components.ad.feed.a.k;
import com.kwad.components.ad.feed.a.l;
import com.kwad.components.model.FeedType;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: com.kwad.components.ad.feed.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] dU;

        static {
            int[] iArr = new int[FeedType.values().length];
            dU = iArr;
            try {
                iArr[FeedType.FEED_TYPE_TEXT_IMMERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                dU[FeedType.FEED_TYPE_TEXT_ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                dU[FeedType.FEED_TYPE_TEXT_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                dU[FeedType.FEED_TYPE_TEXT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                dU[FeedType.FEED_TYPE_TEXT_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                dU[FeedType.FEED_TYPE_TEXT_ABOVE_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                dU[FeedType.FEED_TYPE_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static com.kwad.components.core.widget.b a(Context context, FeedType feedType) {
        switch (AnonymousClass1.dU[feedType.ordinal()]) {
            case 1:
                return new j(context);
            case 2:
                return new com.kwad.components.ad.feed.a.f(context);
            case 3:
                return new h(context);
            case 4:
                return new k(context);
            case 5:
                return new l(context);
            case 6:
            case 7:
                com.kwad.sdk.core.d.b.e("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                return null;
            default:
                return null;
        }
    }

    public static com.kwad.components.core.widget.b a(Context context, FeedType feedType, int i2) {
        if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
            return (i2 == 1 || i2 == 8) ? new g(context) : new com.kwad.components.ad.feed.a.f(context);
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return a(context, feedType);
            }
            if (i2 == 3) {
                return b(context, feedType);
            }
            if (i2 != 8) {
                com.kwad.sdk.core.d.b.e("KSFeedFactory", "getNewFeedView materialType is unknown");
                return null;
            }
        }
        return c(context, feedType);
    }

    private static com.kwad.components.core.widget.b b(Context context, FeedType feedType) {
        switch (AnonymousClass1.dU[feedType.ordinal()]) {
            case 1:
                return new j(context);
            case 2:
                return new com.kwad.components.ad.feed.a.f(context);
            case 3:
                return new h(context);
            case 4:
                return new k(context);
            case 5:
                return new l(context);
            case 6:
                return new h(context);
            case 7:
                com.kwad.sdk.core.d.b.e("KSFeedFactory", "getVideoView type is unknown" + feedType);
                return null;
            default:
                return null;
        }
    }

    private static com.kwad.components.core.widget.b c(Context context, FeedType feedType) {
        int i2 = AnonymousClass1.dU[feedType.ordinal()];
        if (i2 == 2) {
            return new g(context);
        }
        if (i2 == 3) {
            return new i(context);
        }
        com.kwad.sdk.core.d.b.e("KSFeedFactory", "getVideoView type is unknown:" + feedType);
        return null;
    }
}
