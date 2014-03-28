package sjtu.dclab.kaffa.ewarranty.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;

public class NetConnection {
	private static int TIMEOUT = 30 * 1000;
	
	private static HttpClient httpClient = null;
	
	public static HttpClient createHttpClient(){
		BasicHttpParams httpParams = new BasicHttpParams();
		httpParams.setParameter("charset", HTTP.UTF_8);//set charset
		HttpConnectionParams.setConnectionTimeout(httpParams, NetConnection.TIMEOUT);//set connection timeout
		HttpConnectionParams.setSoTimeout(httpParams, NetConnection.TIMEOUT);//set socket timeout waiting for data
		httpClient = new DefaultHttpClient(httpParams);
		
		return httpClient;
	}
}
