package com.personal.qpaper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
 
public class WriteImage {
    /** Path to the resulting PDF */
    public static final String RESULT
        = "movie_posters_1.pdf";
    /** Path to the resources. */
    public static final String RESOURCE = "resources/test_image.jpg";
 
    /**
     * Main method.
     *
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     * @throws SQLException
     */
    public static void main(String[] args)
        throws IOException, DocumentException, SQLException {
        new WriteImage().createPdf(RESULT);
    }
 
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException 
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException {
 
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        Rectangle rect = new Rectangle(0, 806, 36, 842);
        rect.setBackgroundColor(BaseColor.RED);
        document.add(rect);
        document.add(new Paragraph("Hello World!"));
        Image image = Image.getInstance(RESOURCE);
        image.scaleToFit(500, 500);
        // step 4
            document.add(image);
        // step 5
        document.close();
 
    }
}