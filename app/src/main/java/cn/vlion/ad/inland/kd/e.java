package cn.vlion.ad.inland.kd;

import android.view.View;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.shu.priory.download.DownLoadDialogCallback;

/* loaded from: classes.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ DownLoadDialogCallback f3906a;

    /* renamed from: b */
    public final /* synthetic */ j f3907b;

    public e(j jVar, DownLoadDialogCallback downLoadDialogCallback) {
        this.f3907b = jVar;
        this.f3906a = downLoadDialogCallback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            DownLoadDialogCallback downLoadDialogCallback = this.f3906a;
            if (downLoadDialogCallback != null) {
                downLoadDialogCallback.onDismiss();
            }
            this.f3907b.dismiss();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
