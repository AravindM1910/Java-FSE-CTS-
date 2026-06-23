interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Word document opened");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF document opened");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Excel document opened");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument(String str);
}

class DocumentFactoryClass extends DocumentFactory {
    public Document createDocument(String str) {
        if (str.equalsIgnoreCase("WordDocument")) {
            return new WordDocument();
        } else if (str.equalsIgnoreCase("PdfDocument")) {
            return new PdfDocument();
        } else if (str.equalsIgnoreCase("ExcelDocument")) {
            return new ExcelDocument();
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DocumentFactoryClass obj = new DocumentFactoryClass();

        Document doc = obj.createDocument("WordDocument");

        if (doc != null) {
            doc.open();
        } else {
            System.out.println("Invalid document type");
        }
    }
}