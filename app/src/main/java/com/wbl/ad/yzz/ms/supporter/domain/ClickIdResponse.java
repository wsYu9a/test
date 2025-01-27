package com.wbl.ad.yzz.ms.supporter.domain;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class ClickIdResponse implements Serializable {
    private ClickIdInfo data;
    private Integer ret;

    public class ClickIdInfo implements Serializable {
        private String clickid;
        private String dstlink;

        public ClickIdInfo() {
        }

        public String getClickid() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11384, this, null);
        }

        public String getDstlink() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11383, this, null);
        }

        public void setClickid(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11378, this, str);
        }

        public void setDstlink(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11377, this, str);
        }
    }

    public ClickIdInfo getData() {
        return (ClickIdInfo) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11380, this, null);
    }

    public Integer getRet() {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11379, this, null);
    }

    public void setData(ClickIdInfo clickIdInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11342, this, clickIdInfo);
    }

    public void setRet(Integer num) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11341, this, num);
    }
}
