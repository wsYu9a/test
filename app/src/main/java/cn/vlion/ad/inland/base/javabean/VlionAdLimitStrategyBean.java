package cn.vlion.ad.inland.base.javabean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class VlionAdLimitStrategyBean {
    private String ShowId = "";
    private List<AdLimitStrategyBean> adLimitStrategyBean;

    public static class AdLimitStrategyBean implements Serializable {
        private String adSrcName = "";
        private int count = 0;
        private long lasttime = 0;

        public String getAdSrcName() {
            return this.adSrcName;
        }

        public int getCount() {
            return this.count;
        }

        public long getLasttime() {
            return this.lasttime;
        }

        public void setAdSrcName(String str) {
            this.adSrcName = str;
        }

        public void setCount(int i10) {
            this.count = i10;
        }

        public void setLasttime(long j10) {
            this.lasttime = j10;
        }
    }

    public List<AdLimitStrategyBean> getAdLimitStrategyBean() {
        return this.adLimitStrategyBean;
    }

    public String getShowId() {
        return this.ShowId;
    }

    public void setAdLimitStrategyBean(List<AdLimitStrategyBean> list) {
        this.adLimitStrategyBean = list;
    }

    public void setShowId(String str) {
        this.ShowId = str;
    }
}
