package com.vivo.ic.dm.datareport;

import com.vivo.ic.dm.DownloadInfo;
import java.util.HashMap;

/* loaded from: classes4.dex */
public interface DataReportListener {
    void reportDownloadContinue(String str, HashMap<String, String> hashMap);

    void reportDownloadDelete(String str, HashMap<String, String> hashMap);

    void reportDownloadFailed(String str, DownloadInfo downloadInfo, HashMap<String, String> hashMap);

    void reportDownloadInterrupt(String str, DownloadInfo downloadInfo, HashMap<String, String> hashMap);

    void reportDownloadPause(String str, HashMap<String, String> hashMap);

    void reportDownloadSpeed(String str, DownloadInfo downloadInfo, HashMap<String, String> hashMap);

    void reportDownloadSuccess(String str, DownloadInfo downloadInfo, HashMap<String, String> hashMap);

    void reportNetWorkEvent(String str, HashMap<String, String> hashMap);

    void reportNewDownloadTask(String str, DownloadInfo downloadInfo, HashMap<String, String> hashMap);
}
