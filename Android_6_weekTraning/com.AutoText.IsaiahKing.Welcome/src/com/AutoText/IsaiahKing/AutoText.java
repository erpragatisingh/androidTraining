package com.AutoText.IsaiahKing;

import android.provider.BaseColumns;



public final class AutoText
{
    private AutoText(){}
    
    
    public static final class MessageTemplate implements BaseColumns
    {
    	private MessageTemplate(){}
    	public static final String DEFAULT_SORT_ORDER = "modified DESC";
    	public static final String MessageText = "message";
    	public static final String CREATED_DATE = "created";
    	public static final String MODIFIED_DATE = "modified";
    }
}