package com.alimm.tanx.core.log;

import com.alimm.tanx.core.ad.bean.BaseBean;
import java.text.SimpleDateFormat;
import java.util.Objects;

/* loaded from: classes.dex */
public class LogItemBean extends BaseBean {
    public String level;
    public String message;
    public String tag;
    public String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(Long.valueOf(System.currentTimeMillis()));

    public LogItemBean() {
    }

    public boolean equals(LogItemBean logItemBean) {
        return hashCode() == logItemBean.hashCode();
    }

    public int hashCode() {
        return Objects.hash(this.tag, this.level, this.message);
    }

    public String toString() {
        return "LogItemBean{tag='" + this.tag + "', level='" + this.level + "', message='" + this.message + "', time=" + this.time + "} " + super.toString();
    }

    public LogItemBean(String str, String str2, String str3) {
        this.tag = str;
        this.level = str2;
        this.message = str3;
    }
}
