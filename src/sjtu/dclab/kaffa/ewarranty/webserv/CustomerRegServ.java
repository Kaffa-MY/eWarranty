package sjtu.dclab.kaffa.ewarranty.webserv;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import sjtu.dclab.kaffa.ewarranty.domain.CustomerCard;
import sjtu.dclab.kaffa.ewarranty.util.ClassParse;
import sjtu.dclab.kaffa.ewarranty.util.NetConnection;

public class CustomerRegServ {
	private static final String servName = "register";
	private static final String hostUrl = "http://103.6.221.220:3000/api";
	private HttpResponse response;

	public JSONObject customerReg(CustomerCard customer) {
		HttpClient httpClient = NetConnection.createHttpClient();
		String url = hostUrl + "/" + servName;
		HttpPost httpPost = new HttpPost(url);
		
		JSONObject js = null;

		List<BasicNameValuePair> pairs = new LinkedList<BasicNameValuePair>();
		pairs.add(new BasicNameValuePair("name", customer.getName()));
		pairs.add(new BasicNameValuePair("password", customer.getPasswd()));
		pairs.add(new BasicNameValuePair("email", customer.getEmail()));
		pairs.add(new BasicNameValuePair("address", customer.getAddress()));
		pairs.add(new BasicNameValuePair("telephone", customer.getTel()));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
			response = httpClient.execute(httpPost);
			ClassParse classParse = new ClassParse();
			js = classParse.HttpEntity2JsonOB(response.getEntity());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return js;
	}
}
