package com.vivo.ic.dm.network;

import android.os.Process;
import com.vivo.ic.VLog;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private String f28521a;

    /* renamed from: b */
    private long f28522b;

    /* renamed from: c */
    private int f28523c;

    public b(String str, long j2) {
        this.f28523c = -100;
        this.f28521a = str;
        this.f28522b = j2;
    }

    public void a(String str) {
        if (this.f28523c == -100) {
            VLog.d(this.f28521a, Process.myTid() + " [" + this.f28522b + "] " + str);
            return;
        }
        VLog.d(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + this.f28523c + ") " + str);
    }

    public void b(int i2, String str) {
        VLog.i(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + i2 + ") " + str);
    }

    public void c(String str) {
        if (this.f28523c == -100) {
            VLog.w(this.f28521a, Process.myTid() + " [" + this.f28522b + "] " + str);
            return;
        }
        VLog.w(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + this.f28523c + ") " + str);
    }

    public void b(String str) {
        if (this.f28523c == -100) {
            VLog.i(this.f28521a, Process.myTid() + " [" + this.f28522b + "] " + str);
            return;
        }
        VLog.i(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + this.f28523c + ") " + str);
    }

    public void a(int i2, String str) {
        VLog.d(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + i2 + ") " + str);
    }

    public b(String str, long j2, int i2) {
        this.f28523c = -100;
        this.f28521a = str;
        this.f28522b = j2;
        this.f28523c = i2;
    }

    public void a(String str, Throwable th) {
        if (this.f28523c == -100) {
            VLog.e(this.f28521a, Process.myTid() + " [" + this.f28522b + "] " + str, th);
            return;
        }
        VLog.e(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + this.f28523c + ") " + str, th);
    }

    public void b(String str, Throwable th) {
        if (this.f28523c == -100) {
            VLog.w(this.f28521a, Process.myTid() + " [" + this.f28522b + "] " + str, th);
            return;
        }
        VLog.w(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + this.f28523c + ") " + str, th);
    }

    public void a(int i2, String str, Throwable th) {
        VLog.e(this.f28521a, Process.myTid() + " [" + this.f28522b + "](" + i2 + ") " + str, th);
    }
}
