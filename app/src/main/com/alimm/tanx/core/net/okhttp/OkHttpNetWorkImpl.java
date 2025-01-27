package com.alimm.tanx.core.net.okhttp;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.net.bean.DownLoadRequestBean;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.AdNetWorkCallBack;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.net.okhttp.callback.OnUploadListener;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.bean.UtErrorBean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.EncryptUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.io.File;
import okhttp3.Response;

/* loaded from: classes.dex */
public class OkHttpNetWorkImpl<T> implements INetWork<T>, NotConfused {
    private static final String TAG = "OkHttpNetWorkImpl";
    long netTime = 0;

    /* renamed from: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl$1 */
    public class AnonymousClass1 implements ResultCall {
        final /* synthetic */ NetWorkCallBack tanxc_do;
        final /* synthetic */ Class tanxc_for;
        final /* synthetic */ boolean tanxc_if;

        public AnonymousClass1(NetWorkCallBack netWorkCallBack, boolean z10, Class cls) {
            netWorkCallBack = netWorkCallBack;
            z11 = z10;
            cls = cls;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void inProgress(float f10) {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onAfter() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onBefore() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onError(int i10, String str) {
            NetWorkCallBack netWorkCallBack = netWorkCallBack;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i10, "", str);
            }
            LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
            TanxBaseUt.utError(i10, OkHttpNetWorkImpl.TAG, str, "OkHttp");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onSuccess(String str) {
            NetWorkCallBack netWorkCallBack = netWorkCallBack;
            if (netWorkCallBack != 0) {
                try {
                    if (z11) {
                        netWorkCallBack.succ(JSON.parseObject(str, cls));
                    } else {
                        netWorkCallBack.succ(str);
                    }
                } catch (Exception e10) {
                    onError(UtErrorCode.NETWORK_ERROR.getIntCode(), e10.getMessage());
                    e10.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl$2 */
    public class AnonymousClass2 implements ResultCall {
        final /* synthetic */ long tanxc_do;
        final /* synthetic */ RequestBean tanxc_for;
        final /* synthetic */ NetWorkCallBack tanxc_if;
        final /* synthetic */ boolean tanxc_int;
        final /* synthetic */ Class tanxc_new;

        public AnonymousClass2(long j10, NetWorkCallBack netWorkCallBack, RequestBean requestBean, boolean z10, Class cls) {
            currentTimeMillis = j10;
            netWorkCallBack = netWorkCallBack;
            requestBean = requestBean;
            z10 = z10;
            cls = cls;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void inProgress(float f10) {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onAfter() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onBefore() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onError(int i10, String str) {
            OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
            LogUtils.d("splashTimeConsuming", "netTimeAll onError->" + OkHttpNetWorkImpl.this.netTime);
            NetWorkCallBack netWorkCallBack = netWorkCallBack;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i10, "", str);
            }
            LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
            TanxBaseUt.utNetError(i10, OkHttpNetWorkImpl.TAG, new UtErrorBean(requestBean, i10, str), "OkHttp");
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onSuccess(String str) {
            LogUtils.d(OkHttpNetWorkImpl.TAG, "当前线程post onSuccess：" + Thread.currentThread().getName());
            OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
            LogUtils.d("splashTimeConsuming", "netTimeAll onSuccess->" + OkHttpNetWorkImpl.this.netTime);
            LogUtils.d(OkHttpNetWorkImpl.TAG, str);
            if (netWorkCallBack != null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        onError(UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "response:" + str);
                    } else if (z10) {
                        LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp decrypt before-> " + str);
                        String decrypt = EncryptUtils.decrypt(str);
                        LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp decrypt -> " + decrypt);
                        if (TextUtils.isEmpty(decrypt)) {
                            onError(UtErrorCode.DECRYPT_ERROR.getIntCode(), "decrypt error:" + str);
                        } else {
                            OkHttpNetWorkImpl.this.succCallBack(cls, decrypt, netWorkCallBack);
                        }
                    } else {
                        OkHttpNetWorkImpl.this.succCallBack(cls, str, netWorkCallBack);
                        LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp noDecrypt-> " + str);
                    }
                } catch (Exception e10) {
                    onError(UtErrorCode.NETWORK_ERROR.getIntCode(), LogUtils.getStackTraceMessage(e10));
                    e10.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl$3 */
    public class AnonymousClass3 implements ResultCall {
        final /* synthetic */ OnUploadListener tanxc_do;

        public AnonymousClass3(OnUploadListener onUploadListener) {
            onUploadListener = onUploadListener;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void inProgress(float f10) {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onAfter() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onBefore() {
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onError(int i10, String str) {
            OnUploadListener onUploadListener = onUploadListener;
            if (onUploadListener != null) {
                onUploadListener.error(i10, str);
            }
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
        public void onSuccess(String str) {
            Log.d("", "");
            OnUploadListener onUploadListener = onUploadListener;
            if (onUploadListener != null) {
                onUploadListener.succ(str);
            }
        }
    }

    private String getTag(RequestBean requestBean, NetWorkCallBack netWorkCallBack) {
        return TextUtils.isEmpty(requestBean.getTag()) ? netWorkCallBack != null ? netWorkCallBack.getClass().toString() : "" : requestBean.getTag();
    }

    private boolean isNull(RequestBean requestBean, NetWorkCallBack netWorkCallBack) {
        if (requestBean != null) {
            return false;
        }
        if (netWorkCallBack == null) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.NETWORK_PARAM_ERROR;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void succCallBack(Class<T> cls, String str, NetWorkCallBack netWorkCallBack) {
        Object parseObject = JSON.parseObject(str, cls);
        LogUtils.d(TAG, "当前线程post succCallBack：" + Thread.currentThread().getName());
        if (netWorkCallBack instanceof AdNetWorkCallBack) {
            ((AdNetWorkCallBack) netWorkCallBack).succ(parseObject, str);
        } else {
            netWorkCallBack.succ(parseObject);
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void cancelOkHttpTag(String str) {
        if (!TextUtils.isEmpty(str)) {
            tanxc_do.tanxc_do().tanxc_do(str);
        } else {
            LogUtils.e("OkHttp ", "tag为空，无法cancelOkHttpTag");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "OkHttp ", "tag为空，无法cancelOkHttpTag", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        try {
            if (isNull(requestBean, onDownloadListener)) {
                return;
            }
            DownLoadRequestBean downLoadRequestBean = (DownLoadRequestBean) requestBean;
            tanxc_do.tanxc_byte().tanxc_for(downLoadRequestBean.getUrl()).tanxc_int(getTag(downLoadRequestBean, onDownloadListener)).tanxc_do(downLoadRequestBean.getPath()).tanxc_if(downLoadRequestBean.getFileName()).tanxc_do(downLoadRequestBean.isResume()).tanxc_do().tanxc_do(onDownloadListener);
        } catch (Exception e10) {
            LogUtils.e("sendHttpDownload", e10);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e10));
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        sendHttpGet(requestBean, cls, true, true, netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        sendHttpPost(requestBean, cls, true, netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls) {
        String string;
        if (requestBean == null) {
            return null;
        }
        try {
            Response tanxc_do = tanxc_do.tanxc_if(true).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(EncryptUtils.encrypt(requestBean.getJson(), false)).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(false);
            if (tanxc_do != null) {
                String str = "";
                if (tanxc_do.body() != null && (string = tanxc_do.body().string()) != null) {
                    str = string;
                }
                LogUtils.d(TAG, "result:->" + str);
                String decrypt = EncryptUtils.decrypt(str, false);
                if (!TextUtils.isEmpty(decrypt)) {
                    return (T) JSON.parseObject(decrypt, cls);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            LogUtils.e("sendSyncHttpPost2Gzip", e10);
        }
        return null;
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void uploadFile(RequestBean requestBean, File file, OnUploadListener onUploadListener) {
        try {
            if (isNull(requestBean, onUploadListener)) {
                return;
            }
            tanxc_do.tanxc_try().tanxc_do(requestBean.getUrl()).tanxc_if(requestBean.getTag()).tanxc_do(requestBean.getParams()).tanxc_do(new Pair<>(file.getName(), file)).tanxc_do().tanxc_do(new ResultCall() { // from class: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.3
                final /* synthetic */ OnUploadListener tanxc_do;

                public AnonymousClass3(OnUploadListener onUploadListener2) {
                    onUploadListener = onUploadListener2;
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void inProgress(float f10) {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onAfter() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onBefore() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onError(int i10, String str) {
                    OnUploadListener onUploadListener2 = onUploadListener;
                    if (onUploadListener2 != null) {
                        onUploadListener2.error(i10, str);
                    }
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onSuccess(String str) {
                    Log.d("", "");
                    OnUploadListener onUploadListener2 = onUploadListener;
                    if (onUploadListener2 != null) {
                        onUploadListener2.succ(str);
                    }
                }
            });
        } catch (Exception e10) {
            Log.e("sendHttpDownload", LogUtils.getStackTraceMessage(e10));
            if (onUploadListener2 != null) {
                UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
                onUploadListener2.error(utErrorCode.getIntCode(), utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e10));
            }
        }
    }

    private boolean isNull(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        if (requestBean != null) {
            return false;
        }
        if (onDownloadListener == null) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.NETWORK_PARAM_ERROR;
        onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), "downLoad接口请求参数判空:" + utErrorCode.getMsg());
        return true;
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(RequestBean requestBean, Class cls, boolean z10, boolean z11, NetWorkCallBack netWorkCallBack) {
        try {
            if (isNull(requestBean, netWorkCallBack)) {
                return;
            }
            tanxc_do.tanxc_new().tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_if(requestBean.getCacheOfflineTime()).tanxc_do(requestBean.getCacheOnlineTime()).tanxc_do(requestBean.isOnlyOneNet()).tanxc_for(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(new ResultCall() { // from class: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.1
                final /* synthetic */ NetWorkCallBack tanxc_do;
                final /* synthetic */ Class tanxc_for;
                final /* synthetic */ boolean tanxc_if;

                public AnonymousClass1(NetWorkCallBack netWorkCallBack2, boolean z112, Class cls2) {
                    netWorkCallBack = netWorkCallBack2;
                    z11 = z112;
                    cls = cls2;
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void inProgress(float f10) {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onAfter() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onBefore() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onError(int i10, String str) {
                    NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                    if (netWorkCallBack2 != null) {
                        netWorkCallBack2.error(i10, "", str);
                    }
                    LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
                    TanxBaseUt.utError(i10, OkHttpNetWorkImpl.TAG, str, "OkHttp");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onSuccess(String str) {
                    NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                    if (netWorkCallBack2 != 0) {
                        try {
                            if (z11) {
                                netWorkCallBack2.succ(JSON.parseObject(str, cls));
                            } else {
                                netWorkCallBack2.succ(str);
                            }
                        } catch (Exception e10) {
                            onError(UtErrorCode.NETWORK_ERROR.getIntCode(), e10.getMessage());
                            e10.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e10) {
            LogUtils.e("sendHttpGet", e10);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            netWorkCallBack2.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e10));
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(RequestBean requestBean, Class<T> cls, boolean z10, NetWorkCallBack netWorkCallBack) {
        long currentTimeMillis = System.currentTimeMillis();
        this.netTime = 0L;
        try {
            if (isNull(requestBean, netWorkCallBack)) {
                return;
            }
            LogUtils.d(TAG, "当前线程post：" + Thread.currentThread().getName());
            tanxc_do.tanxc_if(false).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(z10 ? EncryptUtils.encrypt(requestBean.getJson()) : requestBean.getJson()).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(new ResultCall() { // from class: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.2
                final /* synthetic */ long tanxc_do;
                final /* synthetic */ RequestBean tanxc_for;
                final /* synthetic */ NetWorkCallBack tanxc_if;
                final /* synthetic */ boolean tanxc_int;
                final /* synthetic */ Class tanxc_new;

                public AnonymousClass2(long currentTimeMillis2, NetWorkCallBack netWorkCallBack2, RequestBean requestBean2, boolean z102, Class cls2) {
                    currentTimeMillis = currentTimeMillis2;
                    netWorkCallBack = netWorkCallBack2;
                    requestBean = requestBean2;
                    z10 = z102;
                    cls = cls2;
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void inProgress(float f10) {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onAfter() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onBefore() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onError(int i10, String str) {
                    OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
                    LogUtils.d("splashTimeConsuming", "netTimeAll onError->" + OkHttpNetWorkImpl.this.netTime);
                    NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                    if (netWorkCallBack2 != null) {
                        netWorkCallBack2.error(i10, "", str);
                    }
                    LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
                    TanxBaseUt.utNetError(i10, OkHttpNetWorkImpl.TAG, new UtErrorBean(requestBean, i10, str), "OkHttp");
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onSuccess(String str) {
                    LogUtils.d(OkHttpNetWorkImpl.TAG, "当前线程post onSuccess：" + Thread.currentThread().getName());
                    OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
                    LogUtils.d("splashTimeConsuming", "netTimeAll onSuccess->" + OkHttpNetWorkImpl.this.netTime);
                    LogUtils.d(OkHttpNetWorkImpl.TAG, str);
                    if (netWorkCallBack != null) {
                        try {
                            if (TextUtils.isEmpty(str)) {
                                onError(UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "response:" + str);
                            } else if (z10) {
                                LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp decrypt before-> " + str);
                                String decrypt = EncryptUtils.decrypt(str);
                                LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp decrypt -> " + decrypt);
                                if (TextUtils.isEmpty(decrypt)) {
                                    onError(UtErrorCode.DECRYPT_ERROR.getIntCode(), "decrypt error:" + str);
                                } else {
                                    OkHttpNetWorkImpl.this.succCallBack(cls, decrypt, netWorkCallBack);
                                }
                            } else {
                                OkHttpNetWorkImpl.this.succCallBack(cls, str, netWorkCallBack);
                                LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp noDecrypt-> " + str);
                            }
                        } catch (Exception e10) {
                            onError(UtErrorCode.NETWORK_ERROR.getIntCode(), LogUtils.getStackTraceMessage(e10));
                            e10.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e10) {
            LogUtils.e("sendHttpPost", e10);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            netWorkCallBack2.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e10));
        }
    }

    private String getTag(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        if (!TextUtils.isEmpty(requestBean.getTag())) {
            return requestBean.getTag();
        }
        if (onDownloadListener != null) {
            return onDownloadListener.getClass().toString();
        }
        return "";
    }

    private boolean isNull(RequestBean requestBean, OnUploadListener onUploadListener) {
        if (requestBean != null) {
            return false;
        }
        if (onUploadListener == null) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.NETWORK_PARAM_ERROR;
        onUploadListener.error(utErrorCode.getIntCode(), "downLoad接口请求参数判空:" + utErrorCode.getMsg());
        return true;
    }

    private String getTag(RequestBean requestBean) {
        if (TextUtils.isEmpty(requestBean.getTag())) {
            return System.currentTimeMillis() + "";
        }
        return requestBean.getTag();
    }
}
