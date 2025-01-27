package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class f5 extends ImageView implements d {

    /* renamed from: a */
    public b f2799a;

    /* renamed from: b */
    public int f2800b;

    /* renamed from: c */
    public int f2801c;

    public f5(Context context) {
        super(context, null);
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            if (this.f2799a != null) {
                this.f2799a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogVlion.e("VlionImageView onAttachedToWindow:");
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogVlion.e("VlionImageView onDetachedFromWindow:");
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        LogVlion.e("VlionImageView onVisibilityAggregated:isVisible=" + z10);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        String str;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            str = "VlionImageView onVisibilityChanged:VISIBLE";
        } else if (8 == i10) {
            str = "VlionImageView onVisibilityChanged:GONE";
        } else if (4 == i10) {
            str = "VlionImageView onVisibilityChanged:INVISIBLE";
        } else {
            try {
                str = "VlionImageView onVisibilityChanged:" + i10;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return;
            }
        }
        LogVlion.e(str);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        StringBuilder a10 = l1.a("VlionImageView onWindowFocusChanged:");
        a10.append(z10 ? "获取焦点" : "失去焦点");
        a10.append(" getWidth=");
        a10.append(getWidth());
        a10.append(" getHeight=");
        a10.append(getHeight());
        LogVlion.e(a10.toString());
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        LogVlion.e("VlionImageView onWindowVisibilityChanged:visibility=" + i10);
    }
}
