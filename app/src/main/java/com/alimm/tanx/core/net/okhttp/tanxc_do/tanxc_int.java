package com.alimm.tanx.core.net.okhttp.tanxc_do;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.net.okhttp.request.MyRequestBody;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.LogUtils;
import com.sigmob.sdk.base.k;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/* loaded from: classes.dex */
public class tanxc_int {
    private int tanxc_byte;
    private final OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    private final Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    private Pair<String, File>[] tanxc_do;
    private RequestBody tanxc_else;
    private String tanxc_for;
    private String tanxc_if;
    private Map<String, String> tanxc_int;
    private boolean tanxc_new;
    private int tanxc_try;

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$1 */
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

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$2 */
    public class AnonymousClass2 implements MyRequestBody.Listener {
        final /* synthetic */ ResultCall tanxc_do;

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ long tanxc_do;
            final /* synthetic */ long tanxc_if;

            public AnonymousClass1(long j10, long j11) {
                j10 = j10;
                j11 = j11;
            }

            @Override // java.lang.Runnable
            public void run() {
                ResultCall resultCall = resultCall;
                if (resultCall != null) {
                    resultCall.inProgress((j10 * 1.0f) / j11);
                }
                LogUtils.i("OkHttp ", "请求进度 ==> " + ((j10 * 1.0f) / j11));
            }
        }

        public AnonymousClass2(ResultCall resultCall) {
            resultCall = resultCall;
        }

        @Override // com.alimm.tanx.core.net.okhttp.request.MyRequestBody.Listener
        public void onRequestProgress(long j10, long j11) {
            tanxc_int.this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.2.1
                final /* synthetic */ long tanxc_do;
                final /* synthetic */ long tanxc_if;

                public AnonymousClass1(long j102, long j112) {
                    j10 = j102;
                    j11 = j112;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ResultCall resultCall = resultCall;
                    if (resultCall != null) {
                        resultCall.inProgress((j10 * 1.0f) / j11);
                    }
                    LogUtils.i("OkHttp ", "请求进度 ==> " + ((j10 * 1.0f) / j11));
                }
            });
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$3 */
    public class AnonymousClass3 extends MyRequestBody {
        public AnonymousClass3(RequestBody requestBody, MyRequestBody.Listener listener) {
            super(requestBody, listener);
        }

        @Override // com.alimm.tanx.core.net.okhttp.request.MyRequestBody, okhttp3.RequestBody
        /* renamed from: contentType */
        public MediaType getContentType() {
            return null;
        }

        @Override // com.alimm.tanx.core.net.okhttp.request.MyRequestBody, okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$4 */
    public class AnonymousClass4 implements Callback {
        final /* synthetic */ ResultCall tanxc_do;

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$4$1 */
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

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$4$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ResultCall resultCall = resultCall;
                if (resultCall != null) {
                    resultCall.onAfter();
                }
            }
        }

        public AnonymousClass4(ResultCall resultCall) {
            resultCall = resultCall;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (tanxc_int.this.tanxc_byte < tanxc_int.this.tanxc_try && tanxc_int.this.tanxc_try > 0) {
                tanxc_int.tanxc_int(tanxc_int.this);
                tanxc_int.this.tanxc_case.newCall(call.request()).enqueue(this);
            } else {
                tanxc_int.this.tanxc_if();
                if (resultCall != null) {
                    tanxc_int.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.4.1
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
            String str;
            tanxc_int.this.tanxc_if();
            int code = response.code();
            LogUtils.i("OkHttp ", "请求code ==> " + code);
            if (response.isSuccessful()) {
                if (response.body() == null || (str = response.body().string()) == null) {
                    str = "";
                }
                LogUtils.i("OkHttp ", str);
                ResultCall resultCall = resultCall;
                if (resultCall != null) {
                    resultCall.onSuccess(str);
                }
                LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                tanxc_int.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.4.2
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ResultCall resultCall2 = resultCall;
                        if (resultCall2 != null) {
                            resultCall2.onAfter();
                        }
                    }
                }, 10L);
                return;
            }
            String response2 = response.toString();
            ResultCall resultCall2 = resultCall;
            if (resultCall2 != null) {
                resultCall2.onError(code, UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
            }
        }
    }

    public static /* synthetic */ int tanxc_int(tanxc_int tanxc_intVar) {
        int i10 = tanxc_intVar.tanxc_byte;
        tanxc_intVar.tanxc_byte = i10 + 1;
        return i10;
    }

    public tanxc_int tanxc_do() {
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        Map<String, String> map = this.tanxc_int;
        if (map == null) {
            tanxc_do(type);
        } else {
            if (!map.isEmpty()) {
                for (String str : this.tanxc_int.keySet()) {
                    type.addFormDataPart(str, this.tanxc_int.get(str));
                }
            }
            tanxc_do(type);
        }
        this.tanxc_else = type.build();
        return this;
    }

    public tanxc_int tanxc_if(String str) {
        this.tanxc_for = str;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_new) {
            if (!TextUtils.isEmpty(this.tanxc_for)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_for);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
            }
        }
    }

    public void tanxc_do(ResultCall resultCall) {
        if (resultCall != null) {
            LogUtils.i("OkHttp ", "上传图片");
            LogUtils.i("OkHttp ", "请求开始");
            this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.1
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
            if (!TextUtils.isEmpty(this.tanxc_for)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_for)) {
                    return;
                } else {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_for);
                }
            } else if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                return;
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
            }
        }
        Request.Builder builder = new Request.Builder();
        builder.url(this.tanxc_if);
        if (!TextUtils.isEmpty(this.tanxc_for)) {
            builder.tag(this.tanxc_for);
        }
        LogUtils.i("OkHttp ", "请求接口 ==> " + this.tanxc_if);
        if (this.tanxc_int != null) {
            LogUtils.i("OkHttp ", "请求参数 ==> " + this.tanxc_int.toString());
        }
        new MyRequestBody(this.tanxc_else, new MyRequestBody.Listener() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.2
            final /* synthetic */ ResultCall tanxc_do;

            /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$2$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ long tanxc_do;
                final /* synthetic */ long tanxc_if;

                public AnonymousClass1(long j102, long j112) {
                    j10 = j102;
                    j11 = j112;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ResultCall resultCall = resultCall;
                    if (resultCall != null) {
                        resultCall.inProgress((j10 * 1.0f) / j11);
                    }
                    LogUtils.i("OkHttp ", "请求进度 ==> " + ((j10 * 1.0f) / j11));
                }
            }

            public AnonymousClass2(ResultCall resultCall2) {
                resultCall = resultCall2;
            }

            @Override // com.alimm.tanx.core.net.okhttp.request.MyRequestBody.Listener
            public void onRequestProgress(long j102, long j112) {
                tanxc_int.this.tanxc_char.post(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.2.1
                    final /* synthetic */ long tanxc_do;
                    final /* synthetic */ long tanxc_if;

                    public AnonymousClass1(long j1022, long j1122) {
                        j10 = j1022;
                        j11 = j1122;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ResultCall resultCall2 = resultCall;
                        if (resultCall2 != null) {
                            resultCall2.inProgress((j10 * 1.0f) / j11);
                        }
                        LogUtils.i("OkHttp ", "请求进度 ==> " + ((j10 * 1.0f) / j11));
                    }
                });
            }
        }) { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.3
            public AnonymousClass3(RequestBody requestBody, MyRequestBody.Listener listener) {
                super(requestBody, listener);
            }

            @Override // com.alimm.tanx.core.net.okhttp.request.MyRequestBody, okhttp3.RequestBody
            /* renamed from: contentType */
            public MediaType getContentType() {
                return null;
            }

            @Override // com.alimm.tanx.core.net.okhttp.request.MyRequestBody, okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
            }
        };
        builder.post(this.tanxc_else);
        this.tanxc_case.newCall(builder.build()).enqueue(new Callback() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.4
            final /* synthetic */ ResultCall tanxc_do;

            /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$4$1 */
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

            /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int$4$2 */
            public class AnonymousClass2 implements Runnable {
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ResultCall resultCall2 = resultCall;
                    if (resultCall2 != null) {
                        resultCall2.onAfter();
                    }
                }
            }

            public AnonymousClass4(ResultCall resultCall2) {
                resultCall = resultCall2;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call2, IOException iOException2) {
                if (tanxc_int.this.tanxc_byte < tanxc_int.this.tanxc_try && tanxc_int.this.tanxc_try > 0) {
                    tanxc_int.tanxc_int(tanxc_int.this);
                    tanxc_int.this.tanxc_case.newCall(call2.request()).enqueue(this);
                } else {
                    tanxc_int.this.tanxc_if();
                    if (resultCall != null) {
                        tanxc_int.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.4.1
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
                String str;
                tanxc_int.this.tanxc_if();
                int code = response.code();
                LogUtils.i("OkHttp ", "请求code ==> " + code);
                if (response.isSuccessful()) {
                    if (response.body() == null || (str = response.body().string()) == null) {
                        str = "";
                    }
                    LogUtils.i("OkHttp ", str);
                    ResultCall resultCall2 = resultCall;
                    if (resultCall2 != null) {
                        resultCall2.onSuccess(str);
                    }
                    LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                    tanxc_int.this.tanxc_char.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_int.4.2
                        public AnonymousClass2() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ResultCall resultCall22 = resultCall;
                            if (resultCall22 != null) {
                                resultCall22.onAfter();
                            }
                        }
                    }, 10L);
                    return;
                }
                String response2 = response.toString();
                ResultCall resultCall22 = resultCall;
                if (resultCall22 != null) {
                    resultCall22.onError(code, UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
                }
            }
        });
    }

    public tanxc_int tanxc_do(Pair<String, File>... pairArr) {
        this.tanxc_do = pairArr;
        return this;
    }

    public tanxc_int tanxc_do(String str) {
        this.tanxc_if = str;
        return this;
    }

    public tanxc_int tanxc_do(Map<String, String> map) {
        this.tanxc_int = map;
        return this;
    }

    public void tanxc_do(MultipartBody.Builder builder) {
        if (this.tanxc_do == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            Pair<String, File>[] pairArr = this.tanxc_do;
            if (i10 >= pairArr.length) {
                return;
            }
            Pair<String, File> pair = pairArr[i10];
            if (pair != null) {
                Object obj = pair.first;
                File file = (File) pair.second;
                file.getName();
                builder.addFormDataPart(k.f18193y, file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));
            }
            i10++;
        }
    }
}
