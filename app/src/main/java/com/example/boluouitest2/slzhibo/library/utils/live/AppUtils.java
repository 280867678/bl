package com.example.boluouitest2.slzhibo.library.utils.live;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.example.boluouitest2.slzhibo.library.Activity.SLLiveActivity;
import com.example.boluouitest2.slzhibo.library.service.TokenDialogService;
import com.example.boluouitest2.slzhibo.library.utils.UserInfoManager;

import java.util.List;

public class AppUtils {




    public static boolean isTokenInvalidErrorCode(int i) {
        return i == 101001;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void handlerTokenInvalid(Context context) {
        if (context instanceof SLLiveActivity) {
            startDialogService(context, TokenDialogService.class);
            ((SLLiveActivity) context).finish();
        } else if (!TextUtils.isEmpty(UserInfoManager.getInstance().getToken())) {
//            TokenInvalidDialog.newInstance().show(((FragmentActivity) context).getSupportFragmentManager());
            Toast.makeText(context.getApplicationContext(), "TokenInvalidDialog:::37::AppUtils", Toast.LENGTH_SHORT).show();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void startDialogService(Context context, Class<? extends IntentService> cls) {
        startDialogService(context, cls, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void startDialogService(Context context, Class<? extends IntentService> cls, String str) {
        if (!isRunBackground(context)) {
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                Intent intent = new Intent(context, cls);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("resultItem", str);
                }
                context.startService(intent);
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean isRunBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                return runningAppProcessInfo.importance == 400;
            }
        }
        return false;
    }

    public static boolean isToastAPIRequestErrorMsg(int i, String str) {
        return (TextUtils.isEmpty(str) || i == 30000 || i == 30001 || i == 200023 || i == 200163 || i == 300006 || i == 200166 || i == 200168 || i == 200111 || i == 200112 || i == 210024 || isExceptionErrorCode(i)) ? false : true;
    }

    public static boolean isExceptionErrorCode(int i) {
        return i == 1000 || i == 1001 || i == 2000;
    }
}
