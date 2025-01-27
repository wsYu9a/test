package com.umeng.analytics.vshelper;

/* loaded from: classes4.dex */
public class PageNameMonitor implements com.umeng.analytics.vshelper.a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    public static class a {

        /* renamed from: a */
        private static final PageNameMonitor f24221a = new PageNameMonitor();

        private a() {
        }
    }

    public /* synthetic */ PageNameMonitor(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static PageNameMonitor getInstance() {
        return a.f24221a;
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            try {
                String str = currentCustomPage;
                if (str != null) {
                    return str;
                }
                String str2 = currentActivity;
                if (str2 != null) {
                    return str2;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String getCurrentActivityName() {
        String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }

    private PageNameMonitor() {
    }
}
