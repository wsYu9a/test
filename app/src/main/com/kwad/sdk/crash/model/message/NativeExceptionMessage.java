package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class NativeExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -7790706181005700630L;
    public String mFingerprint = "Unknown";
    public String mRevision = "Unknown";
    public String mRegister = "Unknown";
    public String mSignal = "Unknown";
    public String mCode = "Unknown";
    public String mManuallyKill = "Unknown";
    public String mFaultAddr = "Unknown";
    public String mAbortMsg = "";
    public String mNativeBacktrace = "";
    public String mJavaBacktrace = "";
    public String mScudoAbortMsg = "";
    public String mGwpAsanCause = "";
    public String mGwpAsanAllocationThread = "";
    public String mGwpAsanAllocationBacktrace = "";
    public String mGwpAsanDeallocationThread = "";
    public String mGwpAsanDeallocationBacktrace = "";

    public NativeExceptionMessage() {
        this.mExceptionType = 4;
    }

    public final String getAbortMsg() {
        return this.mAbortMsg;
    }

    public final String getCode() {
        return this.mCode;
    }

    public final String getFaultAddr() {
        return this.mFaultAddr;
    }

    public final String getFingerprint() {
        return this.mFingerprint;
    }

    public final String getGwpAsanAllocationBacktrace() {
        return this.mGwpAsanAllocationBacktrace;
    }

    public final String getGwpAsanAllocationThread() {
        return this.mGwpAsanAllocationThread;
    }

    public final String getGwpAsanDeallocationBacktrace() {
        return this.mGwpAsanDeallocationBacktrace;
    }

    public final String getGwpAsanDeallocationThread() {
        return this.mGwpAsanDeallocationThread;
    }

    public final String getJavaBacktrace() {
        return this.mJavaBacktrace;
    }

    public final String getManuallyKill() {
        return this.mManuallyKill;
    }

    public final String getNativeBacktrace() {
        return this.mNativeBacktrace;
    }

    public final String getRegister() {
        return this.mRegister;
    }

    public final String getRevision() {
        return this.mRevision;
    }

    public final String getSignal() {
        return this.mSignal;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String getTypePrefix() {
        return "NATIVE_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mFingerprint = jSONObject.optString("mFingerprint");
        this.mRevision = jSONObject.optString("mRevision");
        this.mRegister = jSONObject.optString("mRegister");
        this.mSignal = jSONObject.optString("mSignal");
        this.mCode = jSONObject.optString("mCode");
        this.mManuallyKill = jSONObject.optString("mManuallyKill");
        this.mFaultAddr = jSONObject.optString("mFaultAddr");
        this.mAbortMsg = jSONObject.optString("mAbortMsg");
        this.mJavaBacktrace = jSONObject.optString("mJavaBacktrace");
        this.mNativeBacktrace = jSONObject.optString("mNativeBacktrace");
        this.mGwpAsanAllocationThread = jSONObject.optString("mGwpAsanAllocationThread");
        this.mGwpAsanAllocationBacktrace = jSONObject.optString("mGwpAsanAllocationBacktrace");
        this.mGwpAsanDeallocationThread = jSONObject.optString("mGwpAsanDeallocationThread");
        this.mGwpAsanDeallocationBacktrace = jSONObject.optString("mGwpAsanDeallocationBacktrace");
    }

    public final void setAbortMsg(String str) {
        this.mAbortMsg = str;
    }

    public final void setCode(String str) {
        this.mCode = str;
    }

    public final void setFaultAddr(String str) {
        this.mFaultAddr = str;
    }

    public final void setFingerprint(String str) {
        this.mFingerprint = str;
    }

    public final void setGwpAsanAllocationBacktrace(String str) {
        this.mGwpAsanAllocationBacktrace = str;
    }

    public final void setGwpAsanAllocationThread(String str) {
        this.mGwpAsanAllocationThread = str;
    }

    public final void setGwpAsanDeallocationBacktrace(String str) {
        this.mGwpAsanDeallocationBacktrace = str;
    }

    public final void setGwpAsanDeallocationThread(String str) {
        this.mGwpAsanDeallocationThread = str;
    }

    public final void setJavaBacktrace(String str) {
        this.mJavaBacktrace = str;
    }

    public final void setManuallyKill(String str) {
        this.mManuallyKill = str;
    }

    public final void setNativeBacktrace(String str) {
        this.mNativeBacktrace = str;
    }

    public final void setRegister(String str) {
        this.mRegister = str;
    }

    public final void setRevision(String str) {
        this.mRevision = str;
    }

    public final void setSignal(String str) {
        this.mSignal = str;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        x.putValue(json, "mFingerprint", this.mFingerprint);
        x.putValue(json, "mRevision", this.mRevision);
        x.putValue(json, "mRegister", this.mRegister);
        x.putValue(json, "mSignal", this.mSignal);
        x.putValue(json, "mCode", this.mCode);
        x.putValue(json, "mManuallyKill", this.mManuallyKill);
        x.putValue(json, "mFaultAddr", this.mFaultAddr);
        x.putValue(json, "mAbortMsg", this.mAbortMsg);
        x.putValue(json, "mNativeBacktrace", this.mNativeBacktrace);
        x.putValue(json, "mJavaBacktrace", this.mJavaBacktrace);
        x.putValue(json, "mGwpAsanAllocationThread", this.mGwpAsanAllocationThread);
        x.putValue(json, "mGwpAsanAllocationBacktrace", this.mGwpAsanAllocationBacktrace);
        x.putValue(json, "mGwpAsanDeallocationThread", this.mGwpAsanDeallocationThread);
        x.putValue(json, "mGwpAsanDeallocationBacktrace", this.mGwpAsanDeallocationBacktrace);
        return json;
    }
}
