package com.modjk.game.exp;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Experience 
{
	public int before_level = 1;
    public float before_value_per = 0.0f;
    public int before_base_value = 0;
    public int before_next_value = 0;
    public int before_value = 0;
    
    public int after_level = 1;
    public float after_value_per = 0.0f;
    public int after_base_value = 0;
    public int after_next_value = 0;
    public int after_value = 0;
    
    public int level_up_count = 0;
    public int add_value = 0;
    
    public int min_value = 0;
    public int min_level = 1;
    
    public int max_value = 1;
    public int max_level = 1;

    // getJSONObject 절대 쓰지말것
 	public JSONObject toJSONObject()
	{
 		try
 		{
 			ObjectMapper mapper = new ObjectMapper();
 			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
 			return new JSONObject( mapper.writeValueAsString( this ) );
 		}
 		catch(Exception e)
 		{
 			return new JSONObject();
 		}
	}
}
