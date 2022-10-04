package com.edvora.TestingAssessment.Utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.edvora.TestingAssessment.TestCases.BaseClass;



public class Reporting extends TestListenerAdapter {

	
	public void onStart(ITestContext testContext)
	{	
		System.out.println(testContext.getName()+" Test is Started...");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println(tr.getName()+" Test is passed...");
		
	}
	
	public void onTestFailure(ITestResult tr)
	{	
		System.out.println(tr.getName()+" Test is Failed...");
		BaseClass base=new BaseClass();
		try {
			base.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println(tr.getName()+" Test is Skipped...");
	}
	
	public void onFinish(ITestContext testContext) {
		System.out.println(testContext.getName()+" Test is finished...");
	}
}
