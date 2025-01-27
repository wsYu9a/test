package com.vivo.mobilead.unified.nativead;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.IBidding;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.base.view.VivoNativeAdContainer;

/* loaded from: classes4.dex */
public class VivoNativeExpressView extends VivoNativeAdContainer implements IBidding {
    private com.vivo.mobilead.unified.base.view.s.a baseNativeExpressView;
    protected MediaListener mediaListener;

    protected VivoNativeExpressView(@NonNull Context context, com.vivo.mobilead.unified.base.view.s.a aVar) {
        super(context);
        this.baseNativeExpressView = aVar;
        if (aVar != null) {
            addView(aVar, new FrameLayout.LayoutParams(aVar.getLayoutParams()));
        }
    }

    public void destroy() {
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public int getPrice() {
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        if (aVar == null) {
            return -3;
        }
        return aVar.getPrice();
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public String getPriceLevel() {
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        return aVar == null ? "" : aVar.getPriceLevel();
    }

    public void pause() {
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void resume() {
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendLossNotification(int i2, int i3) {
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        if (aVar != null) {
            aVar.a(i2, i3);
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendWinNotification(int i2) {
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setMediaListener(MediaListener mediaListener) {
        this.mediaListener = mediaListener;
        com.vivo.mobilead.unified.base.view.s.a aVar = this.baseNativeExpressView;
        if (aVar != null) {
            aVar.setMediaListener(mediaListener);
        }
    }
}
