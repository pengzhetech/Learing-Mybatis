package com.javaman.mybatis.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

/**
 * @author pengzhe
 * @date 2018/4/26 22:13
 * @description
 */

public class XPathTest {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        //开启验证
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);
        //创建DocumentBuilder
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //设置异常处理对象
        builder.setErrorHandler(new ErrorHandler() {
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("warning:" + exception.getMessage());
            }

            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }

            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("fatalError:" + exception.getMessage());
            }
        });
        //将文档加载到一个Document对象中
        Document document = builder.parse("/Users/pengzhe/code/Project/Learing-Mybatis/src/main/java/com/javaman/mybatis/xpath/inventory.xml");

        //创建XPathFactory
        XPathFactory factory = XPathFactory.newInstance();

        //创建XPath对象
        XPath xPath = factory.newXPath();

        //编译XPath表达式
        XPathExpression expression = xPath.compile("//book[author='Alex']/title/text()");

        /**
         * 通过XPath表达式得到的结果,第一个参数指定了XPath表达式进行查询的上下文节点,也就是在指定//节点下查找符合XPath的节点
         * 本例中的上下文节点是整个文档,第二个参数指定了XPath表达式//的返回类型
         */
        Object result = expression.evaluate(document, XPathConstants.NODESET);

        System.out.println("查询作者为Alex的图书标题");

        NodeList nodeList = (NodeList) result;

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }


        System.out.println("查询1997年后的图书的标题");
        nodeList = (NodeList) xPath.evaluate("//book[@year>1997]/title/text()", document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }

        System.out.println("查询1997年后的图书的属性和标题");
        nodeList = (NodeList) xPath.evaluate("//book[@year>1997]/@*|//book[@year>1997]/title/text()", document, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }

    }
}
