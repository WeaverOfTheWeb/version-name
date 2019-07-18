//
//  VersionName.java
//
//  Created by Alex Bonine 07/19/2012
//

package com.phonegap.plugins.versionname;

import org.json.JSONArray;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class VersionName extends CordovaPlugin {

    public final String ACTION_GET_VERSION_NAME = "getVersionName";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        boolean result = false;
        PackageManager packageManager = this.cordova.getActivity().getPackageManager();
        if(action.equals(ACTION_GET_VERSION_NAME)) {
            try {
                // PackageInfo packageInfo = packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0);
                PackageInfo packageInfo = packageManager.getPackageInfo(args.getString(0), 0);
                result = true;
                callbackContext.success(packageInfo.versionName);
            }
            catch (NameNotFoundException nnfe) {
                result = false;
                callbackContext.success(nnfe.getMessage());
            }
        
        }
        
        return result;
    }
}
