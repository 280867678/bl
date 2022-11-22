package com.example.boluouitest2.slzhibo.library.utils.live;

/* loaded from: classes2.dex */
public class ApiException extends Exception {
    public int code;
    public String msg;

    public ApiException(Throwable th, int i) {
        super(th);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public ApiException(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
