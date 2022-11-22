package com.example.boluouitest2.service;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.boluouitest2.bean.OpenScreenAdBean;
import com.example.boluouitest2.util.SpUtil;

import java.io.File;

public class DownloadAdImgService extends IntentService {

    public DownloadAdImgService() {
        super("DownloadAdImgService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        try {
            OpenScreenAdBean openScreenAdBean = (OpenScreenAdBean) intent.getParcelableExtra("open_screen_ad");
            if (openScreenAdBean != null && !TextUtils.isEmpty(openScreenAdBean.getImg_url())) {
                String img_url = openScreenAdBean.getImg_url();
                String substring = img_url.substring(img_url.lastIndexOf("/") + 1);
                File file = Glide.with(this).asFile().load(img_url).submit().get();
                if (file != null) {
                    String path = file.getPath();
                    boolean z = false;
                    String str = path.substring(0, path.lastIndexOf("/")) + File.separator + "ad";
                    File file2 = new File(str);
                    String str2 = str + File.separator + substring;
                    if ((!file2.exists() ? file2.mkdirs() : false) || file2.exists()) {
                        z = file.renameTo(new File(str2));
                    }
                    if (z) {
                        openScreenAdBean.setLocal_path(str2);
                        SpUtil.m9573D().m9538g(JSON.toJSONString(openScreenAdBean));
                    }
                }
            }
        } catch (Exception e) {
            Log.e(e.toString(),"哈哈");
        }
    }


}
