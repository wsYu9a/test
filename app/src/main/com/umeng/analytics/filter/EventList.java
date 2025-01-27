package com.umeng.analytics.filter;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes4.dex */
public class EventList extends c implements FileLockCallback {
    private static final int DELETE_LIST_DATA = 2;
    private static final int LOAD_LIST_DATA = 1;
    private static final int SAVE_LIST_DATA = 0;
    private Context mAppContext;
    protected String mEventList;
    protected String mEventListKey;
    protected String mEventListName;
    protected String mEventListVersionKey;
    private FileLockUtil mFileLock = new FileLockUtil();

    public EventList(String str, String str2) {
        this.mEventListName = str;
        this.mEventListKey = str;
        this.mEventListVersionKey = str2;
    }

    private void deleteDataFile(File file) {
        if (this.mAppContext != null) {
            synchronized (this.mFileLock) {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } finally {
                }
            }
        }
    }

    private boolean loadEventListFromFile(Context context, File file) {
        Throwable th2;
        BufferedReader bufferedReader;
        String sb2;
        if (file.exists() && TextUtils.isEmpty(this.mEventList)) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th3) {
                    th2 = th3;
                    bufferedReader = null;
                }
                try {
                    StringBuilder sb3 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb3.append(readLine);
                    }
                    sb2 = sb3.toString();
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        UMCrashManager.reportCrash(context, th2);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return false;
                    } catch (Throwable th5) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th6) {
                                UMCrashManager.reportCrash(context, th6);
                            }
                        }
                        throw th5;
                    }
                }
                if (!TextUtils.isEmpty(sb2)) {
                    String md5 = HelperUtils.getMD5(sb2);
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(context, this.mEventListVersionKey, "");
                    this.mEventList = sb2;
                    eventListChange();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> loadEventListFromFile: mEventList = " + this.mEventList);
                    if (!UMUtils.isMainProgress(context)) {
                        if (!md5.equalsIgnoreCase(imprintProperty)) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th7) {
                                UMCrashManager.reportCrash(context, th7);
                            }
                            return false;
                        }
                        this.mEventList = sb2;
                        eventListChange();
                        try {
                            bufferedReader.close();
                        } catch (Throwable th8) {
                            UMCrashManager.reportCrash(context, th8);
                        }
                        return true;
                    }
                    if (!md5.equalsIgnoreCase(imprintProperty)) {
                        setMD5ClearFlag(true);
                        try {
                            bufferedReader.close();
                        } catch (Throwable th9) {
                            UMCrashManager.reportCrash(context, th9);
                        }
                        return false;
                    }
                    this.mEventList = sb2;
                    setMD5ClearFlag(false);
                    try {
                        bufferedReader.close();
                    } catch (Throwable th10) {
                        UMCrashManager.reportCrash(context, th10);
                    }
                    return true;
                }
                bufferedReader.close();
            } catch (Throwable th11) {
                UMCrashManager.reportCrash(context, th11);
            }
        }
        return false;
    }

    private void saveEventListToFile(Context context, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.mEventList.getBytes());
            fileOutputStream.close();
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public boolean enabled() {
        synchronized (this) {
            try {
                return this.mEventList != null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void eventListChange() {
    }

    public boolean matchHit(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        if (f.at.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable black list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
        if (f.au.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable white list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
    }

    @Override // com.umeng.analytics.filter.c, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
    public boolean onPreProcessImprintKey(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onPreProcessImprintKey: key = " + str + "; len of value=" + str2.length());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--->>> onPreProcessImprintKey: value = ");
        sb2.append(str2);
        UMRTLog.i(UMRTLog.RTLOG_TAG, sb2.toString());
        this.mEventList = str2;
        eventListChange();
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e10) {
                UMCrashManager.reportCrash(this.mAppContext, e10);
            }
        }
        this.mFileLock.doFileOperateion(file, this, 0);
        setMD5ClearFlag(false);
        return true;
    }

    public void register(Context context) {
        if (this.mAppContext == null) {
            this.mAppContext = context.getApplicationContext();
        }
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!TextUtils.isEmpty(UMEnvelopeBuild.imprintProperty(this.mAppContext, this.mEventListVersionKey, ""))) {
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this, 1);
            } else {
                setMD5ClearFlag(true);
            }
        }
        if (UMUtils.isMainProgress(this.mAppContext)) {
            ImprintHandler.getImprintService(this.mAppContext).registPreProcessCallback(this.mEventListKey, this);
            ImprintHandler.getImprintService(this.mAppContext).registImprintCallback(this.mEventListVersionKey, this);
        }
    }

    public void setMD5ClearFlag(boolean z10) {
    }

    public String toString() {
        if (TextUtils.isEmpty(this.mEventListName) || TextUtils.isEmpty(this.mEventListKey)) {
            return "Uninitialized EventList.";
        }
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append("EventListName:" + this.mEventListName + ",");
        sb2.append("listKey:" + this.mEventListKey + ",");
        if (TextUtils.isEmpty(this.mEventList)) {
            sb2.append("listKeyValue:empty,");
        } else {
            sb2.append("listKeyValue:" + this.mEventList + "]");
        }
        if (TextUtils.isEmpty(this.mEventListVersionKey)) {
            sb2.append("listKeyVer:empty]");
        } else {
            sb2.append("listKeyVer:" + this.mEventListVersionKey + "]");
        }
        return sb2.toString();
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                saveEventListToFile(this.mAppContext, file);
            }
        } else if (i10 == 1) {
            synchronized (this) {
                try {
                    if (loadEventListFromFile(this.mAppContext, file)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> find event list data file, load it.");
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> can't find event list file.");
                    }
                } finally {
                }
            }
        } else if (i10 == 2) {
            synchronized (this) {
                this.mEventList = null;
                deleteDataFile(file);
            }
        }
        return true;
    }
}
