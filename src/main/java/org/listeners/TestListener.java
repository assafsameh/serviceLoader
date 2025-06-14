package org.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("**************************** onTestStart *************************************") ;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("**************************** onTestSuccess *************************************") ;
	}
}