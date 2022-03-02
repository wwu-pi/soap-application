package de.wwu.acse.soap;

import de.wwu.acse.soap.client.AdderSoapClient;
import de.wwu.acse.soap.soap_generated.AddResponse;
import de.wwu.acse.soap.soap_generated.MyNumber;
import de.wwu.acse.soap.soap_generated.MySum;

public class SoapApplication {

	public static void main(String[] args) {
		// We just initialize it manually for this quick demo. 
		// The AdderSoapClient is autowireable and should be used as such
		// For instance, the client can be used in a service class
		AdderSoapClient client = new AdderSoapClient("http://localhost:8080/ws");
		AddResponse result = client.addRequest(12, 38);
		MySum sum = result.getSum();
		MyNumber n1 = sum.getN1();
		MyNumber n2 = sum.getN2();
		int intSum = sum.getSum();
		System.out.println("{n1=" + n1.getVal() + ", n2=" + n2.getVal() + ", sum=" + intSum + "}");
	}

}
