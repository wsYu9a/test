package com.kwai.filedownloader.e;

/* loaded from: classes2.dex */
public class a {
    public static boolean cB(int i2) {
        h("request pause the task[%d] in the download service", Integer.valueOf(i2));
        return false;
    }

    public static byte cC(int i2) {
        h("request get the status for the task[%d] in the download service", Integer.valueOf(i2));
        return (byte) 0;
    }

    public static boolean cD(int i2) {
        h("request clear the task[%d] data in the database", Integer.valueOf(i2));
        return false;
    }

    private static void h(String str, Object... objArr) {
        d.h(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean l(String str, String str2, boolean z) {
        h("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }
}
