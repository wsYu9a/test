package cn.vlion.ad.inland.kd;

import android.view.View;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.shu.priory.download.DownLoadDialogCallback;

/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ DownLoadDialogCallback f3908a;

    /* renamed from: b */
    public final /* synthetic */ j f3909b;

    public f(j jVar, DownLoadDialogCallback downLoadDialogCallback) {
        this.f3909b = jVar;
        this.f3908a = downLoadDialogCallback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            DownLoadDialogCallback downLoadDialogCallback = this.f3908a;
            if (downLoadDialogCallback != null) {
                downLoadDialogCallback.onConfirmDownload();
            }
            this.f3909b.dismiss();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
