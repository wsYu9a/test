package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\f\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0014\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0015\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u001a*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a/\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u00022\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001e0 H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"checkAttribute", "", "Landroid/content/res/TypedArray;", "index", "", "getBooleanOrThrow", "", "getColorOrThrow", "getColorStateListOrThrow", "Landroid/content/res/ColorStateList;", "getDimensionOrThrow", "", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "getDrawableOrThrow", "Landroid/graphics/drawable/Drawable;", "getFloatOrThrow", "getFontOrThrow", "Landroid/graphics/Typeface;", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "getStringOrThrow", "", "getTextArrayOrThrow", "", "", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "getTextOrThrow", "use", "R", e.f19025e, "Lkotlin/Function1;", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i10) {
        if (!typedArray.hasValue(i10)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getBoolean(i10, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getColor(i10, 0);
    }

    @k
    public static final ColorStateList getColorStateListOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        ColorStateList colorStateList = typedArray.getColorStateList(i10);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimension(i10, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelOffset(i10, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelSize(i10, 0);
    }

    @k
    public static final Drawable getDrawableOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        Drawable drawable = typedArray.getDrawable(i10);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getFloat(i10, 0.0f);
    }

    @k
    @RequiresApi(26)
    public static final Typeface getFontOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return TypedArrayApi26ImplKt.getFont(typedArray, i10);
    }

    public static final int getIntOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getInt(i10, 0);
    }

    public static final int getIntegerOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getInteger(i10, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getResourceId(i10, 0);
    }

    @k
    public static final String getStringOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        String string = typedArray.getString(i10);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @k
    public static final CharSequence[] getTextArrayOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        CharSequence[] textArray = typedArray.getTextArray(i10);
        Intrinsics.checkNotNullExpressionValue(textArray, "getTextArray(index)");
        return textArray;
    }

    @k
    public static final CharSequence getTextOrThrow(@k TypedArray typedArray, @StyleableRes int i10) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        CharSequence text = typedArray.getText(i10);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@k TypedArray typedArray, @k Function1<? super TypedArray, ? extends R> block) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        R invoke = block.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
