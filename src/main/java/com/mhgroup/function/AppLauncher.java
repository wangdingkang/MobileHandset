package com.mhgroup.function;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Created by DK Wang on 2015/3/20.
 */
public class AppLauncher {

    private PackageManager packageManger;
    private List<ApplicationInfo> packages;
    public AppLauncher(Context context)
    {
        this.packageManger = context.getPackageManager();
        initPackageInfo();
    }

    public void initPackageInfo()
    {
        if(this.packageManger != null)
        {
            this.packages = packageManger.getInstalledApplications(packageManger.GET_META_DATA);
        }
    }


    public String getPackageName(String input)
    {
        String packageName = null;
        // find the app you want from the list


        return packageName;
    }



}
