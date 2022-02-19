package com.oseamiya.jsonparser;

import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser extends AndroidNonvisibleComponent {
  public JsonParser(ComponentContainer container) {
    super(container.$form());
  }
    @SimpleEvent
    public void OnException(String message, String errorFrom){
        EventDispatcher.dispatchEvent(this,"OnException", message,errorFrom);
    }
    @SimpleFunction
    public String GetArrayFromObject(String object, String name) {
      try {
          JSONObject jsonObject = new JSONObject(object);
          return jsonObject.getJSONArray(name).toString();
      } catch (JSONException exception){
          OnException(exception.getMessage(), "GetArrayFromObject");
          return "";
      }
    }
    @SimpleFunction
    public String GetStringFromObject(String object, String name) {
        try {
            JSONObject jsonObject = new JSONObject(object);
            return jsonObject.getString(name);
        } catch (JSONException exception){
            OnException(exception.getMessage(), "GetStringFromObject");
            return "";
        }
    }
    @SimpleFunction
    public String GetArrayFromArray(String array, int position){
        try {
            JSONArray jsonArray = new JSONArray(array);
            return jsonArray.getJSONArray(position - 1).toString();
        } catch (JSONException e) {
            OnException(e.getMessage(), "GetArrayFromArray");
            return "";
        }
    }
    @SimpleFunction
    public String GetObjectFromArray(String array, int position) {
      try {
          JSONArray jsonArray = new JSONArray(array);
          return jsonArray.getJSONObject(position - 1).toString();
      } catch (JSONException exception){
          OnException(exception.getMessage(), "GetObjectFromArray");
          return "";
      }
    }
    @SimpleFunction
    public String GetObjectFromObject(String object, String name) {
      try {
          JSONObject jsonObject = new JSONObject(object);
          return jsonObject.getJSONObject(name).toString();
      } catch (JSONException exception){
          OnException(exception.getMessage(), "GetObjectFromObject");
          return "";
      }
    }
    @SimpleFunction
    public boolean HasKey(String object, String key) {
        try {
            JSONObject jsonObject = new JSONObject(object);
            return jsonObject.has(key);
        } catch (JSONException exception){
            OnException(exception.getMessage(), "HasKey");
            return false;
        }
    }
    @SimpleFunction
    public int ArrayLength(String array) {
      try {
          JSONArray jsonArray = new JSONArray(array);
          return jsonArray.length();
      } catch (JSONException exception){
          OnException(exception.getMessage(), "ArrayLength");
          return -1;
      }
    }
}
