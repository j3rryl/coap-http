/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;

/**
 *
 * @author DOwuor
 */
public class SimpleCoapClient {
    
        public static void main(String[] args) {
            
            CoapClient client = new CoapClient();
            CoapResponse response;
            String uri;
            uri = "coap://localhost:5683/hello?q=wow";
            
            client.setURI(uri);
            response = client.get();
            if (response != null) {
                
                System.out.println("advanced: " + Utils.prettyPrint(response));
            }
    }
    
}
