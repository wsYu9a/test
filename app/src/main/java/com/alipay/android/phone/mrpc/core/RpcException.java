package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public class RpcException extends RuntimeException {
    public static final long serialVersionUID = -2875437994101380406L;
    public int mCode;
    public String mMsg;
    public String mOperationType;

    public RpcException(Integer num, String str) {
        super(a(num, str));
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    public static String a(Integer num, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RPCException: ");
        if (num != null) {
            sb2.append("[");
            sb2.append(num);
            sb2.append("]");
        }
        sb2.append(" : ");
        if (str != null) {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public String getOperationType() {
        return this.mOperationType;
    }

    public void setOperationType(String str) {
        this.mOperationType = str;
    }

    public RpcException(Integer num, String str, Throwable th2) {
        super(a(num, str), th2);
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    public RpcException(Integer num, Throwable th2) {
        super(th2);
        this.mCode = num.intValue();
    }

    public RpcException(String str) {
        super(str);
        this.mCode = 0;
        this.mMsg = str;
    }
}
