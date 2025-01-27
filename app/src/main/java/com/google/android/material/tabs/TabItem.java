package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: a */
    public final CharSequence f7804a;

    /* renamed from: b */
    public final Drawable f7805b;

    /* renamed from: c */
    public final int f7806c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TabItem);
        this.f7804a = obtainStyledAttributes.getText(R.styleable.TabItem_android_text);
        this.f7805b = obtainStyledAttributes.getDrawable(R.styleable.TabItem_android_icon);
        this.f7806c = obtainStyledAttributes.getResourceId(R.styleable.TabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
