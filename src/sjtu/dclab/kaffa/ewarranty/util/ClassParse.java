package sjtu.dclab.kaffa.ewarranty.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.json.JSONObject;

import sjtu.dclab.kaffa.ewarranty.domain.AbstractCard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClassParse {
	private Gson gson;

	public ClassParse() {
		this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
	}

	public String card2String(AbstractCard card) {
		if (card != null) {
			String res = gson.toJson(card);
			return res;
		} else {
			return null;
		}
	}

	public JSONObject HttpEntity2JsonOB(HttpEntity entity) {
		JSONObject jso = null;
		
		try {
			InputStream inputStream = entity.getContent();
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			for (String line = reader.readLine(); line != null; line = reader
					.readLine()) {
				builder.append(line);
			}

			inputStream.close();
			String jsString = builder.toString();

			jso = new JSONObject(jsString);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jso;
	}
}
