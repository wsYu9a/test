package cn.vlion.ad.inland.kd;

import android.view.View;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.shu.priory.download.DownLoadDialogCallback;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ DownLoadDialogCallback f3912a;

    public i(DownLoadDialogCallback downLoadDialogCallback) {
        this.f3912a = downLoadDialogCallback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            DownLoadDialogCallback downLoadDialogCallback = this.f3912a;
            if (downLoadDialogCallback != null) {
                downLoadDialogCallback.onOpenDetail(2);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
