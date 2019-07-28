import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonHelper {
	
	public ArrayList<Object> getAllParentChildNodeByKey(JSONObject jObject, String keyNode) {
		class ScanAllNode {
			ArrayList<Object> result = new ArrayList<Object>();
			public ArrayList<Object> checkAllNodeByKey(JSONObject jObject, String keyNode) {
				Iterator<String> iterator = jObject.keys();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					Object value = null;

					try {
						if (jObject.get(key) instanceof JSONArray) {
							JSONArray jsonArray = jObject.getJSONArray(key);
							jsonArray.forEach(item -> {
								checkAllNodeByKey((JSONObject) item, keyNode);
							});
						} else if (jObject.get(key) instanceof JSONObject) {
							JSONObject jsonValue = jObject.getJSONObject(key);
							checkAllNodeByKey(jsonValue, keyNode);
						} else {
							// value = jObject.get(key);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}

					if (key.equals(keyNode)) {
						value = jObject.get(key);
						result.add(value);
					}
				}
				return result;
			}
		}
		return new ScanAllNode().checkAllNodeByKey(jObject, keyNode);
	}
	
	
}
