package com.presentiagroup.PersonalityCoach;

public class Param 
{
	public 	static final String temp = "temp";
	public 	static final int NT = 1;
	public 	static final int NF = 2;
	public 	static final int SP = 3;
	public 	static final int SJ = 4;
	public 	static final int TempOverview = 5;
	
	public 	static final String scale = "scale";
	public 	static final int EI = 1;
	public 	static final int SN = 2;
	public 	static final int TF = 3;
	public 	static final int JP = 4;
	
	public 	static final String more = "more";
	public 	static final int presentia = 1;
	public 	static final int oka = 2;
	public 	static final int mbti = 3;
	public 	static final int contactus = 4;
	
	public 	static final String sixteen = "sixteen";
	public 	static final int ISTJ = 1;
	public 	static final int ISFJ = 2;
	public 	static final int INFJ = 3;
	public 	static final int INTJ = 4;
	public 	static final int ISTP = 5;
	public 	static final int ISFP = 6;
	public 	static final int INFP = 7;
	public 	static final int INTP = 8;
	public 	static final int ESTP = 9;
	public 	static final int ESFP = 10;
	public 	static final int ENFP = 11;
	public 	static final int ENTP = 12;
	public 	static final int ESTJ = 13;
	public 	static final int ESFJ = 14;
	public 	static final int ENFJ = 15;
	public 	static final int ENTJ = 16;
	public static String Convert(String str)
     {
     	String s = str;
     	final StringBuilder result = new StringBuilder(s.length());
     	String[] words = s.split("\\s");
     	for(int i=0,l=words.length;i<l;++i) 
     	{
     		if(i>0) result.append(" ");      
     		result.append(Character.toUpperCase(words[i].charAt(0)))
             .append(words[i].substring(1));
     	}
     	return result.toString();

     }
}
