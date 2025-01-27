package com.martian.mibook.application;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.data.TypefaceItem;
import com.martian.ttbookhd.R;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class TypefaceManager {

    /* renamed from: a */
    public static final String f11351a = "mibook_typeface.json";

    /* renamed from: b */
    public static final String f11352b = com.martian.libmars.d.h.f9883b + "/pinery/mibook/";

    /* renamed from: c */
    private final Context f11353c;

    /* renamed from: d */
    public LinkedList<String> f11354d = null;

    /* renamed from: e */
    private boolean f11355e = false;

    class a extends com.google.gson.b.a<LinkedList<String>> {
        a() {
        }
    }

    public TypefaceManager(Context context) {
        this.f11353c = context;
    }

    private LinkedList<String> f(String json) {
        LinkedList<String> linkedList = (LinkedList) GsonUtils.a().fromJson(json, new a().getType());
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            if (TextUtils.isEmpty(listIterator.next())) {
                listIterator.remove();
            }
        }
        return linkedList;
    }

    private LinkedList<String> i() throws IOException {
        String B = com.martian.libsupport.e.B(this.f11353c, f11351a);
        this.f11355e = false;
        return f(B);
    }

    public void a() {
        com.martian.libsupport.e.p(this.f11353c, f11351a);
        com.martian.libsupport.e.o(f11352b + f11351a);
        LinkedList<String> linkedList = this.f11354d;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    public void b(String filepath) {
        LinkedList<String> e2 = e();
        this.f11354d = e2;
        e2.remove(filepath);
        this.f11355e = true;
        try {
            c();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void c() throws IOException {
        if (this.f11355e) {
            com.martian.libsupport.e.E(this.f11353c, f11351a, new Gson().toJson(this.f11354d));
        }
    }

    public LinkedList<TypefaceItem> d() {
        LinkedList<TypefaceItem> linkedList = new LinkedList<>();
        TypefaceItem typefaceItem = new TypefaceItem();
        typefaceItem.setType(0);
        linkedList.add(typefaceItem);
        LinkedList<String> e2 = e();
        if (e2 != null && !e2.isEmpty()) {
            for (int size = e2.size() - 1; size >= 0; size--) {
                String str = e2.get(size);
                if (!com.martian.libsupport.k.p(str) && new File(str).exists()) {
                    TypefaceItem typefaceItem2 = new TypefaceItem();
                    typefaceItem2.setFilePath(str);
                    typefaceItem2.setType(2);
                    linkedList.add(typefaceItem2);
                }
            }
        }
        TypefaceItem typefaceItem3 = new TypefaceItem();
        String str2 = com.martian.libmars.d.h.F().u() + "SourceHanSerifCN-Regular.ttf";
        String str3 = com.martian.libmars.d.h.F().u() + this.f11353c.getString(R.string.typeface_sysong) + ".zip";
        typefaceItem3.setType(1);
        typefaceItem3.setDownloadUrl("https://mibook-1251592799.file.myqcloud.com/font/SourceHanSerifCN-Regular.zip");
        typefaceItem3.setDownloadPath(str3);
        typefaceItem3.setFilePath(str2);
        typefaceItem3.setRes(R.drawable.typeface_sysong);
        typefaceItem3.setFileSize("7.26M");
        linkedList.add(typefaceItem3);
        TypefaceItem typefaceItem4 = new TypefaceItem();
        String str4 = com.martian.libmars.d.h.F().u() + "GenJyuuGothic-Regular-2.ttf";
        String str5 = com.martian.libmars.d.h.F().u() + this.f11353c.getString(R.string.typeface_syrouhei) + ".zip";
        typefaceItem4.setType(1);
        typefaceItem4.setDownloadUrl("https://mibook-1251592799.file.myqcloud.com/font/GenJyuuGothic-Regular-2.zip");
        typefaceItem4.setDownloadPath(str5);
        typefaceItem4.setFilePath(str4);
        typefaceItem4.setRes(R.drawable.typeface_syrou);
        typefaceItem4.setFileSize("4.87M");
        linkedList.add(typefaceItem4);
        TypefaceItem typefaceItem5 = new TypefaceItem();
        String str6 = com.martian.libmars.d.h.F().u() + "yrdz.ttf";
        String str7 = com.martian.libmars.d.h.F().u() + this.f11353c.getString(R.string.typeface_yrdz) + ".zip";
        typefaceItem5.setType(1);
        typefaceItem5.setDownloadUrl("https://mibook-1251592799.file.myqcloud.com/font/yrdz.zip");
        typefaceItem5.setDownloadPath(str7);
        typefaceItem5.setFilePath(str6);
        typefaceItem5.setRes(R.drawable.typeface_yrdz);
        typefaceItem5.setFileSize("2.26M");
        linkedList.add(typefaceItem5);
        TypefaceItem typefaceItem6 = new TypefaceItem();
        String str8 = com.martian.libmars.d.h.F().u() + "SIMKAI(1).ttf";
        String str9 = com.martian.libmars.d.h.F().u() + this.f11353c.getString(R.string.typeface_kai) + ".zip";
        typefaceItem6.setType(1);
        typefaceItem6.setDownloadUrl("https://mibook-1251592799.file.myqcloud.com/font/SIMKAI.zip");
        typefaceItem6.setDownloadPath(str9);
        typefaceItem6.setFilePath(str8);
        typefaceItem6.setRes(R.drawable.typeface_kai);
        typefaceItem6.setFileSize("6.42M");
        linkedList.add(typefaceItem6);
        return linkedList;
    }

    public LinkedList<String> e() {
        if (this.f11354d == null) {
            try {
                this.f11354d = i();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f11354d == null) {
            this.f11354d = new LinkedList<>();
        }
        return this.f11354d;
    }

    public boolean g(String filepath) {
        if (com.martian.libsupport.k.p(filepath)) {
            return false;
        }
        LinkedList<String> e2 = e();
        this.f11354d = e2;
        Iterator<String> it = e2.iterator();
        while (it.hasNext()) {
            if (filepath.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void h(String item) {
        LinkedList<String> linkedList = this.f11354d;
        if (linkedList == null) {
            this.f11354d = new LinkedList<>();
        } else {
            linkedList.remove(item);
        }
        this.f11354d.addFirst(item);
        this.f11355e = true;
    }

    public void j(String item) {
        LinkedList<String> linkedList = this.f11354d;
        if (linkedList == null) {
            this.f11354d = new LinkedList<>();
        } else {
            linkedList.remove(item);
        }
        this.f11355e = true;
    }

    public boolean k(List<String> favorList) {
        if (favorList == null || favorList.isEmpty()) {
            return false;
        }
        LinkedList<String> e2 = e();
        this.f11354d = e2;
        e2.addAll(favorList);
        this.f11355e = true;
        try {
            c();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        this.f11355e = false;
        return true;
    }

    public void l() {
        try {
            this.f11354d = i();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
