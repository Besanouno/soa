package pl.basistam.web;

import pl.basistam.ejb.Converter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

@WebServlet("/converter")
public class ConverterServlet extends HttpServlet {

    private Converter converter;

    public ConverterServlet() throws NamingException {
        converter = lookupConverterEjb();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String conversion = request.getParameter("conversion");
        double temperature;
        double result = 0;
        String x = request.getParameter("temp");
        try {
            temperature = Double.parseDouble(request.getParameter("temp"));
        } catch(NumberFormatException e) {
            e.printStackTrace();
            print(response, "Błędna temperatura");
            return;
        }
        if ("c2f".equals(conversion)) {
            result = converter.cels2fahr(temperature);
        } else if ("f2c".equals(conversion)) {
            result = converter.fahr2cels(temperature);
        } else {
            print(response, "Podana metoda konwersji nie istnieje!");
            return;
        }
        print(response, "Wynik to: " + result);
    }

    void print(HttpServletResponse response, String message) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.print(message);
            out.flush();
        }
    }

    private Converter lookupConverterEjb() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(InitialContext.PROVIDER_URL, "remote://localhost:4447");
        final Context context = new InitialContext(jndiProperties);
        return (Converter) context.lookup("ejb:/converter-ejb/ConverterImpl!pl.basistam.ejb.Converter");
    }
}
