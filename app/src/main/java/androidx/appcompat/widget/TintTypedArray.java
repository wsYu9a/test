package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintTypedArray {

    /* renamed from: a */
    private final Context f979a;

    /* renamed from: b */
    private final TypedArray f980b;

    /* renamed from: c */
    private TypedValue f981c;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f979a = context;
        this.f980b = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i2, boolean z) {
        return this.f980b.getBoolean(i2, z);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return this.f980b.getChangingConfigurations();
    }

    public int getColor(int i2, int i3) {
        return this.f980b.getColor(i2, i3);
    }

    public ColorStateList getColorStateList(int i2) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.f980b.hasValue(i2) || (resourceId = this.f980b.getResourceId(i2, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.f979a, resourceId)) == null) ? this.f980b.getColorStateList(i2) : colorStateList;
    }

    public float getDimension(int i2, float f2) {
        return this.f980b.getDimension(i2, f2);
    }

    public int getDimensionPixelOffset(int i2, int i3) {
        return this.f980b.getDimensionPixelOffset(i2, i3);
    }

    public int getDimensionPixelSize(int i2, int i3) {
        return this.f980b.getDimensionPixelSize(i2, i3);
    }

    public Drawable getDrawable(int i2) {
        int resourceId;
        return (!this.f980b.hasValue(i2) || (resourceId = this.f980b.getResourceId(i2, 0)) == 0) ? this.f980b.getDrawable(i2) : AppCompatResources.getDrawable(this.f979a, resourceId);
    }

    public Drawable getDrawableIfKnown(int i2) {
        int resourceId;
        if (!this.f980b.hasValue(i2) || (resourceId = this.f980b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().b(this.f979a, resourceId, true);
    }

    public float getFloat(int i2, float f2) {
        return this.f980b.getFloat(i2, f2);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i2, int i3, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f980b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f981c == null) {
            this.f981c = new TypedValue();
        }
        return ResourcesCompat.getFont(this.f979a, resourceId, this.f981c, i3, fontCallback);
    }

    public float getFraction(int i2, int i3, int i4, float f2) {
        return this.f980b.getFraction(i2, i3, i4, f2);
    }

    public int getIndex(int i2) {
        return this.f980b.getIndex(i2);
    }

    public int getIndexCount() {
        return this.f980b.getIndexCount();
    }

    public int getInt(int i2, int i3) {
        return this.f980b.getInt(i2, i3);
    }

    public int getInteger(int i2, int i3) {
        return this.f980b.getInteger(i2, i3);
    }

    public int getLayoutDimension(int i2, String str) {
        return this.f980b.getLayoutDimension(i2, str);
    }

    public String getNonResourceString(int i2) {
        return this.f980b.getNonResourceString(i2);
    }

    public String getPositionDescription() {
        return this.f980b.getPositionDescription();
    }

    public int getResourceId(int i2, int i3) {
        return this.f980b.getResourceId(i2, i3);
    }

    public Resources getResources() {
        return this.f980b.getResources();
    }

    public String getString(int i2) {
        return this.f980b.getString(i2);
    }

    public CharSequence getText(int i2) {
        return this.f980b.getText(i2);
    }

    public CharSequence[] getTextArray(int i2) {
        return this.f980b.getTextArray(i2);
    }

    public int getType(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f980b.getType(i2);
        }
        if (this.f981c == null) {
            this.f981c = new TypedValue();
        }
        this.f980b.getValue(i2, this.f981c);
        return this.f981c.type;
    }

    public boolean getValue(int i2, TypedValue typedValue) {
        return this.f980b.getValue(i2, typedValue);
    }

    public boolean hasValue(int i2) {
        return this.f980b.hasValue(i2);
    }

    public int length() {
        return this.f980b.length();
    }

    public TypedValue peekValue(int i2) {
        return this.f980b.peekValue(i2);
    }

    public void recycle() {
        this.f980b.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public int getLayoutDimension(int i2, int i3) {
        return this.f980b.getLayoutDimension(i2, i3);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i2, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i2, iArr));
    }
}
