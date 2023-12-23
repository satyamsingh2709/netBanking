package com.netbanking.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

	public static void main(String[] args) {
		
		String s1 = "xyz";
		permutation(s1, "");
	}
	public static void permutation(String s1, String print) {
		
		if(s1.length()==0) {
			System.out.println(print);
			return;
		}
		
		for(int i=0;i<s1.length();i++) {
			System.out.println("I value and s1"+i+" "+s1+" "+print);
			char c = s1.charAt(i);
			String left = s1.substring(0,i);
			String right = s1.substring(i+1);
			String newString = left+right;
			permutation(newString,print+c);
		}
	}
}
