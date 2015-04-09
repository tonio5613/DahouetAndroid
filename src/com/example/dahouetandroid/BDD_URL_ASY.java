package com.example.dahouetandroid;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class BDD_URL_ASY extends AsyncTask<URL, Void, String>
{
	private Context context;
	
	
	String result_asy;
	
	public BDD_URL_ASY (Context context)
	{
		this.context=context;
	}
	
	public BDD_URL_ASY() {
		// TODO Auto-generated constructor stub
	}

	public String getResult_asy() {
		return result_asy;
	}
	public void setResult_asy(String result_asy) {
		this.result_asy = result_asy;
	}
	
	@Override
	protected String doInBackground(URL... urls) {
    	
    	return GET_URL(urls[0]);
    }
    // This is called each time you call publishProgress()
    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }

    @Override
    protected void onPostExecute(String result) {
		
  result_asy=result;
  //showDialog("Downloaded " + result + " bytes");
  //Toast.makeText(this., "The lastest version is " + result, Toast.LENGTH_SHORT).show();
    }

public static String GET_URL(URL urls){
	InputStream inputStream=null;
	    String result = null;
	    String statu=null;
	    int name=0;

	    	//URL Connection (RFC 2616)
	    	   try {
	    		 HttpURLConnection urlConnection = (HttpURLConnection) urls.openConnection();
	    		 //urlConnection.setDoOutput(true);
	    		// urlConnection.setChunkedStreamingMode(0);  
	    	   
	    		 inputStream = new BufferedInputStream(urlConnection.getInputStream());
	    		 
	    	    // readStream(inputStream);
	    	    
	        if(inputStream != null)
	        {
	        result = convertInputStreamToString(inputStream);

	        }
	        else
	            {
	              //  urlConnection.disconnect();
		            result = "Did not work!";

	            }

	    }
	    	   catch (Exception e) {
	        Log.d("InputStream: ", e.getLocalizedMessage());
	    }

	    return result;
}

private static String convertInputStreamToString(InputStream inputStream) throws IOException{
	
    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
    String line = "";
    String result = "";
    
    while((line = bufferedReader.readLine()) != null)
        result += line;

    inputStream.close();
    return result;

}
		

}
