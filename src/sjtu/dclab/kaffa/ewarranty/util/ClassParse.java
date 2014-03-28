package sjtu.dclab.kaffa.ewarranty.util;

import sjtu.dclab.kaffa.ewarranty.domain.AbstractCard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClassParse {
	private Gson gson;

	public ClassParse() {
		this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}
	
	public String card2String(AbstractCard card) {
		if (card != null) {
			String res = gson.toJson(card);
			return res;
		}else{
			return null;
		}
	}
}
