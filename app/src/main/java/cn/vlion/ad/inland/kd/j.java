package cn.vlion.ad.inland.kd;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.download.DownLoadDialogCallback;

/* loaded from: classes.dex */
public final class j extends Dialog {
    public j(Context context, DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
        super(context);
        a(downloadDialogInfo, downLoadDialogCallback);
    }

    public final void a(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
        if (downloadDialogInfo == null || downLoadDialogCallback == null) {
            try {
                dismiss();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                dismiss();
                return;
            }
        }
        setContentView(R.layout.vlion_cn_kd_layout_download_bottom_sheet);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        setCancelable(false);
        ImageView imageView = (ImageView) findViewById(R.id.icon);
        TextView textView = (TextView) findViewById(R.id.tv_name);
        TextView textView2 = (TextView) findViewById(R.id.tv_desc1);
        TextView textView3 = (TextView) findViewById(R.id.tv_desc2);
        Button button = (Button) findViewById(R.id.btn_cancel);
        textView.setText(downloadDialogInfo.getAppName());
        textView2.setText("版本号：" + downloadDialogInfo.getAppVer());
        textView3.setText("开发者：" + downloadDialogInfo.getDeveloperName());
        VlionKDAdapter.a(imageView, downloadDialogInfo.getIconUrl());
        findViewById(R.id.img_dismiss).setOnClickListener(new e(this, downLoadDialogCallback));
        button.setOnClickListener(new f(this, downLoadDialogCallback));
        findViewById(R.id.tv_function).setOnClickListener(new g(downLoadDialogCallback));
        findViewById(R.id.tv_permissions).setOnClickListener(new h(downLoadDialogCallback));
        findViewById(R.id.tv_privacy).setOnClickListener(new i(downLoadDialogCallback));
    }
}
