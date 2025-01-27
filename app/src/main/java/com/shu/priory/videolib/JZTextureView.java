package com.shu.priory.videolib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* loaded from: classes3.dex */
public class JZTextureView extends TextureView {

    /* renamed from: a */
    public int f17350a;

    /* renamed from: b */
    public int f17351b;

    public JZTextureView(Context context) {
        super(context);
        this.f17350a = 0;
        this.f17351b = 0;
    }

    public void a(int i10, int i11) {
        if (this.f17350a == i10 && this.f17351b == i11) {
            return;
        }
        this.f17350a = i10;
        this.f17351b = i11;
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ce, code lost:
    
        if (r6 > r11) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d0, code lost:
    
        r6 = (r11 * r3) / r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e2, code lost:
    
        if (r6 > r11) goto L186;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.videolib.JZTextureView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        if (f10 != getRotation()) {
            super.setRotation(f10);
            requestLayout();
        }
    }

    public JZTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17350a = 0;
        this.f17351b = 0;
    }
}
