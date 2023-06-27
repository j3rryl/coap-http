/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author DOwuor
 */
public class SimpleCoapServer {

    public static void main(String[] args) {
        
        CoapServer server = new CoapServer();
        
        CoapResource resource = new CoapResource("hello") {
            @Override
            public void handleGET(CoapExchange exchange) {
                String text = exchange.getRequestOptions().getUriQuery().get(0);
                System.out.println(getName() + "'called GET method.");
                exchange.respond("Hello " + text.substring(text.indexOf("=") + 1));
            }
            
            @Override
            public void handlePOST(CoapExchange exchange) {
                String text = exchange.getRequestText();
                System.out.println(getName() + "'called POST method.");
                exchange.respond("Hello " + text);
            }
        };
        
        server.add(resource);
        server.start();
    }
}
