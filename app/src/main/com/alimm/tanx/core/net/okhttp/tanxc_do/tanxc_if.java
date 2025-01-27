package com.alimm.tanx.core.net.okhttp.tanxc_do;

import android.os.Handler;
import android.text.TextUtils;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public class tanxc_if {
    private int tanxc_byte;
    private final OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    private final Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    private String tanxc_do;
    private Request tanxc_else;
    private Map<String, String> tanxc_for;
    private String tanxc_if;
    private Map<String, String> tanxc_int;
    private boolean tanxc_new;
    private int tanxc_try;

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ ResultCall tanxc_do;

        public AnonymousClass1(ResultCall resultCall) {
            resultCall = resultCall;
        }

        @Override // java.lang.Runnable
        public void run() {
            resultCall.onBefore();
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2 */
    public class AnonymousClass2 implements Callback {
        final /* synthetic */ ResultCall tanxc_do;

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ IOException tanxc_do;
            final /* synthetic */ Call tanxc_if;

            public AnonymousClass1(IOException iOException, Call call) {
                iOException = iOException;
                call = call;
            }

            @Override // java.lang.Runnable
            public void run() {
                IOException iOException = iOException;
                if (!(iOException instanceof SocketException)) {
                    UtErrorCode utErrorCode = iOException instanceof ConnectException ? UtErrorCode.NETWORK_CONNECT_EXCEPTION : iOException instanceof SocketTimeoutException ? UtErrorCode.NETWORK_TIMEOUT : UtErrorCode.NETWORK_ERROR;
                    LogUtils.i("OkHttp ", "请求失败原因 ==> " + LogUtils.getStackTraceMessage(iOException));
                    IOException iOException2 = iOException;
                    String str = "";
                    if (iOException2 != null && iOException2.getMessage() != null) {
                        String message = iOException.getMessage();
                        try {
                            str = " --> " + call.request().url().uri().toString();
                        } catch (Exception unused) {
                        }
                        str = message + str;
                    }
                    if (TextUtils.isEmpty(str)) {
                        resultCall.onError(utErrorCode.getIntCode(), utErrorCode.getMsg());
                    } else {
                        resultCall.onError(utErrorCode.getIntCode(), str);
                    }
                }
                LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                resultCall.onAfter();
            }
        }

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2$2 */
        public class RunnableC02142 implements Runnable {
            public RunnableC02142() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ResultCall resultCall = resultCall;
                if (resultCall != null) {
                    resultCall.onAfter();
                }
            }
        }

        public AnonymousClass2(ResultCall resultCall) {
            resultCall = resultCall;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (!(iOException instanceof SocketException) && tanxc_if.this.tanxc_byte < tanxc_if.this.tanxc_try && tanxc_if.this.tanxc_try > 0) {
                tanxc_if.tanxc_for(tanxc_if.this);
                tanxc_if.this.tanxc_case.newCall(call.request()).enqueue(this);
            } else {
                tanxc_if.this.tanxc_if();
                if (resultCall != null) {
                    tanxc_if.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2.1
                        final /* synthetic */ IOException tanxc_do;
                        final /* synthetic */ Call tanxc_if;

                        public AnonymousClass1(IOException iOException2, Call call2) {
                            iOException = iOException2;
                            call = call2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IOException iOException2 = iOException;
                            if (!(iOException2 instanceof SocketException)) {
                                UtErrorCode utErrorCode = iOException2 instanceof ConnectException ? UtErrorCode.NETWORK_CONNECT_EXCEPTION : iOException2 instanceof SocketTimeoutException ? UtErrorCode.NETWORK_TIMEOUT : UtErrorCode.NETWORK_ERROR;
                                LogUtils.i("OkHttp ", "请求失败原因 ==> " + LogUtils.getStackTraceMessage(iOException));
                                IOException iOException22 = iOException;
                                String str = "";
                                if (iOException22 != null && iOException22.getMessage() != null) {
                                    String message = iOException.getMessage();
                                    try {
                                        str = " --> " + call.request().url().uri().toString();
                                    } catch (Exception unused) {
                                    }
                                    str = message + str;
                                }
                                if (TextUtils.isEmpty(str)) {
                                    resultCall.onError(utErrorCode.getIntCode(), utErrorCode.getMsg());
                                } else {
                                    resultCall.onError(utErrorCode.getIntCode(), str);
                                }
                            }
                            LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                            resultCall.onAfter();
                        }
                    }, 10L);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            tanxc_if.this.tanxc_if();
            int code = response.code();
            LogUtils.i("OkHttp ", "请求code ==> " + code);
            if (response.isSuccessful()) {
                String string = response.body() != null ? response.body().string() : "";
                LogUtils.i("OkHttp ", string);
                ResultCall resultCall = resultCall;
                if (resultCall != null) {
                    resultCall.onSuccess(string);
                }
            } else {
                String response2 = response.toString();
                ResultCall resultCall2 = resultCall;
                if (resultCall2 != null) {
                    resultCall2.onError(code, UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
                }
            }
            LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
            tanxc_if.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2.2
                public RunnableC02142() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ResultCall resultCall3 = resultCall;
                    if (resultCall3 != null) {
                        resultCall3.onAfter();
                    }
                }
            }, 10L);
        }
    }

    public static /* synthetic */ int tanxc_for(tanxc_if tanxc_ifVar) {
        int i10 = tanxc_ifVar.tanxc_byte;
        tanxc_ifVar.tanxc_byte = i10 + 1;
        return i10;
    }

    public tanxc_if tanxc_do() {
        Request.Builder builder = new Request.Builder();
        Map<String, String> map = this.tanxc_int;
        if (map != null) {
            builder.url(tanxc_do(this.tanxc_do, map));
        } else {
            LogUtils.i("OkHttp ", "请求接口 ==>> " + this.tanxc_do);
            builder.url(this.tanxc_do);
        }
        if (!TextUtils.isEmpty(this.tanxc_if)) {
            builder.tag(this.tanxc_if);
        }
        builder.headers(tanxc_for(this.tanxc_for));
        this.tanxc_else = builder.build();
        return this;
    }

    public tanxc_if tanxc_for(int i10) {
        this.tanxc_try = i10;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_new) {
            if (TextUtils.isEmpty(this.tanxc_if)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_do);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
            }
        }
    }

    private Headers tanxc_for(Map<String, String> map) {
        Headers.Builder builder = new Headers.Builder();
        if (map == null || map.isEmpty()) {
            map = new HashMap<>();
            map.put("User-Agent", AndroidUtils.getUserAgent());
        }
        for (String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
        return builder.build();
    }

    public tanxc_if tanxc_if(int i10) {
        if (i10 != 0) {
            com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for.tanxc_do().tanxc_do(i10);
        }
        return this;
    }

    public tanxc_if tanxc_if(String str) {
        this.tanxc_if = str;
        return this;
    }

    public tanxc_if tanxc_if(Map<String, String> map) {
        this.tanxc_int = map;
        return this;
    }

    public void tanxc_do(ResultCall resultCall) {
        if (resultCall != null) {
            LogUtils.i("OkHttp ", "请求方式 ==> GET");
            this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.1
                final /* synthetic */ ResultCall tanxc_do;

                public AnonymousClass1(ResultCall resultCall2) {
                    resultCall = resultCall2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    resultCall.onBefore();
                }
            });
        }
        if (this.tanxc_new) {
            if (!TextUtils.isEmpty(this.tanxc_if)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                    if (resultCall2 != null) {
                        resultCall2.onError(UtErrorCode.NETWORK_ONLY_ONE_NET_ERROR_EXCEPTION.getIntCode(), "onlyOneNet error tag:" + this.tanxc_if);
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
            } else {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_do)) {
                    if (resultCall2 != null) {
                        resultCall2.onError(UtErrorCode.NETWORK_ONLY_ONE_NET_ERROR_EXCEPTION.getIntCode(), "onlyOneNet error url:" + this.tanxc_do);
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_do);
            }
        }
        this.tanxc_case.newCall(this.tanxc_else).enqueue(new Callback() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2
            final /* synthetic */ ResultCall tanxc_do;

            /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ IOException tanxc_do;
                final /* synthetic */ Call tanxc_if;

                public AnonymousClass1(IOException iOException2, Call call2) {
                    iOException = iOException2;
                    call = call2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IOException iOException2 = iOException;
                    if (!(iOException2 instanceof SocketException)) {
                        UtErrorCode utErrorCode = iOException2 instanceof ConnectException ? UtErrorCode.NETWORK_CONNECT_EXCEPTION : iOException2 instanceof SocketTimeoutException ? UtErrorCode.NETWORK_TIMEOUT : UtErrorCode.NETWORK_ERROR;
                        LogUtils.i("OkHttp ", "请求失败原因 ==> " + LogUtils.getStackTraceMessage(iOException));
                        IOException iOException22 = iOException;
                        String str = "";
                        if (iOException22 != null && iOException22.getMessage() != null) {
                            String message = iOException.getMessage();
                            try {
                                str = " --> " + call.request().url().uri().toString();
                            } catch (Exception unused) {
                            }
                            str = message + str;
                        }
                        if (TextUtils.isEmpty(str)) {
                            resultCall.onError(utErrorCode.getIntCode(), utErrorCode.getMsg());
                        } else {
                            resultCall.onError(utErrorCode.getIntCode(), str);
                        }
                    }
                    LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                    resultCall.onAfter();
                }
            }

            /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2$2 */
            public class RunnableC02142 implements Runnable {
                public RunnableC02142() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ResultCall resultCall3 = resultCall;
                    if (resultCall3 != null) {
                        resultCall3.onAfter();
                    }
                }
            }

            public AnonymousClass2(ResultCall resultCall2) {
                resultCall = resultCall2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call2, IOException iOException2) {
                if (!(iOException2 instanceof SocketException) && tanxc_if.this.tanxc_byte < tanxc_if.this.tanxc_try && tanxc_if.this.tanxc_try > 0) {
                    tanxc_if.tanxc_for(tanxc_if.this);
                    tanxc_if.this.tanxc_case.newCall(call2.request()).enqueue(this);
                } else {
                    tanxc_if.this.tanxc_if();
                    if (resultCall != null) {
                        tanxc_if.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2.1
                            final /* synthetic */ IOException tanxc_do;
                            final /* synthetic */ Call tanxc_if;

                            public AnonymousClass1(IOException iOException22, Call call22) {
                                iOException = iOException22;
                                call = call22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IOException iOException22 = iOException;
                                if (!(iOException22 instanceof SocketException)) {
                                    UtErrorCode utErrorCode = iOException22 instanceof ConnectException ? UtErrorCode.NETWORK_CONNECT_EXCEPTION : iOException22 instanceof SocketTimeoutException ? UtErrorCode.NETWORK_TIMEOUT : UtErrorCode.NETWORK_ERROR;
                                    LogUtils.i("OkHttp ", "请求失败原因 ==> " + LogUtils.getStackTraceMessage(iOException));
                                    IOException iOException222 = iOException;
                                    String str = "";
                                    if (iOException222 != null && iOException222.getMessage() != null) {
                                        String message = iOException.getMessage();
                                        try {
                                            str = " --> " + call.request().url().uri().toString();
                                        } catch (Exception unused) {
                                        }
                                        str = message + str;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        resultCall.onError(utErrorCode.getIntCode(), utErrorCode.getMsg());
                                    } else {
                                        resultCall.onError(utErrorCode.getIntCode(), str);
                                    }
                                }
                                LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                                resultCall.onAfter();
                            }
                        }, 10L);
                    }
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                tanxc_if.this.tanxc_if();
                int code = response.code();
                LogUtils.i("OkHttp ", "请求code ==> " + code);
                if (response.isSuccessful()) {
                    String string = response.body() != null ? response.body().string() : "";
                    LogUtils.i("OkHttp ", string);
                    ResultCall resultCall2 = resultCall;
                    if (resultCall2 != null) {
                        resultCall2.onSuccess(string);
                    }
                } else {
                    String response2 = response.toString();
                    ResultCall resultCall22 = resultCall;
                    if (resultCall22 != null) {
                        resultCall22.onError(code, UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
                    }
                }
                LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                tanxc_if.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.2.2
                    public RunnableC02142() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ResultCall resultCall3 = resultCall;
                        if (resultCall3 != null) {
                            resultCall3.onAfter();
                        }
                    }
                }, 10L);
            }
        });
    }

    public tanxc_if tanxc_do(int i10) {
        if (i10 != 0) {
            com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if.tanxc_do().tanxc_do(i10);
        }
        return this;
    }

    public tanxc_if tanxc_do(String str) {
        this.tanxc_do = str;
        return this;
    }

    public tanxc_if tanxc_do(boolean z10) {
        this.tanxc_new = z10;
        return this;
    }

    public tanxc_if tanxc_do(Map<String, String> map) {
        this.tanxc_for = map;
        return this;
    }

    private String tanxc_do(String str, Map<String, String> map) {
        StringBuilder sb2 = new StringBuilder();
        if (str.indexOf("?") == -1) {
            sb2.append(str + "?");
        } else {
            sb2.append(str + "&");
        }
        if (map != null && !map.isEmpty()) {
            for (String str2 : map.keySet()) {
                sb2.append(str2);
                sb2.append("=");
                sb2.append(map.get(str2));
                sb2.append("&");
            }
        }
        StringBuilder deleteCharAt = sb2.deleteCharAt(sb2.length() - 1);
        LogUtils.i("OkHttp ", "请求接口 ==>> " + deleteCharAt.toString());
        return deleteCharAt.toString();
    }
}
