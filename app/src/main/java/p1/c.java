package p1;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.facade.template.ILogger;

/* loaded from: classes.dex */
public class c implements ILogger {

    /* renamed from: b */
    public static boolean f29703b = false;

    /* renamed from: c */
    public static boolean f29704c = false;

    /* renamed from: d */
    public static boolean f29705d = false;

    /* renamed from: a */
    public String f29706a;

    public c() {
        this.f29706a = b.f29690a;
    }

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb2 = new StringBuilder("[");
        if (f29704c) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id2 = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb2.append("ThreadId=");
            sb2.append(id2);
            sb2.append(" & ");
            sb2.append("ThreadName=");
            sb2.append(name);
            sb2.append(" & ");
            sb2.append("FileName=");
            sb2.append(fileName);
            sb2.append(" & ");
            sb2.append("ClassName=");
            sb2.append(className);
            sb2.append(" & ");
            sb2.append("MethodName=");
            sb2.append(methodName);
            sb2.append(" & ");
            sb2.append("LineNumber=");
            sb2.append(lineNumber);
        }
        sb2.append(" ] ");
        return sb2.toString();
    }

    public void b(boolean z10) {
        f29705d = z10;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void debug(String str, String str2) {
        if (f29703b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.d(str, str2 + a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void error(String str, String str2) {
        if (f29703b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.e(str, str2 + a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public String getDefaultTag() {
        return this.f29706a;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void info(String str, String str2) {
        if (f29703b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.i(str, str2 + a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public boolean isMonitorMode() {
        return f29705d;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void monitor(String str) {
        if (f29703b && isMonitorMode()) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(this.f29706a + "::monitor", str + a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void showLog(boolean z10) {
        f29703b = z10;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void showStackTrace(boolean z10) {
        f29704c = z10;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void warning(String str, String str2) {
        if (f29703b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.w(str, str2 + a(stackTraceElement));
        }
    }

    public c(String str) {
        this.f29706a = str;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void error(String str, String str2, Throwable th2) {
        if (f29703b) {
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.e(str, str2, th2);
        }
    }
}
