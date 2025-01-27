package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.NativeBackTraceElement;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.utils.u;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class g extends d {
    public static final Pattern aLJ = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern aLK = Pattern.compile("\\sd+\\spc");

    private NativeExceptionMessage E(File file) {
        String str;
        try {
            str = u.W(file);
        } catch (IOException e10) {
            this.mErrorMessage += e10 + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e11) {
                this.mErrorMessage += e11 + "\n";
            }
        }
        u.T(file);
        return nativeExceptionMessage;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        r0 = r5.group(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r0 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r4.setSignal(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        r0 = r5.group(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r0 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r4.setCode(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        r0 = r5.group(5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r0 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        r4.setFaultAddr(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r0.equals("--------") == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r0 = java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r4.setManuallyKill(r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r0 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        r0 = r5.group(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
    
        if (r0 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        r4.setThreadName(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
    
        r5 = r5.group(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        if (r5 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        r4.setTid(java.lang.Integer.parseInt(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.NativeExceptionMessage r4, java.io.File r5) {
        /*
            r3 = this;
            boolean r0 = r5.exists()
            if (r0 != 0) goto L7
            return
        L7:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.io.IOException -> L3a
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.io.IOException -> L3a
            r1.<init>(r5)     // Catch: java.io.IOException -> L3a
            r0.<init>(r1)     // Catch: java.io.IOException -> L3a
        L11:
            java.lang.String r5 = r0.readLine()     // Catch: java.io.IOException -> L3a
            if (r5 == 0) goto L7e
            java.lang.String r1 = "Fatal signal (\\d+) \\((\\w+)\\), code (-*\\d+) \\((\\w+)\\), fault addr (-*\\w*) in tid (\\d+) \\((.*)\\), pid (\\d+).*"
            java.util.regex.Pattern r1 = r3.fS(r1)     // Catch: java.io.IOException -> L3a
            java.util.regex.Matcher r5 = r1.matcher(r5)     // Catch: java.io.IOException -> L3a
            boolean r1 = r5.lookingAt()     // Catch: java.io.IOException -> L3a
            if (r1 == 0) goto L11
            int r1 = r5.groupCount()     // Catch: java.io.IOException -> L3a
            r2 = 8
            if (r1 < r2) goto L11
            r0 = 2
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3a
            if (r0 == 0) goto L3c
            r4.setSignal(r0)     // Catch: java.io.IOException -> L3a
            goto L3c
        L3a:
            r4 = move-exception
            goto L7f
        L3c:
            r0 = 4
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3a
            if (r0 == 0) goto L46
            r4.setCode(r0)     // Catch: java.io.IOException -> L3a
        L46:
            r0 = 5
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3a
            if (r0 == 0) goto L65
            r4.setFaultAddr(r0)     // Catch: java.io.IOException -> L3a
            java.lang.String r1 = "--------"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L3a
            if (r0 == 0) goto L5f
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.io.IOException -> L3a
        L5a:
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L3a
            goto L62
        L5f:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.io.IOException -> L3a
            goto L5a
        L62:
            r4.setManuallyKill(r0)     // Catch: java.io.IOException -> L3a
        L65:
            r0 = 7
            java.lang.String r0 = r5.group(r0)     // Catch: java.io.IOException -> L3a
            if (r0 == 0) goto L6f
            r4.setThreadName(r0)     // Catch: java.io.IOException -> L3a
        L6f:
            r0 = 6
            java.lang.String r5 = r5.group(r0)     // Catch: java.io.IOException -> L3a
            if (r5 == 0) goto L7e
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.io.IOException -> L3a
            r4.setTid(r5)     // Catch: java.io.IOException -> L3a
            goto L9e
        L7e:
            return
        L7f:
            r4.printStackTrace()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r3.mErrorMessage
            r5.append(r0)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = "\n"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.mErrorMessage = r4
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.g.a(com.kwad.sdk.crash.model.message.NativeExceptionMessage, java.io.File):void");
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, File file4, File file5) {
        File file6 = new File(file5, "java_backtrace");
        new File(file5, "all_java_backtrace");
        File file7 = new File(file5, "maps");
        NativeExceptionMessage E = E(file2);
        try {
            a(E, file, file6, file7, false);
            if (E.mTid == 0) {
                a(E, new File(file5, "debug"));
            }
            File file8 = new File(file5, ".minfo");
            if (file8.exists()) {
                E.mDumpsys = u.W(file8);
            } else {
                com.kwad.sdk.core.d.c.w("NativeCrashReporter", "memory file not exist:" + file8.getName());
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.w("NativeCrashReporter", Log.getStackTraceString(e10));
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            this.mErrorMessage += e10 + "\n";
        }
        TextUtils.isEmpty(this.mErrorMessage);
        return E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f6, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.NativeExceptionMessage r17, java.io.File r18, java.io.File r19, java.io.File r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.g.a(com.kwad.sdk.crash.model.message.NativeExceptionMessage, java.io.File, java.io.File, java.io.File, boolean):void");
    }

    private void a(String str, BufferedReader bufferedReader, NativeExceptionMessage nativeExceptionMessage) {
        StringBuilder sb2 = new StringBuilder();
        Backtrace backtrace = new Backtrace();
        StringBuilder sb3 = new StringBuilder();
        Backtrace backtrace2 = new Backtrace();
        boolean startsWith = str.startsWith("de");
        if (startsWith) {
            sb3.append(str);
            sb3.append("\n");
        } else {
            sb2.append(str);
            sb2.append("\n");
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || TextUtils.isEmpty(readLine)) {
                break;
            } else {
                a(readLine, startsWith ? backtrace2 : backtrace);
            }
        }
        if (startsWith) {
            nativeExceptionMessage.setGwpAsanDeallocationThread(sb3.toString());
            nativeExceptionMessage.setGwpAsanDeallocationBacktrace(backtrace2.toJson().toString());
        } else {
            nativeExceptionMessage.setGwpAsanAllocationThread(sb2.toString());
            nativeExceptionMessage.setGwpAsanAllocationBacktrace(backtrace.toJson().toString());
        }
    }

    private void a(String str, Backtrace backtrace) {
        String group;
        if (backtrace.mFrame > 256) {
            return;
        }
        NativeBackTraceElement nativeBackTraceElement = new NativeBackTraceElement(str, backtrace.mFrame);
        Matcher matcher = fS(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*?([^/]+\\.so)(?:\\s+\\(offset\\s+\\w+\\))?(?:\\s+\\((.*?)\\+\\d+\\))?(\\s+\\(BuildId:\\s+(\\b\\w+)\\))?").matcher(str);
        Matcher matcher2 = fS(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*?([^/]+)\\s+\\((.*?)\\+\\d+\\)\\s+\\(BuildId:\\s+(\\b\\w+)\\)").matcher(str);
        Matcher matcher3 = fS(".*#\\d+\\s+pc\\s+(\\w+)\\s+.*-cache.*\\(offset\\s+\\w+\\)\\s+\\((.*?)\\+\\d+\\)").matcher(str);
        if (matcher.lookingAt() && matcher.groupCount() >= 5) {
            nativeBackTraceElement.setPc(matcher.group(1));
            nativeBackTraceElement.setFileName(matcher.group(2));
            String group2 = matcher.group(3);
            if (!TextUtils.isEmpty(group2)) {
                if (fS(".*(Mterp|ExecuteMterp|(art::|_ZN3art11)(interpreter|.*Invoke)|art_?interpreter|art_?quick|ZN3art9ArtMethod6Invoke|art::ArtMethod::Invoke).*").matcher(group2).lookingAt()) {
                    nativeBackTraceElement.setNeedClustering(false);
                    return;
                }
                Matcher matcher4 = fS("[^\\[(<\\]]+").matcher(group2);
                if (matcher4.lookingAt()) {
                    Matcher matcher5 = fS(".*(\\b\\w+)").matcher(matcher4.group());
                    if (matcher5.lookingAt() && matcher.groupCount() > 0 && (group = matcher5.group(1)) != null) {
                        nativeBackTraceElement.setMethodName(group);
                    }
                }
                if (nativeBackTraceElement.getMethodName() == null) {
                    nativeBackTraceElement.setMethodName(group2);
                }
            }
            String group3 = matcher.group(5);
            if (group3 != null) {
                nativeBackTraceElement.setBuildId(group3);
            }
        } else if (matcher2.lookingAt() && matcher2.groupCount() >= 4) {
            nativeBackTraceElement.setPc(matcher2.group(1));
            nativeBackTraceElement.setFileName(matcher2.group(2));
            String group4 = matcher2.group(3);
            if (group4 != null) {
                nativeBackTraceElement.setMethodName(group4);
            }
            String group5 = matcher2.group(4);
            if (group5 != null) {
                nativeBackTraceElement.setBuildId(group5);
            }
        } else {
            if (!matcher3.lookingAt() || matcher3.groupCount() < 2) {
                return;
            }
            nativeBackTraceElement.setPc(matcher3.group(1));
            nativeBackTraceElement.setFileName("jit-code-cache");
            String group6 = matcher3.group(2);
            if (group6 != null) {
                nativeBackTraceElement.setMethodName(group6);
            }
        }
        backtrace.setFrame(backtrace.getFrame() + 1);
        backtrace.getBacktraces().add(nativeBackTraceElement);
    }

    private static void a(BufferedReader bufferedReader, File file) {
        boolean exists = file.exists();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.startsWith("---")) {
                return;
            }
            if (!exists) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write(readLine);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        }
    }

    private static void a(BufferedReader bufferedReader, ExceptionMessage exceptionMessage) {
        boolean z10 = false;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (!z10 && readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                z10 = true;
            } else if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                if (readLine.contains("dvm_lock_sample")) {
                    if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                        exceptionMessage.mLockInfo = readLine + "\n";
                    } else {
                        exceptionMessage.mLockInfo += readLine + "\n";
                    }
                } else if (readLine.contains("Long monitor")) {
                    if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                        exceptionMessage.mMonitorInfo = readLine + "\n";
                    } else {
                        exceptionMessage.mMonitorInfo += readLine + "\n";
                    }
                } else if (readLine.contains("Slow Looper")) {
                    if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                        exceptionMessage.mSlowLooper = readLine + "\n";
                    } else {
                        exceptionMessage.mSlowLooper += readLine + "\n";
                    }
                } else if (readLine.contains("Slow Operation")) {
                    if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                        exceptionMessage.mSlowOperation = readLine + "\n";
                    } else {
                        exceptionMessage.mSlowOperation += readLine + "\n";
                    }
                }
            } else if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                exceptionMessage.mGCInfo = readLine + "\n";
            } else {
                exceptionMessage.mGCInfo += readLine + "\n";
            }
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb2) {
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
        if (!str.startsWith("    r") && !str.startsWith("    ip") && !str.startsWith("    x") && !str.startsWith("    sp")) {
            if (str.startsWith("pid: ")) {
                String[] split = str.split("\\s+");
                if (split.length < 9) {
                    return;
                }
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < split.length; i13++) {
                    if ("name:".equals(split[i13])) {
                        i10 = i13;
                    } else if (">>>".equals(split[i13])) {
                        i11 = i13;
                    } else if ("<<<".equals(split[i13])) {
                        i12 = i13;
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                int i14 = i10 + 1;
                sb3.append(split[i14]);
                while (true) {
                    i14++;
                    if (i14 >= i11) {
                        break;
                    }
                    sb3.append(" ");
                    sb3.append(split[i14]);
                }
                nativeExceptionMessage.mThreadName = sb3.toString();
                sb3.setLength(0);
                int i15 = i11 + 1;
                sb3.append(split[i15]);
                while (true) {
                    i15++;
                    if (i15 < i12) {
                        sb3.append(" ");
                        sb3.append(split[i15]);
                    } else {
                        nativeExceptionMessage.mProcessName = sb3.toString();
                        return;
                    }
                }
            } else if (str.startsWith("signal ")) {
                String[] split2 = str.split("\\s+");
                if (split2.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.fY(split2[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.fY(split2[5]);
                    nativeExceptionMessage.mFaultAddr = split2[split2.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split2[split2.length + (-1)]) ? "True" : "False";
                }
            }
        } else {
            sb2.append(str);
            sb2.append('\n');
        }
    }
}
