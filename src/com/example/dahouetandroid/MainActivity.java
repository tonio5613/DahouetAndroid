package com.example.dahouetandroid;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Console;

import javax.xml.parsers.DocumentBuilderFactory;




import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.example.helloafpa.R;
import com.example.dahouetandroid.BDD_URL_ASY;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private List<String> ListReg = null;
	private String regate;
	private String strDevArr;
	private Double strMontant;
	private ImageView view;
	private Spinner spinner1;
	private static JSONObject json;
	private static JSONObject json2;
	private JSONArray jsonarray;
	private ArrayList<String> ListRegate;
	private ArrayAdapter<String> spinneradap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new ImageView(this);
		
		setContentView(R.layout.activity_main);
		
		ListRegate= new ArrayList<String>();
		ListRegate.add("");
	
  	  try
	    {
		//  HttpGet get =new HttpGet("http://cadorb.fr/dahouet/api/api.php?action=get&var=regate");
	 		    	
      	//List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(); //On crée la liste qui contiendra tous nos paramètres
      	 
      	//Et on y rajoute nos paramétres
      	//nameValuePairs.add(new BasicNameValuePair("", ));
      	//nameValuePairs.add(new BasicNameValuePair("trader_bank", mPhoneNumber));
         	//get.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	    	//get.
		  URL url=new URL("http://cadorb.fr/dahouet/api/api.php?action=get&var=regate");
		  
		  
		  BDD_URL_ASY bdd=(BDD_URL_ASY) new BDD_URL_ASY();
		  bdd.execute(url);	      		    	
		  }
		 catch (Exception e) {
			 Toast.makeText(getBaseContext(), "erreurs : "+e,
		        	 Toast.LENGTH_LONG).show();     		  
		 }	 
		
		//http://cadorb.fr/dahouet/api/api.php?action=get&var=regate
		 final Button bouton = (Button) findViewById(R.id.button1);
		 spinner1= (Spinner) findViewById(R.id.spinner1);

		 // On appelle sa méthode setOnClickListener()
		bouton.setOnClickListener((new View.OnClickListener() {
	        public void onClick(View v) {
	        	
		       	  
	    	}
		}));
	
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
	
	public class BDD_URL_ASY extends AsyncTask<URL, Void, String>
	{

	
		
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
							
	  try {

		json= new JSONObject(result);
		jsonarray = json.getJSONArray("reg");

		for(int i=0;i<jsonarray.length();i++)
		{
		
		Toast.makeText(getBaseContext(), "Tab: " + jsonarray.get(i).toString()
			, Toast.LENGTH_SHORT).show();
			
			json2=jsonarray.getJSONObject(i);
			
			String dat=json2.optString("REGID").toString();
	
				ListRegate.add(dat);
	

		}
spinneradap= new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, ListRegate);

		//http://cadorb.fr/dahouet/api/api.php?action=get&var=regate
		 
		 spinner1.setAdapter(spinneradap);
		
	} catch (Exception e) {
		Toast.makeText(getBaseContext(), "Erreur: " + e, Toast.LENGTH_SHORT).show();
		e.printStackTrace();
	}
	  
	  
	    }

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

	
}
