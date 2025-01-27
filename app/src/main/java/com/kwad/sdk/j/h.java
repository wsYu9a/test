package com.kwad.sdk.j;

import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class h extends Resources {
    private final Resources aDE;

    public h(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aDE = resources2;
    }

    private static boolean ak(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    private static boolean cu(int i2) {
        StringBuilder sb = new StringBuilder("0x");
        sb.append(Integer.toHexString(i2));
        return !sb.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getAnimation(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getAnimation(i2) : super.getAnimation(i2);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getBoolean(i2) : super.getBoolean(i2);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getColor(i2) : super.getColor(i2);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 23)
    public final int getColor(int i2, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getColor(i2, theme) : super.getColor(i2, theme);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getDimension(i2) : super.getDimension(i2);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getDimensionPixelOffset(i2) : super.getDimensionPixelOffset(i2);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getDimensionPixelSize(i2) : super.getDimensionPixelSize(i2);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getDrawable(i2) : super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i2, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getDrawable(i2) : super.getDrawable(i2, theme);
    }

    @Override // android.content.res.Resources
    @Nullable
    @Deprecated
    public final Drawable getDrawableForDensity(int i2, int i3) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getDrawableForDensity(i2, i3) : super.getDrawableForDensity(i2, i3);
    }

    @Override // android.content.res.Resources
    @Nullable
    @RequiresApi(api = 21)
    public final Drawable getDrawableForDensity(int i2, int i3, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getDrawableForDensity(i2, i3, theme) : super.getDrawableForDensity(i2, i3, theme);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 29)
    public final float getFloat(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getFloat(i2) : super.getFloat(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 26)
    public final Typeface getFont(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getFont(i2) : super.getFont(i2);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i2, int i3, int i4) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getFraction(i2, i3, i4) : super.getFraction(i2, i3, i4);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        return ak(str, str3) ? this.aDE.getIdentifier(str, str2, str3) : super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final int[] getIntArray(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getIntArray(i2) : super.getIntArray(i2);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getInteger(i2) : super.getInteger(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getLayout(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getLayout(i2) : super.getLayout(i2);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getMovie(i2) : super.getMovie(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i2, int i3) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getQuantityString(i2, i3) : super.getQuantityString(i2, i3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i2, int i3, Object... objArr) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getQuantityString(i2, i3, objArr) : super.getQuantityString(i2, i3, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getQuantityText(int i2, int i3) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getQuantityText(i2, i3) : super.getQuantityText(i2, i3);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getResourceEntryName(i2) : super.getResourceEntryName(i2);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getResourceName(i2) : super.getResourceName(i2);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getResourcePackageName(i2) : super.getResourcePackageName(i2);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getResourceTypeName(i2) : super.getResourceTypeName(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getString(i2) : super.getString(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i2, Object... objArr) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getString(i2, objArr) : super.getString(i2, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String[] getStringArray(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getStringArray(i2) : super.getStringArray(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getText(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getText(i2) : super.getText(i2);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i2, CharSequence charSequence) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getText(i2, charSequence) : super.getText(i2, charSequence);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence[] getTextArray(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getTextArray(i2) : super.getTextArray(i2);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i2, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i2));
        if (cu(i2)) {
            this.aDE.getValue(i2, typedValue, z);
        } else {
            super.getValue(i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z) {
        int identifier = getIdentifier(str, "string", null);
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (cu(identifier)) {
            this.aDE.getValue(str, typedValue, z);
        } else {
            super.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i2));
        if (cu(i2)) {
            this.aDE.getValueForDensity(i2, i3, typedValue, z);
        } else {
            super.getValueForDensity(i2, i3, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getXml(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.getXml(i2) : super.getXml(i2);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final TypedArray obtainTypedArray(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.obtainTypedArray(i2) : super.obtainTypedArray(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.openRawResource(i2) : super.openRawResource(i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i2, TypedValue typedValue) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.openRawResource(i2, typedValue) : super.openRawResource(i2, typedValue);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i2) {
        com.kwad.sdk.core.d.b.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i2));
        return cu(i2) ? this.aDE.openRawResourceFd(i2) : super.openRawResourceFd(i2);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }
}
