package com.tencent.bugly.beta.tinker;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

/* loaded from: classes4.dex */
public class TinkerLoadReporter extends DefaultLoadReporter {
    private static final String TAG = "Tinker.TinkerLoadReporter";
    private final LoadReporter userLoadReporter;

    /* renamed from: com.tencent.bugly.beta.tinker.TinkerLoadReporter$1 */
    public class AnonymousClass1 implements MessageQueue.IdleHandler {
        public AnonymousClass1() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (!UpgradePatchRetry.getInstance(((DefaultLoadReporter) TinkerLoadReporter.this).context).onPatchRetryLoad()) {
                return false;
            }
            TinkerReport.onReportRetryPatch();
            return false;
        }
    }

    public TinkerLoadReporter(Context context) {
        super(context);
        this.userLoadReporter = TinkerManager.userLoadReporter;
    }

    public void onLoadException(Throwable th2, int i10) {
        super.onLoadException(th2, i10);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadException(th2, i10);
        } else {
            TinkerReport.onLoadException(th2, i10);
        }
    }

    public void onLoadFileMd5Mismatch(File file, int i10) {
        super.onLoadFileMd5Mismatch(file, i10);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadFileMd5Mismatch(file, i10);
        } else {
            TinkerReport.onLoadFileMisMatch(i10);
        }
    }

    public void onLoadFileNotFound(File file, int i10, boolean z10) {
        File file2;
        super.onLoadFileNotFound(file, i10, z10);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadFileNotFound(file, i10, z10);
            return;
        }
        TinkerLog.i(TAG, "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[]{file.getAbsolutePath(), Integer.valueOf(i10), Boolean.valueOf(z10)});
        if (i10 == 4) {
            Tinker with = Tinker.with(((DefaultLoadReporter) this).context);
            if (with.isMainProcess() && (file2 = with.getTinkerLoadResultIfPresent().patchVersionFile) != null) {
                if (UpgradePatchRetry.getInstance(((DefaultLoadReporter) this).context).onPatchListenerCheck(SharePatchFileUtil.getMD5(file2))) {
                    TinkerLog.i(TAG, "try to repair oat file on patch process", new Object[0]);
                    TinkerInstaller.onReceiveUpgradePatch(((DefaultLoadReporter) this).context, file2.getAbsolutePath());
                } else {
                    TinkerLog.i(TAG, "repair retry exceed must max time, just clean", new Object[0]);
                    checkAndCleanPatch();
                }
            }
        } else {
            checkAndCleanPatch();
        }
        TinkerReport.onLoadFileNotFound(i10);
    }

    public void onLoadInterpret(int i10, Throwable th2) {
        super.onLoadInterpret(i10, th2);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadInterpret(i10, th2);
        } else {
            TinkerReport.onLoadInterpretReport(i10, th2);
        }
    }

    public void onLoadPackageCheckFail(File file, int i10) {
        super.onLoadPackageCheckFail(file, i10);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPackageCheckFail(file, i10);
        } else {
            TinkerReport.onLoadPackageCheckFail(i10);
        }
    }

    public void onLoadPatchInfoCorrupted(String str, String str2, File file) {
        super.onLoadPatchInfoCorrupted(str, str2, file);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchInfoCorrupted(str, str2, file);
        } else {
            TinkerReport.onLoadInfoCorrupted();
        }
    }

    public void onLoadPatchListenerReceiveFail(File file, int i10) {
        super.onLoadPatchListenerReceiveFail(file, i10);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchListenerReceiveFail(file, i10);
        } else {
            TinkerReport.onTryApplyFail(i10);
        }
    }

    public void onLoadPatchVersionChanged(String str, String str2, File file, String str3) {
        super.onLoadPatchVersionChanged(str, str2, file, str3);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchVersionChanged(str, str2, file, str3);
        }
    }

    public void onLoadResult(File file, int i10, long j10) {
        super.onLoadResult(file, i10, j10);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadResult(file, i10, j10);
            return;
        }
        if (i10 == 0) {
            TinkerReport.onLoaded(j10);
        }
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.bugly.beta.tinker.TinkerLoadReporter.1
            public AnonymousClass1() {
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (!UpgradePatchRetry.getInstance(((DefaultLoadReporter) TinkerLoadReporter.this).context).onPatchRetryLoad()) {
                    return false;
                }
                TinkerReport.onReportRetryPatch();
                return false;
            }
        });
    }
}
