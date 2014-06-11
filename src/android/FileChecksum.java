package com.chasenoel.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.util.Log;

public class FileChecksum extends CordovaPlugin {
    
    private static final String TAG = "FileChecksum";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, "Got a call to execute");
        if(action.equals("getChecksum")){
            Log.i(TAG, "getChecksum");
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
            this.compareFileToChecksum(filesAndChecksums, callbackContext);
            return true;
        }
        return false;
    }
    
    private void getChecksum(String filename, CallbackContext callbackContext){
        Log.i(TAG, "getChecksum inner");
        try{
            String hash = sha1Checksum(filename);
            callbackContext.success(hash);
        }
        catch(Exception e){
            callbackContext.error(e.getMessage());
        }
    }
    
    private void getChecksums(JSONArray files, CallbackContext callbackContext){
        
    }
    
    private void compareFileToChecksum(JSONObject filesAndChecksums, CallbackContext callbackContext){
        
    }
    
    private String sha1Checksum(String file) throws FileNotFoundException,NoSuchAlgorithmException,IOException{
        Log.i(TAG, "sha1Checksum");
        MessageDigest md = MessageDigest.getInstance("SHA1");
        FileInputStream fis = new FileInputStream(file);
        byte[] dataBytes = new byte[1024];

        int nread = 0; 

        while ((nread = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        };

        byte[] mdbytes = md.digest();

        //convert the byte to hex format
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < mdbytes.length; i++) {
            sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        Log.i(TAG, "sha1Checksum: "+sb.toString());
        return sb.toString();
    }
}
