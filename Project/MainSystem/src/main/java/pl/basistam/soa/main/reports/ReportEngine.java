package pl.basistam.soa.main.reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pl.basistam.dataAccess.api.CarParkDao;
import pl.basistam.dataAccess.entities.Ticket;
import pl.basistam.soa.main.EjbBindings;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Stateless
public class ReportEngine {
    @EJB(mappedName = EjbBindings.CarParkDao_JNDI)
    private CarParkDao carParkDao;

    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public byte[] createTicketsRaport(int area, LocalDateTime beginning, LocalDateTime end) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = PdfWriter.getInstance(document, byteArrayOutputStream);

        try {
            document.open();
            document.add(new Paragraph(String.format("Raport dla strefy %d", area)));
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph(String.format("z okresu: %s - %s", beginning.format(DATE_FORMATTER), end.format(DATE_FORMATTER))));
            document.add(Chunk.NEWLINE);

            List<Ticket> tickets = carParkDao.getTicketsFromArea(area, beginning, end);
            PdfPTable table = new PdfPTable(3);
            PdfPCell parkingSpotHeader = new PdfPCell(new Paragraph("Numer miejsca"));
            PdfPCell purchaseDateHeader = new PdfPCell(new Paragraph("Zakup"));
            PdfPCell expirationDateHeader = new PdfPCell(new Paragraph("Wygasa"));
            table.addCell(parkingSpotHeader);
            table.addCell(purchaseDateHeader);
            table.addCell(expirationDateHeader);

            tickets.forEach(t ->
            {
                PdfPCell parkingSpotCell = new PdfPCell(new Paragraph(Integer.toString(t.getParkingSpot().getId())));
                table.addCell(parkingSpotCell);

                PdfPCell purchaseDateCell = new PdfPCell(new Paragraph(t.getTimeOfPurchase().format(DATE_FORMATTER)));
                table.addCell(purchaseDateCell);

                PdfPCell expirationDateCell = new PdfPCell(new Paragraph(t.getTimeOfExpiration().format(DATE_FORMATTER)));
                table.addCell(expirationDateCell);
            });

            document.add(table);
            document.add(Chunk.NEWLINE);
        } finally {
            document.close();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
