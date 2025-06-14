package org.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuiteListener implements ISuiteListener {

    // يتم تنفيذ هذا الميثود عند بداية تشغيل الـ Suite
    @Override
    public void onStart(ISuite suite) {
        System.out.println("---------------------------------------✅ Suite Started: ----------------------------------- >> " + suite.getName());
    }

    // يتم تنفيذ هذا الميثود عند الانتهاء من تشغيل الـ Suite
    @Override
    public void onFinish(ISuite suite) {
        System.out.println("---------------------------------------- ✅ Suite Finished: -------------------------------- >> " + suite.getName());
    }
}
