package com.mulesoft.training;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.DynamicPort;
import org.junit.Rule;

public class HelloMavenTest extends FunctionalTestCase {

	@Rule
	public DynamicPort dynamicPort = new DynamicPort("http.port");
    @Test
    public void mavenFlowReturnsHelloMaven() throws Exception {
    	System.out.println("\n\nDynamic Port in Test case -1: " + dynamicPort.getNumber());
        runFlowAndExpect("mavenFlow", "Hello Maven");
    }
    @Test
    public void retrieveFlightsAddsAppropriateHeader() throws Exception {
    System.out.println("\n\nDynamic Port in Test case -2: " + dynamicPort.getNumber());
      MuleEvent event = runFlow("retrieveFlights");
      String contentType = event.getMessage().getOutboundProperty("Content-Type");
      assertEquals("application/json", contentType);
    }
    
    @Override
    protected String[] getConfigFiles() {
    	String files[]={"maven-project.xml","global.xml"};
        return files;
    }

}
