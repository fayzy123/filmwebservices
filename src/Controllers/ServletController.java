package Controllers;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.Configuration.ClassList;

public class ServletController {

	public static void main(String[] args) throws Exception {
		
		Server server = new Server(8005);
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("webapp");
		ctx.setContextPath("/vehicles");

		// Configure
		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jst1.*\\.jar$");
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
				"org.eclipse.jetty.annotations.AnnotationConfiguration");

		// Mappings
		ctx.addServlet("Servlets.ServletInsert", "/vehicleInsert");
		ctx.addServlet("Servlets.ServletUpdate", "/vehicleUpdate");
		ctx.addServlet("Servlets.ServletDelete", "/vehicleDelete");
		ctx.addServlet("Servlets.ServletSearch", "/vehicleSearch");
		ctx.addServlet("Servlets.ServletHomepage", "/homepage");
		ctx.addServlet("Servlets.ServletSignIn", "/signIn");
		ctx.addServlet("Servlets.ServletSignOut", "/signOut");
		ctx.addServlet("Servlets.ServletAPI", "/api");
		
		// Setting the handler and starting the server
		server.setHandler(ctx);
		server.start();
		server.join();
	}
}
