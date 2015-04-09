package com.example.dahouetandroid;

import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class Regate {
	String REGID;
	int CHALID;
	int COMMIID;
	int REGNUM;
	Date REGDATE;
	int REGLONG;
	Time REGDEP;
	Time REGARR;
	Time ARRPREMS;
	Time ARRDER;
	String DIRVENT;
	int INTVENT;
	String SENSCRT;
	int VITCRT;
	String ETATMER;
	int CAPDEP;
	String LONGBORD;
	
	public String getREGID() {
		return REGID;
	}
	public void setREGID(String rEGID) {
		REGID = rEGID;
	}
	public int getCHALID() {
		return CHALID;
	}
	public void setCHALID(int cHALID) {
		CHALID = cHALID;
	}
	public int getCOMMIID() {
		return COMMIID;
	}
	public void setCOMMIID(int cOMMIID) {
		COMMIID = cOMMIID;
	}
	public int getREGNUM() {
		return REGNUM;
	}
	public void setREGNUM(int rEGNUM) {
		REGNUM = rEGNUM;
	}
	public Date getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Date rEGDATE) {
		REGDATE = rEGDATE;
	}
	public int getREGLONG() {
		return REGLONG;
	}
	public void setREGLONG(int rEGLONG) {
		REGLONG = rEGLONG;
	}
	public Time getREGDEP() {
		return REGDEP;
	}
	public void setREGDEP(Time rEGDEP) {
		REGDEP = rEGDEP;
	}
	public Time getREGARR() {
		return REGARR;
	}
	public void setREGARR(Time rEGARR) {
		REGARR = rEGARR;
	}
	public Time getARRPREMS() {
		return ARRPREMS;
	}
	public void setARRPREMS(Time aRRPREMS) {
		ARRPREMS = aRRPREMS;
	}
	public Time getARRDER() {
		return ARRDER;
	}
	public void setARRDER(Time aRRDER) {
		ARRDER = aRRDER;
	}
	public String getDIRVENT() {
		return DIRVENT;
	}
	public void setDIRVENT(String dIRVENT) {
		DIRVENT = dIRVENT;
	}
	public int getINTVENT() {
		return INTVENT;
	}
	public void setINTVENT(int iNTVENT) {
		INTVENT = iNTVENT;
	}
	public String getSENSCRT() {
		return SENSCRT;
	}
	public void setSENSCRT(String sENSCRT) {
		SENSCRT = sENSCRT;
	}
	public int getVITCRT() {
		return VITCRT;
	}
	public void setVITCRT(int vITCRT) {
		VITCRT = vITCRT;
	}
	public String getETATMER() {
		return ETATMER;
	}
	public void setETATMER(String eTATMER) {
		ETATMER = eTATMER;
	}
	public int getCAPDEP() {
		return CAPDEP;
	}
	public void setCAPDEP(int cAPDEP) {
		CAPDEP = cAPDEP;
	}
	public String getLONGBORD() {
		return LONGBORD;
	}
	public void setLONGBORD(String lONGBORD) {
		LONGBORD = lONGBORD;
	}
	
	public static String GET(HttpGet urls){
    	InputStream inputStream=null;
    	    String result = null;
    	    String statu=null;
    	    int name=0;
    	    try {

    	        // create HttpClient
    	        HttpClient httpclient = new DefaultHttpClient();  
    	        // make GET request to the given URL
    	        HttpResponse httpResponse = httpclient.execute(urls);
    	        
    	        Log.i("Dahouet_statu",statu=httpResponse.getStatusLine().toString());
    	        
    	        HttpEntity entity = httpResponse.getEntity();

    	        if (entity != null) 
    	        {
    	        inputStream=entity.getContent();	
    	        }
    	        if(inputStream != null)
    	        {
    	        // result = convertInputStreamToString(inputStream);
    	    
    	        }
    	        else
    	            result = "Did not work!";

    	    } catch (Exception e) {
    	        Log.d("InputStream: ", e.getLocalizedMessage());
    	    }

    	    return result;
    	}
	

}
