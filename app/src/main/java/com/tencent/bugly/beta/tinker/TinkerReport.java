package com.tencent.bugly.beta.tinker;

import com.tencent.connect.common.Constants;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

/* loaded from: classes4.dex */
public class TinkerReport {
    public static final int KEY_APPLIED = 5;
    public static final int KEY_APPLIED_DEXOPT_EXIST = 122;
    public static final int KEY_APPLIED_DEXOPT_FORMAT = 123;
    public static final int KEY_APPLIED_DEXOPT_OTHER = 121;
    public static final int KEY_APPLIED_DEX_EXTRACT = 182;
    public static final int KEY_APPLIED_EXCEPTION = 120;
    public static final int KEY_APPLIED_FAIL_COST_10S_LESS = 206;
    public static final int KEY_APPLIED_FAIL_COST_30S_LESS = 207;
    public static final int KEY_APPLIED_FAIL_COST_5S_LESS = 205;
    public static final int KEY_APPLIED_FAIL_COST_60S_LESS = 208;
    public static final int KEY_APPLIED_FAIL_COST_OTHER = 209;
    public static final int KEY_APPLIED_INFO_CORRUPTED = 124;
    public static final int KEY_APPLIED_LIB_EXTRACT = 183;
    public static final int KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 153;
    public static final int KEY_APPLIED_PACKAGE_CHECK_DEX_META = 151;
    public static final int KEY_APPLIED_PACKAGE_CHECK_LIB_META = 152;
    public static final int KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND = 155;
    public static final int KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 154;
    public static final int KEY_APPLIED_PACKAGE_CHECK_RES_META = 157;
    public static final int KEY_APPLIED_PACKAGE_CHECK_SIGNATURE = 150;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 158;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 156;
    public static final int KEY_APPLIED_PATCH_FILE_EXTRACT = 181;
    public static final int KEY_APPLIED_RESOURCE_EXTRACT = 184;
    public static final int KEY_APPLIED_START = 4;
    public static final int KEY_APPLIED_SUCC_COST_10S_LESS = 201;
    public static final int KEY_APPLIED_SUCC_COST_30S_LESS = 202;
    public static final int KEY_APPLIED_SUCC_COST_5S_LESS = 200;
    public static final int KEY_APPLIED_SUCC_COST_60S_LESS = 203;
    public static final int KEY_APPLIED_SUCC_COST_OTHER = 204;
    public static final int KEY_APPLIED_UPGRADE = 100;
    public static final int KEY_APPLIED_UPGRADE_FAIL = 101;
    public static final int KEY_APPLIED_VERSION_CHECK = 180;
    public static final int KEY_APPLY_WITH_RETRY = 10;
    public static final int KEY_CRASH_CAUSE_XPOSED_ART = 9;
    public static final int KEY_CRASH_CAUSE_XPOSED_DALVIK = 8;
    public static final int KEY_CRASH_FAST_PROTECT = 7;
    public static final int KEY_DOWNLOAD = 1;
    public static final int KEY_LOADED = 6;
    public static final int KEY_LOADED_EXCEPTION_DEX = 252;
    public static final int KEY_LOADED_EXCEPTION_DEX_CHECK = 253;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE = 254;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE_CHECK = 255;
    public static final int KEY_LOADED_INFO_CORRUPTED = 309;
    public static final int KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR = 450;
    public static final int KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR = 451;
    public static final int KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK = 452;
    public static final int KEY_LOADED_MISMATCH_DEX = 300;
    public static final int KEY_LOADED_MISMATCH_LIB = 301;
    public static final int KEY_LOADED_MISMATCH_RESOURCE = 302;
    public static final int KEY_LOADED_MISSING_DEX = 303;
    public static final int KEY_LOADED_MISSING_DEX_OPT = 307;
    public static final int KEY_LOADED_MISSING_LIB = 304;
    public static final int KEY_LOADED_MISSING_PATCH_FILE = 305;
    public static final int KEY_LOADED_MISSING_PATCH_INFO = 306;
    public static final int KEY_LOADED_MISSING_RES = 308;
    public static final int KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 353;
    public static final int KEY_LOADED_PACKAGE_CHECK_DEX_META = 351;
    public static final int KEY_LOADED_PACKAGE_CHECK_LIB_META = 352;
    public static final int KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND = 356;
    public static final int KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 354;
    public static final int KEY_LOADED_PACKAGE_CHECK_RES_META = 357;
    public static final int KEY_LOADED_PACKAGE_CHECK_SIGNATURE = 350;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 358;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 355;
    public static final int KEY_LOADED_SUCC_COST_1000_LESS = 401;
    public static final int KEY_LOADED_SUCC_COST_3000_LESS = 402;
    public static final int KEY_LOADED_SUCC_COST_5000_LESS = 403;
    public static final int KEY_LOADED_SUCC_COST_500_LESS = 400;
    public static final int KEY_LOADED_SUCC_COST_OTHER = 404;
    public static final int KEY_LOADED_UNCAUGHT_EXCEPTION = 251;
    public static final int KEY_LOADED_UNKNOWN_EXCEPTION = 250;
    public static final int KEY_REQUEST = 0;
    public static final int KEY_TRY_APPLY = 2;
    public static final int KEY_TRY_APPLY_ALREADY_APPLY = 77;
    public static final int KEY_TRY_APPLY_CONDITION_NOT_SATISFIED = 80;
    public static final int KEY_TRY_APPLY_CRASH_LIMIT = 79;
    public static final int KEY_TRY_APPLY_DISABLE = 71;
    public static final int KEY_TRY_APPLY_GOOGLEPLAY = 75;
    public static final int KEY_TRY_APPLY_INSERVICE = 73;
    public static final int KEY_TRY_APPLY_JIT = 81;
    public static final int KEY_TRY_APPLY_MEMORY_LIMIT = 78;
    public static final int KEY_TRY_APPLY_NOT_EXIST = 74;
    public static final int KEY_TRY_APPLY_ROM_SPACE = 76;
    public static final int KEY_TRY_APPLY_RUNNING = 72;
    public static final int KEY_TRY_APPLY_SUCCESS = 3;
    public static final int KEY_TRY_APPLY_UPGRADE = 70;
    private static final String TAG = "Tinker.TinkerReport";
    private static Reporter reporter;

    public interface Reporter {
        void onReport(int i10);

        void onReport(String str);
    }

    public static void onApplied(long j10, boolean z10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (z10) {
            reporter2.onReport(5);
        }
        if (z10) {
            reporter.onReport(100);
        } else {
            reporter.onReport(101);
        }
        TinkerLog.i(TAG, "hp_report report apply cost = %d", new Object[]{Long.valueOf(j10)});
        if (j10 < 0) {
            TinkerLog.e(TAG, "hp_report report apply cost failed, invalid cost", new Object[0]);
            return;
        }
        if (j10 <= 5000) {
            if (z10) {
                reporter.onReport(200);
                return;
            } else {
                reporter.onReport(205);
                return;
            }
        }
        if (j10 <= 10000) {
            if (z10) {
                reporter.onReport(201);
                return;
            } else {
                reporter.onReport(206);
                return;
            }
        }
        if (j10 <= 30000) {
            if (z10) {
                reporter.onReport(202);
                return;
            } else {
                reporter.onReport(207);
                return;
            }
        }
        if (j10 <= 60000) {
            if (z10) {
                reporter.onReport(203);
                return;
            } else {
                reporter.onReport(208);
                return;
            }
        }
        if (z10) {
            reporter.onReport(204);
        } else {
            reporter.onReport(209);
        }
    }

    public static void onApplyCrash(Throwable th2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(120);
        reporter.onReport("Tinker Exception:apply tinker occur exception " + TinkerUtils.getExceptionCauseString(th2));
    }

    public static void onApplyDexOptFail(Throwable th2) {
        if (reporter == null) {
            return;
        }
        if (th2.getMessage().contains("checkDexOptExist failed")) {
            reporter.onReport(122);
            return;
        }
        if (th2.getMessage().contains("checkDexOptFormat failed")) {
            reporter.onReport(123);
            return;
        }
        reporter.onReport(121);
        reporter.onReport("Tinker Exception:apply tinker occur exception " + TinkerUtils.getExceptionCauseString(th2));
    }

    public static void onApplyExtractFail(int i10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i10 == 1) {
            reporter2.onReport(KEY_APPLIED_PATCH_FILE_EXTRACT);
            return;
        }
        if (i10 == 3) {
            reporter2.onReport(KEY_APPLIED_DEX_EXTRACT);
        } else if (i10 == 5) {
            reporter2.onReport(KEY_APPLIED_LIB_EXTRACT);
        } else {
            if (i10 != 6) {
                return;
            }
            reporter2.onReport(KEY_APPLIED_RESOURCE_EXTRACT);
        }
    }

    public static void onApplyInfoCorrupted() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(124);
    }

    public static void onApplyPackageCheckFail(int i10) {
        if (reporter == null) {
        }
        TinkerLog.i(TAG, "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i10)});
        switch (i10) {
            case Constants.ERROR_HTTPSTATUS_ERROR /* -9 */:
                reporter.onReport(KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                break;
            case -8:
                reporter.onReport(KEY_APPLIED_PACKAGE_CHECK_RES_META);
                break;
            case -7:
                reporter.onReport(KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL);
                break;
            case -6:
                reporter.onReport(KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND);
                break;
            case -5:
                reporter.onReport(153);
                break;
            case -4:
                reporter.onReport(152);
                break;
            case -3:
                reporter.onReport(151);
                break;
            case -2:
                reporter.onReport(155);
                break;
            case -1:
                reporter.onReport(150);
                break;
        }
    }

    public static void onApplyPatchServiceStart() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(4);
    }

    public static void onApplyVersionCheckFail() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(KEY_APPLIED_VERSION_CHECK);
    }

    public static void onFastCrashProtect() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(7);
    }

    public static void onLoadException(Throwable th2, int i10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i10 == -4) {
            reporter2.onReport(KEY_LOADED_UNCAUGHT_EXCEPTION);
        } else if (i10 != -3) {
            if (i10 != -2) {
                if (i10 == -1) {
                    reporter2.onReport(250);
                }
            } else {
                if (th2.getMessage().contains("checkDexInstall failed")) {
                    reporter.onReport(253);
                    TinkerLog.e(TAG, "tinker dex check fail:" + th2.getMessage(), new Object[0]);
                    return;
                }
                reporter.onReport(KEY_LOADED_EXCEPTION_DEX);
                TinkerLog.e(TAG, "tinker dex reflect fail:" + th2.getMessage(), new Object[0]);
            }
        } else {
            if (th2.getMessage().contains("checkResInstall failed")) {
                reporter.onReport(255);
                TinkerLog.e(TAG, "tinker res check fail:" + th2.getMessage(), new Object[0]);
                return;
            }
            reporter.onReport(254);
            TinkerLog.e(TAG, "tinker res reflect fail:" + th2.getMessage(), new Object[0]);
        }
        reporter.onReport("Tinker Exception:load tinker occur exception " + TinkerUtils.getExceptionCauseString(th2));
    }

    public static void onLoadFileMisMatch(int i10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i10 == 3) {
            reporter2.onReport(300);
        } else if (i10 == 5) {
            reporter2.onReport(301);
        } else {
            if (i10 != 6) {
                return;
            }
            reporter2.onReport(302);
        }
    }

    public static void onLoadFileNotFound(int i10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
        }
        switch (i10) {
            case 1:
                reporter2.onReport(305);
                break;
            case 2:
                reporter2.onReport(306);
                break;
            case 3:
                reporter2.onReport(303);
                break;
            case 4:
                reporter2.onReport(307);
                break;
            case 5:
                reporter2.onReport(304);
                break;
            case 6:
                reporter2.onReport(308);
                break;
        }
    }

    public static void onLoadInfoCorrupted() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(309);
    }

    public static void onLoadInterpretReport(int i10, Throwable th2) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i10 == 0) {
            reporter2.onReport(KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK);
            return;
        }
        if (i10 == 1) {
            reporter2.onReport(KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR);
            reporter.onReport("Tinker Exception:interpret occur exception " + TinkerUtils.getExceptionCauseString(th2));
            return;
        }
        if (i10 != 2) {
            return;
        }
        reporter2.onReport(KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR);
        reporter.onReport("Tinker Exception:interpret occur exception " + TinkerUtils.getExceptionCauseString(th2));
    }

    public static void onLoadPackageCheckFail(int i10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
        }
        switch (i10) {
            case Constants.ERROR_HTTPSTATUS_ERROR /* -9 */:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                break;
            case -8:
                reporter2.onReport(357);
                break;
            case -7:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL);
                break;
            case -6:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND);
                break;
            case -5:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                break;
            case -4:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_LIB_META);
                break;
            case -3:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_DEX_META);
                break;
            case -2:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND);
                break;
            case -1:
                reporter2.onReport(KEY_LOADED_PACKAGE_CHECK_SIGNATURE);
                break;
        }
    }

    public static void onLoaded(long j10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(6);
        if (j10 < 0) {
            TinkerLog.e(TAG, "hp_report report load cost failed, invalid cost", new Object[0]);
            return;
        }
        if (j10 <= 500) {
            reporter.onReport(400);
            return;
        }
        if (j10 <= 1000) {
            reporter.onReport(401);
            return;
        }
        if (j10 <= 3000) {
            reporter.onReport(402);
        } else if (j10 <= 5000) {
            reporter.onReport(403);
        } else {
            reporter.onReport(404);
        }
    }

    public static void onReportRetryPatch() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(10);
    }

    public static void onTryApply(boolean z10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(2);
        reporter.onReport(70);
        if (z10) {
            reporter.onReport(3);
        }
    }

    public static void onTryApplyFail(int i10) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
        }
        switch (i10) {
            case TinkerUtils.ERROR_PATCH_CONDITION_NOT_SATISFIED /* -24 */:
                reporter2.onReport(80);
                break;
            case TinkerUtils.ERROR_PATCH_CRASH_LIMIT /* -23 */:
                reporter2.onReport(79);
                break;
            case TinkerUtils.ERROR_PATCH_MEMORY_LIMIT /* -22 */:
                reporter2.onReport(78);
                break;
            case TinkerUtils.ERROR_PATCH_ROM_SPACE /* -21 */:
                reporter2.onReport(76);
                break;
            case TinkerUtils.ERROR_PATCH_GOOGLEPLAY_CHANNEL /* -20 */:
                reporter2.onReport(75);
                break;
            default:
                switch (i10) {
                    case -6:
                        reporter2.onReport(77);
                        break;
                    case -5:
                        reporter2.onReport(81);
                        break;
                    case -4:
                        reporter2.onReport(73);
                        break;
                    case -3:
                        reporter2.onReport(72);
                        break;
                    case -2:
                        reporter2.onReport(74);
                        break;
                    case -1:
                        reporter2.onReport(71);
                        break;
                }
        }
    }

    public static void onXposedCrash() {
        if (reporter == null) {
            return;
        }
        if (ShareTinkerInternals.isVmArt()) {
            reporter.onReport(9);
        } else {
            reporter.onReport(8);
        }
    }

    public void setReporter(Reporter reporter2) {
        reporter = reporter2;
    }
}
