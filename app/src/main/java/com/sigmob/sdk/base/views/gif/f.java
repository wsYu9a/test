package com.sigmob.sdk.base.views.gif;

import android.graphics.Bitmap;
import com.sigmob.sdk.base.views.gif.a;

/* loaded from: classes4.dex */
public class f implements a.InterfaceC0580a {
    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0580a
    public void a(byte[] bArr) {
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0580a
    public byte[] b(int i10) {
        return new byte[i10];
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0580a
    public void a(int[] iArr) {
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0580a
    public Bitmap a(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0580a
    public int[] a(int i10) {
        return new int[i10];
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0580a
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }
}
