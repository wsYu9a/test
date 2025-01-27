package com.alimm.tanx.core.common;

import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class AdTask implements Runnable {
    private Runnable tanxc_do;
    private onErrorListener tanxc_for;
    private String tanxc_if;

    public interface onErrorListener {
        void onError(String str);
    }

    public AdTask(Runnable runnable, String str) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.tanxc_do.run();
        } catch (Exception e10) {
            e10.printStackTrace();
            onErrorListener onerrorlistener = this.tanxc_for;
            if (onerrorlistener != null) {
                onerrorlistener.onError(e10.getMessage());
            }
            LogUtils.e("AdTask", e10, "AdTask");
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "AdTask", LogUtils.getStackTraceMessage(e10), "AdTask");
        }
    }

    public AdTask(Runnable runnable, String str, onErrorListener onerrorlistener) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
        this.tanxc_for = onerrorlistener;
    }
}
