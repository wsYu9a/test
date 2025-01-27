package com.wbl.ad.yzz.network.bean.request;

import androidx.core.os.EnvironmentCompat;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class SceneReq implements Serializable {
    public String scene;

    public SceneReq() {
    }

    public String getScene() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11112, this, null);
    }

    public void setScene(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11111, this, str);
    }

    public SceneReq(String str) {
        if (str == null) {
            this.scene = EnvironmentCompat.MEDIA_UNKNOWN;
        } else {
            this.scene = str;
        }
    }
}
