import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlManager {

    public void createXml(String serverAddress, String port, String username, String password, String dbName) {
        Element serverElement = new Element("server");
        serverElement.setAttribute("esm", "meisam");


        Element config = new Element("server_config_1");
        config.addContent(new Element("ip").setText(serverAddress));
        config.addContent(new Element("port").setText(port));
        config.addContent(new Element("user").setText(username));
        config.addContent(new Element("pass").setText(password));
        config.addContent(new Element("database").setText(dbName));

        serverElement.addContent(config);

        Document document = new Document(serverElement);

        XMLOutputter outputter = new XMLOutputter();
        outputter.setFormat(Format.getPrettyFormat());
        try {
            outputter.output(document, new FileWriter("serverConfiguration.xml"));
        } catch (IOException e) {
            System.out.println("khata dar zakhireie file");
        }

        //  document.getRootElement().addContent(config);


    }


    public void read() {
        File xmlFile = new File("serverConfiguration.xml");

        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(xmlFile);
            Element rootElement = document.getRootElement();
//            Element server_config_1 = rootElement.getChild("server_config_1");
//            Element username = server_config_1.getChild("user");
//            System.out.println(username.getValue());
            List<Element> children = rootElement.getChildren();


            for (Element item : children)
            {
               // System.out.println(item.getName());
                for(Element c : item.getChildren())
                {
                   String result= c.getValue();
                   return result;
                }
            }

        } catch (JDOMException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
