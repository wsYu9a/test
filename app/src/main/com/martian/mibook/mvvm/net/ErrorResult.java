package com.martian.mibook.mvvm.net;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\r¨\u0006\""}, d2 = {"Lcom/martian/mibook/mvvm/net/ErrorResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", MediationConstant.KEY_ERROR_CODE, "", MediationConstant.KEY_ERROR_MSG, "", "stackTrace", "(ILjava/lang/String;Ljava/lang/String;)V", "arg1", "getArg1", "()I", "setArg1", "(I)V", "arg2", "getArg2", "setArg2", "getErrorCode", "setErrorCode", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "obj", "", "getObj", "()Ljava/lang/Object;", "setObj", "(Ljava/lang/Object;)V", "getStackTrace", "setStackTrace", "what", "getWhat", "setWhat", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ErrorResult extends Exception {
    private int arg1;
    private int arg2;
    private int errorCode;

    @k
    private String errorMsg;

    @l
    private Object obj;

    @l
    private String stackTrace;
    private int what;

    public ErrorResult(int i10, @k String errorMsg, @l String str) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.errorCode = i10;
        this.errorMsg = errorMsg;
        this.stackTrace = str;
    }

    public final int getArg1() {
        return this.arg1;
    }

    public final int getArg2() {
        return this.arg2;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @k
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @l
    public final Object getObj() {
        return this.obj;
    }

    @Override // java.lang.Throwable
    @l
    public final String getStackTrace() {
        return this.stackTrace;
    }

    public final int getWhat() {
        return this.what;
    }

    public final void setArg1(int i10) {
        this.arg1 = i10;
    }

    public final void setArg2(int i10) {
        this.arg2 = i10;
    }

    public final void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public final void setErrorMsg(@k String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMsg = str;
    }

    public final void setObj(@l Object obj) {
        this.obj = obj;
    }

    public final void setStackTrace(@l String str) {
        this.stackTrace = str;
    }

    public final void setWhat(int i10) {
        this.what = i10;
    }

    public /* synthetic */ ErrorResult(int i10, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? "" : str2);
    }
}
