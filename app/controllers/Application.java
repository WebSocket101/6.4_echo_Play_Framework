package controllers;

import play.*;
import play.mvc.*;
import play.libs.F.Callback;
import play.libs.F.Callback0;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Ihre Applikation ist bereit."));
    }

	public static Result halloWelt() {
		String message = "Hallo Welt";
		return ok(halloWelt.render(message));
	}

	public static Result echo() {
		return ok(echo.render());
	}

	public static WebSocket<String> ws() {
	  	return new WebSocket<String>() {
	    	@Override
	    	public void  onReady(play.mvc.WebSocket.In<String> in, final play.mvc.WebSocket.Out<String> out) {
	        	System.out.println("Handeshake abgeschlossen");
	        	in.onMessage(new Callback<String>() {
	          		@Override
	          		public void invoke(String event) {
	            		out.write(event);
	          		}
	        	});
	      		in.onClose(new Callback0() {
	        		public void invoke() throws Throwable {
	         			System.out.println("WebSocket geschlossen");
	        		}
	      		});
	    	}
		};
	}

}
