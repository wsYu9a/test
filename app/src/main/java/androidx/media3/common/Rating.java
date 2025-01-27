package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Rating;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

/* loaded from: classes.dex */
public abstract class Rating implements Bundleable {
    static final int RATING_TYPE_HEART = 0;
    static final int RATING_TYPE_PERCENTAGE = 1;
    static final int RATING_TYPE_STAR = 2;
    static final int RATING_TYPE_THUMB = 3;
    static final int RATING_TYPE_UNSET = -1;
    static final float RATING_UNSET = -1.0f;
    static final String FIELD_RATING_TYPE = Util.intToStringMaxRadix(0);

    @UnstableApi
    public static final Bundleable.Creator<Rating> CREATOR = new Bundleable.Creator() { // from class: m0.e0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            Rating fromBundle;
            fromBundle = Rating.fromBundle(bundle);
            return fromBundle;
        }
    };

    public static Rating fromBundle(Bundle bundle) {
        int i10 = bundle.getInt(FIELD_RATING_TYPE, -1);
        if (i10 == 0) {
            return HeartRating.CREATOR.fromBundle(bundle);
        }
        if (i10 == 1) {
            return PercentageRating.CREATOR.fromBundle(bundle);
        }
        if (i10 == 2) {
            return StarRating.CREATOR.fromBundle(bundle);
        }
        if (i10 == 3) {
            return ThumbRating.CREATOR.fromBundle(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i10);
    }

    public abstract boolean isRated();
}
