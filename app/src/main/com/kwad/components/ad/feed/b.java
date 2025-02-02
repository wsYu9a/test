package com.kwad.components.ad.feed;

import android.content.Context;
import com.kwad.components.ad.feed.b.g;
import com.kwad.components.ad.feed.b.h;
import com.kwad.components.ad.feed.b.i;
import com.kwad.components.ad.feed.b.j;
import com.kwad.components.ad.feed.b.k;
import com.kwad.components.ad.feed.b.l;
import com.kwad.components.model.FeedType;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: com.kwad.components.ad.feed.b$1 */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: ff */
        static final /* synthetic */ int[] f11458ff;

        static {
            int[] iArr = new int[FeedType.values().length];
            f11458ff = iArr;
            try {
                iArr[FeedType.FEED_TYPE_TEXT_IMMERSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11458ff[FeedType.FEED_TYPE_TEXT_ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11458ff[FeedType.FEED_TYPE_TEXT_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11458ff[FeedType.FEED_TYPE_TEXT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11458ff[FeedType.FEED_TYPE_TEXT_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11458ff[FeedType.FEED_TYPE_TEXT_ABOVE_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11458ff[FeedType.FEED_TYPE_UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static com.kwad.components.core.widget.b a(Context context, FeedType feedType, int i10) {
        if (feedType == FeedType.FEED_TYPE_TEXT_NEW) {
            return (i10 == 1 || i10 == 8) ? new g(context) : new com.kwad.components.ad.feed.b.f(context);
        }
        if (i10 != 1) {
            if (i10 == 2) {
                return a(context, feedType);
            }
            if (i10 == 3) {
                return b(context, feedType);
            }
            if (i10 != 8) {
                com.kwad.sdk.core.d.c.e("KSFeedFactory", "getNewFeedView materialType is unknown");
                return null;
            }
        }
        return c(context, feedType);
    }

    private static com.kwad.components.core.widget.b b(Context context, FeedType feedType) {
        switch (AnonymousClass1.f11458ff[feedType.ordinal()]) {
            case 1:
                return new j(context);
            case 2:
                return new com.kwad.components.ad.feed.b.f(context);
            case 3:
                return new h(context);
            case 4:
                return new k(context);
            case 5:
                return new l(context);
            case 6:
                return new h(context);
            case 7:
                com.kwad.sdk.core.d.c.e("KSFeedFactory", "getVideoView type is unknown" + feedType);
                return null;
            default:
                return null;
        }
    }

    private static com.kwad.components.core.widget.b c(Context context, FeedType feedType) {
        int i10 = AnonymousClass1.f11458ff[feedType.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return new g(context);
        }
        if (i10 == 3) {
            return new i(context);
        }
        com.kwad.sdk.core.d.c.e("KSFeedFactory", "getVideoView type is unknown:" + feedType);
        return null;
    }

    private static com.kwad.components.core.widget.b a(Context context, FeedType feedType) {
        switch (AnonymousClass1.f11458ff[feedType.ordinal()]) {
            case 1:
                return new j(context);
            case 2:
                return new com.kwad.components.ad.feed.b.f(context);
            case 3:
                return new h(context);
            case 4:
                return new k(context);
            case 5:
                return new l(context);
            case 6:
            case 7:
                com.kwad.sdk.core.d.c.e("KSFeedFactory", "getSingleImageView type is unknown:" + feedType);
                return null;
            default:
                return null;
        }
    }
}
