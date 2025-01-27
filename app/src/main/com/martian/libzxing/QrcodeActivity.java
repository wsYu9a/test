package com.martian.libzxing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.qr_codescan.R;
import com.martian.libzxing.QrcodeActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import ma.b;

/* loaded from: classes3.dex */
public class QrcodeActivity extends Activity {

    /* renamed from: e */
    public static final String f13070e = "MARTIAN_QRCODE";

    /* renamed from: f */
    public static final String f13071f = "MARTIAN_TITLE";

    /* renamed from: b */
    public String f13072b = "";

    /* renamed from: c */
    public String f13073c = "";

    /* renamed from: d */
    public Bitmap f13074d;

    public static void e(Context context, Bitmap bitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Boohee");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getAbsolutePath())));
    }

    public static void g(Activity activity, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(f13070e, str2);
        bundle.putString(f13071f, str);
        Intent intent = new Intent(activity, (Class<?>) QrcodeActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public String b(String str) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString(str);
        }
        return null;
    }

    public final /* synthetic */ boolean c(View view) {
        d();
        return false;
    }

    public void d() {
        e(this, this.f13074d);
        Toast.makeText(this, "二维码已保存到相册", 0).show();
    }

    public void f(String str) {
        Toast.makeText(this, str, 0).show();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qrcode);
        if (bundle != null) {
            this.f13072b = bundle.getString(f13070e);
            this.f13073c = bundle.getString(f13071f);
        } else {
            this.f13072b = b(f13070e);
            this.f13073c = b(f13071f);
        }
        if (TextUtils.isEmpty(this.f13072b)) {
            f("获取二维码失败");
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(R.id.invite_title);
        ImageView imageView = (ImageView) findViewById(R.id.invite_qrcode);
        if (!TextUtils.isEmpty(this.f13073c)) {
            textView.setText(this.f13073c);
        }
        Bitmap a10 = b.a(this.f13072b);
        this.f13074d = a10;
        if (a10 == null || a10.isRecycled()) {
            f("获取二维码失败");
            finish();
        } else {
            imageView.setImageBitmap(this.f13074d);
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ma.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean c10;
                    c10 = QrcodeActivity.this.c(view);
                    return c10;
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f13074d;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(f13070e, this.f13072b);
        bundle.putString(f13071f, this.f13073c);
        super.onSaveInstanceState(bundle);
    }
}
