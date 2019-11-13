package org.dharshanaw.utils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BarcodeGenerator {
    public static void main(String[] args) throws IOException, DocumentException {

        Document document = new Document(PageSize.A4, 50F, 50F, 50F, 50F);
        PdfWriter pdfwriter = PdfWriter.getInstance(document, new FileOutputStream("bars.pdf"));
        document.open();
        com.lowagie.text.pdf.PdfContentByte pdfcontentbyte = pdfwriter.getDirectContent();
        Barcode128 barcode128 = new Barcode128();
        barcode128.setCode("9780201615883");
        com.lowagie.text.Image image = barcode128.createImageWithBarcode(pdfcontentbyte, Color.blue, Color.black);

        BufferedImage bImage= new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        File outputfile = new File("saved.png");
        ImageIO.write(bImage, "jpg", new File("code39.jpg"));

//        BarcodeEAN codeEAN = new BarcodeEAN();
//        codeEAN.setCodeType(codeEAN.EAN13);
//        codeEAN.setCode("9780201615883");
//        Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
    }
}
