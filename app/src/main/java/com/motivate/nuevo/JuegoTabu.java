package com.motivate.nuevo;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by Guillermo on 30-06-2015.
 */
public class JuegoTabu extends Juego {


    public JuegoTabu() {
    }


    public int generar_aleatorio(NodeList nodeList) {
        return (int) (Math.random() * nodeList.getLength());
    }

    public String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
