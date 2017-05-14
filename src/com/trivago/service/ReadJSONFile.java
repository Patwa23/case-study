package com.trivago.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.trivago.model.HotelInfo;
import com.trivago.model.Hotel;
import com.trivago.model.Ratings;
import com.trivago.model.Reviews;

public class ReadJSONFile {

	public List<Hotel> readAllFile() {
		List<Hotel> list=new ArrayList<Hotel>();
		
		String localPath="C:\\Users\\n83667\\MyJavaWorkspace";			
		Hotel hotelreview1=readReviewFile(localPath+"\\trivago\\resources\\review\\reviews1.json");
		list.add(hotelreview1);
		Hotel hotelreview2=readReviewFile(localPath+"\\trivago\\resources\\review\\reviews2.json");
		list.add(hotelreview2);
		Hotel hotelreview3=readReviewFile(localPath+"\\trivago\\resources\\review\\reviews3.json");
		list.add(hotelreview3);
		Hotel hotelreview4=readReviewFile(localPath+"\\trivago\\resources\\review\\reviews4.json");
		list.add(hotelreview4);
		Hotel hotelreview5=readReviewFile(localPath+"\\trivago\\resources\\review\\reviews5.json");
		list.add(hotelreview5);	
		return list;

    }

	// Method to read the review file from Source.
	public  Hotel readReviewFile(String fileSource) {
		Hotel hotelReview=new Hotel();
		JSONParser parser = new JSONParser();	
        try {
        
            Object obj = parser.parse(new FileReader(fileSource));
            // creating JSONObject
            JSONObject jsonObject = (JSONObject) obj;

            //creating JSONArray of Reviews
            JSONArray reviewArray = (JSONArray) jsonObject.get("Reviews");           
            Iterator<JSONObject> iterator = reviewArray.iterator();
            //Iterating the attribute of Reviews
            JSONObject reviewObject=null;
            List<Reviews> reviewList=new ArrayList<Reviews>();
            HotelInfo hotelInfoObj=null;
            hotelInfoObj=parseHotelInfo(jsonObject,hotelInfoObj);
            while (iterator.hasNext()) { 
            	// creating JSONObject of review 
            	Reviews reviews=new Reviews();
            	reviews=parseReview(iterator,reviews,hotelInfoObj); 
            	reviewList.add(reviews);
            }
            hotelReview.setReview(reviewList);
            
            hotelReview.setHotelInfo(hotelInfoObj);
            
            
       
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();  
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return hotelReview;
	}

	/**
	 * @param iterator
	 * @param hotelInfoObj 
	 * @throws java.text.ParseException 
	 */
	public Reviews parseReview(Iterator<JSONObject> iterator,Reviews reviews, HotelInfo hotelInfoObj) throws java.text.ParseException {
		JSONObject reviewObject;
		reviewObject= iterator.next();           	           			
		JSONObject ratingObj=(JSONObject) reviewObject.get("Ratings");
		//System.out.println(ratingObj.containsKey("Business service (e.g., internet access)"));
		
		Ratings ratings =new Ratings(ratingObj.containsKey("Service")?Integer.parseInt((String) ratingObj.get("Service")):0, 
				ratingObj.containsKey("Cleanliness")?Integer.parseInt((String) ratingObj.get("Cleanliness")):0, 
				ratingObj.containsKey("Business service (e.g., internet access)")?Integer.parseInt((String) ratingObj.get("Business service (e.g., internet access)")):0, 
				ratingObj.containsKey("Check in / front desk")? Integer.parseInt((String) ratingObj.get("Check in / front desk")):0, 
				ratingObj.containsKey("Overall")?Float.parseFloat((String) ratingObj.get("Overall")):0, 
				ratingObj.containsKey("Value")?Integer.parseInt((String) ratingObj.get("Value")):0, 
				ratingObj.containsKey("Rooms")?Integer.parseInt((String) ratingObj.get("Rooms")):0, 
				ratingObj.containsKey("Location")?Integer.parseInt((String) ratingObj.get("Location")):0);
		
		String string =(String) reviewObject.get("Date");
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(string);
		             
		 reviews=new Reviews(ratings, (String) reviewObject.get("AuthorLocation"), 
				(String) reviewObject.get("Title"), 
				(String) reviewObject.get("Author"),
				(String) reviewObject.get("ReviewID"),
				(String) reviewObject.get("Content"),
				date);
		 String localPath="C:\\Users\\n83667\\MyJavaWorkspace";	
		 readSematicFile(localPath+"\\trivago\\resources\\review\\semantics.json",(String) reviewObject.get("Content"),hotelInfoObj);
		return reviews;
	}
	/**
	 * @param jsonObject
	 */
	public HotelInfo parseHotelInfo(JSONObject jsonObject, HotelInfo hotelInfoObj) {
		JSONObject hotelInfoJSONObj = (JSONObject) jsonObject.get("HotelInfo"); 
		 hotelInfoObj=new HotelInfo((String) hotelInfoJSONObj.get("Name"),
											(String) hotelInfoJSONObj.get("HotelURL"), 
											(String) hotelInfoJSONObj.get("Price"), 
											(String) hotelInfoJSONObj.get("Address"),
											(String) hotelInfoJSONObj.get("HotelID"),
											(String) hotelInfoJSONObj.get("ImgURL"));
		return hotelInfoObj;
	}
	
	private void readSematicFile(String fileSource, String reviewContent, HotelInfo hotelInfoObj) {
		JSONParser parser = new JSONParser();
		// creating JSONObject
            
			try {
				Object obj = parser.parse(new FileReader(fileSource));
				JSONObject jsonObject = (JSONObject) obj;				
				Map<String, Object> positiveMap=parseSemantics(jsonObject,"positive");
				Map<String, Object> negativeMap=parseSemantics(jsonObject,"negative");
				Map<String, Object> intensifierMap=parseSemantics(jsonObject,"intensifier");
				findAndUpdateSemantic(positiveMap,reviewContent,hotelInfoObj,"positive");
				findAndUpdateSemantic(negativeMap,reviewContent,hotelInfoObj,"negative");
				findAndUpdateSemantic(intensifierMap,reviewContent,hotelInfoObj,"intensifier");
				
				
			} catch (IOException | org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


	private Map<String, Object> parseSemantics(JSONObject jsonObject, String string) {		
		JSONArray topicArray = (JSONArray) jsonObject.get(string);
		Map<String, Object> topicMap=new HashMap<String,Object>();
		 Iterator<JSONObject> iterator = topicArray.iterator(); 	 
		 if(string.equalsIgnoreCase("intensifier")){
			 while (iterator.hasNext()) { 
		         	// creating JSONObject of review 	         	
		         	JSONObject topicJSONObj = iterator.next();	
		         	topicMap.put((String)topicJSONObj.get("phrase"),topicJSONObj.get("multiplier"));
		         		         			         	
		         }			 
		 }else{
			 while (iterator.hasNext()) { 
		         	// creating JSONObject of review 	         	
		         	JSONObject topicJSONObj = iterator.next();		         	
		         	topicMap.put((String)topicJSONObj.get("phrase"),topicJSONObj.get("value"));
		         }				 
		 }	
		return topicMap;
		
	}
	
	private void findAndUpdateSemantic(Map<String, Object> topicMap, String reviewContent, HotelInfo hotelInfoObj,
			String string) {

		
		
		for (Entry<String, Object> entry : topicMap.entrySet()) {
			boolean isWordFound = isContainExactWord(reviewContent, entry.getKey());
			if(isWordFound & string.equalsIgnoreCase("positive")){
				System.out.println(entry.getKey());
				hotelInfoObj.setPositive(hotelInfoObj.getPositive()+(int)((long)entry.getValue()));
				System.out.println(hotelInfoObj.getPositive());
			}
			else if(isWordFound & string.equalsIgnoreCase("negative")){	
				System.out.println(entry.getKey());
				hotelInfoObj.setNegative(hotelInfoObj.getNegative()+(int)((long)entry.getValue()));
				System.out.println(hotelInfoObj.getNegative());
			}
			else if(isWordFound & string.equalsIgnoreCase("intensifier")){
				System.out.println(entry.getKey());
				String str = entry.getValue().toString(); 
				double d = Double.valueOf(str).doubleValue();
				hotelInfoObj.setIntensifier(hotelInfoObj.getIntensifier()+d);
				System.out.println(hotelInfoObj.getIntensifier());
				//System.out.println(d);
			}		
		}
			
	}

	private boolean isContainExactWord(String fullString, String partWord) {
	    String pattern = "\\b"+partWord.toUpperCase()+"\\b";
	    Pattern p=Pattern.compile(pattern);
	    Matcher m=p.matcher(fullString.toUpperCase());
	    return m.find();
	}


}
