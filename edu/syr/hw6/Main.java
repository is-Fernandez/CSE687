package edu.syr.hw6;
import java.util.*;

class Element {
    public String content;
    public boolean isItalic;
    public boolean isBold;
    public boolean isStrikethru;

    public Element(String text) {
        this.content = text;
        this.isItalic = false;
        this.isBold = false;
        this.isStrikethru = false;
    }

    public Element(String text, boolean isItalic, boolean isBold, boolean isStrikethru) {
        this.content = text;
        this.isItalic = isItalic;
        this.isBold = isBold;
        this.isStrikethru = isStrikethru;
    }

    public String toString() {
        return content;
    }

    public String toMarkdown() {
        String md = content;
        if (isItalic) md = "*" + md + "*";
        if (isBold) md = "**" + md + "**";
        if (isStrikethru) md = "~~" + md + "~~";
        return md;
    }
}

abstract class TextDecorator extends Element {
    protected Element element;

    public TextDecorator(Element element) {
        super(element.content, element.isItalic, element.isBold, element.isStrikethru);
        this.element = element;
    }
}

class Italic extends TextDecorator {
    public Italic(Element element) {
        super(element);
        this.isItalic = true;
    }
}

class Bold extends TextDecorator {
    public Bold(Element element) {
        super(element);
        this.isBold = true;
    }
}

class Strikethru extends TextDecorator {
    public Strikethru(Element element) {
        super(element);
        this.isStrikethru = true;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test order independence
        Element e1 = new Italic(new Strikethru(new Element("text")));
        Element e2 = new Strikethru(new Italic(new Element("text")));

        System.out.println("e1: " + e1.toMarkdown());
        System.out.println("e2: " + e2.toMarkdown());

        // Original pangram example
        Element[] pangram = new Element[9];

        pangram[0] = new Element("The");
        pangram[1] = new Italic(new Element("quick"));
        pangram[2] = new Bold(new Element("bold"));
        pangram[3] = new Element("fox");
        pangram[4] = new Element("jumps");
        pangram[5] = new Element("over");
        pangram[6] = new Element("the");
        pangram[7] = new Strikethru(new Element("lazy"));
        pangram[8] = new Element("dog");

        StringBuffer justText = new StringBuffer();
        StringBuffer markdown = new StringBuffer();

        for (Element e : pangram) {
            justText.append(e.toString()).append(" ");
            markdown.append(e.toMarkdown()).append(" ");
        }

        System.out.println(justText.toString().trim());
        System.out.println(markdown.toString().trim());
    }
}

