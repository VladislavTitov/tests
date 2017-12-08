package ru.vladislav.titov.utils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileReader;
import java.io.StringReader;

public class XmlParser {

    private Document settings;
    private static XmlParser ourInstance;

    private XmlParser() {
        settings = convertStringToDocument("E:\\Programming\\testing\\autotests\\src\\test\\resources\\settings.xml");
    }

    public static XmlParser getInstance() {
        if (ourInstance == null) {
            ourInstance = new XmlParser();
        }
        return ourInstance;
    }

    public String getBaseUrl() {
        return settings.getElementsByTagName("url").item(0).getTextContent();
    }

    public String getLogin() {
        return settings.getElementsByTagName("login").item(0).getTextContent();
    }

    public String getPassword() {
        return settings.getElementsByTagName("password").item(0).getTextContent();
    }

    private Document convertStringToDocument(String pathToXml) {

        try(FileReader xmlReader = new FileReader(pathToXml)) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;

            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[1024];

            while (xmlReader.read(buffer) != -1){
                stringBuilder.append(buffer);
            }

            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(stringBuilder.toString().trim())));

            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
