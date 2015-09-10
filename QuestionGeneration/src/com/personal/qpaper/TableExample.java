package com.personal.qpaper;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TableExample {
    public static final String RESOURCE = "resources/test_image.jpg";
    public static final String RESOURCE2 = "resources/test_image2.jpg";
    public static void main(String[] args) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("Table3.pdf"));
            document.setPageSize(PageSize.A4);
            // document.setMargins(5, 5, 5, 5);
            document.open();
            document.add(new Paragraph("Section 1 :                                                                    2 X 5",
                new Font(Font.FontFamily.HELVETICA  , 15, Font.BOLD)));
            document.add(new Paragraph("                                          ",
                new Font(Font.FontFamily.HELVETICA  , 15, Font.BOLD)));

            PdfPTable table = new PdfPTable(new float[]{3, 97}); 
            table.setWidthPercentage(100);
            table.getDefaultCell().setBorder(0);

            Image image = Image.getInstance(RESOURCE);
            image.scaleToFit(image.getWidth(), image.getHeight());
            Image image2 = Image.getInstance(RESOURCE2);

            table.addCell(new Paragraph("1."));
            table.addCell(image);


            table.addCell(new Paragraph("2."));
            table.addCell(image2);


            document.add(table);

            document.add(image);
            document.close();
        } catch(Exception e){

        }
    }
}