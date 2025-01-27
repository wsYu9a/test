package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.c.a;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.u;

/* loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int a0 = R.style.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] b0 = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    @NonNull
    private final ElevationOverlayProvider c0;

    @Nullable
    private ColorStateList d0;

    @Nullable
    private ColorStateList e0;
    private boolean f0;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.d0 == null) {
            int d2 = a.d(this, R.attr.colorSurface);
            int d3 = a.d(this, R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.c0.l()) {
                dimension += u.h(this);
            }
            int e2 = this.c0.e(d2, dimension);
            int[][] iArr = b0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = a.g(d2, d3, 1.0f);
            iArr2[1] = e2;
            iArr2[2] = a.g(d2, d3, 0.38f);
            iArr2[3] = e2;
            this.d0 = new ColorStateList(iArr, iArr2);
        }
        return this.d0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.e0 == null) {
            int[][] iArr = b0;
            int[] iArr2 = new int[iArr.length];
            int d2 = a.d(this, R.attr.colorSurface);
            int d3 = a.d(this, R.attr.colorControlActivated);
            int d4 = a.d(this, R.attr.colorOnSurface);
            iArr2[0] = a.g(d2, d3, 0.54f);
            iArr2[1] = a.g(d2, d4, 0.32f);
            iArr2[2] = a.g(d2, d3, 0.12f);
            iArr2[3] = a.g(d2, d4, 0.12f);
            this.e0 = new ColorStateList(iArr, iArr2);
        }
        return this.e0;
    }

    public boolean k() {
        return this.f0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f0 = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.switchmaterial.SwitchMaterial.a0
            android.content.Context r7 = com.google.android.material.theme.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            com.google.android.material.elevation.ElevationOverlayProvider r7 = new com.google.android.material.elevation.ElevationOverlayProvider
            r7.<init>(r0)
            r6.c0 = r7
            int[] r2 = com.google.android.material.R.styleable.SwitchMaterial
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.n.j(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.SwitchMaterial_useMaterialThemeColors
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f0 = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.switchmaterial.SwitchMaterial.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
