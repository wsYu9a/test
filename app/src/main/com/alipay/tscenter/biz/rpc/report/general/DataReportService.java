package com.alipay.tscenter.biz.rpc.report.general;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* loaded from: classes.dex */
public interface DataReportService {
    @OperationType("alipay.security.device.data.report")
    DataReportResult reportData(DataReportRequest dataReportRequest);
}
