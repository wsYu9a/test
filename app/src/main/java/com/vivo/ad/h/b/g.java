package com.vivo.ad.h.b;

import android.graphics.Bitmap;
import android.view.View;
import java.io.File;

/* loaded from: classes4.dex */
public interface g {
    void a(String str, String str2, String str3);

    void a(byte[] bArr, File file);

    View getView();

    void setBg(Bitmap bitmap);

    void setBgClick(com.vivo.mobilead.unified.base.callback.i iVar);

    void setBtnClick(com.vivo.ad.view.k kVar);

    void setBtnText(com.vivo.ad.model.b bVar);

    void setCloseClick(View.OnClickListener onClickListener);

    void setDesc(String str);

    void setDownloadCount(String str);

    void setIcon(Bitmap bitmap);

    void setScore(float f2);

    void setScoreState(boolean z);

    void setTitle(String str);
}
