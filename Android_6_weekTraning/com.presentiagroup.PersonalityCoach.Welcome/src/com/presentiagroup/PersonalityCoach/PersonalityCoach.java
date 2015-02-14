package com.presentiagroup.PersonalityCoach;
import android.provider.BaseColumns;
public final class PersonalityCoach 
{
	   private PersonalityCoach(){}
	    public static final class Friends implements BaseColumns
	    {
	    	private Friends(){}
	    	public static final String name = "name";
	    	public static final String type = "type";
	    	public static final String note = "note";
	    }
	    public static final class My implements BaseColumns
	    {
	    	private My(){}
	    	public static final String name = "name";
	    	public static final String type = "type";
	    	
	    }
	
}
