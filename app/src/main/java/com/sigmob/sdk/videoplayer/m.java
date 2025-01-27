package com.sigmob.sdk.videoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* loaded from: classes4.dex */
public class m extends TextureView {

    /* renamed from: c */
    public static final String f20832c = "ResizeTextureView";

    /* renamed from: a */
    public int f20833a;

    /* renamed from: b */
    public int f20834b;

    public m(Context context) {
        super(context);
        this.f20833a = 0;
        this.f20834b = 0;
    }

    public void a(int i10, int i11) {
        if (this.f20833a == i10 && this.f20834b == i11) {
            return;
        }
        this.f20833a = i10;
        this.f20834b = i11;
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:
    
        if (r2 > r12) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fe, code lost:
    
        r2 = (r12 * r4) / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
    
        if (r2 > r12) goto L123;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoplayer.m.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        if (f10 != getRotation()) {
            super.setRotation(f10);
            requestLayout();
        }
    }

    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20833a = 0;
        this.f20834b = 0;
    }
}
