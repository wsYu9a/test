package com.martian.mibook.lib.account.response;

import ba.j;
import java.util.Date;

/* loaded from: classes3.dex */
public class MiVContributor {

    @j.a
    private String cont_header;

    @j.a
    private String cont_nickname;

    @j.a
    private Long cont_uid;

    @j.a
    private Date createdOn;

    public Long getContUid() {
        return this.cont_uid;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public String getHeader() {
        return this.cont_header;
    }

    public String getNickname() {
        return this.cont_nickname;
    }

    public void setContUid(Long l10) {
        this.cont_uid = l10;
    }

    public void setCreatedOn(Date date) {
        this.createdOn = date;
    }

    public void setHeader(String str) {
        this.cont_header = str;
    }

    public void setNickname(String str) {
        this.cont_nickname = str;
    }
}
