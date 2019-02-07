package com.casestudy.solvian_test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;

public class GenerateCertificateUpdate implements Callable<String>{

	/*private static final ThreadLocal<ISINCheckDigitUtil> local = new ThreadLocal<ISINCheckDigitUtil>() {
		 @Override protected ISINCheckDigitUtil initialValue() {
             return new ISINCheckDigitUtil();
	}};*/
	private final ISINCheckDigitUtil local=new ISINCheckDigitUtil();
	
	@Override
	public String call() throws Exception {
		CertificateUpdate certificate = new CertificateUpdate();
		certificate.setAskPrice(getRandomFloat());
		certificate.setAskSize(new Random().nextInt(4001)+1000);
		certificate.setBidPrice(getRandomFloat());
		certificate.setBidSize(new Random().nextInt(9001)+1000);
		certificate.setIsin(local.getISIN());
		certificate.setDate(new Date());
		return certificate.toString();
	}
	
	private float getRandomFloat() {
		return (float) (100.00+ new Random().nextFloat()*(200.00-100.00));
	}
}


