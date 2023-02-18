package com.spring.user.service;

import java.awt.Color;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.user.entities.AppUser;
import com.spring.user.entities.CoResponse;
import com.spring.user.entities.CoTrgEntity;
import com.spring.user.entities.EligibilityResponse;
import com.spring.user.repositories.AppUserRepo;
import com.spring.user.repositories.CoTrgRepository;
import com.spring.user.repositories.DcCaseRepository;
import com.spring.user.repositories.EligiRespRepository;

@Service
public class CoServiceImpl implements CoService {

	@Autowired
	private CoTrgRepository trgRepository;

	@Autowired
	private EligiRespRepository respRepository;

	@Autowired
	private AppUserRepo userRepo;

	@Autowired
	private DcCaseRepository dccaseRepo;
	
	long successCnt = 0;
	long failureCnt = 0;
	String appId = null;

	CoTrgEntity trgEntity = new CoTrgEntity();

	@Override
	public CoResponse sendNotices() {

		CoResponse response = new CoResponse();

		List<CoTrgEntity> list = trgRepository.findByTrgStatus("PENDING");

		for (CoTrgEntity trg : list) {
			try {
				processTrigger(trg);
				successCnt++;
			} catch (Exception e) {
				e.printStackTrace();
				failureCnt++;
			}
		}
		response.setTotalRecordsProcessed(Long.valueOf(list.size()));
		response.setApprovedCitizenCount(successCnt);
		response.setDeniedCitizenCount(failureCnt);

		return null;
	}

	private void processTrigger(CoTrgEntity trg) {
		Long caseNum = trg.getCaseNum();
		EligibilityResponse byCaseNum = respRepository.findByCaseNum(caseNum);
		Integer appId = dccaseRepo.findByAppId(caseNum);
		AppUser appUser = userRepo.findById(appId);

		byte[] file = null;

		if (trg.equals("Approved")) {
			file = buildApPdf();
		} else {
			file = buildDnPdf();
		}
		trgEntity.setTrgStatus("COMPLETED");

	}

	private byte[] buildDnPdf() {

		Document document = new Document(PageSize.A4);
		// PdfWriter.getInstance(document, response.getOutputStream());

		PdfWriter.getInstance(document, null);

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("ELIGIBILITY_RESPONSE", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(8);

		table.setWidthPercentage(100f);
		// table.setWidths(new float[] { 1.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });

		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		// set table header data

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.cyan);
		cell.setPadding(5);

		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ssn", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("holderName", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planName", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planStatus", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planStartDate", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planEndDate", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("benfitAmount", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("deniedReason", font1));
		table.addCell(cell);

		// set table data

		List<EligibilityResponse> record = respRepository.findAll();

		for (EligibilityResponse records : record) {
			table.addCell(String.valueOf(records.getHolderSsn()));
			table.addCell(records.getHolderName());
			table.addCell(records.getPlanName());
			table.addCell(records.getPlanStatus());
			table.addCell(String.valueOf(records.getPlanStartDate()));
			table.addCell(String.valueOf(records.getPlanEndDate()));
			table.addCell(String.valueOf(records.getBenfitAmount()));
			table.addCell(records.getDeniedReason());

		}

		document.add(table);

		document.close();
		String subject = "HIS eligibility info";
		String body = "HIS eligibility info";
		// emailUtils.sendemail
		// trgRepository.save(document);
		return null;
	}

	private byte[] buildApPdf() {
		Document document = new Document(PageSize.A4);
//		PdfWriter.getInstance(document, response.getOutputStream());

		PdfWriter.getInstance(document, null);

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("ELIGIBILITY_RESPONSE", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(8);

		table.setWidthPercentage(100f);
		// table.setWidths(new float[] { 1.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });

		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		// set table header data

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.cyan);
		cell.setPadding(5);

		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ssn", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("holderName", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planName", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planStatus", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planStartDate", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("planEndDate", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("benfitAmount", font1));
		table.addCell(cell);

		cell.setPhrase(new Phrase("deniedReason", font1));
		table.addCell(cell);

		// set table data

		List<EligibilityResponse> record = respRepository.findAll();

		for (EligibilityResponse records : record) {
			table.addCell(String.valueOf(records.getHolderSsn()));
			table.addCell(records.getHolderName());
			table.addCell(records.getPlanName());
			table.addCell(records.getPlanStatus());
			table.addCell(String.valueOf(records.getPlanStartDate()));
			table.addCell(String.valueOf(records.getPlanEndDate()));
			table.addCell(String.valueOf(records.getBenfitAmount()));
			table.addCell(records.getDeniedReason());

		}

		document.add(table);

		document.close();
		String subject = "HIS eligibility info";
		String body = "HIS eligibility info";
		// emailUtils.sendemail
		// trgRepository.save(document);

		return null;
	}
}