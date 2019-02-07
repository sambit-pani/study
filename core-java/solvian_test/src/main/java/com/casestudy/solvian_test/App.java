package com.casestudy.solvian_test;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Log log = LogFactory.getLog(App.class);
    public static void main( String[] args ) throws Exception
    {
    	int numberOfThread = 10;//Integer.parseInt(args[0]);
    	int numberOfCertificateUpdate =10;//https://drive.google.com/open?id=1b0BQrKEFWhMsvXZUuXRfnSVKCfBCyYD7 Integer.parseInt(args[1]);
    	ExecutorService service = Executors.newFixedThreadPool(numberOfThread);
    	for(int i=1;i<=numberOfCertificateUpdate;i++) {
    		Future<String> certificate = service.submit(new GenerateCertificateUpdate());
    		//if(certificate.isDone()) {
    			log.info(certificate.get());
    			//System.out.println(certificate.get());
    		//}
    	}
    	GenerateCertificateUpdate update = new GenerateCertificateUpdate();
    	System.out.println(update.call());
    	
    }
}
