package de.wwu.acse.soap.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import de.wwu.acse.soap.soap_generated.AddRequest;
import de.wwu.acse.soap.soap_generated.AddResponse;

@Component
public class AdderSoapClient extends WebServiceGatewaySupport {
	private final String adderWebServiceUrl;
	
	@Autowired
	public AdderSoapClient(@Value("${adderws.url}") String url) {
		this.adderWebServiceUrl = url;
		// The following configurations are used by WebServiceTemplate to 
		// automatically (de-)marshall the SOAP messags.
		// Point marshaller to generated classes for (de-)marshalling of SOAP-messages 
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in pom.xml
		marshaller.setContextPath("de.wwu.acse.soap.soap_generated");
		this.setDefaultUri(adderWebServiceUrl);
		// Set marshaller for this client
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}
	
	public AddResponse addRequest(int i1, int i2) {
		AddRequest request = new AddRequest();
		request.setN1(i1);
		request.setN2(i2);
		AddResponse response = 
				(AddResponse) getWebServiceTemplate()
					.marshalSendAndReceive(request); // We use the default Uri
		return response;
	}
}
