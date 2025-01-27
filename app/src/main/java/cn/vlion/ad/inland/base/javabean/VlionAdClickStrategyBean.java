package cn.vlion.ad.inland.base.javabean;

import androidx.annotation.NonNull;
import cn.vlion.ad.inland.base.l1;

/* loaded from: classes.dex */
public class VlionAdClickStrategyBean {
    private String adx_tagid = "";
    private int count = 0;
    private long clickLasttime = 0;

    public String getAdx_tagid() {
        return this.adx_tagid;
    }

    public long getClickLasttime() {
        return this.clickLasttime;
    }

    public int getCount() {
        return this.count;
    }

    public void setAdx_tagid(String str) {
        this.adx_tagid = str;
    }

    public void setClickLasttime(long j10) {
        this.clickLasttime = j10;
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    @NonNull
    public String toString() {
        StringBuilder a10 = l1.a(" 点击adx_tagid =");
        a10.append(this.adx_tagid);
        a10.append("  点击count =");
        a10.append(this.count);
        a10.append(" 最后点击时间 =");
        a10.append(this.clickLasttime);
        return a10.toString();
    }
}
