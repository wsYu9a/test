package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class g extends d {
    public static final Pattern asy = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern asz = Pattern.compile("\\sd+\\spc");

    private void a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.dW(file.getName());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z = false;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (z && readLine.startsWith("backtrace:")) {
                        z = false;
                        z2 = true;
                    } else if (z2) {
                        if (readLine.startsWith("###### ending of java stack trace ######")) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                    } else if (z) {
                        a(nativeExceptionMessage, readLine, sb2);
                    } else if (readLine.startsWith("*** ***")) {
                        z = true;
                    }
                } catch (IOException e2) {
                    this.mErrorMessage += e2 + "\n";
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        }
        if (sb.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mRegister = sb2.substring(0, sb2.length() - 1);
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
            return;
        }
        if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
            return;
        }
        if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
            return;
        }
        if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
            return;
        }
        if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
            return;
        }
        if (str.startsWith("    r") || str.startsWith("    ip") || str.startsWith("    x") || str.startsWith("    sp")) {
            sb.append(str);
            sb.append('\n');
            return;
        }
        if (!str.startsWith("pid: ")) {
            if (str.startsWith("signal ")) {
                String[] split = str.split("\\s+");
                if (split.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.dX(split[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.dX(split[5]);
                    nativeExceptionMessage.mFaultAddr = split[split.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split[split.length + (-1)]) ? "True" : "False";
                    return;
                }
                return;
            }
            return;
        }
        String[] split2 = str.split("\\s+");
        if (split2.length < 9) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < split2.length; i5++) {
            if ("name:".equals(split2[i5])) {
                i2 = i5;
            } else if (">>>".equals(split2[i5])) {
                i3 = i5;
            } else if ("<<<".equals(split2[i5])) {
                i4 = i5;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        int i6 = i2 + 1;
        String str2 = split2[i6];
        while (true) {
            sb2.append(str2);
            i6++;
            if (i6 >= i3) {
                break;
            }
            sb2.append(" ");
            str2 = split2[i6];
        }
        nativeExceptionMessage.mThreadName = sb2.toString();
        sb2.setLength(0);
        int i7 = i3 + 1;
        String str3 = split2[i7];
        while (true) {
            sb2.append(str3);
            i7++;
            if (i7 >= i4) {
                nativeExceptionMessage.mProcessName = sb2.toString();
                return;
            } else {
                sb2.append(" ");
                str3 = split2[i7];
            }
        }
    }

    private static void c(File file, ExceptionMessage exceptionMessage) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    ThreadInfo threadInfo = new ThreadInfo();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.isEmpty()) {
                            arrayList.add(threadInfo);
                            threadInfo = new ThreadInfo();
                        } else if (asz.matcher(readLine).matches()) {
                            if (threadInfo.mTrace != null) {
                                readLine = threadInfo.mTrace + readLine;
                            }
                            threadInfo.mTrace = readLine;
                            threadInfo.mTrace += "\n";
                        } else {
                            Matcher matcher = asy.matcher(readLine);
                            if (matcher.lookingAt()) {
                                threadInfo.mName = matcher.group(1);
                                threadInfo.mTid = Integer.parseInt(matcher.group(2));
                                threadInfo.mIndex = Integer.parseInt(matcher.group(3));
                            }
                        }
                    }
                    memoryInfo.mNativeThreads = arrayList;
                    exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                } catch (IOException e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
        }
    }

    private NativeExceptionMessage y(File file) {
        String str;
        try {
            str = q.Q(file);
        } catch (IOException e2) {
            this.mErrorMessage += e2 + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e3) {
                this.mErrorMessage += e3 + "\n";
            }
        }
        q.N(file);
        return nativeExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage y = y(file2);
        try {
            a(y, file);
            b(file3, y);
            d.a(file4, y);
            c(new File(str + ".ntrace"), y);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) y.toString(), true);
            com.kwad.sdk.crash.utils.g.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ Native Crash Report Begin ------\n").append(y);
            y.mDumpsys = q.Q(new File(str + ".minfo"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            this.mErrorMessage += e2 + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            y.mErrorMessage += this.mErrorMessage;
        }
        return y;
    }
}
