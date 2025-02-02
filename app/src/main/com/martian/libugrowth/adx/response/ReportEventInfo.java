package com.martian.libugrowth.adx.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ReportEventInfo {
    private ReportEvent reportEvent;
    private long reportTime;
    private List<String> urls;

    public ReportEvent getReportEvent() {
        return this.reportEvent;
    }

    public long getReportTime() {
        return this.reportTime;
    }

    public List<String> getUrls() {
        if (this.urls == null) {
            this.urls = new ArrayList();
        }
        return this.urls;
    }

    public ReportEventInfo setReportEvent(ReportEvent reportEvent) {
        this.reportEvent = reportEvent;
        return this;
    }

    public ReportEventInfo setReportTime(long j10) {
        this.reportTime = j10;
        return this;
    }

    public ReportEventInfo setUrls(List<String> list) {
        this.urls = list;
        return this;
    }
}
