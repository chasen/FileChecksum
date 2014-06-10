package com.chasenoel.cordova.filechecksum;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class FileChecksum extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("getChecksum")){
            String filename = args.getString(0);
            this.getChecksum(filename,callbackContext);
            return true;
        }
        if(action.equals("getChecksums")){
            JSONArray files = args.getJSONArray(0);
            this.getChecksums(files,callbackContext);
            return true;
        }
        if(action.equals("compareFileToChecksum")){
            JSONObject filesAndChecksums = args.getJSONObject(0);
            this.compareFileToChecksum(args,callbackContext);
            return true;
        }
        return false;
    }
    
    private void getChecksum(String filename, CallbackContext callbackContext){
        
    }
    
    private void getChecksums(JSONArray files, CallbackContext callbackContext){
        
    }
    
    private void compareFileToChecksum(JSONObject filesAndChecksums, CallbackContext callbackContext){
        
    }
}
