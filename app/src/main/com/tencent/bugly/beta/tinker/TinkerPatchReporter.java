package com.tencent.bugly.beta.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class TinkerPatchReporter extends DefaultPatchReporter {
    private final PatchReporter userPatchReporter;

    public TinkerPatchReporter(Context context) {
        super(context);
        this.userPatchReporter = TinkerManager.userPatchReporter;
    }

    public void onPatchDexOptFail(File file, List<File> list, Throwable th2) {
        super.onPatchDexOptFail(file, list, th2);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchDexOptFail(file, list, th2);
        } else {
            TinkerReport.onApplyDexOptFail(th2);
        }
    }

    public void onPatchException(File file, Throwable th2) {
        super.onPatchException(file, th2);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchException(file, th2);
        } else {
            TinkerReport.onApplyCrash(th2);
        }
    }

    public void onPatchInfoCorrupted(File file, String str, String str2) {
        super.onPatchInfoCorrupted(file, str, str2);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchInfoCorrupted(file, str, str2);
        } else {
            TinkerReport.onApplyInfoCorrupted();
        }
    }

    public void onPatchPackageCheckFail(File file, int i10) {
        super.onPatchPackageCheckFail(file, i10);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchPackageCheckFail(file, i10);
        } else {
            TinkerReport.onApplyPackageCheckFail(i10);
        }
    }

    public void onPatchResult(File file, boolean z10, long j10) {
        super.onPatchResult(file, z10, j10);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchResult(file, z10, j10);
        } else {
            TinkerReport.onApplied(j10, z10);
            UpgradePatchRetry.getInstance(((DefaultPatchReporter) this).context).onPatchServiceResult();
        }
    }

    public void onPatchServiceStart(Intent intent) {
        super.onPatchServiceStart(intent);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchServiceStart(intent);
        } else {
            TinkerReport.onApplyPatchServiceStart();
            UpgradePatchRetry.getInstance(((DefaultPatchReporter) this).context).onPatchServiceStart(intent);
        }
    }

    public void onPatchTypeExtractFail(File file, File file2, String str, int i10) {
        super.onPatchTypeExtractFail(file, file2, str, i10);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchTypeExtractFail(file, file2, str, i10);
        } else {
            TinkerReport.onApplyExtractFail(i10);
        }
    }

    public void onPatchVersionCheckFail(File file, SharePatchInfo sharePatchInfo, String str) {
        super.onPatchVersionCheckFail(file, sharePatchInfo, str);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchVersionCheckFail(file, sharePatchInfo, str);
        } else {
            TinkerReport.onApplyVersionCheckFail();
        }
    }
}
