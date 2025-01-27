package com.kwad.components.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6),
    FEED_TYPE_TEXT_NEW(7),
    FEED_TYPE_CONTENT_11(11),
    FEED_TYPE_CONTENT_12(12),
    FEED_TYPE_CONTENT_13(13);

    private int type;

    FeedType(int i2) {
        this.type = i2;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        int aW = a.aW(d.cb(adTemplate));
        int i2 = adTemplate.type;
        FeedType feedType = FEED_TYPE_TEXT_ABOVE_GROUP;
        if (i2 > feedType.type) {
            return true;
        }
        FeedType fromInt = fromInt(i2);
        if (aW != 1) {
            if (aW == 2) {
                return (fromInt == FEED_TYPE_UNKNOWN || fromInt == feedType) ? false : true;
            }
            if (aW == 3) {
                return fromInt != FEED_TYPE_UNKNOWN;
            }
            if (aW != 8) {
                return false;
            }
        }
        return fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW || fromInt == FEED_TYPE_TEXT_IMMERSE;
    }

    @NonNull
    public static FeedType fromInt(int i2) {
        for (FeedType feedType : values()) {
            if (feedType.type == i2) {
                return feedType;
            }
        }
        return isH5Type(i2) ? FEED_TYPE_TEXT_NEW : FEED_TYPE_UNKNOWN;
    }

    private static boolean isH5Type(int i2) {
        return i2 == 7 || i2 == 8 || i2 == 14 || i2 == 15 || i2 == 16 || i2 == 17 || i2 == 18 || i2 == 19 || i2 >= 2000;
    }

    public final int getType() {
        return this.type;
    }
}
